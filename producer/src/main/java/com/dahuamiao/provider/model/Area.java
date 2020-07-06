package com.dahuamiao.provider.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Date;

/**
 * generated by Generate POJOs.groovy
 * <p>Date: 2019-09-10 15:35:10.</p>
 *
 * @author custom
 */

@TableName("cfg_area")
public class Area extends Model<Area> {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 所有父级id
     */
    private String parentIds;

    /**
     * 行政区域名称
     */
    private String name;

    /**
     * 行政区省份
     */
    private String provinceName;

    /**
     * 行政区全名
     */
    private String fullName;

    /**
     * 行政区别名
     */
    private String alias;

    /**
     * 首字母检索
     */
    private String abbr;

    /**
     * 电话区号
     */
    private String areaCode;

    /**
     * 拼音
     */
    private String pinyin;

    /**
     * 邮政编码
     */
    private String zip;

    /**
     * 行政区域类型（1-国家，2-省直辖市，3-市，4-县，区）
     */
    private Integer type;

    /**
     * 高德地图中城市对应的city_id
     */
    private String geoCityId;

    /**
     * 是否系统内置(1-是；0-否)
     */
    private Integer isSystem;

    /**
     * 逻辑删除状态（0-正常；1-删除）
     */
    private Integer delFlag;

    /**
     * 创建该记录的用户id
     */
    private Long creatorId;

    /**
     * 创建该记录的用户名称
     */
    private String creatorName;

    /**
     * 创建该记录的时间
     */
    private Date createTime;

    /**
     * 最后一次修改该记录的用户id
     */
    private Long updaterId;

    /**
     * 最后一次修改该记录的用户名称
     */
    private String updaterName;

    /**
     * 最后一次修改该记录的时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getGeoCityId() {
        return geoCityId;
    }

    public void setGeoCityId(String geoCityId) {
        this.geoCityId = geoCityId;
    }

    public Integer getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
