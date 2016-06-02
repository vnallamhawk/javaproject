/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.vnallamhawk.mp3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * creation of address entity
 * @author VenkataRakesh creation of Entity and JPQL Queries
 */
@Entity
@Table(name = "AddressInfo")
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "select a from Address a"),
    @NamedQuery(name = "Address.findByAddress", query = "select a from Address a where a.address =:address"),
    @NamedQuery(name = "Address.findById", query = "select a from Address a where a.id = :id")
})
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date lastUpdated;

    private String address;

    /**
     *
     */
    public Address() {
    }

    /**
     * Constructor for Address Class
     *
     * @param lastUpdated
     * @param address
     */
    public Address(Date lastUpdated, String address) {
        this.lastUpdated = lastUpdated;
        this.address = address;
    }

    /**
     * Creating one to one mapping
     */
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<StoreManager> storeManager = new ArrayList<>();

    /**
     *
     * @return
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

    /**
     * creating a function for returning the store managers
     *
     * @return
     */
    public List<StoreManager> getStoreManager() {
        return storeManager;
    }

    /**
     * creating a function for setting the store managers
     *
     * @param storeManager
     */
    public void setStoreManager(List<StoreManager> storeManager) {
        this.storeManager = storeManager;
    }

    /**
     * creating of tostring method for the address class
     */
    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", lastUpdated=" + lastUpdated + ", address=" + address + ", storeManager=" + storeManager + '}';
    }

}
