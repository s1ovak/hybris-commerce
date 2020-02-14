<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <c:forEach var="question" items="${questions}">
        <div>
            <p>
            <p>${question.questionCustomer.name}</p>
            <b>Question: </b><span>${question.question}</span>
            <p>
            <p>${question.answerCustomer.name}</p>
            <b>Answer: </b><span>${question.answer}</span>
        </div>
    </c:forEach>
</div>

