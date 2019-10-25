package com.gaoxing.domain.sub1;

import org.apache.ibatis.type.Alias;

@Alias("MyClass1")
public class MyClass {
    // 设置了批量起别名，别名为类名，但是子包内有名字重复的类，则使用注解起别名解决
}
