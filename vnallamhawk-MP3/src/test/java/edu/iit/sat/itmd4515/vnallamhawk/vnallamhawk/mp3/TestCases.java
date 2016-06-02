/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.vnallamhawk.mp3;

import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * TestCases class
 *
 * @author VenkataRakesh
 */
public class TestCases {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    /**
     *connecting to the created persistence before each class.
     */
    @BeforeClass
    public static void beforeEachClass() {
        emf = Persistence.createEntityManagerFactory("vnallamhawkPU");
    }

    /**
     * function which gets executed before each test method
     */
    @Before
    public void beforeEachTestMethod() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    /**
     * Inserting data through sampleData function
     */
    @Test
    public void sampleData() {
        tx.begin();
        Store s1 = new Store("Scott Rental", "2727 York Terrace", "Chicago", "3124782243", 60616);
        Store s2 = new Store("Rakesh Rental", "2727 S Michigan", "New York", "3124782242", 60654);
        Store s3 = new Store("Srp Rental", "2727 S Indiana Avenue", "Los Angeles", "3124782243", 60636);

        Address a1 = new Address(new GregorianCalendar(2012, 10, 01).getTime(), "2727 S Michigan Avenue");
        Address a2 = new Address(new GregorianCalendar(2015, 10, 04).getTime(), "500 E Lake Meadows");
        Address a3 = new Address(new GregorianCalendar(2014, 04, 03).getTime(), "452 W Prairie Shores");

        Customer c1 = new Customer();
        Customer c2 = new Customer();
        Customer c3 = new Customer();
        c1.setFirstName("Rakesh");
        c1.setDob(new GregorianCalendar(1989, 11, 11).getTime());
        c1.setLastName("Nallam");
        c1.setPhone("0909090900");
        c1.setPincode("578983");

        c2.setFirstName("Prithvi");
        c2.setDob(new GregorianCalendar(1980, 01, 01).getTime());
        c2.setLastName("Raj");
        c2.setPhone("2005534000");
        c2.setPincode("623426");

        c3.setFirstName("Rohan");
        c3.setDob(new GregorianCalendar(1980, 01, 01).getTime());
        c3.setLastName("Gavaskar");
        c3.setPhone("9001552310");
        c3.setPincode("564978");

        StoreManager sm1 = new StoreManager();
        StoreManager sm2 = new StoreManager();
        sm1.setFirstName("Scott");
        sm1.setDob(new GregorianCalendar(2011, 11, 11).getTime());
        sm1.setLocation("Chicago");
        sm1.setLastName("Klapman");
        sm1.setPhone("3124782243");
        sm1.setPincode("60616");

        sm2.setFirstName("Scott");
        sm2.setDob(new GregorianCalendar(2011, 11, 01).getTime());
        sm2.setLastName("Sprison");
        sm2.setLocation("New Jersey");
        sm2.setPhone("3125532243");
        sm2.setPincode("623426");

        a1.getStoreManager().add(sm1);
        sm1.setAddress(a1);
        a2.getStoreManager().add(sm2);
        sm2.setAddress(a2);

        sm1.setStore(s1);
        sm2.setStore(s2);

        Product p1 = new Product(200, "Refrigerator", "Electronic Item");
        Product p2 = new Product(150, "AC", "Electronic Item");
        Product p3 = new Product(175, "Washing Machine", "Electronic Item");
        Product p4 = new Product(175, "Sofa", "Furniture");

        Inventory i1 = new Inventory(new GregorianCalendar(2012, 10, 01).getTime(), 89, "Chicago");
        Inventory i2 = new Inventory(new GregorianCalendar(2013, 11, 02).getTime(), 23, "New Jersey");
        Inventory i3 = new Inventory(new GregorianCalendar(2016, 25, 03).getTime(), 23, "New York");

        c1.getProduct().add(p1);
        p1.getCustomer().add(c1);
        c1.getProduct().add(p2);
        p1.getCustomer().add(c2);
        c2.getProduct().add(p2);
        p2.getCustomer().add(c2);
        c3.getProduct().add(p3);
        p3.getCustomer().add(c3);

        p1.getInventory().add(i1);
        i1.setProduct(p1);
        p2.getInventory().add(i2);
        i2.setProduct(p2);
        p3.getInventory().add(i3);
        i3.setProduct(p3);

        em.persist(s1);
        em.persist(s2);
        em.persist(s3);
        em.persist(a1);
        em.persist(a2);
        em.persist(a3);
        em.persist(sm1);
        em.persist(sm2);
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        em.persist(i1);
        em.persist(i2);
        em.persist(i3);
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        tx.commit();
        assertNotNull("StoreId should not be null", s1.getId());
        assertNotNull("AddressId should not be null", a1.getId());
        assertNotNull("StoreManager should not be null", sm1.getId());
        assertNotNull("Customer Id cannot be null", c1.getId());
        assertNotNull("Product Id cannot be null", p1.getId());
        assertNotNull("Inventory Id cannot be null", i1.getId());
    }

