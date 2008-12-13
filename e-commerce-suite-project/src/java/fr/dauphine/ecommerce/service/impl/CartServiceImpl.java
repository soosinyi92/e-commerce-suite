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

    private StockService stockService;
    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }
    
    public Cart refreshCart(Cart cart) {
        validateCart(cart);
        return cart;
    }

    public boolean validateCart(Cart cart) {
        boolean valid = false;
        if (cart.getItems().size() > 0) {
            for (CartItem cartItem : cart.getItems().values()) {
                if (cartItem.getQuantity() > cartItem.getQuantityStock()) {
                    valid = false;
                }
            }
            valid = true;
        }
        else {
            valid = false;
        }
        cart.setCanOrder(valid);
        return valid;
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
        validateCart(cart);
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
        validateCart(cart);
        return cart;
    }

}
