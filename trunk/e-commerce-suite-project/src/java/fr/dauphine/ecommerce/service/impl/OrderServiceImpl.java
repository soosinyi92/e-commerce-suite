/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.service.impl;

import fr.dauphine.ecommerce.dao.OrderDao;
import fr.dauphine.ecommerce.model.Cart;
import fr.dauphine.ecommerce.model.Order;
import fr.dauphine.ecommerce.service.OrderService;
import fr.dauphine.ecommerce.service.StockService;

/**
 *
 * @author DELL
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    
    private StockService stockService;
    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }
    
    public Order getOrderFromCart(Cart cart) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Order order(Cart cart) {
        Order order = getOrderFromCart(cart);

        orderDao.addOrder(order);
        
        return order;
    }

    //stockService.updateProductStockQuantity(productId, 1);
    
}
