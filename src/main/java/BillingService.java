import com.google.inject.ImplementedBy;

/**
 * Billing Service.
 */
@ImplementedBy(RealBillingService.class)
public interface BillingService {

    /**
     *
     * @param order order
     * @param creditCard cc
     * @return Receipt
     */
    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
