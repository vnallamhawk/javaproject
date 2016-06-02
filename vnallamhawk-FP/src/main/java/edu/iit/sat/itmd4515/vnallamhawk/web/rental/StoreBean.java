/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.web.rental;

import edu.iit.sat.itmd4515.vnallamhawk.domain.Store;
import edu.iit.sat.itmd4515.vnallamhawk.domain.StoreManager;
import edu.iit.sat.itmd4515.vnallamhawk.service.StoreManagerService;
import edu.iit.sat.itmd4515.vnallamhawk.service.StoreService;
import edu.iit.sat.itmd4515.vnallamhawk.web.AbstractJSFBean;
import edu.iit.sat.itmd4515.vnallamhawk.web.LoginBean;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author VenkataRakesh
 */
@Named
@RequestScoped
public class StoreBean extends AbstractJSFBean {

    private static final Logger LOG = Logger.getLogger(StoreBean.class.getName());

    @EJB
    private StoreService storeService;

    @EJB
    private StoreManagerService smService;

    private StoreManager storeManager;

    /**
     * Get the value of storeManager
     *
     * @return the value of storeManager
     */
    public StoreManager getStoreManager() {
        return storeManager;
    }

    /**
     * Set the value of storeManager
     *
     * @param storeManager new value of storeManager
     */
    public void setStoreManager(StoreManager storeManager) {
        this.storeManager = storeManager;
    }

    private List<Store> stores;

    /**
     * Get the value of stores
     *
     * @return the value of stores
     */
    public List<Store> getStores() {
        return stores;
    }

    /**
     * Set the value of stores
     *
     * @param stores new value of stores
     */
    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    private StoreManager sm;
    @Inject
    LoginBean loginBean;

    //private void StoreList()
    //{
    //    stores =smService.findByUsername(loginBean.getRemoteUser());
    //}
    /**
     *
     */
    public StoreBean() {
        super();
    }

    /**
     *
     */
    @PostConstruct
    public void getManager() {

        super.postContruct();
        storeManager = smService.findByUsername(loginBean.getRemoteUser());
        LOG.info("Inside StoreBean.postConstruct() with " + storeManager.toString());
    }

    /**
     *  For Updating StoreManager
     * @return
     */
    public String update() {
        LOG.info("Inside StoreBean update " + storeManager.toString());
        smService.update(storeManager);
        return loginBean.getPortalPathByRole("/welcome.xhtml");
    }

    /**
     * For creating StoreManager
     * @return
     */
    public String smCreate() {

        LOG.info("Creating the following Store Manager " + this.storeManager.toString());
        smService.create(storeManager);
        return loginBean.getPortalPathByRole("/welcome.xhtml");
    }

}






