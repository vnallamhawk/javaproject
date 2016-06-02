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
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author VenkataRakesh
 */

@Named
@RequestScoped
public class StoreCreationBean extends AbstractJSFBean {
    
    private static final Logger LOG = Logger.getLogger(StoreCreationBean.class.getName());
    
    @EJB
    private StoreService storeService;
    
    @EJB
    private StoreManagerService smService;
    
        private Store store;

    /**
     * Get the value of store
     *
     * @return the value of store
     */
    public Store getStore() {
        return store;
    }

    /**
     * Set the value of store
     *
     * @param store new value of store
     */
    public void setStore(Store store) {
        this.store = store;
    }

    
    
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
    @Inject LoginBean loginBean;
       

    /**
     *
     */
    
    public StoreCreationBean()
    {
        super();
    }
    
    /**
     *
     */
    @PostConstruct
    public void getManager()
    {
        try
        {
        super.postContruct();
        store = new Store();
        storeManager = new StoreManager();
        refreshStore();
        LOG.info("Inside StoreCreationBean.postConstruct() with " + store.toString());
        }
        catch(Exception ex)
        {
        facesContext.addMessage(null, new FacesMessage("The user is not assigned any Store", "Store Exception"));
        }
    }
    
    /**
     *
     */
    public void refreshStore()
    {
        try{
        storeManager= smService.findByUsername(loginBean.getRemoteUser());
        store = storeManager.getStore();
        }
        catch(Exception ex)
                {
                    facesContext.addMessage(null, new FacesMessage("The user is not assigned any ", "User Created"));
                }
         
    }
    
    /**
     * for updating Store Manager
     * @return
     */
    public String update()
    {
        LOG.info("Inside StoreBean update " + storeManager.toString());
        smService.update(storeManager);
        return loginBean.getPortalPathByRole("/welcome.xhtml");
    }
    
    /**
     * for creating StoreManager
     * @return
     */
    public String smCreate() {
   
        LOG.info("Creating " + this.storeManager.toString());
        
        smService.create(storeManager);
       
        return loginBean.getPortalPathByRole("/welcome.xhtml");
    }
    
    /**
     * For Crating Store
     * @return
     */
    public String storeCreate() {
        LOG.info("Creating Store" + this.store.toString());
        storeService.create(store);
        return loginBean.getPortalPathByRole("/welcome.xhtml");
    }
    
    /**
     * For deleting the store
     * @param s
     * @return
     */
    public String doDelete(Store s) {
        LOG.info("We are going to delete the store " + s.toString());
        storeService.delete(s);
        refreshStore();
        return loginBean.getPortalPathByRole("/welcome.xhtml");
    }
    

}
