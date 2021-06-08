package com.xingji.frameproject.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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