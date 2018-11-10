package com.spring;

import com.spring.annotation.SocketCmd;
import com.spring.annotation.SocketModule;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 初始化bean前后调用的方法类
 */
@Component
public class Scanner implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        Class<?>[] interfaces = clazz.getInterfaces();
        if (interfaces != null && interfaces.length > 0) {
            for (Class<?> interFace : interfaces) {
                SocketModule socketModule = interFace.getAnnotation(SocketModule.class);
                // 接口注解
                if (socketModule == null)
                    continue;
                Method[] methods = interFace.getMethods();
                // 方法注解
                if(methods != null && methods.length > 0) {
                    for (Method method : methods) {
                        SocketCmd socketCmd = method.getAnnotation(SocketCmd.class);
                        if (socketCmd == null)
                            continue;
                        short module = socketModule.module();
                        short cmd = socketCmd.cmd();

                        Invoker invoker = Invoker.valueOf(bean, method);

                        /**
                         * bean初始化后判断执行器管理者中是否添加过当前bean的执行器，没有则将执行器添加进管理者中
                         */
                        if (InvokerHolder.getInvoker(module, cmd) == null){
                            InvokerHolder.addInvoker(module, cmd, invoker);
                        } else {
                            System.out.println("重复注册执行器module："+module+"   cmd:"+cmd);
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
