package lesson10_04;

import java.sql.*;
import java.util.*;

public class MySqlDaoFactory implements DaoFactory {

    public String user = "root";//Логин пользователя
    public String password = "1234";//Пароль
    public String url = "jdbc:mysql://localhost:3306/daotrain";//URL адрес
    public String driver = "com.mysql.jdbc.Driver"; // Driver name
	
    public Connection getConnect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public StudentDao getStudentDao(Connection connection) throws DaoException {
        return new MySqlStudentDao(connection);
    }

    @Override
    public SubjectDao getSubjectDao(Connection connection) throws DaoException {
        return new MySqlSubjectDao(connection);
    }
	
    @Override
    public MarkDao getMarkDao(Connection connection) throws DaoException {
        return new MySqlMarkDao(connection);
	}
		
    public MySqlDaoFactory() {
        try {
            Class.forName(driver); //Register driver
			}
			catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}