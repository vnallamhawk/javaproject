/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.mp2.web;

import edu.iit.sat.itmd4515.vnallamhawk.mp2.model.Customer;
import edu.iit.sat.itmd4515.vnallamhawk.mp2.service.CustomerService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 *
 * @author VenkataRakesh
 */
@WebServlet(name = "CustomerController", urlPatterns = {"/CustomerController", "/insert", "/delete", "/search", "/update", "/customerlist"})
public class CustomerController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(CustomerController.class.getName());

    @Resource
    Validator validator;

    /**
     * Creating a Customer Service object Using Enterprise Java Bean
     */
    @EJB
    CustomerService svc;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        /**
         * switch case to get the url pattern in the browser and redirect to the
         * corresponding page using getRequestDispatcher method
         */
        switch (request.getServletPath()) {

            /**
             * when the URL in the browser ends with insert pattern it is
             * redirected to CreateCustomer.jsp page
             */
            case "/insert":
                LOG.info("Inside InsertCustomer");
                request.getRequestDispatcher("/WEB-INF/pages/CreateCustomer.jsp").forward(request, response);
                break;

            /**
             * when the URL in the browser ends with delete pattern it is
             * redirected to DeleteCustomer.jsp page
             */
            case "/delete":
                LOG.info("Inside DeleteCustomer");
                request.getRequestDispatcher("/WEB-INF/pages/DeleteCustomer.jsp").forward(request, response);
                break;

            /**
             * when the URL in the browser ends with search pattern it is
             * redirected to SearchCustomer.jsp page
             */
            case "/search":
                LOG.info("Inside SearchCustomer");
                request.getRequestDispatcher("/WEB-INF/pages/SearchCustomer.jsp").forward(request, response);
                break;

            /**
             * when the URL in the browser ends with update pattern it is
             * redirected to UpdateCustomer.jsp page
             */
            case "/update":
                LOG.info("Inside UpdateCustomer");
                Long customerId = Long.parseLong(WebUtil.trimParam(request.getParameter("customerId")));
                //LOG.info("customerid inside update method"+customerId.toString());
                request.setAttribute("customerupdate", svc.findById(customerId));
                request.getRequestDispatcher("/WEB-INF/pages/UpdateCustomer.jsp").forward(request, response);
                break;

            /**
             * when the URL in the browser ends with customerlist pattern it is
             * redirected to CustomerList.jsp page
             */
            case "/customerlist":
                LOG.info("Inside CustomerList");
                request.setAttribute("customers", svc.findAll());
                request.getRequestDispatcher("/WEB-INF/pages/CustomerList.jsp").forward(request, response);
                break;

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        LOG.info("Inside doPost method.  I am processing a form POST.");

        Map<String, String> messages = new HashMap<>();
        request.setAttribute("messages", messages);

        switch (request.getServletPath()) {
            /**
             * when the form is posted in the Create Customer jsp page, it is
             * redirect to this switch case Data is inserted to the database in
             * this function
             */
            case "/insert":

                LOG.info("STORING CUSTOMER ID IN POST METHOD");
                String firstName = WebUtil.trimParam(request.getParameter("firstName"));
                String lastName = WebUtil.trimParam(request.getParameter("lastName"));
                String email = WebUtil.trimParam(request.getParameter("email"));
                String phone = WebUtil.trimParam(request.getParameter("phone"));
                String address = WebUtil.trimParam(request.getParameter("address"));
                String postal_code = WebUtil.trimParam(request.getParameter("postal_code"));
                Integer storeId = 1;
                Integer addressId = svc.getMaxAddressId();
                Integer cityId = 2;
                Customer c = new Customer(firstName, lastName, email, phone, address, postal_code, storeId,
                        addressId, cityId);

                Set<ConstraintViolation<Customer>> violations = validator.validate(c);
                if (violations.isEmpty()) {
                    LOG.info("Received the following customer from user form:\t" + c.toString());
                    if (svc.insert(c)) {
                        messages.put("success", "Customer Successully inserted into database");
                        request.setAttribute("customers", svc.findAll());
                        // On success, I now want to redirect to my servlet URL pattern to ensure that customers gets set in the requestScope
                        request.getRequestDispatcher("/WEB-INF/pages/CustomerList.jsp").forward(request, response);
                    } else {
                        messages.put("failure", "Query Failed");
                        request.getRequestDispatcher("/WEB-INF/pages/CreateCustomer.jsp").forward(request, response);
                    }
                } else {
                    // if violations is not empty, our object failed validation.  Log!
                    LOG.info("There are " + violations.size() + " violations.");

                    for (ConstraintViolation<Customer> violation : violations) {
                        LOG.info("####### " + violation.getRootBeanClass().getSimpleName()
                                + "." + violation.getPropertyPath() + " failed violation:\t"
                                + violation.getInvalidValue() + " failed with message:\t"
                                + violation.getMessage());
                    }
                    // if failure, send back to user form with validation messages
                    request.setAttribute("violations", violations);
                    request.setAttribute("customer", c);
                    request.getRequestDispatcher("/WEB-INF/pages/CreateCustomer.jsp").forward(request, response);
                }
                break;

            /**
             * when the form is posted in the Delete Customer jsp page, it is
             * redirect to this switch case Data is deleted from the database in
             * this function
             */
            case "/delete":
                try {
                    Long customerId = null;
                    LOG.info("INSIDE DELETE");
                    if (!WebUtil.isEmpty(request.getParameter("customerId"))) {
                        LOG.info("STORING CUSTOMER ID IN POST METHOD");
                        // needs additional checks to ensure it is actually Long and right format
                        customerId = Long.parseLong(WebUtil.trimParam(request.getParameter("customerId")));
                        LOG.info("customer" + customerId.toString());
                        // if (violations.isEmpty()) {
                        if (svc.delete(customerId) == "deleted") {
                            messages.put("success", "Customer Successully deleted from the database");
                            request.setAttribute("customers", svc.findAll());
                            // On success, I now want to redirect to my servlet URL pattern to ensure that customers gets set in the requestScope
                            request.getRequestDispatcher("/WEB-INF/pages/CustomerList.jsp").forward(request, response);
                        } else if (svc.delete(customerId) == "DelFailed") {
                            messages.put("Failure", "Customer Id does not exist");
                            request.getRequestDispatcher("/WEB-INF/pages/DeleteCustomer.jsp").forward(request, response);
                        } else {
                            messages.put("Failure", svc.delete(customerId));
                            request.getRequestDispatcher("/WEB-INF/pages/DeleteCustomer.jsp").forward(request, response);
                        }
                    } else {
                        messages.put("Failure", "Please enter the Customer Id to be deleted");
                        request.getRequestDispatcher("/WEB-INF/pages/DeleteCustomer.jsp").forward(request, response);
                    }
                } catch (Exception ex) {
                    messages.put("Failure", ex.getMessage());
                    request.getRequestDispatcher("/WEB-INF/pages/DeleteCustomer.jsp").forward(request, response);
                }

                break;

            /**
             * when the form is posted in the Search Customer jsp page, it is
             * redirect to this switch case Values are fetched according to the
             * passed value in this page
             */
            case "/search":
                try {
                    Long customerId = null;
                    LOG.info("INSIDE search");
                    if (!WebUtil.isEmpty(request.getParameter("customerId"))) {
                        LOG.info("STORING CUSTOMER ID IN POST METHOD");
                        // needs additional checks to ensure it is actually Long and right format
                        customerId = Long.parseLong(WebUtil.trimParam(request.getParameter("customerId")));
                        if (!(svc.findById(customerId).isEmpty())) {
                            request.setAttribute("customers", svc.findById(customerId));
                            messages.put("Success", "Customer ID exist");
                            request.getRequestDispatcher("/WEB-INF/pages/SearchCustomer.jsp").forward(request, response);
                        } else {
                            messages.put("failure", "Customer ID does not exist");
                            request.getRequestDispatcher("/WEB-INF/pages/SearchCustomer.jsp").forward(request, response);
                        }
                        //c = svc.findById(customerId);
                    } else {
                        messages.put("Error", "Please enter the Customer Id");
                        request.getRequestDispatcher("/WEB-INF/pages/SearchCustomer.jsp").forward(request, response);
                    }
                } catch (Exception ex) {
                    messages.put("Error", ex.getMessage() + "Please Enter a Number");
                    request.getRequestDispatcher("/WEB-INF/pages/SearchCustomer.jsp").forward(request, response);
                }
                break;

            /**
             * when the form is posted in the Search Customer jsp page, it is
             * redirect to this switch case Values are updated in this page
             */
            case "/update":
                try {
                    Long customerId = null;
                    if (!WebUtil.isEmpty(request.getParameter("customerId"))) {
                        LOG.info("STORING CUSTOMER ID IN POST METHOD");
                        // needs additional checks to ensure it is actually Long and right format
                        customerId = Long.parseLong(WebUtil.trimParam(request.getParameter("customerId")));
                        firstName = WebUtil.trimParam(request.getParameter("firstName"));
                        lastName = WebUtil.trimParam(request.getParameter("lastName"));
                        email = WebUtil.trimParam(request.getParameter("email"));
                        phone = WebUtil.trimParam(request.getParameter("phone"));
                        address = WebUtil.trimParam(request.getParameter("address"));
                        postal_code = WebUtil.trimParam(request.getParameter("postal_code"));
                        LOG.info("phone,addres,postal_code" + phone + address + postal_code);

                        c = new Customer(customerId, firstName, lastName, email, phone, address, postal_code);
                        if (svc.update(c) == "success") {
                            messages.put("Successs", "Updated Successfully");
                            request.getRequestDispatcher("/WEB-INF/pages/SearchCustomer.jsp").forward(request, response);
                        } else {
                            messages.put("Failure", svc.update(c));
                            request.getRequestDispatcher("/WEB-INF/pages/UpdateCustomer.jsp").forward(request, response);
                        }
                    } else {
                        messages.put("failure", "Please enter the input properly");
                        request.getRequestDispatcher("/WEB-INF/pages/UpdateCustomer.jsp").forward(request, response);
                    }
                } catch (Exception Ex) {
                    messages.put("failure", Ex.getMessage());
                    request.getRequestDispatcher("/WEB-INF/pages/UpdateCustomer.jsp").forward(request, response);
                }

                break;
        }
    }
}
