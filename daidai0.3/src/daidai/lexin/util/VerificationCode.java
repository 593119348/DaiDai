package daidai.lexin.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VerificationCode {
	public static Map<String, BufferedImage> getVerificationCode() {
		BufferedImage bfi = new BufferedImage(80,25,BufferedImage.TYPE_INT_RGB);  
        Graphics g = bfi.getGraphics();  
        g.fillRect(0, 0, 80, 25);  
  
        //��֤���ַ���Χ  
        char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();  
        Random r = new Random();   
        int index;    
        StringBuffer sb = new StringBuffer(); //�����ַ���  
        for(int i=0; i<4; i++){  
            index = r.nextInt(ch.length);  
            g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));  
            Font font = new Font("����", 30, 20);  
            g.setFont(font);  
            g.drawString(ch[index]+"", (i*20)+2, 23);  
            sb.append(ch[index]);  
        }  
          
        // ������  
        int area = (int) (0.02 * 80 * 25);  
        for(int i=0; i<area; ++i){  
            int x = (int)(Math.random() * 80);  
            int y = (int)(Math.random() * 25);  
            bfi.setRGB(x, y, (int)(Math.random() * 255));  
        }  
          
      //������֤���еĸ�����  
        for (int i = 0; i < 6; i++) {    
              //�����ȡ�����ߵ������յ�  
              int xstart = (int)(Math.random() * 80);  
              int ystart = (int)(Math.random() * 25);  
              int xend = (int)(Math.random() * 80);  
              int yend = (int)(Math.random() * 25);  
              g.setColor(interLine(1, 255));  
              g.drawLine(xstart, ystart, xend, yend);  
            }  
        Map<String, BufferedImage> map = new HashMap<>();
        map.put(sb.toString(), bfi);
        return map;
	}
	
	private static Color interLine(int Low, int High){  
        if(Low > 255)  
            Low = 255;  
        if(High > 255)  
            High = 255;  
        if(Low < 0)  
            Low = 0;  
        if(High < 0)  
            High = 0;  
        int interval = High - Low;  
        int r = Low + (int)(Math.random() * interval);  
        int g = Low + (int)(Math.random() * interval);  
        int b = Low + (int)(Math.random() * interval);  
        return new Color(r, g, b);  
      }  
}
