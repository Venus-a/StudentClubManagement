package com.cys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cys.jwt.JwtUtil;
import com.cys.model.Activity;
import com.cys.model.LeaveInfo;
import com.cys.service.ILeaveInfoService;
import com.cys.util.JsonObject;
import com.cys.util.R;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 * 在线留言管理 前端控制器
 * </p>
 *
 * @author kappy
 * @since 2023-01-10
 */
@Api(tags = {"在线留言管理"})
@RestController
@RequestMapping("/leaveinfo")
public class LeaveInfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ILeaveInfoService leaveInfoService;


    @ApiOperation(value = "新增在线留言管理")
    @RequestMapping("/addInfo")
    public R add(@RequestBody LeaveInfo leaveInfo){

        //加入留言时间
        leaveInfo.setLeaveTime(new Date());
        int num= leaveInfoService.add(leaveInfo);
        if (num>0){
            return R.ok();
        }
        return R.fail("失败");
    }


    @ApiOperation(value = "删除在线留言管理")
    @RequestMapping("/deleteById")
    public R delete(Long id){

        int num = leaveInfoService.delete(id);
        if (num>0){
            return R.ok();
        }
        return R.fail("失败");
    }

    /**
     * 高级分页查询接口
     */
    @RequestMapping("/queryLeaveInfoList")
    public JsonObject queryLeaveInfoList(String tel,
                                         @RequestParam(defaultValue = "1")int page,
                                         @RequestParam(defaultValue = "15")int limit){



        //创建返回结果集对象
        JsonObject jsonObject=new JsonObject();
        PageInfo<LeaveInfo> PageInfo = leaveInfoService.queryList(page, limit,tel);
        jsonObject.setCode(20000);
        jsonObject.setTotal(PageInfo.getTotal());
        jsonObject.setData(PageInfo.getList());
        return jsonObject;
    }


}
