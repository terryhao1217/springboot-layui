package com.haiyu.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haiyu.manager.common.utils.DigestUtils;
import com.haiyu.manager.dto.UserTaskDTO;
import com.haiyu.manager.pojo.UserTask;
import com.haiyu.manager.dao.UserTaskMapper;
import com.haiyu.manager.dto.UserTaskSearchDTO;
import com.haiyu.manager.service.UserTaskService;
import com.haiyu.manager.response.PageDataResult;
import com.haiyu.manager.common.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: AdminUserServiceImpl
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/11/21 11:04
 */
@Service
public class UserTaskServiceImpl implements UserTaskService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserTaskMapper userTaskMapper;

    @Override
    public PageDataResult getUserTaskList(UserTaskSearchDTO userTaskSearch, Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult = new PageDataResult();
        List<UserTask> userTask = userTaskMapper.getUserTaskList(userTaskSearch);

        PageHelper.startPage(pageNum, pageSize);

        if(userTask.size() != 0){
            PageInfo<UserTask> pageInfo = new PageInfo<>(userTask);
            pageDataResult.setList(userTask);
            pageDataResult.setTotals((int) pageInfo.getTotal());
        }

        return pageDataResult;
    }


    @Override
    public Map<String,Object> addUserTask(UserTask userTask) {
        Map<String,Object> data = new HashMap();
        try {

            userTask.setSubTime(DateUtils.getCurrentDate());
            userTask.setStatus(0);
            int result = userTaskMapper.insert(userTask);
            if(result == 0){
                data.put("code",0);
                data.put("msg","新增失败！");
                logger.error("用户任务[新增]，结果=新增失败！");
                return data;
            }
            data.put("code",1);
            data.put("msg","新增成功！");
            logger.info("用户任务[新增]，结果=新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户任务[新增]异常！", e);
            return data;
        }
        return data;
    }


    @Override
    public Map <String, Object> updateUserTask(UserTask userTask) {
        Map<String,Object> data = new HashMap();

        int result = userTaskMapper.updateUserTask(userTask);
        if(result == 0){
            data.put("code",0);
            data.put("msg","更新失败！");
            logger.error("用户任务[更新]，结果=更新失败！");
            return data;
        }
        data.put("code",1);
        data.put("msg","更新成功！");
        logger.info("用户任务[更新]，结果=更新成功！");
        return data;
    }

    @Override
    public UserTask getUserTaskById(Integer id) {
        return userTaskMapper.selectByPrimaryKey(id);
    }


    @Override
    public Map <String, Object> delUserTask(Integer id,Integer status) {
        Map<String, Object> data = new HashMap<>();
        try {
            // 删除用户
            int result = userTaskMapper.updateUserTaskStatus(id,status);
            if(result == 0){
                data.put("code",0);
                data.put("msg","删除用户任务失败");
                logger.error("删除用户任务失败");
                return data;
            }
            data.put("code",1);
            data.put("msg","删除用户任务成功");
            logger.info("删除用户任务成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除用户任务异常！", e);
        }
        return data;
    }

    @Override
    public Map <String, Object> recoverUserTask(Integer id, Integer status) {
        Map<String, Object> data = new HashMap<>();
        try {
            int result = userTaskMapper.updateUserTaskStatus(id,status);
            if(result == 0){
                data.put("code",0);
                data.put("msg","恢复用户任务失败");
            }
            data.put("code",1);
            data.put("msg","恢复用户任务成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("恢复用户任务异常！", e);
        }
        return data;
    }

}
