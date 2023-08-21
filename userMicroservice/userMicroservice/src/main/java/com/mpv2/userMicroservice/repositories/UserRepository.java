package com.mpv2.userMicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpv2.userMicroservice.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
