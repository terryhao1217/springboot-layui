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
public interface UserOrderService {

    PageDataResult getUserOrderList(Integer pageNum, Integer pageSize);


}
