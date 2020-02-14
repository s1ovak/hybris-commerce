package org.training.facades.impl;

import de.hybris.platform.cmsfacades.data.ProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.training.facades.QuestionFacade;
import org.training.model.QuestionModel;
import org.training.service.QuestionService;
import questions.data.QuestionData;

import java.util.stream.Collectors;

@Component
public class DefaultQuestionFacade implements QuestionFacade {

    private QuestionService questionService;

    @Autowired
    public DefaultQuestionFacade(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public ProductData getProductDataWithQuestions(String productCode) {
        ProductData productData = new ProductData();
        productData.setQuestions(
                questionService.getQuestionsByProduct(productCode).stream()
                        .map(this::getQuestionData)
                        .collect(Collectors.toList()));
        return productData;
    }

    private QuestionData getQuestionData(QuestionModel questionModel) {
        QuestionData questionData = new QuestionData();
        questionData.setId(questionModel.getCode());
        questionData.setQuestion(questionModel.getQuestion());
        questionData.setAnswer(questionModel.getAnswer());
        questionData.setQuestionCustomer(questionModel.getQuestionCustomer());
        questionData.setAnswerCustomer(questionModel.getAnswerCustomer());
        return questionData;
    }
}
