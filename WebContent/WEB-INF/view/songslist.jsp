<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {margin: 0;}

ul.topnav {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

ul.topnav li {float: left;}

ul.topnav li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

ul.topnav li a:hover:not(.active) {background-color: #111;}

ul.topnav li a.active {background-color: #4CAF50;}

ul.topnav li.right {float: right;}

@media screen and (max-width: 600px){
    ul.topnav li.right, 
    ul.topnav li {float: none;}
}

* {
    box-sizing: border-box;
}

input[type=text], select, textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    resize: vertical;
}

label {
    padding: 12px 12px 12px 0;
    display: inline-block;
}

input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    float: left;
}

input[type=submit]:hover {
    background-color: #45a049;
}

.container {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}

.col-25 {
    float: left;
    width: 25%;
    margin-top: 6px;
}

.col-75 {
    float: left;
    width: 75%;
    margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}

.bsd {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
    .col-25, .col-75, input[type=submit] {
        width: 100%;
        margin-top: 0;
    }
}

</style>
</head>
<body>

<ul class="topnav">
  <li class=bsd>Bs"d</li>
  <li><a href="signup" onclick="return false;">Sign up</a></li>
  <li><a href="changeDetail">Change Detail</a></li>
  <li><a class="active" href="songslist">Songs List</a></li>
  <li><a href="mysongs">My Songs</a></li>
  <li><a href="exit">Exit</a></li>
</ul>



User: ${user.userName} ${user.lastName} <br>
<div class="container">
  <form:form action="songslist" method = "get">
  <c:set var="count" value="0" scope="page"/>
  <c:forEach items="${songs}" var="item">
  <c:if test="${item.songActive==1}">
  <input type ="checkbox" name="video" value ="${count}"checked>Like/Unlike
   </c:if>
     <c:if test="${item.songActive==0}">
  <input type ="checkbox" name="video" value ="${count}">Like/Unlike
   </c:if>
    <div class="row">
      <div class="col-25">
        <label>${item.songName}</label>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label>${item.songArtist}</label>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label>${item.songTime}</label>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label><iframe width="854" src="${item.songEmbed}" height="480"></iframe></label>
      </div>
    </div>
        <div class="row">
      <input type="submit" value="Update" formaction="songslist">
    </div>   
  <c:set var="count" value="${count + 1}" scope="page"/>               
</c:forEach> 
   </form:form>
</div>
    
</body>
</html>
