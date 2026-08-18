package training.main;

import training.entity.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CourseManagement {
    private ArrayList<Course> courses;

    public CourseManagement() {
        this.courses = new ArrayList<>();
    }

    private void input(Scanner sc) {
        System.out.println("\n--- THÊM KHÓA HỌC MỚI ---");
        Course course = new Course();
        course.input(sc, courses);
        courses.add(course);
        System.out.println("Thêm khóa học thành công!");
    }

    private ArrayList<Course> search(String type, Object data) {
        ArrayList<Course> results = new ArrayList<>();
        if (type == null || data == null) {
            return results;
        }

        String searchStr = data.toString().trim();

        Map<String, Course> courseMapByCode = new HashMap<>();
        for (Course course : courses) {
            if (course.getCode() != null) {
                courseMapByCode.put(course.getCode().toUpperCase(), course);
            }
        }

        switch (type.toLowerCase()) {
            case "code":
                Course foundCourse = courseMapByCode.get(searchStr.toUpperCase());
                if (foundCourse != null) {
                    results.add(foundCourse);
                }
                break;

            case "name":
                for (Course course : courses) {
                    if (course.getName() != null && 
                       (course.getName().equalsIgnoreCase(searchStr) || course.getName().toLowerCase().contains(searchStr.toLowerCase()))) {
                        results.add(course);
                    }
                }
                break;

            case "status":
                boolean statusBool;
                if (data instanceof Boolean) {
                    statusBool = (Boolean) data;
                } else {
                    statusBool = searchStr.equalsIgnoreCase("true") || searchStr.equalsIgnoreCase("active");
                }
                for (Course course : courses) {
                    if (course.isStatus() == statusBool) {
                        results.add(course);
                    }
                }
                break;

            case "duration":
                try {
                    short dur = Short.parseShort(searchStr);
                    for (Course course : courses) {
                        if (course.getDuration() == dur) {
                            results.add(course);
                        }
                    }
                } catch (NumberFormatException e) {
                }
                break;

            case "flag":
                for (Course course : courses) {
                    if (course.getFlag() != null && course.getFlag().equalsIgnoreCase(searchStr)) {
                        results.add(course);
                    }
                }
                break;
        }

        return results;
    }

    private void displayAll(String flag) {
        if (flag == null || flag.trim().isEmpty()) {
            System.out.println("Flag không được để trống.");
            return;
        }

        System.out.println("\n--- DANH SÁCH KHÓA HỌC CÓ FLAG '" + flag + "' ---");
        boolean found = false;
        for (Course course : courses) {
            if (course.getFlag() != null && course.getFlag().equalsIgnoreCase(flag.trim())) {
                System.out.println(course);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy khóa học nào có flag: " + flag);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseManagement management = new CourseManagement();
        String choice = "";

        do {
            System.out.println("\n================ QUẢN LÝ KHÓA HỌC ================");
            System.out.println("1. Tạo khóa học và nhập dữ liệu từ bàn phím");
            System.out.println("2. Tìm kiếm khóa học theo thuộc tính");
            System.out.println("3. Hiển thị tất cả khóa học theo flag");
            System.out.println("4. Thoát");
            System.out.print("Vui lòng chọn chức năng (1-4): ");

            choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    management.input(sc);
                    break;
                case "2":
                    if (management.courses.isEmpty()) {
                        System.out.println("Chưa có khóa học nào trong danh sách!");
                        break;
                    }
                    System.out.println("\n--- TÌM KIẾM KHÓA HỌC ---");
                    System.out.print("Nhập tên thuộc tính cần tìm (code/name/status/duration/flag): ");
                    String attribute = sc.nextLine().trim();
                    System.out.print("Nhập giá trị cần tìm: ");
                    String searchVal = sc.nextLine().trim();

                    ArrayList<Course> searchResults = management.search(attribute, searchVal);
                    if (searchResults.isEmpty()) {
                        System.out.println("Không tìm thấy khóa học phù hợp.");
                    } else {
                        System.out.println("Tìm thấy " + searchResults.size() + " khóa học:");
                        for (Course c : searchResults) {
                            System.out.println(c);
                        }
                    }
                    break;
                case "3":
                    if (management.courses.isEmpty()) {
                        System.out.println("Chưa có khóa học nào!");
                        break;
                    }
                    System.out.print("Nhập cờ flag để lọc ('optional', 'prerequisite', 'N/A'): ");
                    String inputFlag = sc.nextLine().trim();
                    management.displayAll(inputFlag);
                    break;
                case "4":
                    System.out.println("Đã thoát chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn 1, 2, 3 hoặc 4.");
                    break;
            }
        } while (!choice.equals("4"));
    }
}
