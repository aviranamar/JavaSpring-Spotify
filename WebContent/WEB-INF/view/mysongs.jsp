<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {
	margin: 0;
}

ul.topnav {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

ul.topnav li {
	float: left;
}

ul.topnav li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.bsd {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

ul
.topnav
 
li
 
a
:hover
:not
 
(
.active
 
)
{
background-color
:
 
#111
;


}
ul.topnav li a.active {
	background-color: #4CAF50;
}

ul.topnav li.right {
	float: right;
}

@media screen and (max-width: 600px) {
	ul.topnav li.right, ul.topnav li {
		float: none;
	}
}
</style>
</head>
<body>

	<ul class="topnav">
		<li class=bsd>Bs"d</li>
		<li><a href="signup" onclick="return false;">Sign up</a></li>
		<li><a href="changeDetail">Change Detail</a></li>
		<li><a href="songslist">Songs List</a></li>
		<li><a class="active" href="mysongs">My Songs</a></li>
		<li><a href="exit">Exit</a></li>
	</ul>

	User: ${user.userName} ${user.lastName}
	<div class="container">
		<form:form name="thisfunc" action="mysongs" method="get">
		<c:set var="count" value="0" scope="page"/>
			<c:forEach items="${songs}" var="item">
				<c:if test="${item.songActive==1}">
				<c:if test="${index==count}">
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
							<label><iframe width="854"
									src=${item.songEmbed
									} height="480"></iframe></label>
						</div>
					</div>
					<input type="hidden" name="index" value="${index}">
				</c:if>
				</c:if>
			<c:set var="count" value="${count+1 }" scope="page"/>	
			</c:forEach>
			
			<div class="row">
				<input type="submit" value="Previous" onclick="thisfunc.action='mysongspre';return true;">
				<input type="submit" value="Next" onclick="'mysongs';return true;">
			</div>

			
		</form:form>
	</div>

</body>
</html>
