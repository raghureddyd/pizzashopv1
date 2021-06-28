package ch.tim.pizzashopv1.common.security.controller;

import ch.tim.pizzashopv1.common.exception.ApplicationException;
import ch.tim.pizzashopv1.common.exception.MessageCode;
import ch.tim.pizzashopv1.common.security.model.JwtRequest;
import ch.tim.pizzashopv1.common.security.model.JwtResponse;
import ch.tim.pizzashopv1.common.security.service.UserService;
import ch.tim.pizzashopv1.common.security.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class LoginController {

    private final JwtUtility jwtUtility;

    private final AuthenticationManager authenticationManager;

    private final UserService userService;
    @Autowired
    public LoginController(JwtUtility jwtUtility, AuthenticationManager authenticationManager, UserService userService) {
        this.jwtUtility = jwtUtility;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/login")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest){
        //TODO: Bad coding remove it from here
        try {
            authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                jwtRequest.getUsername(),
                jwtRequest.getPassword()
              )
            );
        } catch (BadCredentialsException e) {
            throw new ApplicationException(MessageCode.INVALID_CREDENTIALS, MessageCode.INVALID_CREDENTIALS.getDescription());
        }

        final UserDetails userDetails
          = userService.loadUserByUsername(jwtRequest.getUsername());

        final String token =
          jwtUtility.generateToken(userDetails);

        return  new JwtResponse(token);
    }
}
