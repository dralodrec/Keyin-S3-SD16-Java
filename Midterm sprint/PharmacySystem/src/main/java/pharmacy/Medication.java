package pharmacy;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a medication stored by the pharmacy.
 */
public class Medication {
    private int id;
    private String name;
    private String dose;
    private int quantityInStock;
    private LocalDate expiryDate;

    public Medication(int id, String name, String dose, int quantityInStock, LocalDate expiryDate) {
        this.id = id;
        this.name = name;
        this.dose = dose;
        this.quantityInStock = quantityInStock;
        this.expiryDate = expiryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = Math.max(0, quantityInStock);
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    public void restock(int amount) {
        if (amount > 0) {
            quantityInStock += amount;
        }
    }

    public boolean reduceStock(int amount) {
        if (amount <= 0) {
            return false;
        }
        if (quantityInStock >= amount) {
            quantityInStock -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "ID: " + id +
                ", Name: " + name +
                ", Dose: " + dose +
                ", Stock: " + quantityInStock +
                ", Expiry: " + expiryDate +
                ", Expired: " + (isExpired() ? "YES" : "NO") +
                "}";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Medication)) {
            return false;
        }
        Medication that = (Medication) object;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
