package com.meituan.tuangou;

import com.meituan.tuangou.request.CouponCancelParam;
import com.meituan.tuangou.request.CouponConsumeParam;
import com.meituan.tuangou.request.CouponHistoryParam;
import com.meituan.tuangou.result.*;
import com.meituan.tuangou.util.JsonUtil;
import com.meituan.tuangou.util.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 美团接口实现类
 *
 * @author jiajia.xiao
 * @date 2021/10/716:29
 */
@Slf4j
@Service
public class MeiTuanCouponServiceImpl extends BaseMeiTuanCouponService {


    @Override
    public QueryCouponResult queryCoupon(String couponCode) {
        if (StringUtils.isBlank(couponCode)) {
            throw new IllegalArgumentException("couponCode不能为空");
        }
        Map<String, String> map = new HashMap<>(1);
        map.put("couponCode", couponCode);
        String string = JsonUtil.jsonString(map);
        String post = this.post(API_GATEWAY + "/tuangou/coupon/queryById", string);
        QueryCouponResult result = null;
        try {
            result = JsonUtil.toJava(post, QueryCouponResult.class);
        } catch (Exception e) {
            log.error("返回结果转换异常", e);
        }
        return result;
    }

    @Override
    public CouponPrepareResult couponPrepare(String couponCode) {
        if (StringUtils.isBlank(couponCode)) {
            throw new IllegalArgumentException("couponCode不能为空");
        }
        Map<String, String> preMap = new HashMap<>(1);
        preMap.put("couponCode", couponCode);
        String string = JsonUtil.jsonString(preMap);
        String post = this.post(API_GATEWAY + "/tuangou/coupon/prepare", string);
        CouponPrepareResult result = null;
        try {
            result = JsonUtil.toJava(post, CouponPrepareResult.class);
        } catch (Exception e) {
            log.error("返回结果转换异常", e);
        }
        return result;
    }

    @Override
    public CouponConsumeResult couponConsume(CouponConsumeParam couponConsumeParam) {
        //todo校验参数
        String string = JsonUtil.jsonString(couponConsumeParam);
        String post = this.post(API_GATEWAY + "/tuangou/coupon/consume", string);
        CouponConsumeResult result = null;
        try {
            result = JsonUtil.toJava(post, CouponConsumeResult.class);
        } catch (Exception e) {
            log.error("返回结果转换异常", e);
        }
        return result;
    }

    @Override
    public CouponCancelResult couponCancel(CouponCancelParam couponCancelParam) {
        //todo校验参数
        String string = JsonUtil.jsonString(couponCancelParam);
        String post = this.post(API_GATEWAY + "/tuangou/coupon/cancel", string);
        CouponCancelResult result = null;
        try {
            result = JsonUtil.toJava(post, CouponCancelResult.class);
        } catch (Exception e) {
            log.error("返回结果转换异常", e);
        }
        return result;
    }

    @Override
    public CouponHistoryResult getCouponHistory(CouponHistoryParam couponHistoryParam) {
        //todo校验参数
        String string = JsonUtil.jsonString(couponHistoryParam);
        String post = this.post(API_GATEWAY + "/tuangou/coupon/queryListByDate", string);
        CouponHistoryResult result = null;
        try {
            result = JsonUtil.toJava(post, CouponHistoryResult.class);
        } catch (Exception e) {
            log.error("返回结果转换异常", e);
        }
        return result;
    }

    @Override
    public SetMealListResult querySetMealList(Integer dealStatus) {
        Map<String, Integer> map = new HashMap<>(1);
        map.put("dealStatus", dealStatus);
        String string = JsonUtil.jsonString(map);
        String post = this.post(API_GATEWAY + "/tuangou/coupon/querySetMealList", string);
        SetMealListResult result = null;
        try {
            result = JsonUtil.toJava(post, SetMealListResult.class);
        } catch (Exception e) {
            log.error("返回结果转换异常", e);
        }
        return result;
    }

    @Override
    public CouponTradeDetailResult queryTradeDetail(String couponCode) {
        if (StringUtils.isBlank(couponCode)) {
            throw new IllegalArgumentException("couponCode不能为空");
        }
        Map<String, String> map = new HashMap<>(1);
        map.put("couponCode", couponCode);
        String string = JsonUtil.jsonString(map);
        String post = this.post(API_GATEWAY + "/tuangou/coupon/queryTradeDetail", string);
        CouponTradeDetailResult result = null;
        try {
            result = JsonUtil.toJava(post, CouponTradeDetailResult.class);
        } catch (Exception e) {
            log.error("返回结果转换异常", e);
        }
        return result;
    }

    @Override
    public String queryShopAuthUrl(Long shopCode, String shopName) {
        Long timestamp = System.currentTimeMillis();
        Map<String, String> params = new LinkedHashMap<>();
        params.put("businessId", config.getBusinessId());
        params.put("developerId", config.getDeveloperId());
        params.put("ePoiId", String.valueOf(shopCode));
        params.put("ePoiName", shopName);
        params.put("timestamp", String.valueOf(timestamp));
        String sign = SignUtil.getSign(config.getSignKey(), params);
        String authUrl = AUTH_GATEWAY + "/storemap?developerId=" + config.getDeveloperId() + "&businessId=" + config.getBusinessId() + "&ePoiId=" + shopCode + "&ePoiName=" + shopName + "&timestamp=" + timestamp + "&sign=" + sign;
        log.info("url：" + authUrl);
        return authUrl;
    }

}
