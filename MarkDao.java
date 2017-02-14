package les10;

import java.util.*;
import java.sql.*;

public interface MarkDao {

    // Создает новую запись и соответствующий ей объект
	public void create(Mark mark) throws DaoException;

    // Возвращает объект соответствующий записи с первичным ключом key или null
	public Mark read(int key) throws DaoException;

    //Сохраняет состояние объекта в базе данных
	public void update(Mark mark) throws DaoException;

    //Удаляет запись об объекте из базы данных
	public void delete(int key) throws DaoException;

    //Возвращает список объектов соответствующих всем записям в базе данных
	public List<Mark> getAll() throws DaoException;
	
	//Возвращает список оценок одного студента
	public List<Mark> getAllMarkOneStud (int key) throws DaoException;
	
	//Закрывает соединение и все PreparedStatement's
	public void close() throws DaoException;
}