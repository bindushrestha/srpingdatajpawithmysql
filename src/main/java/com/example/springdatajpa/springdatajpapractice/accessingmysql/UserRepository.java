package com.example.springdatajpa.springdatajpapractice.accessingmysql;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
