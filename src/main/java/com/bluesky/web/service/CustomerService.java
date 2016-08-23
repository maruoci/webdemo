package com.bluesky.web.service;

import com.bluesky.web.helper.DatabaseHelper;
import com.bluesky.web.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 55 on 2016/8/22.
 */
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger("LOG_INFO");

    /**
     * 获取列表
     * @return
     */
    public List<Customer> getCustomerList(){

        String sql = "SELECT * FROM customer";
        return DatabaseHelper.findList(Customer.class,sql,null);
    }

    /**
     * 获取对象
     * @param id
     * @return
     */
    public Customer getCustomer(long id){
        //TODO
        return null;
    }

    /**
     * 增
     * @param fieldMap
     * @return
     */
    public boolean createCustomer(Map<String,Object> fieldMap){
        //TODO
        return false;
    }

    public boolean deleteCustomer(long id){
        //TODO
        return false;
    }

    public boolean updateCustomer(long id , Map<String,Object> fieldMap){
        //TODO
        return false;
    }
}
