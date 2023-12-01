package com.example.hibernate.programs.hibernate_programs;

import org.hibernate.cfg.Configuration;

public class BookOperations {

	private static Book createBook() 
	{
		Book book = new Book();
		book.setAuthor("manoj");
		book.setBookName("Hibernate");
		book.setPrice(200);
		
		return book;
	}
	
//	private static Session createConnection() 
//	{
//		//Configuration conf = new Conf
//	}
	
	public static void main(String[] args) {
		
		;

	}

}
