package com.meituan.tuangou;

import lombok.Data;

/**
 * @author jiajia.xiao
 * @date 2021/10/1111:21
 */
@Data
public class MeiTuanConfig {

    /**
     * 网关地址
     */
    private String gateway;
    /**
     * 签名key
     */
    private String signKey;
    /**
     * token
     */
    private String appAuthToken;
    /**
     * 开发者id
     */
    private String developerId;
    /**
     * 业务id 1
     */
    private String businessId;
    /**
     *
     */
    private String charset = "UTF-8";
    /**
     * 版本号
     */
    private String version = "2";

}
