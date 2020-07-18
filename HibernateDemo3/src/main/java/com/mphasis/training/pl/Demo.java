package com.mphasis.training.pl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mphasis.training.entities.Account;
import com.mphasis.training.util.HibernateUtil;

public class Demo {

	public static void main(String[] args) {

		SessionFactory sessionFactory =HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Account a1=(Account) session.get(Account.class, 124);
		//First level cache
		Account a2=(Account) session.get(Account.class, 124);
		session.close();
		//2nd level cache
		Session session1=sessionFactory.openSession();
		Account a11=(Account) session1.get(Account.class, 124);
		session1.close();
	}

}
