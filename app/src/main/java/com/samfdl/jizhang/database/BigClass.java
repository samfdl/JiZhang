package com.samfdl.jizhang.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 大类
 */
@Entity
public class BigClass {
    @Id(autoincrement = true)
    private Long id;

    @Property
    private String className;

    @Generated(hash = 1182590857)
    public BigClass(Long id, String className) {
        this.id = id;
        this.className = className;
    }

    @Generated(hash = 70346398)
    public BigClass() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}