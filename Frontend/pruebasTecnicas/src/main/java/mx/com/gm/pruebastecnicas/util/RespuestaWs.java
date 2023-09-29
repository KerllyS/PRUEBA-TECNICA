/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.pruebastecnicas.util;

import java.io.Serializable;

/**
 *
 * @author kerll
 */
public class RespuestaWs implements Serializable {

    private Long id;
    private Boolean estado;
    private String data;
    private String mensaje;

    public RespuestaWs() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "RespuestaWs{" + "id=" + id + ", estado=" + estado + ", data=" + data + ", mensaje=" + mensaje + '}';
    }

}
