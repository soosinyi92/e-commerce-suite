/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.service.impl;

import fr.dauphine.ecommerce.dao.OrderDao;
import fr.dauphine.ecommerce.model.Cart;
import fr.dauphine.ecommerce.model.CartItem;
import fr.dauphine.ecommerce.model.Order;
import fr.dauphine.ecommerce.model.OrderItem;
import fr.dauphine.ecommerce.model.ProductStock;
import fr.dauphine.ecommerce.service.CartService;
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

    private CartService cartService;
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }


    public Order getOrderFromCart(Cart cart) {
        Order order = new Order();
        
        for (CartItem cartItem : cart.getItems().values()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            order.getItems().add(orderItem);
        }
        
        return order;
    }

    public boolean validateCart(Cart cart) {
        cart = cartService.refreshCart(cart);

        if (cart.getItems().size() > 0) {
            for (CartItem cartItem : cart.getItems().values()) {
                if (cartItem.getQuantity() > cartItem.getQuantityStock()) {
                    return false;
                }
            } 
            return true;
        }
        else {
            return false;
        }
    }

    public Order order(Cart cart) {
        Order order = getOrderFromCart(cart);
        
        for (OrderItem orderItem : order.getItems()) {
            Long productId = orderItem.getProduct().getId();
            
            ProductStock productStock = stockService.getProductStock(productId);
            
            Integer oldQuantity = productStock.getQuantity();
            Integer newQuantity = oldQuantity - orderItem.getQuantity();
            
            stockService.updateProductStockQuantity(productId, newQuantity);
        }
        orderDao.addOrder(order);
        
        return order;
    }

    //stockService.updateProductStockQuantity(productId, 1);
    
}
