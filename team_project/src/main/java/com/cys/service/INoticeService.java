package com.cys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cys.model.Notice;

/**
 * <p>
 * 公告信息 服务类
 * </p>
 *
 * @author kappy
 * @since 2023-01-10
 */
public interface INoticeService extends IService<Notice> {

    /**
     * 查询公告信息分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Notice>
     */
    IPage<Notice> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加公告信息
     *
     * @param notice 公告信息
     * @return int
     */
    int add(Notice notice);

    /**
     * 删除公告信息
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改公告信息
     *
     * @param notice 公告信息
     * @return int
     */
    int updateData(Notice notice);

    /**
     * id查询数据
     *
     * @param id id
     * @return Notice
     */
    Notice findById(Long id);
}
