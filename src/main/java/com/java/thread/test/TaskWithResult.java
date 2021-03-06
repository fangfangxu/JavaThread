package com.java.thread.test;

import java.util.Random;
import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    /**
     * 任务的具体过程，一旦任务传给ExecutorService的submit
     * 方法，则该方法自动在一个线程上执行
     *
     * @return
     * @throws Exception
     */
    @Override
    public String call() throws Exception {
        System.out.println("call()方法被自动调用，干活！" + Thread.currentThread().getName());

        if (id==2) {
            throw new TaskException("Meet error in task." + Thread.currentThread().getName());
        }

        return "call（）方法被自动调用，任务的结果是：" + id + "  " + Thread.currentThread().getName();
    }

    class TaskException extends Exception {
        public TaskException(String message) {
            super(message);
        }
    }
}
