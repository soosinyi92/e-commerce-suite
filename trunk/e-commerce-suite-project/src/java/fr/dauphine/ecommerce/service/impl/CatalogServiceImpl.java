/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.service.impl;

import fr.dauphine.ecommerce.model.Cart;
import fr.dauphine.ecommerce.model.CartItem;
import fr.dauphine.ecommerce.model.ProductStock;
import fr.dauphine.ecommerce.service.CatalogService;
import fr.dauphine.ecommerce.service.StockService;
import fr.dauphine.ecommerce.exceptions.CartException;
import java.util.List;

/**
 *
 * @author DELL
 */
public class CatalogServiceImpl implements CatalogService {

    private StockService stockService;
    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }
    
    public List<ProductStock> searchCatalogue(Cart cart) {
        // Get Stock articles
        List<ProductStock> articles = stockService.searchProductStock();

        for (ProductStock article : articles) {
            Long productId = article.getProduct().getId();
            if (cart.containsProduct(productId)) {
                try {
                    CartItem cartItem = cart.getItem(productId);
                    Integer leftQuantity = article.getQuantity() - cartItem.getQuantity();
                    article.setQuantity(leftQuantity);
                }
                catch (CartException ex) {}
            }
        }
        
        return articles;
    }

}
