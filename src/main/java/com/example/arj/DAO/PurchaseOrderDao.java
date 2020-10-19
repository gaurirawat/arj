package com.example.arj.DAO;

import com.example.arj.models.PurchaseOrder;
import com.example.arj.repositories.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PurchaseOrderDao implements Dao<PurchaseOrder> {

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public PurchaseOrder find(Integer id) {
        return purchaseOrderRepository.getOne(id);
    }

    @Override
    public List<PurchaseOrder> findAll() {
        return purchaseOrderRepository.findAll();
    }

    @Override
    public PurchaseOrder save(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public PurchaseOrder update(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public void delete(PurchaseOrder purchaseOrder) {
        purchaseOrderRepository.deleteById(purchaseOrder.getId());
    }

    @Override
    public void delete(Integer id) {
        purchaseOrderRepository.deleteById(id);
    }
}
