/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.service;

import fr.dauphine.ecommerce.model.ProductStock;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface StockService {

    public List<ProductStock> searchProductStock();
    public ProductStock getProductStock(Long productId);
    public void updateProductStockQuantity(Long productId, Integer quantity);

}
