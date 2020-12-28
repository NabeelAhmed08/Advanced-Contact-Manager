<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"  type= "text/css" href="webjars/bootstrap/css/bootstrap.min.css"/>
<title>Add Contact</title>
</head>
<body>
<div th:replace="fragments ::header" ></div>
 <div class= container > 
  <h1> Add/Update Contact </h1>
  <hr>

  <form  action ="#" th:action="@{saveContact}"
  					 th:object="${addedcontact}"  method = "POST" >
  
  <fieldset>
  <input type="hidden" th:field="*{id}" />  
  <label for="name">Name:</label><br>
  <input class="form-control mb-4 col-4" type="text" id="name" name="name" th:field="*{name}" placeholder="Name" required>
  <label for="pno">Phone Number:</label><br>
  <input class="form-control mb-4 col-4" type="text" id="pno"  name="pno"  th:field="*{pno}" placeholder="Phone Number" required>
  <label for="email">Email:</label><br>
  <input class="form-control mb-4 col-4" type="text" id="email" name="email" th:field="*{email}" placeholder="E-mail" required>
  <label for="location">Location:</label><br>
  <input class="form-control mb-4 col-4" type="text" id="location" name="location" th:field="*{location}" placeholder="location" required>
  <input type="submit" class="btn btn-info col-2" value="Submit">
  </fieldset>
  </form>
  <hr>
  <a th:href="@{allContacts}"> Back to All Contact </a>

  <script src="webjars/bootstrap/js/bootstrap.min.js" ></script>
   <script src="webjars/jquery/jquery.min.js" ></script>
</div>   
</body>
</html>