package Users.Researcher;

import Users.User;

public class ResearcherDecorator extends User {
    private User user;

    public ResearcherDecorator(User user) {
        super(user); // Скопировать данные пользователя
        this.setUser(user);
    }
    public void printResearchPapers() {
        // Логика печати научных работ
    }
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}

