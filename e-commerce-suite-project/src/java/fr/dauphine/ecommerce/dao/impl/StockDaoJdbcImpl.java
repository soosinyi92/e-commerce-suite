/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.ecommerce.dao.impl;

import fr.dauphine.ecommerce.dao.StockDao;
import fr.dauphine.ecommerce.model.Product;
import fr.dauphine.ecommerce.model.ProductStock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public ProductStock loadProduct(ResultSet rs) throws SQLException {
        String idString = rs.getString("Id");
        String name = rs.getString("Name");
        String description = rs.getString("Description");
        Double price = rs.getDouble("Price");
        Integer quantity = rs.getInt("Quantity");
        Long id = Long.parseLong(idString);

        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);

        ProductStock productStock = new ProductStock();
        productStock.setProduct(product);
        productStock.setQuantity(quantity);
        return productStock;
    }

    public ProductStock getProductStock(Long productId) {
        try {
            Connection conn = dataSource.getConnection();
            
            // récuperer les données excuter la requête
            ResultSet rs;
            String query = "select * from Product p, ProductStock ps where p.Id=? and p.id=ps.product_Id";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, productId + "");
            rs = ps.executeQuery();

            //charger les données dans les objets du model
            if (rs.next()) {
                return loadProduct(rs);
            } else {
                return null;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(StockDaoJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<ProductStock> searchProductStock() {
        try {
            Connection conn = dataSource.getConnection();

            // récuperer les données excuter la requête
            ResultSet rs;
            String query = "select * from Product p, ProductStock ps where p.id=ps.product_Id";
            PreparedStatement ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            //charger les données dans les objets du model
            List<ProductStock> list = new ArrayList<ProductStock>();
            
            while (rs.next()) {
                list.add(loadProduct(rs));
                
            }
        return list;
        }
        catch (SQLException ex) {
            Logger.getLogger(StockDaoJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void updateProductStockQuantity(Long productId, Integer quantity) {
        try {
            Connection conn = dataSource.getConnection();
            String query = "update ProductStock set quantity = ? where Product_Id = ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, quantity);
            ps.setString(2,productId+"");
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StockDaoJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
