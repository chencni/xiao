/**
 * Created by chenzhong on 2018/11/19.
 */
$(
    function () {
        $('.gallery a').Chocolat();//绑定点击事件
        //设置ajax请求完成后运行的函数,
        $.ajaxSetup({
            complete: function (xhr, status) {
                if ("REDIRECT" == xhr.getResponseHeader("REDIRECT")) { //若HEADER中含有REDIRECT说明后端想重定向，
                    var win = window;
                    while (win != win.top) {
                        win = win.top;
                    }
                    win.location.href = xhr.getResponseHeader("CONTENTPATH");//将后端重定向的地址取出来,使用win.location.href去实现重定向的要求
                }
            }
        });
      
        var _editor;
        //重新实例化一个编辑器，防止在上面的editor编辑器中显示上传的图片或者文件
        $("#upload_ue").hide();
        _editor = UE.getEditor('upload_ue', {zIndex: 1055});
        _editor.ready(function () {
            //隐藏编辑器，因为不会用到这个编辑器实例，所以要隐藏
            _editor.hide();
            //设置编辑器不可用
            _editor.setDisabled();

            //侦听图片上传
            _editor.addListener('beforeInsertImage', function (t, arg) {
                //把图片url封装成json 数组
                var imagesUrl=new Array();
                for (i=0;i<arg.length;i++){
                    imagesUrl.push(arg[i].src)
                }
                var url = "SendGalleryAction";
                var data ="imagesUrl="+JSON.stringify(imagesUrl);
                $.post(url, data, callbackFn);
                function callbackFn(returnData, status, xhr) {
                    alert(returnData.saveRs);//提示
                    pageClick(null, 1);//跳到第一页
                };

            });
        });
       
        $("#uploadGallery").click(upImage);
        //弹出图片上传的对话框
        function upImage() {
            var myImage = _editor.getDialog("insertimage");
            myImage.open();
            return false;
        }

        //弹出文件上传的对话框
        function upFiles() {
            var myFiles = _editor.getDialog("attachment");
            myFiles.open();
        }
//分页导航twbsPagination
        var $pagination = $('#pagination');//分页导航位置
        var defaultOpts = {//分页导航参数配置
            totalPages: 100,
            visiblePages: 5,
            initiateStartPageClick: true,//第一次加载页面时模拟点击第一页，调用下面的回调函数获取totalPages 与分页内容，更新页面，默认为true
            hideOnlyOnePage: false, //默认false
            first: '<nobr>首页</nobr>',
            prev: '<nobr>前一页</nobr>',
            next: '<nobr>后一页</nobr>',
            last: '<nobr>尾页</nobr>',
            onPageClick: pageClick//点击的回调函数
        };
      
        $pagination.twbsPagination(defaultOpts);//生成分页导航
        function pageClick(event, currentPage) {
            //启动异步通信向后台提交currenPage
            var url = "GalleryPaginationAction";
            var data = "currentPage="+currentPage;
            var dataType = "json";
            $.post(url, data, callbackFn, dataType);//ajax
            function callbackFn(returnJsonData) {//后台返回totalPages和分页数据returnJsonData
                var totalPages = returnJsonData.newTotalPages;
                $pagination.twbsPagination('destroy');
                defaultOpts.initiateStartPageClick = false;// !!!!否则会死循环！！！
                $pagination.twbsPagination($.extend({}, defaultOpts, {//刷新导航条
                    startPage: currentPage,
                    totalPages: totalPages
                }));
                refreshContent(returnJsonData.content);// 更新分页数据
            }
        }
       
        function refreshContent(jsonContent) {// 更新分页数据
            //遍历所有图片模板节点
            $(".gallery-grids ul li").each(function (index, curNode) {
                var curJsonContentLength = jsonContent.length;
                if (curJsonContentLength > index) {
                    imageUrl = jsonContent[index].imageUrl;
                    $($(curNode).find("a")[0]).attr("href", imageUrl);
                    $($(curNode).find("img")[0]).attr("src", imageUrl);
                    $($(curNode).find("a")[0]).addClass("bigPic");
                    $(curNode).show();
                } else{
                	$($(curNode).find("a")[0]).removeClass("bigPic");//响应点击弹出
                	$(curNode).hide();
                }
            });
            $('.gallery .bigPic').Chocolat();//绑定点击事件
        };
      
      //快速登录
        function loginSubmit(){
        	var loginPwd=$("#qk_login_form input[name='loginPwd']").val();
        	$("#qk_login_form input[name='loginPwd']").val(hex_md5(loginPwd));//密码MD5加密
        	return true;
        }
        $("#qk-submit").click(loginSubmit);
    }
)