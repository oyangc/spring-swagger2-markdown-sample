package com.oyangc.swaggersample.comtroller.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("分页查询")
public class Page implements Serializable {
    @ApiModelProperty("查看第几页")
    private Integer pageIndex = 1;
    @ApiModelProperty("每页多少条")
    private Integer pageSize = 10;
}
