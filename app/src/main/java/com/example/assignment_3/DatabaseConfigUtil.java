package com.example.assignment_3;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

public class DatabaseConfigUtil extends OrmLiteConfigUtil {

private static final Class<?>[] classes = new Class[]{Contacts.class};
    public static void main(String[] args) throws SQLException, IOException
        {
        try {
            writeConfigFile("ormlite_config.txt", classes);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  }

}
