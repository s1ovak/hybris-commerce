package org.training.service;

import org.training.model.QuestionModel;

import java.util.List;

public interface QuestionService {
    List<QuestionModel> getQuestionsByProduct(final String productCode);
}
