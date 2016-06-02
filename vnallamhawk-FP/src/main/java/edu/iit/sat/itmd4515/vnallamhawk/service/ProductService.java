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
public class ProductService extends AbstractService<Product> {

    private static final Logger LOG = Logger.getLogger(Product.class.getName());

    /**
     * Constructor class
     */
    public ProductService() {
        super(Product.class);
    }

    /**
     * List of all products
     *
     * @return
     */
    @Override
    public List<Product> findAll() {
        LOG.info("Inside ProductService.findAll() method");
        List<Product> list = getEntityManager().createNamedQuery("Product.findAll", Product.class).getResultList();
        LOG.info(list.toString());
        return list;
    }

    /**
     *
     * @param prod
     * @param cust
     */
    public void delete(Product prod, Customer cust) {
        prod = getEntityManager().getReference(Product.class, prod.getId());
        cust = getEntityManager().getReference(Customer.class, cust.getId());
        prod.getCustomer().remove(cust);
        cust.getProduct().remove(prod);
        if (prod.getCustomer().isEmpty()) {
            getEntityManager().remove(prod);
        }

    }

}
