/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.test.dao;

import fr.dauphine.ecommerce.dao.StockDao;
import fr.dauphine.ecommerce.dao.impl.StockDaoJdbcImpl;
import fr.dauphine.ecommerce.model.ProductStock;
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
        stockDao = new StockDaoJdbcImpl();
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