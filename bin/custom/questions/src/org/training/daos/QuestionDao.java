package org.training.daos;

import org.training.model.QuestionModel;

import java.util.List;

public interface QuestionDao {
    List<QuestionModel> findQuestionsByProductCode(final String productCode);
}
