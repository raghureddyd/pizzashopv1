package ch.tim.pizzashopv1.config;

import ch.tim.pizzashopv1.common.security.filter.JwtFilter;
import ch.tim.pizzashopv1.common.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    private static final String[] AUTH_WHITELIST = {
      // -- Swagger UI v2
      "/v2/api-docs",
      "/swagger-resources",
      "/swagger-resources/**",
      "/configuration/ui",
      "/configuration/security",
      "/swagger-ui.html",
      "/webjars/**",
      // -- Swagger UI v3 (OpenAPI)
      "/v3/api-docs/**",
      "/swagger-ui/**",
      //app specific logs
      "/h2-console",
      "/api/v1/login",
      "/api/v1/pizzas/**",
      "/api/v1/trackings/**"
    };

    @Autowired
    private UserService userService;

    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userService);
        //auth.authenticationProvider(loginAuthenticationProvider);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /*@Bean
    protected BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }*/

    //TODO : Remove it and use BCryptPasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
          .disable()
          .authorizeRequests()
          .antMatchers(AUTH_WHITELIST).permitAll()
          .antMatchers(HttpMethod.POST,"/api/v1/users").permitAll()
          .antMatchers(HttpMethod.POST,"/api/v1/trackings").hasAnyAuthority("STAFF","ADMIN")
          .antMatchers(HttpMethod.GET,"/api/v1/users/**").hasAnyAuthority("STAFF","ADMIN")
          .anyRequest().authenticated()
          .and()
          .sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
           http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    }
}