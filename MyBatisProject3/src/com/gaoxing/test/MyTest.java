package com.gaoxing.test;

import com.gaoxing.domain.Customer;
import com.gaoxing.domain.Order;
import com.gaoxing.mapper.CustomerMapper;
import com.gaoxing.mapper.OrderMapper;
import com.gaoxing.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void getAccountCustomer(){
        /* 查总数 */
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Integer accountCustomer = mapper.getAccountCustomer();
        System.out.println(accountCustomer);
        sqlSession.close(); // 11

    }

    @Test
    public void getCustomer(){
        /* 查记录 返回对应类 */
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.getCustomer(1);
        System.out.println(customer); // Customer(cust_ids=1, cust_names=高星, cust_professions=射手, cust_phones=15937067033, email=12341241@qq.com)
        sqlSession.close();
    }

    @Test
    public void getCustomerWidthId(){
        /* 查记录 返回对应Map */
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Map<String, Object> customerWidthId = mapper.getCustomerWidthId(1);
        System.out.println(customerWidthId); // {cust_profession=射手, cust_name=高星, cust_id=1, cust_phone=15937067033, email=12341241@qq.com}
        sqlSession.close();
    }

    @Test
    public void getAllCustomer(){
        /* 查询所有客户 key为指定字段，value为对应类 */
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Map<Integer, Customer> allCustomer = mapper.getAllCustomer();
        System.out.println(allCustomer);
        // {1={cust_profession=射手, cust_name=高星, cust_id=1, cust_phone=15937067033, email=12341241@qq.com}, 2={cust_profession=刺客, cust_name=李白, cust_id=2, cust_phone=18977665521, email=libai@163.com}...}
        sqlSession.close();
    }

    @Test
    public void getAllListCustomer(){
        /* 查询所有客户 返回list 集合 */
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> allListCustomer = mapper.getAllListCustomer();
        System.out.println(allListCustomer);
        // [Customer(cust_id=1, cust_name=高星, cust_profession=射手, cust_phone=15937067033, email=12341241@qq.com), Customer(cust_id=2, cust_name=李白, cust_profession=刺客, cust_phone=18977665521, email=libai@163.com)...]
        for (Customer customer : allListCustomer) {
            System.out.println(customer);
            /**
             * Customer(cust_id=1, cust_name=高星, cust_profession=射手, cust_phone=15937067033, email=12341241@qq.com)
             * Customer(cust_id=2, cust_name=李白, cust_profession=刺客, cust_phone=18977665521, email=libai@163.com)
             * ...
             */
        }
        sqlSession.close();
    }

    @Test
    public void getAllOrder(){
        SqlSession sqlSession = MybatisUtils.opensession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> allOrder = mapper.getAllOrder();
        for (Order order : allOrder) {
            System.out.println(order);
            /**
             * Order(order_id=1, order_name=订单名称1, order_num=1001, customer=Customer(cust_id=1, cust_name=高星, cust_profession=射手, cust_phone=15937067033, email=12341241@qq.com))
             * Order(order_id=2, order_name=订单名称2, order_num=1002, customer=Customer(cust_id=3, cust_name=阿轲, cust_profession=刺客, cust_phone=18977665997, email=aike@qq.com))
             * ...
             */
        }
        sqlSession.close();
    }

    @Test
    public void getOrderWidthId(){
        SqlSession sqlSession = MybatisUtils.opensession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order orderWidthId = mapper.getOrderWidthId(1);
        System.out.println(orderWidthId.getCustomer().getCust_name()); // 高星 懒加载，用到的时候才执行相关sql语句
        //System.out.println(orderWidthId); // Order(order_id=1, order_name=订单名称1, order_num=1001, customer=Customer(cust_id=1, cust_name=高星, cust_profession=射手, cust_phone=15937067033, email=12341241@qq.com))
        sqlSession.close();
    }

    @Test
    public void saveBoth(){
        /* 多对一添加操作 */
        /* 把新的订单添加到新的客户 */
        SqlSession sqlSession = MybatisUtils.opensession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        Customer customer = new Customer();
        customer.setCust_name("新客户001");
        customer.setCust_phone("15937067033");
        customer.setCust_profession("护士");
        customer.setEmail("1511844263@qq.com");

        Order order = new Order();
        order.setOrder_name("新订单001");
        order.setOrder_num("201910260001");

        order.setCustomer(customer);

        /**
         * 先添加客户 获取客户生成的id 再添加订单
         */

        // 保存客户
        customerMapper.insertCustomer(customer);
        System.out.println(customer); // Customer(cust_id=19, cust_name=新客户001, cust_profession=护士, cust_phone=15937067033, email=1511844263@qq.com)

        // 保存订单
        orderMapper.insertOrder(order);
        System.out.println(order); // Order(order_id=7, order_name=新订单001, order_num=201910260001, customer=Customer(cust_id=19, cust_name=新客户001, cust_profession=护士, cust_phone=15937067033, email=1511844263@qq.com))

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void test5(){
        /* 把新的订单添加到获取的客户 */
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        Order order1 = new Order();
        order1.setOrder_name("测试订单1");
        order1.setOrder_num("0001");

        Order order2 = new Order();
        order2.setOrder_name("测试订单2");
        order2.setOrder_num("0002");

        Customer customer = customerMapper.getCustomer(1);
        order1.setCustomer(customer);
        order2.setCustomer(customer);

        orderMapper.insertOrder(order1);
        orderMapper.insertOrder(order2);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void getAllCustomers(){
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> allCustomers = customerMapper.getAllCustomers();
        for (Customer allCustomer : allCustomers) {
            System.out.println(allCustomer);
            /**
             * 先把所有的customer都查了出来，
             * 打印的时候，打印一条记录，发送一条sql语句
             */
        }
        sqlSession.close();
    }

    @Test
    public void test6(){
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        Customer customer = new Customer();
        customer.setCust_name("新客户");

        Order order1 = new Order();
        order1.setOrder_name("订单1");
        order1.setOrder_num("111111");

        Order order2 = new Order();
        order2.setOrder_name("订单2");
        order2.setOrder_num("222222");

        /*List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        customer.setOrders(orders);*/

        customer.getOrders().add(order1);
        customer.getOrders().add(order2);

        // 保存客户
        customerMapper.insertCustomer(customer);
        // 保存订单
        orderMapper.insertOrder(order1);
        orderMapper.insertOrder(order2);
        // 更新关系
        for (Order order : customer.getOrders()) {
            orderMapper.updateOrder(customer.getCust_id(),order.getOrder_id());
        }

        sqlSession.commit();
        sqlSession.close();

    }
}
