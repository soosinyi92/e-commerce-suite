/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.model;

import fr.dauphine.ecommerce.service.exceptions.CartException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class Cart {

    private Map<Long, CartItem> items;

    public Cart() {
        items = new HashMap<Long, CartItem>();
    }

    public Map<Long, CartItem> getItems() {
        return items;
    }

    public boolean containsProduct(Long productId) {
        if (items.containsKey(productId)) {
            return true;
        }
        else {
            return false;
        }
    }

    public CartItem getItem(Long productId) throws CartException {
        if (items.containsKey(productId)) {
            return items.get(productId);
        }
        else {
            throw new CartException("Product " + productId + " not in cart");
        }
    }

    public void setItems(Map<Long, CartItem> items) {
        this.items = items;
    }

}
