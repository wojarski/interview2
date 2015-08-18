package interview.web.controller;

import interview.core.exception.AccountException;
import interview.core.exception.TransferException;
import interview.core.exception.TransferException.Reason;
import interview.core.form.TransferForm;
import interview.core.service.AccountService;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;

@Controller
public class TransferController {

	@Autowired
	AccountService accountService;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		NumberFormat numberFormat = new DecimalFormat(".##");
		binder.registerCustomEditor(BigDecimal.class, 
				new CustomNumberEditor(BigDecimal.class, numberFormat, true));
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView newTransfer() throws AccountException {
	 	return new ModelAndView("pages/index.html");
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody TransferForm submitTransfer(@Valid @ModelAttribute TransferForm form) {
		try {
			accountService.transfer(form);
		} catch (TransferException e) {
			Map<String, String> errors = Maps.newHashMap();
			switch (e.getReason()) {
				case SRC_ACCOUNT_WRONG:
					errors.put("accountNoFrom", Reason.SRC_ACCOUNT_WRONG.toString());
					break;
				case DST_ACCOUNT_WRONG:
					errors.put("accountNoTo", Reason.DST_ACCOUNT_WRONG.toString());
					break;
				case BALANCE_INSUFFICIENT:
					errors.put("error", Reason.BALANCE_INSUFFICIENT.toString());
					break;
				default:
					break;
			}
			form.setErrors(errors);
			e.printStackTrace();
		}
		return form;
	}
	
}
