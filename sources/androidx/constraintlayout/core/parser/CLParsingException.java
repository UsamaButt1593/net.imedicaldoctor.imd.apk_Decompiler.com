package androidx.constraintlayout.core.parser;

public class CLParsingException extends Exception {
    private final int X;
    private final String Y;
    private final String s;

    public CLParsingException(String str, CLElement cLElement) {
        int i2;
        this.s = str;
        if (cLElement != null) {
            this.Y = cLElement.o();
            i2 = cLElement.m();
        } else {
            this.Y = "unknown";
            i2 = 0;
        }
        this.X = i2;
    }

    public String a() {
        return this.s + " (" + this.Y + " at line " + this.X + ")";
    }

    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + a();
    }
}
