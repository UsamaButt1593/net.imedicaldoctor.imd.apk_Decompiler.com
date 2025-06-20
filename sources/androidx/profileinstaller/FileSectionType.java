package androidx.profileinstaller;

enum FileSectionType {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);
    
    private final long s;

    private FileSectionType(long j2) {
        this.s = j2;
    }

    static FileSectionType b(long j2) {
        FileSectionType[] values = values();
        for (int i2 = 0; i2 < values.length; i2++) {
            if (values[i2].c() == j2) {
                return values[i2];
            }
        }
        throw new IllegalArgumentException("Unsupported FileSection Type " + j2);
    }

    public long c() {
        return this.s;
    }
}
