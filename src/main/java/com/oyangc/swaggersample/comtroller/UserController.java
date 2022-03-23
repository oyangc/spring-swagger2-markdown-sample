package com.oyangc.swaggersample.comtroller;

import com.oyangc.swaggersample.comtroller.bean.User;
import com.oyangc.swaggersample.comtroller.common.AjaxResult;
import com.oyangc.swaggersample.comtroller.common.Page;
import com.oyangc.swaggersample.comtroller.common.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "用户管理")
@RestController
@RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
public class UserController extends BaseController {

    @ApiOperation("创建用户")
    @PostMapping("/users")
    public AjaxResult create(@RequestBody @Valid User user) {
        return AjaxResult.ok("ok", user);
    }

    @ApiOperation("用户详情")
    @GetMapping("/users/{id}")
    public AjaxResult findById(@PathVariable Long id) {
        User user = new User("yy", 21, "yy", "yy@test.com");
        return AjaxResult.ok("ok", user);
    }

    @ApiOperation("用户列表")
    @GetMapping("/users")
    public TableDataInfo list(@ApiParam("分页查询") @RequestParam Page page) {
        List<User> result = new ArrayList<>();
        result.add(new User("xx", 22, "xx", "xx@test.com"));
        return getDataTable(result);
    }

    @ApiIgnore
    @DeleteMapping("/users/{id}")
    public AjaxResult deleteById(@PathVariable Long id) {
        return AjaxResult.ok("del user : " + id);
    }

}