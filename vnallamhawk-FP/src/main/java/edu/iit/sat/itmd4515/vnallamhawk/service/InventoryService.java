/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.service;

import edu.iit.sat.itmd4515.vnallamhawk.domain.Inventory;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author VenkataRakesh
 */
@Stateless
@Named
public class InventoryService extends AbstractService<Inventory>{
    private static final Logger LOG = Logger.getLogger(InventoryService.class.getName());

    /**
     *
     */
    public InventoryService()
    {
        super(Inventory.class);
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Inventory> findAll(){
       LOG.info("Inside InventoryService.findAll() method");
        List<Inventory> list = getEntityManager().createNamedQuery("Inventory.findAll",Inventory.class).getResultList();
        LOG.info(list.toString());
        return list;
    }
    
    
}
