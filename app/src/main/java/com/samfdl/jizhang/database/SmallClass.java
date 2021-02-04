package com.samfdl.jizhang.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class SmallClass {
    @Id
    private Long id;

    @NotNull
    private String className;
    @NotNull
    private String classType;
    @NotNull
    private Long bigclassId;
    @Generated(hash = 434042290)
    public SmallClass(Long id, @NotNull String className, @NotNull String classType,
            @NotNull Long bigclassId) {
        this.id = id;
        this.className = className;
        this.classType = classType;
        this.bigclassId = bigclassId;
    }
    @Generated(hash = 1173518667)
    public SmallClass() {
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
    public Long getBigclassId() {
        return this.bigclassId;
    }
    public void setBigclassId(Long bigclassId) {
        this.bigclassId = bigclassId;
    }
}