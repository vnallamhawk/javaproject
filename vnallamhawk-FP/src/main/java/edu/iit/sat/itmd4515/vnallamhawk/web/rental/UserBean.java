/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.web.rental;

import edu.iit.sat.itmd4515.vnallamhawk.security.Group;
import edu.iit.sat.itmd4515.vnallamhawk.security.User;
import edu.iit.sat.itmd4515.vnallamhawk.service.GroupService;
import edu.iit.sat.itmd4515.vnallamhawk.service.UserService;
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
public class UserBean extends AbstractJSFBean {

    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @EJB
    private UserService userService;

    @EJB
    private GroupService groupService;

    @Inject
    LoginBean loginBean;

    private String username;

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    private String confirmPassword;

    /**
     * Get the value of confirmPassword
     *
     * @return the value of confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * Set the value of confirmPassword
     *
     * @param confirmPassword new value of confirmPassword
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    private User user;

    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(User user) {
        this.user = user;
    }

    private List<Group> groups;

    /**
     * Get the value of groups
     *
     * @return the value of groups
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * Set the value of groups
     *
     * @param groups new value of groups
     */
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @PostConstruct
    private void postConstruct() {
        super.postContruct();
        user = new User();
        group = new Group();
        refreshGroups();
        //customer = new Customer();
        //customers = custService.findAll();
        //refreshProducts();
    }

    /**
     *
     */
    public void refreshGroups() {
        this.groups = groupService.findAll();
    }

    private Group group;

    /**
     * Get the value of group
     *
     * @return the value of group
     */
    public Group getGroup() {
        return group;
    }

    /**
     * Set the value of group
     *
     * @param group new value of group
     */
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * For creating user
     * @return
     */
    public String createUser() {
        try {
            if (password.equals(confirmPassword)) {
                User u = new User(username, password);
                u.addGroup(group);
                userService.create(u);
                LOG.info("Creating User " + this.user.toString());
                facesContext.addMessage(null, new FacesMessage("User Created", "User Created"));

                LOG.info("username user object" + user.getUserName());
                LOG.info("username user psswor" + user.getPassword());
                LOG.info("username user confirm password" + confirmPassword);
            } else {
                facesContext.addMessage(null, new FacesMessage("Passwords do not match", "Passwords do not match"));
            }

            LOG.info("username user object" + user.getUserName());
            LOG.info("username user psswor" + user.getPassword());
            LOG.info("username user confirm password" + confirmPassword);

        } catch (Exception ex) {
            facesContext.addMessage(null, new FacesMessage(ex.getMessage() + "Username Already Exists", "Error In Insertion"));
        }
        return loginBean.getPortalPathByRole("/login.xhtml");
    }

}
