package com.customer.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.ms.model.CustomerM;
import com.customer.ms.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<CustomerM> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public CustomerM findById(String cusId) {
		
		Optional<CustomerM> opt = customerRepository.findById(cusId);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null; 
	}

	@Override
	public CustomerM addCustomer(CustomerM customer) {
		
		return customerRepository.save(customer);
	}

	@Override
	public CustomerM updateCustomer(CustomerM customer) {
		CustomerM updatedCustomer = null;
		
		Optional<CustomerM> opt = customerRepository.findById(customer.getCusId());
		if(opt.isPresent()) {
			updatedCustomer = customerRepository.save(customer);
		}
		
		return updatedCustomer;
	}

	@Override
	public void deleteCustomer(String cusId) {
		customerRepository.deleteById(cusId);
	}
	
	
	
}
