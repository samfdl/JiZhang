package com.samfdl.jizhang.database;

/**
 * 初始化、存放及获取DaoUtils
 */
public class DaoUtilsStore {
    private volatile static DaoUtilsStore instance = new DaoUtilsStore();
    private CommonDaoUtils<SmallClass> mSmallClassDaoUtils;

    public static DaoUtilsStore getInstance() {
        return instance;
    }

    private DaoUtilsStore() {
        DaoManager mManager = DaoManager.getInstance();
        SmallClassDao smallClassDao = mManager.getDaoSession().getSmallClassDao();
        mSmallClassDaoUtils = new CommonDaoUtils<>(SmallClass.class, smallClassDao);
    }

    public CommonDaoUtils<SmallClass> getSmallClassDaoUtils() {
        return mSmallClassDaoUtils;
    }
}