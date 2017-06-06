<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!Doctype html>
<html>
<head>
    <title>HttpMessageConverter</title>
</head>
<body>

<div id="resp"></div>
<input type="button" onclick="reg();" value="请求">

<script src="assets/js/jquery.js" type="text/javascript"></script>

<script>
    function reg() {
        $.ajax({
            url: "convert",
            data: "1-wangyunfei", // 注意这里的数据格式，后台处理按此格式处理，用"-"隔开。
            type: "POST",
            contentType: "application/x-heqingbao", // 自定义的application/x-heqingbao
            success: function (data) {
                $("#resp").html(data)
            }
        });
    }
</script>

</body>
</html>