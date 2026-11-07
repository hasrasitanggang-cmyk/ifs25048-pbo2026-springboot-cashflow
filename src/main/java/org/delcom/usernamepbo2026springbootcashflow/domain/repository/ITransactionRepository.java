package org.delcom.usernamepbo2026springbootcashflow.domain.repository;

import org.delcom.usernamepbo2026springbootcashflow.domain.entity.Transaction;

/** Port spesifik Transaction, menambahkan penyimpanan dengan ID otomatis. */
public interface ITransactionRepository extends IRepository<Transaction, Integer> {
    /** Menyimpan pemasukan baru dan mengembalikannya lengkap dengan ID. */
    Transaction saveIncome(String description, double amount);

    /** Menyimpan pengeluaran baru dan mengembalikannya lengkap dengan ID. */
    Transaction saveExpense(String description, double amount);
}
