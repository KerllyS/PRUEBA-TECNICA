/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.pruebastecnicas.managebeans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mx.com.gm.pruebastecnicas.models.Customer;
import mx.com.gm.pruebastecnicas.services.interfaces.CustomerService;
import mx.com.gm.pruebastecnicas.util.JsfUtil;
import mx.com.gm.pruebastecnicas.util.RespuestaWs;
import org.primefaces.PrimeFaces;

/**
 *
 * @author kerll
 */
@Named
@ViewScoped
public class CustomerMB implements Serializable {

    @Inject
    private CustomerService customerService;

    private List<Customer> customers;

    private Customer customer;

    private Boolean customerView;

    @PostConstruct
    public void initView() {
        try {
            consultar();
            customer = new Customer();
        } catch (Exception e) {
            System.out.println("-->>>" + e.getMessage());
        }
    }

    public void consultar() {
        customers = customerService.finAll();
        PrimeFaces.current().ajax().update("dtCustomer");
    }

    public void create() {
        System.out.println("EXAMPLE: ");
        customer = new Customer();
        PrimeFaces.current().executeScript("PF('dlgFormulario').show()");
        PrimeFaces.current().ajax().update("dlgFormulario");
        customerView = false;
    }

    public void read(Long id) {
        customer = customerService.read(id);
        PrimeFaces.current().executeScript("PF('dlgFormulario').show()");
        PrimeFaces.current().ajax().update("dlgFormulario");
        customerView = true;

    }

    public void update(Customer customer) {
        this.customer = customer;
        PrimeFaces.current().executeScript("PF('dlgFormulario').show()");
        PrimeFaces.current().ajax().update("dlgFormulario");
        customerView = false;
    }

    public void delete(Customer customer) {
        RespuestaWs rws = customerService.delete(customer);
        System.out.println("rws: " + rws);
        if (rws != null) {
            if (rws.getEstado()) {
                JsfUtil.addSuccessMessage("CORRECTO!!!", rws.getMensaje());
            } else {
                JsfUtil.addWarningMessage("Aviso!!", rws.getMensaje());
            }
        } else {
            JsfUtil.addErrorMessage("Error", "Error en la accion eliminar");
        }
        consultar();
    }

    public void save() {
        System.out.println("customer:" + customer);
        if (customer.getId() != null) {
            System.out.println("update<<<customer:" + customer);
            customerService.update(customer);
        } else {
            System.out.println("create<<customer:" + customer);
            customerService.create(customer);
        }
        cerrar();
        consultar();

    }

    public void cerrar() {
        customer = new Customer();
        PrimeFaces.current().executeScript("PF('dlgFormulario).hide()");
        PrimeFaces.current().ajax().update("dlgFormulario");
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Boolean getCustomerView() {
        return customerView;
    }

    public void setCustomerView(Boolean customerView) {
        this.customerView = customerView;
    }

}
