/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.dao.impl;

import fr.dauphine.ecommerce.dao.OrderDao;
import fr.dauphine.ecommerce.model.Order;

/**
 *
 * @author adm
 */
public class OrderDaoMockImpl implements OrderDao {

    public void addOrder(Order order) {
        System.out.println("Order with " + order.getItems().size() + " elements has been passed");
    }

}
