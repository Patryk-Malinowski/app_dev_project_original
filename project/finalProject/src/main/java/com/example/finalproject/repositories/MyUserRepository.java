package com.example.finalproject.repositories;

import com.example.finalproject.entities.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, String> {

}
