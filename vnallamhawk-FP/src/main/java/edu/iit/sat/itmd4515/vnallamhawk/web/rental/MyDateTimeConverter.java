/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.web.rental;

import edu.iit.sat.itmd4515.vnallamhawk.domain.StoreManager;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 *
 * @author VenkataRakesh
 */
@Named
@FacesConverter(value = "myDateTimeConverter", forClass = StoreManager.class)
public class MyDateTimeConverter extends DateTimeConverter {

    /**
     *
     */
    public MyDateTimeConverter() {
        setPattern("MM/dd/yyyy");
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.length() != getPattern().length()) {
            throw new ConverterException("Invalid format");
        }

        return super.getAsObject(context, component, value);
    }
}
