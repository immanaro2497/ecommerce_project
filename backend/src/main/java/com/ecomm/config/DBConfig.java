package com.ecomm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.CartDAOImpl;
import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.CategoryDAOImpl;
import com.ecomm.dao.OrderDetailDAO;
import com.ecomm.dao.OrderDetailDAOImpl;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.ProductDAOImpl;
import com.ecomm.dao.SupplierDAO;
import com.ecomm.dao.SupplierDAOImpl;
import com.ecomm.dao.UserDAO;
import com.ecomm.dao.UserDAOImpl;
import com.ecomm.model.Cart;
import com.ecomm.model.Category;
import com.ecomm.model.OrderDetail;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;
import com.ecomm.model.User;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecomm.*")
public class DBConfig 
{
@Bean(name="datasource")
public DataSource getH2DataSource()
{
	DriverManagerDataSource datasource=new DriverManagerDataSource();
	
	datasource.setDriverClassName("org.h2.Driver");
	datasource.setUrl("jdbc:h2:tcp://localhost/E:/database/table7/ecomdb");
	datasource.setUsername("imm");
	datasource.setPassword("imm");
	System.out.println(">>>>>>Datasource object created<<<<<<");
	return datasource;
}

@Bean(name="sessionFactory")
public SessionFactory getSessionFactory()
{
	Properties hibernateprop=new Properties();
	
	hibernateprop.put("hibernate.hbm2ddl.auto","update");
	hibernateprop.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());

	factory.addProperties(hibernateprop);
	
	factory.addAnnotatedClass(Category.class);
	factory.addAnnotatedClass(Supplier.class);
	factory.addAnnotatedClass(Product.class);
	factory.addAnnotatedClass(Cart.class);
	factory.addAnnotatedClass(User.class);
	factory.addAnnotatedClass(OrderDetail.class);
	System.out.println(">>>>>>SessionFactory Object created<<<<<<");

	return factory.buildSessionFactory();
	
}
@Bean(name="TransactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
{
	System.out.println(">>>>>TransactionManager Object created<<<<<<");
	return new HibernateTransactionManager(sessionFactory);
}
@Bean(name="categoryDAO") 
		public CategoryDAO getCategoryDAO() {
	System.out.println("Category DAO Implementation");
			return new CategoryDAOImpl();
		}
@Bean(name="supplierDAO") 
public SupplierDAO getSupplierDAO() {
	System.out.println("Supplier DAO Implementation");
	return new SupplierDAOImpl();
}
@Bean(name="productDAO") 
public ProductDAO getProductDAO() {
	System.out.println("Product DAO Implementation");
	return new ProductDAOImpl();
}
@Bean(name="cartDAO") 
public CartDAO getCartDAO() {
	System.out.println("Cart DAO Implementation");
	return new CartDAOImpl();
}
@Bean(name="userDAO") 
public UserDAO getUserDAO() {
	System.out.println("User DAO Implementation");
	return new UserDAOImpl();
}
@Bean(name="orderDetailDAO") 
public OrderDetailDAO getOrderDetailDAO() {
	System.out.println("OrderDetail DAO Implementation");
	return new OrderDetailDAOImpl();
}
}
