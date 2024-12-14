package Users.Researcher;

import java.util.Comparator;
import java.util.List;

public interface Researcher {
	void conductResearch();
    void publishPaper(ResearchPaper paper);
    List<ResearchPaper> getResearchPapers();
    void printPapers(Comparator<ResearchPaper> comparator);
    int calculateHIndex();
	void printPapers();
	
	
}
