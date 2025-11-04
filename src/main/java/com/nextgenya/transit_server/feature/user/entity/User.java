package com.nextgenya.transit_server.feature.user.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record User(ObjectId id, String email, String hashedPassword, String firstName, String lastName) {}