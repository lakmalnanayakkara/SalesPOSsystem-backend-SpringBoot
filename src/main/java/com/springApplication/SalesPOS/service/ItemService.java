package com.springApplication.SalesPOS.service;

import com.springApplication.SalesPOS.dto.request.ItemSaveRequestDTO;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);
}
