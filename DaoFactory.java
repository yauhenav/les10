package les10;

import java.sql.*;

public interface DaoFactory {

    // Возвращает подключение к базе данных
    public Connection getConnect() throws SQLException;

    // Возвращает объект для управления персистентным состоянием объекта Student
    public StudentDao getStudentDao(Connection connection) throws DaoException;

    // Возвращает объект для управления персистентным состоянием объекта Subject
    public SubjectDao getSubjectDao(Connection connection) throws DaoException;
	
	// Возвращает объект для управления персистентным состоянием объекта Mark
	public MarkDao getMarkDao (Connection connection) throws DaoException;
}