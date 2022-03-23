package com.oyangc.swaggersample.comtroller.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("操作消息")
public class AjaxResult {
    @ApiModelProperty("状态码")
    /** 状态码 */
    public Integer code;

    @ApiModelProperty("返回内容")
    /** 返回内容 */
    public String msg;
    @ApiModelProperty("数据对象")
    /** 数据对象 */
    public Object data;
    
    public static AjaxResult build() {
        return new AjaxResult();
    }

    public static AjaxResult ok(String msg) {
        return new AjaxResult(200, msg, null);
    }

    public static AjaxResult ok(String msg, Object data) {
        return new AjaxResult(200, msg, data);
    }

    public static AjaxResult error(String msg) {
        return new AjaxResult(500, msg, null);
    }

    public static <T> AjaxResult error(String msg, T data) {
        return new AjaxResult(500, msg, data);
    }

    private AjaxResult() {
    }

    private AjaxResult(Integer status, String msg, Object data) {
        this.code = status;
        this.msg = msg;
        this.data = data;
    }

}
