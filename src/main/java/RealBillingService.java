/**
 * Real billing service implementation
 */

public class RealBillingService implements BillingService {

    private  CreditCardProcessor processor;
    private  TransactionLog transactionLog;

    /**
     * @param processor processor
     * @param transactionLog transactionLog
     */

    public RealBillingService(CreditCardProcessor processor, TransactionLog transactionLog) {
        this.processor = processor;
        this.transactionLog = transactionLog;
    }

    public CreditCardProcessor getProcessor() {
        return processor;
    }

    public TransactionLog getTransactionLog() {
        return transactionLog;
    }

    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        try {
            ChargeResult result = processor.charge(creditCard, order.getAmount());
            transactionLog.logChargeResult(result);

            return result.wasSuccessful()
                   ? Receipt.forSuccessfulCharge(order.getAmount())
                   : Receipt.forDeclinedCharge(result.getDeclineMessage());
        } catch (RuntimeException e) {
            transactionLog.logException(e);
            return Receipt.forSystemFailure(e.getMessage());
        }
    }

}
