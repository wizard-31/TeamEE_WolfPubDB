package main.java.wolfpub.dbobject;

import java.util.Date;

public class Publication {
	private Integer publication_id;
	private String publication_type;
	private String topic;
	private String title;
	private Date publication_date;
	public int getPublication_id() {
		return publication_id;
	}
	public void setPublication_id(int publication_id) {
		this.publication_id = publication_id;
	}
	public String getPublication_type() {
		return publication_type;
	}
	public void setPublication_type(String publication_type) {
		this.publication_type = publication_type;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPublication_date() {
		return publication_date;
	}
	public void setPublication_date(Date string) {
		this.publication_date = string;
	}
	
	public void display() {
        System.out.println("Pulication Details");
        System.out.println("Id: " + publication_id);
        System.out.println("Type: " + publication_type);
        System.out.println("Topic: " + topic);
        System.out.println("Title: " + title);
        System.out.println("Publication Date: " + publication_date);
        return;
        
    }

    public String getMeta() {
        return "( publication_type, topic, title, publication_date)";
    }

    public String toString() {
        String res = "(";
        res = res + "'";
        res = res + publication_type;
        res = res + "'";
        res = res + ",";
        res = res + "'";
        res = res + topic;
        res = res + "'";
        res = res + ",";
        res = res + "'";
        res = res + title;
        res = res + "'";
        res = res + ",";
        res = res + "'";
        res = res + publication_date;
        res = res + "'";
        res = res + ")";
        return res;
    }
	

}
