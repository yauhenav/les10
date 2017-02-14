package les10;

import java.util.*;
import java.sql.*;

public interface MarkDao {

    // ������� ����� ������ � ��������������� �� ������
	public void create(Mark mark) throws DaoException;

    // ���������� ������ ��������������� ������ � ��������� ������ key ��� null
	public Mark read(int key) throws DaoException;

    //��������� ��������� ������� � ���� ������
	public void update(Mark mark) throws DaoException;

    //������� ������ �� ������� �� ���� ������
	public void delete(int key) throws DaoException;

    //���������� ������ �������� ��������������� ���� ������� � ���� ������
	public List<Mark> getAll() throws DaoException;
	
	//���������� ������ ������ ������ ��������
	public List<Mark> getAllMarkOneStud (int key) throws DaoException;
	
	//��������� ���������� � ��� PreparedStatement's
	public void close() throws DaoException;
}