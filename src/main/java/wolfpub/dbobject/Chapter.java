package main.java.wolfpub.dbobject;

public class Chapter
{
    private Integer publication_Id;
    private Integer chapter_Id;
    private String chapter_Text;

    public Chapter(Integer publication_Id, Integer chapter_Id, String chapter_Text)
    {
        this.publication_Id = publication_Id;
        this.chapter_Id = chapter_Id;
        this.chapter_Text = chapter_Text;
    }

    public Chapter() {
		// TODO Auto-generated constructor stub
	}

	//Initializing Getters and Setters
    public Integer getPublication_Id() { return publication_Id; }
    public void setPublication_Id(Integer publication_Id) { this.publication_Id = publication_Id; }

    public Integer getChapter_Id() { return chapter_Id; }
    public void setChapter_Id(Integer chapter_Id) { this.chapter_Id = chapter_Id; }

    public String getChapter_Text() { return chapter_Text; }
    public void setChapter_Text(String chapter_Text) { this.chapter_Text = chapter_Text; }
    
	public void display() {
        System.out.println("Chapter Details");
        System.out.println("Publication ID: " + publication_Id);
        System.out.println("Chapter ID: " + chapter_Id);
        System.out.println("Text: " + chapter_Text);
     
        return;
        
    }

    public String getMeta() {
        return "( publication_Id, chapter_Id, chapter_Text)";
    }

    public String toString() {
        String res = "(";
        res = res + "'";
        res = res + publication_Id;
        res = res + "'";
        res = res + ",";
        res = res + "'";
        res = res + chapter_Id;
        res = res + "'";
        res = res + ",";
        res = res + "'";
        res = res + chapter_Text;
        res = res + "'";
        res = res + ")";
        return res;
    }
	
}