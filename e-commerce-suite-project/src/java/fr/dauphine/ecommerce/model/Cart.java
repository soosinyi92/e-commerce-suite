/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Cart {

    private List<CartItem> items;

    public Cart() {
        items = new ArrayList<CartItem>();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

}
