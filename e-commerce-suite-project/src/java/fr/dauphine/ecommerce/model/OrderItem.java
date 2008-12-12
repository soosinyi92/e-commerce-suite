/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.model;

/**
 *
 * @author DELL
 */
public class OrderItem {

    private Product product;
    private Integer quantity;

    public OrderItem() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
}
