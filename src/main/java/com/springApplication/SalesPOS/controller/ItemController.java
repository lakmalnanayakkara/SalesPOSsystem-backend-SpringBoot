package com.springApplication.SalesPOS.controller;

import com.springApplication.SalesPOS.dto.request.ItemSaveRequestDTO;
import com.springApplication.SalesPOS.dto.response.ItemGetResponseDTO;
import com.springApplication.SalesPOS.service.ItemService;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save")
    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
        String message = itemService.saveItem(itemSaveRequestDTO);
        return message;
    }
    @GetMapping(
            path = "/get-by-name",
            params = "name")
    public ItemGetResponseDTO getItemByItemName(@RequestParam(value = "name") String ItemName){
        System.out.println(ItemName);
        ItemGetResponseDTO itemGetResponseDTO = itemService.getItemByName(ItemName);
        return itemGetResponseDTO;
    }
}
