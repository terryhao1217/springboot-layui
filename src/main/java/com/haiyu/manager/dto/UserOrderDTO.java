package com.haiyu.manager.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserOrderDTO {

    private Integer id;


    private String orderNumber;


    private String payAmount;

    private String taskId;

    private String userId;

    private String status;

    private String payTime;

    private String createTime;
}
