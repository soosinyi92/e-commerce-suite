/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.model;

/**
 *
 * @author DELL
 */
public class CartItem {

    private Product product;
    private Integer quantity;
    private Integer quantityStock;

    public CartItem() {
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
    
    public Integer getQuantityStock() {
        return quantityStock;
    }
    
    public void setQuantityStock(Integer quantityStock) {
        this.quantityStock = quantityStock;
    }
    
}
