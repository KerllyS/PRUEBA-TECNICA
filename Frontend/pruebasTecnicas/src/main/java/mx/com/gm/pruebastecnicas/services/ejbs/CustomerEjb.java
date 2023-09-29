/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.pruebastecnicas.services.ejbs;

import java.util.List;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import mx.com.gm.pruebastecnicas.models.Customer;
import mx.com.gm.pruebastecnicas.services.interfaces.CustomerService;
import mx.com.gm.pruebastecnicas.util.RespuestaWs;
import mx.com.gm.pruebastecnicas.util.Service;
import mx.com.gm.pruebastecnicas.util.SisVars;

/**
 *
 * @author kerll
 */
@Singleton(name = "customerEjb")
@ApplicationScoped
public class CustomerEjb implements CustomerService {

    @Inject
    private Service service;

    @Override
    public Customer create(Customer data) {
        return (Customer) service.methodPOST(data, SisVars.wsService + "customer/save", Customer.class);
    }

    @Override
    public Customer read(Long id) {
        return (Customer) service.methodPOST(SisVars.wsService + "customer/findById/" + id, Customer.class);
    }

    @Override
    public Customer update(Customer data) {
        return (Customer) service.methodPOST(data, SisVars.wsService + "customer/update", Customer.class);
    }

    @Override
    public RespuestaWs delete(Customer data) {
        return (RespuestaWs) service.methodPOST(data, SisVars.wsService + "customer/delete", RespuestaWs.class);
    }

    @Override
    public List<Customer> finAll() {
        return (List<Customer>) service.methodListPOST(SisVars.wsService + "customer/findAll", Customer[].class);
    }

}
