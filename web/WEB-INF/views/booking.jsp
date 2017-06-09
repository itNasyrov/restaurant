
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking events</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <%--<script src="js/jquery.min.js" type="text/javascript"></script>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<script type="text/javascript">
    var service = '/booking';
    var RestGetAll = function () {
        $.ajax({
            type: 'GET',
            url: service + '/all',
            dataType:'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    }
    var RestPut = function (date, idEvent, idMenu, available, price, phone, client, quantity) {
        var JSONObject = {
            'date': date,
            'idEvent': idEvent,
            'idMenu':idMenu,
            'available': available,
            'price': price,
            'phone':phone,
            'client':client,
            'quantity': quantity
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
</script>

<div class="panel panel-default">
    <div class="panel-heading">
        REST API For Booking
    </div>

    <div class="panel-body">
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Get booking list</td>
                <td><code><strong>GET</strong>/booking/all</code></td>
                <td>
                    <button type="button" onclick="RestGetAll()">Get list</button>
                </td>
            </tr>
            <%--<tr>--%>
                <%--<td>Get document by id</td>--%>
                <%--<td>--%>
                    <%--id: <input id="getDocumentId" value=""/>--%>
                    <%--<button type="button" onclick="RestGet($('#getDocumentId').val())">Try</button>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <tr>
                <td>Add booking</td>
                <td><code><strong>PUT</strong>/booking/add</code></td>
                <td>
                    <form class="form-inline">
                        dateBegin: <input type="date" id="putDateBegin" value=""/>
                        dateEnd: <input type="date" id="putDateEnd" value=""/>
                        idEvent: <input type="text" id="putIdIvent" value=""/>
                        idMenu: <input type="text" id="putIdMenu" value=""/>
                        available: <input type="text" id="putAvailable", value=""/>
                        price: <input type="text" id="putPrice" value=""/>
                        phone:<input type="text" id="putPhone" value=""/>
                        client: <input type="text" id="putClient" value=""/>
                        quantity: <input type="text" id="putQuantity" value=""/>
                        <button type="button" onclick="RestPut(
                            $('#putDateBegin').val(),
                            $('#putDateEnd').val(),
                            $('#putIdIvent').val(),
                            $('#putIdMenu').val(),
                            $('#putAvailable').val(),
                            $('#putPrice').val(),
                            $('#putPhone').val(),
                            $('#putClient').val(),
                            $('#putQuantity').val())">Add
                        </button>
                    </form>
                </td>
            </tr>
            <%--<tr>--%>
                <%--<td>Update document</td>--%>
                <%--<td><code>POST</code>/document/update</td>--%>
                <%--<td>--%>
                    <%--<form class="form-inline">--%>
                        <%--id: <input type="text" id="putId" value="documentId"/>--%>
                        <%--<br>--%>
                        <%--name: <input type="text" id="putName" value="documentName"/>--%>
                        <%--<br>--%>
                        <%--description: <input type="text" id="putDescription" value="documentDescription"/>--%>
                        <%--<button type="button" onclick="RestPost()">Try</button>--%>
                    <%--</form>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>Delete document by id</td>--%>
                <%--<td><code><strong>DELETE</strong>/document/delete/{id}</code></td>--%>
                <%--<td>--%>
                    <%--Id: <input id="DocumentIdForDelete" value=""/>--%>
                    <%--<button type="button" onclick="RestDelete($('#DocumentIdForDelete').val())">Try</button>--%>
                <%--</td>--%>
            <%--</tr>--%>
            </tbody>
        </table>
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
