package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.annotation.ArrayRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.provider.FontRequest;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FontResourcesParserCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final int f5763a = 400;

    /* renamed from: b  reason: collision with root package name */
    private static final int f5764b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5765c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f5766d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f5767e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static final int f5768f = 500;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static int a(TypedArray typedArray, int i2) {
            return typedArray.getType(i2);
        }
    }

    public interface FamilyResourceEntry {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FetchStrategy {
    }

    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final FontFileResourceEntry[] f5769a;

        public FontFamilyFilesResourceEntry(@NonNull FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.f5769a = fontFileResourceEntryArr;
        }

        @NonNull
        public FontFileResourceEntry[] a() {
            return this.f5769a;
        }
    }

    public static final class FontFileResourceEntry {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final String f5770a;

        /* renamed from: b  reason: collision with root package name */
        private final int f5771b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f5772c;

        /* renamed from: d  reason: collision with root package name */
        private final String f5773d;

        /* renamed from: e  reason: collision with root package name */
        private final int f5774e;

        /* renamed from: f  reason: collision with root package name */
        private final int f5775f;

        public FontFileResourceEntry(@NonNull String str, int i2, boolean z, @Nullable String str2, int i3, int i4) {
            this.f5770a = str;
            this.f5771b = i2;
            this.f5772c = z;
            this.f5773d = str2;
            this.f5774e = i3;
            this.f5775f = i4;
        }

        @NonNull
        public String a() {
            return this.f5770a;
        }

        public int b() {
            return this.f5775f;
        }

        public int c() {
            return this.f5774e;
        }

        @Nullable
        public String d() {
            return this.f5773d;
        }

        public int e() {
            return this.f5771b;
        }

        public boolean f() {
            return this.f5772c;
        }
    }

    public static final class ProviderResourceEntry implements FamilyResourceEntry {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final FontRequest f5776a;

        /* renamed from: b  reason: collision with root package name */
        private final int f5777b;

        /* renamed from: c  reason: collision with root package name */
        private final int f5778c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private final String f5779d;

        public ProviderResourceEntry(@NonNull FontRequest fontRequest, int i2, int i3) {
            this(fontRequest, i2, i3, (String) null);
        }

        public int a() {
            return this.f5778c;
        }

        @NonNull
        public FontRequest b() {
            return this.f5776a;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public String c() {
            return this.f5779d;
        }

        public int d() {
            return this.f5777b;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public ProviderResourceEntry(@NonNull FontRequest fontRequest, int i2, int i3, @Nullable String str) {
            this.f5776a = fontRequest;
            this.f5778c = i2;
            this.f5777b = i3;
            this.f5779d = str;
        }
    }

    private FontResourcesParserCompat() {
    }

    private static int a(TypedArray typedArray, int i2) {
        return Api21Impl.a(typedArray, i2);
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    @androidx.annotation.Nullable
    public static androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry b(@androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser r3, @androidx.annotation.NonNull android.content.res.Resources r4) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        L_0x0000:
            int r0 = r3.next()
            r1 = 2
            if (r0 == r1) goto L_0x000b
            r2 = 1
            if (r0 == r2) goto L_0x000b
            goto L_0x0000
        L_0x000b:
            if (r0 != r1) goto L_0x0012
            androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry r3 = d(r3, r4)
            return r3
        L_0x0012:
            org.xmlpull.v1.XmlPullParserException r3 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r4 = "No start tag found"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.FontResourcesParserCompat.b(org.xmlpull.v1.XmlPullParser, android.content.res.Resources):androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry");
    }

    @NonNull
    public static List<List<byte[]>> c(@NonNull Resources resources, @ArrayRes int i2) {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i3 = 0; i3 < obtainTypedArray.length(); i3++) {
                    int resourceId = obtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i2)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    @Nullable
    private static FamilyResourceEntry d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, (String) null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    @Nullable
    private static FamilyResourceEntry e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.f5193j);
        String string = obtainAttributes.getString(R.styleable.f5194k);
        String string2 = obtainAttributes.getString(R.styleable.o);
        String string3 = obtainAttributes.getString(R.styleable.p);
        int resourceId = obtainAttributes.getResourceId(R.styleable.f5195l, 0);
        int integer = obtainAttributes.getInteger(R.styleable.f5196m, 1);
        int integer2 = obtainAttributes.getInteger(R.styleable.f5197n, 500);
        String string4 = obtainAttributes.getString(R.styleable.q);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(f(xmlPullParser, resources));
                    } else {
                        g(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[0]));
        }
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new ProviderResourceEntry(new FontRequest(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
    }

    private static FontFileResourceEntry f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.r);
        int i2 = R.styleable.A;
        if (!obtainAttributes.hasValue(i2)) {
            i2 = R.styleable.t;
        }
        int i3 = obtainAttributes.getInt(i2, 400);
        int i4 = R.styleable.y;
        if (!obtainAttributes.hasValue(i4)) {
            i4 = R.styleable.u;
        }
        boolean z = 1 == obtainAttributes.getInt(i4, 0);
        int i5 = R.styleable.B;
        if (!obtainAttributes.hasValue(i5)) {
            i5 = R.styleable.v;
        }
        int i6 = R.styleable.z;
        if (!obtainAttributes.hasValue(i6)) {
            i6 = R.styleable.w;
        }
        String string = obtainAttributes.getString(i6);
        int i7 = obtainAttributes.getInt(i5, 0);
        int i8 = R.styleable.x;
        if (!obtainAttributes.hasValue(i8)) {
            i8 = R.styleable.s;
        }
        int resourceId = obtainAttributes.getResourceId(i8, 0);
        String string2 = obtainAttributes.getString(i8);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new FontFileResourceEntry(string2, i3, z, string, i7, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }
}
