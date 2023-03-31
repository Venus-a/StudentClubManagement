package com.cys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cys.dao.UserinfoMapper;
import com.cys.model.LeaveInfo;
import com.cys.model.UserInfo;
import com.cys.service.IUserinfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 管理员信息表 服务实现类
 * </p>
 *
 * @author kappy
 * @since 2023-01-10
 */
@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, UserInfo> implements IUserinfoService {

    @Autowired
    private UserinfoMapper userInfoDao;

    @Override
    public  IPage<UserInfo> findListByPage(Integer page, Integer pageCount){
        IPage<UserInfo> wherePage = new Page<>(page, pageCount);
        UserInfo where = new UserInfo();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(UserInfo userinfo){
        return baseMapper.insert(userinfo);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(UserInfo userinfo){
        return baseMapper.updateById(userinfo);
    }

    @Override
    public UserInfo findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public UserInfo queryUserInfoByUserNameAndPasswordAndType(UserInfo userInfo) {
        return userInfoDao.queryUserInfoByUserNameAndPasswordAndType(userInfo);
    }

    @Override
    public PageInfo<UserInfo> queryList(int page, int limit, UserInfo info) {
        PageHelper.startPage(page, limit);
        List<UserInfo> ac = userInfoDao.queryUserInfoList(info);
        PageInfo<UserInfo> pageInfo = new PageInfo<>(ac);
        return pageInfo;
    }

    @Override
    public int updatePassWord(Integer id, String newPassWord) {
        return userInfoDao.updatePasswordByIdAndNewPassword(id,newPassWord);
    }
}
