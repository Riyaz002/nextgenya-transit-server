package com.nextgenya.transit_server.feature.user.dto;

public record RegistrationRequest(String email, String password, String firstName, String lastName) {}