public class PizzaOrder {

    private String type;
    private Double amount;

    public PizzaOrder(String type, Double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public Double getAmount() {
        return amount;
    }

}
