package droolscours.loyalty;

import javax.jws.WebMethod;
import javax.jws.WebService;

import droolscours.loyalty.domains.Ticket;
@WebService
public interface IServiceCalculate {

	@WebMethod(operationName="calculate") 
	public abstract Ticket calculate( Ticket ticket);

}