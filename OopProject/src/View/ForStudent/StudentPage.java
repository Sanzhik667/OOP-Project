package View.ForStudent;

/**
 * <!-- begin-user-doc -->

 * <!--  end-user-doc  -->
 * @generated
 */

<<<<<<< HEAD
import java.util.Scanner;
import java.util.Map;

=======
import Data.Organizations;
import Data.Data;
import Enums.OrganizationName;
>>>>>>> branch 'master' of https://github.com/Sanzhik667/OOP-Project.git
import System.ProjectSystem;
import Users.Student;
import Users.User;
<<<<<<< HEAD
import Data.News;

=======
import Users.News;

import java.util.List;
import java.util.Scanner;
>>>>>>> branch 'master' of https://github.com/Sanzhik667/OOP-Project.git

public class StudentPage extends ProjectSystem {
<<<<<<< HEAD
	private String studentName;
	private Map<String Map<String, Integer>> marksDataBase;
    public StudentPage(User currentUser, Map<String Map<String, Integer>> marksDataBase, String studentName) {
=======

    private Student currentStudent;
    private List<Organizations> organizationsList;

    public StudentPage(User currentUser) {
>>>>>>> branch 'master' of https://github.com/Sanzhik667/OOP-Project.git
        super(currentUser);
<<<<<<< HEAD
        this.marksDataBase = marksDataBase;
        this.studentName = currentUser.getFirstName()
=======
        this.currentStudent = (Student) currentUser;
        this.organizationsList = Organizations.loadOrganizations();
>>>>>>> branch 'master' of https://github.com/Sanzhik667/OOP-Project.git
    }

    @Override
    public void handleUserActions() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("1. View Courses");
            System.out.println("2. View Transcript");
<<<<<<< HEAD
            System.out.println("3. Show News")
            System.out.println("4. Go Back");
=======
            System.out.println("3. Manage Organizations");
            System.out.println("4. Show News");
            System.out.println("5. Go Back");
>>>>>>> branch 'master' of https://github.com/Sanzhik667/OOP-Project.git
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewCourses();
                    break;
                case 2:
                    viewTranscript();
                    break;
                case 3:
                    manageOrganizations();
                    break;
                case 4:
                    showNews();
                    break;
                case 5:
                    isRunning = false; // Выход из текущего меню
                    goBack();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void goBack() {
        // TODO Auto-generated method stub
    }

    private void viewCourses() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("** View Courses **");
            System.out.println("1. List All Courses");
            System.out.println("2. Search for a Course");
            System.out.println("3. Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listAllCourses();
                    break;
                case 2:
                    searchForCourse();
                    break;
                case 3:
                    isRunning = false; // Возврат в основное меню
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void listAllCourses() {
        System.out.println("Displaying all courses...");
        // Здесь можно реализовать логику вывода списка курсов из базы данных.
        System.out.println("1. Programming Basics");
        System.out.println("2. Data Structures");
        System.out.println("3. Algorithms");
        System.out.println("Press Enter to go back...");
        new Scanner(System.in).nextLine(); // Ждём нажатия Enter, чтобы вернуться
    }

    private void searchForCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course name to search: ");
        String courseName = scanner.nextLine();
        // Здесь можно реализовать логику поиска курсов в базе данных.
        System.out.println("Searching for course: " + courseName);
        System.out.println("No results found. (Stub)");
        System.out.println("Press Enter to go back...");
        scanner.nextLine(); // Ждём нажатия Enter, чтобы вернуться
    }

    private void viewTranscript() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("** View Transcript **");
            System.out.println("1. View Marks");
            System.out.println("2. Download Transcript");
            System.out.println("3. Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ViewMarks();
                    break;
                case 2:
                	DownloadTranscript();
                case 3:
                    isRunning = false; // Возврат в основное меню
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void viewMarks() {
        System.out.println("\n--YOUR MARKS--");
        Map<String Map<String, Integer>> studentMarks = marksDataBase.get(studentFirstName);
        if(studentMarks == null || studentMarks.isEmpty()) {
        	System.out.println("No marks available :(");
        }
        else {
        	System.out.println("SUBJECT | GRADE | LETTER GRADE");
        	System.out.println("-------------------------");
        	int totalCount = 0;
        	int subjectCount = 0;
        	for(Map.Entry<String, Integer> : studentMarks.entrySet()) {
        		String course = entry.getKey();
        		int mark = entry.getValue();
        		String LetterGrade = entry.getLetterGrade();
        		String.out.println(course + " | " + mark + " | " + letterGrade);
        		totalMark += mark;
        		subjectCount++;
        	}
        	double average = (double) totalCount/subjectCount;
        	System.out.println("Average grade: " + average);
        }
        new Scanner(System.in).nextLine(); // Ждём нажатия Enter, чтобы вернуться
    }
    private String getLetterGrade() {
    	if(mark >= 95 && mark <= 100) {
    		return "A";
    	}
    	else if(mark >= 90 && mark <= 94) {
    		return "A-";
    	}
    	else if(mark >= 85 && mark <= 89) {
    		return "B+";
    	}
    	else if(mark >= 80 && mark <= 84) {
    		return "B";
    	}
    	else if(mark >= 75 && mark <= 79) {
    		return "B-";
    	}
    	else if(mark >= 70 && mark <= 74) {
    		return "C+";
    	}
    	else if(mark >= 65 && mark <= 69) {
    		return "C";
    	}
    	else if(mark >= 60 && mark <= 64) {
    		return "C-";
    	}
    	else if(mark >= 55 && mark <= 59) {
    		return "D+";
    	}
    	else if(mark >= 50 && mark <= 54) {
    		return "D";
    	}
    	else if(mark >= 25 && mark <= 49) {
    		return "FX";
    	}
    	else if(mark >= 0 && mark <= 24) {
    		return "F";
    	}
    }
    private void DownloadTranscript() {
    	System.out.println("Transcript downloading ...");
    	int length = 20;
		for(int i = 0; i < length; i++) {
			System.out.print("_");
			try {
				Thread.sleep(150);
			}
			catch(InterruptedException e){
				e.printStackTrace();
				System.out.print("Downloading faild!");
			}
		}
		System.out.println("Transcript downloaded seccessfully!");
    }

    public void showNews() {
<<<<<<< HEAD
		if(News.isEmpty()){
			System.out.println("There is no news.");
		}
		else {
			System.out.println("Latest news: ");
			for(News news : News) {
				System.out.println(news);
			}
		}
	}
    
    
=======
        if (Data.Newss.isEmpty()) {
            System.out.println("There is no news.");
        } else {
            System.out.println("Latest news: ");
            for (News news : Data.Newss) {
                System.out.println(news);
            }
        }
    }

    // Методы для управления организациями
    private void manageOrganizations() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("** Manage Organizations **");
            System.out.println("1. Join Organization");
            System.out.println("2. Leave Organization");
            System.out.println("3. Become Organization Leader");
            System.out.println("4. View My Organizations");
            System.out.println("5. Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    joinOrganization(scanner);
                    break;
                case 2:
                    leaveOrganization(scanner);
                    break;
                case 3:
                    becomeLeader(scanner);
                    break;
                case 4:
                    viewMyOrganizations();
                    break;
                case 5:
                    isRunning = false; // Возврат в основное меню
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void joinOrganization(Scanner scanner) {
        System.out.println("Available Organizations:");
        for (OrganizationName name : OrganizationName.values()) {
            System.out.println("- " + name);
        }
        System.out.print("Enter the organization name to join: ");
        String orgName = scanner.nextLine().toUpperCase();

        try {
            OrganizationName organizationName = OrganizationName.valueOf(orgName);
            Organizations org = findOrganizationByName(organizationName);
            currentStudent.joinOrganization(org);
            Organizations.saveOrganizations(organizationsList);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid organization name.");
        }
    }

    private void leaveOrganization(Scanner scanner) {
        System.out.print("Enter the organization name to leave: ");
        String orgName = scanner.nextLine().toUpperCase();

        try {
            OrganizationName organizationName = OrganizationName.valueOf(orgName);
            Organizations org = findOrganizationByName(organizationName);
            currentStudent.leaveOrganization(org);
            Organizations.saveOrganizations(organizationsList);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid organization name.");
        }
    }

    private void becomeLeader(Scanner scanner) {
        System.out.print("Enter the organization name to become a leader: ");
        String orgName = scanner.nextLine().toUpperCase();

        try {
            OrganizationName organizationName = OrganizationName.valueOf(orgName);
            Organizations org = findOrganizationByName(organizationName);
            currentStudent.becomeLeader(org);
            Organizations.saveOrganizations(organizationsList);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid organization name.");
        }
    }

    private void viewMyOrganizations() {
        System.out.println("Your Organizations:");
        for (OrganizationName orgName : currentStudent.getOrganizations()) {
            System.out.println("- " + orgName);
        }
    }

    private Organizations findOrganizationByName(OrganizationName name) {
        for (Organizations org : organizationsList) {
            if (org.getOrganizationName() == name) {
                return org;
            }
        }
        Organizations newOrg = new Organizations(name);
        organizationsList.add(newOrg);
        return newOrg;
    }
>>>>>>> branch 'master' of https://github.com/Sanzhik667/OOP-Project.git
}
