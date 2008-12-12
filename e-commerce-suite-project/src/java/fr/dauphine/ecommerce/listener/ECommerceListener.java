/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.listener;

import fr.dauphine.ecommerce.service.CartService;
import fr.dauphine.ecommerce.service.CatalogService;
import fr.dauphine.ecommerce.service.OrderService;
import fr.dauphine.ecommerce.service.StockService;
import fr.dauphine.ecommerce.service.impl.CartServiceImpl;
import fr.dauphine.ecommerce.service.impl.CatalogServiceImpl;
import fr.dauphine.ecommerce.service.impl.OrderServiceImpl;
import fr.dauphine.ecommerce.service.impl.StockServiceImpl;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 * @author DELL
 */

public class ECommerceListener implements ServletContextListener {
    
    public void contextInitialized(ServletContextEvent sce) {
        CatalogService catalogService = new CatalogServiceImpl();
        StockService stockService = new StockServiceImpl();
        CartService cartService = new CartServiceImpl();
        OrderService orderService = new OrderServiceImpl(); 

        sce.getServletContext().setAttribute("catalogService", catalogService);
        sce.getServletContext().setAttribute("stockService", stockService);
        sce.getServletContext().setAttribute("cartService", cartService);
        sce.getServletContext().setAttribute("orderService", orderService);
        System.out.println("Context Initialized");
    }
    
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context Destroyed");
    }
    
}