package com.iteratrlearning.shu_book.chapter_02;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {

                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public List<BankTransaction> findMaxBankTransactionInDate(LocalDate startDate, LocalDate endDate) {
        final long startTimestamp = Timestamp.valueOf(LocalDateTime.of(startDate, LocalTime.MIN)).getTime();
        final long endTimestamp = Timestamp.valueOf(LocalDateTime.of(endDate, LocalTime.MAX)).getTime();

        List<BankTransaction> bankTransactionList = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            final long timestamp = Timestamp.valueOf(LocalDateTime.of(bankTransaction.getDate(), LocalTime.MIN)).getTime();
            if (startTimestamp <= timestamp && timestamp < endTimestamp) {
                bankTransactionList.add(bankTransaction);
            }
        }

        return bankTransactionList;
    }


}
