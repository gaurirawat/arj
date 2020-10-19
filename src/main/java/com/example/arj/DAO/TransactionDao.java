package com.example.arj.DAO;

import com.example.arj.Models.Transaction;
import com.example.arj.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionDao implements Dao<Transaction> {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction find(Integer id) {
        return transactionRepository.getOne(id);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction update(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
