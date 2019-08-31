<%--
  Created by IntelliJ IDEA.
  User: caihongyu
  Date: 2019/5/18
  Time: 下午3:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<script>
    function $(v){return document.getElementById(v);}
    var x=0;
    function c(y){
        $("a"+x).style.display = "none";
        $("a"+y).style.display = "";
        x=y
    }

</script>

<style>
    #main{
        width: auto;
        height:auto;
        overflow:hidden;
        visibility:visible;
        margin:auto;
        margin-left: 0px;
        margin-top:200px;
    }
    #left{
        width:300px;
        float:left;
        border:#CCCCCC 1px solid;
    }
    #right{
        width: 1600px;
        height: auto;
        float:left;
        border:#CCCCCC 1px solid;

    }
    .orlder_content{
        margin-top: 350px;
    }
</style>

<div id="main">
    <div id="left">
        <a href="javascript:;" onclick="c(0);">菜单一</a>
        <div class="orlder_content">
            <a href="javascript:;" onclick="c(1);">菜单二</a>
        </div>

    </div>
    <div id="right">
        <div id="a0">
            <iframe src="caipin.jsp" frameborder="0"></iframe> </a> </div>
        <div id="a1" style="display:none;">
            <iframe src="dingdan.jsp" frameborder="0"></iframe></div>
    </div>
</div>
</body>
</html>
