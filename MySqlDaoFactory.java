package les10;

import java.sql.*;
import java.util.*;
import java.io.*;

public class MySqlDaoFactory implements DaoFactory {
	
	Connection connection = null;
	
	// Constructor
    public MySqlDaoFactory() throws SQLException, IOException, FileNotFoundException {
        Properties props = new Properties();
		props.load(new FileInputStream("e:/repos/les10/config.properties"));
		this.connection =  DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("password"));
    }
	
	@Override
    public StudentDao getStudentDao() throws DaoException {
        return new MySqlStudentDao(connection);
    }

	@Override
    public SubjectDao getSubjectDao() throws DaoException {
        return new MySqlSubjectDao(connection);
    }
	
	@Override
    public MarkDao getMarkDao() throws DaoException {
        return new MySqlMarkDao(connection);
	}
	
	// Closes Connection instance object
	@Override
	public void close() throws SQLException {
		try {
			if (connection != null) {
				connection.close();
			} else {
				System.err.println("Connection was not established");
			}
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}
}
