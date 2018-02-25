package model;

import java.util.Date;

public class Order {
	
	private int orderId;
	private Entity entity;
	private boolean buy;
	private int units;
	private Currency tradingCurrency;
	private Date instructionDate;
	private Date settlementRequestDate;
	private Date actualSettlementDate;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Entity getEntity() {
		return entity;
	}
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	public boolean isBuy() {
		return buy;
	}
	public void setBuy(boolean buy) {
		this.buy = buy;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public Currency getTradingCurrency() {
		return tradingCurrency;
	}
	public void setTradingCurrency(Currency tradingCurrency) {
		this.tradingCurrency = tradingCurrency;
	}
	public Date getInstructionDate() {
		return instructionDate;
	}
	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}
	public Date getSettlementRequestDate() {
		return settlementRequestDate;
	}
	public void setSettlementRequestDate(Date settlementRequestDate) {
		this.settlementRequestDate = settlementRequestDate;
	}
	public Date getActualSettlementDate() {
		return actualSettlementDate;
	}
	public void setActualSettlementDate(Date actualSettlementDate) {
		this.actualSettlementDate = actualSettlementDate;
	}
	
	

}
