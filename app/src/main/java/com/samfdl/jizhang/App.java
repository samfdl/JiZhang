package com.samfdl.jizhang;

import android.app.Application;
import android.content.Context;

import com.samfdl.jizhang.database.DaoMaster;
import com.samfdl.jizhang.database.DaoSession;

import org.greenrobot.greendao.database.Database;

public class App extends Application {
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        // regular SQLite database
        ExampleOpenHelper helper = new ExampleOpenHelper(this, "notes-db");
        Database db = helper.getWritableDb();

        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static class ExampleOpenHelper extends DaoMaster.OpenHelper {
        public ExampleOpenHelper(Context context, String name) {
            super(context, name);
        }

        @Override
        public void onCreate(Database db) {
            super.onCreate(db);
        }
    }
}
