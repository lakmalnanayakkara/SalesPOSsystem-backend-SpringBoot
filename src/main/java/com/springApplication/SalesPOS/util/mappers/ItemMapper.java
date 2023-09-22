package com.springApplication.SalesPOS.util.mappers;

import com.springApplication.SalesPOS.dto.paginated.PaginatedResponseItemDTO;
import com.springApplication.SalesPOS.dto.response.ItemGetResponseDTO;
import com.springApplication.SalesPOS.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ItemMapper {

    List<ItemGetResponseDTO> entityToItemDTOList(List<Item> items);

    List<ItemGetResponseDTO> pageListToResponseList(Page<Item> items);
}
