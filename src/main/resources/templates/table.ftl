<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>城市列表</title>
        <script type="text/javascript" src="/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="/table.js"></script>


    </head>

    <body>

        <div style="text-align: center">
            <span>城市名称: </span>&nbsp;<input id="cityName" ></input>
            <button id="query" onclick="query()">查询</button>
        </div>

        <br/>

        <div style="text-align:center">
            <table id="cityTable" style="text-align:center;FONT-SIZE: 11pt; WIDTH: 600px; BORDER-COLLAPSE: collapse" borderColor=#3399ff cellSpacing=0 cellPadding=0 align=center border=1>
                <tr>
                    <th style="display: none">城市id</th>
                    <th>省份编号</th>
                    <th>城市名称</th>
                    <th>城市描述</th>
                    <th>操作 </th>
                </tr>
                <#if cities??>
                    <#list cities as each>
                        <tr>
                            <td id = "id" style="display: none">${each.id}</td>
                            <td id = "provinceId">${each.provinceId?c}</td>
                            <td id = "cityName">${each.cityName}</td>
                            <td id = "description">${each.description}</td>
                            <td>
                                <button onclick="drop(this)">删除</button>
                                <button onclick="toogle(this)" value="0">修改</button>
                            </td>
                        </tr>
                    </#list>
                    <tr>
                        <td>
                            <input id = "newProvinceId"/>
                        </td>
                        <td>
                            <input id="newCityName"/>
                        </td>
                        <td>
                            <input id="newDescription"/>
                        </td>
                        <td>
                            <button id="add" onclick="add()">新增城市</button>
                        </td>
                    </tr>
                </#if>
            </table>

            <br/>
        </div>
    </body>

</html>