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

    @Override
    public String toString() {
        return "Chapter{" +
                "Publication_ID=" + Publication_ID +
                ", Chapter_ID=" + Chapter_ID +
                ", Chapter_text='" + Chapter_text + '\'' +
                '}';
    }

    //Initializing Getters and Setters
    public Integer getPublication_ID() { return Publication_ID; }
    public void setPublication_ID(Integer publication_ID) { this.Publication_ID = publication_ID; }

    public Integer getChapter_ID() { return Chapter_ID; }
    public void setChapter_ID(Integer chapter_ID) { this.Chapter_ID = chapter_ID; }

    public String getChapter_text() { return Chapter_text; }
    public void setChapter_text(String chapter_text) { this.Chapter_text = chapter_text; }
}
