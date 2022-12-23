package com.testprojects.NSCTest.dao;

import com.testprojects.NSCTest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий сущности Пользователь
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
