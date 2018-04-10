public class InMemoryTransactionLog implements TransactionLog {
    @Override
    public void logChargeResult(ChargeResult chargeResult) {
        System.out.println("Charge has been processed for " + chargeResult.getAmount());
    }

    @Override
    public void logException(RuntimeException e) {
        e.printStackTrace();
    }
}
