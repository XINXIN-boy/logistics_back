layui.use(['layer', 'form', 'element', 'jquery'], function() {

    let element = layui.element,
        $ = layui.jquery,
        layer = layui.layer,
        form = layui.form;

    $("#oldPassword").change(function () {
        $.ajax({
            url: "/user/judgeOldPassword.do",
            type:"post" ,
            data:"oldPassword="+$("#oldPassword").val(),
            success:function (data) {
                if (data.code == 0){
                    layer.msg(data.msg)
                    $("#newPassword").attr("disabled",false)
                    $("#change").attr("disabled",false)
                }else {
                    layer.msg(data.msg)
                    $("#newPassword").attr("disabled",true)
                    $("#change").attr("disabled",false)
                }
            }
        })
    })


    form.on('submit(change)', function () {

        $.ajax({
            type: 'post',
            url:  '/user/updateUserPassword.do',
                async: false,
            data: {
                'loginId': $.cookie("loginId"),
                'Password': $("#newPassword").val()
            },
            dataType: 'json',
            success: function (result) {
                console.log(result);
                if (result.code ==0) {
                    layer.msg('密码修改成功', {
                        time: 800,
                        icon: 1
                    }, function () {
                        $('#passForm')[0].reset()
                    });
                } else {
                    layer.msg('密码修改失败', {
                        time: 800,
                        icon: 5
                    });
                }
            }
        });

        return false;
    })

});


