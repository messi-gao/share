package com.example.demo.dao;

import com.example.demo.entity.TOrderDeliverMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TOrderDeliverMessageRepository
 *
 * @author yihe.gao
 */
@Repository
public interface TOrderDeliverMessageRepository extends JpaRepository<TOrderDeliverMessageEntity, Integer> {
}
