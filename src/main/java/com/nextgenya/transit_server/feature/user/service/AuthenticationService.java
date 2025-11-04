package com.nextgenya.transit_server.feature.user.service;

import com.nextgenya.transit_server.feature.user.entity.User;
import com.nextgenya.transit_server.feature.user.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Boolean save(
            String email,
            String password,
            String firstName,
            String lastName
    ){
        if(getUserByEmail(email) == null){
            User user = new User(ObjectId.get(), email, password, firstName, lastName);
            return userRepository.save(user)!=null;
        } else return false;
    }
}
