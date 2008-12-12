/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.dao.impl;

import fr.dauphine.ecommerce.dao.StockDao;
import fr.dauphine.ecommerce.model.Product;
import fr.dauphine.ecommerce.model.ProductStock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author adm
 */
public class StockDaoMockImpl implements StockDao {

    private ProductStock sim(Long id, String name, Integer quantity, Double price) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        ProductStock productStock=new ProductStock();
        productStock.setProduct(product);
        productStock.setQuantity(quantity);
        return productStock;
    }

    private ProductStock clown(ProductStock orig) {
        ProductStock clown = sim(orig.getProduct().getId(), orig.getProduct().getName(), orig.getQuantity(), orig.getProduct().getPrice());
        return clown;
    }

    private Map<Long, ProductStock> db = new HashMap<Long, ProductStock>();

    public StockDaoMockImpl() {
        db.put(1L, sim(1L, "Radiohead", 4, 21.0));
        db.put(2L, sim(2L, "Matoub", 6, 16.0));
        db.put(3L, sim(3L, "Gnawa Diffusion", 5, 19.0));
        db.put(4L, sim(4L, "Super Compile", 0, 32.0));
        db.put(5L, sim(5L, "Mamadou et Myriam", 5, 17.0));
    }
    
    public ProductStock getProductStock(Long productId) {
        ProductStock orig = db.get(productId);
        ProductStock clown = clown(orig);
        return clown;
    }

    public List<ProductStock> searchProductStock() {
        List<ProductStock> articles = new ArrayList<ProductStock>();
        for (ProductStock productStock : db.values()) {
            articles.add(clown(productStock));
        }
        return articles;
    }
    
    public void updateProductStockQuantity(Long productId, Integer quantity) {
        ProductStock productStock = db.get(productId);
        Integer newQuantity = productStock.getQuantity() - quantity;
        productStock.setQuantity(newQuantity);
    }
    
}
