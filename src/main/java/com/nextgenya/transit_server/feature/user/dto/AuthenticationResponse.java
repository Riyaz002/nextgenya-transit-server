package com.nextgenya.transit_server.feature.user.dto;

public record AuthenticationResponse(String access_token, String refresh_token) {}