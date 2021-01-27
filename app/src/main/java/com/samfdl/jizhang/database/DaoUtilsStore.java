package com.samfdl.jizhang.database;

/**
 * 初始化、存放及获取DaoUtils
 */
public class DaoUtilsStore {
    private volatile static DaoUtilsStore instance = new DaoUtilsStore();
    private CommonDaoUtils<SmallClass> mUserDaoUtils;

    public static DaoUtilsStore getInstance() {
        return instance;
    }

    private DaoUtilsStore() {
        DaoManager mManager = DaoManager.getInstance();
        SmallClassDao _UserDao = mManager.getDaoSession().getSmallClassDao();
        mUserDaoUtils = new CommonDaoUtils<>(SmallClass.class, _UserDao);
    }

    public CommonDaoUtils<SmallClass> getUserDaoUtils() {
        return mUserDaoUtils;
    }
}