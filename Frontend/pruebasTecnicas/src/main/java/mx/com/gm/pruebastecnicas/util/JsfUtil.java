/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.pruebastecnicas.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author kerll
 */
public class JsfUtil {

    public static void addErrorMessage(final String title, final String msg) {
        final FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addSuccessMessage(final String title, final String msg) {
        final FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, title, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addInformationMessage(String summary, String details) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, details);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addWarningMessage(String summary, String details) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, details);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

}
