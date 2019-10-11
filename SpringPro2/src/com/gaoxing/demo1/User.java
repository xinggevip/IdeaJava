package com.gaoxing.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Component("user")等同于这种写法：
 *  <bean id="user" class="下面的class"></bean>
 */
@Component("user")
public class User {
    /**
     * @Value("Tom")等同于这种写法：
     * <property name="name" value="Tom"/>
     */
    @Value("Tom")
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
