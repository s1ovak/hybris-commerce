<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <c:if test="${not empty questions}">
        <c:forEach var="question" items="${questions}">
            <div>
                <p>${question.questionCustomer.name}</p>
                <p>question: ${question.question}</p>
                <p>${question.answerCustomer.name}</p>
                <p>answer: ${question.answer}</p>
            </div>
        </c:forEach>
    </c:if>
</div>

