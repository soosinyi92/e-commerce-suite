/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.servlet;

import fr.dauphine.ecommerce.model.Cart;
import fr.dauphine.ecommerce.model.Order;
import fr.dauphine.ecommerce.service.CartService;
import fr.dauphine.ecommerce.service.OrderService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderConfirmationServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        OrderService orderService = (OrderService)getServletContext().getAttribute("orderService");
        CartService cartService = (CartService)getServletContext().getAttribute("cartService");
        
        Cart cart = Utils.getCart(request.getSession());
        //Order order = orderService.getOrderFromCart(cart);
        
        Order order = orderService.order(cart);
        cartService.emptyCart(cart);
        request.setAttribute("order", order);
        
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/orderProcessed.jsp");
        rd.forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
