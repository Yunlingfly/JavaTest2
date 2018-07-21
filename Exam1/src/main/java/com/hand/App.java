package com.hand;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App app=new App();
        app.method1();
    }

    // http Get
    public void method1() {
        try {
            URL url = new URL("http://192.168.11.205:18080/trainning/SampleChapter1.pdf");
            URLConnection connection = url.openConnection();
            connection.addRequestProperty("encoding", "utf-8");
            //设置为ture，我们的huConnection对象才能获取数据
            connection.setDoInput(true);

            InputStream inputStream = connection.getInputStream();
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            FileOutputStream fs = new FileOutputStream(new File("..\\tmp\\SampleChapter1.pdf"));
            BufferedOutputStream outputStream = new BufferedOutputStream(fs);

            BufferedInputStream bufferedReader = new BufferedInputStream(inputStream);
            byte[] b = new byte[1024];
            int len;
            while (-1 != (len = bufferedReader.read(b, 0, b.length))) {
                outputStream.write(b, 0, len);
            }
            inputStream.close();
            outputStream.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
