package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// Remove @RepositoryRestResource to disable auto REST API
@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {
}
