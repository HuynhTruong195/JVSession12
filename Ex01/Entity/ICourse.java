package Ex01.Entity;

import java.util.Scanner;

public class ICourse implements IApp {
    private String courseId;
    private String courseName;
    private int credits;

    public ICourse() {
    }

    public ICourse(String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập mã môn học");
        courseId = scanner.nextLine();
        System.out.println("Nhập tên môn học");
        courseName = scanner.nextLine();
        System.out.println("Nhập số tín chỉ");
        credits = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "Course [id=" + courseId + ", name=" + courseName + ", credits=" + credits + "]";
    }
}
