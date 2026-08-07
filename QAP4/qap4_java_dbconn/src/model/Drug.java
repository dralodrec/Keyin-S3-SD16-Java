package com.qap4.model;

import java.math.BigDecimal;
import java.util.Objects;

/** Represents a drug saved in the text file. */
public class Drug {
    private final int drugId;
    private final String drugName;
    private final BigDecimal drugCost;
    private final String dosage;

    public Drug(int drugId, String drugName, BigDecimal drugCost, String dosage) {
        if (drugId <= 0) {
            throw new IllegalArgumentException("Drug ID must be greater than zero.");
        }
        if (drugName == null || drugName.isBlank()) {
            throw new IllegalArgumentException("Drug name is required.");
        }
        if (drugCost == null || drugCost.signum() < 0) {
            throw new IllegalArgumentException("Drug cost cannot be negative.");
        }
        if (dosage == null || dosage.isBlank()) {
            throw new IllegalArgumentException("Dosage is required.");
        }

        this.drugId = drugId;
        this.drugName = drugName.trim();
        this.drugCost = drugCost;
        this.dosage = dosage.trim();
    }

    public int getDrugId() {
        return drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public BigDecimal getDrugCost() {
        return drugCost;
    }

    public String getDosage() {
        return dosage;
    }

    @Override
    public String toString() {
        return String.format(
                "Drug{id=%d, name='%s', cost=$%s, dosage='%s'}",
                drugId,
                drugName,
                drugCost.setScale(2, java.math.RoundingMode.HALF_UP),
                dosage
        );
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Drug drug)) return false;
        return drugId == drug.drugId
                && drugName.equals(drug.drugName)
                && drugCost.compareTo(drug.drugCost) == 0
                && dosage.equals(drug.dosage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drugId, drugName, drugCost.stripTrailingZeros(), dosage);
    }
}
