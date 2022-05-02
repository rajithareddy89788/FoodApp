package com.mouritech.onlinefoodorderapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.entity.FoodCart;
import com.mouritech.onlinefoodorderapplication.entity.FoodCartItems;

@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart, Long>  {
	List<FoodCart> findAllByCustomer(Customer customer);

	void save(FoodCartItems cart);

    List<FoodCart> deleteByCustomer(Customer customer);
    //List<FoodCart> findAllByCustomer(Customer customer);
}
