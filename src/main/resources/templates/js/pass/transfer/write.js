layui.use(['element', 'form', 'laydate', 'layer', 'table'], function () {
    let element = layui.element,
        form = layui.form,
        laydate = layui.laydate,
        layer = layui.layer,
        table = layui.table;

    let driverId = $.cookie("loginId");
    let goodsBillCode = window.location.href.split("=")[1];

    $.ajax({
        type:'get',
        url:'/transfer/findcominfo',
        dataType:'json',
        success:function (data) {
            if(data.code ==0){
                $.each(data.data(), function (i,item) {
                    $("#transferStation").append(new Option(item.city,item.id))
                });
            }
            form.render('select');
        }
    });

    form.on('select(transferStation)',function (data) {

        $.ajax({
            type:'get',
            url:'/transfer/selectcominfo?id=' + data.value,
            dataType:'json',
            async: false,
            success:function (result) {
                if(result.code == 0){
                    $("#transferCompany").val(result.data.companyName);
                    $("#transferAddr").val(result.data.detailAddress);
                    $("#transferStationTel").val(result.data.linkPhone);
                    $("#transferFee").val(1.3);
                    $("#afterTransferBill").val(goodsBillCode);
                    $("#transferCheck").val(driverId);
                }
                laydate.render({
                    elem: '#checkTime',
                    value: new Date()
                });
            }
        })
    })

    form.on('submit(addInfo)', function () {

        $("#transferForm :input").each(function () {
            $(this).removeAttr("disabled");
        });

        $.ajax({
            type: 'post',
            url: '/transfer/addInfo?goodsBillCode=' + goodsBillCode,
            data: $("#transferForm").serialize(),
            dataType: 'json',
            success: function (result) {
                if (result.code == 0) {
                    layer.msg('中转信息插入成功', {
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
    })

});