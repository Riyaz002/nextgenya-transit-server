package com.nextgenya.transit_server.feature.user.repository;

import com.nextgenya.transit_server.feature.user.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends org.springframework.data.repository.Repository<User, Object> {
    User findByEmail(Object id);
    User save(User user);
}
