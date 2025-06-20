package com.google.android.gms.common.server.response;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.itextpdf.text.pdf.Barcode128;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import okio.internal._BufferKt;

@ShowFirstParty
@KeepForSdk
public class FastParser<T extends FastJsonResponse> {

    /* renamed from: g  reason: collision with root package name */
    private static final char[] f20337g = {'u', 'l', 'l'};

    /* renamed from: h  reason: collision with root package name */
    private static final char[] f20338h = {'r', 'u', Barcode128.H};

    /* renamed from: i  reason: collision with root package name */
    private static final char[] f20339i = {'r', 'u', Barcode128.H, '\"'};

    /* renamed from: j  reason: collision with root package name */
    private static final char[] f20340j = {'a', 'l', 's', Barcode128.H};

    /* renamed from: k  reason: collision with root package name */
    private static final char[] f20341k = {'a', 'l', 's', Barcode128.H, '\"'};

    /* renamed from: l  reason: collision with root package name */
    private static final char[] f20342l = {10};

    /* renamed from: m  reason: collision with root package name */
    private static final zai<Integer> f20343m = new zaa();

    /* renamed from: n  reason: collision with root package name */
    private static final zai<Long> f20344n = new zab();
    private static final zai<Float> o = new zac();
    private static final zai<Double> p = new zad();
    private static final zai<Boolean> q = new zae();
    private static final zai<String> r = new zaf();
    private static final zai<BigInteger> s = new zag();
    private static final zai<BigDecimal> t = new zah();

    /* renamed from: a  reason: collision with root package name */
    private final char[] f20345a = new char[1];

    /* renamed from: b  reason: collision with root package name */
    private final char[] f20346b = new char[32];

    /* renamed from: c  reason: collision with root package name */
    private final char[] f20347c = new char[1024];

    /* renamed from: d  reason: collision with root package name */
    private final StringBuilder f20348d = new StringBuilder(32);

    /* renamed from: e  reason: collision with root package name */
    private final StringBuilder f20349e = new StringBuilder(1024);

    /* renamed from: f  reason: collision with root package name */
    private final Stack<Integer> f20350f = new Stack<>();

    @ShowFirstParty
    @KeepForSdk
    public static class ParseException extends Exception {
        public ParseException(@NonNull String str) {
            super(str);
        }

        public ParseException(@NonNull String str, @NonNull Throwable th) {
            super("Error instantiating inner object", th);
        }

        public ParseException(@NonNull Throwable th) {
            super(th);
        }
    }

    /* access modifiers changed from: private */
    public final boolean A(BufferedReader bufferedReader, boolean z) throws ParseException, IOException {
        char k2 = k(bufferedReader);
        if (k2 != '\"') {
            if (k2 == 'f') {
                z(bufferedReader, z ? f20341k : f20340j);
                return false;
            } else if (k2 == 'n') {
                z(bufferedReader, f20337g);
                return false;
            } else if (k2 == 't') {
                z(bufferedReader, z ? f20339i : f20338h);
                return true;
            } else {
                StringBuilder sb = new StringBuilder(19);
                sb.append("Unexpected token: ");
                sb.append(k2);
                throw new ParseException(sb.toString());
            }
        } else if (!z) {
            return A(bufferedReader, true);
        } else {
            throw new ParseException("No boolean value found in string");
        }
    }

