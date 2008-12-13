/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.test.dao;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import fr.dauphine.ecommerce.dao.OrderDao;
import fr.dauphine.ecommerce.dao.impl.OrderDaoJdbcImpl;
import fr.dauphine.ecommerce.model.Order;
import fr.dauphine.ecommerce.model.OrderItem;
import fr.dauphine.ecommerce.model.Product;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adm
 */
public class OrderDaoTest {

    private OrderDao orderDao;
    public OrderDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName("sun.jdbc.odbc.JdbcOdbcDriver");
    dataSource.setUrl("jdbc:odbc:eCommerce");
    dataSource.setDefaultAutoCommit(true);

    OrderDaoJdbcImpl orderDaoJdbc = new OrderDaoJdbcImpl();
    orderDaoJdbc.setDataSource(dataSource);
    orderDao = orderDaoJdbc;
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testAddOrder() {
      OrderItem item1 = new OrderItem();
      item1.setQuantity(2);

      Product product = new Product();
      product.setId(1L);
      product.setName("album1");
      product.setPrice(20.0);
      item1.setProduct(product);

      
      List<OrderItem> list = new ArrayList<OrderItem>();
      list.add(item1);

      OrderItem item2 = new OrderItem();
      item2.setQuantity(3);

      Product product2 = new Product();
      product2.setId(2L);
      product2.setName("album2");
      product2.setPrice(30.0);
      item2.setProduct(product2);
      list.add(item2);


      Order order = new Order();
      order.setItems(list);
      orderDao.addOrder(order);

     }

}