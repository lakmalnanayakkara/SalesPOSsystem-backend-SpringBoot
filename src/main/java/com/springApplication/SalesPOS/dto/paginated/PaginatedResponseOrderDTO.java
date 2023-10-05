package com.springApplication.SalesPOS.dto.paginated;

import com.springApplication.SalesPOS.dto.response.ResponseOrderDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseOrderDTO {
    private List<ResponseOrderDetailsDTO> responseOrderDetailsDTOS;
    private long count;
}
