/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vnallamhawk.web;
import edu.iit.sat.itmd4515.vnallamhawk.domain.StoreManager;
import edu.iit.sat.itmd4515.vnallamhawk.service.StoreManagerService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VenkataRakesh
 */
@WebServlet(name="StorePortalTestServlet", urlPatterns = {"/storePortal"})
public class StorePortalTestServlet extends HttpServlet{
    
    @EJB 
    private StoreManagerService smService;
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' type='text/css' href= 'resources/css/bootstrap.css'>");
            out.println("<title>Servlet StorePortalTestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StorePortalTestServlet at " + request.getContextPath() + "</h1>");
            out.println("<h2>" + request.getRemoteUser() + "</h2>");

            if (request.isUserInRole("managers")) {
                StoreManager sm = smService.findByUsername(request.getRemoteUser());

                out.println("<table class='table-bordered'><tr>");
                out.println("<tr><th>FirstName</th><th>Last Name</th><th> DOB</th><th>Location</th><th>Pincode</th><th>Store In-Charge</th></tr>");
                
                out.println("<tr><td>"+sm.getFirstName() + "</td><td>" + sm.getLastName() + "</td><td>" + sm.getDob() + "</td>"
                + "<td>" + sm.getLocation() + "</td><td>"+ sm.getPincode() + "</td><td>"+sm.getStore().getName()+"</td></tr>");
               
                
              
             
            }
            out.println("</table>");
            out.println("<a href=\"" + request.getContextPath() + "/logout\">Logout</a>");
            
            out.println("</body>");
            out.println("</html>");
         }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
