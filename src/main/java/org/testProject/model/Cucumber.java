package org.testProject.model;

import org.testProject.enums.SizeCategory;

import java.util.Random;
import java.util.UUID;

public class Cucumber {

    private static int MAX_SIZE = 10;
    private static Random random = new Random();
    private static String DEFAULT_ADDRESS = "Address 1";

    private String uid;
    private int size;
    private SizeCategory sizeCategory;
    private int pimpleCount;
    private String address;

    public Cucumber() {
        this.uid = UUID.randomUUID().toString();
        this.size = random.nextInt(1, MAX_SIZE);
        this.sizeCategory = SizeCategory.getCategory(this.size);
        this.pimpleCount = random.nextInt(100);
        this.address = DEFAULT_ADDRESS;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public SizeCategory getSizeCategory() {
        return sizeCategory;
    }

    public void setSizeCategory(SizeCategory sizeCategory) {
        this.sizeCategory = sizeCategory;
    }

    public int getPimpleCount() {
        return pimpleCount;
    }

    public void setPimpleCount(int pimpleCount) {
        this.pimpleCount = pimpleCount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
