package com.example.demomybatisplus.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 联系人分组表
 *
 * @TableName ds_member_group
 */
@TableName(value = "ds_member_group", resultMap = "BaseResultMap")
@Data
public class DsMemberGroup implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 分组标识
     */
    @TableId(value = "id")
    private String id;
    /**
     * 企业标识
     */
    @TableField(value = "org_id")
    private String orgId;
    /**
     * 分组名称
     */
    @TableField(value = "name")
    private String name;
    /**
     * 动态条件
     */
    @TableField(value = "condition")
    private String condition;
    /**
     * 是否自动更新
     */
    @TableField(value = "auto")
    private Integer auto;
    /**
     * 分组同步令牌
     */
    @TableField(value = "sync_token")
    private String syncToken;
    /**
     * 自增seq
     */
    @TableField(value = "seq")
    private Integer seq;
    /**
     * 创建时间(北京时间)
     */
    @TableField(value = "create_time")
    private Date createTime;
    /**
     * 更新时间(北京时间)
     */
    @TableField(value = "update_time")
    private Date updateTime;
}
