/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.dao.impl;

import fr.dauphine.ecommerce.dao.OrderDao;
import fr.dauphine.ecommerce.model.Order;
import fr.dauphine.ecommerce.model.CartItem;
import fr.dauphine.ecommerce.model.Order;
import fr.dauphine.ecommerce.model.OrderItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;


/**
 *
 * @author adm
 */
public class OrderDaoJdbcImpl implements OrderDao {
    private DataSource dataSource;
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
    }


    public void addOrderItem (Integer Order_Id, OrderItem item) throws SQLException{

       Connection conn = dataSource.getConnection();
       String queryInsert = "insert into Order_Items values (?,?,?,?)";
       PreparedStatement ps = conn.prepareStatement(queryInsert);
       ps.setInt(1, Order_Id);
       ps.setString(2,item.getProduct().getId()+"");
       ps.setInt(3, item.getQuantity());
       ps.setDouble(4, item.getProduct().getPrice());
       ps.executeUpdate();

    }

    public void addOrder(Order order) {
        try {


            Connection conn = dataSource.getConnection();
            String queryInsert = "insert into [Order](Date_Order) values (?)";
            PreparedStatement ps1 = conn.prepareStatement(queryInsert);
            ps1.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            ps1.executeUpdate();

            ResultSet rs2 ;
            String querySelect = "select max(Order_Id) as nb from [Order]";
            Statement stm2 = conn.createStatement();
            rs2 = stm2.executeQuery(querySelect);
            rs2.next();
            Integer nb = rs2.getInt("nb");

            Integer size = order.getItems().size();
            Integer i=0;
            while (i<size){
                addOrderItem(nb, order.getItems().get(i));
                i++;
            }




        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
