package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daidai.lexin.function.AdminManager;
import daidai.lexin.function.BlackBoxManager;
import daidai.lexin.function.Login;
import daidai.lexin.function.LoginManager;
import daidai.lexin.function.Register;
import daidai.lexin.function.UserManager;
import daidai.lexin.models.User;
import daidai.lexin.models.UserBInformation;
import daidai.lexin.models.UserDInformation;
import daidai.lexin.models.WhiteBox;
import daidai.lexin.util.IPAddress;
import daidai.lexin.util.StringFactory;
import daidai.lexin.util.VerificationCode;

@Controller
@RequestMapping("/")
public class MyController {

	/***
	 * 注册
	 * @param phone
	 * @param password
	 * @param code
	 * @param request
	 * @return
	 */
    @RequestMapping("/register")
    public String register(String phone,String password,String code,HttpServletRequest request){
    	request.setAttribute("warnning", null);
    	request.setAttribute("form", "signup");
    	String mod = "login";
    	if (null==code || "".equals(code)) return mod;
    	String verificationCode = (String)request.getSession().getAttribute("verificationCode"); 
    	System.out.println(verificationCode);
    	if ( !verificationCode.equals(code) ) {
    		request.setAttribute("warnning", "验证码错误");
    		return mod;
    	}
    	if (null==phone || null==password || "".equals(phone) || "".equals(password)) {
    		request.setAttribute("warnning", "用户名或密码为空");
    		return mod;
    	}
    	int state = new Register(phone, password).execute();
    	if(state==1) {
    		mod=login(phone,password,request);
    	} else if (state==-1) {
	    	request.setAttribute("warnning", "用户名已存在或不符合要求");
    	} else if (state==0) {
    		request.setAttribute("warnning", "密码不符合要求");
    	}
        return mod;
    }
    
    /***
     * 登录
     * @param phone
     * @param password
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public String login(String phone, String password,HttpServletRequest request){
    	String mod = "login";
    	HttpSession session= request.getSession();  
    	request.setAttribute("warnning", null);
    	request.setAttribute("form", null);
    	if (null==phone || "".equals(phone) || null==password || "".equals(password)) return mod;
    	System.out.println(phone);
    	System.out.println(password);
    	
    	String ip = IPAddress.getIpAddr(request);
    	System.out.println(ip);
    	String address = "";
    	try {
			address = IPAddress.getAddresses("ip="+ip, "utf-8");
		} catch (UnsupportedEncodingException e) {}
    	System.out.println("address="+address);
    	
	    User user = new Login(phone,password, ip, null==address?"保密":address).execute();
	    
	    if (null==user) {
	    	request.setAttribute("warnning", "用户名或密码错误");
	    	return mod;
	    }
	    System.out.println(user);
	    
	    if (0==user.getIswhitebox()) {
	    	request.setAttribute("warnning", "用户不是管理员");
	    	return mod;
	    }
	    
	    WhiteBox wb = AdminManager.getAdminByUser(user.getUserid());
	    System.out.println(wb);
    	session.setAttribute("user", user);
    	session.setAttribute("admin", wb);
    	mod = "home";
        return mod;
    }
    
    /***
     * 主页
     * @param request
     * @return
     */
    @RequestMapping(value="/home")
    public String home(HttpServletRequest request){
    	request.setAttribute("warnning", null);
	    User user = (User)request.getSession().getAttribute("user");
	    WhiteBox wb = (WhiteBox)request.getSession().getAttribute("admin");
	    String mod = "login";
	    if(null!=user && null!=wb) {
	    	mod = "home";
	    } else {
	    	request.setAttribute("warnning", "请先登录");
	    }
        return mod;
    }
    
    /***
     * 个人页面
     * @param request
     * @return
     */
    @RequestMapping("/person")
    public String person(HttpServletRequest request){
    	User user = (User)request.getSession().getAttribute("user");
    	if ( null == user ) return "login";
    	UserBInformation ub = UserManager.getBInformationByUser(user.getUserid());
    	request.setAttribute("binformation", ub );
    	return "person";
    }
    
