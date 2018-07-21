package com.hand;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// 服务器
public class Server {
    private static BufferedInputStream bi = null;
    private static BufferedOutputStream bo = null;
    private static ServerSocket ss;
    private static Socket s;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            ss = new ServerSocket(5555);
            System.out.println("服务器正常启动。。。。");
            s = ss.accept();//阻塞方法
            System.out.println("连接成功" + s.getRemoteSocketAddress());
            bi = new BufferedInputStream(s.getInputStream());
            bo = new BufferedOutputStream(new FileOutputStream("..\\tmp\\SampleChapter1.pdf"));

            byte[] b = new byte[1024];
            int len;
            while (-1 != (len = bi.read(b, 0, b.length))) {
                bo.write(b, 0, len);
            }
            System.out.println("文件传输结束");

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        try {
            bi.close();
            bo.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
