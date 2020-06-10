<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
<title>Todo Management</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
    <link type="text/css"
          rel="stylesheet"
          href="css/styles.css" />

</head>

<body>
<body>
<nav role="navigation" class="navbar navbar-default">
	<div class="">
		<a href="http://www.javaguides.net" class="navbar-brand">Java Guides</a>
	</div>
	<div class="navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="active"><a href="/">Home</a></li>
			<li><a href="/todo-list">Todos</a></li>
		</ul>
		<ul class="nav navbar-nav">
			<li><a href="/logout">Logout</a></li>
		</ul>
	</div>
</nav>

   
    
<br/><br/>
<div id="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading"><input type="button" onclick="window.location.href='showFormForAdd'; return false"
    class="add-button" value="Add Todo"></div>
    <div id="content">
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Email</th>
                <th scope="col">Action</th>
            </tr>

            <c:forEach var="tempCustomer" items="${customers}">
            <c:url var="updateLink" value="/customer/showFormForUpdate">
                <c:param name="customerId" value="${tempCustomer.id}" />
            </c:url>
            <c:url var="deleteLink" value="/customer/delete">
                <c:param name="customerId" value="${tempCustomer.id}" />
            </c:url>
            <tr>
                <td> ${tempCustomer.firstName} </td>
                <td> ${tempCustomer.lastName} </td>
                <td> ${tempCustomer.email} </td>
                <td>
                    <a href="${updateLink}">Update</a>
                    <a href="${deleteLink}">Delete</a>
                </td>

            </tr>

            </c:forEach>

        </table>

    </div>

</div>


</body>

</html>







