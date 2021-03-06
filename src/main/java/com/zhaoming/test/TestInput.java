package com.zhaoming.test;

import com.zhaoming.test.bean.Coordinate;
import com.zhaoming.test.util.ImageUtils;
import com.zhaoming.test.util.PathUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Java小机器人打开记事本自己输入文字
 * @author Wayss
 *
 */

public class TestInput {
    public static void main(String [] args) throws Exception{
        Robot robot = new Robot();

        //调用系统方法打开记事本
        /*Runtime.getRuntime().exec("notepad");
        robot.delay(2000);
        //全屏显示
//        keyPressWithAlt(robot,KeyEvent.VK_SPACE);
        //输入x
        keyPress(robot, KeyEvent.VK_X);
        //输入回车
        keyPress(robot, KeyEvent.VK_ENTER);
        robot.delay(1000);
        //输入字符串
        keyPressString(robot,"Hello, I'm Robot");*/
        //findImageForScreen();
        /*robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(300,300);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);*/
        System.out.println(PathUtil.getPath());
    }

    //Shift组合键
    public static void keyPressWithShift(Robot r,int key){
        //按下Shift
        r.keyPress(KeyEvent.VK_SHIFT);
        //按下某个键
        r.keyPress(key);

        //释放某个键
        r.keyRelease(key);
        //释放Shift
        r.keyRelease(KeyEvent.VK_SHIFT);
        //等待100ms
        r.delay(100);
    }

    //Ctrl组合键
    public static void keyPressWithCtrl(Robot r,int key){
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(key);

        r.keyRelease(key);
        r.keyRelease(KeyEvent.VK_CONTROL);

        r.delay(100);
    }

    //Alt组合键
    public static void keyPressWithAlt(Robot r ,int key){
        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(key);

        r.keyRelease(key);
        r.keyRelease(KeyEvent.VK_ALT);
        r.delay(100);
    }

    //输入字符串
    public static void keyPressString(Robot r ,String str){
        //获取剪切板
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        //将传入字符串封装下
        Transferable tText = new StringSelection(str);
        //将字符串放入剪切板
        clip.setContents(tText, null);
        //按下Ctrl+V实现粘贴文本
        keyPressWithCtrl(r, KeyEvent.VK_V);
        r.delay(100);
    }

    //输入数字
    public static void keyPressNumber(Robot r ,int number){
        //将数字转成字符串
        String str = Integer.toString(number);
        //调用字符串的方法
        keyPressString(r,str);
    }

    //实现按一次某个按键
    public static void keyPress(Robot r,int key){
        //按下键
        r.keyPress(key);
        //释放键
        r.keyRelease(key);

        r.delay(1000);
    }

    //快速打开QQ消息(这个组合键因人而异)
    public static void keyPressAtlWithCtrlWithZ(Robot r){
        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_Z);

        r.keyRelease(KeyEvent.VK_Z);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_ALT);
    }

    //点击一下鼠标左键
    public static void mouseLeftHit(Robot r){
        r.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
        r.delay(1000);
    }
    public static void findImageForScreen() {

        try {

            //获取屏幕宽和高
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int w = (int) screenSize.getWidth();
			int h = (int) screenSize.getHeight();


            Robot robot = new Robot();
            //全屏截图
            BufferedImage screenImg = robot.createScreenCapture(new Rectangle(0, 0, w, h));
            OutputStream out = new FileOutputStream("E:\\robot-test/screenImg.png");
            ImageIO.write(screenImg, "png", out);
            //将截到的BufferedImage写到本地

            InputStream inputStream = new FileInputStream("E:\\robot-test/QQ截图20211125140307.png");
            BufferedImage searchImg = ImageIO.read(inputStream);
            //将要查找的本地图读到BufferedImage

            //图片识别工具类
            Coordinate coordinate = ImageUtils.find(screenImg, searchImg);
            if(null != coordinate) {
                System.out.println("查找完毕---坐标是" + coordinate.getX() + "," + coordinate.getY());
                robot.mouseMove(coordinate.getX()+(searchImg.getWidth()/2),coordinate.getY()+(searchImg.getHeight()/2));
                robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            }else {
                System.out.println("没找到");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}