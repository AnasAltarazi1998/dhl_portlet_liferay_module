package portlet1.controller;

import portlet1.dto.CreateShipmentRequest;
import portlet1.dto.CreateShipmentResponse;
import portlet1.dto.User;
import portlet1.service.soap_request_service;

import com.liferay.portletmvc4spring.bind.annotation.ActionMapping;
import com.liferay.portletmvc4spring.bind.annotation.RenderMapping;

import java.util.Locale;
import java.io.InputStream;

import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.MessageSource;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import org.springframework.ui.ModelMap;

import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Controller
@RequestMapping("VIEW")
public class ShipmentController {

	private static final Logger logger = LoggerFactory.getLogger(ShipmentController.class);

	@Autowired
	private LocalValidatorFactoryBean localValidatorFactoryBean;

	@Autowired
	private MessageSource messageSource;

	@ActionMapping
	public void submitApplicant(@ModelAttribute("CreateShipmentRequest") CreateShipmentRequest createShipmentRequest,
			BindingResult bindingResult, ModelMap modelMap, Locale locale, ActionResponse actionResponse,
			SessionStatus sessionStatus) 
			 {

			localValidatorFactoryBean.validate(createShipmentRequest, bindingResult);
			if (!bindingResult.hasErrors()) {
				MutableRenderParameters mutableRenderParameters = actionResponse.getRenderParameters();
				try 
				{
					if(createShipmentRequest.getAccountNumber().length() != 14)
					{
						mutableRenderParameters.setValue("javax.portlet.action", "accountNumberError");
					}else
					{
						soap_request_service soap_request_service_instance = soap_request_service.getInstance();
						InputStream xml_response = soap_request_service_instance.send_soap_request(createShipmentRequest);	
						CreateShipmentResponse createShipmentResponse = soap_request_service_instance.convertResponseToObject(xml_response);
						logger.debug(createShipmentResponse.toString());

						if(!createShipmentResponse.getShipment_number().equals("shipment_number"))
						{
							modelMap.put("shipmentNumber", createShipmentResponse.getShipment_number());
							modelMap.put("statusMessage", createShipmentResponse.getStatusMessage());
							modelMap.put("statusText", createShipmentResponse.getStatusText());
							modelMap.put("labelUrl", createShipmentResponse.getLabelUrl());
							mutableRenderParameters.setValue("javax.portlet.action", "success");
						}
						else
						{

							modelMap.put("errorText", createShipmentResponse.getStatusText());
							modelMap.put("errorMessage", createShipmentResponse.getStatusMessage());
							mutableRenderParameters.setValue("javax.portlet.action", "error");
						}
						sessionStatus.setComplete();
				}
					
				} catch (NullPointerException e) {
					mutableRenderParameters.setValue("javax.portlet.action", "accountNumberError");
				}
			}
				
	}
	

	@RenderMapping
	public String prepareView() {
		return "createShipment";
	}

	@RenderMapping(params = "javax.portlet.action=success")
	public String showShipment(ModelMap modelMap) {
		return "shipment";
	}
	@RenderMapping(params = "javax.portlet.action=error")
	public String showError(ModelMap modelMap) {
		return "error";
	}
	@RenderMapping(params = "javax.portlet.action=accountNumberError")
	public String showAccountNumberError(ModelMap modelMap) {
		modelMap.put("accountNumberError", "account number should be 14 char");
		return "createShipment";
	}
	@ModelAttribute("user")
	private User _getUserModelAttribute() {
		return new User();
	}
	@ModelAttribute("CreateShipmentRequest")
	private CreateShipmentRequest _getCreateShipmentRequestModelAttribute() {
		return new CreateShipmentRequest();
	}
}