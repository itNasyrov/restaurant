<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Events</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <%--<script src="js/jquery.min.js" type="text/javascript"></script>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<script type="text/javascript">
    var service = '/event';
    var RestGet = function (id) {
        $.ajax({
            type: 'GET',
            url: service + "/get/id/" + id,
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
    var RestPut = function (client_name, client_description, price) {
        var JSONObject = {
            'name': client_name,
            'description': client_description,
            'price': price
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
            'description': $('#putDescription').val(),
            'price': $('#putPrice').val()
        };
        $.ajax({
            type: 'POST',
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
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
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
        REST API For Events
    </div>

    <div class="panel-body">
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Get all events</td>
                <td><code><strong>GET</strong>/event/all</code></td>
                <td>
                    <button type="button" onclick="RestGetAll()">Try</button>
                </td>
            </tr>
            <tr>
                <td>Get event by id</td>
                <td>
                    id: <input id="getEventId" value=""/>
                    <button type="button" onclick="RestGet($('#getEventId').val())">Try</button>
                </td>
            </tr>
            <tr>
                <td>Add event</td>
                <td><code><strong>PUT</strong>/event/add</code></td>
                <td>
                    <form class="form-inline">
                        name: <input type="text" id="postName" value="eventName"/>
                        description: <input type="text" id="postDescription" value="eventDescription"/>
                        price: <input type="text" id="postPrice" value="eventPrice"/>
                        <button type="button" onclick="RestPut($('#postName').val(), $('#postDescription').val(), $('#postPrice').val())">Try
                        </button>
                    </form>
                </td>
            </tr>
            <tr>
                <td>Update event</td>
                <td><code>POST</code>/event/update</td>
                <td>
                    <form class="form-inline">
                        id: <input type="text" id="putId" value="eventId"/>
                        <br>
                        name: <input type="text" id="putName" value="eventName"/>
                        <br>
                        description: <input type="text" id="putDescription" value="eventDescription"/>
                        <br>
                        price: <input type="text" id="putPrice" value="eventPrice"/>
                        <button type="button" onclick="RestPost()">Try</button>
                    </form>
                </td>
            </tr>
            <tr>
                <td>Delete event by id</td>
                <td><code><strong>DELETE</strong>/event/delete/{id}</code></td>
                <td>
                    Id: <input id="EventIdForDelete" value=""/>
                    <button type="button" onclick="RestDelete($('#EventIdForDelete').val())">Try</button>
                </td>
            </tr>
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
