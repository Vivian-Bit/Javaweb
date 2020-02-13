package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static class Task implements Runnable {
        private final Socket socket;

        public Task(Socket socket) {
            this.socket = socket;
        }

        // 两个阻塞点，鱼与熊掌不可兼得，所以使用线程方式处理
        @Override
        public void run() {
            try {
                // 面向字节流的
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();

                // 可以有个循环
                is.read();      // 第二个阻塞点
                // 面向字节流的，所以处理应用层协议有点复杂
                // 从 is 中读取请求内容，需要进行应用层协议分包
                // 将响应内容发送到 os 中，需要遵守应用层协议

                socket.close(); // 可以 Server 关闭，可以 Client 关闭
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        // 实际做了 3 个事情
        // 1. 新建 socket
        // 2. 绑定本地 ip + 本地端口
        // 3. 开始 listen(监听）
        ServerSocket serverSocket = new ServerSocket(8888);

        // 主线程只负责 accept
        while (true) {
            Socket clientSocket = serverSocket.accept();    // 第一个阻塞点(没有建立连接之前)
            // clientSocket 就拥有了五元组（TCP 连接的一个复合主键（多个字段组成的唯一标识））
            // TCP + 本地IP + 本地port + 远端IP + 远端端口
            pool.execute(new Task(clientSocket));
        }
    }
}
