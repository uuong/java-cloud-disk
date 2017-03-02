<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + request.getContextPath() + "/";
%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/23 0023
  Time: 21:28
  To change this template use FileMode | Settings | FileMode Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <%@ include file="layout/css.jsp" %>
    <%@ include file="layout/js.jsp" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/index.css">
</head>
<body>

<div id="header">
    <!-- logo -->
    <div class="top_left">
        <a href="javascript:;" class="logo"></a>
        <div class="top_left_text">

        </div>
    </div>


    <div class="top_right">

        <div class="search">
            <i class="icon"></i>
            <input type="text" value="" placeholder="搜索全部文件"/>
        </div>
        <div class="head_icon">
            <img src="${pageContext.request.contextPath}/static/img/head.png" alt=""/>
            <i class="icon"></i>
        </div>
    </div>
    <p class="tip">新建文件夹成功</p>
</div>

<!-- 内容区 -->
<div id="content" class="clear">
    <!-- 左边导航 -->
    <div id="nav" class="contentLeft fl">

        <div class="up">
            <div class="upload">

                <a href="javascript:;">上传</a>


            </div>
        </div>
        <div class="option">
            <ul>
                <li class="active">
                    <i class="listico icon1"></i>
                    <a href="javascript:;">目录</a>
                </li>
                <li>
                    <i class="listico icon2"></i>
                    <a href="javascript:;">最近</a>
                </li>
                <span class="line"></span>
                <li>
                    <i class="listico icon3"></i>
                    <a href="javascript:;" onclick="doAjax('none')">文档</a>
                </li>
                <li>
                    <i class="listico icon4"></i>
                    <a href="javascript:;">图片</a>
                </li>
                <li>
                    <i class="listico icon5"></i>
                    <a href="javascript:;">音乐</a>
                </li>
                <li>
                    <i class="listico icon6"></i>
                    <a href="javascript:;">视频</a>
                </li>
                <li>
                    <i class="listico icon7"></i>
                    <a href="javascript:;">笔记</a>
                </li>
                <span class="line"></span>
                <li>
                    <i class="listico icon8"></i>
                    <a href="javascript:;">剪贴板</a>
                </li>
                <span class="line"></span>
                <li>
                    <i class="listico icon9"></i>
                    <a href="javascript:;">分享的链接</a>
                </li>
                <li>
                    <i class="listico icon10"></i>
                    <a href="javascript:;">回收站</a>
                </li>
            </ul>
        </div>
        <div class="copyright">
            <a href="">版权声明</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="">投诉指引</a>
        </div>
    </div>
    <!-- 右边主内容区 -->
    <div id="main" class="fl clear">

        <div id="main_header">
            <a href="javascript:;" class="g-btn g-btn-gray" id="download">
		            <span class="btn-inner ">
		                <i class="ico ico-down"></i>
		                <span class="text">下载</span>
		            </span>
            </a>
            <a class="g-btn g-btn-gray" href="javascript:;" id="share">
		            <span class="btn-inner ">
		                <i class="ico ico-share"></i>
		                <span class="text">分享</span>
		            </span>
            </a>
            <a class="g-btn g-btn-gray" href="javascript:;" id="move">
		            <span class="btn-inner ">
		                <i class="ico ico-move"></i>
		                <span class="text">移动到</span>
		            </span>
            </a>
            <a class="g-btn g-btn-gray" href="javascript:;" id="rename">
		            <span class="btn-inner ">
		                <i class="ico ico-rename"></i>
		                <span class="text">重命名</span>
		            </span>
            </a>
            <a class="g-btn g-btn-gray" href="javascript:;" id="delete">
		            <span class="btn-inner ">
		                <i class="ico ico-del"></i>
		                <span class="text">删除</span>
		            </span>
            </a>
            <a class="g-btn g-btn-gray" href="javascript:;" id="addMkdir">
		            <span class="btn-inner ">
		                <i class="ico ico-mkdir"></i>
		                <span class="text">新建文件夹</span>
		            </span>
            </a>
            <a class="g-btn g-btn-gray" href="javascript:;" id="a-restart">
		            <span class="btn-inner  minpad ">
		                <i class="ico ico-ref"></i>
		                <span class="text"></span>
		            </span>
            </a>
        </div>

        <%--<div class="main_bottom_left1 main_bottom_left fl">--%>
        <%--<!-- 树形菜单 -->--%>
        <%--</div>--%>
        <div class="main_bottom_right fl">
            <!-- 右边标题区 -->
            <div class="disTitle">
                <label class="checkall"></label>
                <div class="path-nav clear">
                    <span class="current-path" style="z-index:11" data-file-id="0">xx云</span>
                </div>
            </div>

            <table class="table table-striped  table-hover">
                <tr>
                    <th width="150">文件名</th>
                    <th width="150">大小</th>
                    <th width="150">类型</th>
                    <th width="150">下载</th>
                </tr>
            </table>


            <!-- 右边显示文件夹区 -->
            <div id="disContent"></div>
            <div id="file_empty" class="g_empty sort_folder_empty">
                <div class="empty_box">
                    <div class="ico"></div>
                    <p class="title">暂无文件</p>
                    <p class="content">请点击左上角的“上传”按钮添加</p>
                </div>
            </div>


        </div>
        <!-- 内容区的结束部分 -->
    </div>

    <div id="alertBox">
        <p class="title">删除文件<span class="close">×</span></p>
        <div class="alertContent">
            <span class="bg">确定要删除这个文件夹吗?</span>
            <span class="span2">已删除的文件可以在回收站找到</span>
            <div class="btn" style="font-size:13px;">
                <span id="ok" style="background: #298ff4;color:#fff;">确定</span>
                <span id="cancle">取消</span>
            </div>
        </div>
    </div>
    <div id="mask"></div>
    <div id="menu">
        <li id="z">下载</li>
        <li id="delectBtn">删除</li>
        <li id="renameBtn">重命名</li>
        <li id="moveBtn">移动到</li>
        <li id="x">分享到</li>
    </div>


    <div id="disk_table">
        <%@include file="layout/disk-table.jsp" %>
    </div>
</div>
</div>

</body>
<script type="text/javascript">

    function doAjax(url) {
        $.ajax({
            type: "POST",
            url: "disk/get?type=" + url,

            success: function (response) {
//                alert(response);

                $("#disContent").html(response);
            }
        });
    }
</script>
</html>
