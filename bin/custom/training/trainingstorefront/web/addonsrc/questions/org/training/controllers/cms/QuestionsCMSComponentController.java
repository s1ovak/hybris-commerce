package org.training.controllers.cms;

import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import de.hybris.platform.commercefacades.product.data.ProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.training.facades.QuestionFacade;
import org.training.model.QuestionsCMSComponentModel;

import javax.servlet.http.HttpServletRequest;

@Controller(QuestionsCMSComponentModel._TYPECODE + "Controller")
@RequestMapping(value = "/view/" + QuestionsCMSComponentModel._TYPECODE + "Controller")
public class QuestionsCMSComponentController extends AbstractCMSAddOnComponentController<QuestionsCMSComponentModel> {

    private QuestionFacade questionFacade;

    @Autowired
    public QuestionsCMSComponentController(QuestionFacade questionFacade) {
        this.questionFacade = questionFacade;
    }

    @Override
    protected void fillModel(HttpServletRequest request, Model model, QuestionsCMSComponentModel component) {
        ProductData productData = questionFacade
                .getProductDataWithQuestions(getRequestContextData(request).getProduct().getPk().toString());
        model.addAttribute("questions", productData.getQuestions());
        model.addAttribute("fontSize", component.getFontSize());
        model.addAttribute("numberOfQuestions", component.getNumberOfQuestionsToShow());
    }
}