    /**
     * Sample data for read test cases
     */
    public void samplereadData() {
        tx.begin();
        Store s1 = new Store("Leonardo Rental", "2000 York Terrace", "Los Angeles", "3124782243", 60616);

        Address a1 = new Address(new GregorianCalendar(2012, 10, 01).getTime(), "2727 S Michigan Avenue");

        Customer c1 = new Customer();

        c1.setFirstName("Ryan");
        c1.setDob(new GregorianCalendar(1989, 11, 11).getTime());
        c1.setLastName("Harris");
        c1.setPhone("3457892341");
        c1.setPincode("984562");

        StoreManager sm1 = new StoreManager();
        sm1.setFirstName("Jeremy");
        sm1.setDob(new GregorianCalendar(2011, 11, 11).getTime());
        sm1.setLastName("Hajek");
        sm1.setPhone("5392235467");
        sm1.setPincode("563453");

        //setting address
        a1.getStoreManager().add(sm1);
        sm1.setAddress(a1);

        //setting store
        sm1.setStore(s1);

        Product p1 = new Product(100, "Grinder", "Mechanical Item");

        Inventory i1 = new Inventory(new GregorianCalendar(2012, 10, 01).getTime(), 89, "California");

        c1.getProduct().add(p1);
        p1.getCustomer().add(c1);

        p1.getInventory().add(i1);
        i1.setProduct(p1);

        em.persist(s1);

        em.persist(a1);

        em.persist(sm1);

        em.persist(p1);

        em.persist(i1);

        em.persist(c1);

        tx.commit();

    }

    /**
     * Read Operation test cases
     */
    @Test
    public void readData() {
        samplereadData();

        List<Store> slist = em.createNamedQuery("Store.findAll", Store.class).getResultList();
        assertFalse(slist.isEmpty());
        slist.stream().forEach((sl) -> {
            System.out.println("List Of Stores" + "\n" + sl.toString());
        }); //assertNotNull("StoreId should not be null", s.getId());

        List<StoreManager> smlist = em.createNamedQuery("StoreManager.findAll", StoreManager.class).getResultList();
        assertFalse(smlist.isEmpty());
        smlist.stream().forEach((sl) -> {
            System.out.println("List Of Store Manager" + "\n" + sl.toString());
        });

        List<Product> plist = em.createNamedQuery("Product.findAll", Product.class).getResultList();
        assertFalse(plist.isEmpty());
        plist.stream().forEach((p1) -> {
            System.out.println("List Of Products" + "\n" + p1.toString());
        });

        //List<Product> products = em.createNamedQuery("select p.NAME from product p where p.price in (select max(price) from product p)",Product.class).getResultList();        
        List<Inventory> ilist = em.createNamedQuery("Inventory.findAll", Inventory.class).getResultList();
        assertFalse(ilist.isEmpty());
        ilist.stream().forEach((i1) -> {
            System.out.println("List Of Inventories" + "\n" + i1.toString());
        });

        List<Customer> cust = em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
        assertFalse(cust.isEmpty());
        cust.stream().forEach((c1) -> {
            System.out.println("List Of Customers" + "\n" + c1.toString());
        });

        List<Address> alist = em.createNamedQuery("Address.findAll", Address.class).getResultList();
        assertFalse(alist.isEmpty());
        alist.stream().forEach((a1) -> {
            System.out.println("List Of Address" + "\n" + a1.toString());
        });

        //Products with price greater than 99
        List<Product> products = em.createNamedQuery("Product.findByRange").setParameter(1, 99).getResultList();
        assertFalse(products.isEmpty());
        products.stream().forEach((prod) -> {
            System.out.println("Products with maximum price" + "\n" + prod.toString());
        });

    }

    /**
     * Sample Data For update operation
     */
    public void sampleUpdateData() {
        //Store Entity
        tx.begin();
        Store s1 = new Store("Shawshank Rental", "2340 York Terrace", "Naperville", "3124782243", 60616);
        Address a1 = new Address(new GregorianCalendar(2011, 10, 01).getTime(), "2342 S Michigan Avenue");
        Customer c1 = new Customer();
        c1.setFirstName("Gregor");
        c1.setDob(new GregorianCalendar(1991, 11, 11).getTime());
        c1.setLastName("Muller");
        c1.setPhone("3457892343");
        c1.setPincode("234232");
        StoreManager sm1 = new StoreManager();
        sm1.setFirstName("Jason");
        sm1.setDob(new GregorianCalendar(1983, 11, 11).getTime());
        sm1.setLastName("Lambert");
        sm1.setPhone("5392235232");
        sm1.setPincode("423124");
        //setting address
        a1.getStoreManager().add(sm1);
        sm1.setAddress(a1);
        //setting store
        sm1.setStore(s1);
        Product p1 = new Product(200, "Laptop", "Electronic");
        Inventory i1 = new Inventory(new GregorianCalendar(2011, 10, 01).getTime(), 201, "Washington");
        c1.getProduct().add(p1);
        p1.getCustomer().add(c1);

        p1.getInventory().add(i1);
        i1.setProduct(p1);

        em.persist(s1);

        em.persist(a1);

        em.persist(sm1);

        em.persist(p1);

        em.persist(i1);

        em.persist(c1);

        tx.commit();

    }

