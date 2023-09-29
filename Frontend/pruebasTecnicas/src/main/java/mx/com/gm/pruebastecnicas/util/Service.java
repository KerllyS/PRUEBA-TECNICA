/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.gm.pruebastecnicas.util;

import java.net.URI;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kerll
 */
@Local
public interface Service {

    public Object methodPOST(Object data, String url, Class resultClass);

    public Object methodPOST(String url, Class resultClass);

    public List methodListPOST(String url, Class resultClass);

}
