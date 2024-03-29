### 一、什么是死锁？
- 所谓死锁，就是在两个或多个并发进程中，如果每个进程持有某种资源而又都等待着别的进程释放它或它们现在保持着的资源，否则就不能向前推进，此时每个进程都占用了一定的资源但又都不能向前推进，称这一组进程产生了死锁。
- 举个例子，如果此时有一个线程A持有a锁，按照先锁a再获得锁b的的顺序获得锁，而在此同时又有另外一个线程B，按照先锁b再锁a的顺序获得锁。如下图所示：


### 二、死锁产生的原因
- 资源竞争
- 操作系统中的资源分为两类
>（1）可剥夺资源，是指某进程在获得这类资源后，该资源可以再被其他进程或系统剥夺，CPU和主存均属于可剥夺性资源；
> （2）另一类资源是不可剥夺资源，当系统把这类资源分配给某进程后，再不能强行收回，只能在进程用完后自行释放，如磁带机、打印机等。
- 产生死锁的原因之一就是竞争不可剥夺资源，例如系统中只有一台打印机，进程A已经占用了打印机，而进程B也要使用打印机，此时B进程就会陷入阻塞；
- 原因二是竞争一些临时性资源（临时资源包括硬件中断、信号、消息、缓冲区内的消息等），通常消息通信顺序进行不当，则会产生死锁。
- 进程间推进顺序非法
例如，进程A在运行过程中请求资源R2，R2已经被B进程占有，A会发送阻塞；当运行进程B时需要请求R1，而R1已经被A占有，于是发生进程死锁。
### 三、死锁产生的必要条件
- 互斥条件：
> 指的是共享资源的互斥。主要是因为多个线程都想访问同一个共享资源，但是该共享资源在某个时刻只能由一个进程访问。
- 持有并等待条件：
> 某进程持有一些资源并等待另外一些资源，在这一过程中，该进程并不会放弃自己已经持有的资源。
- 不可剥夺条件：
> 某线程持有的资源在其使用完之前不能被其他线程获取，只能由其自己使用完后释放。
- 循环等待条件：
> 存在一个进程链，每个进程占有下一个进程所需要的至少一种资源。
### 四、死锁的解决方法
简单描述（四种方法）：

- 预防：通过设置某些限制条件，以破坏产生死锁的四个条件中的一个或者几个，来防止发生死锁。
- 避免：系统在分配资源时根据资源的使用情况提前作出预测，从而避免死锁的发生。
- 检测：允许系统在运行的过程中产生死锁，但是，系统中有相应的管理模块可以及时检测出已经产生的死锁，并且精确地确定与死锁有关的进程和资源，然后采取适当措施，清除系统中已经产生的死锁。
- 解除：与检测死锁相配套的一种措施，用于将进程从死锁状态下解脱出来。

解决死锁的具体描述：

- 预防死锁
> 根据死锁产生的四个必要条件，只要使用其中之一不能成立，死锁就不会出现。但必要条件①是由设备的固有特性所决定的，不仅不能改变，相反还应加以保证，因此实际上只有三种方法：
> 资源一次性分配：一次性分配所有资源，这样就不会再有请求了，只要有一个资源得不到分配，也不给这个进程分配其他的资源：（破坏请求条件）
- 可剥夺资源：即当某进程获得了部分资源，一但得不到其它资源，则释放已占有的资源（破坏不可剥夺条件）
- 资源有序分配法：系统给每类资源赋予一个编号，每一个进程按编号递增的顺序请求资源，释放则相反（破坏环路等待条件）
- 避免死锁
> 避免死锁，它是在进程请求分配资源时，采用某种算法（银行家算法）来预防可能发生的死锁，从而拒绝可能引起死锁的某个资源请求。

- 在避免死锁（或银行家算法）中必须谈到两种系统状态：
> 安全状态，指系统能按照某种顺序，为每个进程分配所需的资源，直至最大需求，使得每个进程都能顺利完成。
> 非安全状态：即在某个时刻系统中不存在一个安全序列，则称系统处于不安全状态或非安全状态。
虽然并非所有不安全状态都是死锁状态，但当系统进入不安全状态后，便有可能进入死锁状态；反之只要系统处于安全状态，系统便可避免进入死锁状态。因此，避免死锁的实质是如何使系统不进入不安全状态。
- 检测死锁
通过使用软件工具来检测死锁：

- Jstack命令
jstack是java虚拟机自带的一种堆栈跟踪工具。jstack用于打印出给定的java进程ID或核心文件或远程调试服务的Java堆栈信息。 Jstack工具可以用于生成java虚拟机当前时刻的线程快照。线程快照是当前java虚拟机内每一条线程正在执行的方法堆栈的集合，生成线程快照的主要目的是定位线程出现长时间停顿的原因，如线程间死锁、死循环、请求外部资源导致的长时间等待等。 线程出现停顿的时候通过jstack来查看各个线程的调用堆栈，就可以知道没有响应的线程到底在后台做什么事情，或者等待什么资源。

- JConsole工具
Jconsole是JDK自带的监控工具，在JDK/bin目录下可以找到。它用于连接正在运行的本地或者远程的JVM，对运行在Java应用程序的资源消耗和性能进行监控，并画出大量的图表，提供强大的可视化界面。而且本身占用的服务器内存很小，甚至可以说几乎不消耗

- 解除死锁
当发现有进程死锁后，便应立即把它从死锁状态中解脱出来，常采用的方法有：

- 剥夺资源：从其它进程剥夺足够数量的资源给死锁进程，以解除死锁状态；
- 撤消进程：可以直接撤消死锁进程或撤消代价最小的进程，直至有足够的资源可用，死锁状态消除为止；所谓代价是指优先级、运行代价、进程的重要性和价值等。
