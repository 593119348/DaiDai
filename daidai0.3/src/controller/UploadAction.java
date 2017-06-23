package controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import daidai.lexin.function.UserManager;
import daidai.lexin.models.User;
import daidai.lexin.models.UserBInformation;
import daidai.lexin.util.ImageUtils;

@Controller
public class UploadAction {

	/***
	 * 头像页面
	 * @param request
	 * @return
	 */
    @RequestMapping(value="/photo")
    public String photo(HttpServletRequest request) {
    	User user =(User) request.getSession().getAttribute("user");
		if (null==user) return "login";
		return "photo";
    }
    
    /***
     * 上传GET方式
     * @param request
     * @return
     */
    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public String upload(HttpServletRequest request) {
    	request.setAttribute("warnning", null);
    	User user =(User) request.getSession().getAttribute("user");
		if (null==user) return "login";
		return "home";
    }
    
    /***
     * 上传POST方式
     * @param photofile
     * @param x
     * @param y
     * @param w
     * @param h
     * @param r
     * @param sx
     * @param sy
     * @param request
     * @return
     */
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public String upload(MultipartFile photofile, String x,String y,String w,String h,String r, String sx,String sy,HttpServletRequest request) {  	
		System.out.println(photofile.getSize());

		request.setAttribute("warnning", null);
    	User user =(User) request.getSession().getAttribute("user");
		if (null==user) return "login";
		if (null==photofile || photofile.getSize()==0 || photofile.getSize()>1024*1024 || !(x+y+w+h+r+sx+sy).matches("^[-]?\\d+[-]?\\d+[-]?\\d+[-]?\\d+[-]?\\d+$")) {
			request.setAttribute("warnning", "上传失败");
			return "photo";
		}
		
		final String DIR = "photo";
		UserBInformation ub = UserManager.getBInformationByUser(user.getUserid());
        String path = request.getSession().getServletContext().getRealPath(DIR);  
        String fileName = user.getUserid() +".jpg";
        String absFilePath = path+"\\"+fileName;
        File targetFile = new File(path, fileName); 
        System.out.println(path);
        System.out.println(fileName);
        System.out.println(absFilePath);
        if(!targetFile.exists()){ 
            targetFile.mkdirs();  
        }  
        //保存  
        try {  
            photofile.transferTo(targetFile);  
            int ri = Integer.parseInt(r);
            ImageUtils.conventionalTreatment(absFilePath,(ri<0?360+ri:ri),Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(w), Integer.parseInt(h), 100, 100,Integer.parseInt(sx),Integer.parseInt(sy), "jpg", absFilePath);
            
            ub.setUser_binformation_photo(DIR+"/"+fileName);
            UserManager.updateBInformation(ub);
//            model.addAttribute("fileUrl", request.getContextPath()+"/DIR/"+fileName);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	    System.out.println(ub);
        return "photo";  
    }  
	
}
