<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/19
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index_base.css">
    <!-- 先引入 Vue -->
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
    <!-- 引入element组件库 -->
    <script src="${pageContext.request.contextPath}/js/index.js"></script>

</head>
<body>
    <div id="app" >
        <div id="top">
            <el-row>
                <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
                <el-col :span="8">
                    <div class="grid-content bg-purple-light">
                        <div id="logo">
                            <div id="logo_text">
                                <b>JAVA</b>
                            </div>
                        </div>
                    </div>
                </el-col>
                <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
            </el-row>

            <el-row>
                <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
                <el-col :span="8">
                    <div class="grid-content bg-purple-light">
                        <div id="titleInfo">
                            {{ titleInfo }}
                        </div>
                    </div>
                </el-col>
                <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
            </el-row>
        </div>

        <div id="main">
            <el-row>
                <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
                <el-col :span="8">
                    <div class="grid-content bg-purple-light">
                        <form id="frm" action="WebCrawlControll" method="post">
                        <div id="inputInfo">
                            <el-input :placeholder="inputPlaceholder" v-model="inputtext" name="url">
                            </el-input>
                            <div id="main_button">
                                <!--主体按钮-->
                                <el-button type="info" size="small" @click="test">获取网页源代码</el-button>
                            </div>
                        </div>
                        </form>
                    </div>
                </el-col>
                <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
            </el-row>
        </div>

        <div id="bottom">
            <el-row>
                <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
                <el-col :span="8">
                    <div class="grid-content bg-purple-light">
                        <div id="bottomInfo">
                            {{bottomTilet }}
                            <br />
                            {{ inputtext }}
                        </div>
                    </div>
                </el-col>
                <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
            </el-row>
        </div>
    </div>
</body>
</html>
<script>
    new Vue({
        el: '#app',
        data: function() {
            return {
                visible: false ,
                titleInfo: '图片下载系统',
                inputtext: '',
                inputPlaceholder: '请输入URL:如:http://www.qq.com',
                bottomTilet: '需要视频素材请联系老师QQ'
            }
        },
        methods: {
            /*点击按钮时触发此方法*/
            test(){
                submitFrm();
            }
        }
    });

    //提交表单方法
    function submitFrm(){
        if(checkURL()){
            var frm = document.getElementById("frm");
            frm.submit();
        }
    }

    //检查URL方法
    function checkURL(){
        var url = document.getElementsByName("url")[0].value;
        var reg = /http:\/\/|https:\/\//;
        if(!reg.test(url)){
            alert("URL输入格式不正确!");
            document.getElementsByName("url")[0].focus();
            return false;
        }
        return true;

    }
</script>
