package com.meituan.tuangou.result;

import lombok.Data;

/**
 * @author jiajia.xiao
 * @date 2021/10/814:29
 */
@Data
public class CouponCancelResult extends BaseResult{

    /**
     * 响应结果数据
     */
    private CouponCancel data;

    @Data
    public static class CouponCancel{
        /**
         *
         * 操作状态0表示成功，其余表示失败
         */
        private Integer result;
        /**
         * 撤销结果描述信息
         */
        private String message;

    }
}
