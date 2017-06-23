package daidai.lexin.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;


public class ImageUtils {

    public static String IMAGE_TYPE_GIF = "gif";// ͼ�ν�����ʽ
    public static String IMAGE_TYPE_JPG = "jpg";// ������Ƭר����
    public static String IMAGE_TYPE_JPEG = "jpeg";// ������Ƭר����
    public static String IMAGE_TYPE_BMP = "bmp";// Ӣ��Bitmap��λͼ���ļ�д������Windows����ϵͳ�еı�׼ͼ���ļ���ʽ
    public static String IMAGE_TYPE_PNG = "png";// ����ֲ����ͼ��
    public static String IMAGE_TYPE_PSD = "psd";// Photoshop��ר�ø�ʽPhotoshop

    public static void main(String[] args) throws IOException {
    	String path = "C:/Lexin/eclipseEE/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/daidai0.2/photo/";
    	String name1 = "null.jpg";
    	String name2 = "test.jpg";
    	conventionalTreatment(path+name1, -45, 50, 50, 100, 100, 50, 100, -1, -1, "jpg", path+2+name2);
    }

    public final static void conventionalTreatment(String inpath, int ange,int x,int y,int w,int h, int sw,int sh,int sx,int sy, String type, String outpath) throws IOException {
		BufferedImage src = ImageIO.read(new File(inpath));
		if (sx==-1) src = reversal(src, false);
		if (sy==-1) src = reversal(src, true);
		src =scale2( cut( Rotate( 
        						src , ange),
        				x, y, w, h ), 
        		sh, sw, true );
        		
        ImageIO.write(src, "jpg", new File(outpath));  
    }
    
    public final static BufferedImage reversal(BufferedImage src,boolean isVertical) {
    	int width = src.getWidth();
        int height = src.getHeight();
        double[] matrix;
        if(isVertical){
            matrix = new double[]{1, 0, 0, -1, 0,height};
        }else {
            matrix = new double[]{-1, 0, 0, 1,width,0};
        }
        AffineTransform affineTransform = new AffineTransform(matrix);
    	BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = newImg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawRenderedImage(src, affineTransform);
        g.dispose();
    	return newImg;
    }
    
