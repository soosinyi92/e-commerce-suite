/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.servlet;

import fr.dauphine.ecommerce.model.Product;
import fr.dauphine.ecommerce.model.ProductStock;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class CatalogServlet extends HttpServlet {

    private ProductStock sim(Long id, String name, Integer quantity, Double price) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        ProductStock productStock=new ProductStock();
        productStock.setProduct(product);
        productStock.setQuantity(quantity);
        return productStock;
    }

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Recuperer le Catalogue Ã  partir du scope application
        // Catalogue cat = this.getCatalogue(getServletContext());
        
        // Les articles du catalogue

        // Get from Service
        List<ProductStock> articles = new ArrayList<ProductStock>();
        articles.add(sim(1L, "Radiohead", 4, 21.0));
        articles.add(sim(2L, "Matoub", 6, 16.0));
        articles.add(sim(3L, "Gnawa Diffusion", 5, 19.0));
        articles.add(sim(4L, "Super Compile", 0, 32.0));
        
        request.setAttribute("articles", articles);

        RequestDispatcher rd = request.getRequestDispatcher("catalog.jsp");
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
