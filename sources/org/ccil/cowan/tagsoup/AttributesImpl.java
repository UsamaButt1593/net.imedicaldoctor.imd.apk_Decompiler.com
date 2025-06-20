package org.ccil.cowan.tagsoup;

import org.xml.sax.Attributes;

public class AttributesImpl implements Attributes {

    /* renamed from: a  reason: collision with root package name */
    int f31463a;

    /* renamed from: b  reason: collision with root package name */
    String[] f31464b;

    public AttributesImpl() {
        this.f31463a = 0;
        this.f31464b = null;
    }

    private void b(int i2) throws ArrayIndexOutOfBoundsException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Attempt to modify attribute at illegal index: ");
        stringBuffer.append(i2);
        throw new ArrayIndexOutOfBoundsException(stringBuffer.toString());
    }

    private void d(int i2) {
        int i3;
        if (i2 > 0) {
            String[] strArr = this.f31464b;
            if (strArr == null || strArr.length == 0) {
                i3 = 25;
            } else if (strArr.length < i2 * 5) {
                i3 = strArr.length;
            } else {
                return;
            }
            while (i3 < i2 * 5) {
                i3 *= 2;
            }
            String[] strArr2 = new String[i3];
            int i4 = this.f31463a;
            if (i4 > 0) {
                System.arraycopy(this.f31464b, 0, strArr2, 0, i4 * 5);
            }
            this.f31464b = strArr2;
        }
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        d(this.f31463a + 1);
        String[] strArr = this.f31464b;
        int i2 = this.f31463a;
        strArr[i2 * 5] = str;
        strArr[(i2 * 5) + 1] = str2;
        strArr[(i2 * 5) + 2] = str3;
        strArr[(i2 * 5) + 3] = str4;
        strArr[(i2 * 5) + 4] = str5;
        this.f31463a = i2 + 1;
    }

    public void c() {
        if (this.f31464b != null) {
            for (int i2 = 0; i2 < this.f31463a * 5; i2++) {
                this.f31464b[i2] = null;
            }
        }
        this.f31463a = 0;
    }

    public void e(int i2) {
        int i3;
        if (i2 < 0 || i2 >= (i3 = this.f31463a)) {
            b(i2);
            return;
        }
        if (i2 < i3 - 1) {
            String[] strArr = this.f31464b;
            System.arraycopy(strArr, (i2 + 1) * 5, strArr, i2 * 5, ((i3 - i2) - 1) * 5);
        }
        int i4 = this.f31463a;
        int i5 = (i4 - 1) * 5;
        String[] strArr2 = this.f31464b;
        strArr2[i5] = null;
        strArr2[i5 + 1] = null;
        strArr2[i5 + 2] = null;
        strArr2[i5 + 3] = null;
        strArr2[i5 + 4] = null;
        this.f31463a = i4 - 1;
    }

    public void f(int i2, String str, String str2, String str3, String str4, String str5) {
        if (i2 < 0 || i2 >= this.f31463a) {
            b(i2);
            return;
        }
        String[] strArr = this.f31464b;
        int i3 = i2 * 5;
        strArr[i3] = str;
        strArr[i3 + 1] = str2;
        strArr[i3 + 2] = str3;
        strArr[i3 + 3] = str4;
        strArr[i3 + 4] = str5;
    }

    public void g(Attributes attributes) {
        c();
        int length = attributes.getLength();
        this.f31463a = length;
        if (length > 0) {
            this.f31464b = new String[(length * 5)];
            for (int i2 = 0; i2 < this.f31463a; i2++) {
                int i3 = i2 * 5;
                this.f31464b[i3] = attributes.getURI(i2);
                this.f31464b[i3 + 1] = attributes.getLocalName(i2);
                this.f31464b[i3 + 2] = attributes.getQName(i2);
                this.f31464b[i3 + 3] = attributes.getType(i2);
                this.f31464b[i3 + 4] = attributes.getValue(i2);
            }
        }
    }

    public int getIndex(String str) {
        int i2 = this.f31463a * 5;
        for (int i3 = 0; i3 < i2; i3 += 5) {
            if (this.f31464b[i3 + 2].equals(str)) {
                return i3 / 5;
            }
        }
        return -1;
    }

    public int getLength() {
        return this.f31463a;
    }

    public String getLocalName(int i2) {
        if (i2 < 0 || i2 >= this.f31463a) {
            return null;
        }
        return this.f31464b[(i2 * 5) + 1];
    }

    public String getQName(int i2) {
        if (i2 < 0 || i2 >= this.f31463a) {
            return null;
        }
        return this.f31464b[(i2 * 5) + 2];
    }

    public String getType(int i2) {
        if (i2 < 0 || i2 >= this.f31463a) {
            return null;
        }
        return this.f31464b[(i2 * 5) + 3];
    }

    public String getURI(int i2) {
        if (i2 < 0 || i2 >= this.f31463a) {
            return null;
        }
        return this.f31464b[i2 * 5];
    }

    public String getValue(int i2) {
        if (i2 < 0 || i2 >= this.f31463a) {
            return null;
        }
        return this.f31464b[(i2 * 5) + 4];
    }

    public void h(int i2, String str) {
        if (i2 < 0 || i2 >= this.f31463a) {
            b(i2);
        } else {
            this.f31464b[(i2 * 5) + 1] = str;
        }
    }

    public void i(int i2, String str) {
        if (i2 < 0 || i2 >= this.f31463a) {
            b(i2);
        } else {
            this.f31464b[(i2 * 5) + 2] = str;
        }
    }

    public void j(int i2, String str) {
        if (i2 < 0 || i2 >= this.f31463a) {
            b(i2);
        } else {
            this.f31464b[(i2 * 5) + 3] = str;
        }
    }

    public void k(int i2, String str) {
        if (i2 < 0 || i2 >= this.f31463a) {
            b(i2);
        } else {
            this.f31464b[i2 * 5] = str;
        }
    }

    public void l(int i2, String str) {
        if (i2 < 0 || i2 >= this.f31463a) {
            b(i2);
        } else {
            this.f31464b[(i2 * 5) + 4] = str;
        }
    }

    public AttributesImpl(Attributes attributes) {
        g(attributes);
    }

    public int getIndex(String str, String str2) {
        int i2 = this.f31463a * 5;
        for (int i3 = 0; i3 < i2; i3 += 5) {
            if (this.f31464b[i3].equals(str) && this.f31464b[i3 + 1].equals(str2)) {
                return i3 / 5;
            }
        }
        return -1;
    }

    public String getType(String str) {
        int i2 = this.f31463a * 5;
        for (int i3 = 0; i3 < i2; i3 += 5) {
            if (this.f31464b[i3 + 2].equals(str)) {
                return this.f31464b[i3 + 3];
            }
        }
        return null;
    }

    public String getValue(String str) {
        int i2 = this.f31463a * 5;
        for (int i3 = 0; i3 < i2; i3 += 5) {
            if (this.f31464b[i3 + 2].equals(str)) {
                return this.f31464b[i3 + 4];
            }
        }
        return null;
    }

    public String getType(String str, String str2) {
        int i2 = this.f31463a * 5;
        for (int i3 = 0; i3 < i2; i3 += 5) {
            if (this.f31464b[i3].equals(str) && this.f31464b[i3 + 1].equals(str2)) {
                return this.f31464b[i3 + 3];
            }
        }
        return null;
    }

    public String getValue(String str, String str2) {
        int i2 = this.f31463a * 5;
        for (int i3 = 0; i3 < i2; i3 += 5) {
            if (this.f31464b[i3].equals(str) && this.f31464b[i3 + 1].equals(str2)) {
                return this.f31464b[i3 + 4];
            }
        }
        return null;
    }
}
