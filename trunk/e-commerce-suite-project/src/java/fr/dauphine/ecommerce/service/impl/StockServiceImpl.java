/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.service.impl;

import fr.dauphine.ecommerce.dao.StockDao;
import fr.dauphine.ecommerce.model.ProductStock;
import fr.dauphine.ecommerce.service.StockService;
import java.util.List;

/**
 *
 * @author DELL
 */
public class StockServiceImpl implements StockService {

    private StockDao stockDao;
    public void setStockDao(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    public List<ProductStock> searchProductStock() {
        return stockDao.searchProductStock();
    }

    public ProductStock getProductStock(Long productId) {
        return stockDao.getProductStock(productId);
    }

    public void updateProductStockQuantity(Long productId, Integer quantity) {
        stockDao.updateProductStockQuantity(productId, quantity);
    }

}
