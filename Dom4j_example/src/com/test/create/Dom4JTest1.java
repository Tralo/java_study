package com.test.create;

import java.io.FileOutputStream;
import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * dom4j框架学习 使用dom4j框架创建xml文档并输出保存
 * 
 */
public class Dom4JTest1
{

    public static void main(String[] args) throws Exception
    {
        // 第二种方式:创建文档并设置文档的根元素节点
        Element root2 = DocumentHelper.createElement("student");
        Document document2 = DocumentHelper.createDocument(root2);

        // 添加属性
        root2.addAttribute("name", "zhangsan");
        // 添加子节点:add之后就返回这个元素
        Element helloElement = root2.addElement("hello");
        Element worldElement = root2.addElement("world");

        helloElement.setText("hello Text");
        worldElement.setText("world text");


        // 输出到文件
        // 格式
        OutputFormat format = new OutputFormat("    ", true);// 设置缩进为4个空格，并且另起一行为true

        // 另一种输出方式，记得要调用flush()方法,否则输出的文件中显示空白
        XMLWriter xmlWriter3 = new XMLWriter(new FileWriter("student.xml"),
                format);
        xmlWriter3.write(document2);
        xmlWriter3.flush();
        // close()方法也可以

    }
}