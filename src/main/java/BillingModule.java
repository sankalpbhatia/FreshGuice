import annotations.Paypal;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;


public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CreditCardProcessor.class).annotatedWith(Paypal.class).to(PaypalCreditCardProcessor.class);
        bind(CreditCardProcessor.class).annotatedWith(Names.named("Bank")).to(BankCreditCardProcessor.class);
        bind(CreditCardProcessor.class).to(BankCreditCardProcessor.class);
        bind(TransactionLog.class).to(InMemoryTransactionLog.class);
    }

    //.. or here!

    @Provides
    @Singleton
    public BillingService getBillingService(CreditCardProcessor ccp, TransactionLog transactionLog) {
        return new RealBillingService(ccp, transactionLog);
    }
}
