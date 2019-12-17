package com.haiyu.manager.pojo;

import lombok.Data;
import javax.persistence.*;


@Table(name = "user_task")
@Data
public class UserTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "task_number")
    private String task_number;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "website")
    private String website;

    @Column(name = "typee")
    private int typee;

    @Column(name = "status")
    private int status;

    @Column(name = "sub_time")
    private String subTime;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

}
