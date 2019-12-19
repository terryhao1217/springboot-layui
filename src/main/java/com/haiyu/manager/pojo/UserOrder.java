package com.haiyu.manager.pojo;

import lombok.Data;
import javax.persistence.*;

@Table(name = "user_order")
@Data
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "pay_amount")
    private String payAmount;

    @Column(name = "task_id")
    private String taskId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "status")
    private String status;

    @Column(name = "pay_time")
    private String payTime;

    @Column(name = "create_time")
    private String createTime;
}
