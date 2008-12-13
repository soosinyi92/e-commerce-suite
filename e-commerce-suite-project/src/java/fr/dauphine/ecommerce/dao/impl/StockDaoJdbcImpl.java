/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.dao.impl;

import fr.dauphine.ecommerce.dao.StockDao;
import fr.dauphine.ecommerce.model.Product;
import fr.dauphine.ecommerce.model.ProductStock;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author adm
 */

public class StockDaoJdbcImpl implements StockDao {

    private DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ProductStock getProductStock(Long productId) {
        try {
            Connection conn = dataSource.getConnection();
            Product product = new Product();
            //product.setId(1L);
            //product.setName("prod1");
            //ResultSet rs
            ProductStock productStock = new ProductStock();
            productStock.setProduct(product);
            productStock.setQuantity(30);
            return productStock;
        }
        catch (SQLException ex) {
            Logger.getLogger(StockDaoJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<ProductStock> searchProductStock() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    


    public void updateProductStockQuantity(Long productId, Integer quantity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