    /***
     * 更改用户详细信息
     * @param education
     * @param school
     * @param entrancetime
     * @param job
     * @param company
     * @param inductiontime
     * @param request
     * @return
     */
    @RequestMapping(value="/updateUserDinformation")
    public String updateUserDinformation(String education,String school,String entrancetime,String job,String company,String inductiontime,HttpServletRequest request) {
    	try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	System.out.println(education);
    	System.out.println(school);
    	System.out.println(entrancetime);
    	System.out.println(job);
    	System.out.println(company);
    	System.out.println(inductiontime);

    	request.setAttribute("warnning", null);
    	User user = (User) request.getSession().getAttribute("user");
    	if (null==user) return "login";
    	
    	if ( (entrancetime+inductiontime+education).matches("^\\d+/\\d+/\\d+\\d+/\\d+/\\d+$") ) {
    		UserDInformation ud = UserManager.getDInformationByUser(user.getUserid());
    		ud.setUser_dinformation_education(education);
    		ud.setUser_dinformation_school( school.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("&", "&amp;").replaceAll("\"", "&quot;").replaceAll(" ", "&nbsp;") );
    		ud.setUser_dinformation_schooltime(entrancetime);
    		ud.setUser_dinformation_job(  job.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("&", "&amp;").replaceAll("\"", "&quot;").replaceAll(" ", "&nbsp;") );
    		ud.setUser_dinformation_company( company.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("&", "&amp;").replaceAll("\"", "&quot;").replaceAll(" ", "&nbsp;") );
    		ud.setUser_dinformation_jobtime(inductiontime);
    		UserManager.updateDInformation(ud);
    		System.out.println(ud);
    	} else {
    		request.setAttribute("warnning", "参数错误");
    	}
    	
    	return "person";
    }
    
    /***
     * 更改用户基本信息
     * @param name
     * @param gender
     * @param birth
     * @param address
     * @param introduction
     * @param request
     * @return
     */
    @RequestMapping(value="/updateUserBinformation")
    public String updateUserBinformation(String name,String gender,String birth,String address,String introduction,HttpServletRequest request){
    	System.out.println(name);
    	System.out.println(gender);
    	System.out.println(birth);
    	System.out.println(address);
    	System.out.println(introduction);
    	request.setAttribute("warnning", null);
    	User user = (User) request.getSession().getAttribute("user");
    	if (null==user) return "login";
    	
    	if (null!=birth && null!=gender && gender.matches("^\\d{1}$")) {
    		UserBInformation ub = UserManager.getBInformationByUser(user.getUserid());
    		ub.setUser_binformation_name( name.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("&", "&amp;").replaceAll("\"", "&quot;") );
    		ub.setUser_binformation_sex(gender);
    		ub.setUser_binformation_birth(birth);
    		ub.setUser_binformation_address( address.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("&", "&amp;").replaceAll("\"", "&quot;").replaceAll(" ", "&nbsp;") );
    		ub.setUser_binformation_introduction( introduction.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("&", "&amp;").replaceAll("\"", "&quot;").replaceAll(" ", "&nbsp;") );
    		UserManager.updateBInformation(ub);
    		System.out.println(ub);
    	} else {
    		request.setAttribute("warnning", "参数错误");
    	}
    	return "person";
    }
    
