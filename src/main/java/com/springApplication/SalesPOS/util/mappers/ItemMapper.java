package com.springApplication.SalesPOS.util.mappers;

import com.springApplication.SalesPOS.dto.response.ItemGetResponseDTO;
import com.springApplication.SalesPOS.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ItemMapper {

    List<ItemGetResponseDTO> entityToItemDTOList(List<Item> items);
}
