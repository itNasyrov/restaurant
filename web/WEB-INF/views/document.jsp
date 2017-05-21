
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
   <script type="text/javascript">
       var service="/firm";
       var RestGetAll=function () {
           $.ajax({
               type:'Get',
               url:service+'/all',
               dataType:'json',
               asinc:false,
               success:function (resault) {
                   $('#responce').html(JSON.stringify(resault))
               },
               error:function (jqXHR,textStatus,errorThrown) {
                   $('#responce').html(JSON.stringify(jqXHR))
               }

           });
       };

       var RestGetId=function (id) {
           $.ajax({
               type:'Get',
               url:service+'/get/id/'+id,
               dataType:'json',
               asinc:false,
               success:function (resault) {
                   $('#responce').html(JSON.stringify(resault))
                   $('#responce').append("<br>"+resault.id+" "+resault.name)
               },
               error:function (jqXHR,textStatus,errorThrown) {
                   $('#responce').html(JSON.stringify(jqXHR))
               }

           });
       };
       var RestGetName=function (name) {
           $.ajax({
               type:'Get',
               url:service+'/get/name/'+name,
               dataType:'json',
               asinc:false,
               success:function (resault) {
                   $('#responce').html(JSON.stringify(resault))
               },
               error:function (jqXHR,textStatus,errorThrown) {
                   $('#responce').html(JSON.stringify(jqXHR))
               }

           });
       };
       var RestDeleteId=function (id) {
           $.ajax({
               type:'Delete',
               url:service+'/delete/'+id,
               dataType:'json',
               asinc:false,
               success:function (resault) {
                   $('#responce').html(JSON.stringify(resault))
               },
               error:function (jqXHR,textStatus,errorThrown) {
                   $('#responce').html(JSON.stringify(jqXHR))
               }

           });
       };
       var RestPut=function (firm_name, firm_description) {
           var JSONObject = {
               'name':firm_name,
               'description':firm_description
           }
           $.ajax({
               type:'PUT',
               url:service+"/add",
               contentType:'application/json;charset=utf-8',
               data:JSON.stringify(JSONObject),
               dataType:'json',
               asinc:false,
               success:function (resault) {
                   $('#responce').html(JSON.stringify(resault))
               },
               error:function (jqXHR,textStatus,errorThrown) {
                   $('#responce').html(JSON.stringify(jqXHR))
               }
           });
           
       };
       var RestPost=function (firm_id, firm_name, firm_description) {
           var JSONObject = {
               'id':firm_id,
               'name':firm_name,
               'description':firm_description
           }
           $.ajax({
               type:'POST',
               url:service+"/update",
               contentType:'application/json;charset=utf-8',
               data:JSON.stringify(JSONObject),
               dataType:'json',
               asinc:false,
               success:function (resault) {
                   $('#responce').html(JSON.stringify(resault))
               },
               error:function (jqXHR,textStatus,errorThrown) {
                   $('#responce').html(JSON.stringify(jqXHR))
               }
           });

       };

   </script>
<div class="panel panel-default">
    <div class="panel panel-heading">
        REST API FOR FIRM
        <div class="panel panel-body">
            <table class="table">
                <thead>
                  <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th></th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                <tr>
                    <td>List of firms </td>
                    <td><code><strong>GET</strong>/firm/all</code></td>
                    <td>
                        <button type="button" onclick="RestGetAll()">Try</button>
                    </td>
                  <tr>
                    <td>Get firm </td>
                    <td><code><strong>GET</strong>/firm/id/{id}</code></td>
                    <td>
                        by id:<input id="getFirmById" value=""/>
                        <button type="button" onclick="RestGetId($('#getFirmById').val())">Try</button>
                    </td>
                  </tr>
                  <tr>
                    <td>Get firm </td>
                      <td><code><strong>GET</strong>/firm/name/{name}</code></td>
                    <td>
                        by name:<input id="getFirmByName" value=""/>
                        <button type="button" onclick="RestGetName($('#getFirmByName').val())">Try</button>
                    </td>
                  </tr>
                  <tr>
                    <td>Add firm</td>
                    <td><code><strong>PUT</strong>/firm/add</code></td>
                    <td>
                        <form class="form-inline">
                            name:<input type="text" id="putName" value="firmName"/><br>
                            description:<input type="text" id="putDescription" value="firmDescription"/>
                            <button type="button" onclick="RestPut($('#putName').val(),$('#putDescription').val())">Try</button>
                        </form>
                    </td>
                  </tr>
                  <tr>
                      <td>Delete firm </td>
                      <td><code><strong>DELETE</strong>/firm/delete/{id}</code></td>
                      <td>
                          by id:<input id="deleteFirmById" value=""/>
                          <button type="button" onclick="RestDeleteId($('#deleteFirmById').val())">Try</button>
                      </td>
                  </tr>
                <tr>
                    <td>Update firm </td>
                    <td><code><strong>POST</strong>/firm/update</code></td>
                    <td>
                        <form class="form-inline">
                            id:<input id="postId" value=""/><br>
                            name:<input type="text" id="postName" value="firmName"/><br>
                            description:<input type="text" id="postDescription" value="firmDescription"/>
                            <button type="button" onclick="RestPost($('#postId').val(),$('#postName').val(),$('#postDescription').val())">Try</button>
                        </form>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="panel panel-default">
            <div class="panel panel-heading">
                <strong>RESPONSE</strong>
            </div>
            <div class="panel-body" id="responce"></div>
            <div class="panel-body" id="responceJS"></div>
        </div>
    </div >
</div>
</body>
</html>
