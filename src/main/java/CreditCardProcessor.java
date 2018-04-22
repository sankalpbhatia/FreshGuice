
public interface CreditCardProcessor {

    ChargeResult charge(CreditCard creditCard, Double amount);
}
