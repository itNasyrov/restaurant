<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заказы</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <%--<script src="js/jquery.min.js" type="text/javascript"></script>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<script type="text/javascript">
    var service = '/order';
    var RestGet = function (id) {
        $.ajax({
            type: 'GET',
            url: service + "/get/" + id,
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(order(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };

    function strDate(d) {
        var str = "";
        if (d != null) str = new Date(d).toUTCString();
        return str;
    }
    function order(result) {
        var headTxt = "Номер заказа: " + result.id + "<br>" +

            "Время приема заказа: " + result.date + "<br>" +
            "Время выполнения заказа: " + ((result.date_ready == null)?"не выполнен":result.date_ready) + "<br>" +

            "Время приема заказа____: " + strDate(result.date) + "<br>" +
            "Время выполнения заказа: " + strDate(result.date_ready) + "<br>" +

            "Заказчик: " + result.customer + "<br>" +
            "Номер столика: " + result.tableNumber + "<br>" +
            "Статус заказа: " + result.status + "<br>" +
            "Дополнительная информация: " + result.comment + "<br>";
        var i;
        var itemTxt = "";
        for (i = 0; i < result.items.length; i++) {
            for (x in result.items[i]) {
                itemTxt += (result.items[i][x] + " ");
            }
            itemTxt += "<br>";
        }
        return (headTxt + itemTxt);
    };

    var RestAdd = function () {
        var JSONObject = {
            'customer': $('#customer').val(),
            'tableNumber': $('#tableNumber').val(),
            'comment': $('#comment').val(),
        };
        $.ajax({
            type: 'POST',
            url: service + "/add",
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result, textStatus) {
                $('#response').html(order(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };

    var RestPut = function (client_name, client_description) {
        var JSONObject = {
            'name': client_name,
            'description': client_description
        };
        $.ajax({
            type: 'PUT',
            url: service + "/add",
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };
    var RestPost = function () {
        var JSONObject = {
            'id': $('#putId').val(),
            'name': $('#putName').val(),
            'description': $('#putDescription').val()
        };
        $.ajax({
            type: 'PUT',
            url: service + "/update",
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };
    var RestGetAll = function () {
        $.ajax({
            type: 'GET',
            url: service + '/all',
            datatype: 'json',
            async: false,
            success: function (result) {
                $('#response').html(orderAll(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };

    function orderAll(result) {
        var j;
        var txt = "";
        for (j = 0; j < result.length; j++) {
            txt += order(result[j]) + "<hr>";
        }
        return txt;
    };

    var RestDelete = function (id) {
        $.ajax({
            type: 'DELETE',
            url: service + "/delete/" + id,
            datatype: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };

</script>

<div class="panel panel-default">
    <div class="panel-heading">
        Работа с заказами
    </div>

    <div class="panel-body">
        <table class="table">
            <tbody>
            <tr>
                <td>Все заказы</td>
                <td>
                    <button type="button" onclick="RestGetAll()">Показать</button>
                </td>
            </tr>
            <tr>
                <td>Заказ с номером:</td>
                <td><input id="getDocumentId" value=""></td>
                <td>
                    <button type="button" onclick="RestGet($('#getDocumentId').val())">Показать</button>
                </td>
            </tr>
            </tbody>
        </table>
        <form class="form-inline">
            <div class="form-group">
                <label for="customer">Заказчик</label>
                <input type="text" class="form-control" id="customer">
            </div>
            <div class="form-group">
                <label for="tableNumber">Столик №</label>
                <input type="number" class="form-control" id="tableNumber">
            </div>
            <div class="form-group">
                <label for="comment">Доп. информация</label>
                <input type="text"  class="form-control" id="comment" size="100">
            </div>
            <button type="button" class="btn btn-default" onclick="RestAdd()">Add</button>
        </form>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <strong>RESPONSE</strong>
        </div>
        <div class="panel-body" id="response"></div>
    </div>
</div>
</body>
</html>