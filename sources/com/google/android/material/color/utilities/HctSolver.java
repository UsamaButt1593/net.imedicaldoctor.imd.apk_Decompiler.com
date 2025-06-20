package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class HctSolver {

    /* renamed from: a  reason: collision with root package name */
    static final double[][] f21210a = {new double[]{0.001200833568784504d, 0.002389694492170889d, 2.795742885861124E-4d}, new double[]{5.891086651375999E-4d, 0.0029785502573438758d, 3.270666104008398E-4d}, new double[]{1.0146692491640572E-4d, 5.364214359186694E-4d, 0.0032979401770712076d}};

    /* renamed from: b  reason: collision with root package name */
    static final double[][] f21211b = {new double[]{1373.2198709594231d, -1100.4251190754821d, -7.278681089101213d}, new double[]{-271.815969077903d, 559.6580465940733d, -32.46047482791194d}, new double[]{1.9622899599665666d, -57.173814538844006d, 308.7233197812385d}};

    /* renamed from: c  reason: collision with root package name */
    static final double[] f21212c = {0.2126d, 0.7152d, 0.0722d};

    /* renamed from: d  reason: collision with root package name */
    static final double[] f21213d = {0.015176349177441876d, 0.045529047532325624d, 0.07588174588720938d, 0.10623444424209313d, 0.13658714259697685d, 0.16693984095186062d, 0.19729253930674434d, 0.2276452376616281d, 0.2579979360165119d, 0.28835063437139563d, 0.3188300904430532d, 0.350925934958123d, 0.3848314933096426d, 0.42057480301049466d, 0.458183274052838d, 0.4976837250274023d, 0.5391024159806381d, 0.5824650784040898d, 0.6277969426914107d, 0.6751227633498623d, 0.7244668422128921d, 0.775853049866786d, 0.829304845476233d, 0.8848452951698498d, 0.942497089126609d, 1.0022825574869039d, 1.0642236851973577d, 1.1283421258858297d, 1.1946592148522128d, 1.2631959812511864d, 1.3339731595349034d, 1.407011200216447d, 1.4823302800086415d, 1.5599503113873272d, 1.6398909516233677d, 1.7221716113234105d, 1.8068114625156377d, 1.8938294463134073d, 1.9832442801866852d, 2.075074464868551d, 2.1693382909216234d, 2.2660538449872063d, 2.36523901573795d, 2.4669114995532007d, 2.5710888059345764d, 2.6777882626779785d, 2.7870270208169257d, 2.898822059350997d, 3.0131901897720907d, 3.1301480604002863d, 3.2497121605402226d, 3.3718988244681087d, 3.4967242352587946d, 3.624204428461639d, 3.754355295633311d, 3.887192587735158d, 4.022731918402185d, 4.160988767090289d, 4.301978482107941d, 4.445716283538092d, 4.592217266055746d, 4.741496401646282d, 4.893568542229298d, 5.048448422192488d, 5.20615066083972d, 5.3666897647573375d, 5.5300801301023865d, 5.696336044816294d, 5.865471690767354d, 6.037501145825082d, 6.212438385869475d, 6.390297286737924d, 6.571091626112461d, 6.7548350853498045d, 6.941541251256611d, 7.131223617812143d, 7.323895587840543d, 7.5195704746346665d, 7.7182615035334345d, 7.919981813454504d, 8.124744458384042d, 8.332562408825165d, 8.543448553206703d, 8.757415699253682d, 8.974476575321063d, 9.194643831691977d, 9.417930041841839d, 9.644347703669503d, 9.873909240696694d, 10.106627003236781d, 10.342513269534024d, 10.58158024687427d, 10.8238400726681d, 11.069304815507364d, 11.317986476196008d, 11.569896988756009d, 11.825048221409341d, 12.083451977536606d, 12.345119996613247d, 12.610063955123938d, 12.878295467455942d, 13.149826086772048d, 13.42466730586372d, 13.702830557985108d, 13.984327217668513d, 14.269168601521828d, 14.55736596900856d, 14.848930523210871d, 15.143873411576273d, 15.44220572664832d, 15.743938506781891d, 16.04908273684337d, 16.35764934889634d, 16.66964922287304d, 16.985093187232053d, 17.30399201960269d, 17.62635644741625d, 17.95219714852476d, 18.281524751807332d, 18.614349837764564d, 18.95068293910138d, 19.290534541298456d, 19.633915083172692d, 19.98083495742689d, 20.331304511189067d, 20.685334046541502d, 21.042933821039977d, 21.404114048223256d, 21.76888489811322d, 22.137256497705877d, 22.50923893145328d, 22.884842241736916d, 23.264076429332462d, 23.6469514538663d, 24.033477234264016d, 24.42366364919083d, 24.817520537484558d, 25.21505769858089d, 25.61628489293138d, 26.021211842414342d, 26.429848230738664d, 26.842203703840827d, 27.258287870275353d, 27.678110301598522d, 28.10168053274597d, 28.529008062403893d, 28.96010235337422d, 29.39497283293396d, 29.83362889318845d, 30.276079891419332d, 30.722335150426627d, 31.172403958865512d, 31.62629557157785d, 32.08401920991837d, 32.54558406207592d, 33.010999283389665d, 33.4802739966603d, 33.953417292456834d, 34.430438229418264d, 34.911345834551085d, 35.39614910352207d, 35.88485700094671d, 36.37747846067349d, 36.87402238606382d, 37.37449765026789d, 37.87891309649659d, 38.38727753828926d, 38.89959975977785d, 39.41588851594697d, 39.93615253289054d, 40.460400508064545d, 40.98864111053629d, 41.520882981230194d, 42.05713473317016d, 42.597404951718396d, 43.141702194811224d, 43.6900349931913d, 44.24241185063697d, 44.798841244188324d, 45.35933162437017d, 45.92389141541209d, 46.49252901546552d, 47.065252796817916d, 47.64207110610409d, 48.22299226451468d, 48.808024568002054d, 49.3971762874833d, 49.9904556690408d, 50.587870934119984d, 51.189430279724725d, 51.79514187861014d, 52.40501387947288d, 53.0190544071392d, 53.637271562750364d, 54.259673423945976d, 54.88626804504493d, 55.517063457223934d, 56.15206766869424d, 56.79128866487574d, 57.43473440856916d, 58.08241284012621d, 58.734331877617365d, 59.39049941699807d, 60.05092333227251d, 60.715611475655585d, 61.38457167773311d, 62.057811747619894d, 62.7353394731159d, 63.417162620860914d, 64.10328893648692d, 64.79372614476921d, 65.48848194977529d, 66.18756403501224d, 66.89098006357258d, 67.59873767827808d, 68.31084450182222d, 69.02730813691093d, 69.74813616640164d, 70.47333615344107d, 71.20291564160104d, 71.93688215501312d, 72.67524319850172d, 73.41800625771542d, 74.16517879925733d, 74.9167682708136d, 75.67278210128072d, 76.43322770089146d, 77.1981124613393d, 77.96744375590167d, 78.74122893956174d, 79.51947534912904d, 80.30219030335869d, 81.08938110306934d, 81.88105503125999d, 82.67721935322541d, 83.4778813166706d, 84.28304815182372d, 85.09272707154808d, 85.90692527145302d, 86.72564993000343d, 87.54890820862819d, 88.3767072518277d, 89.2090541872801d, 90.04595612594655d, 90.88742016217518d, 91.73345337380438d, 92.58406282226491d, 93.43925555268066d, 94.29903859396902d, 95.16341895893969d, 96.03240364439274d, 96.9059996312159d, 97.78421388448044d, 98.6670533535366d, 99.55452497210776d};

    private HctSolver() {
    }

    static boolean a(double d2, double d3, double d4) {
        return o(d3 - d2) < o(d4 - d2);
    }

    static double[] b(double d2, double d3) {
        int i2;
        int i3;
        double[][] c2 = c(d2, d3);
        double[] dArr = c2[0];
        double h2 = h(dArr);
        double[] dArr2 = c2[1];
        for (int i4 = 0; i4 < 3; i4++) {
            double d4 = dArr[i4];
            double d5 = dArr2[i4];
            if (d4 != d5) {
                int i5 = (d4 > d5 ? 1 : (d4 == d5 ? 0 : -1));
                double s = s(d4);
                if (i5 < 0) {
                    i3 = f(s);
                    i2 = e(s(dArr2[i4]));
                } else {
                    i3 = e(s);
                    i2 = f(s(dArr2[i4]));
                }
                int i6 = i3;
                int i7 = i2;
                for (int i8 = 0; i8 < 8 && Math.abs(i7 - i6) > 1; i8++) {
                    int floor = (int) Math.floor(((double) (i6 + i7)) / 2.0d);
                    double[] p = p(dArr, f21213d[floor], dArr2, i4);
                    double h3 = h(p);
                    int i9 = floor;
                    if (a(h2, d3, h3)) {
                        dArr2 = p;
                        i7 = i9;
                    } else {
                        dArr = p;
                        h2 = h3;
                        i6 = i9;
                    }
                }
            }
        }
        return m(dArr, dArr2);
    }

    static double[][] c(double d2, double d3) {
        double[] dArr = {-1.0d, -1.0d, -1.0d};
        double[] dArr2 = dArr;
        double d4 = 0.0d;
        double d5 = 0.0d;
        boolean z = false;
        boolean z2 = true;
        for (int i2 = 0; i2 < 12; i2++) {
            double[] n2 = n(d2, i2);
            if (n2[0] >= 0.0d) {
                double h2 = h(n2);
                if (!z) {
                    dArr = n2;
                    dArr2 = dArr;
                    d4 = h2;
                    d5 = d4;
                    z = true;
                } else if (z2 || a(d4, h2, d5)) {
                    if (a(d4, d3, h2)) {
                        dArr2 = n2;
                        d5 = h2;
                    } else {
                        dArr = n2;
                        d4 = h2;
                    }
                    z2 = false;
                }
            }
        }
        return new double[][]{dArr, dArr2};
    }

    static double d(double d2) {
        double pow = Math.pow(Math.abs(d2), 0.42d);
        return ((((double) MathUtils.i(d2)) * 400.0d) * pow) / (pow + 27.13d);
    }

    static int e(double d2) {
        return (int) Math.ceil(d2 - 0.5d);
    }

    static int f(double d2) {
        return (int) Math.floor(d2 - 0.5d);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0178, code lost:
        if (r4[0] > 100.01d) goto L_0x018d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x017e, code lost:
        if (r4[1] > 100.01d) goto L_0x018d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0185, code lost:
        if (r4[2] <= 100.01d) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x018c, code lost:
        return com.google.android.material.color.utilities.ColorUtils.c(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int g(double r34, double r36, double r38) {
        /*
            double r2 = java.lang.Math.sqrt(r38)
            r4 = 4622382067542392832(0x4026000000000000, double:11.0)
            double r2 = r2 * r4
            com.google.android.material.color.utilities.ViewingConditions r6 = com.google.android.material.color.utilities.ViewingConditions.f21290k
            double r7 = r6.f()
            r9 = 4598895795485655695(0x3fd28f5c28f5c28f, double:0.29)
            double r7 = java.lang.Math.pow(r9, r7)
            r9 = 4610064722561534525(0x3ffa3d70a3d70a3d, double:1.64)
            double r9 = r9 - r7
            r7 = 4604750475001237340(0x3fe75c28f5c28f5c, double:0.73)
            double r7 = java.lang.Math.pow(r9, r7)
            r9 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r7 = r9 / r7
            r11 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r13 = r34 + r11
            double r13 = java.lang.Math.cos(r13)
            r15 = 4615739258092021350(0x400e666666666666, double:3.8)
            double r13 = r13 + r15
            r15 = 4598175219545276416(0x3fd0000000000000, double:0.25)
            double r13 = r13 * r15
            r15 = 4660676196825845445(0x40ae0c4ec4ec4ec5, double:3846.153846153846)
            double r13 = r13 * r15
            double r15 = r6.h()
            double r13 = r13 * r15
            double r15 = r6.i()
            double r13 = r13 * r15
            double r15 = java.lang.Math.sin(r34)
            double r17 = java.lang.Math.cos(r34)
            r19 = 0
            r11 = 0
        L_0x005a:
            r12 = 5
            if (r11 >= r12) goto L_0x018d
            r20 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r0 = r2 / r20
            r20 = 0
            int r22 = (r36 > r20 ? 1 : (r36 == r20 ? 0 : -1))
            if (r22 == 0) goto L_0x0073
            int r22 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r22 != 0) goto L_0x006c
            goto L_0x0073
        L_0x006c:
            double r22 = java.lang.Math.sqrt(r0)
            double r22 = r36 / r22
            goto L_0x0075
        L_0x0073:
            r22 = r20
        L_0x0075:
            double r4 = r22 * r7
            r22 = r13
            r12 = 4607682818758614130(0x3ff1c71c71c71c72, double:1.1111111111111112)
            double r4 = java.lang.Math.pow(r4, r12)
            double r12 = r6.b()
            double r26 = r6.c()
            double r26 = r9 / r26
            double r28 = r6.k()
            double r9 = r26 / r28
            double r0 = java.lang.Math.pow(r0, r9)
            double r12 = r12 * r0
            double r0 = r6.g()
            double r12 = r12 / r0
            r0 = 4599166011463297925(0x3fd3851eb851eb85, double:0.305)
            double r0 = r0 + r12
            r9 = 4627167142146473984(0x4037000000000000, double:23.0)
            double r0 = r0 * r9
            double r0 = r0 * r4
            double r9 = r9 * r22
            r24 = 4622382067542392832(0x4026000000000000, double:11.0)
            double r26 = r4 * r24
            double r26 = r26 * r17
            double r9 = r9 + r26
            r26 = 4637300241308057600(0x405b000000000000, double:108.0)
            double r4 = r4 * r26
            double r4 = r4 * r15
            double r9 = r9 + r4
            double r0 = r0 / r9
            double r4 = r0 * r17
            double r0 = r0 * r15
            r9 = 4646800021772042240(0x407cc00000000000, double:460.0)
            double r12 = r12 * r9
            r9 = 4646641692097642496(0x407c300000000000, double:451.0)
            double r9 = r9 * r4
            double r9 = r9 + r12
            r26 = 4643774165772402688(0x4072000000000000, double:288.0)
            double r26 = r26 * r0
            double r9 = r9 + r26
            r26 = 4653885274701430784(0x4095ec0000000000, double:1403.0)
            double r9 = r9 / r26
            r28 = 4651048534701768704(0x408bd80000000000, double:891.0)
            double r28 = r28 * r4
            double r28 = r12 - r28
            r30 = 4643299176749203456(0x4070500000000000, double:261.0)
            double r30 = r30 * r0
            double r28 = r28 - r30
            double r28 = r28 / r26
            r30 = 4641944578423783424(0x406b800000000000, double:220.0)
            double r4 = r4 * r30
            double r12 = r12 - r4
            r4 = 4663648937956081664(0x40b89c0000000000, double:6300.0)
            double r0 = r0 * r4
            double r12 = r12 - r0
            double r12 = r12 / r26
            double r0 = j(r9)
            double r4 = j(r28)
            double r9 = j(r12)
            r12 = 3
            double[] r12 = new double[r12]
            r12[r19] = r0
            r0 = 1
            r12[r0] = r4
            r1 = 2
            r12[r1] = r9
            double[][] r4 = f21211b
            double[] r4 = com.google.android.material.color.utilities.MathUtils.e(r12, r4)
            r9 = r4[r19]
            int r5 = (r9 > r20 ? 1 : (r9 == r20 ? 0 : -1))
            if (r5 < 0) goto L_0x018d
            r13 = r4[r0]
            int r5 = (r13 > r20 ? 1 : (r13 == r20 ? 0 : -1))
            if (r5 < 0) goto L_0x018d
            r26 = r4[r1]
            int r5 = (r26 > r20 ? 1 : (r26 == r20 ? 0 : -1))
            if (r5 >= 0) goto L_0x0131
            goto L_0x018d
        L_0x0131:
            double[] r5 = f21212c
            r28 = r5[r19]
            r30 = r5[r0]
            r32 = r5[r1]
            double r28 = r28 * r9
            double r30 = r30 * r13
            double r28 = r28 + r30
            double r32 = r32 * r26
            double r28 = r28 + r32
            int r0 = (r28 > r20 ? 1 : (r28 == r20 ? 0 : -1))
            if (r0 > 0) goto L_0x0148
            return r19
        L_0x0148:
            r0 = 4
            if (r11 == r0) goto L_0x015a
            double r0 = r28 - r38
            double r9 = java.lang.Math.abs(r0)
            r13 = 4566758108544739836(0x3f60624dd2f1a9fc, double:0.002)
            int r5 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x015c
        L_0x015a:
            r0 = 1
            goto L_0x016f
        L_0x015c:
            double r0 = r0 * r2
            r9 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r28 = r28 * r9
            double r0 = r0 / r28
            double r2 = r2 - r0
            r0 = 1
            int r11 = r11 + r0
            r13 = r22
            r4 = r24
            r9 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L_0x005a
        L_0x016f:
            r1 = r4[r19]
            r5 = 4636737995042078065(0x405900a3d70a3d71, double:100.01)
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x018d
            r0 = r4[r0]
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 > 0) goto L_0x018d
            r0 = 2
            r0 = r4[r0]
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x0188
            goto L_0x018d
        L_0x0188:
            int r0 = com.google.android.material.color.utilities.ColorUtils.c(r4)
            return r0
        L_0x018d:
            return r19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.HctSolver.g(double, double, double):int");
    }

    static double h(double[] dArr) {
        double[] e2 = MathUtils.e(dArr, f21210a);
        double d2 = d(e2[0]);
        double d3 = d(e2[1]);
        double d4 = d(e2[2]);
        return Math.atan2(((d2 + d3) - (d4 * 2.0d)) / 9.0d, (((d2 * 11.0d) + (-12.0d * d3)) + d4) / 11.0d);
    }

    static double i(double d2, double d3, double d4) {
        return (d3 - d2) / (d4 - d2);
    }

    static double j(double d2) {
        double abs = Math.abs(d2);
        return ((double) MathUtils.i(d2)) * Math.pow(Math.max(0.0d, (27.13d * abs) / (400.0d - abs)), 2.380952380952381d);
    }

    static boolean k(double d2) {
        return 0.0d <= d2 && d2 <= 100.0d;
    }

    static double[] l(double[] dArr, double d2, double[] dArr2) {
        double d3 = dArr[0];
        double d4 = dArr[1];
        double d5 = dArr[2];
        return new double[]{d3 + ((dArr2[0] - d3) * d2), d4 + ((dArr2[1] - d4) * d2), d5 + ((dArr2[2] - d5) * d2)};
    }

    static double[] m(double[] dArr, double[] dArr2) {
        return new double[]{(dArr[0] + dArr2[0]) / 2.0d, (dArr[1] + dArr2[1]) / 2.0d, (dArr[2] + dArr2[2]) / 2.0d};
    }

    static double[] n(double d2, int i2) {
        int i3 = i2;
        double[] dArr = f21212c;
        double d3 = dArr[0];
        double d4 = dArr[1];
        double d5 = dArr[2];
        double d6 = 100.0d;
        double d7 = i3 % 4 <= 1 ? 0.0d : 100.0d;
        if (i3 % 2 == 0) {
            d6 = 0.0d;
        }
        if (i3 < 4) {
            double d8 = ((d2 - (d4 * d7)) - (d5 * d6)) / d3;
            if (!k(d8)) {
                return new double[]{-1.0d, -1.0d, -1.0d};
            }
            return new double[]{d8, d7, d6};
        } else if (i3 < 8) {
            double d9 = ((d2 - (d3 * d6)) - (d5 * d7)) / d4;
            if (!k(d9)) {
                return new double[]{-1.0d, -1.0d, -1.0d};
            }
            return new double[]{d6, d9, d7};
        } else {
            double d10 = ((d2 - (d3 * d7)) - (d4 * d6)) / d5;
            if (!k(d10)) {
                return new double[]{-1.0d, -1.0d, -1.0d};
            }
            return new double[]{d7, d6, d10};
        }
    }

    static double o(double d2) {
        return (d2 + 25.132741228718345d) % 6.283185307179586d;
    }

    static double[] p(double[] dArr, double d2, double[] dArr2, int i2) {
        return l(dArr, i(dArr[i2], d2, dArr2[i2]), dArr2);
    }

    public static Cam16 q(double d2, double d3, double d4) {
        return Cam16.b(r(d2, d3, d4));
    }

    public static int r(double d2, double d3, double d4) {
        if (d3 < 1.0E-4d || d4 < 1.0E-4d || d4 > 99.9999d) {
            return ColorUtils.d(d4);
        }
        double g2 = (MathUtils.g(d2) / 180.0d) * 3.141592653589793d;
        double t = ColorUtils.t(d4);
        int g3 = g(g2, d3, t);
        return g3 != 0 ? g3 : ColorUtils.c(b(t, g2));
    }

    static double s(double d2) {
        double d3 = d2 / 100.0d;
        return (d3 <= 0.0031308d ? d3 * 12.92d : (Math.pow(d3, 0.4166666666666667d) * 1.055d) - 0.055d) * 255.0d;
    }
}
