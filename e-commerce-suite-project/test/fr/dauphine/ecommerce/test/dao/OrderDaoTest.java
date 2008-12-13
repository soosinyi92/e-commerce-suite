/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.test.dao;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import fr.dauphine.ecommerce.dao.impl.OrderDaoJdbcImpl;
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


    public OrderDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName("sun.jdbc.odbc.JdbcOdbcDriver");
    dataSource.setUrl("jdbc:odbc:eCommerce");
    dataSource.setDefaultAutoCommit(true);

    OrderDaoJdbcImpl orderDao;
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}