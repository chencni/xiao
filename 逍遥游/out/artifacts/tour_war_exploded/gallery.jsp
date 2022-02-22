<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String userName=(session.getAttribute("userName")!=null?session.getAttribute("userName").toString():null);
%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1,shrink-to-fit=no">
        <link  rel="stylesheet" href="css/common.css">
        <!--css-->
        <!-- 新 Bootstrap4 核心 CSS 文件 -->
        <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.css">
        <link rel="stylesheet" href="third/bootstrap-4.1.3-dist/css/bootstrap.css">
        <link rel="stylesheet" href="third/chocolate/chocolat.css" type="text/css">
        <link rel="stylesheet" href="css/common.css">
        <!--  // css-->
        <title>逍遥游</title>
    </head>
<body>
<!--header start-->
<div class="header container">
    <div class="reg_login_menu">
        <ul>
            <%if(userName==null){ %>
            <li><a href="account.jsp"> 注册</a></li>
            <li>
                <!-- 用于打开模态框 -->
                <a id="quickLogin" data-toggle="modal" data-target="#myModal" href="#"> 登录</a>
            </li>
            <%}else{ %>
            <li><a href="LoginOutAction?curUrl=gallery.jsp">注销</a></li>
            <li><a id="uploadGallery" href=""> 发布</a></li>
            <%} %>
            <script type="text/javascript" id="upload_ue"></script><!-- 弹出对话框 ,必须放在页面上，否则百度创建会出错！-->
            <!-- 快速登录模态框 -->
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
                                <form action="LoginAction">
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend"><span class="input-group-text"><i
                                                class="fa fa-user"></i></span>
                                        </div>
                                        <input class="form-control" validate="true" type="text" name="loginEmail"
                                               placeholder="邮箱地址">
                                        <div class="input-group-append"><span class="input-group-text"><i
                                                class="fa fa-hand-o-left"></i></span></div>
                                    </div>
                                    <div></div>
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend"><span class="input-group-text"><i
                                                class="fa fa-lock"></i></span>
                                        </div>
                                        <input class="form-control" validate="true" type="password" name="loginPwd"
                                               placeholder="密码">
                                        <div class="input-group-append"><span class="input-group-text"><i
                                                class="fa fa-hand-o-left"></i></span></div>
                                    </div>
                                    <div></div>
                                    <input type="hidden" name="quckLogin" value="true">
                                    <input type="hidden" name="curUrl" value="gallery.jsp">
                                    <input id="qk-submit" class="form-control" type="submit" value="登录">
                                    <div id="qk_agreeAutoLogin" class="agree"><input type="checkbox" name="agree" value="1"><label>一周内自动登录</label>
                                        <a href="#">忘记密码</a></div>

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
            <!-- 快速登录模态框 -->
        </ul>
    </div>
    <div class="menu">
        <ul>
            <li><a href="Home.html">首页</a></li>
            <li><a href="gallery.html">景色</a></li>
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
<!--content-->
<div id="news" class="mb-5">
    <div class="container-fluid">
        <!--相册头部-->
        <div class="row">
            <div class="col-12 news_header text-center mt-3 mb-5">
                <h1>部分景色</h1>
            </div>
        </div>
        <!--相册头部-->

        <!--相册内容模板-->
        <div class="row gallery mb-2">
            <div class="gallery-grids">
                <ul>
                    <li>
                        <p>赏漓江渔火，还原国币画卷</p>
                        <a href="images/21.jpeg">
                            <img src="images/21.jpeg" alt=""/>
                            <div class="glry-bgd">
                            </div>
                        </a>
                    </li>
                    <li>
                        <p>乌龙泉——看桂林最美夕阳的地方</p>
                        <a href="images/22.jpeg">
                            <img src="images/22.jpeg" alt=""/>
                            <div class="glry-bgd">
                            </div>
                        </a>
                    </li>
                    <li>
                        <p>遇龙河漂流——“小漓江”</p>
                        <a href="images/23.jpeg">
                            <img src="images/23.jpeg" alt=""/>
                            <div class="glry-bgd">
                            </div>
                        </a>
                    </li>
                    <li>
                        <p>两江四湖——媲美威尼斯的环城水系</p>
                        <a href="images/24.jpeg">
                            <img src="images/24.jpeg" alt=""/>
                            <div class="glry-bgd">
                            </div>
                        </a>
                    </li>
                    <li>
                        <p> 银子岩——游了银子岩，一世不缺钱</p>
                        <a href="images/26.jpeg">
                            <img src="images/26.jpeg" alt=""/>
                            <div class="glry-bgd">
                            </div>
                        </a>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>
        </div>
        <!--相册内容模板-->


        <!--分页导航-->
        <div class="row mt-5">
            <div class="col-12">
                <nav aria-label="Page navigation">
                    <ul class="pagination justify-content-center" id="pagination"></ul>
                </nav>
            </div>
        </div>
        <!--分页导航-->

    </div>
</div>

<!--//content-->
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
<script src="third/twbs-pagination-master/jquery.twbsPagination.js"></script>
<script type="text/javascript" charset="utf-8" src="third/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="third/ueditor/ueditor.all.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="third/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" charset="utf-8" src="third/chocolate/jquery.chocolat.js"></script>
<script src="js/gallery.js"></script>
<!--//js-->
</body>

