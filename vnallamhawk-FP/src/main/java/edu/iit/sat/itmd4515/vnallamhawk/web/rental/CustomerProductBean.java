/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.web.rental;

import edu.iit.sat.itmd4515.vnallamhawk.domain.Customer;
import edu.iit.sat.itmd4515.vnallamhawk.domain.Product;
import edu.iit.sat.itmd4515.vnallamhawk.service.CustomerService;
import edu.iit.sat.itmd4515.vnallamhawk.service.ProductService;
import edu.iit.sat.itmd4515.vnallamhawk.web.AbstractJSFBean;
import edu.iit.sat.itmd4515.vnallamhawk.web.LoginBean;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author VenkataRakesh
 */
@Named
@RequestScoped
public class CustomerProductBean extends AbstractJSFBean {

    private static final Logger LOG = Logger.getLogger(CustomerProductBean.class.getName());

    @EJB
    private ProductService prodService;

    @EJB
    private CustomerService custService;

    private Product product;

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

    // private Product product;
    // private List<Product> products;
    private List<Product> products;

    /**
     * Get the value of products
     *
     * @return the value of products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Set the value of products
     *
     * @param products new value of products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    private Customer customer;
    @Inject
    LoginBean loginBean;

    /**
     * Get the value of customer
     *
     * @return the value of customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Set the value of customer
     *
     * @param customer new value of customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     *
     */
    public CustomerProductBean() {

    }

    private void productList() {
        products = custService.findByUsername(loginBean.getRemoteUser()).getProduct();
    }

    private void customerData() {
        customer = custService.findByUsername(loginBean.getRemoteUser());
    }

    @PostConstruct
    private void postConstruct() {
        product = new Product();
        super.postContruct();
        productList();
        customerData();
    }

    /**
     *
     * @param prod
     * @return
     */
    public String doDelete(Product prod) {
        LOG.info("Deleted Product " + prod.toString());
        prodService.delete(prod, custService.findByUsername(loginBean.getRemoteUser()));
        facesContext.addMessage(null, new FacesMessage("Product Removed", "Product Removed"));

        productList();
        return loginBean.getPortalPathByRole("/welcome.xhtml");
    }

    /**
     * Update Function for Customer
     * @return
     */
    public String update() {
        try {
            LOG.log(Level.INFO, "Inside customerProductBean", customer.toString());
            custService.update(customer);
        } catch (Exception ex) {
            facesContext.addMessage(null, new FacesMessage(ex.getMessage(), "Error In Updation"));
        }
        return loginBean.getPortalPathByRole("/welcome.xhtml");
    }
}
