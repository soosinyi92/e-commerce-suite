/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.service;

import fr.dauphine.ecommerce.model.Cart;
import fr.dauphine.ecommerce.model.Order;

/**
 *
 * @author DELL
 */
public interface OrderService {

    public Order getOrderFromCart(Cart cart);
    public Order order(Cart cart);
    public boolean validateCart(Cart cart);
    
}
