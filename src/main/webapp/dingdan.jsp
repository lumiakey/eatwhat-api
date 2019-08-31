<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>


    <form action="post">
<body>
<div>
    <div>

        <div class="top">
            <li>添加菜品信息</li>
        </div>

        <div class="center">
            <ul>
                <li>菜单名称 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input type="text" id="foodName"></li>
                <li>单价     &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" id="foodPrice"></li>
                <li>菜品图片 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input type="text" id="foodPicture"></li>
                <li>库存    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" id="inventory"></li>
                <li>菜品的位置信息&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" id="foodLocation"></li>
                <li>时间提示分为‘早’&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" id="timeTips"></li>
                <li>菜品简介&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" id="foodDesc"></li>

                <li>菜品入库id状态&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" id="foodStateFlag"></li>
                <li>入库时间&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" id="inTime"></li>
                <li>上架时间&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" id="putTime"></li>
                <li>下架时间&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" id="downTime"></li>
            </ul>
        </div>
    </div>
</div>
</body>
<div class="bt1">
    <input type="button" value="确认提交" onclick="fun()">
</div>
</head>
</form>
</head>
<style>
    li{
        list-style: none;
        margin-top: 20px;
    }
    .top{
        margin-left: 900px;
    }
    .center{
        margin-left: 700px;
        margin-top: 150px;
    }
    .bt1{
        margin-left: 900px;
    }
</style>
<script src="http://static.suo.im/static/home/js/jquery-3.2.1.min.js"></script>
<script src="http://static.suo.im/static/home/js/jquery.qrcode.min.js"></script>
<script src="http://static.suo.im/static/suo.im/js/index.js?v=1.1"></script>
<script src="http://static.suo.im/static/suo.im/js/dialog.js?v=2"></script>

<script>

    function fun() {
        // alert($("input#foodName").val()+" " +
        //     ""+$("input#foodPrice").val()+" " +
        //     ""+$("input#foodPicture").val()+" " +
        //     ""+$("input#inventory").val()+" " +
        //     ""+$("input#foodLocation").val()+"" +
        //     " "+$("input#timeTips").val()+" " +
        //     ""+$("input#foodDesc").val()+" " +
        //     ""+$("input#foodStateFlag").val()+"" +
        //     " "+$("input#inTime").val()+" " +
        //     ""+$("input#putTime").val()+" " +
        //     ""+$("input#downTime").val())
        var mall = {
            foodName:$("input#foodName").val(),
            foodPrice:$("input#foodPrice").val(),
            foodPicture:$("input#foodPicture").val(),
            inventory:$("input#inventory").val(),
            foodLocation:$("input#foodLocation").val(),
            foodStateFlag:$("input#foodStateFlag").val(),
            timeTips:$("input#timeTips").val(),
            foodDesc:$("input#foodDesc").val(),
            inTime:$("input#inTime").val(),
            putTime:$("input#inTime").val(),
            downTime:$("input#downTime").val()

        };

        $.ajax({
            type: 'post',
            url: "test.jsp",
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            data:{ mallInstitution: JSON.stringify(mall) },
            cache: false,
            success: function (data) {
                if(data == -1) {
                    alert("不存在该短链接");
                    return;
                }else {
                    $("#shortLink").val(data+"次");
                }
            },
            error: function (data) {
                alert("错了吧！！")
            }
        });



    }
</script>
</html>
