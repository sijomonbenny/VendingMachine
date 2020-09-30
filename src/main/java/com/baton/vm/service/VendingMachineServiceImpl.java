package com.baton.vm.service;

import com.baton.vm.model.Inventory;
import com.baton.vm.repository.VendingMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("inventory_service")
public class VendingMachineServiceImpl implements VendingMachineService {
    @Autowired
    VendingMachineRepository vmRepo;

    @Override
    public List<Inventory> getAllItems() {
        return vmRepo.findAll();
    }

    @Override
    public Inventory getItemById(int invId) {
        return vmRepo.findById((invId)).orElse(null);
    }

    @Override
    public void updateStock(int invId) {
        vmRepo.updateStock(invId);
    }
}
