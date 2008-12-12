package fr.dauphine.ecommerce.dao;

import fr.dauphine.ecommerce.model.ProductStock;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adm
 */
public interface StockDao {
    public ProductStock getProductStock(Long productId);
    public List<ProductStock> searchProductStock();
    public void updateProductStockQuantity(Long productId, Integer quantity);
}
