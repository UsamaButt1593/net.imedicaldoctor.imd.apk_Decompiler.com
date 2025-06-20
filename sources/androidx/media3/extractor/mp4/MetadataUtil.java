package androidx.media3.extractor.mp4;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.metadata.id3.ApicFrame;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.Id3Frame;
import androidx.media3.extractor.metadata.id3.InternalFrame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import com.google.common.collect.ImmutableList;
import com.google.common.net.HttpHeaders;
import java.util.List;

final class MetadataUtil {
    private static final int A = 1885823344;
    private static final int B = 1936683886;
    private static final int C = 1953919848;
    private static final int D = 757935405;
    private static final int E = 3;
    @VisibleForTesting
    static final String[] F = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.L0, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    private static final int G = 169;
    private static final int H = 253;

    /* renamed from: a  reason: collision with root package name */
    private static final String f13591a = "MetadataUtil";

    /* renamed from: b  reason: collision with root package name */
    private static final int f13592b = 7233901;

    /* renamed from: c  reason: collision with root package name */
    private static final int f13593c = 7631467;

    /* renamed from: d  reason: collision with root package name */
    private static final int f13594d = 6516084;

    /* renamed from: e  reason: collision with root package name */
    private static final int f13595e = 6578553;

    /* renamed from: f  reason: collision with root package name */
    private static final int f13596f = 4280916;

    /* renamed from: g  reason: collision with root package name */
    private static final int f13597g = 7630703;

    /* renamed from: h  reason: collision with root package name */
    private static final int f13598h = 6384738;

    /* renamed from: i  reason: collision with root package name */
    private static final int f13599i = 6516589;

    /* renamed from: j  reason: collision with root package name */
    private static final int f13600j = 7828084;

    /* renamed from: k  reason: collision with root package name */
    private static final int f13601k = 7108978;

    /* renamed from: l  reason: collision with root package name */
    private static final int f13602l = 6776174;

    /* renamed from: m  reason: collision with root package name */
    private static final int f13603m = 1668249202;

    /* renamed from: n  reason: collision with root package name */
    private static final int f13604n = 1735291493;
    private static final int o = 6779504;
    private static final int p = 1684632427;
    private static final int q = 1953655662;
    private static final int r = 1953329263;
    private static final int s = 1668311404;
    private static final int t = 1631670868;
    private static final int u = 1936682605;
    private static final int v = 1936679276;
    private static final int w = 1936679282;
    private static final int x = 1936679265;
    private static final int y = 1936679791;
    private static final int z = 1920233063;

    private MetadataUtil() {
    }

    @Nullable
    private static CommentFrame a(int i2, ParsableByteArray parsableByteArray) {
        int s2 = parsableByteArray.s();
        if (parsableByteArray.s() == 1684108385) {
            parsableByteArray.Z(8);
            String G2 = parsableByteArray.G(s2 - 16);
            return new CommentFrame(C.k1, G2, G2);
        }
        Log.n(f13591a, "Failed to parse comment attribute: " + Atom.a(i2));
        return null;
    }

    @Nullable
    private static ApicFrame b(ParsableByteArray parsableByteArray) {
        String str;
        int s2 = parsableByteArray.s();
        if (parsableByteArray.s() == 1684108385) {
            int b2 = Atom.b(parsableByteArray.s());
            String str2 = b2 == 13 ? MimeTypes.Q0 : b2 == 14 ? MimeTypes.R0 : null;
            if (str2 == null) {
                str = "Unrecognized cover art flags: " + b2;
            } else {
                parsableByteArray.Z(4);
                int i2 = s2 - 16;
                byte[] bArr = new byte[i2];
                parsableByteArray.n(bArr, 0, i2);
                return new ApicFrame(str2, (String) null, 3, bArr);
            }
        } else {
            str = "Failed to parse cover art attribute";
        }
        Log.n(f13591a, str);
        return null;
    }

