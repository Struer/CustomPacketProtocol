package com.spring.service;

import com.spring.annotation.SocketCmd;
import com.spring.annotation.SocketModule;

@SocketModule(module = 1)
public interface UserService {

    /**
     * 登录
     */
    @SocketCmd(cmd = 1)
    public boolean login(String userName,String pwd);


    /**
     * 获取信息
     */
    @SocketCmd(cmd = 2)
    public void getinfo();
}
