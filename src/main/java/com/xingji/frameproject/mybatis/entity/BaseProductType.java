package com.xingji.frameproject.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (BaseProductType)实体类
 *
 * @author makejava
 * @since 2021-06-15 09:58:07
 */
@Data
public class BaseProductType implements Serializable {
    private static final long serialVersionUID = -19189572145709900L;
    /**
     * 分类id
     */
    private Integer id;
    /**
     * 分类名称
     */
    private String label;
    /**
     * 父级分类id
     */
    private Integer productTypeParentId;

    /**
     * 子组件
     */
    private List<BaseProductType> children;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getProductTypeParentId() {
        return productTypeParentId;
    }

    public void setProductTypeParentId(Integer productTypeParentId) {
        this.productTypeParentId = productTypeParentId;
    }

    public List<BaseProductType> getChildren() {
        return children;
    }

    public void setChildren(List<BaseProductType> children) {
        this.children = children;
    }
}
