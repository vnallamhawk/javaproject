/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.mp2.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author VenkataRakesh
 */
public class Customer {

    private Long id;

    @NotNull
    @Size(max = 45)
    private String firstName;

    @NotNull(message = "Customer Last Name can not be null")
    @Size(max = 45)
    private String lastName;

    @Size(max = 50)
    private String email;

    @Size(max = 20)
    @NotNull(message = "Phone No can't be null")
    private String phone;

    @Size(max = 50)
    @NotNull(message = "Address can't be null")
    private String address;

    @Size(max = 10)
    @NotNull(message = "Postal Code can't be null")
    private String postal_code;

    private Integer storeId;
    private Integer addressId;
    private Integer city_id;

    /**
     * Get the value of city_id
     *
     * @return the value of city_id
     */
    public Integer getCity_id() {
        return city_id;
    }

    /**
     * Set the value of city_id
     *
     * @param city_id new value of city_id
     */
    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    /**
     * Get the value of postal_code
     *
     * @return the value of postal_code
     */
    public String getPostal_code() {
        return postal_code;
    }

    /**
     * Set the value of postal_code
     *
     * @param postal_code new value of postal_code
     */
    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
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
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @param address
     * @param postal_code
     */
    public Customer(String firstName, String lastName, String email, String phone, String address, String postal_code) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.postal_code = postal_code;
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @param address
     * @param postal_code
     * @param storeId
     * @param addressId
     * @param city_id
     */
    public Customer(String firstName, String lastName, String email, String phone, String address, String postal_code, Integer storeId, Integer addressId, Integer city_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.postal_code = postal_code;
        this.storeId = storeId;
        this.addressId = addressId;
        this.city_id = city_id;
    }

    /**
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @param address
     * @param postalCode
     */
    public Customer(Long id, String firstName, String lastName, String email, String phone, String address, String postalCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.postal_code = postalCode;
    }

    /**
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param email
     */
    public Customer(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the value of first name
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * get the value of LastName and return
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * set the value of LastName and return
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Set the value of email
     *
     * toString method to return all the customer stored values
     *
     * @return
     */
    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + '}';
    }

    /**
     * Get
     *
     * @return
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     *
     * @param storeId
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     *
     * @return
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * set the addressId
     *
     * @param addressId
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

}
