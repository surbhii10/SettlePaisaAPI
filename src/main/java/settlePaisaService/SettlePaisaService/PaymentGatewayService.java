package settlePaisaService.SettlePaisaService;

import java.util.HashMap;
import java.util.UUID;

import settlePaisaModels.SettlePaisaModels.PaymentComponents;
import settlePaisaModels.SettlePaisaModels.PaymentComponentsBreakUp;

public  class PaymentGatewayService
{      
     public static HashMap<String, PaymentComponents> map = new HashMap<String, PaymentComponents>();
      public static String makePayment(double amount)
        {   
        	double txnCharges = amount-10;; 
        	PaymentComponents paymentComponents = new PaymentComponents();
        	paymentComponents.setBaseAmount(amount-txnCharges);
        	SettlePaisaSplitMatrixService matrixService = new SettlePaisaSplitMatrixService ();
        	PaymentComponentsBreakUp paymentComponentsBreakUp = matrixService.makePayment(amount-txnCharges, txnCharges);
        	paymentComponents.setPaymentComponentsBreakUp(paymentComponentsBreakUp);
        	paymentComponents.setTransactionCharges(txnCharges);
        	UUID uuid = UUID.randomUUID();
            String id= uuid.toString();
            map.put(id,paymentComponents);
            return id;
        	
        }
      public static double refund(String transactionId)
      {   System.out.println();
    	  System.out.println(transactionId);
    	  SettlePaisaSplitMatrixService matrixService = new SettlePaisaSplitMatrixService ();
    	  PaymentComponents paymentComponents = new PaymentComponents();
    	  if(!map.containsKey(transactionId))
    		  return 0.0;
    	  paymentComponents = map.get(transactionId);
    	  System.out.println("base" +paymentComponents.getBaseAmount());
    	  double refundAmount = matrixService.refund(paymentComponents);
    	  return refundAmount;
    	  
      }
}
