//package com.cys.service.impl;
//
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.cys.mapper.UserMapper;
//import com.cys.model.Userinfo;
//import com.cys.service.IUserService;
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service("userService")
//public class UserServiceImpl
//        extends ServiceImpl<UserMapper, Userinfo>
//        implements IUserService {
//
//    @Autowired
//    private UserMapper userDao;
//
//    @Override
//    public PageInfo<Userinfo> queryUserByPage(int page, int limit) {
//        PageHelper.startPage(page,limit);
//        List<Userinfo> list = userDao.selectList(null);
//        PageInfo<Userinfo> pageInfo=new PageInfo<>(list);
//        return pageInfo;
//    }
//}
