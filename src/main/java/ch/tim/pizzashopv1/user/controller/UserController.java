package ch.tim.pizzashopv1.user.controller;

import ch.tim.pizzashopv1.common.dto.SearchPaginationResult;
import ch.tim.pizzashopv1.user.service.UserRegistrationService;
import ch.tim.pizzashopv1.user.to.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserRegistrationService userService;


    @Autowired
    public UserController(UserRegistrationService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public ResponseEntity<SearchPaginationResult<UserDTO>> getUsers() {
        log.debug("REST request for getUsers");
        return new ResponseEntity<>(this.userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{usercode}")
    public ResponseEntity<SearchPaginationResult<UserDTO>> getUserByCode(@PathVariable("usercode") String userCode) {
        log.debug("REST request for getUserByCode");
        return new ResponseEntity<>(this.userService.getUserByCode(userCode), HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserDTO userDTO) {
        log.debug("REST request for registerUser");
        return new ResponseEntity<>(this.userService.registerUser(userDTO), HttpStatus.CREATED);
    }
}
