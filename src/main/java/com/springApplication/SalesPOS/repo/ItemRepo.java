package com.springApplication.SalesPOS.repo;

import com.springApplication.SalesPOS.entity.Customer;
import com.springApplication.SalesPOS.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Integer> {
    Item getItemByItemName(String itemName);
}