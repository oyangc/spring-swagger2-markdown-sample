package com.oyangc.swaggersample.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class RecordParam implements Serializable {
    @NotNull(message = "streamId不能为空")
    private String streamId;
    @NotNull(message = "vrecordType不能为空")
    private String vrecordType;
}
