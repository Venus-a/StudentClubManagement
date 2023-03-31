package com.cys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cys.dao.ApplyListMapper;
import com.cys.model.ApplyList;
import com.cys.service.IApplyListService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 审核记录表 服务实现类
 * </p>
 *
 * @author kappy
 * @since 2023-01-10
 */
@Service
public class ApplyListServiceImpl extends ServiceImpl<ApplyListMapper, ApplyList> implements IApplyListService {

    @Override
    public  IPage<ApplyList> findListByPage(Integer page, Integer pageCount){
        IPage<ApplyList> wherePage = new Page<>(page, pageCount);
        ApplyList where = new ApplyList();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ApplyList applyList){
        return baseMapper.insert(applyList);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ApplyList applyList){
        return baseMapper.updateById(applyList);
    }

    @Override
    public ApplyList findById(Long id){
        return  baseMapper.selectById(id);
    }
}
