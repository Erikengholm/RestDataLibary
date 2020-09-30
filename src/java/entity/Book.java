/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Erik Engholm
 */

@Entity
public class Book implements Serializable {

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private int pageNumber;
    private String genres; 

    public Book(String title, int pagenumber, String author, String genres) {
        this.author=author;
        this.pageNumber=pagenumber;
        this.title=title;
        this.genres=genres;
    }

    public ArrayList<String> StringToList() {
        ArrayList<String> genre = null;
        int point1=0;
        genres=" "+genres;
        String concat =genres.concat(",");
        for(int c=0;c<genres.length();c++){
            if(concat.charAt(c)==','){
                    genre.add(concat.substring(++point1, c));
                    point1=c;
                }
        }
        return genre;
         
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genra) {
        this.genres = genra;
    }
            
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book name is"+id+" and is written by "+author;
    }
    public Book(){
    }
    
}
