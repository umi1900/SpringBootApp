package org.umar.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.umar.learn.dao.CustomerEntity;
import org.umar.learn.exception.CustomerException;
import org.umar.learn.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController
{
    @Autowired
    CustomerService service;
 
    @GetMapping
    public ResponseEntity<List<CustomerEntity>> getAllCustomer() {
        List<CustomerEntity> list = service.getAllCustomer();
 
        return new ResponseEntity<List<CustomerEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable("id") Long id) throws Exception{
    	CustomerEntity entity = service.getCustomerById(id);
 
        return new ResponseEntity<CustomerEntity>(HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<CustomerEntity> createOrUpdateCustomer(CustomerEntity customer) throws Exception {
		CustomerEntity updated = service.createOrUpdateCustomer(customer);
        return new ResponseEntity<CustomerEntity>(updated, HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteCustomerById(@PathVariable("id") Long id) throws CustomerException {
        service.deleteCustomerById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}