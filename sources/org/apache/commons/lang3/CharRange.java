package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class CharRange implements Iterable<Character>, Serializable {
    private static final long serialVersionUID = 8270183163158333422L;
    /* access modifiers changed from: private */
    public final char end;
    private transient String iToString;
    /* access modifiers changed from: private */
    public final boolean negated;
    /* access modifiers changed from: private */
    public final char start;

    private static class CharacterIterator implements Iterator<Character> {
        private char current;
        private boolean hasNext;
        private final CharRange range;

        private CharacterIterator(CharRange charRange) {
            char access$200;
            this.range = charRange;
            this.hasNext = true;
            if (!charRange.negated) {
                access$200 = charRange.start;
            } else if (charRange.start != 0) {
                this.current = 0;
                return;
            } else if (charRange.end == 65535) {
                this.hasNext = false;
                return;
            } else {
                access$200 = (char) (charRange.end + 1);
            }
            this.current = access$200;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
            if (r4.current < org.apache.commons.lang3.CharRange.access$300(r4.range)) goto L_0x0032;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void prepareNext() {
            /*
                r4 = this;
                org.apache.commons.lang3.CharRange r0 = r4.range
                boolean r0 = r0.negated
                r1 = 0
                if (r0 == 0) goto L_0x0035
                char r0 = r4.current
                r2 = 65535(0xffff, float:9.1834E-41)
                if (r0 != r2) goto L_0x0013
            L_0x0010:
                r4.hasNext = r1
                goto L_0x0040
            L_0x0013:
                int r0 = r0 + 1
                org.apache.commons.lang3.CharRange r3 = r4.range
                char r3 = r3.start
                if (r0 != r3) goto L_0x0032
                org.apache.commons.lang3.CharRange r0 = r4.range
                char r0 = r0.end
                if (r0 != r2) goto L_0x0026
                goto L_0x0010
            L_0x0026:
                org.apache.commons.lang3.CharRange r0 = r4.range
                char r0 = r0.end
            L_0x002c:
                int r0 = r0 + 1
                char r0 = (char) r0
                r4.current = r0
                goto L_0x0040
            L_0x0032:
                char r0 = r4.current
                goto L_0x002c
            L_0x0035:
                char r0 = r4.current
                org.apache.commons.lang3.CharRange r2 = r4.range
                char r2 = r2.end
                if (r0 >= r2) goto L_0x0010
                goto L_0x0032
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.CharRange.CharacterIterator.prepareNext():void");
        }

        public boolean hasNext() {
            return this.hasNext;
        }

        public Character next() {
            if (this.hasNext) {
                char c2 = this.current;
                prepareNext();
                return Character.valueOf(c2);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private CharRange(char c2, char c3, boolean z) {
        if (c2 > c3) {
            char c4 = c3;
            c3 = c2;
            c2 = c4;
        }
        this.start = c2;
        this.end = c3;
        this.negated = z;
    }

    public static CharRange is(char c2) {
        return new CharRange(c2, c2, false);
    }

    public static CharRange isIn(char c2, char c3) {
        return new CharRange(c2, c3, false);
    }

    public static CharRange isNot(char c2) {
        return new CharRange(c2, c2, true);
    }

    public static CharRange isNotIn(char c2, char c3) {
        return new CharRange(c2, c3, true);
    }

    public boolean contains(char c2) {
        return (c2 >= this.start && c2 <= this.end) != this.negated;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharRange)) {
            return false;
        }
        CharRange charRange = (CharRange) obj;
        return this.start == charRange.start && this.end == charRange.end && this.negated == charRange.negated;
    }

    public char getEnd() {
        return this.end;
    }

    public char getStart() {
        return this.start;
    }

    public int hashCode() {
        return this.start + 'S' + (this.end * 7) + (this.negated ? 1 : 0);
    }

    public boolean isNegated() {
        return this.negated;
    }

    public Iterator<Character> iterator() {
        return new CharacterIterator();
    }

    public String toString() {
        if (this.iToString == null) {
            StringBuilder sb = new StringBuilder(4);
            if (isNegated()) {
                sb.append('^');
            }
            sb.append(this.start);
            if (this.start != this.end) {
                sb.append('-');
                sb.append(this.end);
            }
            this.iToString = sb.toString();
        }
        return this.iToString;
    }

    public boolean contains(CharRange charRange) {
        if (charRange != null) {
            return this.negated ? charRange.negated ? this.start >= charRange.start && this.end <= charRange.end : charRange.end < this.start || charRange.start > this.end : charRange.negated ? this.start == 0 && this.end == 65535 : this.start <= charRange.start && this.end >= charRange.end;
        }
        throw new IllegalArgumentException("The Range must not be null");
    }
}
