package com.meituan.tuangou;

import com.meituan.tuangou.constant.GroupBuyConstant;
import com.meituan.tuangou.enums.ResultEnum;
import com.meituan.tuangou.exception.AccessTokenException;
import com.meituan.tuangou.result.BaseResult;
import com.meituan.tuangou.util.JsonUtil;
import com.meituan.tuangou.util.SignUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author jiajia.xiao
 * @date 2021/10/1111:30
 */
@Slf4j
public abstract class BaseMeiTuanCouponService implements MeiTuanCouponService {

    /**
     * 美团网关地址
     */
    protected static final String API_GATEWAY = "https://api-open-cater.meituan.com";

    /**
     * 美团授权网关地址
     */
    protected static final String AUTH_GATEWAY = "https://open-erp.meituan.com";

    /**
     * 连接时间
     */
    private static final long CONNECT_TIMEOUT = 15000;
    /**
     * 最大链接数
     */
    private static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 300;
    /**
     * 最大空闲链接数
     */
    private static final int MAX_IDLE_CONNECTIONS = 100;
    /**
     * 增量
     */
    private static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 5;
    /**
     * client
     */
    private static OkHttpClient OKHTTPCLIENT;
    /**
     * 空闲连接数生存时间
     */
    private static final long KEEP_ALIVE_DURATION = 5;

    /**
     * 走配置中心
     */
    protected MeiTuanConfig config;

    static {
        ConnectionPool connectionPool = new ConnectionPool(MAX_IDLE_CONNECTIONS, KEEP_ALIVE_DURATION, TimeUnit.MINUTES);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(DEFAULT_MAX_TOTAL_CONNECTIONS);
        dispatcher.setMaxRequestsPerHost(DEFAULT_MAX_CONNECTIONS_PER_ROUTE);
        OKHTTPCLIENT = new OkHttpClient.Builder()
                .connectionPool(connectionPool)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                .dispatcher(dispatcher)
                .build();
    }

    /**
     * @return
     */

    @Override
    public MeiTuanConfig getConfig() {
        //正常配置可以走配置中心
        MeiTuanConfig  meiTuanConfig = new MeiTuanConfig();
        meiTuanConfig.setCharset(config.getCharset());
        meiTuanConfig.setBusinessId(config.getBusinessId());
        meiTuanConfig.setDeveloperId(config.getDeveloperId());
        meiTuanConfig.setVersion(config.getVersion());
        meiTuanConfig.setSignKey(config.getSignKey());
        meiTuanConfig.setAppAuthToken(config.getAppAuthToken());
        return meiTuanConfig;
    }

    private Map<String, String> getMapParam(String bizJson) {
        MeiTuanConfig config = this.getConfig();
        Map<String, String> params = new LinkedHashMap<>(16);
        params.put(GroupBuyConstant.APPAUTHTOKEN,config.getAppAuthToken());
        params.put(GroupBuyConstant.BIZ, bizJson);
        params.put(GroupBuyConstant.BUSINESSID, config.getBusinessId());
        params.put(GroupBuyConstant.CHARSET, config.getCharset());
        params.put(GroupBuyConstant.DEVELOPERID, config.getDeveloperId());
        long timestamp = System.currentTimeMillis() / 1000;
        params.put(GroupBuyConstant.TIMESTAMP, String.valueOf(timestamp));
        params.put(GroupBuyConstant.VERSION, config.getVersion());
        return params;
    }

    /**
     * 参数签名
     *
     * @param params
     * @return
     */
    private String sign(Map<String, String> params) {
        MeiTuanConfig config = this.getConfig();
        String sign = SignUtil.getSign(config.getSignKey(), params);
        return sign;
    }

    @Override
    public String post(String url, String bizJson) {
        String resultStr = "";
        try {
            //请求
            Map<String, String> param = this.getMapParam(bizJson);
            param.put(GroupBuyConstant.SIGN, this.sign(param));

            Request.Builder requestBuilder = new Request.Builder();
            requestBuilder.addHeader("Content-Type", "application/x-www-form-urlencoded");
            FormBody.Builder builder = new FormBody.Builder();
            for (String key : param.keySet()) {
                builder.add(key, param.get(key));
            }
            Request request = requestBuilder.post(builder.build()).url(url).build();
            Call call = OKHTTPCLIENT.newCall(request);
            okhttp3.Response response = call.execute();
            resultStr = Objects.requireNonNull(response.body()).string();
            log.info("okhttp post请求结果. url：{} param：{} result:{}", url, param, resultStr);
            return resultStr;
        } catch (AccessTokenException e) {
            return this.getError(ResultEnum.OP_UNIAUTH_FAILED);
        } catch (IOException e) {
            log.error("okhttp post请求异常. url：{} param：{}", url, bizJson, e);
            return this.getError(ResultEnum.OP_NETWORK_FAILED);
        } catch (Exception e) {
            log.error("okhttp post请求异常. url：{} param：{}", url, bizJson, e);
            return this.getError(ResultEnum.OP_MEITUAN_FAIL);
        }
    }

    /**
     * 异常
     * @param resultEnum
     * @return
     */
    private String getError(ResultEnum resultEnum){
        BaseResult result = new BaseResult();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getCode());
        return JsonUtil.jsonString(result);
    }

}
