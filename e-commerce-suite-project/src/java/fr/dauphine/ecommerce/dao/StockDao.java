package fr.dauphine.ecommerce.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adm
 */
public interface StockDao {
    public void getProductStock(Long productId);
    public void searchStock();
    public void updateProductStockQuantity(Long productId, Integer quantity);
}
