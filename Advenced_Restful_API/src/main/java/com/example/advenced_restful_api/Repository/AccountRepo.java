package com.example.advenced_restful_api.Repository;

import com.example.advenced_restful_api.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Integer> {
}
