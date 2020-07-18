package com.mphasis.training.pl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.mphasis.training.entities.Account;
import com.mphasis.training.entities.CurrentAccount;
import com.mphasis.training.entities.SavingsAccount;
import com.mphasis.training.util.HibernateUtil;


public class HibernateApp {

	public static void main(String[] args) {


	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	//criteria
	Session session=sessionFactory.openSession();
	List<Account> accounts=session.createCriteria(Account.class).list();
	for(Account a:accounts) {
		System.out.println(a.getAcc_holder_name()+" "+a.getBalance());
	}
	session.close();
	
	//HQL FROM EMployee
	Session session1=sessionFactory.openSession();
	Query query=session1.createQuery("FROM Account");
	query.list().forEach(System.out::println);
	
	//HQL
	Query query1=session1.createQuery("SELECT a.accnum FROM Account a");
	query1.list().forEach(System.out::println);
	
	//HQL
	session1.beginTransaction();
	Query qd=session1.createQuery("DELETE FROM Account WHERE accnum =:acc");
	qd.setParameter("acc", 123);
	qd.executeUpdate();
	session1.getTransaction().commit();
	System.out.println("Deleted");
	
	session1.close();
	
	//sql select * from employee
	Session session2=sessionFactory.openSession();
	SQLQuery sqlQuery=session2.createSQLQuery("select acc_holder_name,accnum from account");
	List<Object[]> objects=sqlQuery.list();
	for(Object[] row:objects) {
		Account a=new Account();
		a.setAcc_holder_name(row[0].toString());
		a.setAccnum(Integer.parseInt(row[1].toString()));
		System.out.println(a.getAcc_holder_name()+" "+a.getAccnum());
	}
	session2.close();

	}

}
