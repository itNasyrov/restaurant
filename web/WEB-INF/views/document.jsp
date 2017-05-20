<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<script type="text/javascript">
    var service = '/document';

    var restGet = function(id) {
        $.ajax({
            type: 'GET',
            url: service + '/get/id/' + id,
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#id').val(result.id);
                $('#name').val(result.name);
                $('#description').val(result.description);
                $('#status').html("Successfully loaded");
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#status').html(JSON.stringify(jqXHR));
            }
        });
    };

    var restAdd = function(name, description) {
        var JSONObject = {
            "name": name,
            "description": description
        }
        $.ajax({
            type: 'PUT',
            url: service + '/add',
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#id').val(result.id);
                $('#status').html("Successfully added");
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#status').html(JSON.stringify(jqXHR));
            }
        });
    };

    var restUpdate = function(id, name, description) {
        var JSONObject = {
            "id": id,
            "name": name,
            "description": description
        }
        $.ajax({
            type: 'POST',
            url: service + '/update',
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#status').html("Successfully updated");
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#status').html(JSON.stringify(jqXHR));
            }
        });
    };

    var restDelete = function(id) {
        $.ajax({
            type: 'DELETE',
            url: service + '/delete/' + id,
            dataType: 'json',
            async: false,
            success: function (result) {
                clearForm();
                $('#status').html("Successfully deleted");
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#status').html(JSON.stringify(jqXHR));
            }
        });
    };

    var restGetAll = function () {
        $.ajax({
            type: 'GET',
            url: service + '/all',
            dataType: 'json',
            async: false,
            success: function (obj) {
                var res = '<table class="table table-hover"><thead><tr><th>id</th><th>name</th><th>description</th></tr></thead>';
                res += '<tbody>';
                for (var i = 0; i < obj.length; ++i) {
                    res += '<tr class="clickable-row" onclick="restGet(' + obj[i].id + ')"><td>' + obj[i].id + '</td><td>' + obj[i].name + '</td><td>' + obj[i].description + '</td></trclickable-row>';
                }

                res += '</tbody></table>';
                $('#list').html(res);
                $('#status').html("Successfully loaded the list");
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#status').html(JSON.stringify(jqXHR));
            }
        });
    };

    function clearForm() {
        $('#id').val("");
        $('#name').val("");
        $('#description').val("");
    }

    $(function() {
        restGetAll();
    });
</script>

<div class="panel panel-default">
    <div class="panel-heading">Documents</div>
    <div class="panel-body">
        <table class="table">
            <thead>
                <tr>
                    <th class="col-md-2 text-center">Documents</th>
                    <th class="col-md-1 text-center">Selected document</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="table-bordered">
                        <div id="list"></div>
                    </td>
                    <td class="table-bordered">
                        <div id="selected">
                            <form>
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <td class="col-md-1 text-right">id:</td>
                                            <td class="col-md-1"><input id="id" type="text" value="" disabled></td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="col-md-1 text-right">name:</td>
                                            <td class="col-md-1"><input id="name" type="text" value=""></td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-1 text-right">description:</td>
                                            <td class="col-md-1"><input id="description" type="text" value=""></td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-1 text-right">add:</td>
                                            <td class="col-md-1">
                                                <button type="button" onclick="restAdd($('#name').val(), $('#description').val())">Try</button>
                                                <button type="button" onclick="clearForm()">Clear the form</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-1 text-right">update:</td>
                                            <td class="col-md-1"><button type="button" onclick="restUpdate($('#id').val(), $('#name').val(), $('#description').val())">Try</button></td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-1 text-right">delete:</td>
                                            <td class="col-md-1"><button type="button" onclick="restDelete($('#id').val())">Try</button></td>
                                        </tr>
                                        <tr>
                                            <td class="col-md-1 text-right">reload all:</td>
                                            <td class="col-md-1"><button type="button" onclick="restGetAll()">Try</button></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>

<div class="panel panel-default">
    <div class="panel-heading">
        Status
    </div>
    <div class="panel-body" id="status"></div>
</div>
</body>
</html>
