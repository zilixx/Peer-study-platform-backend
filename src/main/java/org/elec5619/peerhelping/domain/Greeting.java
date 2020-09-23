package org.elec5619.peerhelping.domain;

import java.util.Date;

public class Greeting {
    /**
     * Plain Old Java Object, a.k.a. POJO
     */
    private final long id;
    private final String content;
    private final String date;

    public Greeting(long id, String content){
        this.id = id;
        this.content = content;

        var date = new Date();
        this.date = date.toString();
    }

    public long getId(){
        return id;
    }

    public String getContent(){
        return content;
    }

    public String getDate() {
        return date;
    }
}
