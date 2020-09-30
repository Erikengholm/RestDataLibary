/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author Erik Engholm
 */
@Stateless
public class LibaryManager implements LibaryDao {
@PersistenceContext
EntityManager em;
    @Override
    public void Add(Book b) {
        em.persist(b);
    }

    @Override
    public List<Book> showAll() {
      Query q = em.createQuery("SELECT b FROM Book b");
      return q.getResultList();  
    }

    @Override
    public Book findById(Long id) {
    Book b = em.find(Book.class,id);
        if (b == null) {
            throw new EntityNotFoundException("Can't find book for ID "
                + id);
        }
        return b;    }

    @Override
    public List<Book> findByAuthor(String author) {
        Query q = em.createQuery("SELECT b FROM Book b WHERE b.author LIKE :custName").setParameter("custName", author);
      return q.getResultList(); 
    }

    @Override
    public List<Book> findByName(String name) {
      Query q = em.createQuery("SELECT b FROM Book b WHERE b.title LIKE :custName").setParameter("custName", name);
      return q.getResultList(); 
    }

    @Override
    public void update(Book b) {
                em.merge(b);
    }

    @Override
    public void delete(Book b) {
  if (!em.contains(b)) {
            b = em.merge(b);
}
        em.remove(b);    }
    
}
