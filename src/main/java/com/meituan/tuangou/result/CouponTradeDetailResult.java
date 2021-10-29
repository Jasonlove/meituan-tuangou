package com.meituan.tuangou.result;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author jiajia.xiao
 * @date 2021/10/815:46
 */
@Data
public class CouponTradeDetailResult extends BaseResult{

    /**
     * 结果
     */
    private List<CouponTradeDetail> data;

    @Data
    public static class CouponTradeDetail implements Serializable {

        /**
         * 商家促销金额
         */
        private Double bizCost;
        /**
         * 券进价
         */
        private Double buyPrice;
        /**
         * 券购买价
         */
        private Double couponBuyPrice;
        /**
         * 券码
         */
        private String couponCode;
        /**
         *项目id
         */
        private Integer dealId;
        /**
         * 订单id
         */
        private Long orderId;
        /**
         * 券面值，即人们常说的市场价
         */
        private Double dealValue;
        /**
         * 商家预计应得金额
         */
        private Double due;
        /**
         * 验券时间
         */
        private Long useTime;
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
