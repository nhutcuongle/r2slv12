package training.utils;

import training.entity.Course;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static boolean validateCode(String code) {
        if (code == null) {
            return false;
        }
        return code.matches("^RA\\d{3}$");
    }

    public static boolean isDuplicatedCode(String code, ArrayList<Course> courses) {
        if (code == null || courses == null) {
            return false;
        }
        Set<String> codeSet = new HashSet<>();
        for (Course course : courses) {
            if (course.getCode() != null) {
                codeSet.add(course.getCode().toUpperCase());
            }
        }
        return codeSet.contains(code.toUpperCase());
    }

    public static boolean validateStatus(boolean status) {
        return true;
    }

    public static boolean validateFlag(String flag) {
        if (flag == null) {
            return false;
        }
        return flag.equalsIgnoreCase("optional") || 
               flag.equalsIgnoreCase("prerequisite") || 
               flag.equalsIgnoreCase("N/A");
    }

    public static boolean validateDuration(short duration) {
        return duration > 0;
    }
}
