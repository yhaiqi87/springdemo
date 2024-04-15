package com.example.demomybatisplus.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 联系人
 *
 * @TableName ds_member_member
 */
@TableName(value = "ds_member_member", resultMap = "BaseResultMap")
@Data
public class DsMemberMember implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(value = "member_id")
    private String memberId;
    /**
     * 联系人类型 0-个人联系人 1-机构联系人 2-内部联系人 3-隐藏的 4-项目
     */
    @TableField(value = "member_type")
    private Integer memberType;
    /**
     * 联系人状态 0-活动的 1-禁用的 2-注销的 3-隐藏的 4-删除
     */
    @TableField(value = "status")
    private Integer status;
    /**
     * 系统编号
     */
    @TableField(value = "sys_id")
    private String sysId;
    /**
     * 来源
     */
    @TableField(value = "source")
    private String source;
    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;
    /**
     * 电子邮箱 (邮箱与手机号必有其一)
     */
    @TableField(value = "email")
    private String email;
    /**
     * 手机号码 (邮箱与手机号必有其一)
     */
    @TableField(value = "phone")
    private String phone;
    /**
     * 性别
     */
    @TableField(value = "gender")
    private String gender;
    /**
     * 区域信息(省份、城市、区，源于第三方系统)，所属地区
     */
    @TableField(value = "region")
    private String region;
    /**
     * 备注
     */
    @TableField(value = "content")
    private String content;
    /**
     * 微信openId
     */
    @TableField(value = "open_id")
    private String openId;
    /**
     * 微信appId
     */
    @TableField(value = "app_id")
    private String appId;
    /**
     * 支付宝用户标识
     */
    @TableField(value = "ali_pay_user_id")
    private String aliPayUserId;
    /**
     * 联系人编号
     */
    @TableField(value = "member_no")
    private String memberNo;
    /**
     * 地址信息
     */
    @TableField(value = "address", typeHandler = JacksonTypeHandler.class)
    private List<String> address;
    /**
     * 员工编号
     */
    @TableField(value = "employee_id")
    private String employeeId;
    /**
     * 雇佣状态 0-无状态 1-在职 2-离职
     */
    @TableField(value = "employee_status")
    private Integer employeeStatus;
    /**
     * 生日
     */
    @TableField(value = "birthday")
    private Date birthday;
    /**
     * 所属部门
     */
    @TableField(value = "department")
    private String department;
    /**
     * 职位
     */
    @TableField(value = "position")
    private String position;
    /**
     * 机构编号
     */
    @TableField(value = "institute_id")
    private String instituteId;
    /**
     * 机构名称
     */
    @TableField(value = "institute_name")
    private String instituteName;
    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;
    /**
     * 联系人标签
     */
    @TableField(value = "labels"/*, typeHandler = JacksonTypeHandler.class*/)
    private List<String> labels;
    /**
     * 联系人扩展字段
     */
    @TableField(value = "field_val_list")
    private String fieldValList;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;
    /**
     * 联系人所在分组，一个联系人可以对应多个分组
     */
    @TableField(value = "groups"/*, typeHandler = JacksonTypeHandler.class*/)
    private List<Integer> groups;
    /**
     * 分组更新令牌
     */
    @TableField(value = "group_sync_token")
    private String groupSyncToken;
    /**
     * 组织标识
     */
    @TableField(value = "org_id"/*, jdbcType = JdbcType.BINARY, typeHandler = StringBinaryTypeHandler.class*/)
    private String orgId;
    /**
     * 所属门店id
     */
    @TableField(value = "store_id"/*, jdbcType = JdbcType.BINARY, typeHandler = StringBinaryTypeHandler.class*/)
    private String storeId;
    /**
     * 用户标识
     */
    @TableField(value = "user_id"/*, jdbcType = JdbcType.BINARY, typeHandler = StringBinaryTypeHandler.class*/)
    //@TableField(value = "user_id", jdbcType = JdbcType.BINARY)
    private String userId;
}
