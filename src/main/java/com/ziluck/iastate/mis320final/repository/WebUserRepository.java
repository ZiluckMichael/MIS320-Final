package com.ziluck.iastate.mis320final.repository;

import com.ziluck.iastate.mis320final.model.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebUserRepository extends JpaRepository<WebUser, Long> {
    WebUser findByEmail(String email);

    List<WebUser> findByActiveTrue();
}
