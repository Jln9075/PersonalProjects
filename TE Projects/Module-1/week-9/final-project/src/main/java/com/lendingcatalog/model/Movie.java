package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.time.LocalDate;
import java.util.UUID;

public class Movie implements CatalogItem{
    String id;
    String title;
    String director;
    LocalDate releaseDate;

    public Movie(String title, String director, LocalDate releaseDate) {
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @Override
    public boolean matchesName(String searchStr) {
        searchStr = searchStr.toLowerCase();

        if(searchStr.equals(title.toLowerCase())){
            return true;
        }

        return false;
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        return false;
    }

    @Override
    public boolean matchesYear(int searchYear) {
        if (releaseDate.getYear() == searchYear){
            return true;
        }
        return false;
    }

    @Override
    public void registerItem() {
        this.id = UUID.randomUUID().toString();
        try {
            FileStorageService.writeContentsToFile(toString(), "src/main/resources/logs/memberInfo.log", true);
        }
        catch(FileStorageException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString(){
        return "-- " + title + "\n" +
                "-- Directed by: " + director + "\n" +
                "-- Released: " + releaseDate + "\n" +
                "-- Id: " + id + "\n";
    }
}
