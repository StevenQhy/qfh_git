package web.controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    Random ran = new Random();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int width = 100;
        int height = 35;

        //1.创建一对象，在内存中图片(验证码图片对象)
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);


        //2.美化图片
        //2.1 填充背景色
        Graphics g = image.getGraphics();//画笔对象
        g.setColor(Color.PINK);//设置画笔颜色
        g.fillRect(0,0,width,height);

        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width - 1,height - 1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        //生成随机角标

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);//随机字符
            sb.append(ch);
            g.setFont(randomFont());//随机字体
            //2.3写验证码
            g.drawString(ch+"",width/5*i,height/2);
        }
        String chekCode = sb.toString();
        request.getSession().setAttribute("CHECKCODE_SERVER",chekCode);

        //2.4画干扰线
        g.setColor(Color.blue);
        //随机生成坐标点
        for (int i = 0; i < 3; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);//画线
        }

        //画干扰点
        for (int i = 0; i < 3; i++) {
            g.setColor(randomColor());//随机颜色
            int x1 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            g.drawOval(x1,y1,2,2);//画点
        }

        //3.将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    //生成随机颜色
    private Color randomColor(){

        int red = ran.nextInt(255);
        int green = ran.nextInt(255);
        int blue = ran.nextInt(255);
        return new Color(red,green,blue);
    }

    //生辰随机字体
    private Font randomFont(){
        String[] fontNames= {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};
        int index = ran.nextInt(fontNames.length);
        String fontName = fontNames[index];
        int style = ran.nextInt(4);
        int size=ran.nextInt(5)+ 24;
        return new Font(fontName,style,size);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
