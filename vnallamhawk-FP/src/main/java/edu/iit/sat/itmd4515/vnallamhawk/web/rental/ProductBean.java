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
public class ProductBean extends AbstractJSFBean {

    private static final Logger LOG = Logger.getLogger(ProductBean.class.getName());

    @EJB
    private ProductService prodService;

    @EJB
    private CustomerService custService;

    @Inject
    LoginBean loginBean;

    /**
     *
     */
    public ProductBean() {

    }

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

    private List<Customer> customers;

    /**
     * Get the value of customers
     *
     * @return the value of customers
     */
    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     * Set the value of customers
     *
     * @param customers new value of customers
     */
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    private Customer customer;

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

    @PostConstruct
    private void postConstruct() {
        super.postContruct();
        product = new Product();
        customer = new Customer();
        refreshProducts();
    }

    /**
     * for updating products
     */
    public void refreshProducts() {
        products = custService.findByUsername(loginBean.getRemoteUser()).getProduct();
    }

    /**
     * For creating product
     * @return
     */
    public String productCreate() {

        try {
            LOG.info("Creating the following Product" + this.product.toString());
            custService.createProduct(product, custService.findByUsername(loginBean.getRemoteUser()));
            refreshProducts();
        } catch (Exception e) {
            facesContext.addMessage(null, new FacesMessage("Error in Insertion", "Error In Insertion"));
        }
        return loginBean.getPortalPathByRole("/welcome.xhtml");
    }

}
