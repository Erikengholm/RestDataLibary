/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.Book;
import java.util.List;

/**
 *
 * @author Erik Engholm
 */
public interface LibaryDao {
      
    public void Add (Book b);
    public List<Book> showAll();

    public Book findById(Long id);
    public List<Book> findByAuthor(String author);
    public List<Book> findByName(String name);

    public void update(Book b);
    public void delete(Book b);
}
