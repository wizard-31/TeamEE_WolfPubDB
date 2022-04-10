package main.java.wolfpub.dbobject;
public class Article
{
    private Integer article_Id;
    private String topic;
    private String content;

    public Article(Integer article_Id, String topic, String content) {
        this.article_Id = article_Id;
        this.topic = topic;
        this.content = content;
    }

    public Article() {
		// TODO Auto-generated constructor stub
	}

	//Initializing Getters and Setters
    public Integer getArticle_Id() { return article_Id; }
    public void setArticle_Id(Integer article_Id) { this.article_Id = article_Id; }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    
    
    
    public void display() {
        System.out.println("Article Details");
        System.out.println("Article Id: " + article_Id);
        System.out.println("topic: " + topic);
        System.out.println("content: " + content);
     
        return;
        
    }

    public String getMeta() {
        return "( topic, content)";
    }

    public String toString() {
        String res = "(";
      
        res = res + "'";
        res = res + topic;
        res = res + "'";
        res = res + ",";
        res = res + "'";
        res = res + content;
        res = res + "'";
        res = res + ")";
        return res;
    }
}