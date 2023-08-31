# 目录

[toc]

# joker-demo-netty

- 时间：2023-08-30
- 参考链接：
  - [bugstack netty4.x](https://bugstack.cn/md/netty/base/2019-07-30-netty%E6%A1%88%E4%BE%8B%EF%BC%8Cnetty4.1%E5%9F%BA%E7%A1%80%E5%85%A5%E9%97%A8%E7%AF%87%E9%9B%B6%E3%80%8A%E5%88%9D%E5%85%A5JavaIO%E4%B9%8B%E9%97%A8BIO%E3%80%81NIO%E3%80%81AIO%E5%AE%9E%E6%88%98%E7%BB%83%E4%B9%A0%E3%80%8B.html)
  - [fuzhengwei / itstack-demo-netty](https://github.com/fuzhengwei/itstack-demo-netty)
  - [Netty - User guide for 4.x](https://netty.io/wiki/user-guide-for-4.x.html)
  - 



# joker-demo-netty-1-00

在Java中，提供了一些关于使用IO的API，可以供开发者来读写外部数据和文件，我们称这些API为Java IO。IO是Java中比较重要知识点，且比较难学习的知识点。并且随着Java的发展为提供更好的数据传输性能，目前有三种IO共存；分别是BIO、NIO和AIO。

![image-20230831232825921](https://2021-joker.oss-cn-shanghai.aliyuncs.com/java-img/image-20230831232825921.png)



> Java BIO[Blocking I/O] | 同步阻塞I/O模式

BIO 全称Block-IO 是一种同步且阻塞的通信模式。是一个比较传统的通信方式，模式简单，使用方便。但并发处理能力低，通信耗时，依赖网速。

> Java NIO[New I/O] | 同步非阻塞模式

+ Java NIO，全程 Non-Block IO ，是Java SE 1.4版以后，针对网络传输效能优化的新功能。是一种非阻塞同步的通信模式。
+ NIO 与原来的 I/O 有同样的作用和目的, 他们之间最重要的区别是数据打包和传输的方式。原来的 I/O 以流的方式处理数据，而 NIO 以块的方式处理数据。
+ 面向流的 I/O 系统一次一个字节地处理数据。一个输入流产生一个字节的数据，一个输出流消费一个字节的数据。
+ 面向块的 I/O 系统以块的形式处理数据。每一个操作都在一步中产生或者消费一个数据块。按块处理数据比按(流式的)字节处理数据要快得多。但是面向块的 I/O - 缺少一些面向流的 I/O 所具有的优雅性和简单性。

> Java AIO[Asynchronous I/O] | 异步非阻塞I/O模型

Java AIO，全程 Asynchronous IO，是异步非阻塞的IO。是一种非阻塞异步的通信模式。在NIO的基础上引入了新的异步通道的概念，并提供了异步文件通道和异步套接字通道的实现。

如下我们将分别对三种IO进行案例演示，通过对三种的IO的认知来方便学习后续的Netty知识。

## 知识补充

### java.nio.Buffer#flip

参考链接：

- https://www.cnblogs.com/woshijpf/articles/3723364.html



api doc:

```java
    /**
     * Flips this buffer.  The limit is set to the current position and then
     * the position is set to zero.  If the mark is defined then it is
     * discarded.
     *
     * <p> After a sequence of channel-read or <i>put</i> operations, invoke
     * this method to prepare for a sequence of channel-write or relative
     * <i>get</i> operations.  For example:
     *
     * <blockquote><pre>
     * buf.put(magic);    // Prepend header
     * in.read(buf);      // Read data into rest of buffer
     * buf.flip();        // Flip buffer
     * out.write(buf);    // Write header + data to channel</pre></blockquote>
     *
     * <p> This method is often used in conjunction with the {@link
     * java.nio.ByteBuffer#compact compact} method when transferring data from
     * one place to another.  </p>
     *
     * @return  This buffer
     */
    public final Buffer flip() {
        limit = position;
        position = 0;
        mark = -1;
        return this;
    }
```



buffer中的flip方法涉及到bufer中的Capacity,Position和Limit三个概念。

- 其中Capacity在读写模式下都是固定的，就是我们分配的**缓冲大小**,
- Position类似于**读写指针**，表示当前读(写)到什么位置,
- Limit在写模式下表示最多能写入多少数据，此时和Capacity相同，在读模式下表示最多能读多少数据，此时和缓存中的实际数据大小相同。

在写模式下调用`flip`方法，那么 limit 就设置为了 position 当前的值(即当前写了多少数据), postion会被置为0，以表示读操作从缓存的头开始读。也就是说**调用flip之后，读写指针指到缓存头部，并且设置了最多只能读出之前写入的数据长度(而不是整个缓存的容量大小)**。



**注意：**

- buffer.flip(); 一定得有，如果没有，就是从文件最后开始读取的，当然读出来的都是byte=0时候的字符。

- 通过buffer.flip();这个语句，就能把buffer的当前位置更改为buffer缓冲区的第一个位置。































# THE END