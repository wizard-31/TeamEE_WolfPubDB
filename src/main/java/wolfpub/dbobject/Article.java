package main.java.wolfpub.dbobject;

public class Article
{
    private Integer articleID;
    private String topic;
    private String content;
  
    public Article() {
		// TODO Auto-generated constructor stub
  	}

    public Article(Integer articleID, String topic, String content) {
        this.articleID = articleID;
        this.topic = topic;
        this.content = content;
    }

    //Initializing Getters and Setters
    public Integer getArticleID() { return articleID; }
    public void setArticleID(Integer articleID) { this.articleID = articleID; }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public void display() {
        System.out.println("Article Details");
        System.out.println("Article Id: " + articleID);
        System.out.println("topic: " + topic);
        System.out.println("content: " + content);
     
        return;    
    }

    public String getMeta() {
        return "( topic, content)";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("('").append(topic).append("','").append(content).append("')");
        return sb.toString();
    }
}

