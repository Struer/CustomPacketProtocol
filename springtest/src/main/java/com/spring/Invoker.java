package com.spring;

import java.lang.reflect.Method;

/**
 * 执行器
 */
public class Invoker {

    /**
     * 目标对象
     */
    private Object target;
    /**
     * 目标方法
     */
    private Method method;


    /**
     * 获取执行器方法
     * @param target
     * @param method
     * @return Invoker
     */
    public static Invoker valueOf(Object target, Method method) {
        Invoker invoker = new Invoker();
        invoker.setTarget(target);
        invoker.setMethod(method);
        return invoker;
    }

    /**
     * 执行
     *
     * @return
     */
    public Object invoke(Object[] args) {
        Object object = new Object();
        try {
            object = method.invoke(target, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
