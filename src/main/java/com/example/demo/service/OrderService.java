package com.example.demo.service;

/**
 * 订单service
 *
 * @author yihe.gao
 */
public interface OrderService {
    /**
     * 订单发货
     *
     * @param orderId 订单id
     */
    void deliver(int orderId);

    /**
     * 订单发货发短信
     *
     * @param deliverId 订单发货id
     */
    void sendMessage(int deliverId);

}
