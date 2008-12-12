/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.service.impl;

import fr.dauphine.ecommerce.model.Cart;
import fr.dauphine.ecommerce.model.CartItem;
import fr.dauphine.ecommerce.model.ProductStock;
import fr.dauphine.ecommerce.service.CartService;
import fr.dauphine.ecommerce.service.StockService;
import fr.dauphine.ecommerce.exceptions.CartException;

/**
 *
 * @author DELL
 */
public class CartServiceImpl implements CartService {

    private StockService stockService = new StockServiceImpl();

    public Cart refreshCart(Cart cart) {

        return null;

    }

    protected boolean isProductInCart(Cart cart, Long productId) {
        return cart.getItems().containsKey(productId);
    }

    public Cart addToCart(Cart cart, Long productId) throws CartException {
        // Getting the ProductStock
        ProductStock productStock = stockService.getProductStock(productId);

        // Adding the Product to the Cart
        if (isProductInCart(cart, productId)) {
            CartItem cartItem = cart.getItem(productId);
            Integer oldQuantity = cart.getItem(productId).getQuantity();
            cartItem.setQuantity(oldQuantity + 1);
        }
        else { // Not in cart
            CartItem cartItem = new CartItem();
            cartItem.setProduct(productStock.getProduct());
            cartItem.setQuantity(1);
            cartItem.setQuantityStock(productStock.getQuantity());
            cart.getItems().put(productId, cartItem);
        }
        
        return cart;
    }

    public Cart removeFromCart(Cart cart, Long productId) throws CartException {
        if (isProductInCart(cart, productId)) {
            CartItem cartItem = cart.getItem(productId);
            Integer oldQuantity = cart.getItem(productId).getQuantity();
            cartItem.setQuantity(oldQuantity - 1);
            // Remove if quantity = 0
            if (cartItem.getQuantity() == 0) {
                cart.getItems().remove(productId);
            }
        }
        return cart;
    }

}
