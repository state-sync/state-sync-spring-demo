package org.statesync.spring.demo.service.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.statesync.spring.demo.entity.Task;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {

	Page<Task> findBy(Pageable pageable);

	Page<Task> findBy(TextCriteria criteria, Pageable pageable);

	Page<Task> findBySummaryStartsWith(String summary, Pageable pageable);

}
