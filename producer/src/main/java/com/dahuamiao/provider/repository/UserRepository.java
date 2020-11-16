package com.dahuamiao.provider.repository;

import com.dahuamiao.provider.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
