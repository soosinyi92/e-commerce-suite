/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.service.impl;

import fr.dauphine.ecommerce.dao.StockDao;
import fr.dauphine.ecommerce.dao.impl.StockDaoJdbcImpl;
import fr.dauphine.ecommerce.dao.impl.StockDaoMockImpl;
import fr.dauphine.ecommerce.model.ProductStock;
import fr.dauphine.ecommerce.service.StockService;
import java.util.List;

/**
 *
 * @author DELL
 */
public class StockServiceImpl implements StockService {

    private StockDao stockDao = new StockDaoMockImpl();

    public List<ProductStock> searchProductStock() {
        return stockDao.searchProductStock();
    }

    public ProductStock getProductStock(Long productId) {
        return stockDao.getProductStock(productId);
    }

    public void updateProductStockQuantity(Long productId, Integer quantity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}