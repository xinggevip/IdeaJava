package com.gaoxing.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @Component("user")等同于这种写法：
 *  <bean id="user" class="下面的class"></bean>
 */
@Component("user")
@Scope("prototype")
public class User {
    /**
     * @Value("Tom")等同于这种写法：
     * <property name="name" value="Tom"/>
     */
    @Value("Tom")
    private String name;

    // 引用数据类型，前提是改引用被spring管理
    /**等同于这种写法：
     * <property name="dog" ref="dog"/>
     */
    // @Autowired /* 根据类型注入 */
    // @Qualifier("dog") /* 根据名称注入 */

    @Resource(name = "dog") // 等同于上面两句注释的组合写法
    private Dog dog;

    @PostConstruct
    public void init(){
        System.out.println("init----创建时调用");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy----销毁时调用(单例模式开发)");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }
}
