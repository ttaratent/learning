package com.demo.upload;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.util.ajax.JSON;

public class UploadImageController {
	
	
//	public Object uploadImage(HttpServletRequest request,HttpServletResponse response){
//		try {
//			response.setContentType("text/html;charset=UTF-8");
//			ReturnUploadImage rui = null;//这个是UEditor需要的返回值内容，UEditor要的返回值需要封装成Json格式
//			// 转型为MultipartHttpRequest：
//			MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest) request;
//			// 获得文件：
//			MultipartFile file = multipartRequest.getFile("upfile"); //UEditor传到后台的是这个upfile，其他的文件上传，应该也差不多是这个，还没去研究，断点一下就知道了
//			String prefix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
//			String dir="editor";
//			String path = "E:/img/"+dir+"/";
//	        if(this.isLinux()) path = "/img/"+dir+"/";
//	         File dirFile = new File(path);
//	        if(!dirFile.exists()){
//	        	dirFile.mkdir();
//	        }
//	        
//	        String fileName = System.currentTimeMillis()+"."+ prefix;
//	        
//	        boolean succ = ImageUtils.decodeBase64ToImage(ImageUtils.getImgStr(file.getInputStream()), path, fileName);
//	        if(!succ) return "上传失败";
//	        
//	        rui = new ReturnUploadImage();
//			rui.setTitle(fileName);//这里需要设置文件名称如：xxx.jpg
//			rui.setOriginal(fileName);//这里需要设置文件名称如：xxx.jpg
//			rui.setState("SUCCESS");//这里上传成功的话一定要设置大写的 SUCCESS，失败还没测试，猜应该是FAIL，回头再去官网找找
//			rui.setUrl(path+fileName);//严格来说 url应该设置为：服务器IP地址+path+fileName
//			
//			String result = JSON.toJSONString(rui);//这边就是为了返回给UEditor做的格式转换
//			response.getWriter().write(result);
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
//		}
//		return null;
//	}
//	/**
//	 * 
//	* @Title: isLinux 
//	* @Description: TODO(判断当前服务器是否为Linux) 
//	* @author luoq
//	* @param @return    设定文件 
//	* @return boolean    返回类型 
//	* @throws
//	 */
//	public static boolean isLinux(){
//		String os = System.getProperty("os.name");
//		if(os.toLowerCase().startsWith("win")){
//			return false;
//		}else{
//			return true;
//		}
//	} 
}
