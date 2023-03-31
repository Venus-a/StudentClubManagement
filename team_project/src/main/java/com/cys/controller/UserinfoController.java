package com.cys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cys.jwt.JwtUtil;
import com.cys.model.Activity;
import com.cys.model.TypeInfo;
import com.cys.model.UserInfo;
import com.cys.service.IUserinfoService;
import com.cys.util.JsonObject;
import com.cys.util.R;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 管理员信息表 前端控制器
 * </p>
 *
 * @author kappy
 * @since 2023-01-10
 */
@Api(tags = {"管理员信息表"})
@RestController
@RequestMapping("/userinfo")
public class UserinfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserinfoService userinfoService;

    /**
     * 获取用户列表接口
     *  所有的用户类型为社团管理员的用户
     * @param
     * @return
     */
    @RequestMapping("/queryUserInfoList")
    public JsonObject queryUserInfoList(){
        List<UserInfo> list = userinfoService.list();
        JsonObject object =new JsonObject();
        object.setData(list);
        object.setCode(20000);
        return object;
    }

    /**
     * 高级分页查询接口
     */
    @RequestMapping("/queryUserInfoListAll")
    public JsonObject queryUserInfoList(String username,
                                         String tel,
                                         @RequestParam(defaultValue = "1")int page,
                                         @RequestParam(defaultValue = "15")int limit,
                                         HttpServletRequest request){

        //通过header 获取token
        String token =  request.getHeader("token");
        //通过token获取角色类型和用户id
        Integer type = JwtUtil.getUserType(token);
        Integer userId = null;
        UserInfo info = new UserInfo();
        if (username!=null){
            info.setUsername(username);
        }
        if (tel!=null){
            info.setTel(tel);
        }
        if (type==0){
            //如果是一个社团的管理员
            //获取当前用户据id
            userId = JwtUtil.getUserId(token);
            info.setId(userId);
        }

        //创建返回结果集对象
        JsonObject jsonObject=new JsonObject();
        PageInfo<UserInfo> PageInfo = userinfoService.queryList(page, limit, info);
        jsonObject.setCode(20000);
        jsonObject.setTotal(PageInfo.getTotal());
        jsonObject.setData(PageInfo.getList());
        return jsonObject;
    }

    @ApiOperation(value = "新增用户")
    @RequestMapping("/addInfo")
    public R add(@RequestBody UserInfo userInfo){
        //新增后的返回参数 如果是1 成功 0 失败
        int num = userinfoService.add(userInfo);
        if (num>0){
            return R.ok();
        }
        return R.fail("类型添加失败");
    }

    @ApiOperation(value = "删除用户")
    @RequestMapping("/deleteById")
    public R delete(Long id){
        int num = userinfoService.delete(id);
        if (num>0){
            return R.ok();
        }
        return R.fail("删除失败");
    }

    @ApiOperation(value = "更新用户")
    @RequestMapping("/updateInfo")
    public R update(@RequestBody UserInfo userInfo){
        int num = userinfoService.updateData(userInfo);
        if (num>0){
            return R.ok();
        }
        return R.fail("修改失败");
    }
    /**
     * 修改密码
     */
    @RequestMapping("/updatePassword")
    public R updatePassword(@RequestBody UserInfo userInfo){
        int num = userinfoService.updatePassWord(userInfo.getId(),userInfo.getPassword());
        if (num>0){
            return R.ok();
        }
        return R.fail("修改密码失败");
    }
}
