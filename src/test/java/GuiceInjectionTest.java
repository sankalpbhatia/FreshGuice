import annotations.Paypal;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import org.junit.Assert;
import org.junit.Test;


public class GuiceInjectionTest {

    private static final Injector injector = Guice.createInjector(new BillingModule());

    @Test
    public void TestBillingServiceInstanceOfRealBillingService() {
        BillingService billingService = injector.getInstance(BillingService.class);

        Assert.assertTrue(billingService instanceof RealBillingService);
    }

    @Test
    public void TestCreditCardProcessorInstanceOfPaypalCCProcessor() {
        CreditCardProcessor creditCardProcessor =
                injector.getInstance(Key.get(CreditCardProcessor.class, Paypal.class));

        Assert.assertTrue(creditCardProcessor instanceof PaypalCreditCardProcessor);
    }

    @Test
    public void TestCreditCardProcessorInstanceOfBankCCProcessor() {
        CreditCardProcessor creditCardProcessor =
                injector.getInstance(Key.get(CreditCardProcessor.class, Names.named("Bank")));

        Assert.assertTrue(creditCardProcessor instanceof BankCreditCardProcessor);
    }

    @Test
    public void TestBillingServiceHasBankCardProcessor() {
        RealBillingService billingService = (RealBillingService) injector.getInstance(BillingService.class);

        Assert.assertTrue(billingService.getProcessor() instanceof BankCreditCardProcessor);
    }

    @Test
    public void TestTransactionLogInstanceOfInMemory() {
        TransactionLog transactionLog = injector.getInstance(TransactionLog.class);

        Assert.assertTrue(transactionLog instanceof InMemoryTransactionLog);
    }
}
