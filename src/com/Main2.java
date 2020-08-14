package com;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Main2 {

	public static void main(String[] args) {
		
		// loads configuration and mappings
				Configuration configuration = new Configuration().configure();
				ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
				registry.applySettings(configuration.getProperties());
				ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
				
				// builds a session factory from the service registry
				SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
				// obtains the session
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				
				
				
				// gets the book entity back
				
				Book book = (Book) session.get(Book.class, (long) 6);
				System.out.println("Book's Title: " + book.getTitle());
				System.out.println("Book's Description: " + book.getDescription());
				
				Author author = book.getAuthor();
				System.out.println("Author's Name: " + author.getName());
				System.out.println("Author's Email: " + author.getEmail());
				
				Author author1 = (Author) session.get(Author.class, (long) 5);
				System.out.println(author1);
				
								
				session.getTransaction().commit();
				session.close();		
			}
		
		
		

	}


