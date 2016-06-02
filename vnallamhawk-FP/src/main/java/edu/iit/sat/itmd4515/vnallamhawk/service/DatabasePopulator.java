/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.service;

import edu.iit.sat.itmd4515.vnallamhawk.domain.Address;
import edu.iit.sat.itmd4515.vnallamhawk.domain.Customer;
import edu.iit.sat.itmd4515.vnallamhawk.domain.Inventory;
import edu.iit.sat.itmd4515.vnallamhawk.domain.Product;
import edu.iit.sat.itmd4515.vnallamhawk.domain.Store;
import edu.iit.sat.itmd4515.vnallamhawk.domain.StoreManager;
import edu.iit.sat.itmd4515.vnallamhawk.security.Group;
import edu.iit.sat.itmd4515.vnallamhawk.security.User;
import java.util.GregorianCalendar;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Class for populating the database entries
 *
 * @author VenkataRakesh
 */
@Singleton
@Startup
public class DatabasePopulator {

    private static final Logger LOG = Logger.getLogger(DatabasePopulator.class.getName());
    @EJB
    private AddressService addressService;

    @EJB
    private StoreManagerService smService;

    @EJB
    private StoreService storeService;

    @EJB
    private ProductService productService;

    @EJB
    private InventoryService inventoryService;

    @EJB
    private CustomerService customerService;

    @EJB
    private UserService userService;

    @EJB
    private GroupService groupService;

    /**
     *
     */
    public DatabasePopulator() {
    }

