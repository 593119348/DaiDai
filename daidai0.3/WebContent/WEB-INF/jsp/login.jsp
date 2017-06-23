<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<h3>
				Hellow, Dai Dai !
			</h3>
			<form action="login" class="form-horizontal" method="post">
				<div class="control-group">
					<label class="control-label" for="phone">手机号</label>
					<div class="controls">
						<input name="phone" id="phone" type="text" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="password">密 码</label>
					<div class="controls">
						<input name="password" id="password" type="password" />
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<label class="checkbox"><input type="checkbox" /> Remember me</label> <button class="btn" type="submit">登陆</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>-->



<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Dai Dai | </title>

    <!-- Bootstrap -->
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="vendors/animate.css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="login" onload="bodyonload()">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form action="login" method="post" id="loginform">
              <h1>Login Form</h1>
              <div>
                <input type="text" class="form-control" placeholder="Phonenumber" name="phone" required="" />
              </div>
              <div>
                <input type="password" class="form-control" placeholder="Password" name="password" required="" />
              </div>
              <div>
                <a class="btn btn-default submit" href="#" onclick="document.getElementById('loginform').submit();return false">Log in</a>
                <a class="reset_pass" href="#">Lost your password?</a>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">New to site?
                  <a href="#signup" class="to_register" onclick="setTimeout(function(){location.hash='signup';},500);return false"> Create Account </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> Hi Dai Dai!</h1>
                  <p>©2016 All Rights Reserved. DaiDai is a Mutual platform. Welcome visit</p>
                </div>
              </div>
            </form>
          </section>
        </div>

        <div id="register" class="animate form registration_form">
          <section class="login_content">
            <form action="register" method="post" id="registerform">
              <h1>Create Account</h1>
              <div>
                <input type="text" class="form-control" placeholder="Phonenumber" name="phone" required="" />
              </div>
              <div>
                <input type="password" class="form-control" placeholder="Password" name="password" required="" />
              </div>
              <div>
                <input type="text" class="form-control" placeholder="code" name="code" id="checkcode" required="" onblur="verificationcode()" />
                <img  src="<%=request.getContextPath() %>/imagecode" alt="code" id="image" />  
    			<a href="javascript:reload();"><label>换一张</label></a><br>  
    			<span id="span"></span>  
              </div>
              <div>
                <a class="btn btn-default submit" href="#" onclick="document.getElementById('registerform').submit();return false">Submit</a>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">Already a member ?
                  <a href="#signin" class="to_register" onclick="setTimeout(function(){location.hash='signin';},500);return false"> Log in </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> Hi Dai Dai!</h1>
                  <p>©2016 All Rights Reserved. DaiDai is a Mutual platform. Welcome visit</p>
                </div>
              </div>
            </form>
          </section>
        </div>
      </div>
    </div>
    
    
    <!-- jQuery -->
    <script src="vendors/jquery/dist/jquery.min.js"></script>
    
    
    <script type="text/javascript">
    function bodyonload() {
    	<%
	    	out.print(null==request.getAttribute("warnning")?"":"alert('"+(String)request.getAttribute("warnning")+"');");
	    	out.print(null==request.getAttribute("form")?"" : "window.location.href = \"login#signup\";");
    	%>
    }
    
     function reload(){  
        document.getElementById("image").src="<%=request.getContextPath() %>/imagecode?date="+new Date().getTime();  
        $("#checkcode").val("");   // 将验证码清空  
    }   
       
     function verificationcode(){  
         var text=$.trim($("#checkcode").val());  
         $.post("${pageContext.request.contextPath}/verificationcode",{op:text},function(data){  
             data=parseInt($.trim(data));  
             if(data>0){  
                 $("#span").text("验证成功!").css("color","green");
             }else{
                 $("#span").text("验证失败!").css("color","red");  
                 reload();  //验证失败后需要更换验证码  
             }  
         });  
     }  
</script>  
    
  </body>
</html>
