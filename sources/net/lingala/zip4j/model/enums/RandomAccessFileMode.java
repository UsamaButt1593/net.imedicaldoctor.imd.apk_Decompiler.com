package net.lingala.zip4j.model.enums;

public enum RandomAccessFileMode {
    READ("r"),
    WRITE("rw");
    
    private String s;

    private RandomAccessFileMode(String str) {
        this.s = str;
    }

    public String a() {
        return this.s;
    }
}
