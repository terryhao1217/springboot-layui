package com.haiyu.manager.dao;

import com.haiyu.manager.dto.AdminUserDTO;
import com.haiyu.manager.dto.UserTaskSearchDTO;
import com.haiyu.manager.dto.UserTaskDTO;
import com.haiyu.manager.pojo.BaseAdminUser;
import com.haiyu.manager.pojo.UserOrder;
import com.haiyu.manager.pojo.UserTask;
import tk.mapper.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface UserOrderMapper  extends MyMapper<UserOrder> {
    List<UserOrder> getUserOrderList();

}
