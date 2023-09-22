package com.springApplication.SalesPOS.dto.paginated;

import com.springApplication.SalesPOS.dto.response.ItemGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDTO {
    List<ItemGetResponseDTO> itemGetResponseDTOList;
    int count;
}