    /**
     * Test Cases for updating data
     */
    @Test
    public void updateData() {
        sampleUpdateData();
        tx.begin();
        Store s = em.find(Store.class, 1l);
        s.setName("Rakesh");
        tx.commit();
        System.out.println("Updated StoreName:" + s.getName());
        assertEquals("Rakesh", s.getName());

        tx.begin();
        StoreManager sm = em.createNamedQuery("StoreManager.findByLastName", StoreManager.class).setParameter("name", "Lambert").getSingleResult();
        //StoreManager sm=em.find(StoreManager.class,1l);
        sm.setLastName("Lambert Willis");
        tx.commit();
        System.out.println("Updated StoreManager:" + sm.getLastName());
        assertEquals("Lambert Willis", sm.getLastName());

        tx.begin();
        Address a = em.createNamedQuery("Address.findByAddress", Address.class).setParameter("address", "2342 S Michigan Avenue").getSingleResult();
        //StoreManager sm=em.find(StoreManager.class,1l);
        a.setAddress("2342 S Michigan Avenue");
        tx.commit();
        System.out.println("Updated Address:" + a.getAddress());
        assertEquals("2342 S Michigan Avenue", a.getAddress());

        tx.begin();
        Product p = em.createNamedQuery("Product.findByName", Product.class).setParameter("name", "Grinder").getSingleResult();
        //StoreManager sm=em.find(StoreManager.class,1l);
        p.setName("RK Grinder");
        tx.commit();
        System.out.println("Updated Product:" + p.getName());
        assertEquals("RK Grinder", p.getName());

        tx.begin();
        Customer c = em.createNamedQuery("Customer.findByName", Customer.class).setParameter("name", "Gregor").getSingleResult();
        c.setFirstName("Gregor Muller");
        tx.commit();
        System.out.println("Updated Customer:" + c.getFirstName());
        assertEquals("Gregor Muller", c.getFirstName());

        tx.begin();
        Inventory i = em.createNamedQuery("Inventory.findById", Inventory.class).setParameter("id", 1).getSingleResult();
        i.setTotalItems(100);
        tx.commit();
        System.out.println("Total Items:" + i.getTotalItems());
        assertEquals(100, i.getTotalItems());

    }

    /**
     * Test Cases for deleting data
     */
    @Test
    public void deleteData() {
        tx.begin();
        Store s = new Store("Brad Pitt", "4232 South Michigan", "New York", "6743523353", 706005);
        em.persist(s);
        tx.commit();

        Store sname = em.createNamedQuery("Store.findByName", Store.class).setParameter("name", "Brad Pitt").getSingleResult();

        assertNotNull("Store is not empty", sname.getId());
        tx.begin();
        em.remove(sname);
        tx.commit();
        Store scheck = em.find(Store.class, sname.getId());
        assertNull(scheck);

        StoreManager name = em.createNamedQuery("StoreManager.findByName", StoreManager.class).setParameter("name", "Jeremy").getSingleResult();
        assertNotNull("StoreManager is not empty", name.getId());
        tx.begin();
        em.remove(name);
        tx.commit();
        StoreManager sdel = em.find(StoreManager.class, name.getId());
        assertNull(sdel);

        Address address = em.createNamedQuery("Address.findByAddress", Address.class).setParameter("address", "452 W Prairie Shores").getSingleResult();
        assertNotNull("Address is not empty", name.getId());
        tx.begin();
        em.remove(address);
        tx.commit();
        Address adel = em.find(Address.class, address.getId());
        assertNull(adel);

        Product product = em.createNamedQuery("Product.findByName", Product.class).setParameter("name", "AC").getSingleResult();
        assertNotNull("Product is not empty", product.getId());
        tx.begin();
        em.remove(product);
        tx.commit();
        Product pdel = em.find(Product.class, product.getId());
        assertNull(pdel);

        Customer custom = em.createNamedQuery("Customer.findByName", Customer.class).setParameter("name", "Rohan").getSingleResult();
        assertNotNull("Customer is not empty", custom.getId());
        tx.begin();
        em.remove(custom);
        tx.commit();
        Customer cdel = em.find(Customer.class, custom.getId());
        assertNull(cdel);

        Inventory inv = em.createNamedQuery("Inventory.findByLocation", Inventory.class).setParameter("location", "Chicago").getSingleResult();
        assertNotNull("Inventory is not empty", inv.getId());
        tx.begin();
        em.remove(inv);
        tx.commit();
        Inventory idel = em.find(Inventory.class, inv.getId());
        assertNull(idel);

    }

    /**
     * after each test method em is closed
     */
    @After
    public void afterEachTestMethod() {
        em.close();
    }

    /**
     * emf is closed after the class executes
     */
    @AfterClass
    public static void afterEachClass() {
        emf.close();
    }

}
