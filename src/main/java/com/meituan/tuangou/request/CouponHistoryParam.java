package com.meituan.tuangou.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jiajia.xiao
 * @date 2021/10/814:59
 */
@Data
public class CouponHistoryParam implements Serializable {
    /**
     * 日期
     * 格式: 2016-08-12
     */
    private String date;
    /**
     * 查询起始位置，从0开始
     */
    private Integer offset;
    /**
     * 查询条数
     */
    private Integer limit;

}
