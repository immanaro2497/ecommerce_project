package com.ecomm.daotest;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.OrderDetailDAO;
import com.ecomm.model.OrderDetail;

public class OrderDetailDAOTest {
static OrderDetailDAO orderDetailDAO;
@BeforeClass
public static void executefirst() {
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.ecomm");
	context.refresh();
	orderDetailDAO=(OrderDetailDAO)context.getBean("orderDetailDAO");
}
@Test
public void confirmOrderDetail() {
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setOrderId(1);
		orderDetail.setUsername("karthik");
		orderDetail.setTotalAmount(10000);
		orderDetail.setShippingAddr("chennai");
		orderDetail.setTransactionType("CC");
		orderDetail.setOrderDate(String.format("%tc",new Date()));
		assertTrue("problem in adding",orderDetailDAO.confirmOrder(orderDetail));
}
}
