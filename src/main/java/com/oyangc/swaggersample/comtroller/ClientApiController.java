package com.oyangc.swaggersample.comtroller;

import com.oyangc.swaggersample.comtroller.common.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * 客户端接口类
 */
@Api(tags = "客户端接口类")
@Slf4j
@RestController
@RequestMapping(value = "/api/v1", produces = "application/json;charset=UTF-8")
public class ClientApiController {

    /**
     * 开启
     *
     * @param appId         应用ID
     * @param channelName   channel名称
     */
    // @ApiIgnore 用于屏蔽 Swagger
//    @ApiIgnore
    @ApiOperation("开启")
    @PostMapping("/channel/startRecord/{appId}/{channelName}")
    public AjaxResult startRecord(@ApiParam("应用ID") @PathVariable("appId") String appId,
                                  @ApiParam("频道名称") @PathVariable("channelName") String channelName,
                                  HttpServletRequest request) throws Exception    {

        return AjaxResult.ok("操作成功");
    }


}
