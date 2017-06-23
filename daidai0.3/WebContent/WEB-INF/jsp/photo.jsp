
<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="daidai.lexin.function.UserManager"%>
<%@page import="daidai.lexin.models.UserDInformation"%>
<%@page import="daidai.lexin.models.UserBInformation"%>
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
    <!-- bootstrap-daterangepicker -->
    <link href="vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    <!-- Ion.RangeSlider -->
    <link href="vendors/normalize-css/normalize.css" rel="stylesheet">
    <link href="vendors/ion.rangeSlider/css/ion.rangeSlider.css" rel="stylesheet">
    <link href="vendors/ion.rangeSlider/css/ion.rangeSlider.skinFlat.css" rel="stylesheet">
    <!-- Bootstrap Colorpicker -->
    <link href="vendors/mjolnic-bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css" rel="stylesheet">

    <link href="vendors/cropper/dist/cropper.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md" <%=null==request.getAttribute("warnning")?"":"onload=\"alert('"+request.getAttribute("warnning")+"');\"" %>>
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
                <h3>Photo Replace</h3>
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

                <!-- image cropping -->
                <div class="container cropper" id="photochoose2">
                  <div class="row">
                    <div class="col-md-9 docs-buttons">
                      <!-- <h3 class="page-header">Toolbar:</h3> -->
                      
                      <div class="btn-group">
                        <button type="button" class="btn btn-primary" data-method="rotate" data-option="-45" title="Rotate Left">
                          <span class="docs-tooltip" data-toggle="tooltip" title="$().cropper(&quot;rotate&quot;, -45)">
                            <span class="fa fa-rotate-left"></span>
                          </span>
                        </button>
                        <button type="button" class="btn btn-primary" data-method="rotate" data-option="45" title="Rotate Right">
                          <span class="docs-tooltip" data-toggle="tooltip" title="$().cropper(&quot;rotate&quot;, 45)">
                            <span class="fa fa-rotate-right"></span>
                          </span>
                        </button>
                      </div>

                      <div class="btn-group">
                        <button type="button" class="btn btn-primary" data-method="scaleX" data-option="-1" title="Flip Horizontal">
                          <span class="docs-tooltip" data-toggle="tooltip" title="$().cropper(&quot;scaleX&quot;, -1)">
                            <span class="fa fa-arrows-h"></span>
                          </span>
                        </button>
                        <button type="button" class="btn btn-primary" data-method="scaleY" data-option="-1" title="Flip Vertical">
                          <span class="docs-tooltip" data-toggle="tooltip" title="$().cropper(&quot;scaleY&quot;, -1)">
                            <span class="fa fa-arrows-v"></span>
                          </span>
                        </button>
                      </div>

                     

                      <div class="btn-group">
                        <button type="button" class="btn btn-primary" data-method="reset" title="Reset">
                          <span class="docs-tooltip" data-toggle="tooltip" title="$().cropper(&quot;reset&quot;)">
                            <span class="fa fa-refresh"></span>
                          </span>
                        </button>
                        <button type="button" class="btn btn-primary" data-method="getCroppedCanvas">
                          <span class="docs-tooltip" data-toggle="tooltip" title="$().cropper(&quot;getCroppedCanvas&quot;)">
                            <span class="fa fa-photo"></span>
                          </span>
                        </button>
                      </div>
                      
                      <div class="btn-group">
                       <form action="upload" method="post" enctype="multipart/form-data" style="display:inline;">
                        <label class="btn btn-primary btn-upload" for="inputImage" title="Upload image file">
                          <input type="file" class="sr-only" id="inputImage" name="photofile" accept="image/jpg,image/jpeg,image/png">
                          <span class="docs-tooltip" data-toggle="tooltip" title="Import image with Blob URLs">
                            <span class="fa fa-upload"></span>
                          </span>
                        </label>
                        <button type="button" class="btn btn-primary" data-method="crop" title="Crop" onclick="submit()">
                          <span class="docs-tooltip" data-toggle="tooltip" title="$().cropper(&quot;crop&quot;)">
                            <span class="fa fa-check"></span>
                          </span>
                        </button>
	                      <div class="docs-data" hidden="true">
	                          <input type="text" class="form-control" id="dataX" name="x" placeholder="x">
	                          <input type="text" class="form-control" id="dataY" name="y" placeholder="y">
	                          <input type="text" class="form-control" id="dataWidth" name="w" placeholder="width">
	                          <input type="text" class="form-control" id="dataHeight" name="h" placeholder="height">
	                          <input type="text" class="form-control" id="dataRotate" name="r" placeholder="rotate">
	                          <input type="text" class="form-control" id="dataScaleX" name="sx" placeholder="scaleX">
	                          <input type="text" class="form-control" id="dataScaleY" name="sy" placeholder="scaleY">
	                      </div>
                        </form>
                      </div>
                      
                      <!-- Show the cropped image in modal -->
                      <div class="modal fade docs-cropped" id="getCroppedCanvasModal" aria-hidden="true" aria-labelledby="getCroppedCanvasTitle" role="dialog" tabindex="-1">
                        <div class="modal-dialog">
                          <div class="modal-content">
                            <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                              <h4 class="modal-title" id="getCroppedCanvasTitle">Preview</h4>
                            </div>
                            <div class="modal-body"></div>
                            <div class="modal-footer">
                              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                              <a class="btn btn-primary" id="download" href="<%=(null==photo?"photo/null.jpg":photo) %>" download="<%=ub.getUser_binformation_name()+".jpg" %>">Download</a>
                            </div>
                          </div>
                        </div>
                      </div><!-- /.modal -->
                    </div><!-- /.docs-buttons -->
                  </div>

                  <div class="row">
                    <div class="col-md-9" style="float: right;width: 100%">
                    <!-- 图片-->
                      <div class="img-container">
                        <img id="image" src="" alt="Click upload button to upload photo。">
                      </div>
                    </div>
                  </div>

                </div>
                <!-- /image cropping -->
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
    <!-- Cropper -->
    <script src="vendors/cropper/dist/cropper.min.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="build/js/custom.min.js"></script>
	
	
	
  </body>
</html>



<!-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<%--<%=(User)request.getSession().getAttribute("user") %><br/>
	<%=(UserVInformation)request.getSession().getAttribute("vinformation") %><br/>
	<%=(UserBInformation)request.getSession().getAttribute("binformation") %><br/>
	<%=(UserDInformation)request.getSession().getAttribute("dinformation") %><br/>
	<%=(UserData)request.getSession().getAttribute("userdata") %><br/>
	sessionID:<%=request.getSession().getId() %>--%>
</body>
</html>

-->