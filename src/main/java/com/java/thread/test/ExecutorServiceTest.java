package com.java.thread.test;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("xuff-demo-pool-%d").build();
        //创建线程池
        ExecutorService executorService = new ThreadPoolExecutor(20, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        //接收结果FutureList
        List<Future<String>> resultList = new ArrayList<>();

        //创建10个任务并执行
        for (int i = 0; i < 10; i++) {
//使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            System.out.println(i);
            Future<String> future = executorService.submit(new TaskWithResult(i));
            //将执行结果存储到List中
            try{
                System.out.println(future.get());
            }catch (Exception e){
                System.out.println("*******异常");
                executorService.shutdown();
            }

        }


//        for (Future<String> fs : resultList) {
//            try {
//                System.out.println(fs.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//
//        }
    }
}
