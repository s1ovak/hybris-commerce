package org.training.facades;

import de.hybris.platform.cmsfacades.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

public interface QuestionFacade {
    ProductData getProductDataWithQuestions(String productCode);
}
