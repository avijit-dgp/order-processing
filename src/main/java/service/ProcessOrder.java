package service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import model.Order;
import util.Report;

public interface ProcessOrder {
	
	public Map<Date, Report> getDateWiseReport(List<Order> orders);

}
