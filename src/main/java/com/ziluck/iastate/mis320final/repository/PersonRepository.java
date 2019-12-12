package com.ziluck.iastate.mis320final.repository;

import com.ziluck.iastate.mis320final.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonRepository<T extends Person> extends CrudRepository<T, Long> {
}
