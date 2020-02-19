package org.training.interceptors;

import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import de.hybris.platform.servicelayer.user.daos.UserGroupDao;
import org.springframework.beans.factory.annotation.Required;

import java.util.HashSet;
import java.util.Set;

public class HybridsCustomersPrepareInterceptor implements PrepareInterceptor<CustomerModel> {

    private static final String HYBRIDS = "hybrids";
    private UserGroupDao userGroupDao;

    @Required
    public void setUserGroupDao(final UserGroupDao userGroupDao) {
        this.userGroupDao = userGroupDao;
    }

    @Override
    public void onPrepare(CustomerModel customerModel, InterceptorContext interceptorContext) throws InterceptorException {
        final UserGroupModel hybrids = userGroupDao.findUserGroupByUid(HYBRIDS);
        final Set<PrincipalGroupModel> groups = new HashSet<>(customerModel.getGroups());
        if(customerModel.getIsInternal()) {
            groups.add(hybrids);
        } else {
            groups.remove(hybrids);
        }

        customerModel.setGroups(groups);
    }
}
