package net.lingala.zip4j.headers;

public enum HeaderSignature {
    LOCAL_FILE_HEADER(67324752),
    EXTRA_DATA_RECORD(134695760),
    CENTRAL_DIRECTORY(33639248),
    END_OF_CENTRAL_DIRECTORY(101010256),
    DIGITAL_SIGNATURE(84233040),
    ARCEXTDATREC(134630224),
    SPLIT_ZIP(134695760),
    ZIP64_END_CENTRAL_DIRECTORY_LOCATOR(117853008),
    ZIP64_END_CENTRAL_DIRECTORY_RECORD(101075792),
    ZIP64_EXTRA_FIELD_SIGNATURE(1),
    AES_EXTRA_DATA_RECORD(39169);
    
    private long s;

    private HeaderSignature(long j2) {
        this.s = j2;
    }

    public long a() {
        return this.s;
    }
}
