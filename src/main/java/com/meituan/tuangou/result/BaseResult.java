package com.meituan.tuangou.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jiajia.xiao
 * @date 2021/10/716:09
 */
@Data
public class BaseResult implements Serializable {

    /**
     * 响应code
     */
    private String code;

    /**
     * 响应内容
     */
    private String msg;
    /**
     * 编号
     */
    private String traceId;

}
