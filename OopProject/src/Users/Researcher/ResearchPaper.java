package Users.Researcher;

import java.util.Comparator;
import java.util.List;

import Users.ResearchPaper;

public class ResearchPaper {
	private String title;
    private List<String> authors;
    private String journal;
    private Date date;
    private int citations;
    private int pages;
    private String doi;
    public ResearchPaper(String title, List<String> authors, String journal, Date date, int citations, int pages, String doi) {
        this.title = title;
        this.authors = authors;
        this.journal = journal;
        this.date = date;
        this.citations = citations;
        this.pages = pages;
        this.doi = doi;
    }

    // Getter for citations
    public int getCitations() {
        return citations;
    }

    // toString method for formatted output
    @Override
    public String toString() {
        return "Title: " + title + "\nAuthors: " + authors + "\nJournal: " + journal +
               "\nDate: " + date + "\nCitations: " + citations + "\nPages: " + pages + "\nDOI: " + doi;
    }
}

//Custom Exception for low h-index
public class LowHIndexException extends Exception {
 public LowHIndexException(String message) {
     super(message);
 }
}



}
