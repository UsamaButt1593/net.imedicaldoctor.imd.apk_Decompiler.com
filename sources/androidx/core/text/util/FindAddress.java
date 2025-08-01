package androidx.core.text.util;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class FindAddress {

    /* renamed from: a  reason: collision with root package name */
    private static final int f6219a = 4;

    /* renamed from: b  reason: collision with root package name */
    private static final int f6220b = 14;

    /* renamed from: c  reason: collision with root package name */
    private static final int f6221c = 5;

    /* renamed from: d  reason: collision with root package name */
    private static final int f6222d = 25;

    /* renamed from: e  reason: collision with root package name */
    private static final int f6223e = 5;

    /* renamed from: f  reason: collision with root package name */
    private static final ZipRange[] f6224f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f6225g = "\n\u000b\f\r  ";

    /* renamed from: h  reason: collision with root package name */
    private static final String f6226h = "\t                　";

    /* renamed from: i  reason: collision with root package name */
    private static final String f6227i = "\t                　\n\u000b\f\r  ";

    /* renamed from: j  reason: collision with root package name */
    private static final String f6228j = ",*•\t                　\n\u000b\f\r  ";

    /* renamed from: k  reason: collision with root package name */
    private static final String f6229k = "(?=[,*•\t                　\n\u000b\f\r  ]|$)";

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f6230l = Pattern.compile("[^,*•\t                　\n\u000b\f\r  ]+(?=[,*•\t                　\n\u000b\f\r  ]|$)", 2);

    /* renamed from: m  reason: collision with root package name */
    private static final String f6231m = ",\"'\t                　\n\u000b\f\r  ";

    /* renamed from: n  reason: collision with root package name */
    private static final String f6232n = "(?=[,\"'\t                　\n\u000b\f\r  ]|$)";
    private static final String o = ":,\"'\t                　\n\u000b\f\r  ";
    private static final String p = "(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)";
    private static final Pattern q = Pattern.compile("(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)(?:-(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?))*(?=[,\"'\t                　\n\u000b\f\r  ]|$)", 2);
    private static final Pattern r = Pattern.compile("(?:(ak|alaska)|(al|alabama)|(ar|arkansas)|(as|american[\t                　]+samoa)|(az|arizona)|(ca|california)|(co|colorado)|(ct|connecticut)|(dc|district[\t                　]+of[\t                　]+columbia)|(de|delaware)|(fl|florida)|(fm|federated[\t                　]+states[\t                　]+of[\t                　]+micronesia)|(ga|georgia)|(gu|guam)|(hi|hawaii)|(ia|iowa)|(id|idaho)|(il|illinois)|(in|indiana)|(ks|kansas)|(ky|kentucky)|(la|louisiana)|(ma|massachusetts)|(md|maryland)|(me|maine)|(mh|marshall[\t                　]+islands)|(mi|michigan)|(mn|minnesota)|(mo|missouri)|(mp|northern[\t                　]+mariana[\t                　]+islands)|(ms|mississippi)|(mt|montana)|(nc|north[\t                　]+carolina)|(nd|north[\t                　]+dakota)|(ne|nebraska)|(nh|new[\t                　]+hampshire)|(nj|new[\t                　]+jersey)|(nm|new[\t                　]+mexico)|(nv|nevada)|(ny|new[\t                　]+york)|(oh|ohio)|(ok|oklahoma)|(or|oregon)|(pa|pennsylvania)|(pr|puerto[\t                　]+rico)|(pw|palau)|(ri|rhode[\t                　]+island)|(sc|south[\t                　]+carolina)|(sd|south[\t                　]+dakota)|(tn|tennessee)|(tx|texas)|(ut|utah)|(va|virginia)|(vi|virgin[\t                　]+islands)|(vt|vermont)|(wa|washington)|(wi|wisconsin)|(wv|west[\t                　]+virginia)|(wy|wyoming))(?=[,*•\t                　\n\u000b\f\r  ]|$)", 2);
    private static final Pattern s = Pattern.compile("(?:alley|annex|arcade|ave[.]?|avenue|alameda|bayou|beach|bend|bluffs?|bottom|boulevard|branch|bridge|brooks?|burgs?|bypass|broadway|camino|camp|canyon|cape|causeway|centers?|circles?|cliffs?|club|common|corners?|course|courts?|coves?|creek|crescent|crest|crossing|crossroad|curve|circulo|dale|dam|divide|drives?|estates?|expressway|extensions?|falls?|ferry|fields?|flats?|fords?|forest|forges?|forks?|fort|freeway|gardens?|gateway|glens?|greens?|groves?|harbors?|haven|heights|highway|hills?|hollow|inlet|islands?|isle|junctions?|keys?|knolls?|lakes?|land|landing|lane|lights?|loaf|locks?|lodge|loop|mall|manors?|meadows?|mews|mills?|mission|motorway|mount|mountains?|neck|orchard|oval|overpass|parks?|parkways?|pass|passage|path|pike|pines?|plains?|plaza|points?|ports?|prairie|privada|radial|ramp|ranch|rapids?|rd[.]?|rest|ridges?|river|roads?|route|row|rue|run|shoals?|shores?|skyway|springs?|spurs?|squares?|station|stravenue|stream|st[.]?|streets?|summit|speedway|terrace|throughway|trace|track|trafficway|trail|tunnel|turnpike|underpass|unions?|valleys?|viaduct|views?|villages?|ville|vista|walks?|wall|ways?|wells?|xing|xrd)(?=[,*•\t                　\n\u000b\f\r  ]|$)", 2);
    private static final Pattern t = Pattern.compile("([0-9]+)(st|nd|rd|th)", 2);
    private static final Pattern u = Pattern.compile("(?:[0-9]{5}(?:-[0-9]{4})?)(?=[,*•\t                　\n\u000b\f\r  ]|$)", 2);

    private static class ZipRange {

        /* renamed from: a  reason: collision with root package name */
        int f6233a;

        /* renamed from: b  reason: collision with root package name */
        int f6234b;

        /* renamed from: c  reason: collision with root package name */
        int f6235c;

        /* renamed from: d  reason: collision with root package name */
        int f6236d;

        ZipRange(int i2, int i3, int i4, int i5) {
            this.f6233a = i2;
            this.f6234b = i3;
            this.f6235c = i4;
            this.f6236d = i5;
        }

        /* access modifiers changed from: package-private */
        public boolean a(String str) {
            int parseInt = Integer.parseInt(str.substring(0, 2));
            return (this.f6233a <= parseInt && parseInt <= this.f6234b) || parseInt == this.f6235c || parseInt == this.f6236d;
        }
    }

    static {
        ZipRange zipRange = new ZipRange(99, 99, -1, -1);
        ZipRange zipRange2 = new ZipRange(35, 36, -1, -1);
        ZipRange zipRange3 = new ZipRange(71, 72, -1, -1);
        ZipRange zipRange4 = new ZipRange(96, 96, -1, -1);
        ZipRange zipRange5 = new ZipRange(85, 86, -1, -1);
        ZipRange zipRange6 = new ZipRange(90, 96, -1, -1);
        ZipRange zipRange7 = new ZipRange(80, 81, -1, -1);
        ZipRange zipRange8 = new ZipRange(6, 6, -1, -1);
        ZipRange zipRange9 = new ZipRange(20, 20, -1, -1);
        ZipRange zipRange10 = new ZipRange(19, 19, -1, -1);
        ZipRange zipRange11 = new ZipRange(32, 34, -1, -1);
        ZipRange zipRange12 = new ZipRange(96, 96, -1, -1);
        ZipRange zipRange13 = new ZipRange(30, 31, -1, -1);
        ZipRange zipRange14 = new ZipRange(96, 96, -1, -1);
        ZipRange zipRange15 = new ZipRange(96, 96, -1, -1);
        ZipRange zipRange16 = new ZipRange(50, 52, -1, -1);
        ZipRange zipRange17 = new ZipRange(83, 83, -1, -1);
        ZipRange zipRange18 = zipRange16;
        ZipRange zipRange19 = new ZipRange(60, 62, -1, -1);
        ZipRange zipRange20 = new ZipRange(46, 47, -1, -1);
        ZipRange zipRange21 = zipRange12;
        ZipRange zipRange22 = new ZipRange(66, 67, 73, -1);
        ZipRange zipRange23 = new ZipRange(40, 42, -1, -1);
        ZipRange zipRange24 = new ZipRange(70, 71, -1, -1);
        ZipRange zipRange25 = new ZipRange(1, 2, -1, -1);
        ZipRange zipRange26 = new ZipRange(20, 21, -1, -1);
        ZipRange zipRange27 = new ZipRange(3, 4, -1, -1);
        ZipRange zipRange28 = new ZipRange(96, 96, -1, -1);
        ZipRange zipRange29 = zipRange27;
        ZipRange zipRange30 = new ZipRange(48, 49, -1, -1);
        ZipRange zipRange31 = new ZipRange(55, 56, -1, -1);
        ZipRange zipRange32 = new ZipRange(63, 65, -1, -1);
        ZipRange zipRange33 = new ZipRange(96, 96, -1, -1);
        ZipRange zipRange34 = zipRange32;
        ZipRange zipRange35 = new ZipRange(38, 39, -1, -1);
        ZipRange zipRange36 = new ZipRange(55, 56, -1, -1);
        ZipRange zipRange37 = new ZipRange(27, 28, -1, -1);
        ZipRange zipRange38 = new ZipRange(58, 58, -1, -1);
        ZipRange zipRange39 = new ZipRange(68, 69, -1, -1);
        ZipRange zipRange40 = new ZipRange(3, 4, -1, -1);
        ZipRange zipRange41 = new ZipRange(7, 8, -1, -1);
        ZipRange zipRange42 = zipRange22;
        ZipRange zipRange43 = new ZipRange(87, 88, 86, -1);
        ZipRange zipRange44 = new ZipRange(88, 89, 96, -1);
        ZipRange zipRange45 = new ZipRange(10, 14, 0, 6);
        ZipRange zipRange46 = new ZipRange(43, 45, -1, -1);
        ZipRange zipRange47 = new ZipRange(73, 74, -1, -1);
        ZipRange zipRange48 = new ZipRange(97, 97, -1, -1);
        ZipRange zipRange49 = new ZipRange(6, 6, 0, 9);
        ZipRange zipRange50 = new ZipRange(96, 96, -1, -1);
        ZipRange zipRange51 = new ZipRange(2, 2, -1, -1);
        ZipRange zipRange52 = new ZipRange(29, 29, -1, -1);
        ZipRange zipRange53 = new ZipRange(57, 57, -1, -1);
        ZipRange zipRange54 = zipRange49;
        ZipRange zipRange55 = new ZipRange(37, 38, -1, -1);
        ZipRange zipRange56 = zipRange45;
        ZipRange zipRange57 = new ZipRange(75, 79, 87, 88);
        ZipRange zipRange58 = new ZipRange(84, 84, -1, -1);
        ZipRange zipRange59 = zipRange57;
        ZipRange zipRange60 = new ZipRange(22, 24, 20, -1);
        ZipRange zipRange61 = new ZipRange(6, 9, -1, -1);
        ZipRange zipRange62 = zipRange61;
        f6224f = new ZipRange[]{zipRange, zipRange2, zipRange3, zipRange4, zipRange5, zipRange6, zipRange7, zipRange8, zipRange9, zipRange10, zipRange11, zipRange21, zipRange13, zipRange14, zipRange15, zipRange18, zipRange17, zipRange19, zipRange20, zipRange42, zipRange23, zipRange24, zipRange25, zipRange26, zipRange29, zipRange28, zipRange30, zipRange31, zipRange34, zipRange33, zipRange35, zipRange36, zipRange37, zipRange38, zipRange39, zipRange40, zipRange41, zipRange43, zipRange44, zipRange56, zipRange46, zipRange47, zipRange48, new ZipRange(15, 19, -1, -1), zipRange54, zipRange50, zipRange51, zipRange52, zipRange53, zipRange55, zipRange59, zipRange58, zipRange60, zipRange62, new ZipRange(5, 5, -1, -1), new ZipRange(98, 99, -1, -1), new ZipRange(53, 54, -1, -1), new ZipRange(24, 26, -1, -1), new ZipRange(82, 83, -1, -1)};
    }

    private FindAddress() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
        return -r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.lang.String r13, java.util.regex.MatchResult r14) {
        /*
            int r14 = r14.end()
            java.util.regex.Pattern r0 = f6230l
            java.util.regex.Matcher r0 = r0.matcher(r13)
            r1 = -1
            r2 = 1
            r3 = 0
            java.lang.String r4 = ""
            r5 = 1
            r6 = 1
            r7 = 1
            r8 = 0
            r9 = -1
            r10 = -1
        L_0x0015:
            int r11 = r13.length()
            if (r14 >= r11) goto L_0x00d5
            boolean r11 = r0.find(r14)
            if (r11 != 0) goto L_0x0027
            int r13 = r13.length()
        L_0x0025:
            int r13 = -r13
            return r13
        L_0x0027:
            int r11 = r0.end()
            int r12 = r0.start()
            int r11 = r11 - r12
            r12 = 25
            if (r11 <= r12) goto L_0x0039
            int r13 = r0.end()
            goto L_0x0025
        L_0x0039:
            int r11 = r0.start()
            if (r14 >= r11) goto L_0x0051
            int r11 = r14 + 1
            char r14 = r13.charAt(r14)
            java.lang.String r12 = "\n\u000b\f\r  "
            int r14 = r12.indexOf(r14)
            if (r14 == r1) goto L_0x004f
            int r5 = r5 + 1
        L_0x004f:
            r14 = r11
            goto L_0x0039
        L_0x0051:
            r11 = 5
            if (r5 <= r11) goto L_0x0056
            goto L_0x00d5
        L_0x0056:
            int r6 = r6 + r2
            r12 = 14
            if (r6 <= r12) goto L_0x005d
            goto L_0x00d5
        L_0x005d:
            java.util.regex.MatchResult r12 = h(r13, r14)
            if (r12 == 0) goto L_0x006d
            if (r7 == 0) goto L_0x0069
            if (r5 <= r2) goto L_0x0069
            int r13 = -r14
            return r13
        L_0x0069:
            if (r9 != r1) goto L_0x00cb
            r9 = r14
            goto L_0x00cb
        L_0x006d:
            java.lang.String r7 = r0.group(r3)
            boolean r7 = d(r7)
            if (r7 == 0) goto L_0x007a
            r7 = 0
            r8 = 1
            goto L_0x00cb
        L_0x007a:
            if (r6 != r11) goto L_0x0083
            if (r8 != 0) goto L_0x0083
            int r14 = r0.end()
            goto L_0x00d5
        L_0x0083:
            if (r8 == 0) goto L_0x00ca
            r7 = 4
            if (r6 <= r7) goto L_0x00ca
            java.util.regex.MatchResult r14 = i(r13, r14)
            if (r14 == 0) goto L_0x00ca
            java.lang.String r7 = "et"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x00a7
            java.lang.String r4 = r14.group(r3)
            java.lang.String r7 = "al"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x00a7
            int r14 = r14.end()
            goto L_0x00d5
        L_0x00a7:
            java.util.regex.Pattern r4 = f6230l
            java.util.regex.Matcher r4 = r4.matcher(r13)
            int r7 = r14.end()
            boolean r7 = r4.find(r7)
            if (r7 == 0) goto L_0x00c6
            java.lang.String r7 = r4.group(r3)
            boolean r14 = g(r7, r14)
            if (r14 == 0) goto L_0x00ca
            int r13 = r4.end()
            return r13
        L_0x00c6:
            int r10 = r14.end()
        L_0x00ca:
            r7 = 0
        L_0x00cb:
            java.lang.String r4 = r0.group(r3)
            int r14 = r0.end()
            goto L_0x0015
        L_0x00d5:
            if (r10 <= 0) goto L_0x00d8
            return r10
        L_0x00d8:
            if (r9 <= 0) goto L_0x00db
            goto L_0x00dc
        L_0x00db:
            r9 = r14
        L_0x00dc:
            int r13 = -r9
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.util.FindAddress.a(java.lang.String, java.util.regex.MatchResult):int");
    }

    private static boolean b(String str) {
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (Character.isDigit(str.charAt(i3))) {
                i2++;
            }
        }
        if (i2 > 5) {
            return false;
        }
        Matcher matcher = t.matcher(str);
        if (!matcher.find()) {
            return true;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        if (parseInt == 0) {
            return false;
        }
        String lowerCase = matcher.group(2).toLowerCase(Locale.getDefault());
        int i4 = parseInt % 10;
        String str2 = "th";
        if (i4 == 1) {
            if (parseInt % 100 != 11) {
                str2 = CmcdConfiguration.q;
            }
            return lowerCase.equals(str2);
        } else if (i4 == 2) {
            if (parseInt % 100 != 12) {
                str2 = "nd";
            }
            return lowerCase.equals(str2);
        } else if (i4 != 3) {
            return lowerCase.equals(str2);
        } else {
            if (parseInt % 100 != 13) {
                str2 = "rd";
            }
            return lowerCase.equals(str2);
        }
    }

    static String c(String str) {
        Matcher matcher = q.matcher(str);
        int i2 = 0;
        while (matcher.find(i2)) {
            if (b(matcher.group(0))) {
                int start = matcher.start();
                int a2 = a(str, matcher);
                if (a2 > 0) {
                    return str.substring(start, a2);
                }
                i2 = -a2;
            } else {
                i2 = matcher.end();
            }
        }
        return null;
    }

    @VisibleForTesting
    public static boolean d(String str) {
        return s.matcher(str).matches();
    }

    @VisibleForTesting
    public static boolean e(String str) {
        return u.matcher(str).matches();
    }

    @VisibleForTesting
    public static boolean f(String str, String str2) {
        return g(str, i(str2, 0));
    }

    private static boolean g(String str, MatchResult matchResult) {
        if (matchResult == null) {
            return false;
        }
        int groupCount = matchResult.groupCount();
        while (true) {
            if (groupCount <= 0) {
                break;
            }
            int i2 = groupCount - 1;
            if (matchResult.group(groupCount) != null) {
                groupCount = i2;
                break;
            }
            groupCount = i2;
        }
        return u.matcher(str).matches() && f6224f[groupCount].a(str);
    }

    @VisibleForTesting
    public static MatchResult h(String str, int i2) {
        if (i2 > 0 && o.indexOf(str.charAt(i2 - 1)) == -1) {
            return null;
        }
        Matcher region = q.matcher(str).region(i2, str.length());
        if (region.lookingAt()) {
            MatchResult matchResult = region.toMatchResult();
            if (b(matchResult.group(0))) {
                return matchResult;
            }
        }
        return null;
    }

    @VisibleForTesting
    public static MatchResult i(String str, int i2) {
        if (i2 > 0 && f6228j.indexOf(str.charAt(i2 - 1)) == -1) {
            return null;
        }
        Matcher region = r.matcher(str).region(i2, str.length());
        if (region.lookingAt()) {
            return region.toMatchResult();
        }
        return null;
    }
}
