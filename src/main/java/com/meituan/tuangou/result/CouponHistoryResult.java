package com.meituan.tuangou.result;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author jiajia.xiao
 * @date 2021/10/814:47
 */
@Data
public class CouponHistoryResult extends BaseResult{

    /**
     * 核销历史
     */
    private CouponHistoryTable data;

    @Data
    public static class CouponHistoryTable{
        /**
         * 列表
         */
        private List<CouponHistory> couponCodes;
        /**
         * 总数
         */
        private Long total;
    }

    /**
     *
     */
    @Data
    public static class CouponHistory implements Serializable {

        /**
         * 团购券购买价格
         */
        private Double couponBuyPrice;
        /**
         * 团购券是否可撤销。1表示可撤销，0表示不可撤销
         */
        private Integer couponCancelStatus;
        /**
         * 团购券码
         */
        private String couponCode;
        /**
         * 团购券状态，包含：未使用、已使用、已冻结、作弊已冻结、已退款
         */
        private String couponStatusDesc;
        /**
         * 验券时间
         */
        private String couponUseTime;
        /**
         * 团购券对应项目开始售卖时间
         */
        private String dealBeginTime;
        /**
         * 项目对应的标题
         */
        private String dealTitle;
        /**
         * 项目售卖价
         */
        private Double dealValue;
        /**
         * 验券帐号
         */
        private String verifyAcct;
        /**
         * 验券方式
         * 开放平台api验证
         */
        private String verifyType;

    }


}
