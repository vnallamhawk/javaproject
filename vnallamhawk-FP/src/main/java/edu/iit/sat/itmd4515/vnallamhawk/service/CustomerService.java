/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.service;
import edu.iit.sat.itmd4515.vnallamhawk.domain.Customer;
import edu.iit.sat.itmd4515.vnallamhawk.domain.Product;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author VenkataRakesh
 */
@Named
@Stateless
public class CustomerService extends AbstractService<Customer> {

    private static final Logger LOG = Logger.getLogger(Customer.class.getName());

    /**
     *Constructor
     */
    public CustomerService() {
        super(Customer.class);
    }

    /**
     * List of all Customers
     * @return
     */
    @Override
    public List<Customer> findAll() {
        LOG.info("Inside CustomerService.findAll() method");
        List<Customer> list = getEntityManager().createNamedQuery("Customer.findAll", Customer.class).getResultList();
        LOG.info(list.toString());
        return list;
    }

    /**
     * To find the Username
     * @param username
     * @return
     */
    public Customer findByUsername(String username) {
        return getEntityManager().createNamedQuery("Customer.findByUserName", Customer.class).setParameter("username", username).getSingleResult();
    }

    /**
     *
     * @param p
     * @param c
     */
    public void createProduct(Product p, Customer c) {
        c = getEntityManager().getReference(Customer.class, c.getId());

        p.getCustomer().add(c);
        c.getProduct().add(p);

        getEntityManager().persist(p);
        getEntityManager().persist(c);

    }
}
