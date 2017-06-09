<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <%--<script src="js/jquery.min.js" type="text/javascript"></script>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<script type="text/javascript">
    var service = '/user';
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
    var RestPut = function (client_name, client_login, client_password) {
        var JSONObject = {
            'name': client_name,
            'login': client_login,
            'password': client_password
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
            'login': $('#putLogin').val(),
            'password': $('#putPassword').val(),
            'roleID': $('#putRoleID').val()
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
        REST API For Users
    </div>

    <div class="panel-body">
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Login</th>
                <th>Password</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Get all users</td>
                <td><code><strong>GET</strong>/user/all</code></td>
                <td>
                    <button type="button" onclick="RestGetAll()">Try</button>
                </td>
            </tr>
            <tr>
                <td>Get user by id</td>
                <td>
                    id: <input id="getUserId" value=""/>
                    <button type="button" onclick="RestGet($('#getUserId').val())">Try</button>
                </td>
            </tr>
            <tr>
                <td>Add user</td>
                <td><code><strong>PUT</strong>/user/add</code></td>
                <td>
                    <form class="form-inline">
                        name: <input type="text" id="postName" value="userName"/>
                        login:  <input type="text" id="postLogin" value="userLogin"/>
                        password: <input type="text" id="postPassword" value="userPassword"/>
                        <button type="button" onclick="RestPut($('#postName').val(), $('#postLogin').val(), $('#postPassword').val())">Try
                        </button>
                    </form>
                </td>
            </tr>
            <tr>
                <td>Update user</td>
                <td><code>POST</code>/user/update</td>
                <td>
                    <form class="form-inline">
                        id: <input type="text" id="putId" value="userId"/>
                        <br>
                        name: <input type="text" id="putName" value="userName"/>
                        <br>
                        login: <input type="text" id="putLogin" value="userLogin"/>
                        <br>
                        password: <input type="text" id="putPassword" value="userPassword"/>
                        <br>
                        roleID: <input type="text" id="putRoleID" value="userRoleId"/>
                        <button type="button" onclick="RestPost()">Try</button>
                    </form>
                </td>
            </tr>
            <tr>
                <td>Delete user by id</td>
                <td><code><strong>DELETE</strong>/user/delete/{id}</code></td>
                <td>
                    Id: <input id="UserIdForDelete" value=""/>
                    <button type="button" onclick="RestDelete($('#UserIdForDelete').val())">Try</button>
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
