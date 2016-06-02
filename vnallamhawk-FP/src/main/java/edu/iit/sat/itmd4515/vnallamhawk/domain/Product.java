/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * creating a product entity
 * @author VenkataRakesh
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Product.findByName", query = "select p from Product p where p.name = :name"),
    @NamedQuery(name = "Product.findAll", query = "select p from Product p"),
    @NamedQuery(name = "Product.findByRange", query = "select p from Product p where p.price >?1"),
    @NamedQuery(name = "Product.findById", query = "select p from Product p where p.id = :id")
})
public class Product implements Serializable {

    /**
     *
     */
    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int price;

    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set the value of price
     *
     * @param price new value of price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public long getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(long id) {
        this.id = id;
    }

    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    private String description;

    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Constructor for product class
     *
     * @param price
     * @param name
     * @param description
     */
    public Product(int price, String name, String description) {
        this.price = price;
        this.name = name;
        this.description = description;
    }

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Inventory> inventories = new ArrayList<>();

    /**
     * Set the List of Inventories
     *
     * @param inv
     */
    public void setInventory(List<Inventory> inv) {
        this.inventories = inv;
    }

    /**
     *
     * @return
     */
    public List<Inventory> getInventory() {
        return inventories;
    }

    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<Customer> customers = new ArrayList<>();

    /**
     * returning the list of customers
     *
     * @return
     */
    public List<Customer> getCustomer() {
        return customers;
    }

    /**
     *
     * @param customers
     */
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    /**
     * toString method for product class
     */
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", price=" + price + ", name=" + name + ", description=" + description + '}';
    }

}