    @PostConstruct
    private void seedDatabase() {
        LOG.info("INSIDE DATA GENERATION METHOD");
        Group managers = new Group("MANAGERS", "Inventory Manager Group");
        Group customers = new Group("CUSTOMERS", "Customer Group");
        Group adminGroup = new Group("ADMIN", "Administrative Group");

        User admin = new User("admin", "admin");

        //customers
        User rakesh = new User("rakesh", "rakesh");
        User jash = new User("jash", "jash");
        User scott = new User("scott", "scott");
        User jason = new User("jason", "jason");
        User luke = new User("luke", "luke");
        User brian = new User("brian", "brian");

        //Managers
        User bond = new User("bond", "bond");
        User vignesh = new User("vignesh", "vignesh");
        User kashyap = new User("kashyap", "kashyap");
        User naveen = new User("naveen", "naveen");
        User praveen = new User("praveen", "praveen");
        User pranesh = new User("pranesh", "pranesh");

        admin.addGroup(adminGroup);

        rakesh.addGroup(customers);
        jash.addGroup(customers);
        scott.addGroup(customers);
        jason.addGroup(customers);
        luke.addGroup(customers);
        brian.addGroup(customers);

        bond.addGroup(managers);
        vignesh.addGroup(managers);
        kashyap.addGroup(managers);
        naveen.addGroup(managers);
        praveen.addGroup(managers);
        pranesh.addGroup(managers);

        groupService.create(managers);
        groupService.create(customers);
        groupService.create(adminGroup);

        userService.create(admin);

        userService.create(rakesh);
        userService.create(jash);
        userService.create(scott);
        userService.create(jason);
        userService.create(luke);
        userService.create(brian);

        userService.create(bond);
        userService.create(vignesh);
        userService.create(kashyap);
        userService.create(naveen);
        userService.create(praveen);
        userService.create(pranesh);

        Address a1 = new Address(new GregorianCalendar(2012, 10, 01).getTime(), "2727 S Michigan Avenue");
        Address a2 = new Address(new GregorianCalendar(2015, 10, 04).getTime(), "500 E Lake Meadows");
        Address a3 = new Address(new GregorianCalendar(2014, 04, 03).getTime(), "452 W Prairie Shores");
        Address a4 = new Address(new GregorianCalendar(2016, 02, 02).getTime(), "571 N Western Avenue");
        Address a5 = new Address(new GregorianCalendar(2011, 04, 07).getTime(), "653 E Lake Drive");
        Address a6 = new Address(new GregorianCalendar(2014, 05, 05).getTime(), "452 N State Street");

        addressService.create(a1);
        addressService.create(a2);
        addressService.create(a3);
        addressService.create(a4);
        addressService.create(a5);
        addressService.create(a6);

        Store s1 = new Store("Chicago Rental", "2727 York Terrace", "Chicago", "3124782243", 60616);
        Store s2 = new Store("NewYork Rental", "2727 S Michigan", "New York", "3124782242", 60654);
        Store s3 = new Store("Los Angeles Rental", "2727 S Indiana Avenue", "Los Angeles", "3124782243", 60636);
        Store s4 = new Store("Nevada Rental", "2727 S Indiana Avenue", "Nevada", "3124782243", 60621);
        Store s5 = new Store("NewJersey Rental", "2727 S Indiana Avenue", "New Jersey", "3124782243", 60682);
        Store s6 = new Store("Washington Rental", "2727 S Indiana Avenue", "Washington", "3124782243", 60654);

        storeService.create(s1);
        storeService.create(s2);
        storeService.create(s3);
        storeService.create(s4);
        storeService.create(s5);
        storeService.create(s6);

        StoreManager sm1 = new StoreManager(bond, s1, a1, "Bond", "Muthukumar", "3124782243", "Chicago", "60616", new GregorianCalendar(1989, 10, 01).getTime());
        StoreManager sm2 = new StoreManager(vignesh, s1, a1, "Vignesh", "Rajadhurai", "3124782245", "Chicago", "60613", new GregorianCalendar(1989, 02, 01).getTime());
        StoreManager sm3 = new StoreManager(kashyap, s2, a2, "Kashyap", "Venkat", "3124782284", "New York", "60611", new GregorianCalendar(1990, 03, 11).getTime());
        StoreManager sm4 = new StoreManager(naveen, s3, a3, "Naveen", "Sreenivasan", "3124782292", "Los Angeles ", "60636", new GregorianCalendar(1990, 10, 01).getTime());
        StoreManager sm5 = new StoreManager(praveen, s4, a4, "Praveen", "Balasubramanian", "3124782286", "Nevada", "60636", new GregorianCalendar(1991, 10, 01).getTime());
        StoreManager sm6 = new StoreManager(pranesh, s5, a5, "Pranesh", "Sandeep", "3124782289", "New Jersey", "60623", new GregorianCalendar(1992, 10, 01).getTime());

        smService.create(sm1);
        smService.create(sm2);
        smService.create(sm3);
        smService.create(sm4);
        smService.create(sm5);
        smService.create(sm6);

        Customer c1 = new Customer(rakesh, "rakesh", "nallam", "chicago", "3124782243", "60616", new GregorianCalendar(1994, 7, 8).getTime());
        Customer c2 = new Customer(jash, "jash", "shah", "new york", "3124784444", "60626", new GregorianCalendar(1988, 7, 8).getTime());
        Customer c3 = new Customer(scott, "scott", "spyrison", "new jersey", "3124784421", "60626", new GregorianCalendar(1986, 7, 8).getTime());
        Customer c4 = new Customer(jason, "jason", "lambert", "nevada", "3124784401", "60626", new GregorianCalendar(1991, 7, 8).getTime());
        Customer c5 = new Customer(luke, "luke", "papademas", "los angeles", "3124784490", "60632", new GregorianCalendar(1989, 7, 8).getTime());
        Customer c6 = new Customer(brian, "brian", "bailey", "philadelphia", "3124784419", "60678", new GregorianCalendar(1994, 7, 8).getTime());

        customerService.create(c1);
        customerService.create(c2);
        customerService.create(c3);
        customerService.create(c4);
        customerService.create(c5);
        customerService.create(c6);

        Product p1 = new Product(200, "Refrigerator", "Electronic Item");
        Product p2 = new Product(150, "AC", "Electronic Item");
        Product p3 = new Product(175, "Washing Machine", "Electronic Item");
        Product p4 = new Product(180, "Sofa", "Furniture");
        Product p5 = new Product(190, "Fan", "Electronic Item");
        Product p6 = new Product(195, "Oven", "Electronic Item");

        productService.create(p1);
        productService.create(p2);
        productService.create(p3);
        productService.create(p4);
        productService.create(p5);
        productService.create(p6);

        Inventory i1 = new Inventory(p1, new GregorianCalendar(2012, 10, 01).getTime(), 89, "Chicago");
        Inventory i2 = new Inventory(p2, new GregorianCalendar(2013, 11, 02).getTime(), 23, "New Jersey");
        Inventory i3 = new Inventory(p3, new GregorianCalendar(2016, 25, 03).getTime(), 45, "New York");
        Inventory i4 = new Inventory(p4, new GregorianCalendar(2012, 10, 01).getTime(), 89, "Nevada");
        Inventory i5 = new Inventory(p5, new GregorianCalendar(2013, 11, 02).getTime(), 23, "Los Angeles");
        Inventory i6 = new Inventory(p6, new GregorianCalendar(2016, 25, 03).getTime(), 45, "Charlotte");

        inventoryService.create(i1);
        inventoryService.create(i2);
        inventoryService.create(i3);
        inventoryService.create(i4);
        inventoryService.create(i5);
        inventoryService.create(i6);

        c1.getProduct().add(p1);
        p1.getCustomer().add(c1);
        c1.getProduct().add(p2);
        p1.getCustomer().add(c2);
        c2.getProduct().add(p2);
        p2.getCustomer().add(c2);
        c3.getProduct().add(p3);
        p3.getCustomer().add(c3);
        c4.getProduct().add(p1);
        p4.getCustomer().add(c1);
        c5.getProduct().add(p1);
        p5.getCustomer().add(c1);
        c6.getProduct().add(p1);
        p6.getCustomer().add(c1);
    }

}
