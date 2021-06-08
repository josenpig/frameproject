package com.xingji.frameproject.mybatis.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * loginin
 * @author 
 */
@Data
public class Loginin implements Serializable {
    /**
     * 登陆日志id
     */
    private Integer id;

    /**
     * 登陆时间
     */
    private Date logintime;

    /**
     * 操作员
     */
    private String operator;

    /**
     * 操作员类别
     */
    private String typeofoperator;

    private static final long serialVersionUID = 1L;
}