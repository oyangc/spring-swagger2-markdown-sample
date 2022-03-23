package com.oyangc.swaggersample.comtroller.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 表格分页数据对象
 *
 * @author manis
 */
@Data
@ApiModel("操作消息")
public class TableDataInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("总记录数")
    /** 总记录数 */
    private long total;

    @ApiModelProperty("数据对象")
    /** 列表数据 */
    private List<?> rows;

    @ApiModelProperty("消息状态码")
    /** 消息状态码 */
    private int code;

    @ApiModelProperty("消息")
    /** 消息内容 */
    private String msg;

    /**
     * 表格数据对象
     */
    public TableDataInfo()
    {
    }

    /**
     * 分页
     *
     * @param list 列表数据
     * @param total 总记录数
     */
    public TableDataInfo(List<?> list, int total)
    {
        this.rows = list;
        this.total = total;
    }

}
