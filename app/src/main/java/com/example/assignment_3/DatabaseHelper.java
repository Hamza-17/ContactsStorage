package com.example.assignment_3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "contacts.db";
    private static final int DATABASE_VERSION = 1;
    private Dao<Contacts, Integer> ContactDao = null;
    private RuntimeExceptionDao<Contacts,Integer> ContactRuntimeDao = null;

    public DatabaseHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion) {
        super(context, databaseName, factory, databaseVersion);
    }

/*
    public DatabaseHelper(Context context)
    {


        //super(DATABASE_NAME,null,DATABASE_VERSION,R.row.ormlite_config);

    }


 */

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
       try {

           TableUtils.createTable(connectionSource, Contacts.class);
       }
        catch (SQLException e) {
           e.printStackTrace();
       }


    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {
            TableUtils.dropTable(connectionSource,Contacts.class,true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Dao<Contacts, Integer> getDao() throws SQLException
    {
        if(ContactDao == null) {

            try {
                ContactDao = getDao(Contacts.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return ContactDao;


    }

    public RuntimeExceptionDao<Contacts, Integer> getContactRuntimeExceptionDao()
    {
        if(ContactRuntimeDao == null)
                ContactRuntimeDao = getRuntimeExceptionDao(Contacts.class);
        return ContactRuntimeDao;

    }
}
