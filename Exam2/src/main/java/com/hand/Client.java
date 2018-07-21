package com.hand;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

// 客户端
public class Client {
    private static BufferedOutputStream bo=null;
    private static BufferedInputStream bi=null;

    public static void main(String[] args) {
        try {
            Socket s=new Socket(InetAddress.getLocalHost(),5555);
            bo=new BufferedOutputStream(s.getOutputStream());

            bi = new BufferedInputStream(new FileInputStream("..\\..\\Exam1\\tmp\\SampleChapter1.pdf"));
            byte[] b = new byte[1024];
            int len;
            while (-1 != (len = bi.read(b, 0, b.length))) {
                bo.write(b, 0, len);
            }

            bi.close();
            bo.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bi.close();
            bo.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
