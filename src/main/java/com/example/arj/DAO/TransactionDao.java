package com.example.arj.DAO;

import com.example.arj.models.Transaction;
import com.example.arj.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    @Override
    public void delete(Transaction transaction) {
        transactionRepository.deleteById(transaction.getId());
    }

    @Override
    public void delete(Integer id) {
        transactionRepository.deleteById(id);
    }
}