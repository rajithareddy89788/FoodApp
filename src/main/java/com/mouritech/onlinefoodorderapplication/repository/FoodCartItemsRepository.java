package com.mouritech.onlinefoodorderapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.entity.FoodCartItems;
import com.mouritech.onlinefoodorderapplication.entity.Items;

@Repository
public interface FoodCartItemsRepository extends JpaRepository<FoodCartItems, Long>  {
	List<FoodCartItems> findAllByCustomer(Customer customer);
	FoodCartItems findByItems1AndCustomer(Items items,  Customer customer);

}
