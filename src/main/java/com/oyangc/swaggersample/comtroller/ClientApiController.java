package com.oyangc.swaggersample.comtroller;

import com.oyangc.swaggersample.bean.RecordParam;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 客户端接口类
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/v1", produces = "application/json;charset=UTF-8")
//@SwaggerDefinition(info = @Info(description = "My API", version = "0.0.1",title = "Swagger"))
public class ClientApiController {

    /**
     * 开启录播
     *
     * @param appId         应用ID
     * @param channelName   channel名称
     * @param record  参数对象
     */
    @PostMapping("/channel/startRecord/{appId}/{channelName}")
    public AjaxResult startRecord(@PathVariable("appId") String appId,
                                  @PathVariable("channelName") String channelName,
                                  @Valid @RequestBody RecordParam record,
                                  HttpServletRequest request) throws Exception    {

        return AjaxResult.success("操作成功");
    }


}
