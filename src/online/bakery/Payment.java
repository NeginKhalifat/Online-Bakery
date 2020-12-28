/*
 * Create a new payment object.
 */
package online.bakery;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author salidotir
 */
public class Payment {
    int paymentId ;
    static AtomicInteger atomicInteger = new AtomicInteger(1);
    private final String paymentCustomerId;
    private final Date paymentDate;
    private final int paymentAmount;          // payment amount is calculated in 'Rials' -> int
    private String paymentDiscreption;  // any discreption for payment
    
    // constructor for creating payment object the first time for ordeing
    public Payment(String paymentCustomerId, Date paymentDate, int paymentAmount) {
        this.paymentCustomerId = paymentCustomerId;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.paymentDiscreption = "";
        this.paymentId = atomicInteger.incrementAndGet();
    }

    /**
     * @return the paymentId
     */
    public int getPaymentId() {
        return paymentId;
    }

    /**
     * @return the paymentCustomerId
     */
    public String getPaymentCustomerId() {
        return paymentCustomerId;
    }

    /**
     * @return the paymentDate
     */
    public Date getPaymentDate() {
        return paymentDate;
    }

    /**
     * @return the paymentAmount
     */
    public int getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * @return the paymentDiscreption
     */
    public String getPaymentDiscreption() {
        return paymentDiscreption;
    }

    /**
     * @param paymentDiscreption the paymentDiscreption to set
     */
    public void setPaymentDiscreption(String paymentDiscreption) {
        this.paymentDiscreption = paymentDiscreption;
    }
    
    
}
