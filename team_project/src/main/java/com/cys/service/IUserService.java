package com.cys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cys.model.UserInfo;
import com.github.pagehelper.PageInfo;

public interface IUserService extends IService<UserInfo> {
    /*
    * 分页用户查询
    * */
    PageInfo<UserInfo> queryUserByPage(int page, int limit);
}
