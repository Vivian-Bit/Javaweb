package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // 实际做了 3 个事情
        // 1. 新建 socket
        // 2. 绑定本地 ip + 本地端口(绑定的是出口网卡的 ip, 随机端口）
        // 3. 开始 connect 直到连接建立成功（127.0.0.1， 8888）
        Socket socket = new Socket("127.0.0.1", 8888);

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        // 可以有个循环
        // 将请求内容发送到 os 中，需要遵守应用层协议
        // 从 is 中读取响应内容，需要进行应用层协议分包

        socket.close(); // 可以 Server 关闭，可以 Client 关闭
    }
}
