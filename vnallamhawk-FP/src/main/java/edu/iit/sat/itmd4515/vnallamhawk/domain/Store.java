/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * creating an Entity with JPQL queries
 *
 * @author VenkataRakesh
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Store.findByName", query = "select s from Store s where s.name = :name"),
    @NamedQuery(name = "Store.findAll", query = "select s from Store s"),
    @NamedQuery(name = "Store.findById", query = "select s from Store s where s.id = :id"),
    @NamedQuery(name = "Store.findByManagerId", query = "select s from Store s where s.id = :id")})
public class Store implements Serializable {

    @Override
    public String toString() {
        return "Store{" + "id=" + id + ", name=" + name + ", address=" + address + ", Location=" + Location + ", phoneNumber=" + phoneNumber + ", pincode=" + pincode + '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String address;

    private String Location;

    private String phoneNumber;

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private StoreManager storemanager;

    /**
     *
     */
    public Store() {
    }

    /**
     * Get the value of storemanager
     *
     * @return the value of storemanager
     */
    public StoreManager getStoremanager() {
        return storemanager;
    }

    /**
     * Set the value of storemanager
     *
     * @param storemanager new value of storemanager
     */
    public void setStoremanager(StoreManager storemanager) {
        this.storemanager = storemanager;
    }

    /**
     *
     * @param name
     * @param address
     * @param Location
     * @param phoneNumber
     * @param pincode
     */
    public Store(String name, String address, String Location, String phoneNumber, int pincode) {
        this.name = name;
        this.address = address;
        this.Location = Location;
        this.phoneNumber = phoneNumber;
        this.pincode = pincode;
    }

    /**
     * Get the value of phoneNumber
     *
     * @return the value of phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the value of phoneNumber
     *
     * @param phoneNumber new value of phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private int pincode;

    /**
     * Get the value of pincode
     *
     * @return the value of pincode
     */
    public int getPincode() {
        return pincode;
    }

    /**
     * Set the value of pincode
     *
     * @param pincode new value of pincode
     */
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    /**
     * Get the value of Location
     *
     * @return the value of Location
     */
    public String getLocation() {
        return Location;
    }

    /**
     * Set the value of Location
     *
     * @param Location new value of Location
     */
    public void setLocation(String Location) {
        this.Location = Location;
    }

    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(String address) {
        this.address = address;
    }

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

}
