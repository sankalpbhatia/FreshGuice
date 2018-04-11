import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceTest {

    public static void main(String[] args) {
    /*
     * Guice.createInjector() takes your Modules, and returns a new Injector
     * instance. Most applications will call this method exactly once, in their
     * main() method.
     */
        Injector injector = Guice.createInjector(new BillingModule());
    /*
     * Now that we've got the injector, we can build objects.
     */
        BillingService billingService = injector.getInstance(BillingService.class);

        PizzaOrder pizzaOrder = new PizzaOrder("Very-Veggie", 100d);

        CreditCard creditCard = new CreditCard("12345");

        Receipt receipt = billingService.chargeOrder(pizzaOrder, creditCard);

        System.out.println(receipt.getReceiptMessage());
    }
}
