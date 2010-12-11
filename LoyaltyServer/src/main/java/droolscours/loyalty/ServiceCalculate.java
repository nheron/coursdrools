package droolscours.loyalty;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.drools.runtime.StatefulKnowledgeSession;

import util.KnowledgeSessionHelper;

import droolscours.loyalty.domains.Ticket;

@WebService(endpointInterface = "droolscours.loyalty.IServiceCalculate", serviceName = "ServiceCalculate")
public class ServiceCalculate implements IServiceCalculate {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * droolscours.loyalty.IServiceCalculate#calculate(droolscours.loyalty.domains
	 * .Ticket)
	 */
	private StatefulKnowledgeSession sessionStatefull = null;

	@Override
	public Ticket calculate(@WebParam(name = "arg0") Ticket ticket) {
		sessionStatefull = KnowledgeSessionHelper
				.getStatefulKnowledgeSession("File1.drl");
		sessionStatefull.insert(ticket);
		sessionStatefull.fireAllRules();
		System.out.println("Works");
		return ticket;
	}
}
