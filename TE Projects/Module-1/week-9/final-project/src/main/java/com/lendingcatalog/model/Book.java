package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.time.LocalDate;
import java.util.UUID;

public class Book implements CatalogItem{

    String id;
    String name;
    String writer;
    LocalDate publishDate;

    public String getName() {
        return name;
    }

    public String getWriter() {
        return writer;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public Book(String name, String writer, LocalDate publishDate) {
        this.name = name;
        this.writer = writer;
        this.publishDate = publishDate;
    }

    @Override
    public boolean matchesName(String searchStr) {
        searchStr = searchStr.toLowerCase();

        if(searchStr.equals(name.toLowerCase())){
            return true;
        }

        return false;
    }

    @Override
    public boolean matchesYear(int searchYear) {
        if (publishDate.getYear() == searchYear){
            return true;
        }
        return false;
    }
    @Override
    public boolean matchesCreator(String searchStr) {
        searchStr = searchStr.toLowerCase();

        if(searchStr.equals(writer.toLowerCase())){
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

    public String toString(){
        return "-- " + name + "\n" +
                "-- Written by: " + writer + "\n" +
                "-- Published: " + publishDate + "\n" +
                "-- Id: " + id + "\n";
    }
}
