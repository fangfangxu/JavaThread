package com.java.thread.test;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class ExecutorServiceTest {

    public static void main(String[] args){
      //ExecutorService executorService= Executors.newFixedThreadPool(10);
     ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("xuff-demo-pool-%d").build();
      //创建线程池
     ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory,
             new ThreadPoolExecutor.AbortPolicy());

        


    }
}
