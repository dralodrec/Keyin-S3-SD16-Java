
public class CreditCard {
    private Money balance;
    private Money creditLimit;
    private Person owner;

    
    public CreditCard(Person newCardHolder, Money limit) {
        if (newCardHolder == null || limit == null) {
            throw new IllegalArgumentException("Owner and credit limit cannot be null.");
        }
        owner = newCardHolder;
        creditLimit = new Money(limit);
        balance = new Money(0);
    }

   
    public Money getBalance() {
        return new Money(balance);
    }

    
    public Money getCreditLimit() {
        return new Money(creditLimit);
    }

    
    public String getPersonals() {
        return owner.toString();
    }

    
    public void charge(Money amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Charge amount cannot be null.");
        }

        Money newBalance = balance.add(amount);
        if (newBalance.compareTo(creditLimit) <= 0) {
            balance = newBalance;
            System.out.println("Charge: " + amount);
        } else {
            System.out.println("Exceeds credit limit");
        }
    }

    
    public void payment(Money amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Payment amount cannot be null.");
        }

        if (amount.compareTo(balance) > 0) {
            System.out.println("Payment exceeds balance");
        } else {
            balance = balance.subtract(amount);
            System.out.println("Payment: " + amount);
        }
    }
}
