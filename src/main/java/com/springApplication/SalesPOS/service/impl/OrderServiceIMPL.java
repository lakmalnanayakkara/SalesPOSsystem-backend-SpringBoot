package com.springApplication.SalesPOS.service.impl;

import com.springApplication.SalesPOS.dto.request.OrderSaveRequestDTO;
import com.springApplication.SalesPOS.entity.OrderDetails;
import com.springApplication.SalesPOS.entity.Orders;
import com.springApplication.SalesPOS.repo.CustomerRepo;
import com.springApplication.SalesPOS.repo.ItemRepo;
import com.springApplication.SalesPOS.repo.OrderDetailsRepo;
import com.springApplication.SalesPOS.repo.OrderRepo;
import com.springApplication.SalesPOS.service.OrderService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    @Transactional
    public String addOrders(OrderSaveRequestDTO orderSaveRequestDTO) {
        Orders orders = new Orders(
                customerRepo.getReferenceById(orderSaveRequestDTO.getCustomer()),
                orderSaveRequestDTO.getDate(),
                orderSaveRequestDTO.getTotAmount()
        );
        orderRepo.save(orders);

       /* List<OrderDetails> orderDetailsList = new ArrayList<>();
        for(OrderDetailSaveRequestDTO orderDetailSaveRequestDTO : orderSaveRequestDTO.getOrderDetailSaveRequestDTOList()){
            OrderDetails orderDetails = new OrderDetails(
                    orderDetailSaveRequestDTO.getItemName(),
                    orderDetailSaveRequestDTO.getQty(),
                    orderDetailSaveRequestDTO.getAmount(),
                    itemRepo.getReferenceById(orderDetailSaveRequestDTO.getItem()),
                    orderRepo.getReferenceById(orders.getOrderID())
            );
            orderDetailsRepo.save(orderDetails);
        }*/
        List<OrderDetails> orderDetails = modelMapper.map(
                orderSaveRequestDTO.getOrderDetailSaveRequestDTOList(),
                new TypeToken<List<OrderDetails>>(){}.getType());

        for(int i=0;i<orderDetails.size();i++){
            orderDetails.get(i).setOrders(orders);
            orderDetails.get(i).setItem(itemRepo.getReferenceById(orderSaveRequestDTO.getOrderDetailSaveRequestDTOList().get(i).getItem()));
        }
        orderDetailsRepo.saveAll(orderDetails);
        return "Save Successful";
    }
}
