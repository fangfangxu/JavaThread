# JavaThread
多线程实现

一、Java通过Executors提供四种线程池


     newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。 
     newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。 
     newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。 
     newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
     
 二、古老写法弊端
 
     new Thread(new Runnable() {
        
           @Override
           public void run() {
               // TODO Auto-generated method stub
           }
       }).start();    
 
     new Thread的弊端如下：
      a. 每次new Thread新建对象性能差。
      b. 线程缺乏统一管理，可能无限制新建线程，相互之间竞争，及可能占用过多系统资源导致死机或oom。
      c. 缺乏更多功能，如定时执行、定期执行、线程中断。
      相比new Thread，Java提供的四种线程池的好处在于：
      a. 重用存在的线程，减少对象创建、消亡的开销，性能佳。
      b. 可有效控制最大并发线程数，提高系统资源的使用率，同时避免过多资源竞争，避免堵塞。
      c. 提供定时执行、定期执行、单线程、并发数控制等功能。　    
      
三、 ExecutorService 的submit（） 与execute（）区别 

   1、接收的参数不一样 submit（）可以接受runnable和callable  有返回值
   execute（）接受runnable 无返回值。
   
   2、submit有返回值，而execute没有
   
     用到返回值的例子，比如说我有很多个做validation的task，我希望所有的task执行完，
     然后每个task告诉我它的执行结果，是成功还是失败，如果是失败，原因是什么。
 
   3、submit方便Exception处理
          
      意思就是如果你在你的task里会抛出checked或者unchecked exception，
      而你又希望外面的调用者能够感知这些exception并做出及时的处理，
      那么就需要用到submit，通过捕获Future.get抛出的异常。
      
四、shotdown（） showdownNow（）区别    

    可以关闭 ExecutorService，这将导致其拒绝新任务。提供两个方法来关闭 ExecutorService。 
    shutdown() 方法在终止前允许执行以前提交的任务， 
    shutdownNow() 方法阻止等待任务启动并试图停止当前正在执行的任务。在终止时执行程序没有任务在执行
    ，也没有任务在等待执行，并且无法提交新任务。关闭未使用的 ExecutorService 以允许回收其资源。 
    一般分两个阶段关闭 ExecutorService。第一阶段调用 shutdown 拒绝传入任务，然后调用 shutdownNow（如有必要）取消所有遗留的任务















  