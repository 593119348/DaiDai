<%@page import="daidai.lexin.models.WhiteBox"%>
<%@page import="daidai.lexin.function.AdminManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="daidai.lexin.function.UserManager"%>
<%@page import="daidai.lexin.models.UserDInformation"%>
<%@page import="daidai.lexin.models.UserBInformation"%>
<%@page import="daidai.lexin.models.UserVInformation"%>
<%@page import="daidai.lexin.models.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
User user = (User)request.getSession().getAttribute("user");
if (null==user) {
	response.sendRedirect("login");
	return;
}
WhiteBox admin = (WhiteBox)request.getSession().getAttribute("admin");
ArrayList<User> userlist = (ArrayList<User>)UserManager.getAllUser( 0, 100, "desc");
UserBInformation ub = UserManager.getBInformationByUser(user.getUserid());
String photo = ub.getUser_binformation_photo();
String name = ub.getUser_binformation_name();
%>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>UserMessage</title>

    <!-- Bootstrap -->
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>Dai Dai</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
              <!--lexin头像 -->
                <a href="person"><img src="<%=(null==photo?"photo/null.jpg":photo) %>" alt="..." class="img-circle profile_img"></a>
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <!--lexin昵称 -->
                <h2><%=(null==name?user.getPhoneNumber():name) %></h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>Personnel</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i> User <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="home">Basic Information</a></li>
                      <li><a href="loginrecode">Login Recode</a></li>
                      <li><a href="index3.html">Dashboard3</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-home"></i> Admin <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="index.html">Dashboard</a></li>
                      <li><a href="index2.html">Dashboard2</a></li>
                      <li><a href="index3.html">Dashboard3</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
              <div class="menu_section">
                <h3>Record</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-bug"></i> Additional Pages <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="e_commerce.html">E-commerce</a></li>
                      <li><a href="projects.html">Projects</a></li>
                      <li><a href="project_detail.html">Project Detail</a></li>
                      <li><a href="contacts.html">Contacts</a></li>
                      <li><a href="profile.html">Profile</a></li>
                    </ul>
                  </li>
                  <!--<li><a href="javascript:void(0)"><i class="fa fa-laptop"></i> Landing Page <span class="label label-success pull-right">Coming Soon</span></a></li>-->
                </ul>
              </div>

            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                <!-- <a id="menu_toggle" href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="images/img.jpg" alt="">
                </a> -->
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="<%=(null==photo?"photo/null.jpg":photo) %>" alt=""><%=(null==name?user.getPhoneNumber():name) %>
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="person"> Person</a></li>
                    <li>
                      <a href="javascript:;">
                        <span class="badge bg-red pull-right">50%</span>
                        <span>Settings</span>
                      </a>
                    </li>
                    <li><a href="javascript:;">Help</a></li>
                    <li><a href="logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>

                <!--lexin通知-->
                <li role="presentation" class="dropdown">
                  <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                    <i class="fa fa-envelope-o"></i>
                    <span class="badge bg-green">1</span>
                  </a>
                  <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <div class="text-center">
                        <a>
                          <strong>See All Alerts</strong>
                          <i class="fa fa-angle-right"></i>
                        </a>
                      </div>
                    </li>
                  </ul>
                </li>
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Hi,<%=ub.getUser_binformation_name() %> <small>This is DaiDai's Backstage</small></h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Go!</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>

            <div class="clearfix"></div>

            <div class="row">
              
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>User Message<small>Users</small></h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                      You can view and manage all user information.
                    </p>
					
                    <table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                      <thead>
                        <tr>
                          <th>Phone number</th>
                          <th>Is black</th>
                          <th>Initialization</th>
                          <th>deluser</th>
                          <th>detailed</th>
                        </tr>
                      </thead>
                      <tbody>
                      <%
                      for(int i=0;i<userlist.size();i++) {
                    	  User u = userlist.get(i);
                    	  if (u.getIswhitebox()==1) continue;
                    	  out.print("<tr id=\""+u.getPhoneNumber()+"\">");
                    	  out.print("<td>"+u.getPhoneNumber()+"</td>");
                    	  out.print(
                                  "<td id=\""+u.getPhoneNumber()+"black\"><a href=\"#\" onclick=\"black('"+u.getPhoneNumber()+"')\"><span>"+(0==u.getIsblackbox()?"NO&nbsp;":"YES")+"</span>&nbsp;<i class=\""+(u.getIsblackbox()==0?"fa fa-unlock":"fa fa-unlock-alt")+"\"></i></a></td>"+
                    			  "<td><a href=\"#\" onclick=\"inituser('"+u.getPhoneNumber()+"')\"><i class=\"fa fa-undo\"></i></a></td>"+
                                  "<td><a href=\"#\" onclick=\"deluser('"+u.getPhoneNumber()+"')\"><i class=\"fa fa-trash\"></i></a></td>"+
                                  "<td><a href=\"userinfo?phone="+u.getPhoneNumber()+"\">det</a></td>");
                    	  out.print("</tr>");
                      }
                       %>
                       
                        <!-- <tr>
                          <td>Lexin</td>
                          <td>13066350249</td>
                          <td>Admin</td>
                          <td>2</td>
                          <td>2017-04-09 00:11:01</td>
                          <td><a>init</a></td>
                          <td><a>up</a></td>
                          <td><a>del</a></td>
                          <td><a>det</a></td>
                        </tr>
                        -->
                      </tbody>
                    </table>
					
					
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            DaiDai's Background management page 版权归我所有！
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="vendors/nprogress/nprogress.js"></script>
    <!-- iCheck -->
    <script src="vendors/iCheck/icheck.min.js"></script>
    <!-- Datatables -->
    <script src="vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="vendors/jszip/dist/jszip.min.js"></script>
    <script src="vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="vendors/pdfmake/build/vfs_fonts.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="build/js/custom.min.js"></script>
	
	<script type="text/javascript">
	function upadminlevel(phonenumber){  
        $.post("${pageContext.request.contextPath}/upadminlevel",{phone:phonenumber},function(data){
            alert(data);
        });  
    }
	function black(phonenumber){  
       	var isblack = $("#"+phonenumber+"black span")[0];
       	if (isblack.innerHTML=="NO&nbsp;") {
	        $.post("${pageContext.request.contextPath}/blackuser",{phone:phonenumber},function(data){        	
	        	if (""!=data) {
		        	isblack.innerHTML=(data==0?"NO&nbsp;":"YES");
		        	$("#"+phonenumber+"black i")[0].className="fa fa-unlock-alt";
	        	}
	        });
       	} else {
       		$.post("${pageContext.request.contextPath}/delblackuser",{phone:phonenumber},function(data){
            	if (""!=data) {
		        	isblack.innerHTML=(data==0?"NO&nbsp;":"YES"); 
		        	$("#"+phonenumber+"black i")[0].className="fa fa-unlock";
            	}
            });	
       	}
    }
	function inituser(phonenumber){  
        $.post("${pageContext.request.contextPath}/inituser",{phone:phonenumber},function(data){
            alert(data);
        });  
    }
	
	function deluser(phonenumber){  
        $.post("${pageContext.request.contextPath}/deluser",{phone:phonenumber},function(data){
            if (data=="1") {
            	var tr = document.getElementById(phonenumber); 
            	tr.parentNode.removeChild(tr);
            }
        });  
    }
	</script>
	
  </body>
</html>
