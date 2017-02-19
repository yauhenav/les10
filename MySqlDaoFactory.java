package les10;

import java.sql.*;
import java.util.*;
import java.io.*;

public class MySqlDaoFactory implements DaoFactory {

    public Connection getConnect() throws SQLException, IOException, FileNotFoundException {
        Properties props = new Properties();
		props.load(new FileInputStream("e:/repos/les10/config.properties"));
		return DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("password"));
    }

    public StudentDao getStudentDao(Connection connection) throws DaoException {
        return new MySqlStudentDao(connection);
    }

    public SubjectDao getSubjectDao(Connection connection) throws DaoException {
        return new MySqlSubjectDao(connection);
    }
	
    public MarkDao getMarkDao(Connection connection) throws DaoException {
        return new MySqlMarkDao(connection);
	}
}
