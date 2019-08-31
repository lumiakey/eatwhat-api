<%--
  Created by IntelliJ IDEA.
  User: caihongyu
  Date: 2019/5/18
  Time: 下午4:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>login</title>
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
        }
        #wrap {
            height: 719px;

            background-image: url(picture/g.jpeg);
            background-size:2000px 750px ;
            background-repeat: no-repeat;
            background-position: center center;
            position: relative;
        }
        #head {
            height: 120px;

            background-color: #66CCCC;
            text-align: center;
            position: relative;
        }
        #foot {

            height: 126px;
            background-color: #CC9933;
            position: relative;
        }
        #wrap .logGet {
            height: 408px;
            width: 368px;
            position: absolute;
            background-color: #FFFFFF;
            top: 20%;
            right: 15%;
        }
        .logC a button {
            width: 100%;
            height: 45px;
            background-color: #ee7700;
            border: none;
            color: white;
            font-size: 18px;
        }
        .logGet .logD.logDtip .p1 {
            display: inline-block;
            font-size: 28px;
            margin-top: 30px;
            width: 86%;
        }
        #wrap .logGet .logD.logDtip {
            width: 86%;
            border-bottom: 1px solid #ee7700;
            margin-bottom: 60px;
            margin-top: 0px;
            margin-right: auto;
            margin-left: auto;
        }
        .logGet .lgD img {
            position: absolute;
            top: 12px;
            left: 8px;
        }
        .logGet .lgD input {
            width: 100%;
            height: 42px;
            text-indent: 2.5rem;
        }
        #wrap .logGet .lgD {
            width: 86%;
            position: relative;
            margin-bottom: 30px;
            margin-top: 30px;
            margin-right: auto;
            margin-left: auto;
        }
        #wrap .logGet .logC {
            width: 86%;
            margin-top: 0px;
            margin-right: auto;
            margin-bottom: 0px;
            margin-left: auto;
        }


        .title {
            font-family: "宋体";
            color: #FFFFFF;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);  /* 使用css3的transform来实现 */
            font-size: 36px;
            height: 40px;
            width: 30%;
        }

        .copyright {
            font-family: "宋体";
            color: #FFFFFF;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);  /* 使用css3的transform来实现 */
            height: 60px;
            width: 40%;
            text-align:center;
        }


        #foot .copyright .img {
            width: 100%;
            height: 24px;
            position: relative;
        }
        .copyright .img .icon {
            display: inline-block;
            width: 24px;
            height: 24px;
            margin-left: 22px;
            vertical-align: middle;

            background-repeat: no-repeat;
            vertical-align: middle;
            margin-right: 5px;
        }

        .copyright .img .icon1 {
            display: inline-block;
            width: 24px;
            height: 24px;
            margin-left: 22px;
            vertical-align: middle;

            background-repeat: no-repeat;
            vertical-align: middle;
            margin-right: 5px;
        }
        .copyright .img .icon2 {
            display: inline-block;
            width: 24px;
            height: 24px;
            margin-left: 22px;
            vertical-align: middle;

            background-repeat: no-repeat;
            vertical-align: middle;
            margin-right: 5px;
        }
        #foot .copyright p {
            height: 24px;
            width: 100%;
        }
    </style>
</head>

<body>
<div class="header" id="head">
    <div class="title">EatWhat</div>

</div>

<div class="wrap" id="wrap">
    <div class="logGet">
        <!-- 头部提示信息 -->
        <div class="logD logDtip">
            <p class="p1">登录</p>
        </div>
        <!-- 输入框 -->
        <div class="lgD">
            <img src="picture/msg.png" width="20" height="20" alt=""/>
            <input type="text" id="adminName"
                   placeholder="输入用户名" />
        </div>
        <div class="lgD">
            <img src="picture/login.png" width="20" height="20" alt=""/>
            <input type="text" id="password"
                   placeholder="输入用户密码" />
        </div>
        <div class="logC">
            <a  target="_self"><button id="btn_img" >登 录</button></a>
        </div>
    </div>
</div>

<div class="footer" id="foot">
    <div class="copyright">
        <p>Copyright © 2018 Qunar.com Inc. All Rights Reserved.</p>
        <div class="img">
            <i class="icon"></i><span>联系邮箱：jiankangsun@yahoo.com</span>
        </div>

        <div class="img">
            <i class="icon1"></i><span>联系地址：黑龙江大学</span>
        </div>

        <div class="img">
            <i class="icon2"></i><span>联系电话：18355042634</span>
        </div>


    </div>

</div>
<script src="http://static.suo.im/static/home/js/jquery-3.2.1.min.js"></script>
<script src="http://static.suo.im/static/home/js/jquery.qrcode.min.js"></script>
<script src="http://static.suo.im/static/suo.im/js/index.js?v=1.1"></script>
<script src="http://static.suo.im/static/suo.im/js/dialog.js?v=2"></script>

<script type="text/javascript">
    $(function(){
        $("#btn_img").click(function(){
             var aname=$("#adminName").val();
             var pwd=$("#password").val();


            if(aname=="" || aname == null){
                alert("用户名不能为空!");
                return;
            }
            if(pwd=="" || pwd == null){
                alert("密码不能为空!");
                return;
            }
            console.log(aname + " " + pwd);

            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/administrator/login',
                data: {
                    "phonenumber":aname,
                    "password":pwd
                },
                cache: false,
                dataType:"application/x-www-form-urlencoded",
                success: function (data) {
                    alert(data);
                },
                error: function (data) {
                    alert("错了吧！！" + data);
                }
            });
        });
    });
</script>


</body>
</html>
