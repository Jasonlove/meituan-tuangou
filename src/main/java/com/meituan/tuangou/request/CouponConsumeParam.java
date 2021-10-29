package com.meituan.tuangou.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 美团卡券核销入参
 * @author jiajia.xiao
 * @date 2021/10/717:00
 */
@Data
public class CouponConsumeParam implements Serializable {
    /**
     * 券码
     */
    @JsonProperty("couponCode")
    private String couponCode;
    /**
     * 数量
     */
    private Integer count;
    /**
     * 商家登录ERP帐号ID
     */
    @JsonProperty("eId")
    private String eId;
    /**
     * 商家登录ERP帐号名称
     */
    @JsonProperty("eName")
    private String eName;
    /**
     * 第三方ERP订单号
     */
    @JsonProperty("eOrderId")
    private String eOrderId;
}
