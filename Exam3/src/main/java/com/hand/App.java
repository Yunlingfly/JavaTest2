package com.hand;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Hello world!
 */
public class App {
    private String message; // 最开始返回的信息保存在这

    public static void main(String[] args) {
        App app = new App();
        Pojo pojo = new Pojo();

        System.out.println("[INFO] 股票编码："+args[0]);
        String mes = app.getSinaMessage(args[0]);
        String[] strs = mes.split(",");

        pojo.setName("汉得信息");
        pojo.setOpen(strs[1]);
        pojo.setClose(strs[2]);
        pojo.setCurrent(strs[3]);
        pojo.setHigh(strs[4]);
        pojo.setLow(strs[5]);

        System.out.println(JSON.toJSONString(pojo));
        // 开一个线程，保存成json格式的xml
        app.saveToJson(pojo);

        // 开一个线程，保存成xml格式的xml，附加写入前面的xml文件
        app.saveToXml(pojo);
    }

    // 网络获取数据
    public String getSinaMessage(String id) {
        System.out.println("[INFO] 开始获取数据。。。。。");
        try {
            URL url = new URL("http://hq.sinajs.cn/list=" + id);
            URLConnection connection = url.openConnection();
//            connection.addRequestProperty("encoding", "GBK");
            //设置为ture，我们的huConnection对象才能获取数据
            connection.setDoInput(true);

            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                //我们把我们获取到的资源，打印一下，方便我们观看是否请求成功
                //这里我们还可以在创建一个文档，把我们获取的存取到一个新文档里
//                value= new String(value.getBytes("iso-8859-1"),"gb2312");
                message += value;
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("[INFO] 获取数据成功！");
        return message;
    }

    public void saveToJson(Pojo p) {
        try {
            Thread thread = new JsonSaveThread(p);
            thread.start();
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveToXml(Pojo p) {
        try {
            Thread thread=new XmlSaveThread(p);
            thread.start();
            thread.join();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
