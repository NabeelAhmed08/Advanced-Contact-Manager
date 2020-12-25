
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"  type= "text/css" href="webjars/bootstrap/css/bootstrap.min.css"/>
<title>Home</title>
</head>
<body>
<div th:replace="fragments ::header" ></div>
   <div class= container >
   
    
   <div class="container-fluid">
    <div class="row">
        <div class="col-3 px-1 bg-dark position-fixed" id="sticky-sidebar">
            ...
        </div>
        <div class="col offset-3" id="main">
            <h1>Main Area</h1>
            ...
        </div>
    </div>
</div>





  <hr>
   <a type ="button" class ="btn btn-primary" href = "allContacts">Show all Contacts </a><br><hr>
  <a type ="button" class ="btn btn-success" href = "addContactPage">Add Contact </a><br><hr>
   <a type ="button" class ="btn btn-success" href = "updateContactPage">Update Contact </a><br><hr>
  </div>
  <script src="webjars/bootstrap/js/bootstrap.min.js" ></script>
   <script src="webjars/jquery/jquery.min.js" ></script>
</body>
</html>