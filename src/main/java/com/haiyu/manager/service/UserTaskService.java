package com.haiyu.manager.service;

import com.haiyu.manager.pojo.UserTask;
import com.haiyu.manager.dto.UserTaskSearchDTO;
import com.haiyu.manager.response.PageDataResult;

import java.util.Map;


/**
 * @Title: AdminUserService
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/11/21 11:04
 */
public interface UserTaskService {

    PageDataResult getUserTaskList(UserTaskSearchDTO userTaskSearch, Integer pageNum, Integer pageSize);

    Map<String,Object> addUserTask(UserTask userTask);

    Map<String,Object> updateUserTask(UserTask userTask);

    UserTask  getUserTaskById(Integer id);

    Map<String, Object> delUserTask(Integer id,Integer status);

    Map<String, Object> recoverUserTask(Integer id,Integer status);
}
