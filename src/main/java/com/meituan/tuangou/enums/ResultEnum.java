package com.meituan.tuangou.enums;

/**
 * @Description 美团接口返回状态枚举类
 * @Author zhongo.yu
 * @Date 2021/10/11 16:18
 */
public enum ResultEnum {

    /**
     * 成功
     */
    OP_SUCCESS("OP_SUCCESS", "成功"),
    /**
     * token异常
     */
    OP_UNIAUTH_FAILED("OP_UNIAUTH_FAILED","token异常"),
    /**
     * 网路异常
     */
    OP_NETWORK_FAILED("OP_NETWORK_FAILED","网路异常"),
    /**
     *美团未知异常
     */
    OP_MEITUAN_FAIL("OP_MEITUAN_FAIL","美团未知异常");
    /**
     * code
     */
    private String code;

    /**
     * name
     */
    private String name;

    ResultEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
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
    public static ResultEnum getResultEnumByCode(String code) {
        if (code == null) {
            return null;
        }

        for (ResultEnum e : ResultEnum.values()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }

        return null;
    }
}
