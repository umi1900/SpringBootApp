package org.umar.learn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.umar.learn.dao.CustomerEntity;
import org.umar.learn.exception.CustomerException;
import org.umar.learn.repository.CustomerRepository;

@Service
public class CustomerService
{
	@Autowired
	CustomerRepository repository;
	     
	public List<CustomerEntity> getAllCustomer()
	{
		List<CustomerEntity> customerList = repository.findAll();
		if(customerList.size() > 0) 
		{
		
			return customerList;
	    } else
	    
	    {
	        return new ArrayList<CustomerEntity>();
	    }
	 }
	     
	 public CustomerEntity getCustomerById(Long id) throws CustomerException
	 {
	     Optional<CustomerEntity> customer= repository.findById(id);
	         
	     if(customer.isPresent()) 
	     {
	    	 return customer.get();
	     } else 
	     {
	            throw new CustomerException("No Customer found by given id");
	     }
	     
	     
	 }

      public CustomerEntity createOrUpdateCustomer(CustomerEntity entity) throws CustomerException
      {
    	  Optional<CustomerEntity> customer = repository.findById(entity.getId());
     
    	  if(customer.isPresent())
    	  {
    		  CustomerEntity newEntity = customer.get();
    		  newEntity.setEmail(entity.getEmail());
    		  newEntity.setFirstName(entity.getFirstName());
    		  newEntity.setLastName(entity.getLastName());

    		  newEntity = repository.save(newEntity);
         
    		  return newEntity;
    	  } else
    	  	{
    	  	   entity = repository.save(entity);
         
    	  	   return entity;
    	  	}
}
 
	  
	    public void deleteCustomerById(Long id) throws CustomerException
	    {
	        Optional<CustomerEntity> customer= repository.findById(id);
	         
	        if(customer.isPresent())
	        {
	            repository.deleteById(id);
	        }	
	        else 
	        {
	            throw new CustomerException("No Customer found");
	        }
	    }
}


