package com.nextgenya.transit_server.feature.user.controller;

import com.nextgenya.transit_server.feature.user.dto.AuthenticationResponse;
import com.nextgenya.transit_server.feature.user.dto.LoginRequest;
import com.nextgenya.transit_server.feature.user.dto.RegistrationRequest;
import com.nextgenya.transit_server.feature.user.entity.User;
import com.nextgenya.transit_server.feature.user.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    AuthenticationService authenticationService;

    AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody LoginRequest loginRequest,
            Errors errors
    ) {
        // Handle validation errors early
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        // Fetch user
        User user = authenticationService.getUserByEmail(loginRequest.email());
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        // TODO: Verify password here before generating tokens

        AuthenticationResponse response = new AuthenticationResponse(
                "access-token-example",
                "refresh-token-example"
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody RegistrationRequest registrationRequest,
            Errors errors
    ) {
        // Handle validation errors early
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        boolean userAlreadyExists = authenticationService.getUserByEmail(registrationRequest.email())!=null;

        if(userAlreadyExists) {
            // 409 Conflict = resource already exists
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("User with this email already exists");
        }

        // Fetch user
        Boolean isCreated = authenticationService.save(
                registrationRequest.email(),
                registrationRequest.password(),
                registrationRequest.firstName(),
                registrationRequest.lastName()
        );

        if (!isCreated) {
            // internal error or database failure
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("User could not be created. Try again later.");
        } else{
            AuthenticationResponse response = new AuthenticationResponse(
                    "access-token-example",
                    "refresh-token-example"
            );

            return ResponseEntity.ok(response);
        }
    }
}


