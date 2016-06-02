/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.service;

import edu.iit.sat.itmd4515.vnallamhawk.security.Group;
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
public class GroupService extends AbstractService<Group> {

    private static final Logger LOG = Logger.getLogger(GroupService.class.getName());

    /**
     *
     */
    public GroupService() {
        super(Group.class);
    }

    /**
     * List of all groups excluding admin
     * @return
     */
    @Override
    public List<Group> findAll() {

        LOG.info("Inside GroupService.findAll() method");
        List<Group> list = getEntityManager().createNamedQuery("Group.findGroup", Group.class).getResultList();
        LOG.info(list.toString());
        return list;
    }

    /**
     * List of all groups excluding admin
     * @return
     */
    public List<Group> findGroup() {

        LOG.info("Inside findGroup method");
        List<Group> list = getEntityManager().createNamedQuery("Group.findGroup", Group.class).getResultList();
        LOG.info(list.toString());
        return list;
    }

}
