package com.school.data.repository;

import com.school.data.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login,Integer> {
    @Query("select username from Login")
    List<String>getAllUserNames();
    Login getByUsername(String username);
}
