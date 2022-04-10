package main.java.wolfpub.dbobject;
public class Article
{
    private Integer Article_ID;
    private String Topic;
    private String Content;

    public Article(Integer article_ID, String topic, String content) {
        this.Article_ID = article_ID;
        this.Topic = topic;
        this.Content = content;
    }

    public Article() {
		// TODO Auto-generated constructor stub
	}

	//Initializing Getters and Setters
    public Integer getArticle_ID() { return Article_ID; }
    public void setArticle_ID(Integer article_ID) { this.Article_ID = article_ID; }

    public String getTopic() { return Topic; }
    public void setTopic(String topic) { this.Topic = topic; }

    public String getContent() { return Content; }
    public void setContent(String content) { this.Content = content; }
    
    
    
    
    public void display() {
        System.out.println("Article Details");
        System.out.println("Article Id: " + Article_ID);
        System.out.println("Topic: " + Topic);
        System.out.println("Content: " + Content);
     
        return;
        
    }

    public String getMeta() {
        return "( topic, content)";
    }

    public String toString() {
        String res = "(";
      
        res = res + "'";
        res = res + Topic;
        res = res + "'";
        res = res + ",";
        res = res + "'";
        res = res + Content;
        res = res + "'";
        res = res + ")";
        return res;
    }
}