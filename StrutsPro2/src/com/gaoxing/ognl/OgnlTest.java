package com.gaoxing.ognl;

import com.gaoxing.domain.Goods;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import org.junit.Test;

public class OgnlTest {
    @Test
    public void test1(){
        // ognl使用
        OgnlContext ognlContext = new OgnlContext();
        // 存数据  根对象
        ognlContext.setRoot("aaa");
        // 取数据
        Object root = Ognl.getRoot(ognlContext);
        System.out.println(root);
    }

    @Test
    public void test2() throws OgnlException {
        // ognl使用
        OgnlContext ognlContext = new OgnlContext();
        // 存数据  根对象
        Goods goods = new Goods();
        goods.setName("豆腐干");
        goods.setPrice(888.0);

        ognlContext.setRoot(goods);

        // 获取root
        Object root = ognlContext.getRoot();
        // 1.表达式 取哪一个字段
        // 2.ognlContext
        // 3.root
        Object name = Ognl.getValue("name", ognlContext, root);
        System.out.println(name);

    }

    @Test
    public void test3() throws OgnlException {
        // ognl使用
        OgnlContext ognlContext = new OgnlContext();
        // 存数据  非根对象
        Goods goods = new Goods();
        goods.setName("豆腐干");
        goods.setPrice(888.0);
        // 非根对象不能直接取字段 取得时候就是存得内容
        ognlContext.put("goods",goods);

        // 获取root
        Object root = ognlContext.getRoot();
        // 1.表达式 #key
        // 2.ognlContext
        // 3.root
        Goods obj = (Goods)Ognl.getValue("#goods", ognlContext, root);
        System.out.println(obj.getName());
        System.out.println(obj.getPrice());

    }
}
