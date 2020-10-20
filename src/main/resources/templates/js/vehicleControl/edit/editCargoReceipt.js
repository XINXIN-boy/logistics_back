layui.use(['element', 'form', 'laydate', 'layer', 'table'], function() {
    let element = layui.element,
        form = layui.form,
        laydate = layui.laydate,
        layer = layui.layer,
        table = layui.table;

    lay('.test-item').each(function () {
        laydate.render({
            elem: this,
            trigger: 'click'
        })
    });

    $.ajax({
        type: "get",
        url:"/vehicle/findAllCargoreceiptdetail.do?page=1&limit=50",
        async: false,
        success: function (result) {
            $.each(result.data, function (i, item) {
                let option = "<option value='" + item.goodsRevertBillId + "'>";
                option += item.goodsRevertBillId;
                option += "</option>";
                $("#goodsRevertBillCode").append(option);
            });
            form.render('select');
        }
    });

    $.ajax({
        type: 'get',
        url: '/route/findAllRegions.do',
        dataType: 'json',
        async: false,
        success: function (result) {
            $.each(result.data, function (i, item) {
                let option = '<option value="' + item.city + '">';
                option += item.city;
                option += '</option>';
                $("#loadStation").append(option);
                $("#dealGoodsStation").append(option);
            });
            form.render('select');
        }
    });


    form.on('select(changeSend)', function (data) {
        // ajax
        $.ajax({
            type: 'get',
            url:  '/vehicle/findGoodsBillByCode.do?goodsRevertBillCode=' + data.value,
            success: function (data) {
                var result = data.data ;
                $("#receiveGoodsLinkman").val(result.receiveGoodsCustomer);
                $("#linkmanPhone").val(result.receiveGoodsCustomerTel);
                $("#receiveGoodsDetailAddr").val(result.receiveGoodsCustomerAddr);
            }
        });
    });

    laydate.render({
        elem: '#signTime',
        value: new Date()
    });

    // 货运单回执信息添加
    form.on('submit(addCargoReceipt)', function () {

        $("#receiveGoodsLinkman").removeAttr("disabled");
        $("#linkmanPhone").removeAttr("disabled");
        $("#receiveGoodsDetailAddr").removeAttr("disabled");
        $("#backBillState").removeAttr("disabled");

        $.ajax({
            type: "post",
            url: "/vehicle/addCargoreceipt.do",
            data: $("#cargoReceiptForm").serialize(),
            dataType: "json",
            async: false,
            success: function (result) {
                if (result.code == 0 ) {
                    layer.msg('货运回执单添加成功', {
                        time: 800,
                        icon: 1
                    });
                    $("#resetForm").click();
                } else {
                    layer.msg('货运回执单添加失败', {
                        time: 800,
                        icon: 2
                    });
                }
            }
        });
        return false;
    });

});