/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.service;

import fr.dauphine.ecommerce.model.Cart;
import fr.dauphine.ecommerce.model.ProductStock;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface CatalogService {

    public List<ProductStock> searchCatalogue(Cart cart);

}
