/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.mp2.service;

import edu.iit.sat.itmd4515.vnallamhawk.mp2.model.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author VenkataRakesh
 */
@Stateless
public class CustomerService {

    @Resource(lookup = "jdbc/vnallamhawkMp2DS")
    private DataSource ds;
    private static final Logger LOG = Logger.getLogger(CustomerService.class.getName());

    /**
     * findAll method to list out the all the customers along with their from
     * both the customer table and address table
     * @return 
     */
    public List<Customer> findAll() {

        List<Customer> customers = new ArrayList<>();

        try (Connection c = ds.getConnection()) {
            Statement s = c.createStatement();

            ResultSet rs = s.executeQuery("select * from customer "
                    + "LEFT JOIN address on customer.address_id=address.address_id "
                    + "order by customer.last_update desc");

            while (rs.next()) {
                customers.add(new Customer(rs.getLong("customer_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("postal_code")
                ));
            }
        } catch (SQLException ex) {

            LOG.log(Level.SEVERE, null, ex);
        }
        return customers;

    }

    /**
     * findById method which takes in an argument of customer id and returns the
     * first name,last name email,phone,address and postal_code of the customer
     * Id which is passed to the function.
     * @param id
     * @return 
     */
    public List<Customer> findById(Long id) {
        List<Customer> customers = new ArrayList<>();
        try (Connection c = ds.getConnection()) {

            // JDBC has both Statement and PreparedStatement
            PreparedStatement ps = c.prepareStatement("select * from customer c,address a where "
                    + "c.address_id=a.address_id and c.customer_id=?;");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customers.add(new Customer(rs.getLong("customer_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("postal_code")));
            }

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

        // if nothing was found, return null
        return customers;
    }

    /**
     * returns the total count of address and adds 1. This value is used for
     * insertion of data into the address table.
     * @return 
     */
    public Integer getMaxAddressId() {
        Integer count = 1;
        try (Connection c = ds.getConnection()) {
            Statement s = c.createStatement();

            ResultSet rs = s.executeQuery("select * from address");
            while (rs.next()) {
                count = count + 1;
            }
        } catch (SQLException ex) {

            LOG.log(Level.SEVERE, null, ex);
        }
        LOG.info("count" + count);
        return count;
    }

    /**
     * This method is used for insertion of data into both the customer and
     * address table. It return boolean value.
     * @param customer
     * @return 
     */
    public boolean insert(Customer customer) {
        String insertCustomer = "insert into customer("
                //+ "customer_id,"
                + "first_name,"
                + "last_name,"
                + "email,"
                + "store_id,"
                + "address_id,"
                + "create_date)"
                + " values(?,?,?,?,?,?)";

        String insertAddress = "insert into address("
                + "address,"
                + "phone,"
                + "city_id,"
                + "postal_code)"
                + "values(?,?,?,?)";

        int returnVal = 0;

        try (Connection c = ds.getConnection()) {
            PreparedStatement ps;
            LOG.info("Nothing to update.  Inserting a new record " + customer.toString());
            ps = c.prepareStatement(insertCustomer);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getEmail());
            ps.setInt(4, customer.getStoreId());
            ps.setInt(5, customer.getAddressId());
            ps.setDate(6, Date.valueOf(LocalDate.now()));
            returnVal = ps.executeUpdate();

            PreparedStatement psaddr;
            psaddr = c.prepareStatement(insertAddress);
            psaddr.setString(1, customer.getAddress());
            psaddr.setString(2, customer.getPhone());
            psaddr.setInt(3, customer.getCity_id());
            psaddr.setString(4, customer.getPostal_code());

            returnVal = psaddr.executeUpdate();
            // }

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return false;
        }

        return returnVal > 0;
    }

    /**
     * This method delete is used for deletion of data from both the customer
     * and address table. This method returns a string "deleted" or "delfailed"
     * based on the success of deletion
     * @param id
     * @return 
     */
    public String delete(long id) {

        String rental = "delete from rental where customer_id =?";
        String payment = "delete from payment where customer_id =?";
        String customer = "delete from customer where customer_id =?";
        int returnValrent = 0;
        int returnValpay = 0;
        int returnValCus = 0;

        try (Connection c = ds.getConnection()) {
            PreparedStatement ps_rental;
            PreparedStatement ps_payment;
            PreparedStatement ps_customer;
            //LOG.info("Nothing to update.  Deleting a new record " + customer.toString());
            ps_rental = c.prepareStatement(rental);
            ps_payment = c.prepareStatement(payment);
            ps_customer = c.prepareStatement(customer);
            //ps.setLong(1, customer.getId());
            ps_rental.setLong(1, id);
            ps_payment.setLong(1, id);
            ps_customer.setLong(1, id);
            returnValrent = ps_rental.executeUpdate();
            returnValpay = ps_payment.executeUpdate();
            returnValCus = ps_customer.executeUpdate();
            LOG.info("RETURNVALRENT" + returnValrent);
            LOG.info("RETURNVALPay" + returnValpay);
            LOG.info("RETURNVALCus" + returnValCus);
            if (returnValCus == 1) {
                return "deleted";
            } else {
                return "DelFailed";
            }
            // }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return ex.getMessage();
            //return false;
        }
    }

    /**
     * This method update is used for updation of data from both the customer
     * and address table. This method returns a string "success" if the
     * operation is successful or error exception if the update fails
     * @param customer
     * @return 
     */
    public String update(Customer customer) {
        Integer address_id = getAddressForCustomer(customer.getId());
        LOG.info("address_id inside update" + address_id);
        String updateCus = "update customer set "
                + "first_name=?, "
                + "last_name=?, "
                + "email=?, "
                + "create_date=?"
                + " where customer_id=?";
        LOG.info("QUERY" + updateCus);

        String updateAddr = "update address set "
                + "address=?, "
                + "phone=?, "
                + "postal_code=?"
                + " where address_id=?";

        int returnVal = 0;

        try (Connection c = ds.getConnection()) {
            PreparedStatement ps = c.prepareStatement(updateCus);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getEmail());
            ps.setDate(4, Date.valueOf(LocalDate.now()));
            ps.setLong(5, customer.getId());

            returnVal = ps.executeUpdate();

            PreparedStatement ps1 = c.prepareStatement(updateAddr);
            ps1.setString(1, customer.getPhone());
            ps1.setString(2, customer.getAddress());
            ps1.setString(3, customer.getPostal_code());
            ps1.setInt(4, address_id);
            //ps1.setLong(5, customer.getId());

            returnVal = ps1.executeUpdate();
            return "success";

        } catch (SQLException ex) {

            return ex.getMessage();
        }
    }

    /**
     * This method getAddressForCustomer return the address id of the customer
     * passed to the function.
     * @param customerid
     * @return 
     */
    public int getAddressForCustomer(long customerid) {
        LOG.info("customerId value inside" + customerid);
        Integer address_id = 0;
        try (Connection c = ds.getConnection()) {
            PreparedStatement ps = c.prepareStatement("Select address_id from customer where customer_id=?");
            ps.setInt(1, (int) customerid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                address_id = rs.getInt(1);
            }

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return address_id;

    }
}
