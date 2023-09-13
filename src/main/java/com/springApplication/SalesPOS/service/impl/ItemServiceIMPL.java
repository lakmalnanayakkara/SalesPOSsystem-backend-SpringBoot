package com.springApplication.SalesPOS.service.impl;

import com.springApplication.SalesPOS.dto.request.ItemSaveRequestDTO;
import com.springApplication.SalesPOS.dto.response.ItemGetResponseDTO;
import com.springApplication.SalesPOS.entity.Customer;
import com.springApplication.SalesPOS.entity.Item;
import com.springApplication.SalesPOS.repo.ItemRepo;
import com.springApplication.SalesPOS.service.ItemService;
import com.springApplication.SalesPOS.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);
        if(!itemRepo.existsById(item.getItemID())){
            itemRepo.save(item);
            return item.getItemID() +" "+"Saved Successfully";
        }else{
            throw new DuplicateKeyException("Already Added");
        }
    }

    @Override
    public ItemGetResponseDTO getItemByName(String itemName) {
        Item item = itemRepo.getItemByItemName(itemName);
        if(item.isActiveState() == true){
            ItemGetResponseDTO itemGetResponseDTO = modelMapper.map(item, ItemGetResponseDTO.class);
            return itemGetResponseDTO;
        }else {
            throw new DuplicateKeyException(itemName+" "+"Not Active");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemListByNameWithMappsStruct(String itemName) {
        List<Item> item = itemRepo.getItemListByItemName(itemName);
        if(item.size()>0){
            List<ItemGetResponseDTO> itemGetResponseDTOList = itemMapper.entityToItemDTOList(item);
            return itemGetResponseDTOList;
        }
        throw new DuplicateKeyException(itemName+" "+"Not Active");
    }

}
