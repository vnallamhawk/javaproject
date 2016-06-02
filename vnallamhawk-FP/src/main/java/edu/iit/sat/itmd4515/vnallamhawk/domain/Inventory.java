/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.domain;

/**
 *
 * @author VenkataRakesh
 */
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Creating Entity for Inventory
 * @author VenkataRakesh
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Inventory.findAll", query = "select i from Inventory i"),
    @NamedQuery(name = "Inventory.findByLocation", query = "select i from Inventory i where i.location =:location"),
    @NamedQuery(name = "Inventory.findById", query = "select i from Inventory i where i.id = :id")
})
public class Inventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date lastUpdated;

    private int totalItems;

    /**
     *
     */
    public Inventory() {
    }

    /**
     *
     * @param lastUpdated
     * @param totalItems
     * @param location
     */
    public Inventory(Date lastUpdated, int totalItems, String location) {
        this.lastUpdated = lastUpdated;
        this.totalItems = totalItems;
        this.location = location;
    }
    
    /**
     *
     * @param product
     * @param lastUpdated
     * @param totalItems
     * @param location
     */
    public Inventory(Product product,Date lastUpdated, int totalItems, String location) {
        this.product = product;
        this.lastUpdated = lastUpdated;
        this.totalItems = totalItems;
        this.location = location;
    }

    /**
     * Get the value of lastUpdated
     *
     * @return the value of lastUpdated
     */
    public Date getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Set the value of lastUpdated
     *
     * @param lastUpdated new value of lastUpdated
     */
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    private String location;

    /**
     * Get the value of totalItems
     *
     * @return the value of totalItems
     */
    public int getTotalItems() {
        return totalItems;
    }

    /**
     * Set the value of totalItems
     *
     * @param totalItems new value of totalItems
     */
    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    /**
     * Get the value of location
     *
     * @return the value of location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Set the value of location
     *
     * @param location new value of location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    @ManyToOne
    private Product product;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public long getId() {
        return id;
    }

    /**
     * Get the value of product
     *
     * @return the value of product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Set the value of product
     *
     * @param product new value of product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Inventory{" + "id=" + id + ", lastUpdated=" + lastUpdated + ", totalItems=" + totalItems + ", location=" + location + ", product=" + product + '}';
    }

}
