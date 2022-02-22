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
        <!--新闻头部-->
        <div class="row">
            <div class="col-12 news_header text-center mt-3 mb-5">
                <h1><h1><%=userName==null?"攻略":userName+"攻略" %></h1></h1>
                <h6>最新攻略</h6>
            </div>
        </div>
        <!--新闻头部-->

        <!--新闻内容模板-->
        <div class="row  mb-2"><!--lg-->
            <div class="col-lg-6 ajaxRefresh">
                <div class="container-fluid">
                    <div class="row mb-2"><!--sm-->
                        <div class="col-sm-4">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-12 news_img text-center">
                                        <img src="images/11.jpeg" class="m-auto" alt="/"width="100"height="100">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-12 newsContent">
                                        <div>
                                            <a class="nav-link" href="#" data-toggle="modal" data-target="#newsModal">
                                                <h5> 标题</h5></a>
                                        </div>
                                        <p class="refreshDetail">摘要</p>
                                        <div class="hiddenCotent" style="display:none"></div><!-- 位置很重要 -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!--sm-->
                </div>
            </div>

            <div class="col-lg-6 ajaxRefresh">
                <div class="container-fluid">
                    <div class="row mb-2"><!--sm-->
                        <div class="col-sm-4">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-12 news_img text-center">
                                        <img src="images/11.jpeg" class="m-auto" alt="/"width="100"height="100">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-12 newsContent">
                                        <div>
                                            <a class="nav-link" href="#" data-toggle="modal" data-target="#newsModal">
                                                <h5> 标题</h5></a>
                                        </div>
                                        <p class="refreshDetail">摘要</p>
                                        <div class="hiddenCotent" style="display:none"></div><!-- 位置很重要 -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!--sm-->
                </div>
            </div>
        </div>
        <div class="row  mb-2"><!--lg-->
            <div class="col-lg-6 ajaxRefresh">
                <div class="container-fluid">
                    <div class="row mb-2"><!--sm-->
                        <div class="col-sm-4">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-12 news_img text-center">
                                        <img src="images/11.jpeg" class="m-auto" alt="/"width="100"height="100">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-12 newsContent">
                                        <div>
                                            <a class="nav-link" href="#" data-toggle="modal" data-target="#newsModal">
                                                <h5> 标题</h5></a>
                                        </div>
                                        <p class="refreshDetail">摘要</p>
                                        <div class="hiddenCotent" style="display:none"></div><!-- 位置很重要 -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!--sm-->
                </div>
            </div>

            <div class="col-lg-6 ajaxRefresh">
                <div class="container-fluid">
                    <div class="row mb-2"><!--sm-->
                        <div class="col-sm-4">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-12 news_img text-center">
                                        <img src="images/11.jpeg" class="m-auto" alt="/"width="100"height="100">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-12 newsContent">
                                        <div>
                                            <a class="nav-link" href="#" data-toggle="modal" data-target="#newsModal">
                                                <h5> 标题</h5></a>
                                        </div>
                                        <p class="refreshDetail">摘要</p>
                                        <div class="hiddenCotent" style="display:none"></div><!-- 位置很重要 -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!--sm-->
                </div>
            </div>
        </div>
        <!--新闻内容模板-->

        <!-- 浏览新闻模态框 模板-->
        <div class="modal fade" id="newsModal">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">

                    <!-- 模态框头部 -->
                    <div class="modal-header">
                        <h3 class="modal-title mx-auto">攻略浏览</h3>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- 模态框主体 -->
                    <div class="modal-body">
                        <div class="" id="newsContentModal"></div>
                    </div>
                    <!-- 模态框底部 -->

                    <div class="modal-footer justify-content-center">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal"> 评论</button>
                    </div>

                </div>
            </div>
        </div>
        <!-- //浏览新闻模态框模板 -->

        <!-- 发布新闻模态框 -->
        <div class="modal fade" id="sendNewsModal">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">

                    <!-- 模态框头部 -->
                    <div class="modal-header">
                        <h4 class="modal-title">攻略发布</h4>
                        <button type="button" class="close"
                                data-dismiss="modal">&times;</button>
                    </div>

                    <!-- 模态框主体 -->
                    <div class="modal-body">
                        <form id="newsForm">
                            <p id="newsUeditor"><!--百度富文本编辑器--></p>
                            <input type="hidden" id="newContent" name="newContent">
                            <input id="newsImg" name="newsImg" type="hidden">
                            <a  id="selectImg">选择图片</a><img id="preview" class="newsImg" src="images/img19.jpg">
                            <script type="text/javascript" id="upload_ue"></script>
                            <div class="input-group mt-2 mb-2">
                                <div class="input-group-prepend">
                                    <sapn class="input-group-text"><i class="fa fa-tripadvisor fa-fw"></i></sapn>
                                </div>
                                <input id="title" name="title" class="form-control" placeholder="攻略标题" type="text" tabindex="1">
                            </div>
                            <div class="input-group mt-2 mb-2">
                                <div class="input-group-prepend">
                                    <sapn class="input-group-text"><i class="fa fa-list fa-fw"></i></sapn>
                                </div>
                                <input id="detail" name="detail" class="form-control" placeholder="攻略摘要" type="text" tabindex="2">
                            </div>
                            <div class="justify-content-center text-center">
                                <input id="sendNews"  type="button" class="btn btn-secondary" data-dismiss="modal" value="发布攻略">
                            </div>
                        </form>
                    </div>


                </div>
            </div>
        </div>
        <!-- //发布新闻模态框 -->

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
<script src="third/MD5.js"></script>
<script src="js/news.js"></script>
<!--//js-->
</body>
</html>