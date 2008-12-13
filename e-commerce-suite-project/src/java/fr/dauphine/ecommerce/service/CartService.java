/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.service;

import fr.dauphine.ecommerce.model.Cart;
import fr.dauphine.ecommerce.exceptions.CartException;

/**
 *
 * @author DELL
 */
public interface CartService {

    public Cart refreshCart(Cart cart);
    public boolean validateCart(Cart cart);
    public Cart addToCart(Cart cart, Long productId) throws CartException;
    public Cart removeFromCart(Cart cart, Long productId) throws CartException;

}
