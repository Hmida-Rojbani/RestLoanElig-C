package de.tekup.rest.services;

import org.springframework.stereotype.Service;

import de.tekup.rest.models.CustomerRequest;
import de.tekup.rest.models.WsResponse;

@Service
public class LoanService {
	
	public WsResponse getLoanStatus(CustomerRequest customerRequest) {
		WsResponse response = new WsResponse();
		
		if(customerRequest.getAge() < 25 || customerRequest.getAge() > 50) {
			response.getCriteriaMismatch().add("Customer age must be between 25 and 50.");
		}
		if(customerRequest.getYearlyIncome() < 20000) {
			response.getCriteriaMismatch().add("Customer yearly income must be over 20000.");
		}
		//cibile score 1 -> 999
		if(customerRequest.getCibilScore() < 500) {
			response.getCriteriaMismatch().add("Customer cibile score must be over 500.");
		}
		
		if(response.getCriteriaMismatch().isEmpty()) {
			response.setEligible(true);
			response.setApprovedAmount((long)((50-customerRequest.getAge())*customerRequest.getYearlyIncome()*0.4));
		}else {
			response.setEligible(false);
			response.setApprovedAmount(0);
		}
		
		return response;
	}

}
