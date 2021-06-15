package com.xingji.frameproject.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * operationlog
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operationlog implements Serializable {
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    private String operator;

    private String operation;

    private String method;

    private String params;

    private String ipaddress;

    private static final long serialVersionUID = 1L;
}