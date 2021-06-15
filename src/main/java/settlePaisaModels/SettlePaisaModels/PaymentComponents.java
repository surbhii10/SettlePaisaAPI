package settlePaisaModels.SettlePaisaModels;


public class PaymentComponents 
{
	private double baseAmount;
	private double transactionCharges;
	private PaymentComponentsBreakUp paymentComponentsBreakUp;
	public double getBaseAmount() {
		return baseAmount;
	}
	public void setBaseAmount(double baseAmount) {
		this.baseAmount = baseAmount;
	}
	public double getTransactionCharges() {
		return transactionCharges;
	}
	public void setTransactionCharges(double transactionCharges) {
		this.transactionCharges = transactionCharges;
	}
	public PaymentComponentsBreakUp getPaymentComponentsBreakUp() {
		return paymentComponentsBreakUp;
	}
	public void setPaymentComponentsBreakUp(PaymentComponentsBreakUp paymentComponentsBreakUp) {
		this.paymentComponentsBreakUp = paymentComponentsBreakUp;
	}
	
	
}