    private final boolean B(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) throws ParseException, IOException {
        HashMap hashMap;
        BufferedReader bufferedReader2 = bufferedReader;
        FastJsonResponse fastJsonResponse2 = fastJsonResponse;
        Map<String, FastJsonResponse.Field<?, ?>> c2 = fastJsonResponse.c();
        String s2 = s(bufferedReader);
        if (s2 != null) {
            while (s2 != null) {
                FastJsonResponse.Field field = c2.get(s2);
                if (field == null) {
                    s2 = t(bufferedReader);
                } else {
                    this.f20350f.push(4);
                    int i2 = field.X;
                    switch (i2) {
                        case 0:
                            if (!field.Y) {
                                fastJsonResponse2.g0(field, n(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.h0(field, w(bufferedReader2, f20343m));
                                break;
                            }
                        case 1:
                            if (!field.Y) {
                                fastJsonResponse2.Q(field, v(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.S(field, w(bufferedReader2, s));
                                break;
                            }
                        case 2:
                            if (!field.Y) {
                                fastJsonResponse2.j0(field, p(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.k0(field, w(bufferedReader2, f20344n));
                                break;
                            }
                        case 3:
                            if (!field.Y) {
                                fastJsonResponse2.c0(field, m(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.e0(field, w(bufferedReader2, o));
                                break;
                            }
                        case 4:
                            if (!field.Y) {
                                fastJsonResponse2.Y(field, l(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.a0(field, w(bufferedReader2, p));
                                break;
                            }
                        case 5:
                            if (!field.Y) {
                                fastJsonResponse2.M(field, u(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.O(field, w(bufferedReader2, t));
                                break;
                            }
                        case 6:
                            if (!field.Y) {
                                fastJsonResponse2.U(field, A(bufferedReader2, false));
                                break;
                            } else {
                                fastJsonResponse2.V(field, w(bufferedReader2, q));
                                break;
                            }
                        case 7:
                            if (!field.Y) {
                                fastJsonResponse2.B(field, q(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.D(field, w(bufferedReader2, r));
                                break;
                            }
                        case 8:
                            fastJsonResponse2.X(field, Base64Utils.a(r(bufferedReader2, this.f20347c, this.f20349e, f20342l)));
                            break;
                        case 9:
                            fastJsonResponse2.X(field, Base64Utils.b(r(bufferedReader2, this.f20347c, this.f20349e, f20342l)));
                            break;
                        case 10:
                            char k2 = k(bufferedReader);
                            if (k2 == 'n') {
                                z(bufferedReader2, f20337g);
                                hashMap = null;
                            } else if (k2 == '{') {
                                this.f20350f.push(1);
                                hashMap = new HashMap();
                                while (true) {
                                    char k3 = k(bufferedReader);
                                    if (k3 == 0) {
                                        throw new ParseException("Unexpected EOF");
                                    } else if (k3 == '\"') {
                                        String b2 = b(bufferedReader2, this.f20346b, this.f20348d, (char[]) null);
                                        if (k(bufferedReader) != ':') {
                                            String valueOf = String.valueOf(b2);
                                            throw new ParseException(valueOf.length() != 0 ? "No map value found for key ".concat(valueOf) : new String("No map value found for key "));
                                        } else if (k(bufferedReader) != '\"') {
                                            String valueOf2 = String.valueOf(b2);
                                            throw new ParseException(valueOf2.length() != 0 ? "Expected String value for key ".concat(valueOf2) : new String("Expected String value for key "));
                                        } else {
                                            hashMap.put(b2, b(bufferedReader2, this.f20346b, this.f20348d, (char[]) null));
                                            char k4 = k(bufferedReader);
                                            if (k4 != ',') {
                                                if (k4 != '}') {
                                                    StringBuilder sb = new StringBuilder(48);
                                                    sb.append("Unexpected character while parsing string map: ");
                                                    sb.append(k4);
                                                    throw new ParseException(sb.toString());
                                                }
                                            }
                                        }
                                    } else if (k3 != '}') {
                                    }
                                }
                                y(1);
                            } else {
                                throw new ParseException("Expected start of a map object");
                            }
                            fastJsonResponse2.C(field, hashMap);
                            break;
                        case 11:
                            if (field.Y) {
                                char k5 = k(bufferedReader);
                                if (k5 == 'n') {
                                    z(bufferedReader2, f20337g);
                                    fastJsonResponse2.a(field, field.Y2, (ArrayList) null);
                                    break;
                                } else {
                                    this.f20350f.push(5);
                                    if (k5 == '[') {
                                        fastJsonResponse2.a(field, field.Y2, x(bufferedReader2, field));
                                        break;
                                    } else {
                                        throw new ParseException("Expected array start");
                                    }
                                }
                            } else {
                                char k6 = k(bufferedReader);
                                if (k6 == 'n') {
                                    z(bufferedReader2, f20337g);
                                    fastJsonResponse2.b(field, field.Y2, null);
                                    break;
                                } else {
                                    this.f20350f.push(1);
                                    if (k6 == '{') {
                                        try {
                                            FastJsonResponse g0 = field.g0();
                                            B(bufferedReader2, g0);
                                            fastJsonResponse2.b(field, field.Y2, g0);
                                            break;
                                        } catch (InstantiationException e2) {
                                            throw new ParseException("Error instantiating inner object", e2);
                                        } catch (IllegalAccessException e3) {
                                            throw new ParseException("Error instantiating inner object", e3);
                                        }
                                    } else {
                                        throw new ParseException("Expected start of object");
                                    }
                                }
                            }
                        default:
                            StringBuilder sb2 = new StringBuilder(30);
                            sb2.append("Invalid field type ");
                            sb2.append(i2);
                            throw new ParseException(sb2.toString());
                    }
                    y(4);
                    y(2);
                    char k7 = k(bufferedReader);
                    if (k7 == ',') {
                        s2 = s(bufferedReader);
                    } else if (k7 == '}') {
                        s2 = null;
                    } else {
                        StringBuilder sb3 = new StringBuilder(55);
                        sb3.append("Expected end of object or field separator, but found: ");
                        sb3.append(k7);
                        throw new ParseException(sb3.toString());
                    }
                }
            }
            y(1);
            return true;
        }
        y(1);
        return false;
    }

    private static final String b(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, @Nullable char[] cArr2) throws ParseException, IOException {
        sb.setLength(0);
        bufferedReader.mark(cArr.length);
        boolean z = false;
        boolean z2 = false;
        loop0:
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                for (int i2 = 0; i2 < read; i2++) {
                    char c2 = cArr[i2];
                    if (Character.isISOControl(c2)) {
                        if (cArr2 == null) {
                            break loop0;
                        }
                        int i3 = 0;
                        while (i3 <= 0) {
                            if (cArr2[i3] != c2) {
                                i3++;
                            }
                        }
                        break loop0;
                    }
                    if (c2 == '\"') {
                        if (!z2) {
                            sb.append(cArr, 0, i2);
                            bufferedReader.reset();
                            bufferedReader.skip((long) (i2 + 1));
                            String sb2 = sb.toString();
                            return z ? JsonUtils.c(sb2) : sb2;
                        }
                    } else if (c2 == '\\') {
                        z2 = !z2;
                        z = true;
                    }
                    z2 = false;
                }
                sb.append(cArr, 0, read);
                bufferedReader.mark(cArr.length);
            } else {
                throw new ParseException("Unexpected EOF while parsing string");
            }
        }
        throw new ParseException("Unexpected control character while reading string");
    }

    private final char k(BufferedReader bufferedReader) throws ParseException, IOException {
        if (bufferedReader.read(this.f20345a) == -1) {
            return 0;
        }
        while (Character.isWhitespace(this.f20345a[0])) {
            if (bufferedReader.read(this.f20345a) == -1) {
                return 0;
            }
        }
        return this.f20345a[0];
    }

    /* access modifiers changed from: private */
    public final double l(BufferedReader bufferedReader) throws ParseException, IOException {
        int o2 = o(bufferedReader, this.f20347c);
        if (o2 == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.f20347c, 0, o2));
    }

    /* access modifiers changed from: private */
    public final float m(BufferedReader bufferedReader) throws ParseException, IOException {
        int o2 = o(bufferedReader, this.f20347c);
        if (o2 == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.f20347c, 0, o2));
    }

    /* access modifiers changed from: private */
    public final int n(BufferedReader bufferedReader) throws ParseException, IOException {
        int i2;
        int i3;
        int o2 = o(bufferedReader, this.f20347c);
        if (o2 == 0) {
            return 0;
        }
        char[] cArr = this.f20347c;
        if (o2 > 0) {
            char c2 = cArr[0];
            int i4 = c2 == '-' ? Integer.MIN_VALUE : C.f9088f;
            int i5 = c2 == '-' ? 1 : 0;
            if (i5 < o2) {
                i3 = i5 + 1;
                int digit = Character.digit(cArr[i5], 10);
                if (digit >= 0) {
                    i2 = -digit;
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            } else {
                i3 = i5;
                i2 = 0;
            }
            while (i3 < o2) {
                int i6 = i3 + 1;
                int digit2 = Character.digit(cArr[i3], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (i2 >= -214748364) {
                    int i7 = i2 * 10;
                    if (i7 >= i4 + digit2) {
                        i2 = i7 - digit2;
                        i3 = i6;
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Number too large");
                }
            }
            if (i5 == 0) {
                return -i2;
            }
            if (i3 > 1) {
                return i2;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    private final int o(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i2;
        ParseException parseException;
        char k2 = k(bufferedReader);
        if (k2 == 0) {
            throw new ParseException("Unexpected EOF");
        } else if (k2 == ',') {
            throw new ParseException("Missing value");
        } else if (k2 == 'n') {
            z(bufferedReader, f20337g);
            return 0;
        } else {
            bufferedReader.mark(1024);
            if (k2 == '\"') {
                i2 = 0;
                boolean z = false;
                while (i2 < 1024 && bufferedReader.read(cArr, i2, 1) != -1) {
                    char c2 = cArr[i2];
                    if (!Character.isISOControl(c2)) {
                        if (c2 == '\"') {
                            if (!z) {
                                bufferedReader.reset();
                                bufferedReader.skip((long) (i2 + 1));
                                return i2;
                            }
                        } else if (c2 == '\\') {
                            z = !z;
                            i2++;
                        }
                        z = false;
                        i2++;
                    } else {
                        throw new ParseException("Unexpected control character while reading string");
                    }
                }
            } else {
                cArr[0] = k2;
                int i3 = 1;
                while (i2 < 1024 && bufferedReader.read(cArr, i2, 1) != -1) {
                    char c3 = cArr[i2];
                    if (c3 == '}' || c3 == ',' || Character.isWhitespace(c3) || cArr[i2] == ']') {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i2 - 1));
                        cArr[i2] = 0;
                        return i2;
                    }
                    i3 = i2 + 1;
                }
            }
            if (i2 == 1024) {
                throw parseException;
            }
            parseException = new ParseException("Unexpected EOF");
            throw parseException;
        }
    }

    /* access modifiers changed from: private */
    public final long p(BufferedReader bufferedReader) throws ParseException, IOException {
        long j2;
        int i2;
        int o2 = o(bufferedReader, this.f20347c);
        if (o2 == 0) {
            return 0;
        }
        char[] cArr = this.f20347c;
        if (o2 > 0) {
            int i3 = 0;
            char c2 = cArr[0];
            long j3 = c2 == '-' ? Long.MIN_VALUE : C.f9084b;
            if (c2 == '-') {
                i3 = 1;
            }
            if (i3 < o2) {
                i2 = i3 + 1;
                int digit = Character.digit(cArr[i3], 10);
                if (digit >= 0) {
                    j2 = (long) (-digit);
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            } else {
                j2 = 0;
                i2 = i3;
            }
            while (i2 < o2) {
                int i4 = i2 + 1;
                int digit2 = Character.digit(cArr[i2], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (j2 >= _BufferKt.f31452c) {
                    long j4 = j2 * 10;
                    long j5 = (long) digit2;
                    if (j4 >= j3 + j5) {
                        j2 = j4 - j5;
                        i2 = i4;
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Number too large");
                }
            }
            if (i3 == 0) {
                return -j2;
            }
            if (i2 > 1) {
                return j2;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    /* access modifiers changed from: private */
    @Nullable
    public final String q(BufferedReader bufferedReader) throws ParseException, IOException {
        return r(bufferedReader, this.f20346b, this.f20348d, (char[]) null);
    }

    @Nullable
    private final String r(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, @Nullable char[] cArr2) throws ParseException, IOException {
        char k2 = k(bufferedReader);
        if (k2 == '\"') {
            return b(bufferedReader, cArr, sb, cArr2);
        }
        if (k2 == 'n') {
            z(bufferedReader, f20337g);
            return null;
        }
        throw new ParseException("Expected string");
    }

    @Nullable
    private final String s(BufferedReader bufferedReader) throws ParseException, IOException {
        this.f20350f.push(2);
        char k2 = k(bufferedReader);
        if (k2 == '\"') {
            this.f20350f.push(3);
            String b2 = b(bufferedReader, this.f20346b, this.f20348d, (char[]) null);
            y(3);
            if (k(bufferedReader) == ':') {
                return b2;
            }
            throw new ParseException("Expected key/value separator");
        } else if (k2 == ']') {
            y(2);
            y(1);
            y(5);
            return null;
        } else if (k2 == '}') {
            y(2);
            return null;
        } else {
            StringBuilder sb = new StringBuilder(19);
            sb.append("Unexpected token: ");
            sb.append(k2);
            throw new ParseException(sb.toString());
        }
    }

    @Nullable
    private final String t(BufferedReader bufferedReader) throws ParseException, IOException {
        BufferedReader bufferedReader2 = bufferedReader;
        bufferedReader2.mark(1024);
        char k2 = k(bufferedReader);
        int i2 = 1;
        if (k2 != '\"') {
            if (k2 == ',') {
                throw new ParseException("Missing value");
            } else if (k2 == '[') {
                this.f20350f.push(5);
                bufferedReader2.mark(32);
                if (k(bufferedReader) != ']') {
                    bufferedReader.reset();
                    boolean z = false;
                    loop1:
                    while (true) {
                        boolean z2 = false;
                        while (i2 > 0) {
                            char k3 = k(bufferedReader);
                            if (k3 == 0) {
                                throw new ParseException("Unexpected EOF while parsing array");
                            } else if (!Character.isISOControl(k3)) {
                                if (k3 == '\"') {
                                    if (!z2) {
                                        z = !z;
                                    }
                                    k3 = '\"';
                                }
                                if (k3 == '[') {
                                    if (!z) {
                                        i2++;
                                    }
                                    k3 = '[';
                                }
                                if (k3 == ']' && !z) {
                                    i2--;
                                }
                                if (k3 == '\\' && z) {
                                    z2 = !z2;
                                }
                            } else {
                                throw new ParseException("Unexpected control character while reading array");
                            }
                        }
                        break loop1;
                    }
                }
                y(5);
            } else if (k2 != '{') {
                bufferedReader.reset();
                o(bufferedReader2, this.f20347c);
            } else {
                this.f20350f.push(1);
                bufferedReader2.mark(32);
                char k4 = k(bufferedReader);
                if (k4 != '}') {
                    if (k4 == '\"') {
                        bufferedReader.reset();
                        s(bufferedReader);
                        do {
                        } while (t(bufferedReader) != null);
                    } else {
                        StringBuilder sb = new StringBuilder(18);
                        sb.append("Unexpected token ");
                        sb.append(k4);
                        throw new ParseException(sb.toString());
                    }
                }
                y(1);
            }
        } else if (bufferedReader2.read(this.f20345a) != -1) {
            char c2 = this.f20345a[0];
            boolean z3 = false;
            do {
                if (c2 == '\"') {
                    if (z3) {
                        c2 = '\"';
                        z3 = true;
                    }
                }
                z3 = c2 == '\\' ? !z3 : false;
                if (bufferedReader2.read(this.f20345a) != -1) {
                    c2 = this.f20345a[0];
                } else {
                    throw new ParseException("Unexpected EOF while parsing string");
                }
            } while (!Character.isISOControl(c2));
            throw new ParseException("Unexpected control character while reading string");
        } else {
            throw new ParseException("Unexpected EOF while parsing string");
        }
        char k5 = k(bufferedReader);
        if (k5 == ',') {
            y(2);
            return s(bufferedReader);
        } else if (k5 == '}') {
            y(2);
            return null;
        } else {
            StringBuilder sb2 = new StringBuilder(18);
            sb2.append("Unexpected token ");
            sb2.append(k5);
            throw new ParseException(sb2.toString());
        }
    }

    /* access modifiers changed from: private */
    @Nullable
    public final BigDecimal u(BufferedReader bufferedReader) throws ParseException, IOException {
        int o2 = o(bufferedReader, this.f20347c);
        if (o2 == 0) {
            return null;
        }
        return new BigDecimal(new String(this.f20347c, 0, o2));
    }

    /* access modifiers changed from: private */
    @Nullable
    public final BigInteger v(BufferedReader bufferedReader) throws ParseException, IOException {
        int o2 = o(bufferedReader, this.f20347c);
        if (o2 == 0) {
            return null;
        }
        return new BigInteger(new String(this.f20347c, 0, o2));
    }

    @Nullable
    private final <O> ArrayList<O> w(BufferedReader bufferedReader, zai<O> zai) throws ParseException, IOException {
        char k2 = k(bufferedReader);
        if (k2 == 'n') {
            z(bufferedReader, f20337g);
            return null;
        } else if (k2 == '[') {
            this.f20350f.push(5);
            ArrayList<O> arrayList = new ArrayList<>();
            while (true) {
                bufferedReader.mark(1024);
                char k3 = k(bufferedReader);
                if (k3 == 0) {
                    throw new ParseException("Unexpected EOF");
                } else if (k3 != ',') {
                    if (k3 != ']') {
                        bufferedReader.reset();
                        arrayList.add(zai.a(this, bufferedReader));
                    } else {
                        y(5);
                        return arrayList;
                    }
                }
            }
        } else {
            throw new ParseException("Expected start of array");
        }
    }

    @Nullable
    private final <T extends FastJsonResponse> ArrayList<T> x(BufferedReader bufferedReader, FastJsonResponse.Field<?, ?> field) throws ParseException, IOException {
        ArrayList<T> arrayList = new ArrayList<>();
        char k2 = k(bufferedReader);
        if (k2 == ']') {
            y(5);
            return arrayList;
        } else if (k2 == 'n') {
            z(bufferedReader, f20337g);
            y(5);
            return null;
        } else if (k2 == '{') {
            Stack<Integer> stack = this.f20350f;
            while (true) {
                stack.push(1);
                try {
                    FastJsonResponse g0 = field.g0();
                    if (!B(bufferedReader, g0)) {
                        return arrayList;
                    }
                    arrayList.add(g0);
                    char k3 = k(bufferedReader);
                    if (k3 != ',') {
                        if (k3 == ']') {
                            y(5);
                            return arrayList;
                        }
                        StringBuilder sb = new StringBuilder(19);
                        sb.append("Unexpected token: ");
                        sb.append(k3);
                        throw new ParseException(sb.toString());
                    } else if (k(bufferedReader) == '{') {
                        stack = this.f20350f;
                    } else {
                        throw new ParseException("Expected start of next object in array");
                    }
                } catch (InstantiationException e2) {
                    throw new ParseException("Error instantiating inner object", e2);
                } catch (IllegalAccessException e3) {
                    throw new ParseException("Error instantiating inner object", e3);
                }
            }
        } else {
            StringBuilder sb2 = new StringBuilder(19);
            sb2.append("Unexpected token: ");
            sb2.append(k2);
            throw new ParseException(sb2.toString());
        }
    }

    private final void y(int i2) throws ParseException {
        if (!this.f20350f.isEmpty()) {
            int intValue = this.f20350f.pop().intValue();
            if (intValue != i2) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Expected state ");
                sb.append(i2);
                sb.append(" but had ");
                sb.append(intValue);
                throw new ParseException(sb.toString());
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Expected state ");
        sb2.append(i2);
        sb2.append(" but had empty stack");
        throw new ParseException(sb2.toString());
    }

    private final void z(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i2 = 0;
        while (true) {
            int length = cArr.length;
            if (i2 < length) {
                int read = bufferedReader.read(this.f20346b, 0, length - i2);
                if (read != -1) {
                    int i3 = 0;
                    while (i3 < read) {
                        if (cArr[i3 + i2] == this.f20346b[i3]) {
                            i3++;
                        } else {
                            throw new ParseException("Unexpected character");
                        }
                    }
                    i2 += read;
                } else {
                    throw new ParseException("Unexpected EOF");
                }
            } else {
                return;
            }
        }
    }

    @KeepForSdk
    public void a(@NonNull InputStream inputStream, @NonNull T t2) throws ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            this.f20350f.push(0);
            char k2 = k(bufferedReader);
            if (k2 != 0) {
                if (k2 == '[') {
                    this.f20350f.push(5);
                    Map<String, FastJsonResponse.Field<?, ?>> c2 = t2.c();
                    if (c2.size() == 1) {
                        FastJsonResponse.Field field = (FastJsonResponse.Field) c2.entrySet().iterator().next().getValue();
                        t2.a(field, field.Y2, x(bufferedReader, field));
                    } else {
                        throw new ParseException("Object array response class must have a single Field");
                    }
                } else if (k2 == '{') {
                    this.f20350f.push(1);
                    B(bufferedReader, t2);
                } else {
                    StringBuilder sb = new StringBuilder(19);
                    sb.append("Unexpected token: ");
                    sb.append(k2);
                    throw new ParseException(sb.toString());
                }
                y(0);
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                    Log.w("FastParser", "Failed to close reader while parsing.");
                }
            } else {
                throw new ParseException("No data to parse");
            }
        } catch (IOException e2) {
            throw new ParseException((Throwable) e2);
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th;
        }
    }
}
