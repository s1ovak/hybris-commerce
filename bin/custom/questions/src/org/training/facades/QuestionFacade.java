package org.training.facades;


import de.hybris.platform.commercefacades.product.data.ProductData;

public interface QuestionFacade {
    ProductData getProductDataWithQuestions(String productCode);
}
