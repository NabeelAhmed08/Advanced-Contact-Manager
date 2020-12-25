
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"  type= "text/css" href="webjars/bootstrap/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Home</title>
</head>
<body>
<div th:replace="fragments ::header" ></div>
   
  

<div class="container-fluid">
   
           <div class="side-bar w3-light-grey w3-bar-block" style="width:10%">
  <h3 class="w3-bar-item">Menu</h3>

  <a type ="button" class ="btn btn-success btn-sm mb-3 w3-bar-item" href = "allContacts">Show all Contacts </a>
  <a type ="button" class ="btn btn-success  btn-sm mb-3 w3-bar-item" href = "addContactPage">Add Contact </a>
   <a type ="button" class ="btn btn-success btn-sm w3-bar-item " href = "updateContactPage">Update Contact </a>
</div>
</div>
      
        




  <script src="webjars/bootstrap/js/bootstrap.min.js" ></script>
   <script src="webjars/jquery/jquery.min.js" ></script>
</body>
</html>