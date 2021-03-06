<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String regTip="注册";
    if(request.getAttribute("isReg")!=null){
        regTip =request.getAttribute("regTip").toString();
    }
    String loginTip="登录";
    if(request.getAttribute("loginTip")!=null){
        loginTip =request.getAttribute("loginTip").toString();
    }
%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,shrink-to-fit=no">
    <link  rel="stylesheet" href="css/common.css">
    <!--css-->
    <!-- 新 Bootstrap4 核心 CSS 文件 -->
    <link  rel="stylesheet" href="third/bootstrap-4.1.3-dist/css/bootstrap.css">
    <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.css">
    <!--  // css-->
    <title>逍遥游</title>
</head>
<body>
<!--header start-->
<div class="header container">
    <div class="reg_login_menu">
          <ul> <li><a href="account.html">注册</a></li>
              <!-- 用于打开模态框 -->
            <li><a id="quickLogin" data-toggle="modal" data-target="#myModal" href="">登录</a></li>
              <!-- 模态框 -->
              <div class="modal fade" id="myModal">
                  <div class="modal-dialog">
                      <div class="modal-content">
                          <!-- 模态框头部 -->
                          <div class="modal-header">
                              <h4 class="modal-title">快速登录</h4>
                              <button type="button" class="close" data-dismiss="modal">&times;</button>
                          </div>
                          <!-- 模态框主体 -->
                          <div class="modal-body">
                              <div id="qk_login_form">
                                  <form action="">
                                      <div class="input-group mb-3">
                                          <div class="input-group-prepend"><span class="input-group-text"><i class="fa fa-envelope"></i></span></div>
                                          <input class="form-control" validate="true" type="text" name="loginEmail" placeholder="邮箱地址">
                                          <div class="input-group-append"><span class="input-group-text"><i class="fa fa-hand-o-left"></i></span></div>
                                      </div>
                                      <div></div>
                                      <div class="input-group mb-3">
                                          <div class="input-group-prepend"><span class="input-group-text"><i class="fa fa-lock"></i></span></div>
                                          <input class="form-control" validate="true" type="password" name="loginPwd" placeholder="密码">
                                          <div class="input-group-append"><span class="input-group-text"><i class="fa fa-hand-o-left"></i></span></div>
                                      </div>
                                      <div></div>
                                      <input class="form-control" type="submit" value="登录">
                                      <div id="qk_agreeAutoLogin" class="agree"><input type="checkbox" name="agree" value="1"><label>一周内自动登录</label> <a href="#">忘记密码</a></div>
                                  </form>
                              </div>
                          </div>
                          <!-- 模态框底部 -->
                          <div class="modal-footer">
                              <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                          </div>
                      </div>
                  </div>
              </div>
          </ul>
    </div>
    <div class="menu">
        <ul>
            <li><a href="Home.html">首页</a></li>
            <li><a href="scene.html">景色</a></li>
            <li><a href="method.html">攻略</a></li>
            <li><a href=""> </a></li>
            <li><a href="hotel.html">酒店</a></li>
            <li><a href="food.html">美食</a></li>
            <li><a href=""> </a></li>
        </ul>
    </div>
    <div class="logo"><img src="images/logo.png" alt="logo";width="100"height="100"></div>
<div class="search">
    <form action="" method="get">
        <input type="search" name="keyword" id="keyword" value="" placeholder="关键字">
        <input type="submit" value="">
    </form>
