package com.meituan.tuangou.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jiajia.xiao
 * @date 2021/10/716:44
 */
@Data
public class CouponPrepareResult extends BaseResult{

    /**
     * 响应结果数据
     */
    private CouponPrepare data;

    @Data
    public static class CouponPrepare implements Serializable {
        /**
         * 最大可验证张数
         */
        private Integer count;
        /**
         * 券购买价,即用户在购买团购券时所付的实际价格
         */
        private Double couponBuyPrice;
        /**
         * 券码
         */
        private String couponCode;
        /**
         * 是否代金券,true代表代金券,false代表套餐券
         */
        private Boolean isVoucher;
        /**
         * 券码有效期
         */
        private String couponEndTime;
        /**
         * 项目开始时间
         */
        private String dealBeginTime;
        /**
         * 项目ID
         */
        private Integer dealId;
        /**
         * 团购券价格，即商家促销前的券购买价格，如首次购买有更多优惠这类需要在开店宝设置的促销
         */
        private Double dealPrice;
        /**
         * 项目名称
         */
        private String dealTitle;
        /**
         * 券面值，即人们常说的市场价
         */
        private Double dealValue;
        /**
         * 返回消息
         */
        private String message;
        /**
         * 最小消费张数
         */
        private Integer minConsume;
        /**
         * 操作状态,0表示成功
         */
        private Integer result;
        /**
         * 是否量贩：0：不是，1：是
         */
        private Integer volume;
        /**
         * 量贩项目的单张券原价（普通券单张券原价与项目总价相同
         */
        private double singleValue;

    }

}
