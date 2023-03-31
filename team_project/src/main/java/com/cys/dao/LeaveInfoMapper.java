package com.cys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cys.model.LeaveInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 在线留言管理 Mapper 接口
 * </p>
 *
 * @author kappy
 * @since 2023-01-10
 *
 */
@Component("leaveDao")
public interface LeaveInfoMapper extends BaseMapper<LeaveInfo> {
    List<LeaveInfo> queryLeaveInfoAll(@Param("tel") String tel);
}
