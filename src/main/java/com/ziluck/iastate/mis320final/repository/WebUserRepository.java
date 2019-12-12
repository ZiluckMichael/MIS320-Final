package com.ziluck.iastate.mis320final.repository;

import com.ziluck.iastate.mis320final.model.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WebUserRepository extends JpaRepository<WebUser, Long> {
    WebUser findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("SELECT COALESCE(MAX(id), 1) FROM WebUser")
    int getMaxId();
}
