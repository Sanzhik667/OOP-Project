package Users.Researcher;

import java.util.Comparator;




//Example Comparator (by citations)
public class CitationComparator implements Comparator<ResearchPaper> {
 @Override
 public int compare(ResearchPaper p1, ResearchPaper p2) {
     return Integer.compare(p2.getCitations(), p1.getCitations()); // Descending order by citations
 }
}