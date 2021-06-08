package com.xingji.frameproject.mybatis.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * sys_user_role
 * @author 
 */
@Data
public class SysUserRole implements Serializable {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 角色id
     */
    private Integer roleId;

    private static final long serialVersionUID = -33306975164235045L;
}