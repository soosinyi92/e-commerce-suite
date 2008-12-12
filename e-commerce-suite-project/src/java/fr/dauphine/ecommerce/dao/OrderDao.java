/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.dao;

import fr.dauphine.ecommerce.model.Cart;

/**
 *
 * @author adm
 */
public interface OrderDao {
    public void addOrder(Cart pan);
   

}
