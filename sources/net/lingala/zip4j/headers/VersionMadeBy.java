package net.lingala.zip4j.headers;

public enum VersionMadeBy {
    SPECIFICATION_VERSION((byte) 51),
    WINDOWS((byte) 0),
    UNIX((byte) 3);
    
    private byte s;

    private VersionMadeBy(byte b2) {
        this.s = b2;
    }

    public byte a() {
        return this.s;
    }
}
