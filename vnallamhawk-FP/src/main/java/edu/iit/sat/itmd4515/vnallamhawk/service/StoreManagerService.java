/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.service;

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
public class StoreManagerService extends AbstractService<StoreManager> {
    private static final Logger LOG = Logger.getLogger(StoreManager.class.getName());

    /**
     * Constructor
     */
    public StoreManagerService()
    {
        super(StoreManager.class);
    }
    
    /**
     * List of all StoreManagers
     * @return
     */
    @Override
    public List<StoreManager> findAll(){
       LOG.info("Inside StoreService.findAll() method");
        List<StoreManager> list = getEntityManager().createNamedQuery("StoreManager.findAll",StoreManager.class).getResultList();
        LOG.info(list.toString());
        return list;
    }

    /**
     * Find the Storemanager matching the username
     * @param userName
     * @return
     */
    public StoreManager findByUsername(String userName) {
        return getEntityManager().createNamedQuery("StoreManager.findByUserName",StoreManager.class).setParameter("username", userName).getSingleResult();
    }
    
}
