package org.testProject.enums;

public enum SizeCategory {
    SMALL, MIDDLE, LARGE, OMG, NONCATEGORY;

    public static SizeCategory getCategory(int size) {
        if(size <= 3) {
            return SMALL;
        } else if (size <= 5) {
            return MIDDLE;
        } else if (size <= 8) {
            return LARGE;
        } else if (size <=10) {
            return OMG;
        } else {
            return NONCATEGORY;
        }
    }
}
