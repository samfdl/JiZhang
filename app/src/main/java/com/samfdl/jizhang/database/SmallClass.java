package com.samfdl.jizhang.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class SmallClass {
    @Id
    private Long id;

    @Property
    private String className;

    @Property
    private Long bigclassId;

    @Generated(hash = 1173518667)
    public SmallClass() {
    }

    @Generated(hash = 906260281)
    public SmallClass(Long id, String className, Long bigclassId) {
        this.id = id;
        this.className = className;
        this.bigclassId = bigclassId;
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

    public Long getBigclassId() {
        return this.bigclassId;
    }

    public void setBigclassId(Long bigclassId) {
        this.bigclassId = bigclassId;
    }
}