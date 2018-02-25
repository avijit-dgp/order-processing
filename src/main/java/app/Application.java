package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Currency;
import model.Entity;
import model.Order;
import service.ProcessOrder;
import service.ProcessOrderImpl;
import util.Report;

public class Application {
	
	public static void main(String args[]) {
		
		ProcessOrder processOrder = new ProcessOrderImpl();
		List<Order> orders= new ArrayList<>();
		
		Map<Date, Report> dateWiseReport = processOrder.getDateWiseReport(getSomeOrders(orders));
		dateWiseReport.keySet().stream()
			.forEach(date -> {
				Report report = dateWiseReport.get(date);
				System.out.println("Settlement Date : "+date);
				System.out.println("Total Incoming Amount : "+report.getTotalIncomingAmount());
				System.out.println("Total Outgoing Amount : "+report.getTotalOutgoingAmount());
				System.out.println("Ranking of Entities based on incoming amount::");
				report.getSortedEntityOnIncomingVolume().stream()
					.forEach(incomingVolume -> {
						System.out.println("Entity Name: "+incomingVolume.getEntityName()
						+ "Incoming Amount: "+ incomingVolume.getTotalIncomingAmount());
					});
				System.out.println("Ranking of Entities based on outgoing amount::");
				report.getSortedEntityOnOutgoingVolume().stream()
				.forEach(outingVolume -> {
					System.out.println("Entity Name: "+outingVolume.getEntityName()
					+ "Outgoing Amount: "+ outingVolume.getTotalOutgoingAmount());
				});
			});
		
		
	}


	private static List<Order> getSomeOrders(List<Order> orders) {
		Order order1 = new Order();
		order1.setBuy(true);
		order1.setEntity(new Entity("ABC corp", 200));
		order1.setUnits(100);
		order1.setTradingCurrency(new Currency("GBP", Set.of(DayOfWeek.SATURDAY,DayOfWeek.SUNDAY), 1.2f));
		order1.setSettlementRequestDate(parseDate("2018-02-24"));
		Order order2 = new Order();
		order2.setBuy(false);
		order2.setEntity(new Entity("ABC corp", 100));
		order2.setUnits(100);
		order2.setTradingCurrency(new Currency("EUR", Set.of(DayOfWeek.SATURDAY,DayOfWeek.FRIDAY), .22f));
		order2.setSettlementRequestDate(parseDate("2018-02-23"));
		Order order3 = new Order();
		order3.setBuy(true);
		order3.setEntity(new Entity("Zindal", 150));
		order3.setUnits(200);
		order3.setTradingCurrency(new Currency("INR", Set.of(DayOfWeek.SATURDAY,DayOfWeek.SUNDAY), 60f));
		order3.setSettlementRequestDate(parseDate("2018-02-25"));
		Order order4 = new Order();
		order4.setBuy(true);
		order4.setEntity(new Entity("ABC corp", 500));
		order4.setUnits(100);
		order4.setTradingCurrency(new Currency("CAD", Set.of(DayOfWeek.SATURDAY,DayOfWeek.SUNDAY), .82f));
		order4.setSettlementRequestDate(parseDate("2018-02-25"));
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		orders.add(order4);
		return orders;
	}
	
	
	public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }

}
