package com.springApplication.SalesPOS.controller;

import com.springApplication.SalesPOS.dto.request.ItemSaveRequestDTO;
import com.springApplication.SalesPOS.dto.response.ItemGetResponseDTO;
import com.springApplication.SalesPOS.service.ItemService;
import com.springApplication.SalesPOS.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
        String message = itemService.saveItem(itemSaveRequestDTO);
        ResponseEntity<StandardResponse> response = new ResponseEntity<>(
                new StandardResponse(200, "success", message),
                HttpStatus.OK
        );
        return response;
    }
    @GetMapping(
            path = "/get-by-name",
            params = "name")
    public ResponseEntity<StandardResponse> getItemByItemName(@RequestParam(value = "name") String ItemName){
        ItemGetResponseDTO itemGetResponseDTO = itemService.getItemByName(ItemName);
        ResponseEntity<StandardResponse> response = new ResponseEntity<>(
                new StandardResponse(200, "success", itemGetResponseDTO),
                HttpStatus.OK
        );
        return response;
    }
    @GetMapping(
            path = "/getByName",
            params = "name"
    )
    public ResponseEntity<StandardResponse> getItemListByNameWithMappsStruct(@RequestParam(value = "name") String ItemName){
        List<ItemGetResponseDTO> itemGetResponseDTOList = itemService.getItemListByNameWithMappsStruct(ItemName);
        ResponseEntity<StandardResponse> response = new ResponseEntity<>(
                new StandardResponse(200, "success", itemGetResponseDTOList),
                HttpStatus.OK
        );
        return response;
    }
}
