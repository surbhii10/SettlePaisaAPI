package settlePaisaAPI.SettlePaisaAPI;
import java.awt.PageAttributes.MediaType;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import settlePaisaService.SettlePaisaService.PaymentGatewayService;

@RestController
public class HomeController 
{
	 @GetMapping(path = "/makepayment/{amount}",produces = "application/json")
	  public ResponseEntity<String> makePayment(@PathVariable Double amount)
	   {
		
		  String txnId =  PaymentGatewayService.makePayment(amount);
	      return  ResponseEntity.ok(txnId);
	   }
	 
	 @GetMapping(path = "/refund/{txnId}")
	  public ResponseEntity<Double> refund(@PathVariable UUID txnId)
	   {      
	           
		   double refundAmount = PaymentGatewayService.refund(txnId.toString());
	       return  ResponseEntity.ok(refundAmount);
	   }
	
	
}
