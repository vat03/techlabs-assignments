package com.aurionpro.model;

public class Book implements Comparable<Book> {
	private String isbn;
	private String title;
	private String author;

	public Book(String isbn, String title, String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public int compareTo(Book book) {
		return this.title.compareToIgnoreCase(book.title);
	}

	@Override
	public String toString() {
		return "Book isbn: " + isbn + ", Book Title: " + title + ", Book Author: " + author;
	}
}
