package com.hand;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class XmlSaveThread extends Thread{
    private Pojo p;
    @Override
    public void run() {
        //创建一个xml文档
        Document doc = DocumentHelper.createDocument();
        //向xml文件中添加注释
        doc.addComment("xml数据");
        //创建一个名为students的节点，因为是第一个创建，所以是根节点,再通过doc创建一个则会报错。
        Element root = doc.addElement("xml");
        //在root节点下创建一个名为student的节点
        Element stuEle = root.addElement("stock");
        //给student节点添加属性
//        stuEle.addAttribute("id", "101");
        //给student节点添加一个子节点
        Element nameEle = stuEle.addElement("name");
        //设置子节点的文本
        nameEle.setText(p.getName());

        nameEle = stuEle.addElement("open");
        //设置子节点的文本
        nameEle.setText(p.getOpen());

        nameEle = stuEle.addElement("close");
        //设置子节点的文本
        nameEle.setText(p.getClose());

        nameEle = stuEle.addElement("current");
        //设置子节点的文本
        nameEle.setText(p.getCurrent());

        nameEle = stuEle.addElement("high");
        //设置子节点的文本
        nameEle.setText(p.getHigh());

        nameEle = stuEle.addElement("low");
        //设置子节点的文本
        nameEle.setText(p.getLow());

        //用于格式化xml内容和设置头部标签
        OutputFormat format = OutputFormat.createPrettyPrint();
        //设置xml文档的编码为utf-8
        format.setEncoding("utf-8");
        Writer out;
        try {
            //创建一个输出流对象,附加写入
            out = new FileWriter("..\\..\\Exam3\\tmp\\股票编码.xml",true);
            //创建一个dom4j创建xml的对象
            XMLWriter writer = new XMLWriter(out, format);
            //调用write方法将doc文档写到指定路径
            writer.write(doc);
            writer.close();
            System.out.println("[INFO] 解析为xml成功！");
        } catch (IOException e) {
            System.out.print("[INFO] 解析为XML文件失败");
            e.printStackTrace();
        }

    }

    public XmlSaveThread(Pojo p){
        this.p=p;
    }
    public void testCreateXml() {

    }
}
