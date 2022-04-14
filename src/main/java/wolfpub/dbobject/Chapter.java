package main.java.wolfpub.dbobject;

public class Chapter
{
    private Integer publicationID;
    private Integer chapterID;
    private String chapterText;
  
    public Chapter(Integer publicationID, Integer chapterID, String chapterText)
    {
        this.publicationID = publicationID;
        this.chapterID = chapterID;
        this.chapterText = chapterText;
    }
    
  
    public Chapter() 
    {
		  // TODO Auto-generated constructor stub
	  }

  //Initializing Getters and Setters
    public Integer getPublicationID() { return publicationID; }
    public void setPublicationID(Integer publicationID) { this.publicationID = publicationID; }

    public Integer getChapterID() { return chapterID; }
    public void setChapterID(Integer chapterID) { this.chapterID = chapterID; }

    public String getChapterText() { return chapterText; }
    public void setChapterText(String chapterText) { this.chapterText = chapterText; }
    
	  public void display() {
        System.out.println("Chapter Details");
        System.out.println("Publication ID: " + publicationID);
        System.out.println("Chapter ID: " + chapterID);
        System.out.println("Text: " + chapterText);
        return;
    }

    public String getMeta() {
        return "( publication_Id, chapter_Id, chapter_Text)";
    }
  
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("('").append(publicationID).append("','").append(chapterID).append("','").append(chapterText).append("')");
        return sb.toString();
    }
	
}