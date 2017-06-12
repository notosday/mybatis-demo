/**
 * Created by kewuwei on 2017/6/7.
 */

//跳转到城市列表
function showCity() {
    window.location.href="/cityList";
}

//查询城市信息
function query() {
    var cityName = $("#cityName").val().replace(/\s/g,"");

    if(cityName == "") {
        alert("请填写城市名称!");
        return false;
    }

    $("#cityName").val("");

    window.location.href="/cityList/query?cityName="+cityName;
}

//新增城市
function add() {
    var newCityName = $("#newCityName").val().replace(/\s/g,"");
    var newProvinceId = $("#newProvinceId").val().replace(/\s/g,"");
    var newDescription = $("#newDescription").val().replace(/\s/g,"");

    if(newCityName=='' || newProvinceId == '' || newDescription == ''){
        alert("请填写有效城市信息!");
        return false;
    }

    $.ajax({
        url:"/city/add",
        type:"POST",
        dataType:"json",
        data:{
            cityName:newCityName,
            provinceId:newProvinceId,
            description:newDescription
        },
        beforeSend : function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("Authorization","basic crud s");
        },
        success:function (data) {
            alert("添加成功!");
            window.location.href="/cityList";
        },
        error:function (data) {
            alert($.parseJSON(data.responseText).message);
            $("#newCityName").val("");
            $("#newProvinceId").val("");
            $("#newDescription").val("");
            return false;
        }
    })
}

//删除城市
function drop(obj) {
    var id = $(obj).parent().parent().find("td").eq(0).text();
    $.ajax({
        url:"/city/drop",
        type:"POST",
        dataType:"json",
        data:{
            id:id
        },
        beforeSend : function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("Authorization","basic crud");
        },
        success:function (data) {
            alert("删除成功!");
            window.location.href="/cityList";
        },
        error:function (data) {
            alert($.parseJSON(data.responseText).message);
        }
    })
}

//修改-保存 切换
function toogle(obj) {
    var i = $(obj).val();

    if(i==0){
        edit(obj);
        $(obj).val("1")
    } else {
        update(obj);
        $(obj).val("0")
    }
}

//保存城市信息
function update(obj) {

    //获取字段对象
    var $id = $(obj).parent().parent().find("td").eq(0);
    var $provinceId = $(obj).parent().parent().find("td").eq(1);
    var $cityName = $(obj).parent().parent().find("td").eq(2);
    var $description = $(obj).parent().parent().find("td").eq(3);

    //获取原数据
    var id = $id.text();
    var provinceId = $provinceId.children("input").eq(0).val();
    var cityName = $cityName.children("input").eq(0).val();
    var description = $description.children("input").eq(0).val();

    // alert(" new id:"+id+" provinceId: "+provinceId+" cityName: "+cityName +  " description: "+description);

    $.ajax({
        url:"/city/update",
        type:"POST",
        dataType:"json",
        data:{
            id:id,
            provinceId:provinceId,
            cityName:cityName,
            description:description
        },
        beforeSend : function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("Authorization","basic crud");
        },
        success:function (data) {
            alert("保存成功!");
        },
        error:function (data) {
            alert($.parseJSON(data.responseText).message);
            return false;
        }
    });

    $provinceId.text(provinceId);
    $provinceId.remove("input");
    $cityName.text(cityName);
    $cityName.remove("input");
    $description.text(description);
    $description.remove("input");

    //改变按钮样式为 修改
    $(obj).text("修改");
}


//修改城市信息
function edit(obj) {

    //获取字段对象
    var $id = $(obj).parent().parent().find("td").eq(0);
    var $provinceId = $(obj).parent().parent().find("td").eq(1);
    var $cityName = $(obj).parent().parent().find("td").eq(2);
    var $description = $(obj).parent().parent().find("td").eq(3);

    //获取原数据
    var id = $id.text();
    var provinceId = $provinceId.text();
    var cityName = $cityName.text();
    var description = $description.text();

    // alert("id:"+$id.text()+" provinceId: "+$provinceId.text() + " cityName: "+$cityName.text()+ " description: "+$description.text());

    //清空表格内原数据
    $provinceId.text("");
    $cityName.text("");
    $description.text("");

    //改变按钮样式为 保存
    $(obj).text("保存");

    $("<input type='text' value='"+provinceId+"'/>").appendTo($provinceId);
    $("<input type='text' value='"+cityName+"'/>").appendTo($cityName);
    $("<input type='text' value='"+description+"'/>").appendTo($description);
}