package com.demo.upload;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ImageUtils {

	/**
	 * 将网络图片进行Base64位编码
	 * 
	 * @param imgUrl
	 *            图片的url路径，如http://.....xx.jpg
	 * @return
	 */
	public static String encodeImgageToBase64(URL imageUrl) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		ByteArrayOutputStream outputStream = null;
		try {
			BufferedImage bufferedImage = ImageIO.read(imageUrl);
			outputStream = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "jpg", outputStream);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(outputStream.toByteArray());// 返回Base64编码过的字节数组字符串
	}

	/**
	 * 将本地图片进行Base64位编码
	 * 
	 * @param imgUrl
	 *            图片的url路径，如http://.....xx.jpg
	 * @return
	 */
	public static String encodeImgageToBase64(File imageFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		ByteArrayOutputStream outputStream = null;
		try {
			BufferedImage bufferedImage = ImageIO.read(imageFile);
			outputStream = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "jpg", outputStream);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(outputStream.toByteArray());// 返回Base64编码过的字节数组字符串
	}

	/**
	 * 将Base64位编码的图片进行解码，并保存到指定目录
	 * 
	 * @param base64
	 *            base64编码的图片信息
	 * @return
	 */
	public static boolean decodeBase64ToImage(String base64, String path,
			String imgName) {
		
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			FileOutputStream write = new FileOutputStream(new File(path
					+ imgName));
			byte[] decoderBytes = decoder.decodeBuffer(base64);
			write.write(decoderBytes);
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	 * 
	 * @param in
	 * @return
	 */
	public static String getImgStr(InputStream in) {
		// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		byte[] data = null;
		// 读取图片字节数组
		try {
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(Base64.encodeBase64(data));
	}
	
	
	
	
	
	 /**
	  * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	 * @param imgFilePath
	 * @return
	 */
	public static String GetImageStr(String imgFilePath) {
	        byte[] data = null;
	        
	        // 读取图片字节数组
	        try {
	            InputStream in = new FileInputStream(imgFilePath);
	            data = new byte[in.available()];
	            in.read(data);
	            in.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        // 对字节数组Base64编码
	        BASE64Encoder encoder = new BASE64Encoder();
	        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	    }

	    /**
	     * 对字节数组字符串进行Base64解码并生成图片
	     * @param imgStr
	     * @param imgFilePath
	     * @return
	     */
	    public static boolean GenerateImage(String imgStr, String imgFilePath) {
	        if (imgStr == null) // 图像数据为空
	            return false;
	        BASE64Decoder decoder = new BASE64Decoder();
	        try {
	            // Base64解码
	            byte[] bytes = decoder.decodeBuffer(imgStr);
	            for (int i = 0; i < bytes.length; ++i) {
	                if (bytes[i] < 0) {// 调整异常数据
	                    bytes[i] += 256;
	                }
	            }
	            // 生成jpeg图片
	            OutputStream out = new FileOutputStream(imgFilePath);
	            out.write(bytes);
	            out.flush();
	            out.close();
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }
	    
	    
	/**
	 * 删除单个文件
	 * 
	 * @param fileName
	 *            要删除的文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				//System.out.println("删除单个文件" + fileName + "成功！");
				return true;
			} else {
				System.out.println("删除单个文件" + fileName + "失败！");
				return false;
			}
		} else {
			System.out.println("删除单个文件失败：" + fileName + "不存在！");
			return false;
		}
	}	

}
