package com.meituan.tuangou;

import com.meituan.tuangou.request.CouponCancelParam;
import com.meituan.tuangou.request.CouponConsumeParam;
import com.meituan.tuangou.request.CouponHistoryParam;
import com.meituan.tuangou.result.*;

/**
 * 团购券api
 *
 * @author jiajia.xiao
 * @date 2021/10/716:05
 */
public interface MeiTuanCouponService {

    /**
     * 获取配置
     *
     * @return
     */
    MeiTuanConfig getConfig();

    /**
     * 请求美团接口
     *
     * @param url      地址
     * @param bizJson  请求参数
     * @return 结果
     */
    String post(String url, String bizJson);

    /**
     * 5.2.已验券码查询
     * https://developer.meituan.com/docs/api/tuangou-coupon-queryById
     *
     * @param couponCode
     * @return
     */
    QueryCouponResult queryCoupon(String couponCode);

    /**
     * 5.3.验券准备
     * https://developer.meituan.com/docs/api/tuangou-coupon-prepare
     *
     * @param couponCode
     * @return
     */
    CouponPrepareResult couponPrepare(String couponCode);

    /**
     * 5.4.执行验券
     * https://developer.meituan.com/docs/api/tuangou-coupon-consume
     *
     * @param couponConsumeParam
     * @return
     */
    CouponConsumeResult couponConsume(CouponConsumeParam couponConsumeParam);

    /**
     * 5.5.撤销验券
     * 查询与撤销已验证券码（验证60天内券码）
     * 验券和撤销验券接口支持下面两种情况:
     * 1、美团点评合并前美团曾经发过的所有券码
     * 2、美团点评合并后美团及点评平台餐饮团购类目的券码
     * 注：
     * 撤销验券接口只能撤销美团券，不能撤销点评券，且点评侧没有撤销验券。
     * 团购券验证后，又执行撤销操作原来的券码作废，新券码会以短信形式发给用户（之前的券码不能使用）。
     * https://developer.meituan.com/docs/api/tuangou-coupon-cancel
     *
     * @param couponCancelParam
     * @return
     */
    CouponCancelResult couponCancel(CouponCancelParam couponCancelParam);

    /**
     * 5.6.门店验券历史
     * https://developer.meituan.com/docs/api/tuangou-coupon-queryListByDate
     *
     * @param couponHistoryParam
     * @return
     */
    CouponHistoryResult getCouponHistory(CouponHistoryParam couponHistoryParam);

    /**
     * 5.8.门店套餐映射
     * https://developer.meituan.com/docs/api/tuangou-coupon-querySetMealList
     *
     * @param dealStatus
     * @return
     */
    SetMealListResult querySetMealList(Integer dealStatus);

    /**
     * 9.3.查询团购订单结算明细
     * https://developer.meituan.com/docs/api/tuangou-coupon-queryTradeDetail
     *
     * @param couponCode
     * @return
     */
    CouponTradeDetailResult queryTradeDetail(String couponCode);

    /**
     * 10.生成门店授权地址
     * https://open-erp.meituan.com/storemap
     *
     * @param shopCode
     * @return
     */
    String queryShopAuthUrl(Long shopCode, String shopName);
}
