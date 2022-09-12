package com.example.pmTrial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pmTrial.entities.UserEntity;

//Login is the name of the entity here Login and inside entity the primary key is id which is og Long data type so Long

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
