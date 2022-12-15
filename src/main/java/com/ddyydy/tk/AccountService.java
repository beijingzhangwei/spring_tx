package com.ddyydy.tk;

import java.util.List;

public interface AccountService {
    List<Account> getAll();//查询所有

    int changemonkey();//模拟转账
}