package com.spring.app.controller;

import com.spring.app.configuration.security.ApiUserRole;
import com.spring.app.configuration.security.TokenService;
import com.spring.app.model.dto.request.LoginApiUserRequest;
import com.spring.app.model.dto.request.RegisterApiUserRequest;
import com.spring.app.model.dto.response.LoginApiUserResponse;
import com.spring.app.model.entity.ApiUser;
import com.spring.app.repository.ApiUserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private ApiUserRepository apiUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginApiUserResponse> login(@Valid @RequestBody LoginApiUserRequest apiUserRequest){
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(
            apiUserRequest.login(),
            apiUserRequest.password()
        );

        Authentication authentication = authenticationManager.authenticate(userAndPass);
        ApiUser user = (ApiUser) authentication.getPrincipal();
        String token = tokenService.generateToken(user);

        return ResponseEntity.ok(new LoginApiUserResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody RegisterApiUserRequest apiUserRequest){
        ApiUser newUser = new ApiUser();
        newUser.setLogin(apiUserRequest.login());
        newUser.setPassword(this.passwordEncoder.encode(apiUserRequest.password()));
        newUser.setRole(ApiUserRole.USER);

        ApiUser createdUser = this.apiUserRepository.save(newUser);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }
}



