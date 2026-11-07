package org.delcom.usernamepbo2026springbootcashflow.domain.entity;

import java.time.LocalDateTime;

/**
 * Entity inti yang merepresentasikan satu transaksi keuangan.
 * Berada di layer domain, bebas dari urusan tampilan dan penyimpanan.
 */
public class Transaction {
    /** ID unik, tidak boleh berubah setelah dibuat. */
    private final int id;

    private String description;
    private double amount;
    private final TransactionType type;
    private final LocalDateTime createdAt;

    public Transaction(int id, String description, double amount, TransactionType type) {
        this(id, description, amount, type, LocalDateTime.now());
    }

    public Transaction(int id, String description, double amount, TransactionType type, LocalDateTime createdAt) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isIncome() {
        return type == TransactionType.INCOME;
    }

    /** Dampak transaksi terhadap saldo: positif untuk pemasukan, negatif untuk pengeluaran. */
    public double signedAmount() {
        return isIncome() ? amount : -amount;
    }

    public void changeDescription(String description) {
        this.description = description;
    }

    public void changeAmount(double amount) {
        this.amount = amount;
    }
}
