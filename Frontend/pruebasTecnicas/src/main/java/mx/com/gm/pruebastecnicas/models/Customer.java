/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.pruebastecnicas.models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author kerll
 */
public class Customer implements Serializable {

    private Long id;

    private String identificacion;

    private String nombreCompleto;

    private Date fechaNacimiento;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", identificacion=" + identificacion + ", nombreCompleto=" + nombreCompleto + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

}
