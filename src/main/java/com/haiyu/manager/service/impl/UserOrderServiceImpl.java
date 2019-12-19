package com.haiyu.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haiyu.manager.dao.UserOrderMapper;
import com.haiyu.manager.pojo.UserOrder;
import com.haiyu.manager.response.PageDataResult;
import com.haiyu.manager.service.UserOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Override
    public PageDataResult getUserOrderList(Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult = new PageDataResult();
        List<UserOrder> userOrder = userOrderMapper.getUserOrderList();

        PageHelper.startPage(pageNum, pageSize);

        if(userOrder.size() != 0){
            PageInfo<UserOrder> pageInfo = new PageInfo<>(userOrder);
            pageDataResult.setList(userOrder);
            pageDataResult.setTotals((int) pageInfo.getTotal());
        }

        return pageDataResult;
    }

}
