package com.yyl.one.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2022/2/23 09:57
 */
public class AIOTest {
	/*public void test(){
		try {
			AsynchronousServerSocketChannel serverSock =AsynchronousServerSocketChannel.open().bind(8080);
			serverSock.accept(serverSock, new CompletionHandler<>() {
			 //为异步操作指定CompletionHandler回调函数
				public void completed(AsynchronousSocketChannel sockChannel, AsynchronousServerSocketChannel serverSock) {
					serverSock.accept(serverSock, this);
					// 另外一个 write（sock，CompletionHandler{}）
					sayHelloWorld(sockChannel, Charset.defaultCharset().encode
							("Hello World!"));
				}
				// 省略其他路径处理方法...
			});
		}catch (Exception e){

		}

	}*/


	private void sayHelloWorld(ServerSocketChannel server, ByteBuffer s) throws IOException {
		try (SocketChannel client = server.accept();) {
			client.write(Charset.defaultCharset().encode("Hello world!"));
		}
	}
}
