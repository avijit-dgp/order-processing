package util;

public class TradingEntity {
	private String entityName;
	private double totalIncomingAmount;
	private double totalOutgoingAmount;
	
	
	public TradingEntity() {
		super();
	}
	public TradingEntity(String entityName) {
		super();
		this.entityName = entityName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entityName == null) ? 0 : entityName.hashCode());
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
		TradingEntity other = (TradingEntity) obj;
		if (entityName == null) {
			if (other.entityName != null)
				return false;
		} else if (!entityName.equals(other.entityName))
			return false;
		return true;
	}
	
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
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
	
	
}
