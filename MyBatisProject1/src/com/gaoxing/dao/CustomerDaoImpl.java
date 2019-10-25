package com.gaoxing.dao;

import com.gaoxing.domain.Customer;
import com.gaoxing.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public Customer getCustomerWidthId(Integer id) {
        SqlSession sqlSession = MybatisUtils.opensession();
        Customer customerById = sqlSession.selectOne("queryCustomerById", id);
        return customerById;
    }

    @Override
    public List<Customer> getAllCustomer() {
        SqlSession sqlSession = MybatisUtils.opensession();
        List<Customer> customers = sqlSession.selectList("queryAllCustomer");
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        SqlSession sqlSession = MybatisUtils.opensession();
        sqlSession.insert("insertCustom",customer);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updataCustomer(Customer customer) {
        SqlSession sqlSession = MybatisUtils.opensession();
        sqlSession.update("updataCustomer",customer);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteCUstomer(Integer id) {
        SqlSession sqlSession = MybatisUtils.opensession();
        sqlSession.delete("deleteCustomer",id);
        sqlSession.commit();
        sqlSession.close();
    }
}
