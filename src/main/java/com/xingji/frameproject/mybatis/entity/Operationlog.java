package com.xingji.frameproject.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * operationlog
 * @author 
 */
@Data
@Getter
@Setter
public class Operationlog implements Serializable {
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "ETC/GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    private String operator;

    private String operation;

    private String method;

    private String params;

    private String ipaddress;

    private static final long serialVersionUID = 1L;
}