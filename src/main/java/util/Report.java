package util;

import java.util.Date;
import java.util.List;

public class Report {
	private Date settlementDate;
	private double totalIncomingAmount;
	private double totalOutgoingAmount;
	private List<TradingEntity> sortedEntityOnIncomingVolume;
	private List<TradingEntity> sortedEntityOnOutgoingVolume;
	
	
	public Report(Date settlementDate) {
		super();
		this.settlementDate = settlementDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((settlementDate == null) ? 0 : settlementDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Report other = (Report) obj;
		if (settlementDate == null) {
			if (other.settlementDate != null)
				return false;
		} else if (!settlementDate.equals(other.settlementDate))
			return false;
		return true;
	}
	public Date getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	public double getTotalIncomingAmount() {
		return totalIncomingAmount;
	}
	public void setTotalIncomingAmount(double totalIncomingAmount) {
		this.totalIncomingAmount = totalIncomingAmount;
	}
	public double getTotalOutgoingAmount() {
		return totalOutgoingAmount;
	}
	public void setTotalOutgoingAmount(double totalOutgoingAmount) {
		this.totalOutgoingAmount = totalOutgoingAmount;
	}
	public List<TradingEntity> getSortedEntityOnIncomingVolume() {
		return sortedEntityOnIncomingVolume;
	}
	public void setSortedEntityOnIncomingVolume(List<TradingEntity> sortedEntityOnIncomingVolume) {
		this.sortedEntityOnIncomingVolume = sortedEntityOnIncomingVolume;
	}
	public List<TradingEntity> getSortedEntityOnOutgoingVolume() {
		return sortedEntityOnOutgoingVolume;
	}
	public void setSortedEntityOnOutgoingVolume(List<TradingEntity> sortedEntityOnOutgoingVolume) {
		this.sortedEntityOnOutgoingVolume = sortedEntityOnOutgoingVolume;
	}
	
}
