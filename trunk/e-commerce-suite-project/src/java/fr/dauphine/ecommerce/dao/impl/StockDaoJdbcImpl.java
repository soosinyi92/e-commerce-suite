/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.dao.impl;

import fr.dauphine.ecommerce.dao.StockDao;
import fr.dauphine.ecommerce.model.Product;
import fr.dauphine.ecommerce.model.ProductStock;
import java.util.List;

/**
 *
 * @author adm
 */
public class StockDaoJdbcImpl implements StockDao {

    public ProductStock getProductStock(Long productId) {
        Product product = new Product();
        product.setId(1L);
        product.setName("prod1");
        ProductStock productStock=new ProductStock();
        productStock.setProduct(product);
        productStock.setQuantity(30);
        return  productStock;
    }

    public List<ProductStock> searchProductStock() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    


    public void updateProductStockQuantity(Long productId, Integer quantity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
