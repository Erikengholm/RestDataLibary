/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.LibaryDao;
import entity.Book;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Erik Engholm
 */
@Named(value = "Libary")
@RequestScoped
public class LibaryController {
    @Inject
    LibaryDao lm;
    
     private String author;
    private int pagenumber;
    private String title;
    private List<Book> allData;
    private String genres;
    private Long id;
    private String Choose = "all";
    private String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getChoose() {
        return Choose;
    }

    public void setChoose(String Choose) {
        this.Choose = Choose;
    }
    
     public void submit() {
         genres=" "+genres;
        Book b = new Book(title, pagenumber, author,genres);
        lm.Add(b);
        allData = lm.showAll();

    }
    
     public void listData(){
     switch(Choose){
         case "all":
             fillData();
             break;
         case "id":
             findBookById();
             break;
         case "name":
             findBookByName();
             break;
         case "author":
             findBookByAuthor();
             break;
     }
     
     }
     
    @PostConstruct
    public void fillData(){
            allData = lm.showAll();
    }
    public void update(Book B){
        
        if(title.isEmpty() || title == null){
        }
        else{
        B.setTitle(title);}
        if(pagenumber == 0){
        }
        else{
        B.setPageNumber(pagenumber);}
        if(author.isEmpty() || author == null){
        }
        else{
        B.setAuthor(author);}
        if(genres.isEmpty() || genres == null){
        }
        else{
        B.setTitle(genres);}
        lm.update(B);
        fillData();

    }

    public void findBookById(){
            Book b= lm.findById(Long.parseLong(search));
            allData.clear();
            allData.add(b);
    }

    public void findBookByAuthor(){
            allData.clear();
            allData=lm.findByAuthor(search);
    }

    public void findBookByName(){
            allData.clear();
            allData=lm.findByName(search);
    }

    public void delete(Book b){
    lm.delete(b);
    fillData();
    }
 
    public ArrayList<String> StringToList(Book b) {
        ArrayList<String> genre = new ArrayList<>();
        int point1=0;
        if(b == null){
        }
        else{
        String ph=" "+b.getGenres();
        String concat =ph.concat(",");
        for(int c=0;c<concat.length();c++){
            if(concat.charAt(c)==','){
            genre.add(concat.substring(++point1, c));
            point1=c;
                }
        }
        }
        return genre;
         
    }
    public LibaryController() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
    public LibaryDao getLm() {
        return lm;
    }

    public void setLm(LibaryDao lm) {
        this.lm = lm;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(int pagenumber) {
        this.pagenumber = pagenumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Book> getAllData() {
        return allData;
    }

    public void setAllData(List<Book> allData) {
        this.allData = allData;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
    
    
}
