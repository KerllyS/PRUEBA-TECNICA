/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.gm.pruebastecnicas.services.interfaces;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.pruebastecnicas.models.Customer;
import mx.com.gm.pruebastecnicas.util.RespuestaWs;

/**
 *
 * @author usuario
 */
@Local
public interface CustomerService {

    public Customer create(Customer data);

    public Customer read(Long id);

    public Customer update(Customer data);

    public RespuestaWs delete(Customer data);

    public List<Customer> finAll();

}
