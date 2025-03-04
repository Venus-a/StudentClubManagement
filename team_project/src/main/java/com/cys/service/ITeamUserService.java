package com.cys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cys.model.ApplyList;
import com.cys.model.TeamUser;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 社团成员管理 服务类
 * </p>
 *
 * @author kappy
 * @since 2023-01-10
 */
public interface ITeamUserService extends IService<TeamUser> {

    /**
     * 查询社团成员管理分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<TeamUser>
     */
    IPage<TeamUser> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加社团成员管理
     *
     * @param teamUser 社团成员管理
     * @return int
     */
    int add(TeamUser teamUser);

    /**
     * 删除社团成员管理
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改社团成员管理
     *
     * @param teamUser 社团成员管理
     * @return int
     */
    int updateData(TeamUser teamUser);

    /**
     * id查询数据
     *
     * @param id id
     * @return TeamUser
     */
    TeamUser findById(Long id);

    /**
     * 分页查询
     */
    PageInfo<TeamUser> queryPageInfo(int page,int limit,
                                     String tel,String email,Integer userId);

    /**
     * 根据电话和社团id 判断是否存在该对象
     *
     */
    TeamUser queryTeamUserByTeamIdAndTel( int teamId,
                                          String tel);

    /**
     * 根据用户名 密码 查询是否有当前对象
     */
    TeamUser queryByUserNameAndPwd(String username,
                                   String password);
}
