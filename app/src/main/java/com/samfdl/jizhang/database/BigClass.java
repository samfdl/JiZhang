package com.samfdl.jizhang.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 大类
 */
@Entity
public class BigClass {
    @Id
    private Long id;

    @NotNull
    private String className;
    @NotNull
    private String classType;

    @Generated(hash = 1848294728)
    public BigClass(Long id, @NotNull String className, @NotNull String classType) {
        this.id = id;
        this.className = className;
        this.classType = classType;
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

    public String getClassType() {
        return this.classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }
}