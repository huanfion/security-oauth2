package com.zegobird.oauth2.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "tb_content_category")
public class TbContentCategory implements Serializable {
    /**
     * 类目ID
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "\"name\"")
    private String name;

    /**
     * 状态。可选值:1(正常),2(删除)
     */
    @Column(name = "\"status\"")
    private Short status;

    /**
     * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
     */
    @Column(name = "sort_order")
    private Integer sortOrder;

    /**
     * 该类目是否为父类目，1为true，0为false
     */
    @Column(name = "is_parent")
    private Short isParent;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;

    private static final long serialVersionUID = 1L;
}