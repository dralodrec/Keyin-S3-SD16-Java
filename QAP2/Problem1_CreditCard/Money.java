
public class Money implements Comparable<Money> {
    private long dollars;
    private long cents;

    
    public Money(double amount) {
        long totalCents = Math.round(amount * 100);
        this.dollars = totalCents / 100;
        this.cents = Math.abs(totalCents % 100);
    }

    
    public Money(Money otherAmount) {
        if (otherAmount == null) {
            throw new IllegalArgumentException("Money object cannot be null.");
        }
        this.dollars = otherAmount.dollars;
        this.cents = otherAmount.cents;
    }

  
    public Money add(Money otherAmount) {
        if (otherAmount == null) {
            throw new IllegalArgumentException("Money object cannot be null.");
        }
        return fromTotalCents(this.toTotalCents() + otherAmount.toTotalCents());
    }

    
    public Money subtract(Money otherAmount) {
        if (otherAmount == null) {
            throw new IllegalArgumentException("Money object cannot be null.");
        }
        return fromTotalCents(this.toTotalCents() - otherAmount.toTotalCents());
    }

    
    @Override
    public int compareTo(Money otherAmount) {
        if (otherAmount == null) {
            throw new IllegalArgumentException("Money object cannot be null.");
        }
        return Long.compare(this.toTotalCents(), otherAmount.toTotalCents());
    }

    
    public boolean equals(Money otherAmount) {
        return otherAmount != null && this.toTotalCents() == otherAmount.toTotalCents();
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Money)) {
            return false;
        }
        Money otherAmount = (Money) obj;
        return this.equals(otherAmount);
    }

    
    @Override
    public int hashCode() {
        return Long.hashCode(toTotalCents());
    }

    
    @Override
    public String toString() {
        long totalCents = toTotalCents();
        String sign = totalCents < 0 ? "-" : "";
        long absoluteCents = Math.abs(totalCents);
        return String.format("%s$%d.%02d", sign, absoluteCents / 100, absoluteCents % 100);
    }

    
    private long toTotalCents() {
        long sign = dollars < 0 ? -1 : 1;
        return dollars * 100 + sign * cents;
    }

    
    private static Money fromTotalCents(long totalCents) {
        Money result = new Money(0);
        result.dollars = totalCents / 100;
        result.cents = Math.abs(totalCents % 100);
        return result;
    }
}
