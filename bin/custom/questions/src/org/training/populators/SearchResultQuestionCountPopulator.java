package org.training.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class SearchResultQuestionCountPopulator implements Populator<SearchResultValueData, ProductData> {

    @Override
    public void populate(SearchResultValueData searchResultValueData, ProductData productData) throws ConversionException {
        Assert.notNull(searchResultValueData, "Parameter searchResultValueData cannot be null.");
        Assert.notNull(productData, "Parameter productData cannot be null.");
        productData.setQuestionCount((Integer) searchResultValueData.getValues().get("questionCount"));
    }
}
