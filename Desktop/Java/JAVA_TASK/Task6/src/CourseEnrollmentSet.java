import java.util.HashSet;
import java.util.Scanner;

///
public class CourseEnrollmentSet {
    public static void main(String[] args) {


        HashSet<String> CourseNameSet = new HashSet<>();
        Scanner ce = new Scanner(System.in);
        System.out.println("Enter number of courses:");
        int courses = ce.nextInt();
        ce.nextLine();
        String removeresult;
        String coursetotalClassification;
        String coursename = "";
        String courseremove;


        if (courses <= 0) {
            System.out.println("Invalid number of courses.");

        }else{

                for (int i = 1; i <= courses; i++) {

                    System.out.println("Enter course name:");
                    coursename = ce.nextLine();

                    if (!CourseNameSet.add(coursename)) {
                        System.out.println("Course already exists. Duplicate entries are not allowed.");
                        i = i - 1;
                    }
                }
                System.out.println("Enter the name of a course to remove:");
                 courseremove = ce.nextLine();

                if (CourseNameSet.remove(courseremove)){
                     removeresult = "Course removed successfully";
                } else {
                    removeresult = "Course not found.";
                }
                int totalcourse = CourseNameSet.size();
                if ( totalcourse < 4 ){
                    coursetotalClassification = "Small Course Catalog ";
                } else if ( totalcourse <= 8) {
                    coursetotalClassification = " Medium Course Catalog ";
                }else {
                    coursetotalClassification = "Large Course Catalog";
                }

                System.out.println("Total courses entered:"+ courses);
                System.out.println("Total unique courses remaining:"+ totalcourse);
                System.out.println("All remaining course names:"+ coursename);
                System.out.println("Removal result:"+ courseremove);
                System.out.println("Course catalog classification:"+ coursetotalClassification);

        }ce.close();
        }
    }
