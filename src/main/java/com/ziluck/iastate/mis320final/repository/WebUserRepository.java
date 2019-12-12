package com.ziluck.iastate.mis320final.repository;

import com.ziluck.iastate.mis320final.model.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface WebUserRepository extends JpaRepository<WebUser, Long> {
    WebUser findByEmail(String email);

    boolean existsByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
