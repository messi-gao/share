package com.example.demo.dao;

import com.example.demo.entity.TOrderDeliverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TOrderRepository
 *
 * @author yihe.gao
 */
@Repository
public interface TOrderRepository extends JpaRepository<TOrderDeliverEntity, Integer> {
}
