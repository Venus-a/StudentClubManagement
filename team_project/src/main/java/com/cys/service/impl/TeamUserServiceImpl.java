package com.cys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cys.dao.TeamUserMapper;
import com.cys.model.TeamUser;
import com.cys.service.ITeamUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 社团成员管理 服务实现类
 * </p>
 *
 * @author kappy
 * @since 2023-01-10
 */
@Service
public class TeamUserServiceImpl extends ServiceImpl<TeamUserMapper, TeamUser> implements ITeamUserService {


    @Autowired
    private TeamUserMapper teamUserDao;
    @Override
    public  IPage<TeamUser> findListByPage(Integer page, Integer pageCount){
        IPage<TeamUser> wherePage = new Page<>(page, pageCount);
        TeamUser where = new TeamUser();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(TeamUser teamUser){
        return baseMapper.insert(teamUser);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(TeamUser teamUser){
        return baseMapper.updateById(teamUser);
    }

    @Override
    public TeamUser findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public PageInfo<TeamUser> queryPageInfo(int page, int limit,
                                            String tel, String email,Integer userId) {
        PageHelper.startPage(page,limit);
        //获取dao层接口
        List<TeamUser> teamUsers = teamUserDao.queryTeamUserList(email, tel,userId);
        PageInfo<TeamUser> pageInfo=new PageInfo<>(teamUsers);
        return pageInfo;
    }

    @Override
    public TeamUser queryTeamUserByTeamIdAndTel(int teamId, String tel) {
        return teamUserDao.queryTeamUserByTeamIdAndTel(teamId,tel);
    }

    @Override
    public TeamUser queryByUserNameAndPwd(String username, String password) {
        return teamUserDao.queryByUserNameAndPwd(username,password);
    }
}
