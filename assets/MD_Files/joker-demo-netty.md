# 目录

[toc]

# joker-demo-netty

- 时间：2023-08-30
- 参考链接：
  - [bugstack netty4.x](https://bugstack.cn/md/netty/base/2019-07-30-netty%E6%A1%88%E4%BE%8B%EF%BC%8Cnetty4.1%E5%9F%BA%E7%A1%80%E5%85%A5%E9%97%A8%E7%AF%87%E9%9B%B6%E3%80%8A%E5%88%9D%E5%85%A5JavaIO%E4%B9%8B%E9%97%A8BIO%E3%80%81NIO%E3%80%81AIO%E5%AE%9E%E6%88%98%E7%BB%83%E4%B9%A0%E3%80%8B.html)
  - [fuzhengwei / itstack-demo-netty](https://github.com/fuzhengwei/itstack-demo-netty)
  - [Netty - User guide for 4.x](https://netty.io/wiki/user-guide-for-4.x.html)
  - 



# ==入门篇==

# joker-demo-netty-1-00

- 主题：netty案例，netty4.1基础入门篇零《初入JavaIO之门BIO、NIO、AIO实战练习》

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













# joker-demo-netty-1-01

- 主题：netty案例，netty4.1基础入门篇一《嗨！NettyServer》

- 已测完





# joker-demo-netty-1-02

- 主题： netty案例，netty4.1基础入门篇二《NettyServer接收数据》
- 已测完







# joker-demo-netty-1-03

- 主题： netty案例，netty4.1基础入门篇三《NettyServer字符串解码器》



在实际开发中，server端接收数据后我们希望他是一个字符串或者是一个对象类型，而不是字节码，那么；

1. 在netty中是否可以自动的把接收的Bytebuf数据转String，不需要我手动处理？ 答；有，可以在管道中添加一个StringDecoder。
2. 在网络传输过程中有半包粘包的问题，netty能解决吗？ 答：能，netty提供了很丰富的解码器，在正确合理的使用下就能解决半包粘包问题。
3. 常用的String字符串下有什么样的解码器呢？ 答：不仅在String下有处理半包粘包的解码器在处理其他的数据格式也有，其中谷歌的protobuf数据格式就是其中一个。对于String的有以下常用的三种：
   1. LineBasedFrameDecoder 基于换行
   2. DelimiterBasedFrameDecoder 基于指定字符串
   3. FixedLengthFrameDecoder 基于字符串长度







# joker-demo-netty-1-04

- 主题：netty案例，netty4.1基础入门篇四《NettyServer收发数据》

本章节主要介绍服务端在收到数据后，通过writeAndFlush发送ByteBuf字节码向客户端传输信息。因为我们使用客户端模拟器的编码是GBK格式，所以代码中也需要将字节码转换为GBK，否则会乱码。











# joker-demo-netty-1-05

- 主题：netty案例，netty4.1基础入门篇五《NettyServer字符串编码器》



netty通信就向一个流水channel管道，我们可以在管道的中间插入一些‘挡板’为我们服务。比如字符串的编码解码，在前面我们使用new StringDecoder(Charset.forName("GBK"))进行字符串解码，这样我们在收取数据就不需要手动处理字节码。那么本章节我们使用与之对应的new StringEncoder(Charset.forName("GBK"))进行进行字符串编码，用以实现服务端在发送数据的时候只需要传输字符串内容即可。







# joker-demo-netty-1-06

- 主题：netty案例，netty4.1基础入门篇六《NettyServer群发消息》



在微信或者QQ的聊天中我们经常会用到一些群聊，把你的信息发送给所有用户。那么为了实现群发消息，在netty中我们可以使用ChannelGroup方式进行群发消息。如果为了扩展验证比如你实际聊天有不同的群，那么可以定义ConcurrentHashMap结构来存放ChannelGroup。ChannelGroup中提供了一些基础的方法；添加、异常、查找、清空、发放消息、关闭等。





# joker-demo-netty-1-07

- 主题：netty案例，netty4.1基础入门篇七《嗨！NettyClient》

在前六章的案例中使用socket模拟器链接我们的NettyServer，进行通信测试。本章节我们写一个helloworld版的NettyClient客户端，与我们的socket模拟器进行通信。在netty中客户端与服务端的写法基本类似，注意一些细节即可，这也是netty的强大之处，它把nio流与sokcet封装的相当简单易用。



# joker-demo-netty-1-08

- 主题：netty案例，netty4.1基础入门篇八《NettyClient半包粘包处理、编码解码处理、收发数据方式》

Netty开发中，客户端与服务端需要保持同样的；半包粘包处理，编码解码处理、收发数据方式，这样才能保证数据通信正常。在前面NettyServer的章节中我们也同样处理了；半包粘包、编码解码等，为此在本章节我们可以把这些知识模块开发到NettyClient中。本章节涉及到的知识点有；LineBasedFrameDecoder、StringDecoder、StringEncoder、ChannelInboundHandlerAdapter等。





# joker-demo-netty-1-09 - 有问题	

- 主题：netty案例，netty4.1基础入门篇九《自定义编码解码器，处理半包、粘包数据》



在实际应用场景里，只要是支持sokcet通信的都可以和Netty交互，比如中继器、下位机、PLC等。这些场景下就非常需要自定义编码解码器，来处理字节码传输，并控制半包、粘包以及安全问题。那么本章节我们通过实现ByteToMessageDecoder、MessageToByteEncoder来实现我们的需求。

> 数据传输过程中有各种情况；整包数据、半包数据、粘包数据，比如我们设定开始符号02、结束符号03； 整包数据；02 89 78 54 03 半包数据；02 89 78 粘包数据；02 89 78 54 03 02 89



测试的时候出问题了：

- 服务端收到数据直接 return 了







# joker-demo-netty-1-10

- 主题：netty案例，netty4.1基础入门篇十《关于ChannelOutboundHandlerAdapter简单使用》



ChannelOutboundHandlerAdapter与ChannelInboundHandlerAdapter都是继承于ChannelHandler，并实现自己的ChannelXxxHandler。用于在消息管道中不同时机下处理处理消息。



> ChannelInboundHandler拦截和处理入站事件，ChannelOutboundHandler拦截和处理出站事件。ChannelHandler和ChannelHandlerContext通过组合或继承的方式关联到一起成对使用。事件通过ChannelHandlerContext主动调用如read(msg)、write(msg)和fireXXX()等方法，将事件传播到下一个处理器。注意：入站事件在ChannelPipeline双向链表中由头到尾正向传播，出站事件则方向相反。 当客户端连接到服务器时，Netty新建一个ChannelPipeline处理其中的事件，而一个ChannelPipeline中含有若干ChannelHandler。如果每个客户端连接都新建一个ChannelHandler实例，当有大量客户端时，服务器将保存大量的ChannelHandler实例。为此，Netty提供了Sharable注解，如果一个ChannelHandler状态无关，那么可将其标注为Sharable，如此，服务器只需保存一个实例就能处理所有客户端的事件。

------

ChannelHandler类图 

![ChannelHandler类图](https://bugstack.cn/assets/images/pic-content/2019/08/ChannelHandler%E7%B1%BB%E5%9B%BE.png)





# joker-demo-netty-1-11

- 主题：netty案例，netty4.1基础入门篇十一《netty udp通信方式案例Demo》

在Netty通信中UDP的实现方式也非常简单，只要注意部分代码区别于TCP即可。本章节需要注意的知识点 ；NioDatagramChannel、ChannelOption.SO_BROADCAST

> Internet 协议集支持一个无连接的传输协议，该协议称为用户数据报协议（UDP，User Datagram Protocol）。UDP 为应用程序提供了一种无需建立连接就可以发送封装的 IP 数据报的方法。RFC 768 [1] 描述了 UDP。 Internet 的传输层有两个主要协议，互为补充。无连接的是 UDP，它除了给应用程序发送数据包功能并允许它们在所需的层次上架构自己的协议之外，几乎没有做什么特别的的事情。面向连接的是 TCP，该协议几乎做了所有的事情。







# joker-demo-netty-1-12

- 主题： netty案例，netty4.1基础入门篇十二《简单实现一个基于Netty搭建的Http服务》



Netty不仅可以搭建Socket服务，也可以搭建Http、Https服务。本章节我们通过一个简单的入门案例，来了解Netty搭建的Http服务，在我们后续的Netty网关服务中会使用到这样的功能点。

超文本传输协议（HTTP，HyperText Transfer Protocol)是互联网上应用最为广泛的一种网络协议。

> 在后端开发中接触HTTP协议的比较多，目前大部分都是基于Servlet容器实现的Http服务，往往有一些核心子系统对性能的要求非常高，这个时候我们可以考虑采用NIO的网络模型来实现HTTP服务，以此提高性能和吞吐量，Netty除了开发网络应用非常方便，还内置了HTTP相关的编解码器，让用户可以很方便的开发出高性能的HTTP协议的服务，Spring Webflux默认是使用的Netty。





# ==中级拓展篇==

# itstack-demo-netty-2-01

- 主题：netty案例，netty4.1中级拓展篇一《Netty与SpringBoot整合》

在实际的开发中，我们需要对netty服务进行更多的操作，包括；获取它的状态信息、启动/停止、对客户端用户强制下线等等，为此我们需要把netty服务加入到web系统中，那么本章节介绍如何将Netty与SpringBoot整合。

> Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。通过这种方式，Spring Boot致力于在蓬勃发展的快速应用开发领域(rapid application development)成为领导者。







## 测试

1. 启动SpringBoot *NettyApplication.main >run (即 NettyServer)
2. 启动ApiTest （即 NettyClient）
3. Web访问 *http://localhost:8080/nettyserver/localAddress
4. Web访问 *http://localhost:8080/nettyserver/isOpen
5. 观察结果





# itstack-demo-netty-2-02

- 主题： netty案例，netty4.1中级拓展篇二《Netty使用Protobuf传输数据》



















# THE END