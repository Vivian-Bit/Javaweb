package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        // UDP 套接字（Socket）
        DatagramSocket socket = new DatagramSocket(9999);
        while (true) {
            byte[] recvBuf = new byte[8192];
            DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);

            // 直接从 socket 中读取数据报文
            // 2020-02-13 09:26
            socket.receive(recvPacket); // 这个方法是阻塞方法，没有数据之前，是不回返回的
            // 2222-02-13 09:26
            // 解析请求

            // 准备发送的响应
            byte[] sendBuf = "响应".getBytes("UTF-8");
            DatagramPacket sendPacket = new DatagramPacket(
                    sendBuf, sendBuf.length,
                    recvPacket.getAddress(), recvPacket.getPort());

            socket.send(sendPacket);

            // 没有 close
        }
    }
}
