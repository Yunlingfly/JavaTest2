package com.hand;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class JsonSaveThread extends Thread{
    private Pojo p;
    @Override
    public void run() {
        String json = JSON.toJSONString(p);
        File file = new File("..\\..\\Exam3\\tmp\\股票编码.xml");
        // 判断hello.properties文件是否存在，如果不存在，创建该文件
        try {
            if (!file.exists()) file.createNewFile();
            // 写入字符串到指定的文件中
            FileUtils.writeStringToFile(file, json, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("[INFO] 解析为json成功！");
    }
    public JsonSaveThread(Pojo p){
        this.p=p;
    }
}
