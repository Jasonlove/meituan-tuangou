package com.meituan.tuangou.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author jiajia.xiao
 * @date 2021/10/716:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DealMenu implements Serializable {

    /**
     * 字段内容
     */
    private String content;
    /**
     * 数量/规格
     */
    private String specification;
    /**
     * 单价
     */
    private Double price;
    /**
     * 小计
     */
    private Double total;
    /**
     * 区别表头和行：0表示表头，128表示行
     */
    private String type;
    /**
     * 图片
     */
    private List<String> images;
    /**
     * 描述
     */
    private String desc;

}
