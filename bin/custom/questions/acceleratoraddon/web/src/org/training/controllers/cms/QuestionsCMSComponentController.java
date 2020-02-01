package org.training.controllers.cms;

import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import de.hybris.platform.cms2.model.contents.components.AbstractCMSComponentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

@Controller
public class QuestionsCMSComponentController extends AbstractCMSAddOnComponentController {

    @Override
    protected void fillModel(HttpServletRequest request, Model model, AbstractCMSComponentModel component) {

    }
}
