/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.service;

import fr.dauphine.ecommerce.model.Cart;

/**
 *
 * @author DELL
 */
public interface CartService {

    public Cart refreshCart(Cart cart);
    public Cart addToCart(Cart cart, Long productId);
    public Cart removeFromCart(Cart cart, Long productId);

}
