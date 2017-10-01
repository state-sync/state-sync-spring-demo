package org.statesync.spring.demo.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.statesync.spring.demo.entity.UserProfile;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, String> {

	boolean existsByEmail(String email);

	UserProfile findByEmail(String email);
}
