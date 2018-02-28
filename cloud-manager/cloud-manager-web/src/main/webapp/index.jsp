<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<h2>Hello World!</h2>

<script type="text/javascript" src="jquery-3.2.1.js">
</script>

<script>

    function ajaxTest()
    {

/*        $.ajax({
            type:"GET",
            url:js_path + "/maintainAdd/add",
            data : {id:"1111",username:"liyong"},
            contentType : "application/json",
            dataType : "json",
            complete:function(msg) {

            }
        });*/

        alert(11122);

    }

</script>
<button onclick="ajaxTest()">
    提交
</button>
</body>
</html>
