/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.test.dao;

import fr.dauphine.ecommerce.dao.StockDao;
import fr.dauphine.ecommerce.dao.impl.StockDaoJdbcImpl;
import fr.dauphine.ecommerce.model.ProductStock;
import javax.sql.DataSource;
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
public class StockDaoTest {

    public StockDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {

    }

    private StockDao stockDao;

    @Before
    public void setUp() {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("sun.jdbc.odbc.JdbcOdbcDriver");
        dataSource.setUrl("jdbc:odbc:eCommerce");
        dataSource.setDefaultAutoCommit(true);
        DataSource ds = dataSource;
        
        StockDaoJdbcImpl stockDaoJdbc = new StockDaoJdbcImpl();
        stockDaoJdbc.setDataSource(ds);
        stockDao=stockDaoJdbc;
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void hello() {
        ProductStock pStock= stockDao.getProductStock(1L);
        assertEquals(new Integer(30),pStock.getQuantity());
        assertEquals("prod1",pStock.getProduct().getName());

    }

}