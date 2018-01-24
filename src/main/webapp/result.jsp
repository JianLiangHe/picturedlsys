<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/19
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/result.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <!-- 先引入 Vue -->
    <script src="https://unpkg.com/vue/dist/vue.js"></script>
    <!-- 引入组件库 -->
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>

    <style>
        #main .image-box {
            padding: 10px;
            float: left;
        }

        .image-box img {
            width: 200px;
            height: 160px;
        }

        .download-model-box {
            width: 550px;
            height: 250px;
            background-color: #a0cfff;
            border: 3px solid #8cc5ff;
            position: fixed;
            top: 30%;
            left: 30%;
            display: none;
        }
    </style>
</head>
<body>
    <div id="app" >
        <div id="top">
            <h2>网页源码</h2>
            <div style="margin: 20px 0;">
                <textarea rows="20" cols="130">"${crawlContent.sourceCode}"</textarea>
            </div>
        </div>

        <hr/>
        <h2>共搜索出的${crawlContent.pricute.size()} 张图片</h2>
        <input type="button" value="全部下载" onclick="openDownloadBox();"/>
        <div id="main">
            <!--迭代内容-->
            <c:forEach var="obj" varStatus="ids" items="${crawlContent.pricute}">
                <div class="image-box">
                        ${obj}
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- 下载模态框 -->
    <div class="download-model-box">
        <h2>下载所有图片<input type="button" value="关闭" style="float:right;" onclick="closeDownloadBox();"/></h2>
        <h3 id="downloadTip"></h3>
        <form>
            <input name="downPath" type="text" placeholder="请选择本地存储目录,比如: C:\test\"/><br/>
            <input type="button" value="开始下载" onclick="download();">
        </form>
    </div>
</body>
</html>
<script type="text/javascript">

    //打开模态框方法
    function openDownloadBox(){
        $(".download-model-box").css("display","block");
    }

    //关闭模态框方法
    function closeDownloadBox(){
        $(".download-model-box").css("display","none");
    }

    function download(){
        var downPath = document.getElementsByName("downPath")[0].value;
        //downPath = downPath.replace(/\\/,"/");
        var url = "DownloadPictureControll";
        var params = {"downPath":downPath};
        $("#downloadTip").text("正在下载中...");
        $.post(url,params,function(data){
            if(data==1){
                alert("下载成功,请查看文件!");
            }else{
                alert("下载部分图片出错...");
            }
            $("#downloadTip").text("");
        },"json");
    }

</script>