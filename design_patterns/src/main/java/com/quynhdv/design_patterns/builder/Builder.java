package com.quynhdv.design_patterns.builder;

public class Builder {
    public static void main(String[] args) {
        Book book = new Book();
        book.setName("Gang of Four")
                .setYearPublished(1999)
                .setMonthPublished(3)
                .setDatePublished(15);
        System.out.println(book);
    }
}

class Book {
    private String name, isbn;
    private int yearPublished, monthPublished, datePublished;
    public Book setName(String _name){
        this.name = _name;
        return this;
    }
    public Book setYearPublished(int _year){
        this.yearPublished = _year;
        return this;
    }
    public Book setMonthPublished(int _month){
        this.monthPublished = _month;
        return this;
    }
    public Book setDatePublished(int _date){
        this.datePublished = _date;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", yearPublished=" + yearPublished +
                ", monthPublished=" + monthPublished +
                ", datePublished=" + datePublished +
                '}';
    }
}
