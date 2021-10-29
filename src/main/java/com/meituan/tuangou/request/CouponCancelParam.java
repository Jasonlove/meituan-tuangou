package com.meituan.tuangou.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jiajia.xiao
 * @date 2021/10/814:27
 */
@Data
public class CouponCancelParam implements Serializable {
    /**
     * 券码
     */
    @JsonProperty("couponCode")
    private String couponCode;
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
     * type值永远为1撤销验券
     */
    private Integer type;
}
