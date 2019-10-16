package com.gaoxing.demo2;

public interface AccountDao {
    /* 加钱 */
    public void addMoney(String name,Double money);

    /* 减钱 */
    public void minusMoney(String name,Double money);

}
