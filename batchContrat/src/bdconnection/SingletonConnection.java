/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bdconnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fray
 */
public class SingletonConnection {

    private static SingletonConnection instance=null;
    private static Connection connection=null;

    public SingletonConnection() {
        try {
            Class.forName(BdConst.DRIVER_NAME);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SingletonConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("driver successffuly loaded");
        try {
            connection = DriverManager.getConnection(BdConst.DB_URL, BdConst.DB_USER_NAME, BdConst.DB_PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(SingletonConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("conection successffuly connected ");


    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        SingletonConnection.connection = connection;
    }

    public static SingletonConnection getInstance() {
        if (instance==null) {
            instance=new SingletonConnection();
        }

        return instance;
    }

    public static void setInstance(SingletonConnection instance) {
        SingletonConnection.instance = instance;
    }

    
}

