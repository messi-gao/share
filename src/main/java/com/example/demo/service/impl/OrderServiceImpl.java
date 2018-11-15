package com.example.demo.service.impl;

import com.example.demo.dao.TOrderDeliverMessageRepository;
import com.example.demo.dao.TOrderRepository;
import com.example.demo.entity.TOrderDeliverEntity;
import com.example.demo.entity.TOrderDeliverMessageEntity;
import com.example.demo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单service实现类
 *
 * @author yihe.gao
 */
@Service
public class OrderServiceImpl implements OrderService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TOrderDeliverMessageRepository orderDeliverMessageRepository;
    @Autowired
    private TOrderRepository orderRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deliver(int orderId) {
        TOrderDeliverEntity tOrderDeliverEntity = new TOrderDeliverEntity();
        tOrderDeliverEntity.setOrderId(orderId);
        tOrderDeliverEntity.setDeliverStatus(1);
        orderRepository.save(tOrderDeliverEntity);

        try {
            OrderService orderService = (OrderService) AopContext.currentProxy();
            orderService.sendMessage(tOrderDeliverEntity.getId());
        } catch (Exception e) {
            logger.error("dddddddddddddd");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void sendMessage(int deliverId) {
        // 保存信息到本地数据库
        TOrderDeliverMessageEntity tOrderDeliverMessageEntity = new TOrderDeliverMessageEntity();
        tOrderDeliverMessageEntity.setMessageContent("您的秋裤发货了");
        tOrderDeliverMessageEntity.setDeliverId(deliverId);
        orderDeliverMessageRepository.save(tOrderDeliverMessageEntity);

        // 第三方系统发短信。。。
        throw new RuntimeException("发送短信失败了。。。。。。");
    }
}
