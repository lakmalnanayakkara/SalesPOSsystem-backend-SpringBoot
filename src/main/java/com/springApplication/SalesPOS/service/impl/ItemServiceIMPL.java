package com.springApplication.SalesPOS.service.impl;

import com.springApplication.SalesPOS.dto.request.ItemSaveRequestDTO;
import com.springApplication.SalesPOS.entity.Item;
import com.springApplication.SalesPOS.repo.ItemRepo;
import com.springApplication.SalesPOS.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);
        if(!itemRepo.existsById(item.getItemID())){
            itemRepo.save(item);
            return item.getItemID() + "Saved Successfully";
        }
        return "Item already added";
    }
}
