/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.listener;

import fr.dauphine.ecommerce.dao.StockDao;
import fr.dauphine.ecommerce.dao.impl.StockDaoJdbcImpl;
import fr.dauphine.ecommerce.dao.impl.StockDaoMockImpl;
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
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 * Web application lifecycle listener.
 * @author DELL
 */

public class ECommerceListener implements ServletContextListener {
    
    public void contextInitialized(ServletContextEvent sce) {
        // DataSource(s)
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("sun.jdbc.odbc.JdbcOdbcDriver");
        basicDataSource.setUrl("jdbc:odbc:eCommerce");
        basicDataSource.setDefaultAutoCommit(true);
        // DataSource
        DataSource dataSource = basicDataSource;

        // DAOs
        StockDaoJdbcImpl stockDaoJdbc = new StockDaoJdbcImpl();
        stockDaoJdbc.setDataSource(dataSource);
        StockDaoMockImpl stockDaoMock = new StockDaoMockImpl();
        // Selected DAOs
        //StockDao stockDao = stockDaoJdbc;
        StockDao stockDao = stockDaoMock;

        // Services
        CatalogServiceImpl catalogService = new CatalogServiceImpl();
        StockServiceImpl stockService = new StockServiceImpl();
        CartServiceImpl cartService = new CartServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

        stockService.setStockDao(stockDao);
        catalogService.setStockService(stockService);
        cartService.setStockService(stockService);
        
        // Put in Application Scope
        sce.getServletContext().setAttribute("catalogService", (CatalogService)catalogService);
        sce.getServletContext().setAttribute("stockService", (StockService)stockService);
        sce.getServletContext().setAttribute("cartService", (CartService)cartService);
        sce.getServletContext().setAttribute("orderService", (OrderService)orderService);
        System.out.println("Context Initialized");
    }
    
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context Destroyed");
    }
    
}