</div>
</div>
<!--header end-->
<!--banner start-->
<div class="banner container-full"></div>
<!--banner end-->
<!--account start-->
<div id="reg_login_form">
<div class="container">
<div class="reg_form">
<%--    <%if(rs<=0){%>--%>
<%--        <h1>注册失败</h1>--%>
<%--    <%<%}else{%>--%>
<%--    <h1>注册</h1>--%>
<%--    <%}%>--%>
    <h1><%=regTip%></h1>
    <form action="RegAction" method="post">
        <div class="input-group mb-3">
            <div class="input-group-prepend"><span class="input-group-text"><i class="fa fa-user-o"></i></span></div>
            <input class="form-control border-info" validate="true" type="text" name="userName" placeholder="用户名">
            <div class="input-group-append"><span class="input-group-text"><i class="fa fa-hand-o-left"></i></span></div>
        </div>
        <div></div>
        <div class="input-group mb-3">
            <div class="input-group-prepend"><span class="input-group-text"><i class="fa fa-envelope-o"></i></span></div>
            <input class="form-control" validate="true" type="email" name="email" placeholder="邮箱">
            <div class="input-group-append"><span class="input-group-text"><i class="fa fa-hand-o-left"></i></span></div>
        </div>
        <div></div>
        <div class="input-group mb-3">
            <div class="input-group-prepend"><span class="input-group-text"><i class="fa fa-mobile"></i></span></div>
            <input class="form-control" validate="true" type="text" name="mobile" placeholder="手机号">
            <div class="input-group-append"><span class="input-group-text"><i class="fa fa-hand-o-left"></i></span></div>
        </div>
        <div></div>
        <div class="input-group mb-3">
            <div class="input-group-prepend"><span class="input-group-text"><i class="fa fa-mars"></i></span></div>
            <div class="elems-inline" id="sexTooltip1" data-toggle="tooltip" data-placement="left" title="请选择性别!">
                <input  id="xxx" type="radio" name="sex" value="male" placeholder="男" ><label>男</label>
            </div>
                <div class="input-group-append"><span class="input-group-text"><i class="fa fa-venus"></i></span></div>
            <div class="elems-inline" id="sexTooltip2" data-toggle="tooltip" data-placement="left" title="请选择性别!">
                <input type="radio" name="sex" value="female" placeholder="女" ><label>女</label>
            </div>
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend"><span class="input-group-text"><i class="fa fa-lock"></i></span></div>
            <input class="form-control" validate="true" type="password" name="pwd" placeholder="密码">
            <div class="input-group-append"><span class="input-group-text"><i class="fa fa-hand-o-left"></i></span></div>
        </div>
        <div></div>
        <div class="input-group mb-3">
            <div class="input-group-prepend"><span class="input-group-text"><i class="fa fa-unlock-alt"></i></span></div>
            <input class="form-control" validate="true" type="password" name="pwd2" placeholder="密码确认">
            <div class="input-group-append"><span class="input-group-text"><i class="fa fa-hand-o-left"></i></span></div>
        </div>
        <div></div>
        <input id="regSubmit" class="form-control" type="submit" value="注册">
        <div  class="agree">
            <input id="agree" type="checkbox" name="agree" value="1" data-toggle="tooltip" data-placement="left" title="必须勾选才可注册!">
            <label>已阅读并通用条款</label>
            <a href="#">条款</a>
        </div>
    </form>
</div>
    <div id="login_form">
<%--        <%if(rs>0){%>--%>
<%--        <h1><%=request.getParameter("userName")%>注册成功请登录</h1>--%>
<%--      <%}else{%>--%>
<%--        <h1>登录</h1>--%>
<%--        <%}%>--%>
    <h1><%=loginTip %></h1>
        <form action="LoginAction" method="post" >
            <div class="input-group mb-3">
                <div class="input-group-prepend"><span class="input-group-text"><i class="fa fa-envelope"></i></span></div>
                <input class="form-control" validate="true" type="email" name="loginEmail" placeholder="邮箱">
                <div class="input-group-append"><span class="input-group-text"><i class="fa fa-hand-o-left"></i></span></div>
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend"><span class="input-group-text"><i class="fa fa-lock"></i></span></div>
                <input class="form-control" validate="true" type="password" name="loginPwd" placeholder="密码">
                <div class="input-group-append"><span class="input-group-text"><i class="fa fa-hand-o-left"></i></span></div>
            </div>
            <input class="form-control" type="submit" value="登录">
            <div id="agreeAutoLogin" class="agree">
                <input type="checkbox" name="agree" value="agree"><label>自动登录</label>
                <a href="#">忘记密码</a></div>
        </form>

</div>
</div>
</div>
<!--account end-->
<!--footer start-->
<div class="footer">
    <div class="container">
    <div >copyright @ 计本一班44号陈采妮版权所有 闽ICP证 111111号.</div>
    <div>
        <a href="">微信</a>
        <a href="">QQ</a>
        <a href="">微博</a>
    </div>
</div>
</div>
<!--footer end-->
<!--js-->
<script src="third/jquery-3.3.1.js"></script>
<script src="third/bootstrap-4.1.3-dist/js/bootstrap.bundle.js"></script>
<script src="third/MD5.js"></script>
<script src="js/common.js"></script>
<!--//js-->
</body>
</html>