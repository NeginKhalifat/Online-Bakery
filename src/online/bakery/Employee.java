/*
 * Delivery employees information.
 */
package online.bakery;

import java.util.Date;

import online.bakery.Type.Role;
import online.bakery.sweets.Rate;

/**
 *
 * @author salidotir
 */
public class Employee extends Account{
    private boolean isBusy;
    private float score;
    private int numOfPeopleWhoScored = 0;
    
    public Employee(String username, String password,String FirstName, String LastName) {
        super();
        super.SignUp(username, password, Role.EMPLOYEE);
        super.setFirstname(FirstName);
        super.setLastname(LastName);
        this.score = 0;
        this.isBusy = false;
        Admin.getInstance().createEmploee(this); 
    }

    @Override
    public String getProfile() {
        return super.getProfile() + "Score: " + score + "\nis busy: " + isBusy + "\n";
    }

    /**
     * @return the score
     */
    public float getScore() {
        return score;
    }
    
     /**
     * @return the id
     */
    public int getNumOfPeopleWhoScored() {
        return this.numOfPeopleWhoScored;
    }
    
    public boolean recievOrder(Order order) {
        // this employee is assinged to a delivery
        this.setIsBusy(true);
        System.out.println("Customer with id " + this.getID() +" has received an order to ship.");
        return true;
    }

    public boolean deliverOrder(Order order) {
        this.setIsBusy(false);
        Date actuall = new Date();
        order.finishOrder(actuall, this);
        Admin.getInstance().deliverOrder(order, actuall);
        return true;
    }
    
    public boolean ruineOrder(Order order) {
        this.setIsBusy(false);
        order.ruinByEmployee();
        Admin.getInstance().ruinOrder(order);
        
        // employee must pay the loss
        // To be completed //
        
        return true;
    }

    /**
     * @return the isBusy
     */
    public boolean isIsBusy() {
        return isBusy;
    }

    /**
     * @param isBusy the isBusy to set
     */
    public void setIsBusy(boolean isBusy) {
        this.isBusy = isBusy;
    }
    
    /**
     * @param rate the score to set
     */
    public float addScore(Rate rate) {
        float newScore = 0;
        if(null != rate) switch (rate) {
            case ONE:
                newScore = 1;
                break;
            case TWO:
                newScore = 2;
                break;
            case THREE:
                newScore = 3;
                break;
            case FOUR:
                newScore = 4;
                break;
            case FIVE:
                newScore = 5;
                break;
            default:
                break;
        }
        
        this.score = (this.score*this.numOfPeopleWhoScored + newScore) / (this.numOfPeopleWhoScored + 1);
        this.numOfPeopleWhoScored += 1;
        return this.score;
    }
    
    public boolean addNote(Order order, String text) {
        order.addNote(this, text);
        return true;
    }
}
