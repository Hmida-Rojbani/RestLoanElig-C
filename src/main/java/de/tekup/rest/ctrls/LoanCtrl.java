package de.tekup.rest.ctrls;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.rest.models.CustomerRequest;
import de.tekup.rest.models.WsResponse;
import de.tekup.rest.services.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LoanCtrl {
	
	private LoanService service;
	
	@Operation(summary = "To check the eligibilty of client")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Return Client status"),
			@ApiResponse(responseCode = "400", description = "Not yet Implimented")
	})
	@PostMapping(path="/check/client/status",
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public WsResponse getStatus(@RequestBody CustomerRequest request) {
		return service.getLoanStatus(request);
	}

}
