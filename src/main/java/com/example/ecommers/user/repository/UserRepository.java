package com.example.ecommers.user.repository;

import com.example.ecommers.user.dto.UserEmailIdDTO;
import com.example.ecommers.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    UserEmailIdDTO findByEmailId(String emailId);
}
