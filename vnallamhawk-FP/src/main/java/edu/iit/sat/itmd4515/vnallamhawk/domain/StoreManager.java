/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.domain;
import edu.iit.sat.itmd4515.vnallamhawk.security.User;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * creation of entity for Storemanager and JPQL queries
 * @author VenkataRakesh
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "StoreManager.findByName", query = "select s from StoreManager s where s.firstName = :name"),
    @NamedQuery(name = "StoreManager.findByLastName", query = "select s from StoreManager s where s.lastName = :name"),
    @NamedQuery(name = "StoreManager.findAll", query = "select s from StoreManager s"),
    @NamedQuery(name = "StoreManager.findById", query = "select s from StoreManager s where s.id = :id"),
    @NamedQuery(name = "StoreManager.findByUserName", query = "select s from StoreManager s where s.user.userName = :username")
})
public class StoreManager extends Person implements Serializable {

    // @OneToOne
    // @JoinColumn(name="storeId")
    // private Store storeid;

    /**
     *
     */
   
    public StoreManager(){
        
    }
    
    
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;
    

    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(User user) {
        this.user = user;
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private Store store;

    /**
     *
     * @param user
     * @param store
     * @param address
     * @param firstName
     * @param lastName
     * @param phone
     * @param location
     * @param pincode
     * @param dob
     */
    public StoreManager(User user,Store store,Address address,String firstName,String lastName,String phone,String location,String pincode,Date dob)
     {
         super(firstName,lastName,phone,location,pincode,dob);
         this.user = user;
         this.store =store;
     }

    /**
     * Get the value of store
     *
     * @return the value of store
     */
    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public Address getAddress() {
        return address;
    }

    /**
     *
     * @return
     */
    public Store getStore() {
        return store;
    }

    /**
     * Set the value of store
     *
     * @param store new value of store
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}
