<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
<title>Todo Management Application</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">



</head>

<body>

<nav role="navigation" class="navbar navbar-default">
	<div class="hello">
		<h1>Welcome to Todo </h1>

		<a href="/todo/showFormForAdd">Add Todo</a>
			<a href="/todo/listTodo">View Todos</a>

	</div>
</nav>

<div id="content">
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Todo Name</th>
                <th scope="col">Target Date</th>
                <th scope="col">Function</th>

            </tr>

            <c:forEach var="tempTodo" items="${todo}">
            <c:url var="updateLink" value="/todo/showFormForUpdate">
                <c:param name="todoId" value="${tempTodo.id}" />
            </c:url>
            <c:url var="deleteLink" value="/todo/delete">
                <c:param name="todoId" value="${tempTodo.id}" />
            </c:url>
            <tr>
                <td> ${tempTodo.todoName} </td>
                <td> ${tempTodo.todoDate} </td>
                <td>
                    <a href="${updateLink}">Update</a>
                    <a href="${deleteLink}">Delete</a>
                </td>

            </tr>

            </c:forEach>

        </table>

    </div>
        </body>
        </html>
