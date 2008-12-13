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
public class Order {

    private List<OrderItem> items;

    public Order() {
        items = new ArrayList<OrderItem>();
    }

    public List<OrderItem> getItems() {
        return items;
    }
    
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Double getTotalPrice() {
        Double totalPrice = 0D;

        for (OrderItem item : items) {
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }

}
