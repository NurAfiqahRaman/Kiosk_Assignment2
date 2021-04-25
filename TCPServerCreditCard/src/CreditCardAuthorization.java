import java.util.Scanner;
	/**
	 * This method validate credit card.
	 * 
	 * @return status message
	 * @author Nur Afiqah Raman
	 */
public class CreditCardAuthorization {
	
	public String statusCard(int cardNumber) {
		String statusCard = "Checking for credit card number.";
		boolean status=false;
		int array[]= {88890, 7786, 6788, 1632};
		int i;
		//search for the existence of the card's number
		for (i=0; i<array.length; i++)
		{
			if (array[i]==cardNumber)
				status=true;
			else
				status=false;
		}
		

		if (status)
			statusCard = "Credit card is valid. The system will continue the transaction....";
		
		return statusCard;
	}
	
	
	
	
		
}
