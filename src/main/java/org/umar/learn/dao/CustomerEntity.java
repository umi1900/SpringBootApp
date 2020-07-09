package org.umar.learn.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="TBL_Customer")
@Data
public class CustomerEntity 
{
    
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="first_name", length = 0, nullable = false)
	private String firstName;
	    
	@Column(name="last_name", length = 0, nullable = false)
	private String lastName;
	    
	@Column(name="email", nullable=false, length=200)
	private String email;


	
		
}
	
