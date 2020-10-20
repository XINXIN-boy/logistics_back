layui.use(['layer', 'form', 'element', 'jquery', 'table', 'laydate'], function() {
    let element = layui.element,
        $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        table = layui.table,
        laydate = layui.laydate;

    let bill_code = window.location.href.split('=')[1];
    let employeeId = $.cookie('loginId');

    form.render();

    $.ajax({
        type: 'get',
        url: '/driver/findAll.do?page=1&limit=10',
        dataType: 'json',
        async: false,
        success: function (result) {
            console.log(result);
            $.each(result.data, function (i, item) {
                let option = '<option value="' + item.id + '">';
                option += item.id;
                option += '</option>';
                $("#receiveBillPerson").append(option);
            });
            form.render('select');
        }
    });

    $("#releasePerson").val(employeeId);
    laydate.render({
        elem: '#receiveBillTime',
        value: new Date()
    });

    form.on('submit(release)', function () {
        $("#releaseForm :input").each(function () {
            $(this).removeAttr("disabled");
        });

        $.ajax({
            type: 'post',
            url: '/bill/addBillRelease.do?billCode=' + bill_code,
            data: $("#releaseForm").serialize(),
            dataType: 'json',
            async: false,
            success: function (result) {
                if (result.code == 0) {
                    layer.msg('分发成功', {
                        time: 800,
                        icon: 1
                    }, function () {
                        let index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                    })
                }
            }
        });
        return false;
    });
});