    public final static boolean rotateAndWirte(String inpath, int ange, String type, String outpath) {
    	boolean isok = false;
    	 try {
    		BufferedImage src = ImageIO.read(new File(inpath) );  
    		BufferedImage des = ImageUtils.Rotate(src, 45);  
			ImageIO.write(des, type, new File(outpath));
			isok = true;
		} catch (IOException e) {
			e.printStackTrace();
		}  
    	return isok;
    }

   
    public final static BufferedImage scale(BufferedImage src, int scale, boolean flag) {
        int width = src.getWidth(); // �õ�Դͼ��
        int height = src.getHeight(); // �õ�Դͼ��
        if (flag) {// �Ŵ�
            width = width * scale;
            height = height * scale;
        } else {// ��С
            width = width / scale;
            height = height / scale;
        }
        Image image = src.getScaledInstance(width, height,
                Image.SCALE_DEFAULT);
        BufferedImage tag = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = tag.getGraphics();
        g.drawImage(image, 0, 0, null); // ������С���ͼ
        g.dispose();
        return src;
    }


   
    public final static BufferedImage scale2(BufferedImage bi, int height, int width, boolean bb) {
        double ratio = 0.0; // ���ű���
        Image itemp = bi.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);
        // �������
        if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
            if (bi.getHeight() > bi.getWidth()) {
                ratio = (new Integer(height)).doubleValue()
                        / bi.getHeight();
            } else {
                ratio = (new Integer(width)).doubleValue() / bi.getWidth();
            }
            AffineTransformOp op = new AffineTransformOp(AffineTransform
                    .getScaleInstance(ratio, ratio), null);
            itemp = op.filter(bi, null);
        }
        if (bb) {//����
            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.setColor(Color.white);
            g.fillRect(0, 0, width, height);
            if (width == itemp.getWidth(null))
                g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
                        itemp.getWidth(null), itemp.getHeight(null),
                        Color.white, null);
            else
                g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
                        itemp.getWidth(null), itemp.getHeight(null),
                        Color.white, null);
            g.dispose();
            itemp = image;
        }
        return bi;
    }
    
   
    public final static BufferedImage cut(BufferedImage bi , int x, int y, int width, int height) {
        int srcWidth = bi.getHeight(); // Դͼ���
        int srcHeight = bi.getWidth(); // Դͼ�߶�
        if (srcWidth > 0 && srcHeight > 0) {
            Image image = bi.getScaledInstance(srcWidth, srcHeight,
                    Image.SCALE_DEFAULT);
            // �ĸ������ֱ�Ϊͼ���������Ϳ��
            // ��: CropImageFilter(int x,int y,int width,int height)
            ImageFilter cropFilter = new CropImageFilter(x, y, width, height);
            Image img = Toolkit.getDefaultToolkit().createImage(
                    new FilteredImageSource(image.getSource(),
                            cropFilter));
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(img, 0, 0, width, height, null); // �����и���ͼ
            g.dispose();
            bi = tag;
        }
        return bi;
    }
    
   
    public final static void cut2(String srcImageFile, String descDir,
            int rows, int cols) {
        try {
            if(rows<=0||rows>20) rows = 2; // ��Ƭ����
            if(cols<=0||cols>20) cols = 2; // ��Ƭ����
            // ��ȡԴͼ��
            BufferedImage bi = ImageIO.read(new File(srcImageFile));
            int srcWidth = bi.getHeight(); // Դͼ���
            int srcHeight = bi.getWidth(); // Դͼ�߶�
            if (srcWidth > 0 && srcHeight > 0) {
                Image img;
                ImageFilter cropFilter;
                Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
                int destWidth = srcWidth; // ÿ����Ƭ�Ŀ��
                int destHeight = srcHeight; // ÿ����Ƭ�ĸ߶�
                // ������Ƭ�Ŀ�Ⱥ͸߶�
                if (srcWidth % cols == 0) {
                    destWidth = srcWidth / cols;
                } else {
                    destWidth = (int) Math.floor(srcWidth / cols) + 1;
                }
                if (srcHeight % rows == 0) {
                    destHeight = srcHeight / rows;
                } else {
                    destHeight = (int) Math.floor(srcWidth / rows) + 1;
                }
                // ѭ��������Ƭ
                // �Ľ����뷨:�Ƿ���ö��̼߳ӿ��и��ٶ�
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        // �ĸ������ֱ�Ϊͼ���������Ϳ��
                        // ��: CropImageFilter(int x,int y,int width,int height)
                        cropFilter = new CropImageFilter(j * destWidth, i * destHeight,
                                destWidth, destHeight);
                        img = Toolkit.getDefaultToolkit().createImage(
                                new FilteredImageSource(image.getSource(),
                                        cropFilter));
                        BufferedImage tag = new BufferedImage(destWidth,
                                destHeight, BufferedImage.TYPE_INT_RGB);
                        Graphics g = tag.getGraphics();
                        g.drawImage(img, 0, 0, null); // ������С���ͼ
                        g.dispose();
                        // ���Ϊ�ļ�
                        ImageIO.write(tag, "JPEG", new File(descDir
                                + "_r" + i + "_c" + j + ".jpg"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


   
    public final static void cut3(String srcImageFile, String descDir,
            int destWidth, int destHeight) {
        try {
            if(destWidth<=0) destWidth = 200; // ��Ƭ���
            if(destHeight<=0) destHeight = 150; // ��Ƭ�߶�
            // ��ȡԴͼ��
            BufferedImage bi = ImageIO.read(new File(srcImageFile));
            int srcWidth = bi.getHeight(); // Դͼ���
            int srcHeight = bi.getWidth(); // Դͼ�߶�
            if (srcWidth > destWidth && srcHeight > destHeight) {
                Image img;
                ImageFilter cropFilter;
                Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
                int cols = 0; // ��Ƭ��������
                int rows = 0; // ��Ƭ��������
                // ������Ƭ�ĺ������������
                if (srcWidth % destWidth == 0) {
                    cols = srcWidth / destWidth;
                } else {
                    cols = (int) Math.floor(srcWidth / destWidth) + 1;
                }
                if (srcHeight % destHeight == 0) {
                    rows = srcHeight / destHeight;
                } else {
                    rows = (int) Math.floor(srcHeight / destHeight) + 1;
                }
                // ѭ��������Ƭ
                // �Ľ����뷨:�Ƿ���ö��̼߳ӿ��и��ٶ�
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        // �ĸ������ֱ�Ϊͼ���������Ϳ��
                        // ��: CropImageFilter(int x,int y,int width,int height)
                        cropFilter = new CropImageFilter(j * destWidth, i * destHeight,
                                destWidth, destHeight);
                        img = Toolkit.getDefaultToolkit().createImage(
                                new FilteredImageSource(image.getSource(),
                                        cropFilter));
                        BufferedImage tag = new BufferedImage(destWidth,
                                destHeight, BufferedImage.TYPE_INT_RGB);
                        Graphics g = tag.getGraphics();
                        g.drawImage(img, 0, 0, null); // ������С���ͼ
                        g.dispose();
                        // ���Ϊ�ļ�
                        ImageIO.write(tag, "JPEG", new File(descDir
                                + "_r" + i + "_c" + j + ".jpg"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


   
    public final static void convert(String srcImageFile, String formatName, String destImageFile) {
        try {
            File f = new File(srcImageFile);
            f.canRead();
            f.canWrite();
            BufferedImage src = ImageIO.read(f);
            ImageIO.write(src, formatName, new File(destImageFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


   
    public final static void gray(String srcImageFile, String destImageFile) {
        try {
            BufferedImage src = ImageIO.read(new File(srcImageFile));
            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
            ColorConvertOp op = new ColorConvertOp(cs, null);
            src = op.filter(src, null);
            ImageIO.write(src, "JPEG", new File(destImageFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


   
    public final static void pressText(String pressText,
            String srcImageFile, String destImageFile, String fontName,
            int fontStyle, Color color, int fontSize,int x,
            int y, float alpha) {
        try {
            File img = new File(srcImageFile);
            Image src = ImageIO.read(img);
            int width = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.drawImage(src, 0, 0, width, height, null);
            g.setColor(color);
            g.setFont(new Font(fontName, fontStyle, fontSize));
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));
            // ��ָ���������ˮӡ����
            g.drawString(pressText, (width - (getLength(pressText) * fontSize))
                    / 2 + x, (height - fontSize) / 2 + y);
            g.dispose();
            ImageIO.write((BufferedImage) image, "JPEG", new File(destImageFile));// ������ļ���
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


   
    public final static void pressText2(String pressText, String srcImageFile,String destImageFile,
            String fontName, int fontStyle, Color color, int fontSize, int x,
            int y, float alpha) {
        try {
            File img = new File(srcImageFile);
            Image src = ImageIO.read(img);
            int width = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.drawImage(src, 0, 0, width, height, null);
            g.setColor(color);
            g.setFont(new Font(fontName, fontStyle, fontSize));
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));
            // ��ָ���������ˮӡ����
            g.drawString(pressText, (width - (getLength(pressText) * fontSize))
                    / 2 + x, (height - fontSize) / 2 + y);
            g.dispose();
            ImageIO.write((BufferedImage) image, "JPEG", new File(destImageFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


   
    public final static void pressImage(String pressImg, String srcImageFile,String destImageFile,
            int x, int y, float alpha) {
        try {
            File img = new File(srcImageFile);
            Image src = ImageIO.read(img);
            int wideth = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(wideth, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.drawImage(src, 0, 0, wideth, height, null);
            // ˮӡ�ļ�
            Image src_biao = ImageIO.read(new File(pressImg));
            int wideth_biao = src_biao.getWidth(null);
            int height_biao = src_biao.getHeight(null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));
            g.drawImage(src_biao, (wideth - wideth_biao) / 2,
                    (height - height_biao) / 2, wideth_biao, height_biao, null);
            // ˮӡ�ļ�����
            g.dispose();
            ImageIO.write((BufferedImage) image,  "JPEG", new File(destImageFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


   
    public final static int getLength(String text) {
        int length = 0;
        for (int i = 0; i < text.length(); i++) {
            if (new String(text.charAt(i) + "").getBytes().length > 1) {
                length += 2;
            } else {
                length += 1;
            }
        }
        return length / 2;
    }
    
    

    public final static BufferedImage Rotate(Image src, int angel) {  
        int src_width = src.getWidth(null);  
        int src_height = src.getHeight(null);  
        Rectangle rect_des = CalcRotatedSize(new Rectangle(new Dimension(  
                src_width, src_height)), angel);  
  
        BufferedImage res = null;  
        res = new BufferedImage(rect_des.width, rect_des.height,  
                BufferedImage.TYPE_INT_RGB);  
        Graphics2D g2 = res.createGraphics();  
        g2.translate((rect_des.width - src_width) / 2,  
                (rect_des.height - src_height) / 2);  
        g2.rotate(Math.toRadians(angel), src_width / 2, src_height / 2);  
  
        g2.drawImage(src, null, null);  
        return res;  
    }  
  
    public final static Rectangle CalcRotatedSize(Rectangle src, int angel) {  
        if (angel >= 90) {  
            if(angel / 90 % 2 == 1){  
                int temp = src.height;  
                src.height = src.width;  
                src.width = temp;  
            }  
            angel = angel % 90;  
        }  
  
        double r = Math.sqrt(src.height * src.height + src.width * src.width) / 2;  
        double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;  
        double angel_alpha = (Math.PI - Math.toRadians(angel)) / 2;  
        double angel_dalta_width = Math.atan((double) src.height / src.width);  
        double angel_dalta_height = Math.atan((double) src.width / src.height);  
  
        int len_dalta_width = (int) (len * Math.cos(Math.PI - angel_alpha  
                - angel_dalta_width));  
        int len_dalta_height = (int) (len * Math.cos(Math.PI - angel_alpha  
                - angel_dalta_height));  
        int des_width = src.width + len_dalta_width * 2;  
        int des_height = src.height + len_dalta_height * 2;  
        return new java.awt.Rectangle(new Dimension(des_width, des_height));  
    }  
    
    
}
