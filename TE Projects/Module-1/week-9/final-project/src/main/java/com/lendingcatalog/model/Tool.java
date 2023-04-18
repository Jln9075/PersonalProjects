package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;
import java.util.UUID;

public class Tool implements CatalogItem{
    String id;
    String type;
    String manufacturer;
    int count;

    public String getType() {
        return type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getCount() {
        return count;
    }

    public Tool(String type, String manufacturer, int count) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.count = count;
    }

    @Override
    public boolean matchesName(String searchStr) {
        searchStr = searchStr.toLowerCase();
        if(searchStr.equals(manufacturer.toLowerCase())){
            return true;
        }
        return false;
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        searchStr = searchStr.toLowerCase();

        if(searchStr.equals(manufacturer.toLowerCase())){
            return true;
        }
        return false;
    }

    @Override
    public boolean matchesYear(int searchYear) {
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
    public String toString() {
        return "-- " + type + "\n" +
                "-- Made by: " + manufacturer + "\n" +
                "-- Amount: " + count + "\n" +
                "-- Id: " + id + "\n";
    }
}
