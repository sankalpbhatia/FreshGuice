/**
 * @author sankal
 */
public class ChargeResult {

    private boolean wasSuccessful;
    private Double amount;

    public ChargeResult(boolean wasSuccessful, Double amount) {
        this.wasSuccessful = wasSuccessful;
        this.amount = amount;
    }

    public boolean wasSuccessful() {
        return wasSuccessful;
    }

    public Double getAmount() {
        return amount;
    }

    public String getDeclineMessage() {
        if(!wasSuccessful) {
            return "Declined transaction";
        }
        return "";
    }
}
