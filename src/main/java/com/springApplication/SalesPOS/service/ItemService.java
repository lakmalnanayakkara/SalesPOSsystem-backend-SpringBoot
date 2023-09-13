package com.springApplication.SalesPOS.service;

import com.springApplication.SalesPOS.dto.request.ItemSaveRequestDTO;
import com.springApplication.SalesPOS.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);


    ItemGetResponseDTO getItemByName(String itemName);

    List<ItemGetResponseDTO> getItemListByNameWithMappsStruct(String itemName);
}
