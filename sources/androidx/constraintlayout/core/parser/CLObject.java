package androidx.constraintlayout.core.parser;

import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class CLObject extends CLContainer implements Iterable<CLKey> {

    private class CLObjectIterator implements Iterator {
        int X = 0;
        CLObject s;

        public CLObjectIterator(CLObject cLObject) {
            this.s = cLObject;
        }

        public boolean hasNext() {
            return this.X < this.s.size();
        }

        public Object next() {
            CLKey cLKey = (CLKey) this.s.a3.get(this.X);
            this.X++;
            return cLKey;
        }
    }

    public CLObject(char[] cArr) {
        super(cArr);
    }

    public static CLObject k0(char[] cArr) {
        return new CLObject(cArr);
    }

    public String D(int i2, int i3) {
        StringBuilder sb = new StringBuilder(g());
        sb.append("{\n");
        Iterator<CLElement> it2 = this.a3.iterator();
        boolean z = true;
        while (it2.hasNext()) {
            CLElement next = it2.next();
            if (!z) {
                sb.append(",\n");
            } else {
                z = false;
            }
            sb.append(next.D(CLElement.Z2 + i2, i3 - 1));
        }
        sb.append(StringUtils.LF);
        b(sb, i2);
        sb.append("}");
        return sb.toString();
    }

    public String E() {
        StringBuilder sb = new StringBuilder(g() + "{ ");
        Iterator<CLElement> it2 = this.a3.iterator();
        boolean z = true;
        while (it2.hasNext()) {
            CLElement next = it2.next();
            if (!z) {
                sb.append(", ");
            } else {
                z = false;
            }
            sb.append(next.E());
        }
        sb.append(" }");
        return sb.toString();
    }

    public Iterator iterator() {
        return new CLObjectIterator(this);
    }

    public String l0() {
        return D(0, 0);
    }
}
