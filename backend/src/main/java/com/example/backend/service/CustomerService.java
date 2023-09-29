package com.example.backend.service;

import com.example.backend.Utils.RespuestaWs;
import com.example.backend.entity.Customer;
import com.example.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepository customerRepository;

    public Customer save(Customer data) {
        return customerRepository.save(data);
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).get();
    }

    public RespuestaWs delete(Customer data) {
        try {
            customerRepository.delete(data);
            return new RespuestaWs(Boolean.TRUE, null, "Elimiado correctamente");
        } catch (Exception e) {
            return new RespuestaWs(Boolean.FALSE, null, "No se pudo eliminar");
        }
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
