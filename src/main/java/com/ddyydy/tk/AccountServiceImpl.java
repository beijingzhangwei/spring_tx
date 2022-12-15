package com.ddyydy.tk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService_1")
public class AccountServiceImpl implements AccountService {
    //注入dao接口实例
    @Autowired
    private AccountDao dao;
    @Override
    public List<Account> getAll() {
        return dao.getAll();
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    @Override
    public int changemonkey() {
        dao.subMonkey();//id为2的先转出1000
        //int reuslt=5/0;//模拟一个异常，中断交易
        dao.addMonkey();//id为1的收到1000
        return 0;
    }

}