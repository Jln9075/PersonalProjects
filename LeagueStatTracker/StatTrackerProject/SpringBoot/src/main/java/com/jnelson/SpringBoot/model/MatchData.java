package com.jnelson.SpringBoot.model;

import com.jnelson.SpringBoot.model.matchdata.Info;
import com.jnelson.SpringBoot.model.matchdata.MetaData;

public class MatchData {
    private MetaData metaData;
    private Info info;

    public MatchData(){

    }
    public MatchData(MetaData metaData, Info info) {
        this.metaData = metaData;
        this.info = info;
    }

    public MetaData getMetaData() {
        return metaData;
    }
    public Info getInfo() {
        return info;
    }



    @Override
    public String toString() {
        return "MatchData{" +
                "metaData=" + metaData +
                ", info=" + info +
                '}';
    }
}
