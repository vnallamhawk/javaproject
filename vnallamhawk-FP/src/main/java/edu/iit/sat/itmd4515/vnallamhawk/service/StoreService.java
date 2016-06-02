/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.service;

import edu.iit.sat.itmd4515.vnallamhawk.domain.Store;
import edu.iit.sat.itmd4515.vnallamhawk.domain.StoreManager;
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
public class StoreService extends AbstractService<Store> {

    private static final Logger LOG = Logger.getLogger(Store.class.getName());

    /**
     * Constructor
     */
    public StoreService() {
        super(Store.class);
    }

    /**
     * List of all Stores
     *
     * @return
     */
    @Override
    public List<Store> findAll() {
        LOG.info("Inside StoreService.findAll() method");
        List<Store> list = getEntityManager().createNamedQuery("Store.findAll", Store.class).getResultList();
        LOG.info(list.toString());
        return list;
    }

    /**
     * List of all Stores
     *
     * @param id
     * @return
     */
    public List<Store> findbyStoreId(long id) {
        LOG.info("Inside StoreService.findAll() method");
        List<Store> list = getEntityManager().createNamedQuery("Store.findAll", Store.class).getResultList();
        LOG.info(list.toString());
        return list;
    }

}
