package com.mgmetehan.springBanking.repository;

import com.mgmetehan.springBanking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
