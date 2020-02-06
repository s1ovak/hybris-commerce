package org.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.daos.QuestionDao;
import org.training.model.QuestionModel;
import org.training.service.QuestionService;

import java.util.List;

@Service
public class DefaultQuestionService implements QuestionService {

    private final QuestionDao questionDao;

    @Autowired
    public DefaultQuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }


    @Override
    public List<QuestionModel> getQuestionsByProduct(final String productCode) {
        return questionDao.findQuestionsByProductCode(productCode);
    }
}
