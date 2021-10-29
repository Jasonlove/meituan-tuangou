package com.meituan.tuangou.result;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author jiajia.xiao
 * @date 2021/10/716:18
 */
@Data
public class SetMealListResult extends BaseResult{

    /**
     * 响应结果数据
     */
    private List<SetMeal> data;

    @Data
    public static class SetMeal implements Serializable {

        /**
         * 项目id
         */
        private Integer dealId;

        /**
         * 项目名称
         */
        private String dealTitle;

        /**
         * 市场价格
         */
        private Double dealValue;
        /**
         * 售卖价格
         */
        private Double dealPrice;

        /**
         * 项目开始时间戳，单位是秒
         */
        private Long beginTime;

        /**
         * 项目结束时间戳，单位是秒
         */
        private Long dealEndTime;

        /**
         * json字符串数组
         * "[[{"type":"0","content":"时蔬"},{"specification":"1份","content":"大席小炒","total":"15","price":"15","type":"128"},{"specification":"1例","content":"一品天香","total":"0.23","price":"0.23","type":"128"},{"specification":"1份","content":"一二三四五六七八九十一二三","total":"11","price":"11","type":"128"},{"specification":"1份","content":"【下面条雨的那天】麻辣牛肉面加粉","total":"2","price":"2","type":"128"},{"specification":"1份","content":"沙县小吃","total":"12","price":"12","type":"128"},{"specification":"1份","content":"1比1图片","total":"12","price":"12","type":"128"},{"type":"0","content":"免费提供餐巾纸"}]]"
         */
        private String dealMenu;
        /**
         * 请求的套餐状态
         */
        private Integer dealStatus;
        /**
         * 是否是代金券，true为代金券，false为套餐
         */
        private  Boolean isVoucher;

    }

}
