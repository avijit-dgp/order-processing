package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import model.Order;
import util.Report;
import util.TradingEntity;
import util.Utility;

public class ProcessOrderImpl implements ProcessOrder{
	
	
	
	
	public Map<Date, Report> getDateWiseReport(List<Order> orders) {
		Map<Date,List<TradingEntity>> dateWiseTradingEntity = processOrderDetails(orders);
		Map<Date, Report> dateWiseReport = new HashMap<>();
		dateWiseTradingEntity.keySet().stream()
			.forEach(settlementDate -> {
				Report report = new Report(settlementDate);
				List<TradingEntity> treadedEntityOnThatDay=dateWiseTradingEntity.get(settlementDate);
				treadedEntityOnThatDay.stream()
					.forEach(tradingEntity -> {
						report.setTotalIncomingAmount(
								report.getTotalIncomingAmount()+ tradingEntity.getTotalIncomingAmount());
						report.setTotalOutgoingAmount(
								report.getTotalOutgoingAmount()+tradingEntity.getTotalOutgoingAmount());
					});
				treadedEntityOnThatDay.sort(Comparator.comparing(TradingEntity::getTotalIncomingAmount).reversed());
				report.setSortedEntityOnIncomingVolume(treadedEntityOnThatDay);
				treadedEntityOnThatDay.sort(Comparator.comparing(TradingEntity::getTotalOutgoingAmount).reversed());
				report.setSortedEntityOnOutgoingVolume(treadedEntityOnThatDay);
				dateWiseReport.put(settlementDate, report);
			});
		return dateWiseReport;
		
	}

	private Map<Date,List<TradingEntity>> processOrderDetails(List<Order> orders) {
		Map<Date,List<TradingEntity>> dateWiseTradingEntity = new HashMap<>();
		orders.stream()
		.map(order-> setActualSettlementDate(order))
		.forEach(updatedOrder -> 
		{
			if(updatedOrder.getUnits() > 0) {
				double tradingUSDAmount=updatedOrder.getUnits() * updatedOrder.getEntity().getUnitPrice() * updatedOrder.getTradingCurrency().getAgreedFx();
				TradingEntity tradingEntity = new TradingEntity(updatedOrder.getEntity().getName().toUpperCase());
				if(!dateWiseTradingEntity.containsKey(updatedOrder.getActualSettlementDate())) {
					if(updatedOrder.isBuy())
						tradingEntity.setTotalOutgoingAmount(tradingUSDAmount);
					else
						tradingEntity.setTotalIncomingAmount(tradingUSDAmount);
					List<TradingEntity> tradingEntities = new ArrayList<>();
					tradingEntities.add(tradingEntity);
					dateWiseTradingEntity.put(updatedOrder.getActualSettlementDate(), tradingEntities);
				} else {
					List<TradingEntity> tradingEntities = dateWiseTradingEntity.get(updatedOrder.getActualSettlementDate());
					Optional<TradingEntity> matchedEntity = tradingEntities.stream()
							.filter(entity -> entity.equals(tradingEntity)).findFirst();
					if(matchedEntity.isPresent()){
						if(updatedOrder.isBuy())
							matchedEntity.get().setTotalOutgoingAmount(matchedEntity.get().getTotalOutgoingAmount() + tradingUSDAmount);
						else
							matchedEntity.get().setTotalIncomingAmount(matchedEntity.get().getTotalIncomingAmount() + tradingUSDAmount);
					} else {
						if(updatedOrder.isBuy())
							tradingEntity.setTotalOutgoingAmount(tradingUSDAmount);
						else
							tradingEntity.setTotalIncomingAmount(tradingUSDAmount);
						tradingEntities.add(tradingEntity);
					}
				}
			}
			
		});
		
		return dateWiseTradingEntity;
	}

	private Order setActualSettlementDate(Order order) {
		if(null != order.getSettlementRequestDate())
			order.setActualSettlementDate(Utility.getBusinessDay(order.getSettlementRequestDate(), order.getTradingCurrency()));
		return order;
	}

}
