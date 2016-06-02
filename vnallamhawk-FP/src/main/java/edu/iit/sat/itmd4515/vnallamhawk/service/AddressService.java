/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.service;
import edu.iit.sat.itmd4515.vnallamhawk.domain.Address;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author VenkataRakesh
 */
@Stateless
public class AddressService extends AbstractService<Address> {

    private static final Logger LOG = Logger.getLogger(Address.class.getName());

    /**
     *Constructor
     */
    public AddressService() {
        super(Address.class);
    }

    /**
     *List of all addresses
     * @return
     */
    @Override
    public List<Address> findAll() {
        LOG.info("Inside AddressService.findAll() method");
        List<Address> list = getEntityManager().createNamedQuery("Address.findAll", Address.class).getResultList();
        LOG.info(list.toString());
        return list;
    }

}
