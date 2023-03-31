package com.cys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cys.model.LeaveInfo;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 在线留言管理 服务类
 * </p>
 *
 * @author kappy
 * @since 2023-01-10
 */
public interface ILeaveInfoService extends IService<LeaveInfo> {

    /**
     * 查询在线留言管理分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<LeaveInfo>
     */
    IPage<LeaveInfo> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加在线留言管理
     *
     * @param leaveInfo 在线留言管理
     * @return int
     */
    int add(LeaveInfo leaveInfo);

    /**
     * 删除在线留言管理
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改在线留言管理
     *
     * @param leaveInfo 在线留言管理
     * @return int
     */
    int updateData(LeaveInfo leaveInfo);

    /**
     * id查询数据
     *
     * @param id id
     * @return LeaveInfo
     */
    LeaveInfo findById(Long id);

    /**
     * 高级查询
     */
    PageInfo<LeaveInfo> queryList(int page,int limit,
                                  String tel);
}
