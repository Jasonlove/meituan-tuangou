package com.meituan.tuangou.enums;

/**
 * 美团接口返回业务状态枚举类
 * @author jiajia.xiao
 * @date 2021/10/1115:27
 */
public enum BusinessResultEnum {

    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 券码不存在
     */
    COUPON_CODE_NOT_(1006, "券码超出可撤销时间范围"),

    /**
     * 券码不存在
     */
    COUPON_CODE_NOT_EXIST(1007, "券码不存在"),

    /**
     * 不存在此门店
     */
    COUPON_SHOP_NOT_EXIST(3001, "券不属于该分店，不能接待"),

    /**
     * 美团券已过期
     */
    COUPON_TIMED_STATE(3019, "美团券已过期"),

    /**
     * 美团券已退款
     */
    COUPON_REFUNDED(3020, "美团券已退款"),

    /**
     * 美团券作弊已冻结
     */
    COUPON_FREEZE_STATE(3021, "美团券作弊已冻结"),

    /**
     * 券码不存在
     */
    COUPON_TIME_NOT_EXIST(3025, "券码不在使用时间段内，暂时无法验证");


    /**
     * code
     */
    private Integer code;

    /**
     * name
     */
    private String name;



    BusinessResultEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }



    /**
     * 根据code获取枚举
     *
     * @param code
     * @return
     */
    public static BusinessResultEnum getResultEnumByCode(String code) {
        if (code == null) {
            return null;
        }

        for (BusinessResultEnum e : BusinessResultEnum.values()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }

        return null;
    }

}
