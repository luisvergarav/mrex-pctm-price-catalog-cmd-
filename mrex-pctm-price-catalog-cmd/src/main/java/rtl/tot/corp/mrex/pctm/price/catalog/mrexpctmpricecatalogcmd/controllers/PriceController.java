package rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.application.adapters.CreatePriceCommandBus;
import rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.application.adapters.CreatePriceCommandImpl;
import rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.domain.model.EventProperties;
import rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.infraestrucure.adapters.http.rest.constants.RestConstants;
import rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.infraestrucure.adapters.http.rest.domain.APIResponse;
import rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.infraestrucure.adapters.http.rest.domain.Price;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/")
@Api(value = "ORION", description = "ORION Price Management API")
@Slf4j
@EnableSwagger2
public class PriceController {

	@Autowired
	private HttpServletRequest context;
	@Autowired
	private EventProperties eventProperties;
	@Autowired
	private CreatePriceCommandBus cmdBus;

	@RequestMapping(path = "/mrex/pctm/v1.0/price-catalog", method = POST)
	@ApiOperation(value = "Add Price", response = APIResponse.class)
	public ResponseEntity<APIResponse> createProduct(@RequestBody Price request) {

		log.info(context.getHeader("Country") + context.getHeader("Commerce") + context.getHeader("Channel"));

		eventProperties.setChannel(context.getHeader("Channel"));
		eventProperties.setCommerce(context.getHeader("Commerce"));
		eventProperties.setCountry(context.getHeader("Country"));
		eventProperties.setMimeType(context.getHeader("Content-Type"));
		eventProperties.setVersion("1.0");

		// E2EContext e2e = new E2EContext();
		// try {
		// e2e.setE2EContext(headers);
		// } catch (E2EHelperNotFoundException e) {
		// log.error("Error E2EContext setting headers");
		//
		// }
		// e2e.setServiceRef("Appointment");

		log.info("Create Price request.", request);
		try {

			CreatePriceCommandImpl cmd = new CreatePriceCommandImpl(request);

			if (cmdBus.execute(cmd))
				log.info("Price Created successful ", request.getSku());
			else {
				log.info("Price not Created ", request.getSku());
				return new ResponseEntity<APIResponse>(this.buildErrorRes("Price not Created"), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {

			log.debug("Price Created Exception ", request.getSku());
			return new ResponseEntity<APIResponse>(this.buildErrorRes(e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<APIResponse>(this.buildSuccessRes("Price Created"), HttpStatus.OK);
	}

	/**
	 * API success response
	 *
	 * @return
	 */

	private APIResponse buildSuccessRes(String msg) {
		APIResponse res = new APIResponse();
		res.setCode(RestConstants.SUCCESS_CODE);
		res.setType(RestConstants.SUCCESS_RESPONSE);
		res.setMessage(msg);
		return res;
	}

	/**
	 * API Error response
	 *
	 * @return
	 */
	private APIResponse buildErrorRes(String error) {
		APIResponse res = new APIResponse();
		res.setCode(RestConstants.ERROR_CODE);
		res.setType(RestConstants.SYSTEM_ERROR);
		res.setMessage(error);
		return res;
	}

}
