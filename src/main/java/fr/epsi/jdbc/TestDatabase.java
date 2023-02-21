package fr.epsi.jdbc;

import java.util.ResourceBundle;

abstract public class TestDatabase {

    protected static final String DB_URL;
    protected static final String DB_USER;
    protected static final String DB_PWD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_USER = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.pwd");
    }

}
