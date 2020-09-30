package com.baton.vm.service;

import com.baton.vm.model.Inventory;

import java.util.List;

public interface VendingMachineService {
    public List<Inventory> getAllItems();
    public Inventory getItemById(int invId);
    public void updateStock(int invId);
}
