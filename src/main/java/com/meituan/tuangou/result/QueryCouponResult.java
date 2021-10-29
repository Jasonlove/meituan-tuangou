package com.meituan.tuangou.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jiajia.xiao
 * @date 2021/10/717:30
 */
@Data
public class QueryCouponResult extends BaseResult{

    /**
     * 结果
     */
    private QueryCoupon data;

    @Data
    public static class QueryCoupon implements Serializable {

        /**
         * 团购券码购买价格
         */
        private Double couponBuyPrice;
        /**
         *
         * 券码是否可撤销，表示可撤销，0表示不可撤销
         */
        private Integer couponCancelStatus;
        /**
         * 券码
         */
        private String couponCode;
        /**
         * 券状态
         */
        private String couponStatusDesc;
        /**
         * 券码使用时间
         * 2016-08-12 18:38:40
         */
        private String couponUseTime;
        /**
         * 项目开始时间
         * 2015-12-22 14:27:41
         */
        private String dealBeginTime;
        /**
         * 项目名称
         */
        private String dealTitle;
        /**
         * 市场价
         */
        private Double dealValue;
        /**
         * 验券帐号
         */
        private String verifyAcct;
        /**
         * 	其他验证方式
         */
        private String verifyType;
        /**
         * 是否代金券，代表代金券,false代表套餐券
         */
        private Boolean isVoucher;
        /**
         * 项目id
         */
        private Integer dealId;
        /**
         * 是否量贩：0：不是，1：是
         */
        private Integer volume;
        /**
         * 量贩项目的单张券原价（普通券单张券原价与项目总价相同）
         */
        private Double singleValue;
    }
}
