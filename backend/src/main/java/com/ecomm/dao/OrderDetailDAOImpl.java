package com.ecomm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Cart;
import com.ecomm.model.Category;
import com.ecomm.model.OrderDetail;

@Repository("orderDetailDAO")
@Transactional
public class OrderDetailDAOImpl implements OrderDetailDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean confirmOrder(OrderDetail orderDetail) {
		try
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	
	}
	
	 public List<OrderDetail> getOrderDetail(String username) {
		 Session session=sessionFactory.openSession();
			Query query = session.createQuery("from OrderDetail where Username=:username");
			query.setParameter("username",username);
			List<OrderDetail> listOrderDetail=(List<OrderDetail>)query.list();
			return listOrderDetail;
		 
	 }
	 
	 @Override
	 public OrderDetail getOrderId(int orderId) {
	 	Session session=sessionFactory.openSession();
	 	OrderDetail orderDetail=(OrderDetail)session.get(OrderDetail.class,orderId);
	 	session.close();
	 	return orderDetail;
	 }


}
