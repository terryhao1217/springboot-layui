package com.haiyu.manager.dao;

import com.haiyu.manager.dto.AdminUserDTO;
import com.haiyu.manager.dto.UserTaskSearchDTO;
import com.haiyu.manager.dto.UserTaskDTO;
import com.haiyu.manager.pojo.BaseAdminUser;
import com.haiyu.manager.pojo.UserTask;
import tk.mapper.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserTaskMapper  extends MyMapper<UserTask> {
    List<UserTask> getUserTaskList(UserTaskSearchDTO userTaskSearchDTO);

    UserTask getUserTaskByWebsite(@Param("website")String website,@Param("id") Integer id);

    int updateUserTaskType(@Param("id") Integer id,@Param("typee") Integer typee);

    int updateUserTask(UserTask userTask);

    int updateUserTaskStatus(@Param("id") Integer id,@Param("status") Integer status);

}
