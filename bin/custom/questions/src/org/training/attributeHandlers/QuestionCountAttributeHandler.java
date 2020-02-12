package org.training.attributeHandlers;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;
import org.springframework.stereotype.Component;

@Component
public class QuestionCountAttributeHandler extends AbstractDynamicAttributeHandler<Integer, ProductModel> {
    @Override
    public Integer get(ProductModel model) {
        return model.getQuestions().size();
    }
}
