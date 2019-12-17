package com.haiyu.manager.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class UserTaskDTO {

    private Integer id;


    private String task_number;


    private int user_id;


    private String website;


    private int typee;


    private int status;


    private String subTime;


    private String startTime;


    private String endTime;
}
