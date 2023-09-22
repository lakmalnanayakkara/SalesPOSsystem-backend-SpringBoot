package com.springApplication.SalesPOS.service.impl;

import com.springApplication.SalesPOS.dto.paginated.PaginatedResponseItemDTO;
import com.springApplication.SalesPOS.dto.request.ItemSaveRequestDTO;
import com.springApplication.SalesPOS.dto.response.ItemGetResponseDTO;
import com.springApplication.SalesPOS.entity.Item;
import com.springApplication.SalesPOS.repo.ItemRepo;
import com.springApplication.SalesPOS.service.ItemService;
import com.springApplication.SalesPOS.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public PaginatedResponseItemDTO getItemListByAtiveStatus(boolean activeStatus, int page, int size) {
        Page<Item> items = itemRepo.findAllByActiveStateEquals(activeStatus, PageRequest.of(page, size));
        List<ItemGetResponseDTO> itemGetResponseDTOList = itemMapper.pageListToResponseList(items);
        int count = itemRepo.countAllByActiveStateEquals(activeStatus);
        PaginatedResponseItemDTO paginatedResponseItemDTO = new PaginatedResponseItemDTO(
                itemGetResponseDTOList,
                count
        );
        return paginatedResponseItemDTO;
    }

}
