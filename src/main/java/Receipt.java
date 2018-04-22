
public class Receipt {

    private String receiptMessage;

    public Receipt(String receiptMessage) {
        this.receiptMessage = receiptMessage;
    }

    public String getReceiptMessage() {
        return receiptMessage;
    }

    public static Receipt forSuccessfulCharge(Double amount) {
        return new Receipt("Receipt: Received " + amount);
    }

    public static Receipt forDeclinedCharge(String declineMessage) {
        return new Receipt(declineMessage);
    }

    public static Receipt forSystemFailure(String message) {
        return  new Receipt(message);
    }
}
