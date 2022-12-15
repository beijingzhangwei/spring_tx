package com.ddyydy.tk;

import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountDao {
    List<Account> getAll();//查询数据库中所有信息
    @Update("update posts set post_id=200 where id=1")
    int addMonkey();//给id为1的用户加1000块钱
    @Update("update posts set post_id=400 where id=2")
    int subMonkey();//给id为2的用户减1000块钱
}