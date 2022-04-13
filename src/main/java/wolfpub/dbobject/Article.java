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

    @Override
    public String toString() {
        return "Article{" +
                "Article_ID=" + Article_ID +
                ", Topic='" + Topic + '\'' +
                ", Content='" + Content + '\'' +
                '}';
    }

    //Initializing Getters and Setters
    public Integer getArticle_ID() { return Article_ID; }
    public void setArticle_ID(Integer article_ID) { this.Article_ID = article_ID; }

    public String getTopic() { return Topic; }
    public void setTopic(String topic) { this.Topic = topic; }

    public String getContent() { return Content; }
    public void setContent(String content) { this.Content = content; }
}
