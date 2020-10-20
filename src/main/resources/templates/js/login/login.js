layui.use(['layer', 'form', 'jquery'], function() {
    let $ = layui.jquery,
        layer = layui.layer,
        form = layui.form;
    
    form.on('submit(login)', function () {
        let index = layer.load();
        $.ajax({
            type: 'get',
            url:  '/user/login.do',
            data: {
                'loginId': $('#loginId').val(),
                'password': $('#password').val()
            },
            dataType: 'json',
            async: false,
            success: function (result) {
                console.log(result);
                if (result.code == 0) {
                    $.cookie("loginId", result.data.loginId);
                    setTimeout(function() {
                        layer.close(index);
                        layer.msg('登录成功', {
                            time: 800,
                            icon: 1
                        }, function () {
                            window.location.href = 'index.html';
                        });
                    }, 800);
                }else {
                    layer.msg(result.msg);
                }
            }
        });
        return false;
    });
});
