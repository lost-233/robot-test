/**
 * 
 */
package com.zhaoming.test.test;

import com.zhaoming.test.bean.ImageXyBean;
import com.zhaoming.test.util.ImageCognitionUtil;
import com.zhaoming.test.util.PathUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;


public class FindImgTest {

	public static void main(String[] args) {
		findImageForScreen(PathUtil.getPath()+"cmd/77.png");
		//findImageForScreen("E:\\robot-test/QQ截图20211125140307.png");
	}
	
	public static void findImageForScreen(String file) {
		
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

			InputStream inputStream = new FileInputStream(file);
			BufferedImage searchImg = ImageIO.read(inputStream);
			//将要查找的本地图读到BufferedImage

			//图片识别工具类
			ImageCognitionUtil ic = new ImageCognitionUtil();

			List<ImageXyBean> list = ic.imageSearch(screenImg, searchImg, ImageCognitionUtil.SIM_BLUR);
			
			if( list.size() > 0 ) {
				for (ImageXyBean imgXy : list) { 
					System.out.println("查找完毕---坐标是" + imgXy.x + "," + imgXy.y);
					robot.mouseMove(imgXy.x+(searchImg.getWidth()/2),imgXy.y+(searchImg.getHeight()/2));
					robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
					//把找到的图标记一下
					Graphics g = screenImg.getGraphics();
					g.setColor(Color.red);
					g.drawRect(imgXy.x, imgXy.y, searchImg.getWidth(), searchImg.getHeight());
					g.setFont(new Font("微软雅黑", Font.BOLD, 16));
					g.drawString("←找到的图片在这里", imgXy.x + searchImg.getWidth() + 10,
							imgXy.y + searchImg.getHeight() / 2 + 10);
					out = new FileOutputStream("E:\\robot-test/resultImg.png");
					ImageIO.write(screenImg, "png", out);

				}
			}else {
				System.out.println("没找到");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
