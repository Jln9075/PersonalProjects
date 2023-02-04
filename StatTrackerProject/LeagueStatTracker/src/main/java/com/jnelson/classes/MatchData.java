package com.jnelson.classes;

import com.jnelson.classes.matchdata.Info;
import com.jnelson.classes.matchdata.MetaData;

public class MatchData {
    MetaData metaData;
    Info info;

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