    @Nullable
    public static Metadata.Entry c(ParsableByteArray parsableByteArray) {
        int f2 = parsableByteArray.f() + parsableByteArray.s();
        int s2 = parsableByteArray.s();
        int i2 = (s2 >> 24) & 255;
        if (i2 == G || i2 == H) {
            int i3 = 16777215 & s2;
            if (i3 == f13594d) {
                CommentFrame a2 = a(s2, parsableByteArray);
                parsableByteArray.Y(f2);
                return a2;
            } else if (i3 == f13592b || i3 == f13593c) {
                TextInformationFrame h2 = h(s2, "TIT2", parsableByteArray);
                parsableByteArray.Y(f2);
                return h2;
            } else if (i3 == f13599i || i3 == f13600j) {
                TextInformationFrame h3 = h(s2, "TCOM", parsableByteArray);
                parsableByteArray.Y(f2);
                return h3;
            } else if (i3 == f13595e) {
                TextInformationFrame h4 = h(s2, "TDRC", parsableByteArray);
                parsableByteArray.Y(f2);
                return h4;
            } else if (i3 == f13596f) {
                TextInformationFrame h5 = h(s2, "TPE1", parsableByteArray);
                parsableByteArray.Y(f2);
                return h5;
            } else if (i3 == f13597g) {
                TextInformationFrame h6 = h(s2, "TSSE", parsableByteArray);
                parsableByteArray.Y(f2);
                return h6;
            } else if (i3 == f13598h) {
                TextInformationFrame h7 = h(s2, "TALB", parsableByteArray);
                parsableByteArray.Y(f2);
                return h7;
            } else if (i3 == f13601k) {
                TextInformationFrame h8 = h(s2, "USLT", parsableByteArray);
                parsableByteArray.Y(f2);
                return h8;
            } else if (i3 == f13602l) {
                TextInformationFrame h9 = h(s2, "TCON", parsableByteArray);
                parsableByteArray.Y(f2);
                return h9;
            } else if (i3 == o) {
                TextInformationFrame h10 = h(s2, "TIT1", parsableByteArray);
                parsableByteArray.Y(f2);
                return h10;
            }
        } else if (s2 == f13604n) {
            try {
                return g(parsableByteArray);
            } finally {
                parsableByteArray.Y(f2);
            }
        } else if (s2 == p) {
            TextInformationFrame d2 = d(s2, "TPOS", parsableByteArray);
            parsableByteArray.Y(f2);
            return d2;
        } else if (s2 == q) {
            TextInformationFrame d3 = d(s2, "TRCK", parsableByteArray);
            parsableByteArray.Y(f2);
            return d3;
        } else if (s2 == r) {
            Id3Frame i4 = i(s2, "TBPM", parsableByteArray, true, false);
            parsableByteArray.Y(f2);
            return i4;
        } else if (s2 == s) {
            Id3Frame i5 = i(s2, "TCMP", parsableByteArray, true, true);
            parsableByteArray.Y(f2);
            return i5;
        } else if (s2 == f13603m) {
            ApicFrame b2 = b(parsableByteArray);
            parsableByteArray.Y(f2);
            return b2;
        } else if (s2 == t) {
            TextInformationFrame h11 = h(s2, "TPE2", parsableByteArray);
            parsableByteArray.Y(f2);
            return h11;
        } else if (s2 == u) {
            TextInformationFrame h12 = h(s2, "TSOT", parsableByteArray);
            parsableByteArray.Y(f2);
            return h12;
        } else if (s2 == v) {
            TextInformationFrame h13 = h(s2, "TSO2", parsableByteArray);
            parsableByteArray.Y(f2);
            return h13;
        } else if (s2 == w) {
            TextInformationFrame h14 = h(s2, "TSOA", parsableByteArray);
            parsableByteArray.Y(f2);
            return h14;
        } else if (s2 == x) {
            TextInformationFrame h15 = h(s2, "TSOP", parsableByteArray);
            parsableByteArray.Y(f2);
            return h15;
        } else if (s2 == y) {
            TextInformationFrame h16 = h(s2, "TSOC", parsableByteArray);
            parsableByteArray.Y(f2);
            return h16;
        } else if (s2 == z) {
            Id3Frame i6 = i(s2, "ITUNESADVISORY", parsableByteArray, false, false);
            parsableByteArray.Y(f2);
            return i6;
        } else if (s2 == A) {
            Id3Frame i7 = i(s2, "ITUNESGAPLESS", parsableByteArray, false, true);
            parsableByteArray.Y(f2);
            return i7;
        } else if (s2 == B) {
            TextInformationFrame h17 = h(s2, "TVSHOWSORT", parsableByteArray);
            parsableByteArray.Y(f2);
            return h17;
        } else if (s2 == C) {
            TextInformationFrame h18 = h(s2, "TVSHOW", parsableByteArray);
            parsableByteArray.Y(f2);
            return h18;
        } else if (s2 == D) {
            Id3Frame e2 = e(parsableByteArray, f2);
            parsableByteArray.Y(f2);
            return e2;
        }
        Log.b(f13591a, "Skipped unknown metadata entry: " + Atom.a(s2));
        parsableByteArray.Y(f2);
        return null;
    }

    @Nullable
    private static TextInformationFrame d(int i2, String str, ParsableByteArray parsableByteArray) {
        int s2 = parsableByteArray.s();
        if (parsableByteArray.s() == 1684108385 && s2 >= 22) {
            parsableByteArray.Z(10);
            int R = parsableByteArray.R();
            if (R > 0) {
                String str2 = "" + R;
                int R2 = parsableByteArray.R();
                if (R2 > 0) {
                    str2 = str2 + "/" + R2;
                }
                return new TextInformationFrame(str, (String) null, (List<String>) ImmutableList.K(str2));
            }
        }
        Log.n(f13591a, "Failed to parse index/count attribute: " + Atom.a(i2));
        return null;
    }

