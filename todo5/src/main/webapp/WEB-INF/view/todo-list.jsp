
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
