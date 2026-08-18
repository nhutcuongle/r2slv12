package training.entity;

import training.utils.Validator;
import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    private String code;
    private String name;
    private boolean status;
    private short duration;
    private String flag;

    public Course() {
    }

    public Course(String code, String name, boolean status, short duration, String flag) {
        this.code = code;
        this.name = name;
        this.status = status;
        this.duration = duration;
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void input(Scanner sc, ArrayList<Course> courses) {
        while (true) {
            System.out.print("Nhập mã khóa học (dạng RAxxx, ví dụ RA123): ");
            String inputCode = sc.nextLine().trim();
            if (!Validator.validateCode(inputCode)) {
                System.out.println("Mã không hợp lệ! Mã phải bắt đầu bằng 'RA' và theo sau là 3 chữ số.");
                continue;
            }
            if (Validator.isDuplicatedCode(inputCode, courses)) {
                System.out.println("Mã khóa học bị trùng lặp! Vui lòng nhập mã khác.");
                continue;
            }
            this.code = inputCode;
            break;
        }

        while (true) {
            System.out.print("Nhập tên khóa học: ");
            String inputName = sc.nextLine().trim();
            if (inputName.isEmpty()) {
                System.out.println("Tên khóa học không được để trống!");
                continue;
            }
            this.name = inputName;
            break;
        }

        while (true) {
            System.out.print("Nhập trạng thái (true: hoạt động / false: không hoạt động): ");
            String inputStatus = sc.nextLine().trim();
            if (inputStatus.equalsIgnoreCase("true") || inputStatus.equalsIgnoreCase("false")) {
                this.status = Boolean.parseBoolean(inputStatus);
                break;
            } else {
                System.out.println("Trạng thái không hợp lệ! Vui lòng nhập 'true' hoặc 'false'.");
            }
        }

        while (true) {
            System.out.print("Nhập thời lượng (số dương > 0): ");
            try {
                short inputDuration = Short.parseShort(sc.nextLine().trim());
                if (!Validator.validateDuration(inputDuration)) {
                    System.out.println("Thời lượng phải lớn hơn 0!");
                    continue;
                }
                this.duration = inputDuration;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Thời lượng không hợp lệ! Vui lòng nhập số kiểu short.");
            }
        }

        while (true) {
            System.out.print("Nhập cờ flag ('optional', 'prerequisite', 'N/A'): ");
            String inputFlag = sc.nextLine().trim();
            if (!Validator.validateFlag(inputFlag)) {
                System.out.println("Flag không hợp lệ! Chỉ chấp nhận: 'optional', 'prerequisite', 'N/A'.");
                continue;
            }
            this.flag = inputFlag;
            break;
        }
    }

    @Override
    public String toString() {
        return String.format("Course [Mã=%s, Tên=%s, Trạng thái=%s (%s), Thời lượng=%d, Flag=%s]",
                code, name, status, (status ? "hoạt động" : "không hoạt động"), duration, flag);
    }
}
