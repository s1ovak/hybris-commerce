package org.training.attributeHandlers;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;
import org.springframework.stereotype.Component;

@Component
public class DynamicHybrisCustomerAttributeBean extends AbstractDynamicAttributeHandler<Boolean, CustomerModel> {
    @Override
    public Boolean get(CustomerModel model) {
        String email = model.getUid();
        return email != null && (email.endsWith("hybris.de") || email.endsWith("hybris.com") || email.endsWith("anonymous"));
    }
}
