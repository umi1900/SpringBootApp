package org.umar.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.umar.learn.dao.CustomerEntity;

 
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> 
{

 
}

