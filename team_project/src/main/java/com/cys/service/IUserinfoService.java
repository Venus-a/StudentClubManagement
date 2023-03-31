package com.cys.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cys.model.LeaveInfo;
import com.cys.model.UserInfo;
import com.github.pagehelper.PageInfo;

import java.util.zip.Inflater;

/**
 * <p>
 * 管理员信息表 服务类
 * </p>
 *
 * @author kappy
 * @since 2023-01-10
 */
public interface IUserinfoService extends IService<UserInfo> {

    /**
     * 查询管理员信息表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Userinfo>
     */
    IPage<UserInfo> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加管理员信息表
     *
     * @param userinfo 管理员信息表
     * @return int
     */
    int add(UserInfo userinfo);

    /**
     * 删除管理员信息表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改管理员信息表
     *
     * @param userinfo 管理员信息表
     * @return int
     */
    int updateData(UserInfo userinfo);

    /**
     * id查询数据
     *
     * @param id id
     * @return Userinfo
     */
    UserInfo findById(Long id);


        /**
         * 根据对象尽心属性值查询对象是否存在
         *  用户名 密码 角色
         *
         */
    UserInfo queryUserInfoByUserNameAndPasswordAndType(UserInfo userInfo);

    /**
     * 高级查询
     */
    PageInfo<UserInfo> queryList(int page, int limit,
                                  UserInfo userInfo);

    /**
     * 修改密码
     */
    int updatePassWord(Integer id,String newPassWord);

}
