/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.domain;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Mapper superclass from which Customer and Store Manager Inherit
 * @author VenkataRakesh
 */
@MappedSuperclass 
public class Person {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;

    private String phone;

    private String location;

    private String pincode;
    @Temporal(TemporalType.DATE)
    private Date dob;
    
    /**
     *
     */
    public Person(){
        
    }
    
    /**
     *
     * @param firstName
     * @param lastName
     * @param phone
     * @param location
     * @param pincode
     * @param dob
     */
    public Person(String firstName,String lastName,String phone,String location,String pincode,Date dob)
    {
        this.firstName=firstName;
        this.lastName= lastName;
        this.phone =phone;
        this.location = location;
        this.pincode = pincode;
        this.dob = dob;
    }

    /**
     * Get the value of dob
     *
     * @return the value of dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Set the value of dob
     *
     * @param dob new value of dob
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Get the value of pincode
     *
     * @return the value of pincode
     */
    public String getPincode() {
        return pincode;
    }

    /**
     * Set the value of pincode
     *
     * @param pincode new value of pincode
     */
    public void setPincode(String pincode) {
        this.pincode = pincode;
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

    /**
     * Get the value of phone
     *
     * @return the value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the value of phone
     *
     * @param phone new value of phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
     * Set the value of id creating a tostring method
     *
     * @return
     */
    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", location=" + location + ", pincode=" + pincode + ", dob=" + dob + '}';
    }

}
