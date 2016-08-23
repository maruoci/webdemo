package com.bluesky.web.helper;

import com.bluesky.web.util.CollectionUtil;
import com.bluesky.web.util.PropsUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by 55 on 2016/8/23.
 */
public class DatabaseHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger("LOG_INFO");

    private static final String DRIVER ;
    private static final String URL ;
    private static final String USERNAME ;
    private static final String PASSWORD ;

    private static final QueryRunner QUERY_RUNNER = new QueryRunner();
    private static final ThreadLocal<Connection> CONNECTION_HOLDER = new ThreadLocal<Connection>();

    static{
        Properties conf = PropsUtils.loadProps("config.properties");
        DRIVER = conf.getProperty("jdbc.driver");
        URL = conf.getProperty("jdbc.url");
        USERNAME = conf.getProperty("jdbc.username");
        PASSWORD = conf.getProperty("jdbc.password");

        try{
            Class.forName(DRIVER);
        }catch(ClassNotFoundException e){
            LOGGER.info("load jdbc driver failure" , e);
        }
    }

    public static Connection getConnection(){
        Connection conn = CONNECTION_HOLDER.get();
        if(conn == null){
            try{
                conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            }catch (SQLException e){
                LOGGER.error("SQL Connection create Failure" , e);
            }finally {
                CONNECTION_HOLDER.set(conn);
            }
        }
        return conn;
    }

    public static void closeConnection(){
        Connection conn = CONNECTION_HOLDER.get();
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                LOGGER.error("SQL Connection close Failure" , e);
            }finally {
                CONNECTION_HOLDER.remove();
            }
        }
    }

    /**
     * 列表查询
     * @param entityClass
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public static <T> List<T> findList(Class<T> entityClass, String sql , Object... params){
        List<T> entityList ;
        Connection conn = getConnection();
        try{
            entityList = QUERY_RUNNER.query(conn , sql , new BeanListHandler<T>(entityClass),params);
        }catch (SQLException e){
            LOGGER.error("query entity List error " , e);
            throw new RuntimeException(e);
        }finally {
            closeConnection();
        }
        return entityList;
    }

    /**
     * 对象查询
     * @param entityClass
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public static <T> T findEntity(Class<T> entityClass , String sql , Object... params){
        T entity;
        Connection conn = getConnection();
        try{
            entity = QUERY_RUNNER.query(conn,sql,new BeanHandler<T>(entityClass),params);
        }catch (SQLException e){
            LOGGER.error("query entity Object error " , e);
            throw new RuntimeException(e);
        }finally {
            closeConnection();
        }
        return entity;
    }

    /**
     * update
     * @param sql
     * @param params
     * @return
     */
    public static int executeUpdate(String sql , Object... params){
        int rows = 0 ;
        Connection conn = getConnection();
        try{
            rows = QUERY_RUNNER.update(conn , sql ,params);
        }catch (SQLException e){
            LOGGER.error("execute Update Object error " , e);
            throw new RuntimeException(e);
        }finally {
            closeConnection();
        }
        return rows;
    }

    public static <T> boolean executeInsert(Class<T> entityClass, Map<String,Object> fieldMap){
        if(CollectionUtil.isEmpty(fieldMap)){
            LOGGER.error("Cannot insert entity : fieldMap is empty !");
            return false;
        }

        String sql = "INSERT INTO " + getTableName(entityClass);
        StringBuilder columns = new StringBuilder("(");
        StringBuilder values  = new StringBuilder("(");
        for(String fieldName : fieldMap.keySet()){
            columns.append(fieldName).append(", ");
            values.append("?, ");
        }
        columns.replace(columns.lastIndexOf(", "), columns.length() , ")"); // replace(star,end,str)
        values.replace(values.lastIndexOf(", "), values.length() , ")");

        sql += columns + " VALUES " + values ;
        Object[] params = fieldMap.values().toArray();

        return executeUpdate(sql , params) == 1 ;
    }

    public static <T> boolean updateEntity(Class<T> entityClass , long id , Map<String,Object> fieldMap){
        if(CollectionUtil.isEmpty(fieldMap)){
            LOGGER.error("Cannot update entity : fieldMap is empty !");
            return false;
        }
        String sql = "UPDATE "+ getTableName(entityClass) = " SET ";
        StringBuilder columns = new StringBuilder();
        for(String fieldName : fieldMap.keySet()){
            columns.append(fieldName).append("=?, ");
        }
        sql += columns.substring(0, columns.lastIndexOf(", ")) + " WHERE id=?";

        List<Object> paramList = new ArrayList<Object>();
        paramList.addAll(fieldMap.values());
        paramList.add(id);
        Object[] params = paramList.toArray();
        return executeUpdate(sql , params) == 1;
    }

    public static <T> boolean deleteEntity(Class<T> entityClass , long id){
        String sql = "DELETE FROM " + getTableName(entityClass) + " WHERE id=?";
        return executeUpdate(sql , id) == 1;
    }

    static String getTableName(String className){
        return className;
    }
}
