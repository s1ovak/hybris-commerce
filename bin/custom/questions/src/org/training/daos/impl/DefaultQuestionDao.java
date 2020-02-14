package org.training.daos.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.training.daos.QuestionDao;
import org.training.model.QuestionModel;

import java.util.List;

@Component
public class DefaultQuestionDao implements QuestionDao {

    private final FlexibleSearchService flexibleSearchService;

    @Autowired
    public DefaultQuestionDao(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }


    @Override
    public List<QuestionModel> findQuestionsByProductCode(final String productCode) {
        final String searchQuery =
                "SELECT {p:" + QuestionModel.PK + "}"
                        + "FROM {" + QuestionModel._TYPECODE + " AS p} "
                        + "WHERE " + "{p:" + QuestionModel.PRODUCT + "}=?code ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(searchQuery);
        query.addQueryParameter("code", productCode);
        return flexibleSearchService.<QuestionModel>search(query).getResult();
    }
}
