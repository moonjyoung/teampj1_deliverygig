package com.deliverygig.moonjyoung.repository.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deliverygig.moonjyoung.entity.food.FoodMenuInfoEntity;
import com.deliverygig.moonjyoung.entity.food.FoodMenuOptionEntity;
import com.deliverygig.moonjyoung.entity.food.FoodOptionConnectEntity;

@Repository
public interface FoodOptionConnectRepository extends JpaRepository<FoodOptionConnectEntity, Long> {
    // public FoodMenuInfoEntity findByFocFmiSeq();
    // public FoodMenuOptionEntity findByFocFmoSeq();
}