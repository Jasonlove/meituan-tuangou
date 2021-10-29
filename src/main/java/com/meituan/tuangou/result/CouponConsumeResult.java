package com.meituan.tuangou.result;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author jiajia.xiao
 * @date 2021/10/717:07
 */
@Data
public class CouponConsumeResult extends BaseResult{

    /**
     * 卡券核销
     */
    private CouponConsume data;

    @Data
    public static class CouponConsume implements Serializable {
        /**
         * 订单号
         */
        private String orderId;
        /**
         * 验证券码数组
         */
        private List<String> couponCodes;
        /**
         * 项目名称
         */
        private String dealTitle;
        /**
         *dealValue
         */
        private Double dealValue;
        /**
         * 项目ID
         */
        private Integer dealId;
        /**
         * 美团门店ID
         */
        private String poiid;
        /**
         * 返回值消息
         */
        private String message;
        /**
         * 操作状态
         * 0 正常
         */
        private Integer result;

    }


}
