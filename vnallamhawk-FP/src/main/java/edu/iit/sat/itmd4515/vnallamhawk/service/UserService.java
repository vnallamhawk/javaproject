/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.service;

import edu.iit.sat.itmd4515.vnallamhawk.security.User;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author VenkataRakesh
 */
@Stateless
public class UserService extends AbstractService<User> {

    /**
     * Constructor
     */
    public UserService() {
        super(User.class);
    }

    /**
     * Finding the list of users
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
