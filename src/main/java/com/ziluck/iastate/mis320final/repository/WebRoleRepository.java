package com.ziluck.iastate.mis320final.repository;

import com.ziluck.iastate.mis320final.model.WebRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebRoleRepository extends JpaRepository<WebRole, Long> {
    WebRole findByName(String name);
}
