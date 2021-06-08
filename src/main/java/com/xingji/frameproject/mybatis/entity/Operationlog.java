package com.xingji.frameproject.mybatis.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * operationlog
 * @author 
 */
@Data
@Getter
@Setter
public class Operationlog implements Serializable {
    private Integer id;

    private Date createtime;

    private String operator;

    private String operation;

    private String method;

    private String params;

    private String ipaddress;

    private static final long serialVersionUID = 1L;
}