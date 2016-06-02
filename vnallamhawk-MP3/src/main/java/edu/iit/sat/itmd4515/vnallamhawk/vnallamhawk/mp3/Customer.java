/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.vnallamhawk.mp3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * creation of Entity and JPQL Queries
 *
 * @author VenkataRakesh
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Customer.findByName", query = "select c from Customer c where c.firstName = :name"),
    @NamedQuery(name = "Customer.findAll", query = "select c from Customer c"),
    @NamedQuery(name = "Customer.findById", query = "select c from Customer c where c.id = :id")
})
public class Customer extends Person implements Serializable {

    public Customer() {

    }

    /**
     * creation Many to Many mappings
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ProductCustomer",
            joinColumns = @JoinColumn(name = "Customer"),
            inverseJoinColumns = @JoinColumn(name = "Product"))
    private List<Product> products = new ArrayList<>();

    /**
     * setting the list of products
     *
     * @param product
     */
    public void setProduct(List<Product> product) {
        this.products = product;
    }

    /**
     * returning the list of products
     *
     * @return
     */
    public List<Product> getProduct() {
        return products;
    }
}
