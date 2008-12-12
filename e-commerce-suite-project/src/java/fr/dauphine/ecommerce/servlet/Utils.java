/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.servlet;

import fr.dauphine.ecommerce.model.Cart;
import javax.servlet.http.HttpSession;

public class Utils {

    // Recuperer le Panier a partir du scope session
    public static Cart getCart(HttpSession session) {
        Cart cart = (Cart)session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

}
