# FreshGuice
A hands on practice package for Google Guice. 

This maven project implements a BillingService which charges a PizzaOrder using a CreditCard and generated a Receipt.
See classes in package for more details.

### Interfaces
* BillingService - charges an order using a credit card
* CreditCardProcessor - debits some amount from credit card
* TransactionLog - logs results
### Classes
**src**
* CreditCard - entity representing a Credit Card
* PizzaOrder - entity representing a Pizza order
* Receipt - entity representing a receipt
* RealBillingService implements BillingService
* PaypalCreditCardProcessor implements CreditCardProcessor
* BankCreditCardProcessor implements CreditCardProcessor
* InMemoryTransactionLog implements TransactionLog
* GuiceTest - Main class which uses BillingService
* BillingModule - All Guice bindings go here

**tst** 
* GuiceInjectionTest : Unit tests to check binding constraints

### Task
The task here is to create Guice Bindings in the BillingModule such that the following constraints are satisfied: 

1. All implementations of BillingService should be bound to RealBillingService.
2. CreditCardProcessor interface annotated with @Paypal should be bound to PaypalCreditCardProcessor class.
3. CreditCardProcessor interface named with string “Bank” should be bound to BankCreditCardProcessor class.
4. BillingService instances returned by injector should have instance of BankCreditCardProcessor as their dependency.
5. All implementations of TransactionLog should be bound to InMemoryTransactionLog.

All 5 unit tests in GuiceInjectionTests should pass if the above conditions are satisfied.
You should also be able to run the main method in GuiceTest. 
 
For now, [this](https://github.com/google/guice/wiki/GettingStarted) is the user guide to follow. 

 




