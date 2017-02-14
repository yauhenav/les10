package les10;

import java.util.*;
import java.sql.*;

public interface SubjectDao {

    // ������� ����� ������ � ��������������� �� ������
	public void create(Subject subject) throws DaoException;

    // ���������� ������ ��������������� ������ � ��������� ������ key ��� null
	public Subject read(int key) throws DaoException;

    //��������� ��������� ������� group � ���� ������
	public void update(Subject subject) throws DaoException;

    //������� ������ �� ������� �� ���� ������
	public void delete(Subject subject)  throws DaoException;

    //���������� ������ �������� ��������������� ���� ������� � ���� ������
	public List<Subject> getAll() throws DaoException;
	
	//��������� ���������� � ��� PreparedStatement's
	public void close() throws DaoException;
}