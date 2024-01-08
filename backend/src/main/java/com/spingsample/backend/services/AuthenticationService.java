package com.spingsample.backend.services;

import com.spingsample.backend.dto.JwtAuthenticationResponse;
import com.spingsample.backend.dto.RefreshTokenRequest;
import com.spingsample.backend.dto.SignInRequest;
import com.spingsample.backend.dto.SignUpRequest;
import com.spingsample.backend.model.User;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signIn(SignInRequest signInRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