    /***
     * 显示验证码
     * @param request
     * @param response
     */
    @RequestMapping(value="/imagecode")
    public void imagecode(HttpServletRequest request, HttpServletResponse response) {
    	
    	Map<String, BufferedImage> map = VerificationCode.getVerificationCode();
    	String code = map.keySet().iterator().next();
    	request.getSession().setAttribute("verificationCode", code);  
        try {
			ImageIO.write(map.get(code), "JPG", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		} 
    	
    }
    
    /***
     * 验证码验证
     * @param request
     * @param response
     */
    @RequestMapping(value="/verificationcode")
    public void verificationcode(HttpServletRequest request, HttpServletResponse response) {
    	String verificationCode = (String)request.getSession().getAttribute("verificationCode"); 
    	String checkcode = request.getParameter("op");  
    	if (request.getMethod().equals("POST")) {
	    	if (null==checkcode) return;
	    	PrintWriter out = null;
			try {
				out = response.getWriter();
				if(checkcode.equals(verificationCode)){  
					out.println(1);  
				}else{  
					out.println(0);  
				}    
			} catch (IOException e) {
				e.printStackTrace();
			}  finally {
				if (null!=out) {
					out.flush();  
					out.close();
				}
			}
    	}
    }
    
    /***
     * 登出
     * @param request
     * @return
     */
    @RequestMapping(value="/logout")
    public String logout(HttpServletRequest request) {
    	request.getSession().setAttribute("user",null);
    	return "login";
    }
    
    /***
     * 初始化用户
     * @param phone
     * @param request
     * @param response
     */
    @RequestMapping(value="/inituser")
    public void inituser(String phone, HttpServletRequest request, HttpServletResponse response) {
    	if (request.getMethod().equals("GET")) return;
    	
    	User user = (User)request.getSession().getAttribute("user");
    	if (null==user) return;
    	WhiteBox admin = (WhiteBox)request.getSession().getAttribute("admin");
    	if (null==admin) return;
    	User user2 = UserManager.getUserByPhone(phone);
    	String password = StringFactory.getString(16);
    	user2.setPassword( password );
    	int state = UserManager.updateUser(user2);
    	PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print( state>0?password:state );
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {
			if (null!=out) {
				out.flush();  
				out.close();
			}
		}
    }
    
    /***
     * 取消拉黑
     * @param phone
     * @param request
     * @param response
     */
    @RequestMapping(value="/delblackuser")
    public void delblackuser(String phone, HttpServletRequest request, HttpServletResponse response) {
    	if (request.getMethod().equals("GET")) return;
    	
    	User user = (User)request.getSession().getAttribute("user");
    	if (null==user) return;
    	WhiteBox admin = (WhiteBox)request.getSession().getAttribute("admin");
    	if (null==admin) return;
    	User user2 = UserManager.getUserByPhone(phone);
    	if (0==user2.getIsblackbox()) return;
    	BlackBoxManager.removeBlackBoxByUserID(user2.getUserid());
    	PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print( UserManager.getUserByUserID(user2.getUserid()).getIsblackbox() );
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {
			if (null!=out) {
				out.flush();  
				out.close();
			}
		}
    }
    
    /***
     * 删除用户
     * @param phone
     * @param request
     * @param response
     */
    @RequestMapping(value="/deluser")
    public void deluser(String phone, HttpServletRequest request, HttpServletResponse response) {
    	if (request.getMethod().equals("GET")) return;
    	User user = (User)request.getSession().getAttribute("user");
    	if (null==user) return;
    	WhiteBox admin = (WhiteBox)request.getSession().getAttribute("admin");
    	if (null==admin) return;
    	User user2 = UserManager.getUserByPhone(phone);
    	if (user2.getIswhitebox()>0) return;
    	int state = UserManager.removeUserByUserID(user2.getUserid());
    	PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(state);
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {
			if (null!=out) {
				out.flush();  
				out.close();
			}
		}
    }
    
    /***
     * 拉黑用户
     * @param phone
     * @param request
     * @param response
     */
    @RequestMapping(value="/blackuser")
    public void blackuser(String phone, HttpServletRequest request, HttpServletResponse response) {
    	if (request.getMethod().equals("GET")) return;
    	
    	User user = (User)request.getSession().getAttribute("user");
    	if (null==user) return;
    	WhiteBox admin = (WhiteBox)request.getSession().getAttribute("admin");
    	if (null==admin) return;
    	User user2 = UserManager.getUserByPhone(phone);
    	if (1==user2.getIswhitebox() || 1==user2.getIsblackbox()) return;
    	BlackBoxManager.addBlackBox(user2.getUserid(), "Admin", 0);
    	PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print( UserManager.getUserByUserID(user2.getUserid()).getIsblackbox() );
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {
			if (null!=out) {
				out.flush();  
				out.close();
			}
		}
    }
    
    /***
     * 提升管理员等级
     * @param phone
     * @param request
     * @param response
     */
    @RequestMapping(value="/upadminlevel")
    public void upadminlevel(String phone, HttpServletRequest request, HttpServletResponse response ) {
    	if (request.getMethod().equals("GET")) return;
    	
    	User user = (User)request.getSession().getAttribute("user");
    	if (null==user) return;
    	WhiteBox admin = (WhiteBox)request.getSession().getAttribute("admin");
    	if (null==admin) return;
    	
    	User u2 = UserManager.getUserByPhone(phone);
    	WhiteBox admin2 = u2.getIswhitebox()==0?null:AdminManager.getAdminByUser(u2.getUserid());
    	System.out.println(u2);
    	System.out.println(admin2);
    	int level = 0;
		if (null==admin2 || admin2.getWhitebox_level()<admin.getWhitebox_level()-1) {
			level = null==admin2?1:(admin2.getWhitebox_level()+1);
			System.out.println( AdminManager.addAdmin(u2.getUserid(), level, new Date().getTime(), 0) );	
		}
    	PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(level);
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {
			if (null!=out) {
				out.flush();  
				out.close();
			}
		}
    }
    
    /***
     * 用户信息查询
     * @param phone
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/userinfo")
    public String userinfo(String phone, HttpServletRequest request, HttpServletResponse response ) {
    	User user = (User)request.getSession().getAttribute("user");
    	if (null==user) return "login";
    	WhiteBox admin = (WhiteBox)request.getSession().getAttribute("admin");
    	if (null==admin) return "login";
    	
    	User u2 = UserManager.getUserByPhone(phone);
    	if (null==u2) return "502.html";
    	if (u2.getIswhitebox()>0) return "502.html";
    	request.setAttribute("user", u2);
    	return "userinfo";
    }
    
    /***
     * 登录记录
     * @param request
     * @return
     */
    @RequestMapping(value="/loginrecode")
    public String loginrecode( HttpServletRequest request) {
    	List<daidai.lexin.models.Login> list = LoginManager.selectAllLogin(0, 100);
    	System.out.println(list);
    	request.setAttribute("loginlogs", list);
    	return "loginrecode";
    }
    
    /***
     * 最近一周每天的登录次数
     * @param request
     * @param response
     */
    @RequestMapping(value="/loginrecodecount")
    public void loginrecodecount(HttpServletRequest request, HttpServletResponse response ) {
    	StringBuffer res = new StringBuffer();
    	User user = (User)request.getSession().getAttribute("user");
    	if (null!=user) {
    		WhiteBox admin = (WhiteBox)request.getSession().getAttribute("admin");
    		if (null!=admin) {
    			Calendar cal = Calendar.getInstance();
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    			cal.setTime(new Date());
    			int d = cal.get(Calendar.DAY_OF_WEEK)-1; 
    			cal.add(Calendar.DAY_OF_MONTH, -d);
    			String d1 = sdf.format( cal.getTime() );
    			
    			for (int i=0;i<7;i++) {
    				cal.add(Calendar.DAY_OF_MONTH, 1);
    				res.append( LoginManager.getLoginRecodeCount(d1,  sdf.format( cal.getTime() ) ) ) ;
    				if (i<6) res.append(",");
    				d1 = sdf.format( cal.getTime() );
    			}
    		}
    	}
    	System.out.println(res);
    	PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {
			if (null!=out) {
				out.flush();  
				out.close();
			}
		}
    }

    /***
     * 根据登录次数的用户排序
     * @param request
     * @param response
     */
    @RequestMapping(value="/toploginrecodecount")
    public void toploginrecodecount(HttpServletRequest request, HttpServletResponse response) {
    	List<Map<String,Object>> list = null;
    	User user = (User)request.getSession().getAttribute("user");
    	if (null!=user) {
    		WhiteBox admin = (WhiteBox)request.getSession().getAttribute("admin");
    		if (null!=admin) {
    			list = LoginManager.countLogin(0, 5);
    		}
    	}
    	System.out.println(list);
    	PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(list);
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {
			if (null!=out) {
				out.flush();  
				out.close();
			}
		}
    }

    
}
