/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.pruebastecnicas.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URI;
import java.net.URISyntaxException;
//import java.net.http.HttpHeaders;
import org.springframework.http.HttpHeaders;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
//import javax.ws.rs.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author kerll
 */
@Singleton(name = "serviceEjb")
@ApplicationScoped
public class ServiceEjb implements Service {

    protected Gson gson;
    protected GsonBuilder builder;

    public ServiceEjb() {
        builder = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
                .registerTypeAdapter(Date.class, new JsonDateDeserializer()).disableHtmlEscaping();
        gson = builder.create();
    }

    @Override
    public Object methodPOST(Object data, String url, Class resultClass) {
        System.out.println("url: " + url);
        System.out.println("gson.toJson(data): " + gson.toJson(data));
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(0, new MappingJackson2HttpMessageConverter(mapperDate()));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            URI uri = new URI(url);
            return getObject(data, resultClass, restTemplate, headers, uri);
        } catch (HttpServerErrorException.InternalServerError ex) {
            System.out.println("Error " + ex.getMessage());
            return null;
        } catch (URISyntaxException | RestClientException e) {
            Logger.getLogger(ServiceEjb.class.getName()).log(Level.SEVERE, "{0}", e);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Object methodPOST(String url, Class resultClass) {
        System.out.println("url: " + url);
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(0, new MappingJackson2HttpMessageConverter(mapperDate()));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            URI uri = new URI(url);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<Object> response = restTemplate.exchange(uri, HttpMethod.POST, entity, resultClass);
            if (response != null) {
                return response.getBody();
            }
            return null;
        } catch (HttpServerErrorException.InternalServerError ex) {
            System.out.println("Error " + ex.getMessage());
            return null;
        } catch (URISyntaxException | RestClientException e) {
            Logger.getLogger(ServiceEjb.class.getName()).log(Level.SEVERE, "{0}", e);
        }
        return null;
    }

    @Override
    public List methodListPOST(String url, Class resultClass) {
        System.out.println("url: " + url);
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(0, new MappingJackson2HttpMessageConverter(mapperDate()));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            URI uri = new URI(url);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<Object[]> response = restTemplate.exchange(uri, HttpMethod.POST, entity, resultClass);
            if (response != null) {
                return Arrays.asList(response.getBody());
            } else {
                return null;
            }
        } catch (HttpServerErrorException.InternalServerError ex) {
            System.out.println("Error " + ex.getMessage());
            return null;
        } catch (URISyntaxException | RestClientException e) {
            Logger.getLogger(ServiceEjb.class.getName()).log(Level.SEVERE, "{0}", e);
        }
        return null;
    }

    private Object getObject(Object data, Class resultClass, RestTemplate restTemplate, HttpHeaders headers, URI uri) {
        try {
            HttpEntity<Object> entity = new HttpEntity<>(data, headers);
            ResponseEntity<Object> response = restTemplate.exchange(uri, HttpMethod.POST, entity, resultClass);
            if (response != null) {
                return response.getBody();
            }
        } catch (HttpServerErrorException.InternalServerError ex) {
            System.out.println("Error " + ex.getMessage());
            return null;
        }
        return null;
    }

    public ObjectMapper mapperDate() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }
}
