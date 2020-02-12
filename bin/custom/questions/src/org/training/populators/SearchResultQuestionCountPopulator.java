package org.training.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.training.service.QuestionService;

@Component
public class SearchResultQuestionCountPopulator implements Populator<SearchResultValueData, ProductData> {

    private QuestionService questionService;

    @Autowired
    public SearchResultQuestionCountPopulator(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void populate(SearchResultValueData searchResultValueData, ProductData productData) throws ConversionException {
        Assert.notNull(searchResultValueData, "Parameter searchResultValueData cannot be null.");
        Assert.notNull(productData, "Parameter productData cannot be null.");
        Long productCode = (Long) searchResultValueData.getValues().get("pk");
        productData.setQuestionCount(questionService.getQuestionsByProduct(productCode.toString()).size());
    }
}
