package com.cys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cys.model.Team;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 社团信息管理 服务类
 * </p>
 *
 * @author kappy
 * @since 2023-01-10
 */
public interface ITeamService extends IService<Team> {

    /**
     * 查询社团信息管理分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Team>
     */
    IPage<Team> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加社团信息管理
     *
     * @param team 社团信息管理
     * @return int
     */
    int add(Team team);

    /**
     * 删除社团信息管理
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改社团信息管理
     *
     * @param team 社团信息管理
     * @return int
     */
    int updateData(Team team);

    /**
     * id查询数据
     *
     * @param id id
     * @return Team
     */
    Team findById(Long id);

    /*
    分页高级查询
     */
    PageInfo<Team> queryTeamList(int page,int limit,Team team);

    /**
     * 根据用户id 查询社团信息
     */
    Team queryTeamInfoByUserId(@Param("userId")Integer userId);


    /**
     * 查询我的社团列表
     */
    List<Team> queryMyteamList(String tel);
}
