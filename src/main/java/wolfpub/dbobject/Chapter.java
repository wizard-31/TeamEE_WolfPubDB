package main.java.wolfpub.dbobject;

public class Chapter
{
    private Integer Publication_ID;
    private Integer Chapter_ID;
    private String Chapter_text;
  
    public Chapter(Integer publication_ID, Integer chapter_ID, String chapter_text)
    {
        this.Publication_ID = publication_ID;
        this.Chapter_ID = chapter_ID;
        this.Chapter_text = chapter_text;
    }
    
  
    public Chapter() 
    {
		  // TODO Auto-generated constructor stub
	  }

  //Initializing Getters and Setters
    public Integer getPublication_ID() { return Publication_ID; }
    public void setPublication_ID(Integer publication_ID) { this.Publication_ID = publication_ID; }

    public Integer getChapter_ID() { return Chapter_ID; }
    public void setChapter_ID(Integer chapter_ID) { this.Chapter_ID = chapter_ID; }

    public String getChapter_text() { return Chapter_text; }
    public void setChapter_text(String chapter_text) { this.Chapter_text = chapter_text; }
    
	  public void display() {
        System.out.println("Chapter Details");
        System.out.println("Publication ID: " + Publication_ID);
        System.out.println("Chapter ID: " + Chapter_ID);
        System.out.println("Text: " + Chapter_text);
     
        return;
    }

    public String getMeta() {
        return "( publication_Id, chapter_Id, chapter_Text)";
    }
  
    @Override
    public String toString() {
        String res = "(";
        res = res + "'";
        res = res + Publication_ID;
        res = res + "'";
        res = res + ",";
        res = res + "'";
        res = res + Chapter_ID;
        res = res + "'";
        res = res + ",";
        res = res + "'";
        res = res + Chapter_text;
        res = res + "'";
        res = res + ")";
        return res;
    }
	
}