    @Nullable
    private static Id3Frame e(ParsableByteArray parsableByteArray, int i2) {
        String str = null;
        String str2 = null;
        int i3 = -1;
        int i4 = -1;
        while (parsableByteArray.f() < i2) {
            int f2 = parsableByteArray.f();
            int s2 = parsableByteArray.s();
            int s3 = parsableByteArray.s();
            parsableByteArray.Z(4);
            if (s3 == 1835360622) {
                str = parsableByteArray.G(s2 - 12);
            } else if (s3 == 1851878757) {
                str2 = parsableByteArray.G(s2 - 12);
            } else {
                if (s3 == 1684108385) {
                    i3 = f2;
                    i4 = s2;
                }
                parsableByteArray.Z(s2 - 12);
            }
        }
        if (str == null || str2 == null || i3 == -1) {
            return null;
        }
        parsableByteArray.Y(i3);
        parsableByteArray.Z(16);
        return new InternalFrame(str, str2, parsableByteArray.G(i4 - 16));
    }

    @Nullable
    public static MdtaMetadataEntry f(ParsableByteArray parsableByteArray, int i2, String str) {
        while (true) {
            int f2 = parsableByteArray.f();
            if (f2 >= i2) {
                return null;
            }
            int s2 = parsableByteArray.s();
            if (parsableByteArray.s() == 1684108385) {
                int s3 = parsableByteArray.s();
                int s4 = parsableByteArray.s();
                int i3 = s2 - 16;
                byte[] bArr = new byte[i3];
                parsableByteArray.n(bArr, 0, i3);
                return new MdtaMetadataEntry(str, bArr, s4, s3);
            }
            parsableByteArray.Y(f2 + s2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0020  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.media3.extractor.metadata.id3.TextInformationFrame g(androidx.media3.common.util.ParsableByteArray r3) {
        /*
            int r3 = j(r3)
            r0 = 0
            if (r3 <= 0) goto L_0x0011
            java.lang.String[] r1 = F
            int r2 = r1.length
            if (r3 > r2) goto L_0x0011
            int r3 = r3 + -1
            r3 = r1[r3]
            goto L_0x0012
        L_0x0011:
            r3 = r0
        L_0x0012:
            if (r3 == 0) goto L_0x0020
            androidx.media3.extractor.metadata.id3.TextInformationFrame r1 = new androidx.media3.extractor.metadata.id3.TextInformationFrame
            java.lang.String r2 = "TCON"
            com.google.common.collect.ImmutableList r3 = com.google.common.collect.ImmutableList.K(r3)
            r1.<init>((java.lang.String) r2, (java.lang.String) r0, (java.util.List<java.lang.String>) r3)
            return r1
        L_0x0020:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            androidx.media3.common.util.Log.n(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.MetadataUtil.g(androidx.media3.common.util.ParsableByteArray):androidx.media3.extractor.metadata.id3.TextInformationFrame");
    }

    @Nullable
    private static TextInformationFrame h(int i2, String str, ParsableByteArray parsableByteArray) {
        int s2 = parsableByteArray.s();
        if (parsableByteArray.s() == 1684108385) {
            parsableByteArray.Z(8);
            return new TextInformationFrame(str, (String) null, (List<String>) ImmutableList.K(parsableByteArray.G(s2 - 16)));
        }
        Log.n(f13591a, "Failed to parse text attribute: " + Atom.a(i2));
        return null;
    }

    @Nullable
    private static Id3Frame i(int i2, String str, ParsableByteArray parsableByteArray, boolean z2, boolean z3) {
        int j2 = j(parsableByteArray);
        if (z3) {
            j2 = Math.min(1, j2);
        }
        if (j2 >= 0) {
            return z2 ? new TextInformationFrame(str, (String) null, (List<String>) ImmutableList.K(Integer.toString(j2))) : new CommentFrame(C.k1, str, Integer.toString(j2));
        }
        Log.n(f13591a, "Failed to parse uint8 attribute: " + Atom.a(i2));
        return null;
    }

    private static int j(ParsableByteArray parsableByteArray) {
        parsableByteArray.Z(4);
        if (parsableByteArray.s() == 1684108385) {
            parsableByteArray.Z(8);
            return parsableByteArray.L();
        }
        Log.n(f13591a, "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void k(int i2, GaplessInfoHolder gaplessInfoHolder, Format.Builder builder) {
        if (i2 == 1 && gaplessInfoHolder.a()) {
            builder.S(gaplessInfoHolder.f13068a).T(gaplessInfoHolder.f13069b);
        }
    }

    public static void l(int i2, @Nullable Metadata metadata, Format.Builder builder, Metadata... metadataArr) {
        Metadata metadata2 = new Metadata(new Metadata.Entry[0]);
        if (metadata != null) {
            for (int i3 = 0; i3 < metadata.g(); i3++) {
                Metadata.Entry d2 = metadata.d(i3);
                if (d2 instanceof MdtaMetadataEntry) {
                    MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) d2;
                    if (!mdtaMetadataEntry.s.equals(MdtaMetadataEntry.X2)) {
                        metadata2 = metadata2.a(mdtaMetadataEntry);
                    } else if (i2 == 2) {
                        metadata2 = metadata2.a(mdtaMetadataEntry);
                    }
                }
            }
        }
        for (Metadata b2 : metadataArr) {
            metadata2 = metadata2.b(b2);
        }
        if (metadata2.g() > 0) {
            builder.d0(metadata2);
        }
    }
}
