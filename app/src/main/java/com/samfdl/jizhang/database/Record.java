package com.samfdl.jizhang.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 记账的一条记录
 */
@Entity
public class Record {
    @Id(autoincrement = true)
    private Long id;

    @Generated(hash = 299894576)
    public Record(Long id) {
        this.id = id;
    }

    @Generated(hash = 477726293)
    public Record() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}