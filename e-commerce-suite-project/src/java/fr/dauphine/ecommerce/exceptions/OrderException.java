/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.dauphine.ecommerce.exceptions;

/**
 *
 * @author DELL
 */
public class OrderException extends Exception {

    public OrderException(Throwable arg0) {
        super(arg0);
    }

    public OrderException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public OrderException(String arg0) {
        super(arg0);
    }

    public OrderException() {
    }

}
