package settlePaisaService.SettlePaisaService;

import settlePaisaModels.SettlePaisaModels.PaymentComponents;
import settlePaisaModels.SettlePaisaModels.PaymentComponentsBreakUp;

public class SettlePaisaSplitMatrixService 
{     
	
	public PaymentComponentsBreakUp makePayment(double amount, double transactionCharges)
	{     
		   PaymentComponentsBreakUp paymentBreakup = new PaymentComponentsBreakUp();
		   paymentBreakup.setMerchantBank1(amount*0.8);
		   paymentBreakup.setMerchantBank2(amount*0.2);
		   paymentBreakup.setServiceProvider(amount*0.02);
		   paymentBreakup.setPaymentGatewayFixedCommission(amount*0.01);
		   paymentBreakup.setReferralPartnerCommission(amount*0.005);
		   double commission = (transactionCharges-paymentBreakup.getServiceProvider()-
	                           -paymentBreakup.getPaymentGatewayFixedCommission()-paymentBreakup.getReferralPartnerCommission());
		   paymentBreakup.setPartnerCommissionNSharing(commission*0.4);
		   paymentBreakup.setPaymentGatewayVariableCommission(commission*0.6);
		   paymentBreakup.setPaymentGatewayTotalCommission(amount*0.049);
		   return paymentBreakup;
	}
	public double refund(PaymentComponents paymentComponents)
	{
		PaymentComponentsBreakUp paymentBreakup = new PaymentComponentsBreakUp();
		double baseAmount = paymentComponents.getBaseAmount();
		PaymentComponentsBreakUp pay =  paymentComponents.getPaymentComponentsBreakUp();
		double refundAmount = baseAmount-(pay.getPartnerCommissionNSharing()-pay.getPaymentGatewayFixedCommission()
				                         -pay.getPaymentGatewayTotalCommission()-pay.getPaymentGatewayVariableCommission()-pay.getReferralPartnerCommission()
				                         -pay.getServiceProvider());
		return refundAmount;
		
	}
	
	
}
