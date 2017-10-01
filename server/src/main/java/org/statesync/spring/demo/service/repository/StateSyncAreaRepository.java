package org.statesync.spring.demo.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.statesync.spring.demo.entity.StateSyncArea;

@Repository
public interface StateSyncAreaRepository extends MongoRepository<StateSyncArea, String> {
}
