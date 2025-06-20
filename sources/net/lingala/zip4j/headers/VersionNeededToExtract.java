package net.lingala.zip4j.headers;

public enum VersionNeededToExtract {
    DEFAULT(10),
    DEFLATE_COMPRESSED(20),
    ZIP_64_FORMAT(45),
    AES_ENCRYPTED(51);
    
    private int s;

    private VersionNeededToExtract(int i2) {
        this.s = i2;
    }

    public int a() {
        return this.s;
    }
}
