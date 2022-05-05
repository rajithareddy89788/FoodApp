package com.mouritech.onlinefoodorderapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinefoodorderapplication.dto.ItemDto2;
import com.mouritech.onlinefoodorderapplication.entity.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long> {

	void deleteByItemName(String itemName);

	Items findByItemName(String itemName);
	@Query("SELECT r FROM Items r WHERE r.itemName LIKE %?1%")
	List<ItemDto2> searchByItemName(String itemName);

}
