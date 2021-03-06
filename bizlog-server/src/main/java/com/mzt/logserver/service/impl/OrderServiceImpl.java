package com.mzt.logserver.service.impl;

import com.mzt.logapi.starter.annotation.LogRecordAnnotation;
import com.mzt.logserver.beans.Order;
import com.mzt.logserver.constants.LogRecordType;
import com.mzt.logserver.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author muzhantong
 * create on 2020/6/12 11:08 上午
 */
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    /*'张三下了一个订单,购买商品「超值优惠红烧肉套餐」,下单结果:true' */
    @Override
    @LogRecordAnnotation(
            fail = "创建订单失败，失败原因：「{{#_errorMsg}}」",
            category = "MANAGER_VIEW",
            detail = "{{#order.toString()}}",
            operator = "{{#currentUser}}",
            success = "{{#order.purchaseName}}下了一个订单,购买商品「{{#order.productName}}」,下单结果:{{#_ret}}",
            prefix = LogRecordType.ORDER, bizNo = "{{#order.orderNo}}")
    public boolean createOrder(Order order) {
        log.info("【创建订单】orderNo={}", order.getOrderNo());
        // db insert order
        return true;
    }

    @Override
    @LogRecordAnnotation(success = "更新了订单ORDER{#orderId}},更新内容为...",
            prefix = LogRecordType.ORDER, bizNo = "{{#order.orderNo}}",
            detail = "{{#order.toString()}}")
    public boolean update(Long orderId, Order order) {
        return false;
    }
}
