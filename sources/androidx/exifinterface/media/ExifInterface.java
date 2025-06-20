package androidx.exifinterface.media;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterfaceUtils;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.common.base.Ascii;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import net.imedicaldoctor.imd.BuildConfig;
import net.lingala.zip4j.util.InternalZipConstants;

public class ExifInterface {
    public static final String A = "Compression";
    public static final String A0 = "OECF";
    public static final String A1 = "GPSLongitudeRef";
    private static final String A2 = "CameraSettingsIFDPointer";
    public static final short A3 = 9;
    public static final short A4 = 2;
    public static final int A5 = 0;
    private static final int A6 = 9;
    private static final byte A7 = -49;
    public static final String B = "PhotometricInterpretation";
    public static final String B0 = "SensitivityType";
    public static final String B1 = "GPSLongitude";
    private static final String B2 = "ImageProcessingIFDPointer";
    public static final short B3 = 10;
    public static final short B4 = 3;
    public static final int B5 = 1;
    private static final int B6 = 10;
    private static final byte B7 = -38;
    public static final String C = "Orientation";
    public static final String C0 = "StandardOutputSensitivity";
    public static final String C1 = "GPSAltitudeRef";
    private static final int C2 = 512;
    public static final short C3 = 11;
    public static final short C4 = 4;
    private static final int C5 = 5000;
    private static final int C6 = 11;
    static final byte C7 = -31;
    public static final String D = "SamplesPerPixel";
    public static final String D0 = "RecommendedExposureIndex";
    public static final String D1 = "GPSAltitude";
    public static final int D2 = 0;
    public static final short D3 = 12;
    public static final short D4 = 0;
    static final byte[] D5 = {-1, n7, -1};
    private static final int D6 = 12;
    private static final byte D7 = -2;
    public static final String E = "PlanarConfiguration";
    public static final String E0 = "ISOSpeed";
    public static final String E1 = "GPSTimeStamp";
    public static final int E2 = 1;
    public static final short E3 = 13;
    public static final short E4 = 1;
    private static final String E5 = "FUJIFILMCCD-RAW";
    private static final int E6 = 13;
    static final byte E7 = -39;
    public static final String F = "YCbCrSubSampling";
    public static final String F0 = "ISOSpeedLatitudeyyy";
    public static final String F1 = "GPSSatellites";
    public static final int F2 = 2;
    public static final short F3 = 14;
    public static final short F4 = 2;
    private static final int F5 = 84;
    private static final int F6 = 8192;
    static final int F7 = 0;
    public static final String G = "YCbCrPositioning";
    public static final String G0 = "ISOSpeedLatitudezzz";
    public static final String G1 = "GPSStatus";
    public static final int G2 = 3;
    public static final short G3 = 15;
    public static final short G4 = 0;
    private static final byte[] G5 = {102, 116, 121, 112};
    static final String[] G6 = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int G7 = 1;
    public static final String H = "XResolution";
    public static final String H0 = "ShutterSpeedValue";
    public static final String H1 = "GPSMeasureMode";
    public static final int H2 = 4;
    public static final short H3 = 16;
    public static final short H4 = 0;
    private static final byte[] H5 = {109, 105, 102, 49};
    static final int[] H6 = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final int H7 = 2;
    public static final String I = "YResolution";
    public static final String I0 = "ApertureValue";
    public static final String I1 = "GPSDOP";
    public static final int I2 = 5;
    public static final short I3 = 17;
    public static final short I4 = 0;
    private static final byte[] I5 = {104, 101, 105, 99};
    static final byte[] I6 = {65, 83, 67, 73, 73, 0, 0, 0};
    static final int I7 = 3;
    public static final String J = "ResolutionUnit";
    public static final String J0 = "BrightnessValue";
    public static final String J1 = "GPSSpeedRef";
    public static final int J2 = 6;
    public static final short J3 = 18;
    public static final short J4 = 0;
    private static final short J5 = 20306;
    private static final ExifTag[] J6;
    static final int J7 = 4;
    public static final String K = "StripOffsets";
    public static final String K0 = "ExposureBiasValue";
    public static final String K1 = "GPSSpeed";
    public static final int K2 = 7;
    public static final short K3 = 19;
    public static final short K4 = 1;
    private static final short K5 = 21330;
    private static final ExifTag[] K6;
    static final int K7 = 5;
    public static final String L = "RowsPerStrip";
    public static final String L0 = "MaxApertureValue";
    public static final String L1 = "GPSTrackRef";
    public static final int L2 = 8;
    public static final short L3 = 20;
    public static final short L4 = 2;
    private static final byte[] L5 = {79, 76, 89, 77, 80, 0};
    private static final ExifTag[] L6;
    static final int L7 = 6;
    public static final String M = "StripByteCounts";
    public static final String M0 = "SubjectDistance";
    public static final String M1 = "GPSTrack";
    private static final List<Integer> M2 = Arrays.asList(new Integer[]{1, 6, 3, 8});
    public static final short M3 = 21;
    public static final short M4 = 0;
    private static final byte[] M5 = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final ExifTag[] M6;
    static final int M7 = 7;
    public static final String N = "JPEGInterchangeFormat";
    public static final String N0 = "MeteringMode";
    public static final String N1 = "GPSImgDirectionRef";
    private static final List<Integer> N2 = Arrays.asList(new Integer[]{2, 7, 4, 5});
    public static final short N3 = 22;
    public static final short N4 = 1;
    private static final int N5 = 8;
    private static final ExifTag[] N6;
    static final int N7 = 8;
    public static final String O = "JPEGInterchangeFormatLength";
    public static final String O0 = "LightSource";
    public static final String O1 = "GPSImgDirection";
    public static final short O2 = 1;
    public static final short O3 = 23;
    public static final short O4 = 2;
    private static final int O5 = 12;
    private static final ExifTag O6;
    static final int O7 = 9;
    public static final String P = "TransferFunction";
    public static final String P0 = "Flash";
    public static final String P1 = "GPSMapDatum";
    public static final short P2 = 2;
    public static final short P3 = 24;
    public static final short P4 = 3;
    private static final short P5 = 85;
    private static final ExifTag[] P6;
    static final int P7 = 10;
    public static final String Q = "WhitePoint";
    public static final String Q0 = "SubjectArea";
    public static final String Q1 = "GPSDestLatitudeRef";
    public static final short Q2 = 1;
    public static final short Q3 = 255;
    public static final String Q4 = "N";
    private static final String Q5 = "PENTAX";
    private static final ExifTag[] Q6;
    static final int Q7 = 11;
    public static final String R = "PrimaryChromaticities";
    public static final String R0 = "FocalLength";
    public static final String R1 = "GPSDestLatitude";
    public static final short R2 = 2;
    public static final short R3 = 1;
    public static final String R4 = "S";
    private static final int R5 = 6;
    private static final ExifTag[] R6;
    static final int R7 = 12;
    public static final String S = "YCbCrCoefficients";
    public static final String S0 = "FlashEnergy";
    public static final String S1 = "GPSDestLongitudeRef";
    public static final short S2 = 2;
    public static final short S3 = 4;
    public static final String S4 = "E";
    private static final byte[] S5 = {-119, 80, 78, 71, 13, 10, Ascii.D, 10};
    private static final ExifTag[] S6;
    static final int S7 = 13;
    public static final String T = "ReferenceBlackWhite";
    public static final String T0 = "SpatialFrequencyResponse";
    public static final String T1 = "GPSDestLongitude";
    public static final short T2 = 3;
    public static final short T3 = 6;
    public static final String T4 = "W";
    private static final byte[] T5 = {101, 88, 73, 102};
    static final int T6 = 0;
    static final int T7 = 14;
    public static final String U = "DateTime";
    public static final String U0 = "FocalPlaneXResolution";
    public static final String U1 = "GPSDestBearingRef";
    public static final int U2 = 1;
    public static final short U3 = 8;
    public static final short U4 = 0;
    private static final byte[] U5 = {73, 72, 68, 82};
    private static final int U6 = 1;
    private static final Pattern U7 = Pattern.compile(".*[1-9].*");
    public static final String V = "ImageDescription";
    public static final String V0 = "FocalPlaneYResolution";
    public static final String V1 = "GPSDestBearing";
    public static final int V2 = 65535;
    public static final short V3 = 16;
    public static final short V4 = 1;
    private static final byte[] V5 = {73, 69, 78, 68};
    private static final int V6 = 2;
    private static final Pattern V7 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
    public static final String W = "Make";
    public static final String W0 = "FocalPlaneResolutionUnit";
    public static final String W1 = "GPSDestDistanceRef";
    public static final short W2 = 0;
    public static final short W3 = 24;
    public static final String W4 = "A";
    private static final int W5 = 4;
    private static final int W6 = 3;
    private static final Pattern W7 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    public static final String X = "Model";
    public static final String X0 = "SubjectLocation";
    public static final String X1 = "GPSDestDistance";
    public static final short X2 = 1;
    public static final short X3 = 32;
    public static final String X4 = "V";
    private static final int X5 = 4;
    static final int X6 = 4;
    private static final Pattern X7 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    public static final String Y = "Software";
    public static final String Y0 = "ExposureIndex";
    public static final String Y1 = "GPSProcessingMethod";
    public static final short Y2 = 2;
    public static final short Y3 = 64;
    public static final String Y4 = "2";
    private static final byte[] Y5 = {82, 73, 70, 70};
    static final int Y6 = 5;
    private static final int Y7 = 19;
    public static final String Z = "Artist";
    public static final String Z0 = "SensingMethod";
    public static final String Z1 = "GPSAreaInformation";
    public static final short Z2 = 3;
    public static final short Z3 = 1;
    public static final String Z4 = "3";
    private static final byte[] Z5 = {87, 69, 66, 80};
    private static final int Z6 = 6;
    public static final String a0 = "Copyright";
    public static final String a1 = "FileSource";
    public static final String a2 = "GPSDateStamp";
    public static final short a3 = 4;
    public static final short a4 = 2;
    public static final String a5 = "K";
    private static final int a6 = 4;
    private static final int a7 = 7;
    public static final String b0 = "ExifVersion";
    public static final String b1 = "SceneType";
    public static final String b2 = "GPSDifferential";
    public static final short b3 = 5;
    public static final short b4 = 3;
    public static final String b5 = "M";
    private static final byte[] b6 = {69, 88, 73, 70};
    private static final int b7 = 8;
    public static final String c0 = "FlashpixVersion";
    public static final String c1 = "CFAPattern";
    public static final String c2 = "GPSHPositioningError";
    public static final short c3 = 6;
    public static final short c4 = 4;
    public static final String c5 = "N";
    private static final byte[] c6 = {-99, 1, q6};
    private static final int c7 = 9;
    public static final String d0 = "ColorSpace";
    public static final String d1 = "CustomRendered";
    public static final String d2 = "InteroperabilityIndex";
    public static final short d3 = 7;
    public static final short d4 = 5;
    public static final String d5 = "T";
    private static final byte d6 = 47;
    static final ExifTag[][] d7;
    public static final String e0 = "Gamma";
    public static final String e1 = "ExposureMode";
    public static final String e2 = "ThumbnailImageLength";
    public static final short e3 = 8;
    public static final short e4 = 7;
    public static final String e5 = "M";
    private static final byte[] e6 = "VP8X".getBytes(Charset.defaultCharset());
    private static final ExifTag[] e7;
    public static final String f0 = "PixelXDimension";
    public static final String f1 = "WhiteBalance";
    public static final String f2 = "ThumbnailImageWidth";
    public static final short f3 = 0;
    public static final short f4 = 8;
    public static final String f5 = "K";
    private static final byte[] f6 = "VP8L".getBytes(Charset.defaultCharset());
    private static final HashMap<Integer, ExifTag>[] f7;
    public static final String g0 = "PixelYDimension";
    public static final String g1 = "DigitalZoomRatio";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String g2 = "ThumbnailOrientation";
    public static final short g3 = 1;
    public static final short g4 = 0;
    public static final String g5 = "M";
    private static final byte[] g6 = "VP8 ".getBytes(Charset.defaultCharset());
    private static final HashMap<String, ExifTag>[] g7;
    public static final String h0 = "ComponentsConfiguration";
    public static final String h1 = "FocalLengthIn35mmFilm";
    public static final String h2 = "DNGVersion";
    public static final short h3 = 2;
    public static final short h4 = 1;
    public static final String h5 = "N";
    private static final byte[] h6 = "ANIM".getBytes(Charset.defaultCharset());
    private static final HashSet<String> h7 = new HashSet<>(Arrays.asList(new String[]{v0, g1, u0, M0, E1}));
    public static final String i0 = "CompressedBitsPerPixel";
    public static final String i1 = "SceneCaptureType";
    public static final String i2 = "DefaultCropSize";
    public static final short i3 = 3;
    public static final short i4 = 2;
    public static final short i5 = 0;
    private static final byte[] i6 = "ANMF".getBytes(Charset.defaultCharset());
    private static final HashMap<Integer, Integer> i7 = new HashMap<>();
    public static final String j0 = "MakerNote";
    public static final String j1 = "GainControl";
    public static final String j2 = "ThumbnailImage";
    public static final short j3 = 4;
    public static final short j4 = 3;
    public static final short j5 = 1;
    private static final int j6 = 10;
    static final Charset j7;
    public static final String k0 = "UserComment";
    public static final String k1 = "Contrast";
    public static final String k2 = "PreviewImageStart";
    public static final short k3 = 5;
    public static final short k4 = 1;
    public static final int k5 = 1;
    private static final int k6 = 4;
    static final byte[] k7;
    public static final String l0 = "RelatedSoundFile";
    public static final String l1 = "Saturation";
    public static final String l2 = "PreviewImageLength";
    public static final short l3 = 6;
    public static final short l4 = 0;
    public static final int l5 = 2;
    private static final int l6 = 4;
    private static final byte[] l7;
    public static final String m0 = "DateTimeOriginal";
    public static final String m1 = "Sharpness";
    public static final String m2 = "AspectFrame";
    public static final short m3 = 7;
    public static final short m4 = 1;
    public static final int m5 = 6;
    private static SimpleDateFormat m6 = null;
    static final byte m7 = -1;
    public static final String n0 = "DateTimeDigitized";
    public static final String n1 = "DeviceSettingDescription";
    public static final String n2 = "SensorBottomBorder";
    public static final short n3 = 0;
    public static final short n4 = 0;
    public static final int n5 = 7;
    private static SimpleDateFormat n6 = null;
    private static final byte n7 = -40;
    public static final String o0 = "OffsetTime";
    public static final String o1 = "SubjectDistanceRange";
    public static final String o2 = "SensorLeftBorder";
    public static final short o3 = 1;
    public static final short o4 = 1;
    public static final int o5 = 8;
    static final short o6 = 18761;
    private static final byte o7 = -64;
    public static final String p0 = "OffsetTimeOriginal";
    public static final String p1 = "ImageUniqueID";
    public static final String p2 = "SensorRightBorder";
    public static final short p3 = 2;
    public static final short p4 = 2;
    public static final int p5 = 32773;
    static final short p6 = 19789;
    private static final byte p7 = -63;
    public static final String q0 = "OffsetTimeDigitized";
    @Deprecated
    public static final String q1 = "CameraOwnerName";
    public static final String q2 = "SensorTopBorder";
    public static final short q3 = 3;
    @Deprecated
    public static final int q4 = 0;
    public static final int q5 = 34892;
    static final byte q6 = 42;
    private static final byte q7 = -62;
    public static final String r0 = "SubSecTime";
    public static final String r1 = "CameraOwnerName";
    public static final String r2 = "ISO";
    public static final short r3 = 4;
    @Deprecated
    public static final int r4 = 1;
    public static final int[] r5 = {8, 8, 8};
    private static final int r6 = 8;
    private static final byte r7 = -61;
    public static final String s0 = "SubSecTimeOriginal";
    public static final String s1 = "BodySerialNumber";
    public static final String s2 = "JpgFromRaw";
    public static final short s3 = 5;
    public static final short s4 = 0;
    public static final int[] s5 = {4};
    private static final int s6 = 1;
    private static final byte s7 = -59;
    public static final String t0 = "SubSecTimeDigitized";
    public static final String t1 = "LensSpecification";
    public static final String t2 = "Xmp";
    public static final short t3 = 6;
    public static final short t4 = 1;
    public static final int[] t5 = {8};
    private static final int t6 = 2;
    private static final byte t7 = -58;
    public static final String u0 = "ExposureTime";
    public static final String u1 = "LensMake";
    public static final String u2 = "NewSubfileType";
    public static final short u3 = 255;
    public static final short u4 = 0;
    public static final int u5 = 0;
    private static final int u6 = 3;
    private static final byte u7 = -57;
    private static final String v = "ExifInterface";
    public static final String v0 = "FNumber";
    public static final String v1 = "LensModel";
    public static final String v2 = "SubfileType";
    public static final short v3 = 0;
    public static final short v4 = 1;
    public static final int v5 = 1;
    private static final int v6 = 4;
    private static final byte v7 = -55;
    private static final boolean w = Log.isLoggable(v, 3);
    public static final String w0 = "ExposureProgram";
    public static final String w1 = "LensSerialNumber";
    private static final String w2 = "ExifIFDPointer";
    public static final short w3 = 1;
    public static final short w4 = 2;
    public static final int w5 = 2;
    private static final int w6 = 5;
    private static final byte w7 = -54;
    public static final String x = "ImageWidth";
    public static final String x0 = "SpectralSensitivity";
    public static final String x1 = "GPSVersionID";
    private static final String x2 = "GPSInfoIFDPointer";
    public static final short x3 = 2;
    public static final short x4 = 3;
    public static final int x5 = 6;
    private static final int x6 = 6;
    private static final byte x7 = -53;
    public static final String y = "ImageLength";
    @Deprecated
    public static final String y0 = "ISOSpeedRatings";
    public static final String y1 = "GPSLatitudeRef";
    private static final String y2 = "InteroperabilityIFDPointer";
    public static final short y3 = 3;
    public static final short y4 = 0;
    public static final int y5 = 0;
    private static final int y6 = 7;
    private static final byte y7 = -51;
    public static final String z = "BitsPerSample";
    public static final String z0 = "PhotographicSensitivity";
    public static final String z1 = "GPSLatitude";
    private static final String z2 = "SubIFDPointer";
    public static final short z3 = 4;
    public static final short z4 = 1;
    public static final int z5 = 1;
    private static final int z6 = 8;
    private static final byte z7 = -50;

    /* renamed from: a  reason: collision with root package name */
    private String f7806a;

    /* renamed from: b  reason: collision with root package name */
    private FileDescriptor f7807b;

    /* renamed from: c  reason: collision with root package name */
    private AssetManager.AssetInputStream f7808c;

    /* renamed from: d  reason: collision with root package name */
    private int f7809d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7810e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, ExifAttribute>[] f7811f;

    /* renamed from: g  reason: collision with root package name */
    private Set<Integer> f7812g;

    /* renamed from: h  reason: collision with root package name */
    private ByteOrder f7813h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7814i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f7815j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7816k;

    /* renamed from: l  reason: collision with root package name */
    private int f7817l;

    /* renamed from: m  reason: collision with root package name */
    private int f7818m;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f7819n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;

    private static class ByteOrderedDataInputStream extends InputStream implements DataInput {
        private static final ByteOrder X2 = ByteOrder.LITTLE_ENDIAN;
        private static final ByteOrder Y2 = ByteOrder.BIG_ENDIAN;
        private ByteOrder X;
        int Y;
        private byte[] Z;
        final DataInputStream s;

        ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public int available() throws IOException {
            return this.s.available();
        }

        public int b() {
            return this.Y;
        }

        public long c() throws IOException {
            return ((long) readInt()) & InternalZipConstants.f30717k;
        }

        public void d(ByteOrder byteOrder) {
            this.X = byteOrder;
        }

        public void e(int i2) throws IOException {
            int i3 = 0;
            while (i3 < i2) {
                int i4 = i2 - i3;
                int skip = (int) this.s.skip((long) i4);
                if (skip <= 0) {
                    if (this.Z == null) {
                        this.Z = new byte[8192];
                    }
                    skip = this.s.read(this.Z, 0, Math.min(8192, i4));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i2 + " bytes.");
                    }
                }
                i3 += skip;
            }
            this.Y += i3;
        }

        public void mark(int i2) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        public int read() throws IOException {
            this.Y++;
            return this.s.read();
        }

        public boolean readBoolean() throws IOException {
            this.Y++;
            return this.s.readBoolean();
        }

        public byte readByte() throws IOException {
            this.Y++;
            int read = this.s.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        public char readChar() throws IOException {
            this.Y += 2;
            return this.s.readChar();
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public void readFully(byte[] bArr) throws IOException {
            this.Y += bArr.length;
            this.s.readFully(bArr);
        }

        public int readInt() throws IOException {
            this.Y += 4;
            int read = this.s.read();
            int read2 = this.s.read();
            int read3 = this.s.read();
            int read4 = this.s.read();
            if ((read | read2 | read3 | read4) >= 0) {
                ByteOrder byteOrder = this.X;
                if (byteOrder == X2) {
                    return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == Y2) {
                    return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                }
                throw new IOException("Invalid byte order: " + this.X);
            }
            throw new EOFException();
        }

        public String readLine() throws IOException {
            Log.d(ExifInterface.v, "Currently unsupported");
            return null;
        }

        public long readLong() throws IOException {
            this.Y += 8;
            int read = this.s.read();
            int read2 = this.s.read();
            int read3 = this.s.read();
            int read4 = this.s.read();
            int read5 = this.s.read();
            int read6 = this.s.read();
            int read7 = this.s.read();
            int read8 = this.s.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                ByteOrder byteOrder = this.X;
                if (byteOrder == X2) {
                    return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                }
                int i2 = read2;
                if (byteOrder == Y2) {
                    return (((long) read) << 56) + (((long) i2) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                }
                throw new IOException("Invalid byte order: " + this.X);
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            this.Y += 2;
            int read = this.s.read();
            int read2 = this.s.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.X;
                if (byteOrder == X2) {
                    return (short) ((read2 << 8) + read);
                }
                if (byteOrder == Y2) {
                    return (short) ((read << 8) + read2);
                }
                throw new IOException("Invalid byte order: " + this.X);
            }
            throw new EOFException();
        }

        public String readUTF() throws IOException {
            this.Y += 2;
            return this.s.readUTF();
        }

        public int readUnsignedByte() throws IOException {
            this.Y++;
            return this.s.readUnsignedByte();
        }

        public int readUnsignedShort() throws IOException {
            this.Y += 2;
            int read = this.s.read();
            int read2 = this.s.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.X;
                if (byteOrder == X2) {
                    return (read2 << 8) + read;
                }
                if (byteOrder == Y2) {
                    return (read << 8) + read2;
                }
                throw new IOException("Invalid byte order: " + this.X);
            }
            throw new EOFException();
        }

        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        public int skipBytes(int i2) throws IOException {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.X = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.s = dataInputStream;
            dataInputStream.mark(0);
            this.Y = 0;
            this.X = byteOrder;
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int read = this.s.read(bArr, i2, i3);
            this.Y += read;
            return read;
        }

        public void readFully(byte[] bArr, int i2, int i3) throws IOException {
            this.Y += i3;
            this.s.readFully(bArr, i2, i3);
        }

        ByteOrderedDataInputStream(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }
    }

    private static class ByteOrderedDataOutputStream extends FilterOutputStream {
        private ByteOrder X;
        final OutputStream s;

        public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.s = outputStream;
            this.X = byteOrder;
        }

        public void b(ByteOrder byteOrder) {
            this.X = byteOrder;
        }

        public void c(int i2) throws IOException {
            this.s.write(i2);
        }

        public void d(int i2) throws IOException {
            OutputStream outputStream;
            ByteOrder byteOrder = this.X;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.s.write(i2 & 255);
                this.s.write((i2 >>> 8) & 255);
                this.s.write((i2 >>> 16) & 255);
                outputStream = this.s;
                i2 >>>= 24;
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.s.write((i2 >>> 24) & 255);
                this.s.write((i2 >>> 16) & 255);
                this.s.write((i2 >>> 8) & 255);
                outputStream = this.s;
            } else {
                return;
            }
            outputStream.write(i2 & 255);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: short} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: short} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: short} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e(short r3) throws java.io.IOException {
            /*
                r2 = this;
                java.nio.ByteOrder r0 = r2.X
                java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN
                if (r0 != r1) goto L_0x0017
                java.io.OutputStream r0 = r2.s
                r1 = r3 & 255(0xff, float:3.57E-43)
                r0.write(r1)
                java.io.OutputStream r0 = r2.s
                int r3 = r3 >>> 8
            L_0x0011:
                r3 = r3 & 255(0xff, float:3.57E-43)
                r0.write(r3)
                goto L_0x0027
            L_0x0017:
                java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
                if (r0 != r1) goto L_0x0027
                java.io.OutputStream r0 = r2.s
                int r1 = r3 >>> 8
                r1 = r1 & 255(0xff, float:3.57E-43)
                r0.write(r1)
                java.io.OutputStream r0 = r2.s
                goto L_0x0011
            L_0x0027:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream.e(short):void");
        }

        public void f(long j2) throws IOException {
            d((int) j2);
        }

        public void h(int i2) throws IOException {
            e((short) i2);
        }

        public void write(byte[] bArr) throws IOException {
            this.s.write(bArr);
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            this.s.write(bArr, i2, i3);
        }
    }

    private static class ExifAttribute {

        /* renamed from: e  reason: collision with root package name */
        public static final long f7820e = -1;

        /* renamed from: a  reason: collision with root package name */
        public final int f7821a;

        /* renamed from: b  reason: collision with root package name */
        public final int f7822b;

        /* renamed from: c  reason: collision with root package name */
        public final long f7823c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f7824d;

        ExifAttribute(int i2, int i3, long j2, byte[] bArr) {
            this.f7821a = i2;
            this.f7822b = i3;
            this.f7823c = j2;
            this.f7824d = bArr;
        }

        public static ExifAttribute a(String str) {
            if (str.length() != 1 || str.charAt(0) < '0' || str.charAt(0) > '1') {
                byte[] bytes = str.getBytes(ExifInterface.j7);
                return new ExifAttribute(1, bytes.length, bytes);
            }
            return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }

        public static ExifAttribute b(double d2, ByteOrder byteOrder) {
            return c(new double[]{d2}, byteOrder);
        }

        public static ExifAttribute c(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.H6[12] * dArr.length)]);
            wrap.order(byteOrder);
            for (double putDouble : dArr) {
                wrap.putDouble(putDouble);
            }
            return new ExifAttribute(12, dArr.length, wrap.array());
        }

        public static ExifAttribute d(int i2, ByteOrder byteOrder) {
            return e(new int[]{i2}, byteOrder);
        }

        public static ExifAttribute e(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.H6[9] * iArr.length)]);
            wrap.order(byteOrder);
            for (int putInt : iArr) {
                wrap.putInt(putInt);
            }
            return new ExifAttribute(9, iArr.length, wrap.array());
        }

        public static ExifAttribute f(Rational rational, ByteOrder byteOrder) {
            return g(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute g(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.H6[10] * rationalArr.length)]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.f7829a);
                wrap.putInt((int) rational.f7830b);
            }
            return new ExifAttribute(10, rationalArr.length, wrap.array());
        }

        public static ExifAttribute h(String str) {
            byte[] bytes = (str + 0).getBytes(ExifInterface.j7);
            return new ExifAttribute(2, bytes.length, bytes);
        }

        public static ExifAttribute i(long j2, ByteOrder byteOrder) {
            return j(new long[]{j2}, byteOrder);
        }

        public static ExifAttribute j(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.H6[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j2 : jArr) {
                wrap.putInt((int) j2);
            }
            return new ExifAttribute(4, jArr.length, wrap.array());
        }

        public static ExifAttribute k(Rational rational, ByteOrder byteOrder) {
            return l(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute l(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.H6[5] * rationalArr.length)]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.f7829a);
                wrap.putInt((int) rational.f7830b);
            }
            return new ExifAttribute(5, rationalArr.length, wrap.array());
        }

        public static ExifAttribute m(int i2, ByteOrder byteOrder) {
            return n(new int[]{i2}, byteOrder);
        }

        public static ExifAttribute n(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.H6[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i2 : iArr) {
                wrap.putShort((short) i2);
            }
            return new ExifAttribute(3, iArr.length, wrap.array());
        }

        public double o(ByteOrder byteOrder) {
            Object r = r(byteOrder);
            if (r == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (r instanceof String) {
                return Double.parseDouble((String) r);
            } else {
                if (r instanceof long[]) {
                    long[] jArr = (long[]) r;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (r instanceof int[]) {
                    int[] iArr = (int[]) r;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (r instanceof double[]) {
                    double[] dArr = (double[]) r;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (r instanceof Rational[]) {
                    Rational[] rationalArr = (Rational[]) r;
                    if (rationalArr.length == 1) {
                        return rationalArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int p(ByteOrder byteOrder) {
            Object r = r(byteOrder);
            if (r == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (r instanceof String) {
                return Integer.parseInt((String) r);
            } else {
                if (r instanceof long[]) {
                    long[] jArr = (long[]) r;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (r instanceof int[]) {
                    int[] iArr = (int[]) r;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String q(ByteOrder byteOrder) {
            Object r = r(byteOrder);
            if (r == null) {
                return null;
            }
            if (r instanceof String) {
                return (String) r;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            if (r instanceof long[]) {
                long[] jArr = (long[]) r;
                while (i2 < jArr.length) {
                    sb.append(jArr[i2]);
                    i2++;
                    if (i2 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (r instanceof int[]) {
                int[] iArr = (int[]) r;
                while (i2 < iArr.length) {
                    sb.append(iArr[i2]);
                    i2++;
                    if (i2 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (r instanceof double[]) {
                double[] dArr = (double[]) r;
                while (i2 < dArr.length) {
                    sb.append(dArr[i2]);
                    i2++;
                    if (i2 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(r instanceof Rational[])) {
                return null;
            } else {
                Rational[] rationalArr = (Rational[]) r;
                while (i2 < rationalArr.length) {
                    sb.append(rationalArr[i2].f7829a);
                    sb.append('/');
                    sb.append(rationalArr[i2].f7830b);
                    i2++;
                    if (i2 != rationalArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:162:0x018f A[SYNTHETIC, Splitter:B:162:0x018f] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object r(java.nio.ByteOrder r12) {
            /*
                r11 = this;
                r0 = 0
                r1 = 1
                java.lang.String r2 = "IOException occurred while closing InputStream"
                java.lang.String r3 = "ExifInterface"
                r4 = 0
                androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r5 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ IOException -> 0x017b, all -> 0x0179 }
                byte[] r6 = r11.f7824d     // Catch:{ IOException -> 0x017b, all -> 0x0179 }
                r5.<init>((byte[]) r6)     // Catch:{ IOException -> 0x017b, all -> 0x0179 }
                r5.d(r12)     // Catch:{ IOException -> 0x0033 }
                int r12 = r11.f7821a     // Catch:{ IOException -> 0x0033 }
                switch(r12) {
                    case 1: goto L_0x0149;
                    case 2: goto L_0x0103;
                    case 3: goto L_0x00ea;
                    case 4: goto L_0x00d1;
                    case 5: goto L_0x00af;
                    case 6: goto L_0x0149;
                    case 7: goto L_0x0103;
                    case 8: goto L_0x0096;
                    case 9: goto L_0x007d;
                    case 10: goto L_0x0059;
                    case 11: goto L_0x003f;
                    case 12: goto L_0x001f;
                    default: goto L_0x0016;
                }
            L_0x0016:
                r5.close()     // Catch:{ IOException -> 0x001a }
                goto L_0x001e
            L_0x001a:
                r12 = move-exception
                android.util.Log.e(r3, r2, r12)
            L_0x001e:
                return r4
            L_0x001f:
                int r12 = r11.f7822b     // Catch:{ IOException -> 0x0033 }
                double[] r12 = new double[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x0023:
                int r6 = r11.f7822b     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x0036
                double r6 = r5.readDouble()     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x0023
            L_0x002f:
                r12 = move-exception
                r4 = r5
                goto L_0x018d
            L_0x0033:
                r12 = move-exception
                goto L_0x017d
            L_0x0036:
                r5.close()     // Catch:{ IOException -> 0x003a }
                goto L_0x003e
            L_0x003a:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x003e:
                return r12
            L_0x003f:
                int r12 = r11.f7822b     // Catch:{ IOException -> 0x0033 }
                double[] r12 = new double[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x0043:
                int r6 = r11.f7822b     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x0050
                float r6 = r5.readFloat()     // Catch:{ IOException -> 0x0033 }
                double r6 = (double) r6     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x0043
            L_0x0050:
                r5.close()     // Catch:{ IOException -> 0x0054 }
                goto L_0x0058
            L_0x0054:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x0058:
                return r12
            L_0x0059:
                int r12 = r11.f7822b     // Catch:{ IOException -> 0x0033 }
                androidx.exifinterface.media.ExifInterface$Rational[] r12 = new androidx.exifinterface.media.ExifInterface.Rational[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x005d:
                int r6 = r11.f7822b     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x0074
                int r6 = r5.readInt()     // Catch:{ IOException -> 0x0033 }
                long r6 = (long) r6     // Catch:{ IOException -> 0x0033 }
                int r8 = r5.readInt()     // Catch:{ IOException -> 0x0033 }
                long r8 = (long) r8     // Catch:{ IOException -> 0x0033 }
                androidx.exifinterface.media.ExifInterface$Rational r10 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ IOException -> 0x0033 }
                r10.<init>(r6, r8)     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r10     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x005d
            L_0x0074:
                r5.close()     // Catch:{ IOException -> 0x0078 }
                goto L_0x007c
            L_0x0078:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x007c:
                return r12
            L_0x007d:
                int r12 = r11.f7822b     // Catch:{ IOException -> 0x0033 }
                int[] r12 = new int[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x0081:
                int r6 = r11.f7822b     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x008d
                int r6 = r5.readInt()     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x0081
            L_0x008d:
                r5.close()     // Catch:{ IOException -> 0x0091 }
                goto L_0x0095
            L_0x0091:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x0095:
                return r12
            L_0x0096:
                int r12 = r11.f7822b     // Catch:{ IOException -> 0x0033 }
                int[] r12 = new int[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x009a:
                int r6 = r11.f7822b     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x00a6
                short r6 = r5.readShort()     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x009a
            L_0x00a6:
                r5.close()     // Catch:{ IOException -> 0x00aa }
                goto L_0x00ae
            L_0x00aa:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x00ae:
                return r12
            L_0x00af:
                int r12 = r11.f7822b     // Catch:{ IOException -> 0x0033 }
                androidx.exifinterface.media.ExifInterface$Rational[] r12 = new androidx.exifinterface.media.ExifInterface.Rational[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x00b3:
                int r6 = r11.f7822b     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x00c8
                long r6 = r5.c()     // Catch:{ IOException -> 0x0033 }
                long r8 = r5.c()     // Catch:{ IOException -> 0x0033 }
                androidx.exifinterface.media.ExifInterface$Rational r10 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ IOException -> 0x0033 }
                r10.<init>(r6, r8)     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r10     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x00b3
            L_0x00c8:
                r5.close()     // Catch:{ IOException -> 0x00cc }
                goto L_0x00d0
            L_0x00cc:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x00d0:
                return r12
            L_0x00d1:
                int r12 = r11.f7822b     // Catch:{ IOException -> 0x0033 }
                long[] r12 = new long[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x00d5:
                int r6 = r11.f7822b     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x00e1
                long r6 = r5.c()     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x00d5
            L_0x00e1:
                r5.close()     // Catch:{ IOException -> 0x00e5 }
                goto L_0x00e9
            L_0x00e5:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x00e9:
                return r12
            L_0x00ea:
                int r12 = r11.f7822b     // Catch:{ IOException -> 0x0033 }
                int[] r12 = new int[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x00ee:
                int r6 = r11.f7822b     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x00fa
                int r6 = r5.readUnsignedShort()     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x00ee
            L_0x00fa:
                r5.close()     // Catch:{ IOException -> 0x00fe }
                goto L_0x0102
            L_0x00fe:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x0102:
                return r12
            L_0x0103:
                int r12 = r11.f7822b     // Catch:{ IOException -> 0x0033 }
                byte[] r6 = androidx.exifinterface.media.ExifInterface.I6     // Catch:{ IOException -> 0x0033 }
                int r6 = r6.length     // Catch:{ IOException -> 0x0033 }
                if (r12 < r6) goto L_0x011c
                r12 = 0
            L_0x010b:
                byte[] r6 = androidx.exifinterface.media.ExifInterface.I6     // Catch:{ IOException -> 0x0033 }
                int r7 = r6.length     // Catch:{ IOException -> 0x0033 }
                if (r12 >= r7) goto L_0x011b
                byte[] r7 = r11.f7824d     // Catch:{ IOException -> 0x0033 }
                byte r7 = r7[r12]     // Catch:{ IOException -> 0x0033 }
                byte r6 = r6[r12]     // Catch:{ IOException -> 0x0033 }
                if (r7 == r6) goto L_0x0119
                goto L_0x011c
            L_0x0119:
                int r12 = r12 + r1
                goto L_0x010b
            L_0x011b:
                int r0 = r6.length     // Catch:{ IOException -> 0x0033 }
            L_0x011c:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0033 }
                r12.<init>()     // Catch:{ IOException -> 0x0033 }
            L_0x0121:
                int r6 = r11.f7822b     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x013c
                byte[] r6 = r11.f7824d     // Catch:{ IOException -> 0x0033 }
                byte r6 = r6[r0]     // Catch:{ IOException -> 0x0033 }
                if (r6 != 0) goto L_0x012c
                goto L_0x013c
            L_0x012c:
                r7 = 32
                if (r6 < r7) goto L_0x0135
                char r6 = (char) r6     // Catch:{ IOException -> 0x0033 }
                r12.append(r6)     // Catch:{ IOException -> 0x0033 }
                goto L_0x013a
            L_0x0135:
                r6 = 63
                r12.append(r6)     // Catch:{ IOException -> 0x0033 }
            L_0x013a:
                int r0 = r0 + r1
                goto L_0x0121
            L_0x013c:
                java.lang.String r12 = r12.toString()     // Catch:{ IOException -> 0x0033 }
                r5.close()     // Catch:{ IOException -> 0x0144 }
                goto L_0x0148
            L_0x0144:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x0148:
                return r12
            L_0x0149:
                byte[] r12 = r11.f7824d     // Catch:{ IOException -> 0x0033 }
                int r6 = r12.length     // Catch:{ IOException -> 0x0033 }
                if (r6 != r1) goto L_0x0169
                byte r6 = r12[r0]     // Catch:{ IOException -> 0x0033 }
                if (r6 < 0) goto L_0x0169
                if (r6 > r1) goto L_0x0169
                java.lang.String r12 = new java.lang.String     // Catch:{ IOException -> 0x0033 }
                int r6 = r6 + 48
                char r6 = (char) r6     // Catch:{ IOException -> 0x0033 }
                char[] r1 = new char[r1]     // Catch:{ IOException -> 0x0033 }
                r1[r0] = r6     // Catch:{ IOException -> 0x0033 }
                r12.<init>(r1)     // Catch:{ IOException -> 0x0033 }
                r5.close()     // Catch:{ IOException -> 0x0164 }
                goto L_0x0168
            L_0x0164:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x0168:
                return r12
            L_0x0169:
                java.lang.String r0 = new java.lang.String     // Catch:{ IOException -> 0x0033 }
                java.nio.charset.Charset r1 = androidx.exifinterface.media.ExifInterface.j7     // Catch:{ IOException -> 0x0033 }
                r0.<init>(r12, r1)     // Catch:{ IOException -> 0x0033 }
                r5.close()     // Catch:{ IOException -> 0x0174 }
                goto L_0x0178
            L_0x0174:
                r12 = move-exception
                android.util.Log.e(r3, r2, r12)
            L_0x0178:
                return r0
            L_0x0179:
                r12 = move-exception
                goto L_0x018d
            L_0x017b:
                r12 = move-exception
                r5 = r4
            L_0x017d:
                java.lang.String r0 = "IOException occurred during reading a value"
                android.util.Log.w(r3, r0, r12)     // Catch:{ all -> 0x002f }
                if (r5 == 0) goto L_0x018c
                r5.close()     // Catch:{ IOException -> 0x0188 }
                goto L_0x018c
            L_0x0188:
                r12 = move-exception
                android.util.Log.e(r3, r2, r12)
            L_0x018c:
                return r4
            L_0x018d:
                if (r4 == 0) goto L_0x0197
                r4.close()     // Catch:{ IOException -> 0x0193 }
                goto L_0x0197
            L_0x0193:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x0197:
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.ExifAttribute.r(java.nio.ByteOrder):java.lang.Object");
        }

        public int s() {
            return ExifInterface.H6[this.f7821a] * this.f7822b;
        }

        public String toString() {
            return "(" + ExifInterface.G6[this.f7821a] + ", data length:" + this.f7824d.length + ")";
        }

        ExifAttribute(int i2, int i3, byte[] bArr) {
            this(i2, i3, -1, bArr);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExifStreamType {
    }

    static class ExifTag {

        /* renamed from: a  reason: collision with root package name */
        public final int f7825a;

        /* renamed from: b  reason: collision with root package name */
        public final String f7826b;

        /* renamed from: c  reason: collision with root package name */
        public final int f7827c;

        /* renamed from: d  reason: collision with root package name */
        public final int f7828d;

        ExifTag(String str, int i2, int i3) {
            this.f7826b = str;
            this.f7825a = i2;
            this.f7827c = i3;
            this.f7828d = -1;
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i2) {
            int i3;
            int i4 = this.f7827c;
            if (i4 == 7 || i2 == 7 || i4 == i2 || (i3 = this.f7828d) == i2) {
                return true;
            }
            if ((i4 == 4 || i3 == 4) && i2 == 3) {
                return true;
            }
            if ((i4 == 9 || i3 == 9) && i2 == 8) {
                return true;
            }
            return (i4 == 12 || i3 == 12) && i2 == 11;
        }

        ExifTag(String str, int i2, int i3, int i4) {
            this.f7826b = str;
            this.f7825a = i2;
            this.f7827c = i3;
            this.f7828d = i4;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IfdType {
    }

    private static class Rational {

        /* renamed from: a  reason: collision with root package name */
        public final long f7829a;

        /* renamed from: b  reason: collision with root package name */
        public final long f7830b;

        Rational(double d2) {
            this((long) (d2 * 10000.0d), 10000);
        }

        public double a() {
            return ((double) this.f7829a) / ((double) this.f7830b);
        }

        public String toString() {
            return this.f7829a + "/" + this.f7830b;
        }

        Rational(long j2, long j3) {
            if (j3 == 0) {
                this.f7829a = 0;
                this.f7830b = 1;
                return;
            }
            this.f7829a = j2;
            this.f7830b = j3;
        }
    }

    private static class SeekableByteOrderedDataInputStream extends ByteOrderedDataInputStream {
        SeekableByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.s.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }

        public void f(long j2) throws IOException {
            int i2 = this.Y;
            if (((long) i2) > j2) {
                this.Y = 0;
                this.s.reset();
            } else {
                j2 -= (long) i2;
            }
            e((int) j2);
        }

        SeekableByteOrderedDataInputStream(byte[] bArr) throws IOException {
            super(bArr);
            this.s.mark(Integer.MAX_VALUE);
        }
    }

    static {
        ExifTag exifTag = new ExifTag(u2, TIFFConstants.f26648a, 4);
        ExifTag exifTag2 = new ExifTag(v2, 255, 4);
        ExifTag exifTag3 = new ExifTag(x, 256, 3, 4);
        ExifTag exifTag4 = new ExifTag(y, 257, 3, 4);
        ExifTag exifTag5 = new ExifTag(z, 258, 3);
        ExifTag exifTag6 = new ExifTag(A, 259, 3);
        ExifTag exifTag7 = new ExifTag(B, 262, 3);
        ExifTag exifTag8 = new ExifTag(V, TIFFConstants.e0, 2);
        ExifTag exifTag9 = new ExifTag(W, TIFFConstants.f0, 2);
        ExifTag exifTag10 = new ExifTag(X, TIFFConstants.g0, 2);
        ExifTag exifTag11 = new ExifTag(K, TIFFConstants.h0, 3, 4);
        ExifTag exifTag12 = new ExifTag(C, TIFFConstants.i0, 3);
        String str = K;
        ExifTag exifTag13 = new ExifTag(D, TIFFConstants.r0, 3);
        ExifTag exifTag14 = exifTag12;
        ExifTag exifTag15 = new ExifTag(L, TIFFConstants.s0, 3, 4);
        ExifTag exifTag16 = new ExifTag(M, TIFFConstants.t0, 3, 4);
        ExifTag exifTag17 = new ExifTag(H, TIFFConstants.w0, 5);
        ExifTag exifTag18 = new ExifTag(I, TIFFConstants.x0, 5);
        ExifTag exifTag19 = new ExifTag(E, TIFFConstants.y0, 3);
        ExifTag exifTag20 = new ExifTag(J, TIFFConstants.T0, 3);
        ExifTag exifTag21 = new ExifTag(P, 301, 3);
        ExifTag exifTag22 = new ExifTag(Y, 305, 2);
        ExifTag exifTag23 = new ExifTag(U, 306, 2);
        ExifTag exifTag24 = new ExifTag(Z, 315, 2);
        ExifTag exifTag25 = new ExifTag(Q, 318, 5);
        ExifTag exifTag26 = new ExifTag(R, TIFFConstants.n1, 5);
        ExifTag exifTag27 = new ExifTag(z2, TIFFConstants.A1, 4);
        String str2 = z2;
        ExifTag exifTag28 = exifTag27;
        ExifTag exifTag29 = new ExifTag(N, 513, 4);
        ExifTag exifTag30 = new ExifTag(O, TIFFConstants.Z1, 4);
        ExifTag exifTag31 = new ExifTag(S, 529, 5);
        ExifTag exifTag32 = new ExifTag(F, TIFFConstants.h2, 3);
        ExifTag exifTag33 = new ExifTag(G, 531, 3);
        ExifTag exifTag34 = new ExifTag(T, 532, 5);
        ExifTag exifTag35 = new ExifTag(a0, TIFFConstants.C2, 2);
        ExifTag exifTag36 = new ExifTag(w2, 34665, 4);
        String str3 = w2;
        ExifTag[] exifTagArr = {exifTag, exifTag2, exifTag3, exifTag4, exifTag5, exifTag6, exifTag7, exifTag8, exifTag9, exifTag10, exifTag11, exifTag14, exifTag13, exifTag15, exifTag16, exifTag17, exifTag18, exifTag19, exifTag20, exifTag21, exifTag22, exifTag23, exifTag24, exifTag25, exifTag26, exifTag28, exifTag29, exifTag30, exifTag31, exifTag32, exifTag33, exifTag34, exifTag35, exifTag36, new ExifTag(x2, 34853, 4), new ExifTag(q2, 4, 4), new ExifTag(o2, 5, 4), new ExifTag(n2, 6, 4), new ExifTag(p2, 7, 4), new ExifTag(r2, 23, 3), new ExifTag(s2, 46, 7), new ExifTag(t2, TypedValues.TransitionType.f4033j, 1)};
        J6 = exifTagArr;
        ExifTag[] exifTagArr2 = exifTagArr;
        ExifTag[] exifTagArr3 = {new ExifTag(u0, 33434, 5), new ExifTag(v0, 33437, 5), new ExifTag(w0, 34850, 3), new ExifTag(x0, 34852, 2), new ExifTag(z0, 34855, 3), new ExifTag(A0, 34856, 7), new ExifTag(B0, 34864, 3), new ExifTag(C0, 34865, 4), new ExifTag(D0, 34866, 4), new ExifTag(E0, 34867, 4), new ExifTag(F0, 34868, 4), new ExifTag(G0, 34869, 4), new ExifTag(b0, 36864, 2), new ExifTag(m0, 36867, 2), new ExifTag(n0, 36868, 2), new ExifTag(o0, 36880, 2), new ExifTag(p0, 36881, 2), new ExifTag(q0, 36882, 2), new ExifTag(h0, 37121, 7), new ExifTag(i0, 37122, 5), new ExifTag(H0, 37377, 10), new ExifTag(I0, 37378, 5), new ExifTag(J0, 37379, 10), new ExifTag(K0, 37380, 10), new ExifTag(L0, 37381, 5), new ExifTag(M0, 37382, 5), new ExifTag(N0, 37383, 3), new ExifTag(O0, 37384, 3), new ExifTag(P0, 37385, 3), new ExifTag(R0, 37386, 5), new ExifTag(Q0, 37396, 3), new ExifTag(j0, 37500, 7), new ExifTag(k0, 37510, 7), new ExifTag(r0, 37520, 2), new ExifTag(s0, 37521, 2), new ExifTag(t0, 37522, 2), new ExifTag(c0, 40960, 7), new ExifTag(d0, 40961, 3), new ExifTag(f0, 40962, 3, 4), new ExifTag(g0, 40963, 3, 4), new ExifTag(l0, 40964, 2), new ExifTag(y2, 40965, 4), new ExifTag(S0, 41483, 5), new ExifTag(T0, 41484, 7), new ExifTag(U0, 41486, 5), new ExifTag(V0, 41487, 5), new ExifTag(W0, 41488, 3), new ExifTag(X0, 41492, 3), new ExifTag(Y0, 41493, 5), new ExifTag(Z0, 41495, 3), new ExifTag(a1, 41728, 7), new ExifTag(b1, 41729, 7), new ExifTag(c1, 41730, 7), new ExifTag(d1, 41985, 3), new ExifTag(e1, 41986, 3), new ExifTag(f1, 41987, 3), new ExifTag(g1, 41988, 5), new ExifTag(h1, 41989, 3), new ExifTag(i1, 41990, 3), new ExifTag(j1, 41991, 3), new ExifTag(k1, 41992, 3), new ExifTag(l1, 41993, 3), new ExifTag(m1, 41994, 3), new ExifTag(n1, 41995, 7), new ExifTag(o1, 41996, 3), new ExifTag(p1, 42016, 2), new ExifTag("CameraOwnerName", 42032, 2), new ExifTag(s1, 42033, 2), new ExifTag(t1, 42034, 5), new ExifTag(u1, 42035, 2), new ExifTag(v1, 42036, 2), new ExifTag(e0, 42240, 5), new ExifTag(h2, 50706, 1), new ExifTag(i2, 50720, 3, 4)};
        K6 = exifTagArr3;
        ExifTag[] exifTagArr4 = exifTagArr3;
        ExifTag[] exifTagArr5 = {new ExifTag(x1, 0, 1), new ExifTag(y1, 1, 2), new ExifTag(z1, 2, 5, 10), new ExifTag(A1, 3, 2), new ExifTag(B1, 4, 5, 10), new ExifTag(C1, 5, 1), new ExifTag(D1, 6, 5), new ExifTag(E1, 7, 5), new ExifTag(F1, 8, 2), new ExifTag(G1, 9, 2), new ExifTag(H1, 10, 2), new ExifTag(I1, 11, 5), new ExifTag(J1, 12, 2), new ExifTag(K1, 13, 5), new ExifTag(L1, 14, 2), new ExifTag(M1, 15, 5), new ExifTag(N1, 16, 2), new ExifTag(O1, 17, 5), new ExifTag(P1, 18, 2), new ExifTag(Q1, 19, 2), new ExifTag(R1, 20, 5), new ExifTag(S1, 21, 2), new ExifTag(T1, 22, 5), new ExifTag(U1, 23, 2), new ExifTag(V1, 24, 5), new ExifTag(W1, 25, 2), new ExifTag(X1, 26, 5), new ExifTag(Y1, 27, 7), new ExifTag(Z1, 28, 7), new ExifTag(a2, 29, 2), new ExifTag(b2, 30, 3), new ExifTag(c2, 31, 5)};
        L6 = exifTagArr5;
        ExifTag[] exifTagArr6 = {new ExifTag(d2, 1, 2)};
        M6 = exifTagArr6;
        String str4 = str;
        ExifTag[] exifTagArr7 = exifTagArr6;
        String str5 = str4;
        String str6 = str2;
        String str7 = str3;
        ExifTag[] exifTagArr8 = {new ExifTag(u2, TIFFConstants.f26648a, 4), new ExifTag(v2, 255, 4), new ExifTag(f2, 256, 3, 4), new ExifTag(e2, 257, 3, 4), new ExifTag(z, 258, 3), new ExifTag(A, 259, 3), new ExifTag(B, 262, 3), new ExifTag(V, TIFFConstants.e0, 2), new ExifTag(W, TIFFConstants.f0, 2), new ExifTag(X, TIFFConstants.g0, 2), new ExifTag(str4, TIFFConstants.h0, 3, 4), new ExifTag(g2, TIFFConstants.i0, 3), new ExifTag(D, TIFFConstants.r0, 3), new ExifTag(L, TIFFConstants.s0, 3, 4), new ExifTag(M, TIFFConstants.t0, 3, 4), new ExifTag(H, TIFFConstants.w0, 5), new ExifTag(I, TIFFConstants.x0, 5), new ExifTag(E, TIFFConstants.y0, 3), new ExifTag(J, TIFFConstants.T0, 3), new ExifTag(P, 301, 3), new ExifTag(Y, 305, 2), new ExifTag(U, 306, 2), new ExifTag(Z, 315, 2), new ExifTag(Q, 318, 5), new ExifTag(R, TIFFConstants.n1, 5), new ExifTag(str6, TIFFConstants.A1, 4), new ExifTag(N, 513, 4), new ExifTag(O, TIFFConstants.Z1, 4), new ExifTag(S, 529, 5), new ExifTag(F, TIFFConstants.h2, 3), new ExifTag(G, 531, 3), new ExifTag(T, 532, 5), new ExifTag(a0, TIFFConstants.C2, 2), new ExifTag(str7, 34665, 4), new ExifTag(x2, 34853, 4), new ExifTag(h2, 50706, 1), new ExifTag(i2, 50720, 3, 4)};
        N6 = exifTagArr8;
        O6 = new ExifTag(str5, TIFFConstants.h0, 3);
        ExifTag[] exifTagArr9 = {new ExifTag(j2, 256, 7), new ExifTag(A2, 8224, 4), new ExifTag(B2, 8256, 4)};
        P6 = exifTagArr9;
        ExifTag[] exifTagArr10 = {new ExifTag(k2, 257, 4), new ExifTag(l2, 258, 4)};
        Q6 = exifTagArr10;
        ExifTag[] exifTagArr11 = {new ExifTag(m2, 4371, 3)};
        R6 = exifTagArr11;
        ExifTag[] exifTagArr12 = {new ExifTag(d0, 55, 3)};
        S6 = exifTagArr12;
        ExifTag[][] exifTagArr13 = {exifTagArr2, exifTagArr4, exifTagArr5, exifTagArr7, exifTagArr8, exifTagArr2, exifTagArr9, exifTagArr10, exifTagArr11, exifTagArr12};
        d7 = exifTagArr13;
        e7 = new ExifTag[]{new ExifTag(str6, TIFFConstants.A1, 4), new ExifTag(str7, 34665, 4), new ExifTag(x2, 34853, 4), new ExifTag(y2, 40965, 4), new ExifTag(A2, 8224, 1), new ExifTag(B2, 8256, 1)};
        f7 = new HashMap[exifTagArr13.length];
        g7 = new HashMap[exifTagArr13.length];
        Charset forName = Charset.forName("US-ASCII");
        j7 = forName;
        k7 = "Exif\u0000\u0000".getBytes(forName);
        l7 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        m6 = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        n6 = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i8 = 0;
        while (true) {
            ExifTag[][] exifTagArr14 = d7;
            if (i8 < exifTagArr14.length) {
                f7[i8] = new HashMap<>();
                g7[i8] = new HashMap<>();
                for (ExifTag exifTag37 : exifTagArr14[i8]) {
                    f7[i8].put(Integer.valueOf(exifTag37.f7825a), exifTag37);
                    g7[i8].put(exifTag37.f7826b, exifTag37);
                }
                i8++;
            } else {
                HashMap<Integer, Integer> hashMap = i7;
                ExifTag[] exifTagArr15 = e7;
                hashMap.put(Integer.valueOf(exifTagArr15[0].f7825a), 5);
                hashMap.put(Integer.valueOf(exifTagArr15[1].f7825a), 1);
                hashMap.put(Integer.valueOf(exifTagArr15[2].f7825a), 2);
                hashMap.put(Integer.valueOf(exifTagArr15[3].f7825a), 3);
                hashMap.put(Integer.valueOf(exifTagArr15[4].f7825a), 7);
                hashMap.put(Integer.valueOf(exifTagArr15[5].f7825a), 8);
                return;
            }
        }
    }

    public ExifInterface(@NonNull File file) throws IOException {
        ExifTag[][] exifTagArr = d7;
        this.f7811f = new HashMap[exifTagArr.length];
        this.f7812g = new HashSet(exifTagArr.length);
        this.f7813h = ByteOrder.BIG_ENDIAN;
        if (file != null) {
            O(file.getAbsolutePath());
            return;
        }
        throw new NullPointerException("file cannot be null");
    }

    private void A(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        ExifAttribute exifAttribute;
        g0(seekableByteOrderedDataInputStream);
        k0(seekableByteOrderedDataInputStream, 0);
        C0(seekableByteOrderedDataInputStream, 0);
        C0(seekableByteOrderedDataInputStream, 5);
        C0(seekableByteOrderedDataInputStream, 4);
        D0();
        if (this.f7809d == 8 && (exifAttribute = this.f7811f[1].get(j0)) != null) {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.f7824d);
            seekableByteOrderedDataInputStream2.d(this.f7813h);
            seekableByteOrderedDataInputStream2.e(6);
            k0(seekableByteOrderedDataInputStream2, 9);
            ExifAttribute exifAttribute2 = this.f7811f[9].get(d0);
            if (exifAttribute2 != null) {
                this.f7811f[1].put(d0, exifAttribute2);
            }
        }
    }

    private static boolean A0(int i8) {
        return (i8 == 4 || i8 == 9 || i8 == 13 || i8 == 14) ? false : true;
    }

    private void B0(int i8, int i9) throws IOException {
        String str;
        if (!this.f7811f[i8].isEmpty() && !this.f7811f[i9].isEmpty()) {
            ExifAttribute exifAttribute = this.f7811f[i8].get(y);
            ExifAttribute exifAttribute2 = this.f7811f[i8].get(x);
            ExifAttribute exifAttribute3 = this.f7811f[i9].get(y);
            ExifAttribute exifAttribute4 = this.f7811f[i9].get(x);
            if (exifAttribute == null || exifAttribute2 == null) {
                if (w) {
                    str = "First image does not contain valid size information";
                } else {
                    return;
                }
            } else if (exifAttribute3 != null && exifAttribute4 != null) {
                int p8 = exifAttribute.p(this.f7813h);
                int p9 = exifAttribute2.p(this.f7813h);
                int p10 = exifAttribute3.p(this.f7813h);
                int p11 = exifAttribute4.p(this.f7813h);
                if (p8 < p10 && p9 < p11) {
                    HashMap<String, ExifAttribute>[] hashMapArr = this.f7811f;
                    HashMap<String, ExifAttribute> hashMap = hashMapArr[i8];
                    hashMapArr[i8] = hashMapArr[i9];
                    hashMapArr[i9] = hashMap;
                    return;
                }
                return;
            } else if (w) {
                str = "Second image does not contain valid size information";
            } else {
                return;
            }
            Log.d(v, str);
        } else if (w) {
            Log.d(v, "Cannot perform swap since only one image data exists");
        }
    }

    private void C(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        if (w) {
            Log.d(v, "getRw2Attributes starting with: " + seekableByteOrderedDataInputStream);
        }
        A(seekableByteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.f7811f[0].get(s2);
        if (exifAttribute != null) {
            t(new ByteOrderedDataInputStream(exifAttribute.f7824d), (int) exifAttribute.f7823c, 5);
        }
        ExifAttribute exifAttribute2 = this.f7811f[0].get(r2);
        ExifAttribute exifAttribute3 = this.f7811f[1].get(z0);
        if (exifAttribute2 != null && exifAttribute3 == null) {
            this.f7811f[1].put(z0, exifAttribute2);
        }
    }

    private void C0(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i8) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2;
        StringBuilder sb;
        String arrays;
        ExifAttribute exifAttribute3 = this.f7811f[i8].get(i2);
        ExifAttribute exifAttribute4 = this.f7811f[i8].get(q2);
        ExifAttribute exifAttribute5 = this.f7811f[i8].get(o2);
        ExifAttribute exifAttribute6 = this.f7811f[i8].get(n2);
        ExifAttribute exifAttribute7 = this.f7811f[i8].get(p2);
        if (exifAttribute3 != null) {
            if (exifAttribute3.f7821a == 5) {
                Rational[] rationalArr = (Rational[]) exifAttribute3.r(this.f7813h);
                if (rationalArr == null || rationalArr.length != 2) {
                    sb = new StringBuilder();
                    sb.append("Invalid crop size values. cropSize=");
                    arrays = Arrays.toString(rationalArr);
                } else {
                    exifAttribute2 = ExifAttribute.k(rationalArr[0], this.f7813h);
                    exifAttribute = ExifAttribute.k(rationalArr[1], this.f7813h);
                    this.f7811f[i8].put(x, exifAttribute2);
                    this.f7811f[i8].put(y, exifAttribute);
                    return;
                }
            } else {
                int[] iArr = (int[]) exifAttribute3.r(this.f7813h);
                if (iArr == null || iArr.length != 2) {
                    sb = new StringBuilder();
                    sb.append("Invalid crop size values. cropSize=");
                    arrays = Arrays.toString(iArr);
                } else {
                    exifAttribute2 = ExifAttribute.m(iArr[0], this.f7813h);
                    exifAttribute = ExifAttribute.m(iArr[1], this.f7813h);
                    this.f7811f[i8].put(x, exifAttribute2);
                    this.f7811f[i8].put(y, exifAttribute);
                    return;
                }
            }
            sb.append(arrays);
            Log.w(v, sb.toString());
        } else if (exifAttribute4 == null || exifAttribute5 == null || exifAttribute6 == null || exifAttribute7 == null) {
            o0(seekableByteOrderedDataInputStream, i8);
        } else {
            int p8 = exifAttribute4.p(this.f7813h);
            int p9 = exifAttribute6.p(this.f7813h);
            int p10 = exifAttribute7.p(this.f7813h);
            int p11 = exifAttribute5.p(this.f7813h);
            if (p9 > p8 && p10 > p11) {
                ExifAttribute m8 = ExifAttribute.m(p9 - p8, this.f7813h);
                ExifAttribute m9 = ExifAttribute.m(p10 - p11, this.f7813h);
                this.f7811f[i8].put(y, m8);
                this.f7811f[i8].put(x, m9);
            }
        }
    }

    private void D(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        byte[] bArr = k7;
        seekableByteOrderedDataInputStream.e(bArr.length);
        byte[] bArr2 = new byte[seekableByteOrderedDataInputStream.available()];
        seekableByteOrderedDataInputStream.readFully(bArr2);
        this.p = bArr.length;
        j0(bArr2, 0);
    }

    private void D0() throws IOException {
        B0(0, 5);
        B0(0, 4);
        B0(5, 4);
        ExifAttribute exifAttribute = this.f7811f[1].get(f0);
        ExifAttribute exifAttribute2 = this.f7811f[1].get(g0);
        if (!(exifAttribute == null || exifAttribute2 == null)) {
            this.f7811f[0].put(x, exifAttribute);
            this.f7811f[0].put(y, exifAttribute2);
        }
        if (this.f7811f[4].isEmpty() && b0(this.f7811f[5])) {
            HashMap<String, ExifAttribute>[] hashMapArr = this.f7811f;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!b0(this.f7811f[4])) {
            Log.d(v, "No image meets the size requirements of a thumbnail image.");
        }
        m0(0, g2, C);
        m0(0, e2, y);
        m0(0, f2, x);
        m0(5, g2, C);
        m0(5, e2, y);
        m0(5, f2, x);
        m0(4, C, g2);
        m0(4, y, e2);
        m0(4, x, f2);
    }

    private int E0(ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws IOException {
        ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = byteOrderedDataOutputStream;
        ExifTag[][] exifTagArr = d7;
        int[] iArr = new int[exifTagArr.length];
        int[] iArr2 = new int[exifTagArr.length];
        for (ExifTag exifTag : e7) {
            l0(exifTag.f7826b);
        }
        if (this.f7814i) {
            if (this.f7815j) {
                l0(K);
                l0(M);
            } else {
                l0(N);
                l0(O);
            }
        }
        for (int i8 = 0; i8 < d7.length; i8++) {
            for (Object obj : this.f7811f[i8].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.f7811f[i8].remove(entry.getKey());
                }
            }
        }
        if (!this.f7811f[1].isEmpty()) {
            this.f7811f[0].put(e7[1].f7826b, ExifAttribute.i(0, this.f7813h));
        }
        if (!this.f7811f[2].isEmpty()) {
            this.f7811f[0].put(e7[2].f7826b, ExifAttribute.i(0, this.f7813h));
        }
        if (!this.f7811f[3].isEmpty()) {
            this.f7811f[1].put(e7[3].f7826b, ExifAttribute.i(0, this.f7813h));
        }
        if (this.f7814i) {
            if (this.f7815j) {
                this.f7811f[4].put(K, ExifAttribute.m(0, this.f7813h));
                this.f7811f[4].put(M, ExifAttribute.m(this.f7818m, this.f7813h));
            } else {
                this.f7811f[4].put(N, ExifAttribute.i(0, this.f7813h));
                this.f7811f[4].put(O, ExifAttribute.i((long) this.f7818m, this.f7813h));
            }
        }
        for (int i9 = 0; i9 < d7.length; i9++) {
            int i10 = 0;
            for (Map.Entry<String, ExifAttribute> value : this.f7811f[i9].entrySet()) {
                int s8 = ((ExifAttribute) value.getValue()).s();
                if (s8 > 4) {
                    i10 += s8;
                }
            }
            iArr2[i9] = iArr2[i9] + i10;
        }
        int i11 = 8;
        for (int i12 = 0; i12 < d7.length; i12++) {
            if (!this.f7811f[i12].isEmpty()) {
                iArr[i12] = i11;
                i11 += (this.f7811f[i12].size() * 12) + 6 + iArr2[i12];
            }
        }
        if (this.f7814i) {
            if (this.f7815j) {
                this.f7811f[4].put(K, ExifAttribute.m(i11, this.f7813h));
            } else {
                this.f7811f[4].put(N, ExifAttribute.i((long) i11, this.f7813h));
            }
            this.f7817l = i11;
            i11 += this.f7818m;
        }
        if (this.f7809d == 4) {
            i11 += 8;
        }
        if (w) {
            for (int i13 = 0; i13 < d7.length; i13++) {
                Log.d(v, String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", new Object[]{Integer.valueOf(i13), Integer.valueOf(iArr[i13]), Integer.valueOf(this.f7811f[i13].size()), Integer.valueOf(iArr2[i13]), Integer.valueOf(i11)}));
            }
        }
        if (!this.f7811f[1].isEmpty()) {
            this.f7811f[0].put(e7[1].f7826b, ExifAttribute.i((long) iArr[1], this.f7813h));
        }
        if (!this.f7811f[2].isEmpty()) {
            this.f7811f[0].put(e7[2].f7826b, ExifAttribute.i((long) iArr[2], this.f7813h));
        }
        if (!this.f7811f[3].isEmpty()) {
            this.f7811f[1].put(e7[3].f7826b, ExifAttribute.i((long) iArr[3], this.f7813h));
        }
        int i14 = this.f7809d;
        if (i14 == 4) {
            byteOrderedDataOutputStream2.h(i11);
            byteOrderedDataOutputStream2.write(k7);
        } else if (i14 == 13) {
            byteOrderedDataOutputStream2.d(i11);
            byteOrderedDataOutputStream2.write(T5);
        } else if (i14 == 14) {
            byteOrderedDataOutputStream2.write(b6);
            byteOrderedDataOutputStream2.d(i11);
        }
        byteOrderedDataOutputStream2.e(this.f7813h == ByteOrder.BIG_ENDIAN ? p6 : o6);
        byteOrderedDataOutputStream2.b(this.f7813h);
        byteOrderedDataOutputStream2.h(42);
        byteOrderedDataOutputStream2.f(8);
        for (int i15 = 0; i15 < d7.length; i15++) {
            if (!this.f7811f[i15].isEmpty()) {
                byteOrderedDataOutputStream2.h(this.f7811f[i15].size());
                int size = iArr[i15] + 2 + (this.f7811f[i15].size() * 12) + 4;
                for (Map.Entry next : this.f7811f[i15].entrySet()) {
                    int i16 = g7[i15].get(next.getKey()).f7825a;
                    ExifAttribute exifAttribute = (ExifAttribute) next.getValue();
                    int s9 = exifAttribute.s();
                    byteOrderedDataOutputStream2.h(i16);
                    byteOrderedDataOutputStream2.h(exifAttribute.f7821a);
                    byteOrderedDataOutputStream2.d(exifAttribute.f7822b);
                    if (s9 > 4) {
                        byteOrderedDataOutputStream2.f((long) size);
                        size += s9;
                    } else {
                        byteOrderedDataOutputStream2.write(exifAttribute.f7824d);
                        if (s9 < 4) {
                            while (s9 < 4) {
                                byteOrderedDataOutputStream2.c(0);
                                s9++;
                            }
                        }
                    }
                }
                if (i15 != 0 || this.f7811f[4].isEmpty()) {
                    byteOrderedDataOutputStream2.f(0);
                } else {
                    byteOrderedDataOutputStream2.f((long) iArr[4]);
                }
                for (Map.Entry<String, ExifAttribute> value2 : this.f7811f[i15].entrySet()) {
                    byte[] bArr = ((ExifAttribute) value2.getValue()).f7824d;
                    if (bArr.length > 4) {
                        byteOrderedDataOutputStream2.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.f7814i) {
            byteOrderedDataOutputStream2.write(G());
        }
        if (this.f7809d == 14 && i11 % 2 == 1) {
            byteOrderedDataOutputStream2.c(0);
        }
        byteOrderedDataOutputStream2.b(ByteOrder.BIG_ENDIAN);
        return i11;
    }

    private void I(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (w) {
            Log.d(v, "getWebpAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.d(ByteOrder.LITTLE_ENDIAN);
        byteOrderedDataInputStream.e(Y5.length);
        int readInt = byteOrderedDataInputStream.readInt() + 8;
        byte[] bArr = Z5;
        byteOrderedDataInputStream.e(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (byteOrderedDataInputStream.read(bArr2) == 4) {
                    int readInt2 = byteOrderedDataInputStream.readInt();
                    int i8 = length + 8;
                    if (Arrays.equals(b6, bArr2)) {
                        byte[] bArr3 = new byte[readInt2];
                        if (byteOrderedDataInputStream.read(bArr3) == readInt2) {
                            this.p = i8;
                            j0(bArr3, 0);
                            z0(new ByteOrderedDataInputStream(bArr3));
                            return;
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + ExifInterfaceUtils.a(bArr2));
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    length = i8 + readInt2;
                    if (length != readInt) {
                        if (length <= readInt) {
                            byteOrderedDataInputStream.e(readInt2);
                        } else {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:67|68|69) */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        java.lang.Double.parseDouble(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x014a, code lost:
        return new android.util.Pair<>(12, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0150, code lost:
        return new android.util.Pair<>(2, -1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x013c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<java.lang.Integer, java.lang.Integer> J(java.lang.String r10) {
        /*
            java.lang.String r0 = ","
            boolean r1 = r10.contains(r0)
            r2 = 0
            r3 = 1
            r4 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r6 = -1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            if (r1 == 0) goto L_0x00a6
            java.lang.String[] r10 = r10.split(r0, r6)
            r0 = r10[r2]
            android.util.Pair r0 = J(r0)
            java.lang.Object r1 = r0.first
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r1 != r4) goto L_0x0029
            return r0
        L_0x0029:
            int r1 = r10.length
            if (r3 >= r1) goto L_0x00a5
            r1 = r10[r3]
            android.util.Pair r1 = J(r1)
            java.lang.Object r2 = r1.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x004d
            java.lang.Object r2 = r1.second
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r2 = -1
            goto L_0x0055
        L_0x004d:
            java.lang.Object r2 = r0.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
        L_0x0055:
            java.lang.Object r4 = r0.second
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 == r6) goto L_0x0080
            java.lang.Object r4 = r1.first
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Object r8 = r0.second
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x0077
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r4 = r0.second
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0080
        L_0x0077:
            java.lang.Object r1 = r0.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L_0x0081
        L_0x0080:
            r1 = -1
        L_0x0081:
            if (r2 != r6) goto L_0x008b
            if (r1 != r6) goto L_0x008b
            android.util.Pair r10 = new android.util.Pair
            r10.<init>(r5, r7)
            return r10
        L_0x008b:
            if (r2 != r6) goto L_0x0097
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.<init>(r1, r7)
            goto L_0x00a2
        L_0x0097:
            if (r1 != r6) goto L_0x00a2
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r0.<init>(r1, r7)
        L_0x00a2:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x00a5:
            return r0
        L_0x00a6:
            java.lang.String r0 = "/"
            boolean r1 = r10.contains(r0)
            r8 = 0
            if (r1 == 0) goto L_0x0105
            java.lang.String[] r10 = r10.split(r0, r6)
            int r0 = r10.length
            if (r0 != r4) goto L_0x00ff
            r0 = r10[r2]     // Catch:{ NumberFormatException -> 0x00ff }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            long r0 = (long) r0     // Catch:{ NumberFormatException -> 0x00ff }
            r10 = r10[r3]     // Catch:{ NumberFormatException -> 0x00ff }
            double r2 = java.lang.Double.parseDouble(r10)     // Catch:{ NumberFormatException -> 0x00ff }
            long r2 = (long) r2     // Catch:{ NumberFormatException -> 0x00ff }
            r10 = 10
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 < 0) goto L_0x00f5
            int r4 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x00d0
            goto L_0x00f5
        L_0x00d0:
            r4 = 5
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r6 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r6 > 0) goto L_0x00eb
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x00dd
            goto L_0x00eb
        L_0x00dd:
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            r0.<init>(r10, r1)     // Catch:{ NumberFormatException -> 0x00ff }
            return r0
        L_0x00eb:
            android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            r10.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r10
        L_0x00f5:
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ NumberFormatException -> 0x00ff }
            r0.<init>(r10, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r0
        L_0x00ff:
            android.util.Pair r10 = new android.util.Pair
            r10.<init>(r5, r7)
            return r10
        L_0x0105:
            long r0 = java.lang.Long.parseLong(r10)     // Catch:{ NumberFormatException -> 0x013c }
            r2 = 4
            int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x0124
            r8 = 65535(0xffff, double:3.23786E-319)
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 > 0) goto L_0x0124
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013c }
            r1 = 3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x013c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x013c }
            r0.<init>(r1, r2)     // Catch:{ NumberFormatException -> 0x013c }
            return r0
        L_0x0124:
            if (r3 >= 0) goto L_0x0132
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013c }
            r1 = 9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x013c }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x013c }
            return r0
        L_0x0132:
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013c }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x013c }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x013c }
            return r0
        L_0x013c:
            java.lang.Double.parseDouble(r10)     // Catch:{ NumberFormatException -> 0x014b }
            android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014b }
            r0 = 12
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x014b }
            r10.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x014b }
            return r10
        L_0x014b:
            android.util.Pair r10 = new android.util.Pair
            r10.<init>(r5, r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.J(java.lang.String):android.util.Pair");
    }

    private void K(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(N);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(O);
        if (exifAttribute != null && exifAttribute2 != null) {
            int p8 = exifAttribute.p(this.f7813h);
            int p9 = exifAttribute2.p(this.f7813h);
            if (this.f7809d == 7) {
                p8 += this.q;
            }
            if (p8 > 0 && p9 > 0) {
                this.f7814i = true;
                if (this.f7806a == null && this.f7808c == null && this.f7807b == null) {
                    byte[] bArr = new byte[p9];
                    byteOrderedDataInputStream.skip((long) p8);
                    byteOrderedDataInputStream.read(bArr);
                    this.f7819n = bArr;
                }
                this.f7817l = p8;
                this.f7818m = p9;
            }
            if (w) {
                Log.d(v, "Setting thumbnail attributes with offset: " + p8 + ", length: " + p9);
            }
        }
    }

    private void L(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = byteOrderedDataInputStream;
        HashMap hashMap2 = hashMap;
        ExifAttribute exifAttribute = (ExifAttribute) hashMap2.get(K);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap2.get(M);
        if (exifAttribute != null && exifAttribute2 != null) {
            long[] d8 = ExifInterfaceUtils.d(exifAttribute.r(this.f7813h));
            long[] d9 = ExifInterfaceUtils.d(exifAttribute2.r(this.f7813h));
            if (d8 == null || d8.length == 0) {
                Log.w(v, "stripOffsets should not be null or have zero length.");
            } else if (d9 == null || d9.length == 0) {
                Log.w(v, "stripByteCounts should not be null or have zero length.");
            } else if (d8.length != d9.length) {
                Log.w(v, "stripOffsets and stripByteCounts should have same length.");
            } else {
                long j8 = 0;
                for (long j9 : d9) {
                    j8 += j9;
                }
                int i8 = (int) j8;
                byte[] bArr = new byte[i8];
                int i9 = 1;
                this.f7816k = true;
                this.f7815j = true;
                this.f7814i = true;
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                while (i10 < d8.length) {
                    int i13 = (int) d8[i10];
                    int i14 = (int) d9[i10];
                    if (i10 < d8.length - i9 && ((long) (i13 + i14)) != d8[i10 + 1]) {
                        this.f7816k = false;
                    }
                    int i15 = i13 - i11;
                    if (i15 < 0) {
                        Log.d(v, "Invalid strip offset value");
                        return;
                    }
                    long j10 = (long) i15;
                    if (byteOrderedDataInputStream2.skip(j10) != j10) {
                        Log.d(v, "Failed to skip " + i15 + " bytes.");
                        return;
                    }
                    int i16 = i11 + i15;
                    byte[] bArr2 = new byte[i14];
                    if (byteOrderedDataInputStream2.read(bArr2) != i14) {
                        Log.d(v, "Failed to read " + i14 + " bytes.");
                        return;
                    }
                    i11 = i16 + i14;
                    System.arraycopy(bArr2, 0, bArr, i12, i14);
                    i12 += i14;
                    i10++;
                    i9 = 1;
                }
                this.f7819n = bArr;
                if (this.f7816k) {
                    this.f7817l = (int) d8[0];
                    this.f7818m = i8;
                }
            }
        }
    }

    private void O(String str) throws IOException {
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.f7808c = null;
            this.f7806a = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    if (X(fileInputStream2.getFD())) {
                        this.f7807b = fileInputStream2.getFD();
                    } else {
                        this.f7807b = null;
                    }
                    e0(fileInputStream2);
                    ExifInterfaceUtils.c(fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    ExifInterfaceUtils.c(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                ExifInterfaceUtils.c(fileInputStream);
                throw th;
            }
        } else {
            throw new NullPointerException("filename cannot be null");
        }
    }

    private static boolean P(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = k7;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i8 = 0;
        while (true) {
            byte[] bArr3 = k7;
            if (i8 >= bArr3.length) {
                return true;
            }
            if (bArr2[i8] != bArr3[i8]) {
                return false;
            }
            i8++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0093 A[Catch:{ all -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean R(byte[] r15) throws java.io.IOException {
        /*
            r14 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r2 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x008e }
            r2.<init>((byte[]) r15)     // Catch:{ Exception -> 0x008e }
            int r1 = r2.readInt()     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            long r3 = (long) r1     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            r1 = 4
            byte[] r5 = new byte[r1]     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            r2.read(r5)     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            byte[] r6 = G5     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            boolean r5 = java.util.Arrays.equals(r5, r6)     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            if (r5 != 0) goto L_0x001e
            r2.close()
            return r0
        L_0x001e:
            r5 = 8
            r7 = 1
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x003b
            long r3 = r2.readLong()     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            r9 = 16
            int r11 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r11 >= 0) goto L_0x003c
            r2.close()
            return r0
        L_0x0034:
            r15 = move-exception
            r1 = r2
            goto L_0x00a0
        L_0x0038:
            r15 = move-exception
            r1 = r2
            goto L_0x008f
        L_0x003b:
            r9 = r5
        L_0x003c:
            int r11 = r15.length     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            long r11 = (long) r11     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            int r13 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x0044
            int r15 = r15.length     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            long r3 = (long) r15
        L_0x0044:
            long r3 = r3 - r9
            int r15 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r15 >= 0) goto L_0x004d
            r2.close()
            return r0
        L_0x004d:
            byte[] r15 = new byte[r1]     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            r5 = 0
            r9 = 0
            r10 = 0
        L_0x0053:
            r11 = 4
            long r11 = r3 / r11
            int r13 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0088
            int r11 = r2.read(r15)     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            if (r11 == r1) goto L_0x0065
            r2.close()
            return r0
        L_0x0065:
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 != 0) goto L_0x006a
            goto L_0x0086
        L_0x006a:
            byte[] r11 = H5     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            r12 = 1
            if (r11 == 0) goto L_0x0075
            r9 = 1
            goto L_0x007e
        L_0x0075:
            byte[] r11 = I5     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            if (r11 == 0) goto L_0x007e
            r10 = 1
        L_0x007e:
            if (r9 == 0) goto L_0x0086
            if (r10 == 0) goto L_0x0086
            r2.close()
            return r12
        L_0x0086:
            long r5 = r5 + r7
            goto L_0x0053
        L_0x0088:
            r2.close()
            goto L_0x009f
        L_0x008c:
            r15 = move-exception
            goto L_0x00a0
        L_0x008e:
            r15 = move-exception
        L_0x008f:
            boolean r2 = w     // Catch:{ all -> 0x008c }
            if (r2 == 0) goto L_0x009a
            java.lang.String r2 = "ExifInterface"
            java.lang.String r3 = "Exception parsing HEIF file type box."
            android.util.Log.d(r2, r3, r15)     // Catch:{ all -> 0x008c }
        L_0x009a:
            if (r1 == 0) goto L_0x009f
            r1.close()
        L_0x009f:
            return r0
        L_0x00a0:
            if (r1 == 0) goto L_0x00a5
            r1.close()
        L_0x00a5:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.R(byte[]):boolean");
    }

    private static boolean S(byte[] bArr) throws IOException {
        int i8 = 0;
        while (true) {
            byte[] bArr2 = D5;
            if (i8 >= bArr2.length) {
                return true;
            }
            if (bArr[i8] != bArr2[i8]) {
                return false;
            }
            i8++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean T(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r2 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            java.nio.ByteOrder r4 = r3.i0(r2)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r3.f7813h = r4     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r2.d(r4)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r1 = 20306(0x4f52, float:2.8455E-41)
            if (r4 == r1) goto L_0x001c
            r1 = 21330(0x5352, float:2.989E-41)
            if (r4 != r1) goto L_0x001d
        L_0x001c:
            r0 = 1
        L_0x001d:
            r2.close()
            return r0
        L_0x0021:
            r4 = move-exception
            r1 = r2
            goto L_0x002b
        L_0x0024:
            r1 = r2
            goto L_0x0031
        L_0x0027:
            r4 = move-exception
            goto L_0x002b
        L_0x0029:
            goto L_0x0031
        L_0x002b:
            if (r1 == 0) goto L_0x0030
            r1.close()
        L_0x0030:
            throw r4
        L_0x0031:
            if (r1 == 0) goto L_0x0036
            r1.close()
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.T(byte[]):boolean");
    }

    private boolean U(byte[] bArr) throws IOException {
        int i8 = 0;
        while (true) {
            byte[] bArr2 = S5;
            if (i8 >= bArr2.length) {
                return true;
            }
            if (bArr[i8] != bArr2[i8]) {
                return false;
            }
            i8++;
        }
    }

    private boolean V(byte[] bArr) throws IOException {
        byte[] bytes = E5.getBytes(Charset.defaultCharset());
        for (int i8 = 0; i8 < bytes.length; i8++) {
            if (bArr[i8] != bytes[i8]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean W(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r2 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x0025, all -> 0x0023 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x0025, all -> 0x0023 }
            java.nio.ByteOrder r4 = r3.i0(r2)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r3.f7813h = r4     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r2.d(r4)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r1 = 85
            if (r4 != r1) goto L_0x0019
            r0 = 1
        L_0x0019:
            r2.close()
            return r0
        L_0x001d:
            r4 = move-exception
            r1 = r2
            goto L_0x0027
        L_0x0020:
            r1 = r2
            goto L_0x002d
        L_0x0023:
            r4 = move-exception
            goto L_0x0027
        L_0x0025:
            goto L_0x002d
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()
        L_0x002c:
            throw r4
        L_0x002d:
            if (r1 == 0) goto L_0x0032
            r1.close()
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.W(byte[]):boolean");
    }

    private static boolean X(FileDescriptor fileDescriptor) {
        try {
            ExifInterfaceUtils.Api21Impl.c(fileDescriptor, 0, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!w) {
                return false;
            }
            Log.d(v, "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    private boolean Y(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute;
        int p8;
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(z);
        if (exifAttribute2 != null) {
            int[] iArr = (int[]) exifAttribute2.r(this.f7813h);
            int[] iArr2 = r5;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.f7809d == 3 && (exifAttribute = (ExifAttribute) hashMap.get(B)) != null && (((p8 = exifAttribute.p(this.f7813h)) == 1 && Arrays.equals(iArr, t5)) || (p8 == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!w) {
            return false;
        }
        Log.d(v, "Unsupported data type value");
        return false;
    }

    private static boolean Z(int i8) {
        return i8 == 4 || i8 == 13 || i8 == 14;
    }

    private void a() {
        String i8 = i(m0);
        if (i8 != null && i(U) == null) {
            this.f7811f[0].put(U, ExifAttribute.h(i8));
        }
        if (i(x) == null) {
            this.f7811f[0].put(x, ExifAttribute.i(0, this.f7813h));
        }
        if (i(y) == null) {
            this.f7811f[0].put(y, ExifAttribute.i(0, this.f7813h));
        }
        if (i(C) == null) {
            this.f7811f[0].put(C, ExifAttribute.i(0, this.f7813h));
        }
        if (i(O0) == null) {
            this.f7811f[1].put(O0, ExifAttribute.i(0, this.f7813h));
        }
    }

    public static boolean a0(@NonNull String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.hashCode();
            char c8 = 65535;
            switch (lowerCase.hashCode()) {
                case -1875291391:
                    if (lowerCase.equals("image/x-fuji-raf")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case -1635437028:
                    if (lowerCase.equals("image/x-samsung-srw")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case -1594371159:
                    if (lowerCase.equals("image/x-sony-arw")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case -1487464693:
                    if (lowerCase.equals("image/heic")) {
                        c8 = 3;
                        break;
                    }
                    break;
                case -1487464690:
                    if (lowerCase.equals(MimeTypes.S0)) {
                        c8 = 4;
                        break;
                    }
                    break;
                case -1487394660:
                    if (lowerCase.equals(MimeTypes.Q0)) {
                        c8 = 5;
                        break;
                    }
                    break;
                case -1487018032:
                    if (lowerCase.equals(MimeTypes.U0)) {
                        c8 = 6;
                        break;
                    }
                    break;
                case -1423313290:
                    if (lowerCase.equals("image/x-adobe-dng")) {
                        c8 = 7;
                        break;
                    }
                    break;
                case -985160897:
                    if (lowerCase.equals("image/x-panasonic-rw2")) {
                        c8 = 8;
                        break;
                    }
                    break;
                case -879258763:
                    if (lowerCase.equals(MimeTypes.R0)) {
                        c8 = 9;
                        break;
                    }
                    break;
                case -332763809:
                    if (lowerCase.equals("image/x-pentax-pef")) {
                        c8 = 10;
                        break;
                    }
                    break;
                case 1378106698:
                    if (lowerCase.equals("image/x-olympus-orf")) {
                        c8 = 11;
                        break;
                    }
                    break;
                case 2099152104:
                    if (lowerCase.equals("image/x-nikon-nef")) {
                        c8 = 12;
                        break;
                    }
                    break;
                case 2099152524:
                    if (lowerCase.equals("image/x-nikon-nrw")) {
                        c8 = 13;
                        break;
                    }
                    break;
                case 2111234748:
                    if (lowerCase.equals("image/x-canon-cr2")) {
                        c8 = 14;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                    return true;
                default:
                    return false;
            }
        } else {
            throw new NullPointerException("mimeType shouldn't be null");
        }
    }

    private String b(double d8) {
        long j8 = (long) d8;
        double d9 = d8 - ((double) j8);
        long j9 = (long) (d9 * 60.0d);
        long round = Math.round((d9 - (((double) j9) / 60.0d)) * 3600.0d * 1.0E7d);
        return j8 + "/1," + j9 + "/1," + round + "/10000000";
    }

    private boolean b0(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(y);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(x);
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        return exifAttribute.p(this.f7813h) <= 512 && exifAttribute2.p(this.f7813h) <= 512;
    }

    private static double c(String str, String str2) {
        try {
            String[] split = str.split(",", -1);
            String[] split2 = split[0].split("/", -1);
            String[] split3 = split[1].split("/", -1);
            String[] split4 = split[2].split("/", -1);
            double parseDouble = (Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim())) + ((Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim())) / 60.0d) + ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d);
            if (!str2.equals(R4)) {
                if (!str2.equals(T4)) {
                    if (!str2.equals("N")) {
                        if (!str2.equals(S4)) {
                            throw new IllegalArgumentException();
                        }
                    }
                    return parseDouble;
                }
            }
            return -parseDouble;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    private void d(ByteOrderedDataInputStream byteOrderedDataInputStream, ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr, byte[] bArr2) throws IOException {
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (byteOrderedDataInputStream.read(bArr3) != 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                Charset charset = j7;
                sb.append(new String(bArr, charset));
                if (bArr2 == null) {
                    str = "";
                } else {
                    str = " or " + new String(bArr2, charset);
                }
                sb.append(str);
                throw new IOException(sb.toString());
            }
            e(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    private boolean d0(byte[] bArr) throws IOException {
        int i8 = 0;
        while (true) {
            byte[] bArr2 = Y5;
            if (i8 >= bArr2.length) {
                int i9 = 0;
                while (true) {
                    byte[] bArr3 = Z5;
                    if (i9 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[Y5.length + i9 + 4] != bArr3[i9]) {
                        return false;
                    }
                    i9++;
                }
            } else if (bArr[i8] != bArr2[i8]) {
                return false;
            } else {
                i8++;
            }
        }
    }

    private void e(ByteOrderedDataInputStream byteOrderedDataInputStream, ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr) throws IOException {
        int readInt = byteOrderedDataInputStream.readInt();
        byteOrderedDataOutputStream.write(bArr);
        byteOrderedDataOutputStream.d(readInt);
        if (readInt % 2 == 1) {
            readInt++;
        }
        ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream, readInt);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x009f A[Catch:{ all -> 0x0015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e0(@androidx.annotation.NonNull java.io.InputStream r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x00b8
            r0 = 0
            r1 = 0
        L_0x0004:
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r2 = d7     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            int r2 = r2.length     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            if (r1 >= r2) goto L_0x001e
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r4.f7811f     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r3.<init>()     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r2[r1] = r3     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            int r1 = r1 + 1
            goto L_0x0004
        L_0x0015:
            r5 = move-exception
            goto L_0x00ad
        L_0x0018:
            r5 = move-exception
            goto L_0x009b
        L_0x001b:
            r5 = move-exception
            goto L_0x009b
        L_0x001e:
            boolean r1 = r4.f7810e     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            if (r1 != 0) goto L_0x0030
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r2 = 5000(0x1388, float:7.006E-42)
            r1.<init>(r5, r2)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            int r5 = r4.w(r1)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r4.f7809d = r5     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r5 = r1
        L_0x0030:
            int r1 = r4.f7809d     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            boolean r1 = A0(r1)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            if (r1 == 0) goto L_0x006b
            androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream r0 = new androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r0.<init>((java.io.InputStream) r5)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            boolean r5 = r4.f7810e     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            if (r5 == 0) goto L_0x0045
            r4.D(r0)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            goto L_0x0061
        L_0x0045:
            int r5 = r4.f7809d     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r1 = 12
            if (r5 != r1) goto L_0x004f
            r4.s(r0)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            goto L_0x0061
        L_0x004f:
            r1 = 7
            if (r5 != r1) goto L_0x0056
            r4.x(r0)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            goto L_0x0061
        L_0x0056:
            r1 = 10
            if (r5 != r1) goto L_0x005e
            r4.C(r0)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            goto L_0x0061
        L_0x005e:
            r4.A(r0)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
        L_0x0061:
            int r5 = r4.p     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            long r1 = (long) r5     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r0.f(r1)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r4.z0(r0)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            goto L_0x0090
        L_0x006b:
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r1 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r1.<init>((java.io.InputStream) r5)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            int r5 = r4.f7809d     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r2 = 4
            if (r5 != r2) goto L_0x0079
            r4.t(r1, r0, r0)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            goto L_0x0090
        L_0x0079:
            r0 = 13
            if (r5 != r0) goto L_0x0081
            r4.y(r1)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            goto L_0x0090
        L_0x0081:
            r0 = 9
            if (r5 != r0) goto L_0x0089
            r4.z(r1)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            goto L_0x0090
        L_0x0089:
            r0 = 14
            if (r5 != r0) goto L_0x0090
            r4.I(r1)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
        L_0x0090:
            r4.a()
            boolean r5 = w
            if (r5 == 0) goto L_0x00ac
        L_0x0097:
            r4.h0()
            goto L_0x00ac
        L_0x009b:
            boolean r0 = w     // Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x00a6
            java.lang.String r1 = "ExifInterface"
            java.lang.String r2 = "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface."
            android.util.Log.w(r1, r2, r5)     // Catch:{ all -> 0x0015 }
        L_0x00a6:
            r4.a()
            if (r0 == 0) goto L_0x00ac
            goto L_0x0097
        L_0x00ac:
            return
        L_0x00ad:
            r4.a()
            boolean r0 = w
            if (r0 == 0) goto L_0x00b7
            r4.h0()
        L_0x00b7:
            throw r5
        L_0x00b8:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "inputstream shouldn't be null"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.e0(java.io.InputStream):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        if ("-".equals(r1) != false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Long f0(@androidx.annotation.Nullable java.lang.String r10, @androidx.annotation.Nullable java.lang.String r11, @androidx.annotation.Nullable java.lang.String r12) {
        /*
            r0 = 0
            if (r10 == 0) goto L_0x0086
            java.util.regex.Pattern r1 = U7
            java.util.regex.Matcher r1 = r1.matcher(r10)
            boolean r1 = r1.matches()
            if (r1 != 0) goto L_0x0011
            goto L_0x0086
        L_0x0011:
            java.text.ParsePosition r1 = new java.text.ParsePosition
            r2 = 0
            r1.<init>(r2)
            java.text.SimpleDateFormat r3 = m6     // Catch:{ IllegalArgumentException -> 0x0086 }
            java.util.Date r3 = r3.parse(r10, r1)     // Catch:{ IllegalArgumentException -> 0x0086 }
            if (r3 != 0) goto L_0x0028
            java.text.SimpleDateFormat r3 = n6     // Catch:{ IllegalArgumentException -> 0x0086 }
            java.util.Date r3 = r3.parse(r10, r1)     // Catch:{ IllegalArgumentException -> 0x0086 }
            if (r3 != 0) goto L_0x0028
            return r0
        L_0x0028:
            long r3 = r3.getTime()     // Catch:{ IllegalArgumentException -> 0x0086 }
            if (r12 == 0) goto L_0x007a
            r10 = 1
            java.lang.String r1 = r12.substring(r2, r10)     // Catch:{ IllegalArgumentException -> 0x0086 }
            r2 = 3
            java.lang.String r5 = r12.substring(r10, r2)     // Catch:{ IllegalArgumentException -> 0x0086 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ IllegalArgumentException -> 0x0086 }
            r6 = 6
            r7 = 4
            java.lang.String r6 = r12.substring(r7, r6)     // Catch:{ IllegalArgumentException -> 0x0086 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ IllegalArgumentException -> 0x0086 }
            java.lang.String r8 = "+"
            boolean r8 = r8.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0086 }
            java.lang.String r9 = "-"
            if (r8 != 0) goto L_0x0056
            boolean r8 = r9.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0086 }
            if (r8 == 0) goto L_0x007a
        L_0x0056:
            java.lang.String r8 = ":"
            java.lang.String r12 = r12.substring(r2, r7)     // Catch:{ IllegalArgumentException -> 0x0086 }
            boolean r12 = r8.equals(r12)     // Catch:{ IllegalArgumentException -> 0x0086 }
            if (r12 == 0) goto L_0x007a
            r12 = 14
            if (r5 > r12) goto L_0x007a
            int r5 = r5 * 60
            int r5 = r5 + r6
            r12 = 60000(0xea60, float:8.4078E-41)
            int r5 = r5 * r12
            boolean r12 = r9.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0086 }
            if (r12 == 0) goto L_0x0075
            goto L_0x0076
        L_0x0075:
            r10 = -1
        L_0x0076:
            int r5 = r5 * r10
            long r1 = (long) r5     // Catch:{ IllegalArgumentException -> 0x0086 }
            long r3 = r3 + r1
        L_0x007a:
            if (r11 == 0) goto L_0x0081
            long r10 = androidx.exifinterface.media.ExifInterfaceUtils.g(r11)     // Catch:{ IllegalArgumentException -> 0x0086 }
            long r3 = r3 + r10
        L_0x0081:
            java.lang.Long r10 = java.lang.Long.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x0086 }
            return r10
        L_0x0086:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.f0(java.lang.String, java.lang.String, java.lang.String):java.lang.Long");
    }

    private void g0(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        ByteOrder i02 = i0(byteOrderedDataInputStream);
        this.f7813h = i02;
        byteOrderedDataInputStream.d(i02);
        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i8 = this.f7809d;
        if (i8 == 7 || i8 == 10 || readUnsignedShort == 42) {
            int readInt = byteOrderedDataInputStream.readInt();
            if (readInt >= 8) {
                int i9 = readInt - 8;
                if (i9 > 0) {
                    byteOrderedDataInputStream.e(i9);
                    return;
                }
                return;
            }
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    private void h0() {
        for (int i8 = 0; i8 < this.f7811f.length; i8++) {
            Log.d(v, "The size of tag group[" + i8 + "]: " + this.f7811f[i8].size());
            for (Map.Entry next : this.f7811f[i8].entrySet()) {
                ExifAttribute exifAttribute = (ExifAttribute) next.getValue();
                Log.d(v, "tagName: " + ((String) next.getKey()) + ", tagType: " + exifAttribute.toString() + ", tagValue: '" + exifAttribute.q(this.f7813h) + "'");
            }
        }
    }

    private ByteOrder i0(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short readShort = byteOrderedDataInputStream.readShort();
        if (readShort == 18761) {
            if (w) {
                Log.d(v, "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        } else if (readShort == 19789) {
            if (w) {
                Log.d(v, "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        } else {
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
    }

    private void j0(byte[] bArr, int i8) throws IOException {
        SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(bArr);
        g0(seekableByteOrderedDataInputStream);
        k0(seekableByteOrderedDataInputStream, i8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x027d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k0(androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream r29, int r30) throws java.io.IOException {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r2 = r30
            r5 = 5
            r7 = 0
            java.util.Set<java.lang.Integer> r9 = r0.f7812g
            int r10 = r1.Y
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r9.add(r10)
            short r9 = r29.readShort()
            boolean r10 = w
            java.lang.String r11 = "ExifInterface"
            if (r10 == 0) goto L_0x0031
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = "numberOfDirectoryEntry: "
            r10.append(r12)
            r10.append(r9)
            java.lang.String r10 = r10.toString()
            android.util.Log.d(r11, r10)
        L_0x0031:
            if (r9 > 0) goto L_0x0034
            return
        L_0x0034:
            r10 = 0
        L_0x0035:
            if (r10 >= r9) goto L_0x031f
            int r14 = r29.readUnsignedShort()
            int r15 = r29.readUnsignedShort()
            int r12 = r29.readInt()
            int r13 = r29.b()
            long r3 = (long) r13
            r18 = 4
            long r3 = r3 + r18
            java.util.HashMap<java.lang.Integer, androidx.exifinterface.media.ExifInterface$ExifTag>[] r13 = f7
            r13 = r13[r2]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r14)
            java.lang.Object r6 = r13.get(r6)
            androidx.exifinterface.media.ExifInterface$ExifTag r6 = (androidx.exifinterface.media.ExifInterface.ExifTag) r6
            boolean r13 = w
            if (r13 == 0) goto L_0x0092
            java.lang.Integer r20 = java.lang.Integer.valueOf(r30)
            java.lang.Integer r21 = java.lang.Integer.valueOf(r14)
            if (r6 == 0) goto L_0x006b
            java.lang.String r8 = r6.f7826b
            goto L_0x006c
        L_0x006b:
            r8 = 0
        L_0x006c:
            java.lang.Integer r22 = java.lang.Integer.valueOf(r15)
            java.lang.Integer r23 = java.lang.Integer.valueOf(r12)
            r24 = r9
            java.lang.Object[] r9 = new java.lang.Object[r5]
            r9[r7] = r20
            r20 = 1
            r9[r20] = r21
            r20 = 2
            r9[r20] = r8
            r8 = 3
            r9[r8] = r22
            r8 = 4
            r9[r8] = r23
            java.lang.String r8 = "ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d"
            java.lang.String r8 = java.lang.String.format(r8, r9)
            android.util.Log.d(r11, r8)
            goto L_0x0094
        L_0x0092:
            r24 = r9
        L_0x0094:
            r8 = 7
            if (r6 != 0) goto L_0x00b1
            if (r13 == 0) goto L_0x00ad
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r5 = "Skip the tag entry since tag number is not defined: "
            r9.append(r5)
            r9.append(r14)
            java.lang.String r5 = r9.toString()
        L_0x00aa:
            android.util.Log.d(r11, r5)
        L_0x00ad:
            r23 = r10
            goto L_0x012d
        L_0x00b1:
            if (r15 <= 0) goto L_0x00b8
            int[] r5 = H6
            int r9 = r5.length
            if (r15 < r9) goto L_0x00bb
        L_0x00b8:
            r23 = r10
            goto L_0x0117
        L_0x00bb:
            boolean r9 = r6.a(r15)
            if (r9 != 0) goto L_0x00e3
            if (r13 == 0) goto L_0x00ad
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = "Skip the tag entry since data format ("
            r5.append(r9)
            java.lang.String[] r9 = G6
            r9 = r9[r15]
            r5.append(r9)
            java.lang.String r9 = ") is unexpected for tag: "
            r5.append(r9)
            java.lang.String r9 = r6.f7826b
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            goto L_0x00aa
        L_0x00e3:
            if (r15 != r8) goto L_0x00e7
            int r15 = r6.f7827c
        L_0x00e7:
            long r7 = (long) r12
            r5 = r5[r15]
            r23 = r10
            long r9 = (long) r5
            long r7 = r7 * r9
            r9 = 0
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 < 0) goto L_0x00ff
            r9 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x00fd
            goto L_0x00ff
        L_0x00fd:
            r5 = 1
            goto L_0x0130
        L_0x00ff:
            if (r13 == 0) goto L_0x0115
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = "Skip the tag entry since the number of components is invalid: "
            r5.append(r9)
            r5.append(r12)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r11, r5)
        L_0x0115:
            r5 = 0
            goto L_0x0130
        L_0x0117:
            if (r13 == 0) goto L_0x012d
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "Skip the tag entry since data format is invalid: "
            r5.append(r7)
            r5.append(r15)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r11, r5)
        L_0x012d:
            r5 = 0
            r7 = 0
        L_0x0130:
            if (r5 != 0) goto L_0x013a
            r1.f(r3)
            r4 = r11
        L_0x0136:
            r2 = 3
        L_0x0137:
            r3 = 1
            goto L_0x0313
        L_0x013a:
            java.lang.String r5 = "Compression"
            int r9 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            if (r9 <= 0) goto L_0x01bd
            int r9 = r29.readInt()
            if (r13 == 0) goto L_0x015d
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r25 = r3
            java.lang.String r3 = "seek to data offset: "
            r10.append(r3)
            r10.append(r9)
            java.lang.String r3 = r10.toString()
            android.util.Log.d(r11, r3)
            goto L_0x015f
        L_0x015d:
            r25 = r3
        L_0x015f:
            int r3 = r0.f7809d
            r4 = 7
            if (r3 != r4) goto L_0x0170
            java.lang.String r3 = r6.f7826b
            java.lang.String r4 = "MakerNote"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0173
            r0.q = r9
        L_0x0170:
            r27 = r11
            goto L_0x01b8
        L_0x0173:
            r3 = 6
            if (r2 != r3) goto L_0x0170
            java.lang.String r4 = "ThumbnailImage"
            java.lang.String r10 = r6.f7826b
            boolean r4 = r4.equals(r10)
            if (r4 == 0) goto L_0x0170
            r0.r = r9
            r0.s = r12
            java.nio.ByteOrder r4 = r0.f7813h
            androidx.exifinterface.media.ExifInterface$ExifAttribute r3 = androidx.exifinterface.media.ExifInterface.ExifAttribute.m(r3, r4)
            int r4 = r0.r
            r27 = r11
            long r10 = (long) r4
            java.nio.ByteOrder r4 = r0.f7813h
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.i(r10, r4)
            int r10 = r0.s
            long r10 = (long) r10
            java.nio.ByteOrder r2 = r0.f7813h
            androidx.exifinterface.media.ExifInterface$ExifAttribute r2 = androidx.exifinterface.media.ExifInterface.ExifAttribute.i(r10, r2)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r10 = r0.f7811f
            r11 = 4
            r10 = r10[r11]
            r10.put(r5, r3)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.f7811f
            r3 = r3[r11]
            java.lang.String r10 = "JPEGInterchangeFormat"
            r3.put(r10, r4)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.f7811f
            r3 = r3[r11]
            java.lang.String r4 = "JPEGInterchangeFormatLength"
            r3.put(r4, r2)
        L_0x01b8:
            long r2 = (long) r9
            r1.f(r2)
            goto L_0x01c1
        L_0x01bd:
            r25 = r3
            r27 = r11
        L_0x01c1:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r2 = i7
            java.lang.Integer r3 = java.lang.Integer.valueOf(r14)
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r13 == 0) goto L_0x01ee
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "nextIfdType: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r4 = " byteCount: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r4 = r27
            android.util.Log.d(r4, r3)
            goto L_0x01f0
        L_0x01ee:
            r4 = r27
        L_0x01f0:
            r3 = 8
            if (r2 == 0) goto L_0x0296
            r9 = 3
            if (r15 == r9) goto L_0x0217
            r5 = 4
            if (r15 == r5) goto L_0x0212
            if (r15 == r3) goto L_0x020d
            r3 = 9
            if (r15 == r3) goto L_0x0207
            r3 = 13
            if (r15 == r3) goto L_0x0207
            r7 = -1
            goto L_0x021c
        L_0x0207:
            int r3 = r29.readInt()
        L_0x020b:
            long r7 = (long) r3
            goto L_0x021c
        L_0x020d:
            short r3 = r29.readShort()
            goto L_0x020b
        L_0x0212:
            long r7 = r29.c()
            goto L_0x021c
        L_0x0217:
            int r3 = r29.readUnsignedShort()
            goto L_0x020b
        L_0x021c:
            if (r13 == 0) goto L_0x0239
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
            java.lang.String r5 = r6.f7826b
            r10 = 2
            java.lang.Object[] r6 = new java.lang.Object[r10]
            r9 = 0
            r6[r9] = r3
            r3 = 1
            r6[r3] = r5
            java.lang.String r3 = "Offset: %d, tagName: %s"
            java.lang.String r3 = java.lang.String.format(r3, r6)
            android.util.Log.d(r4, r3)
        L_0x0236:
            r5 = 0
            goto L_0x023b
        L_0x0239:
            r10 = 2
            goto L_0x0236
        L_0x023b:
            int r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x027d
            java.util.Set<java.lang.Integer> r3 = r0.f7812g
            int r5 = (int) r7
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            boolean r3 = r3.contains(r5)
            if (r3 != 0) goto L_0x0259
            r1.f(r7)
            int r2 = r2.intValue()
            r0.k0(r1, r2)
        L_0x0256:
            r13 = r25
            goto L_0x0291
        L_0x0259:
            if (r13 == 0) goto L_0x0256
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Skip jump into the IFD since it has already been read: IfdType "
            r3.append(r5)
            r3.append(r2)
            java.lang.String r2 = " (at "
            r3.append(r2)
            r3.append(r7)
            java.lang.String r2 = ")"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
        L_0x0279:
            android.util.Log.d(r4, r2)
            goto L_0x0256
        L_0x027d:
            if (r13 == 0) goto L_0x0256
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Skip jump into the IFD since its offset is invalid: "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            goto L_0x0279
        L_0x0291:
            r1.f(r13)
            goto L_0x0136
        L_0x0296:
            r13 = r25
            r10 = 2
            int r2 = r29.b()
            int r11 = r0.p
            int r2 = r2 + r11
            int r8 = (int) r7
            byte[] r7 = new byte[r8]
            r1.readFully(r7)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r8 = new androidx.exifinterface.media.ExifInterface$ExifAttribute
            long r9 = (long) r2
            r16 = r8
            r17 = r15
            r18 = r12
            r19 = r9
            r21 = r7
            r16.<init>(r17, r18, r19, r21)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.f7811f
            r2 = r2[r30]
            java.lang.String r7 = r6.f7826b
            r2.put(r7, r8)
            java.lang.String r2 = "DNGVersion"
            java.lang.String r7 = r6.f7826b
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x02cd
            r2 = 3
            r0.f7809d = r2
            goto L_0x02ce
        L_0x02cd:
            r2 = 3
        L_0x02ce:
            java.lang.String r7 = "Make"
            java.lang.String r9 = r6.f7826b
            boolean r7 = r7.equals(r9)
            if (r7 != 0) goto L_0x02e2
            java.lang.String r7 = "Model"
            java.lang.String r9 = r6.f7826b
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x02f0
        L_0x02e2:
            java.nio.ByteOrder r7 = r0.f7813h
            java.lang.String r7 = r8.q(r7)
            java.lang.String r9 = "PENTAX"
            boolean r7 = r7.contains(r9)
            if (r7 != 0) goto L_0x0303
        L_0x02f0:
            java.lang.String r6 = r6.f7826b
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0305
            java.nio.ByteOrder r5 = r0.f7813h
            int r5 = r8.p(r5)
            r6 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r6) goto L_0x0305
        L_0x0303:
            r0.f7809d = r3
        L_0x0305:
            int r3 = r29.b()
            long r5 = (long) r3
            int r3 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r3 == 0) goto L_0x0137
            r1.f(r13)
            goto L_0x0137
        L_0x0313:
            int r10 = r23 + 1
            short r10 = (short) r10
            r2 = r30
            r11 = r4
            r9 = r24
            r5 = 5
            r7 = 0
            goto L_0x0035
        L_0x031f:
            r4 = r11
            r3 = 1
            int r2 = r29.readInt()
            boolean r5 = w
            if (r5 == 0) goto L_0x033b
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r7 = 0
            r3[r7] = r6
            java.lang.String r6 = "nextIfdOffset: %d"
            java.lang.String r3 = java.lang.String.format(r6, r3)
            android.util.Log.d(r4, r3)
        L_0x033b:
            long r6 = (long) r2
            r8 = 0
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x0383
            java.util.Set<java.lang.Integer> r3 = r0.f7812g
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)
            boolean r3 = r3.contains(r8)
            if (r3 != 0) goto L_0x036c
            r1.f(r6)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.f7811f
            r3 = 4
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0360
        L_0x035c:
            r0.k0(r1, r3)
            goto L_0x038d
        L_0x0360:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.f7811f
            r3 = 5
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x038d
            goto L_0x035c
        L_0x036c:
            if (r5 == 0) goto L_0x038d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since re-reading an IFD may cause an infinite loop: "
        L_0x0375:
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r4, r1)
            goto L_0x038d
        L_0x0383:
            if (r5 == 0) goto L_0x038d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since a wrong offset may cause an infinite loop: "
            goto L_0x0375
        L_0x038d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.k0(androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream, int):void");
    }

    private void l0(String str) {
        for (int i8 = 0; i8 < d7.length; i8++) {
            this.f7811f[i8].remove(str);
        }
    }

    private void m0(int i8, String str, String str2) {
        if (!this.f7811f[i8].isEmpty() && this.f7811f[i8].get(str) != null) {
            HashMap<String, ExifAttribute> hashMap = this.f7811f[i8];
            hashMap.put(str2, hashMap.get(str));
            this.f7811f[i8].remove(str);
        }
    }

    private void o0(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i8) throws IOException {
        ExifAttribute exifAttribute = this.f7811f[i8].get(y);
        ExifAttribute exifAttribute2 = this.f7811f[i8].get(x);
        if (exifAttribute == null || exifAttribute2 == null) {
            ExifAttribute exifAttribute3 = this.f7811f[i8].get(N);
            ExifAttribute exifAttribute4 = this.f7811f[i8].get(O);
            if (exifAttribute3 != null && exifAttribute4 != null) {
                int p8 = exifAttribute3.p(this.f7813h);
                int p9 = exifAttribute3.p(this.f7813h);
                seekableByteOrderedDataInputStream.f((long) p8);
                byte[] bArr = new byte[p9];
                seekableByteOrderedDataInputStream.read(bArr);
                t(new ByteOrderedDataInputStream(bArr), p8, i8);
            }
        }
    }

    @Nullable
    private ExifAttribute q(@NonNull String str) {
        if (str != null) {
            if (y0.equals(str)) {
                if (w) {
                    Log.d(v, "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str = z0;
            }
            for (int i8 = 0; i8 < d7.length; i8++) {
                ExifAttribute exifAttribute = this.f7811f[i8].get(str);
                if (exifAttribute != null) {
                    return exifAttribute;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    private void r0(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (w) {
            Log.d(v, "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, ByteOrder.BIG_ENDIAN);
        if (byteOrderedDataInputStream.readByte() == -1) {
            byteOrderedDataOutputStream.c(-1);
            if (byteOrderedDataInputStream.readByte() == -40) {
                byteOrderedDataOutputStream.c(-40);
                ExifAttribute remove = (i(t2) == null || !this.u) ? null : this.f7811f[0].remove(t2);
                byteOrderedDataOutputStream.c(-1);
                byteOrderedDataOutputStream.c(-31);
                E0(byteOrderedDataOutputStream);
                if (remove != null) {
                    this.f7811f[0].put(t2, remove);
                }
                byte[] bArr = new byte[4096];
                while (byteOrderedDataInputStream.readByte() == -1) {
                    byte readByte = byteOrderedDataInputStream.readByte();
                    if (readByte == -39 || readByte == -38) {
                        byteOrderedDataOutputStream.c(-1);
                        byteOrderedDataOutputStream.c(readByte);
                        ExifInterfaceUtils.e(byteOrderedDataInputStream, byteOrderedDataOutputStream);
                        return;
                    } else if (readByte != -31) {
                        byteOrderedDataOutputStream.c(-1);
                        byteOrderedDataOutputStream.c(readByte);
                        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                        byteOrderedDataOutputStream.h(readUnsignedShort);
                        int i8 = readUnsignedShort - 2;
                        if (i8 >= 0) {
                            while (i8 > 0) {
                                int read = byteOrderedDataInputStream.read(bArr, 0, Math.min(i8, 4096));
                                if (read < 0) {
                                    break;
                                }
                                byteOrderedDataOutputStream.write(bArr, 0, read);
                                i8 -= read;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    } else {
                        int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
                        int i9 = readUnsignedShort2 - 2;
                        if (i9 >= 0) {
                            byte[] bArr2 = new byte[6];
                            if (i9 >= 6) {
                                if (byteOrderedDataInputStream.read(bArr2) != 6) {
                                    throw new IOException("Invalid exif");
                                } else if (Arrays.equals(bArr2, k7)) {
                                    byteOrderedDataInputStream.e(readUnsignedShort2 - 8);
                                }
                            }
                            byteOrderedDataOutputStream.c(-1);
                            byteOrderedDataOutputStream.c(readByte);
                            byteOrderedDataOutputStream.h(readUnsignedShort2);
                            if (i9 >= 6) {
                                i9 = readUnsignedShort2 - 8;
                                byteOrderedDataOutputStream.write(bArr2);
                            }
                            while (i9 > 0) {
                                int read2 = byteOrderedDataInputStream.read(bArr, 0, Math.min(i9, 4096));
                                if (read2 < 0) {
                                    break;
                                }
                                byteOrderedDataOutputStream.write(bArr, 0, read2);
                                i9 -= read2;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:55|56|57) */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0142, code lost:
        throw new java.lang.UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0143, code lost:
        r1.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0146, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0046, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x013b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void s(final androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream r13) throws java.io.IOException {
        /*
            r12 = this;
            java.lang.String r0 = "yes"
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L_0x0147
            android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever
            r1.<init>()
            androidx.exifinterface.media.ExifInterface$1 r2 = new androidx.exifinterface.media.ExifInterface$1     // Catch:{ RuntimeException -> 0x013b }
            r2.<init>(r13)     // Catch:{ RuntimeException -> 0x013b }
            androidx.exifinterface.media.ExifInterfaceUtils.Api23Impl.a(r1, r2)     // Catch:{ RuntimeException -> 0x013b }
            r2 = 33
            java.lang.String r2 = r1.extractMetadata(r2)     // Catch:{ RuntimeException -> 0x013b }
            r3 = 34
            java.lang.String r3 = r1.extractMetadata(r3)     // Catch:{ RuntimeException -> 0x013b }
            r4 = 26
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x013b }
            r5 = 17
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x013b }
            boolean r4 = r0.equals(r4)     // Catch:{ RuntimeException -> 0x013b }
            if (r4 == 0) goto L_0x0049
            r0 = 29
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x013b }
            r4 = 30
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x013b }
            r5 = 31
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x013b }
            goto L_0x0065
        L_0x0046:
            r13 = move-exception
            goto L_0x0143
        L_0x0049:
            boolean r0 = r0.equals(r5)     // Catch:{ RuntimeException -> 0x013b }
            if (r0 == 0) goto L_0x0062
            r0 = 18
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x013b }
            r4 = 19
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x013b }
            r5 = 24
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x013b }
            goto L_0x0065
        L_0x0062:
            r0 = 0
            r4 = r0
            r5 = r4
        L_0x0065:
            r6 = 0
            if (r0 == 0) goto L_0x007b
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r7 = r12.f7811f     // Catch:{ RuntimeException -> 0x013b }
            r7 = r7[r6]     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r8 = "ImageWidth"
            int r9 = java.lang.Integer.parseInt(r0)     // Catch:{ RuntimeException -> 0x013b }
            java.nio.ByteOrder r10 = r12.f7813h     // Catch:{ RuntimeException -> 0x013b }
            androidx.exifinterface.media.ExifInterface$ExifAttribute r9 = androidx.exifinterface.media.ExifInterface.ExifAttribute.m(r9, r10)     // Catch:{ RuntimeException -> 0x013b }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x013b }
        L_0x007b:
            if (r4 == 0) goto L_0x0090
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r7 = r12.f7811f     // Catch:{ RuntimeException -> 0x013b }
            r7 = r7[r6]     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r8 = "ImageLength"
            int r9 = java.lang.Integer.parseInt(r4)     // Catch:{ RuntimeException -> 0x013b }
            java.nio.ByteOrder r10 = r12.f7813h     // Catch:{ RuntimeException -> 0x013b }
            androidx.exifinterface.media.ExifInterface$ExifAttribute r9 = androidx.exifinterface.media.ExifInterface.ExifAttribute.m(r9, r10)     // Catch:{ RuntimeException -> 0x013b }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x013b }
        L_0x0090:
            r7 = 6
            if (r5 == 0) goto L_0x00ba
            int r8 = java.lang.Integer.parseInt(r5)     // Catch:{ RuntimeException -> 0x013b }
            r9 = 90
            if (r8 == r9) goto L_0x00aa
            r9 = 180(0xb4, float:2.52E-43)
            if (r8 == r9) goto L_0x00a8
            r9 = 270(0x10e, float:3.78E-43)
            if (r8 == r9) goto L_0x00a5
            r8 = 1
            goto L_0x00ab
        L_0x00a5:
            r8 = 8
            goto L_0x00ab
        L_0x00a8:
            r8 = 3
            goto L_0x00ab
        L_0x00aa:
            r8 = 6
        L_0x00ab:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r9 = r12.f7811f     // Catch:{ RuntimeException -> 0x013b }
            r9 = r9[r6]     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r10 = "Orientation"
            java.nio.ByteOrder r11 = r12.f7813h     // Catch:{ RuntimeException -> 0x013b }
            androidx.exifinterface.media.ExifInterface$ExifAttribute r8 = androidx.exifinterface.media.ExifInterface.ExifAttribute.m(r8, r11)     // Catch:{ RuntimeException -> 0x013b }
            r9.put(r10, r8)     // Catch:{ RuntimeException -> 0x013b }
        L_0x00ba:
            if (r2 == 0) goto L_0x010d
            if (r3 == 0) goto L_0x010d
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ RuntimeException -> 0x013b }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ RuntimeException -> 0x013b }
            if (r3 <= r7) goto L_0x0105
            long r8 = (long) r2     // Catch:{ RuntimeException -> 0x013b }
            r13.f(r8)     // Catch:{ RuntimeException -> 0x013b }
            byte[] r8 = new byte[r7]     // Catch:{ RuntimeException -> 0x013b }
            int r9 = r13.read(r8)     // Catch:{ RuntimeException -> 0x013b }
            if (r9 != r7) goto L_0x00fd
            int r2 = r2 + r7
            int r3 = r3 + -6
            byte[] r7 = k7     // Catch:{ RuntimeException -> 0x013b }
            boolean r7 = java.util.Arrays.equals(r8, r7)     // Catch:{ RuntimeException -> 0x013b }
            if (r7 == 0) goto L_0x00f5
            byte[] r7 = new byte[r3]     // Catch:{ RuntimeException -> 0x013b }
            int r13 = r13.read(r7)     // Catch:{ RuntimeException -> 0x013b }
            if (r13 != r3) goto L_0x00ed
            r12.p = r2     // Catch:{ RuntimeException -> 0x013b }
            r12.j0(r7, r6)     // Catch:{ RuntimeException -> 0x013b }
            goto L_0x010d
        L_0x00ed:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r0 = "Can't read exif"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013b }
            throw r13     // Catch:{ RuntimeException -> 0x013b }
        L_0x00f5:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r0 = "Invalid identifier"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013b }
            throw r13     // Catch:{ RuntimeException -> 0x013b }
        L_0x00fd:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r0 = "Can't read identifier"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013b }
            throw r13     // Catch:{ RuntimeException -> 0x013b }
        L_0x0105:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r0 = "Invalid exif length"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013b }
            throw r13     // Catch:{ RuntimeException -> 0x013b }
        L_0x010d:
            boolean r13 = w     // Catch:{ RuntimeException -> 0x013b }
            if (r13 == 0) goto L_0x0137
            java.lang.String r13 = "ExifInterface"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x013b }
            r2.<init>()     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r3 = "Heif meta: "
            r2.append(r3)     // Catch:{ RuntimeException -> 0x013b }
            r2.append(r0)     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r0 = "x"
            r2.append(r0)     // Catch:{ RuntimeException -> 0x013b }
            r2.append(r4)     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r0 = ", rotation "
            r2.append(r0)     // Catch:{ RuntimeException -> 0x013b }
            r2.append(r5)     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r0 = r2.toString()     // Catch:{ RuntimeException -> 0x013b }
            android.util.Log.d(r13, r0)     // Catch:{ RuntimeException -> 0x013b }
        L_0x0137:
            r1.release()
            return
        L_0x013b:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x0046 }
            java.lang.String r0 = "Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported."
            r13.<init>(r0)     // Catch:{ all -> 0x0046 }
            throw r13     // Catch:{ all -> 0x0046 }
        L_0x0143:
            r1.release()
            throw r13
        L_0x0147:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException
            java.lang.String r0 = "Reading EXIF from HEIF files is supported from SDK 28 and above"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.s(androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream):void");
    }

    private void s0(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (w) {
            Log.d(v, "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, byteOrder);
        byte[] bArr = S5;
        ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr.length);
        int i8 = this.p;
        if (i8 == 0) {
            int readInt = byteOrderedDataInputStream.readInt();
            byteOrderedDataOutputStream.d(readInt);
            ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream, readInt + 8);
        } else {
            ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream, (i8 - bArr.length) - 8);
            byteOrderedDataInputStream.e(byteOrderedDataInputStream.readInt() + 8);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new ByteOrderedDataOutputStream(byteArrayOutputStream2, byteOrder);
                E0(byteOrderedDataOutputStream2);
                byte[] byteArray = ((ByteArrayOutputStream) byteOrderedDataOutputStream2.s).toByteArray();
                byteOrderedDataOutputStream.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                byteOrderedDataOutputStream.d((int) crc32.getValue());
                ExifInterfaceUtils.c(byteArrayOutputStream2);
                ExifInterfaceUtils.e(byteOrderedDataInputStream, byteOrderedDataOutputStream);
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                ExifInterfaceUtils.c(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            ExifInterfaceUtils.c(byteArrayOutputStream);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x017b A[LOOP:0: B:8:0x0037->B:60:0x017b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0182 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void t(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r22, int r23, int r24) throws java.io.IOException {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r24
            boolean r3 = w
            java.lang.String r4 = "ExifInterface"
            if (r3 == 0) goto L_0x0020
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "getJpegAttributes starting with: "
            r3.append(r5)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r4, r3)
        L_0x0020:
            java.nio.ByteOrder r3 = java.nio.ByteOrder.BIG_ENDIAN
            r1.d(r3)
            byte r3 = r22.readByte()
            java.lang.String r5 = "Invalid marker: "
            r6 = -1
            if (r3 != r6) goto L_0x01cf
            byte r7 = r22.readByte()
            r8 = -40
            if (r7 != r8) goto L_0x01b4
            r3 = 2
        L_0x0037:
            byte r5 = r22.readByte()
            if (r5 != r6) goto L_0x0197
            byte r5 = r22.readByte()
            boolean r7 = w
            if (r7 == 0) goto L_0x005f
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Found JPEG segment indicator: "
            r8.append(r9)
            r9 = r5 & 255(0xff, float:3.57E-43)
            java.lang.String r9 = java.lang.Integer.toHexString(r9)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.util.Log.d(r4, r8)
        L_0x005f:
            r8 = -39
            if (r5 == r8) goto L_0x0191
            r8 = -38
            if (r5 != r8) goto L_0x0069
            goto L_0x0191
        L_0x0069:
            int r8 = r22.readUnsignedShort()
            int r9 = r8 + -2
            r10 = 4
            int r3 = r3 + r10
            if (r7 == 0) goto L_0x009a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r11 = "JPEG segment: "
            r7.append(r11)
            r11 = r5 & 255(0xff, float:3.57E-43)
            java.lang.String r11 = java.lang.Integer.toHexString(r11)
            r7.append(r11)
            java.lang.String r11 = " (length: "
            r7.append(r11)
            r7.append(r8)
            java.lang.String r11 = ")"
            r7.append(r11)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r4, r7)
        L_0x009a:
            java.lang.String r7 = "Invalid length"
            if (r9 < 0) goto L_0x018a
            r11 = -31
            r12 = 1
            r13 = 0
            if (r5 == r11) goto L_0x011d
            r11 = -2
            if (r5 == r11) goto L_0x00ef
            switch(r5) {
                case -64: goto L_0x00b7;
                case -63: goto L_0x00b7;
                case -62: goto L_0x00b7;
                case -61: goto L_0x00b7;
                default: goto L_0x00aa;
            }
        L_0x00aa:
            switch(r5) {
                case -59: goto L_0x00b7;
                case -58: goto L_0x00b7;
                case -57: goto L_0x00b7;
                default: goto L_0x00ad;
            }
        L_0x00ad:
            switch(r5) {
                case -55: goto L_0x00b7;
                case -54: goto L_0x00b7;
                case -53: goto L_0x00b7;
                default: goto L_0x00b0;
            }
        L_0x00b0:
            switch(r5) {
                case -51: goto L_0x00b7;
                case -50: goto L_0x00b7;
                case -49: goto L_0x00b7;
                default: goto L_0x00b3;
            }
        L_0x00b3:
            r20 = r7
            goto L_0x0179
        L_0x00b7:
            r1.e(r12)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r5 = r0.f7811f
            r5 = r5[r2]
            if (r2 == r10) goto L_0x00c3
            java.lang.String r9 = "ImageLength"
            goto L_0x00c5
        L_0x00c3:
            java.lang.String r9 = "ThumbnailImageLength"
        L_0x00c5:
            int r11 = r22.readUnsignedShort()
            long r11 = (long) r11
            java.nio.ByteOrder r13 = r0.f7813h
            androidx.exifinterface.media.ExifInterface$ExifAttribute r11 = androidx.exifinterface.media.ExifInterface.ExifAttribute.i(r11, r13)
            r5.put(r9, r11)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r5 = r0.f7811f
            r5 = r5[r2]
            if (r2 == r10) goto L_0x00dc
            java.lang.String r9 = "ImageWidth"
            goto L_0x00de
        L_0x00dc:
            java.lang.String r9 = "ThumbnailImageWidth"
        L_0x00de:
            int r10 = r22.readUnsignedShort()
            long r10 = (long) r10
            java.nio.ByteOrder r12 = r0.f7813h
            androidx.exifinterface.media.ExifInterface$ExifAttribute r10 = androidx.exifinterface.media.ExifInterface.ExifAttribute.i(r10, r12)
            r5.put(r9, r10)
            int r9 = r8 + -7
            goto L_0x00b3
        L_0x00ef:
            byte[] r5 = new byte[r9]
            int r8 = r1.read(r5)
            if (r8 != r9) goto L_0x0115
            java.lang.String r8 = "UserComment"
            java.lang.String r9 = r0.i(r8)
            if (r9 != 0) goto L_0x0111
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r9 = r0.f7811f
            r9 = r9[r12]
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r11 = j7
            r10.<init>(r5, r11)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r5 = androidx.exifinterface.media.ExifInterface.ExifAttribute.h(r10)
            r9.put(r8, r5)
        L_0x0111:
            r20 = r7
        L_0x0113:
            r9 = 0
            goto L_0x0179
        L_0x0115:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid exif"
            r1.<init>(r2)
            throw r1
        L_0x011d:
            byte[] r5 = new byte[r9]
            r1.readFully(r5)
            int r8 = r3 + r9
            byte[] r10 = k7
            boolean r11 = androidx.exifinterface.media.ExifInterfaceUtils.h(r5, r10)
            if (r11 == 0) goto L_0x0145
            int r11 = r10.length
            byte[] r5 = java.util.Arrays.copyOfRange(r5, r11, r9)
            int r3 = r23 + r3
            int r9 = r10.length
            int r3 = r3 + r9
            r0.p = r3
            r0.j0(r5, r2)
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r3 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream
            r3.<init>((byte[]) r5)
            r0.z0(r3)
        L_0x0142:
            r20 = r7
            goto L_0x0177
        L_0x0145:
            byte[] r10 = l7
            boolean r11 = androidx.exifinterface.media.ExifInterfaceUtils.h(r5, r10)
            if (r11 == 0) goto L_0x0142
            int r11 = r10.length
            int r3 = r3 + r11
            int r10 = r10.length
            byte[] r5 = java.util.Arrays.copyOfRange(r5, r10, r9)
            java.lang.String r9 = "Xmp"
            java.lang.String r10 = r0.i(r9)
            if (r10 != 0) goto L_0x0142
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r10 = r0.f7811f
            r10 = r10[r13]
            androidx.exifinterface.media.ExifInterface$ExifAttribute r11 = new androidx.exifinterface.media.ExifInterface$ExifAttribute
            int r15 = r5.length
            r20 = r7
            long r6 = (long) r3
            r3 = 1
            r14 = r11
            r16 = r15
            r15 = r3
            r17 = r6
            r19 = r5
            r14.<init>(r15, r16, r17, r19)
            r10.put(r9, r11)
            r0.u = r12
        L_0x0177:
            r3 = r8
            goto L_0x0113
        L_0x0179:
            if (r9 < 0) goto L_0x0182
            r1.e(r9)
            int r3 = r3 + r9
            r6 = -1
            goto L_0x0037
        L_0x0182:
            java.io.IOException r1 = new java.io.IOException
            r2 = r20
            r1.<init>(r2)
            throw r1
        L_0x018a:
            r2 = r7
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r2)
            throw r1
        L_0x0191:
            java.nio.ByteOrder r2 = r0.f7813h
            r1.d(r2)
            return
        L_0x0197:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid marker:"
            r2.append(r3)
            r3 = r5 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01b4:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01cf:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.t(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int, int):void");
    }

    private void t0(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i8;
        int i9;
        int i10;
        InputStream inputStream2 = inputStream;
        OutputStream outputStream2 = outputStream;
        if (w) {
            Log.d(v, "saveWebpAttributes starting with (inputStream: " + inputStream2 + ", outputStream: " + outputStream2 + ")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream2, byteOrder);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream2, byteOrder);
        byte[] bArr = Y5;
        ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr.length);
        byte[] bArr2 = Z5;
        byteOrderedDataInputStream.e(bArr2.length + 4);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new ByteOrderedDataOutputStream(byteArrayOutputStream2, byteOrder);
                int i11 = this.p;
                if (i11 != 0) {
                    ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream2, (i11 - ((bArr.length + 4) + bArr2.length)) - 8);
                    byteOrderedDataInputStream.e(4);
                    int readInt = byteOrderedDataInputStream.readInt();
                    if (readInt % 2 != 0) {
                        readInt++;
                    }
                    byteOrderedDataInputStream.e(readInt);
                } else {
                    byte[] bArr3 = new byte[4];
                    if (byteOrderedDataInputStream.read(bArr3) == 4) {
                        byte[] bArr4 = e6;
                        boolean z8 = false;
                        boolean z9 = true;
                        if (Arrays.equals(bArr3, bArr4)) {
                            int readInt2 = byteOrderedDataInputStream.readInt();
                            byte[] bArr5 = new byte[(readInt2 % 2 == 1 ? readInt2 + 1 : readInt2)];
                            byteOrderedDataInputStream.read(bArr5);
                            byte b8 = (byte) (8 | bArr5[0]);
                            bArr5[0] = b8;
                            if (((b8 >> 1) & 1) == 1) {
                                z8 = true;
                            }
                            byteOrderedDataOutputStream2.write(bArr4);
                            byteOrderedDataOutputStream2.d(readInt2);
                            byteOrderedDataOutputStream2.write(bArr5);
                            if (z8) {
                                d(byteOrderedDataInputStream, byteOrderedDataOutputStream2, h6, (byte[]) null);
                                while (true) {
                                    byte[] bArr6 = new byte[4];
                                    inputStream2.read(bArr6);
                                    if (!Arrays.equals(bArr6, i6)) {
                                        break;
                                    }
                                    e(byteOrderedDataInputStream, byteOrderedDataOutputStream2, bArr6);
                                }
                            } else {
                                d(byteOrderedDataInputStream, byteOrderedDataOutputStream2, g6, f6);
                            }
                        } else {
                            byte[] bArr7 = g6;
                            if (Arrays.equals(bArr3, bArr7) || Arrays.equals(bArr3, f6)) {
                                int readInt3 = byteOrderedDataInputStream.readInt();
                                int i12 = readInt3 % 2 == 1 ? readInt3 + 1 : readInt3;
                                byte[] bArr8 = new byte[3];
                                if (Arrays.equals(bArr3, bArr7)) {
                                    byteOrderedDataInputStream.read(bArr8);
                                    byte[] bArr9 = new byte[3];
                                    if (byteOrderedDataInputStream.read(bArr9) != 3 || !Arrays.equals(c6, bArr9)) {
                                        throw new IOException("Encountered error while checking VP8 signature");
                                    }
                                    i10 = byteOrderedDataInputStream.readInt();
                                    i12 -= 10;
                                    i8 = (i10 << 2) >> 18;
                                    i9 = (i10 << 18) >> 18;
                                    z9 = false;
                                } else if (!Arrays.equals(bArr3, f6)) {
                                    i10 = 0;
                                    z9 = false;
                                    i9 = 0;
                                    i8 = 0;
                                } else if (byteOrderedDataInputStream.readByte() == 47) {
                                    i10 = byteOrderedDataInputStream.readInt();
                                    i9 = (i10 & 16383) + 1;
                                    i8 = ((i10 & 268419072) >>> 14) + 1;
                                    if ((i10 & 268435456) == 0) {
                                        z9 = false;
                                    }
                                    i12 -= 5;
                                } else {
                                    throw new IOException("Encountered error while checking VP8L signature");
                                }
                                byteOrderedDataOutputStream2.write(bArr4);
                                byteOrderedDataOutputStream2.d(10);
                                byte[] bArr10 = new byte[10];
                                if (z9) {
                                    bArr10[0] = (byte) (bArr10[0] | 16);
                                }
                                bArr10[0] = (byte) (bArr10[0] | 8);
                                int i13 = i9 - 1;
                                int i14 = i8 - 1;
                                bArr10[4] = (byte) i13;
                                bArr10[5] = (byte) (i13 >> 8);
                                bArr10[6] = (byte) (i13 >> 16);
                                bArr10[7] = (byte) i14;
                                bArr10[8] = (byte) (i14 >> 8);
                                bArr10[9] = (byte) (i14 >> 16);
                                byteOrderedDataOutputStream2.write(bArr10);
                                byteOrderedDataOutputStream2.write(bArr3);
                                byteOrderedDataOutputStream2.d(readInt3);
                                if (Arrays.equals(bArr3, bArr7)) {
                                    byteOrderedDataOutputStream2.write(bArr8);
                                    byteOrderedDataOutputStream2.write(c6);
                                } else {
                                    if (Arrays.equals(bArr3, f6)) {
                                        byteOrderedDataOutputStream2.write(47);
                                    }
                                    ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream2, i12);
                                }
                                byteOrderedDataOutputStream2.d(i10);
                                ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream2, i12);
                            }
                            ExifInterfaceUtils.e(byteOrderedDataInputStream, byteOrderedDataOutputStream2);
                            int size = byteArrayOutputStream2.size();
                            byte[] bArr11 = Z5;
                            byteOrderedDataOutputStream.d(size + bArr11.length);
                            byteOrderedDataOutputStream.write(bArr11);
                            byteArrayOutputStream2.writeTo(byteOrderedDataOutputStream);
                            ExifInterfaceUtils.c(byteArrayOutputStream2);
                        }
                    } else {
                        throw new IOException("Encountered invalid length while parsing WebP chunk type");
                    }
                }
                E0(byteOrderedDataOutputStream2);
                ExifInterfaceUtils.e(byteOrderedDataInputStream, byteOrderedDataOutputStream2);
                int size2 = byteArrayOutputStream2.size();
                byte[] bArr112 = Z5;
                byteOrderedDataOutputStream.d(size2 + bArr112.length);
                byteOrderedDataOutputStream.write(bArr112);
                byteArrayOutputStream2.writeTo(byteOrderedDataOutputStream);
                ExifInterfaceUtils.c(byteArrayOutputStream2);
            } catch (Exception e8) {
                e = e8;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    throw new IOException("Failed to save WebP file", e);
                } catch (Throwable th) {
                    th = th;
                    ExifInterfaceUtils.c(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                ExifInterfaceUtils.c(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            throw new IOException("Failed to save WebP file", e);
        }
    }

    private int w(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (S(bArr)) {
            return 4;
        }
        if (V(bArr)) {
            return 9;
        }
        if (R(bArr)) {
            return 12;
        }
        if (T(bArr)) {
            return 7;
        }
        if (W(bArr)) {
            return 10;
        }
        if (U(bArr)) {
            return 13;
        }
        return d0(bArr) ? 14 : 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void x(androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream r6) throws java.io.IOException {
        /*
            r5 = this;
            r5.A(r6)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r6 = r5.f7811f
            r0 = 1
            r6 = r6[r0]
            java.lang.String r1 = "MakerNote"
            java.lang.Object r6 = r6.get(r1)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r6 = (androidx.exifinterface.media.ExifInterface.ExifAttribute) r6
            if (r6 == 0) goto L_0x00ed
            androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream r1 = new androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream
            byte[] r6 = r6.f7824d
            r1.<init>((byte[]) r6)
            java.nio.ByteOrder r6 = r5.f7813h
            r1.d(r6)
            byte[] r6 = L5
            int r2 = r6.length
            byte[] r2 = new byte[r2]
            r1.readFully(r2)
            r3 = 0
            r1.f(r3)
            byte[] r3 = M5
            int r4 = r3.length
            byte[] r4 = new byte[r4]
            r1.readFully(r4)
            boolean r6 = java.util.Arrays.equals(r2, r6)
            if (r6 == 0) goto L_0x003f
            r2 = 8
        L_0x003b:
            r1.f(r2)
            goto L_0x0048
        L_0x003f:
            boolean r6 = java.util.Arrays.equals(r4, r3)
            if (r6 == 0) goto L_0x0048
            r2 = 12
            goto L_0x003b
        L_0x0048:
            r6 = 6
            r5.k0(r1, r6)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r6 = r5.f7811f
            r1 = 7
            r6 = r6[r1]
            java.lang.String r2 = "PreviewImageStart"
            java.lang.Object r6 = r6.get(r2)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r6 = (androidx.exifinterface.media.ExifInterface.ExifAttribute) r6
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r5.f7811f
            r1 = r2[r1]
            java.lang.String r2 = "PreviewImageLength"
            java.lang.Object r1 = r1.get(r2)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r1 = (androidx.exifinterface.media.ExifInterface.ExifAttribute) r1
            if (r6 == 0) goto L_0x007c
            if (r1 == 0) goto L_0x007c
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r5.f7811f
            r3 = 5
            r2 = r2[r3]
            java.lang.String r4 = "JPEGInterchangeFormat"
            r2.put(r4, r6)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r6 = r5.f7811f
            r6 = r6[r3]
            java.lang.String r2 = "JPEGInterchangeFormatLength"
            r6.put(r2, r1)
        L_0x007c:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r6 = r5.f7811f
            r1 = 8
            r6 = r6[r1]
            java.lang.String r1 = "AspectFrame"
            java.lang.Object r6 = r6.get(r1)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r6 = (androidx.exifinterface.media.ExifInterface.ExifAttribute) r6
            if (r6 == 0) goto L_0x00ed
            java.nio.ByteOrder r1 = r5.f7813h
            java.lang.Object r6 = r6.r(r1)
            int[] r6 = (int[]) r6
            if (r6 == 0) goto L_0x00d3
            int r1 = r6.length
            r2 = 4
            if (r1 == r2) goto L_0x009b
            goto L_0x00d3
        L_0x009b:
            r1 = 2
            r1 = r6[r1]
            r2 = 0
            r3 = r6[r2]
            if (r1 <= r3) goto L_0x00ed
            r4 = 3
            r4 = r6[r4]
            r6 = r6[r0]
            if (r4 <= r6) goto L_0x00ed
            int r1 = r1 - r3
            int r1 = r1 + r0
            int r4 = r4 - r6
            int r4 = r4 + r0
            if (r1 >= r4) goto L_0x00b4
            int r1 = r1 + r4
            int r4 = r1 - r4
            int r1 = r1 - r4
        L_0x00b4:
            java.nio.ByteOrder r6 = r5.f7813h
            androidx.exifinterface.media.ExifInterface$ExifAttribute r6 = androidx.exifinterface.media.ExifInterface.ExifAttribute.m(r1, r6)
            java.nio.ByteOrder r0 = r5.f7813h
            androidx.exifinterface.media.ExifInterface$ExifAttribute r0 = androidx.exifinterface.media.ExifInterface.ExifAttribute.m(r4, r0)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r1 = r5.f7811f
            r1 = r1[r2]
            java.lang.String r3 = "ImageWidth"
            r1.put(r3, r6)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r6 = r5.f7811f
            r6 = r6[r2]
            java.lang.String r1 = "ImageLength"
            r6.put(r1, r0)
            goto L_0x00ed
        L_0x00d3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid aspect frame values. frame="
            r0.append(r1)
            java.lang.String r6 = java.util.Arrays.toString(r6)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r0 = "ExifInterface"
            android.util.Log.w(r0, r6)
        L_0x00ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.x(androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream):void");
    }

    private void y(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (w) {
            Log.d(v, "getPngAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.d(ByteOrder.BIG_ENDIAN);
        byte[] bArr = S5;
        byteOrderedDataInputStream.e(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int readInt = byteOrderedDataInputStream.readInt();
                byte[] bArr2 = new byte[4];
                if (byteOrderedDataInputStream.read(bArr2) == 4) {
                    int i8 = length + 8;
                    if (i8 == 16) {
                        if (!Arrays.equals(bArr2, U5)) {
                            throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                        }
                    }
                    if (!Arrays.equals(bArr2, V5)) {
                        if (Arrays.equals(bArr2, T5)) {
                            byte[] bArr3 = new byte[readInt];
                            if (byteOrderedDataInputStream.read(bArr3) == readInt) {
                                int readInt2 = byteOrderedDataInputStream.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr2);
                                crc32.update(bArr3);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.p = i8;
                                    j0(bArr3, 0);
                                    D0();
                                    z0(new ByteOrderedDataInputStream(bArr3));
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + ExifInterfaceUtils.a(bArr2));
                        }
                        int i9 = readInt + 4;
                        byteOrderedDataInputStream.e(i9);
                        length = i8 + i9;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void z(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        boolean z8 = w;
        if (z8) {
            Log.d(v, "getRafAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.e(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        byteOrderedDataInputStream.read(bArr);
        byteOrderedDataInputStream.read(bArr2);
        byteOrderedDataInputStream.read(bArr3);
        int i8 = ByteBuffer.wrap(bArr).getInt();
        int i9 = ByteBuffer.wrap(bArr2).getInt();
        int i10 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i9];
        byteOrderedDataInputStream.e(i8 - byteOrderedDataInputStream.b());
        byteOrderedDataInputStream.read(bArr4);
        t(new ByteOrderedDataInputStream(bArr4), i8, 5);
        byteOrderedDataInputStream.e(i10 - byteOrderedDataInputStream.b());
        byteOrderedDataInputStream.d(ByteOrder.BIG_ENDIAN);
        int readInt = byteOrderedDataInputStream.readInt();
        if (z8) {
            Log.d(v, "numberOfDirectoryEntry: " + readInt);
        }
        for (int i11 = 0; i11 < readInt; i11++) {
            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (readUnsignedShort == O6.f7825a) {
                short readShort = byteOrderedDataInputStream.readShort();
                short readShort2 = byteOrderedDataInputStream.readShort();
                ExifAttribute m8 = ExifAttribute.m(readShort, this.f7813h);
                ExifAttribute m9 = ExifAttribute.m(readShort2, this.f7813h);
                this.f7811f[0].put(y, m8);
                this.f7811f[0].put(x, m9);
                if (w) {
                    Log.d(v, "Updated to length: " + readShort + ", width: " + readShort2);
                    return;
                }
                return;
            }
            byteOrderedDataInputStream.e(readUnsignedShort2);
        }
    }

    private void z0(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        HashMap<String, ExifAttribute> hashMap = this.f7811f[4];
        ExifAttribute exifAttribute = hashMap.get(A);
        if (exifAttribute != null) {
            int p8 = exifAttribute.p(this.f7813h);
            this.o = p8;
            if (p8 != 1) {
                if (p8 != 6) {
                    if (p8 != 7) {
                        return;
                    }
                }
            }
            if (Y(hashMap)) {
                L(byteOrderedDataInputStream, hashMap);
                return;
            }
            return;
        }
        this.o = 6;
        K(byteOrderedDataInputStream, hashMap);
    }

    public int B() {
        switch (l(C, 1)) {
            case 3:
            case 4:
                return BuildConfig.f29478d;
            case 5:
            case 8:
                return TIFFConstants.e0;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    @Nullable
    public byte[] E() {
        int i8 = this.o;
        if (i8 == 6 || i8 == 7) {
            return G();
        }
        return null;
    }

    @Nullable
    public Bitmap F() {
        if (!this.f7814i) {
            return null;
        }
        if (this.f7819n == null) {
            this.f7819n = G();
        }
        int i8 = this.o;
        if (i8 == 6 || i8 == 7) {
            return BitmapFactory.decodeByteArray(this.f7819n, 0, this.f7818m);
        }
        if (i8 == 1) {
            int length = this.f7819n.length / 3;
            int[] iArr = new int[length];
            for (int i9 = 0; i9 < length; i9++) {
                byte[] bArr = this.f7819n;
                int i10 = i9 * 3;
                iArr[i9] = (bArr[i10] << 16) + (bArr[i10 + 1] << 8) + bArr[i10 + 2];
            }
            ExifAttribute exifAttribute = this.f7811f[4].get(e2);
            ExifAttribute exifAttribute2 = this.f7811f[4].get(f2);
            if (!(exifAttribute == null || exifAttribute2 == null)) {
                return Bitmap.createBitmap(iArr, exifAttribute2.p(this.f7813h), exifAttribute.p(this.f7813h), Bitmap.Config.ARGB_8888);
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x006f A[SYNTHETIC, Splitter:B:38:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0090 A[Catch:{ Exception -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b0  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] G() {
        /*
            r11 = this;
            java.lang.String r0 = "ExifInterface"
            boolean r1 = r11.f7814i
            r2 = 0
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            byte[] r1 = r11.f7819n
            if (r1 == 0) goto L_0x000d
            return r1
        L_0x000d:
            android.content.res.AssetManager$AssetInputStream r1 = r11.f7808c     // Catch:{ Exception -> 0x003f, all -> 0x003b }
            if (r1 == 0) goto L_0x002f
            boolean r3 = r1.markSupported()     // Catch:{ Exception -> 0x0021, all -> 0x001c }
            if (r3 == 0) goto L_0x0026
            r1.reset()     // Catch:{ Exception -> 0x0021, all -> 0x001c }
        L_0x001a:
            r3 = r2
            goto L_0x0059
        L_0x001c:
            r0 = move-exception
            r3 = r2
        L_0x001e:
            r2 = r1
            goto L_0x00ab
        L_0x0021:
            r3 = move-exception
            r4 = r3
            r3 = r2
            goto L_0x009d
        L_0x0026:
            java.lang.String r3 = "Cannot read thumbnail from inputstream without mark/reset support"
            android.util.Log.d(r0, r3)     // Catch:{ Exception -> 0x0021, all -> 0x001c }
            androidx.exifinterface.media.ExifInterfaceUtils.c(r1)
            return r2
        L_0x002f:
            java.lang.String r1 = r11.f7806a     // Catch:{ Exception -> 0x003f, all -> 0x003b }
            if (r1 == 0) goto L_0x0044
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003f, all -> 0x003b }
            java.lang.String r3 = r11.f7806a     // Catch:{ Exception -> 0x003f, all -> 0x003b }
            r1.<init>(r3)     // Catch:{ Exception -> 0x003f, all -> 0x003b }
            goto L_0x001a
        L_0x003b:
            r0 = move-exception
            r3 = r2
            goto L_0x00ab
        L_0x003f:
            r3 = move-exception
            r1 = r2
            r4 = r3
            r3 = r1
            goto L_0x009d
        L_0x0044:
            java.io.FileDescriptor r1 = r11.f7807b     // Catch:{ Exception -> 0x003f, all -> 0x003b }
            java.io.FileDescriptor r1 = androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.b(r1)     // Catch:{ Exception -> 0x003f, all -> 0x003b }
            int r3 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0099, all -> 0x0096 }
            r4 = 0
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.c(r1, r4, r3)     // Catch:{ Exception -> 0x0099, all -> 0x0096 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0099, all -> 0x0096 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0099, all -> 0x0096 }
            r10 = r3
            r3 = r1
            r1 = r10
        L_0x0059:
            int r4 = r11.f7817l     // Catch:{ Exception -> 0x0088 }
            int r5 = r11.p     // Catch:{ Exception -> 0x0088 }
            int r4 = r4 + r5
            long r4 = (long) r4     // Catch:{ Exception -> 0x0088 }
            long r4 = r1.skip(r4)     // Catch:{ Exception -> 0x0088 }
            int r6 = r11.f7817l     // Catch:{ Exception -> 0x0088 }
            int r7 = r11.p     // Catch:{ Exception -> 0x0088 }
            int r6 = r6 + r7
            long r6 = (long) r6
            java.lang.String r8 = "Corrupted image"
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 != 0) goto L_0x0090
            int r4 = r11.f7818m     // Catch:{ Exception -> 0x0088 }
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0088 }
            int r5 = r1.read(r4)     // Catch:{ Exception -> 0x0088 }
            int r6 = r11.f7818m     // Catch:{ Exception -> 0x0088 }
            if (r5 != r6) goto L_0x008a
            r11.f7819n = r4     // Catch:{ Exception -> 0x0088 }
            androidx.exifinterface.media.ExifInterfaceUtils.c(r1)
            if (r3 == 0) goto L_0x0085
            androidx.exifinterface.media.ExifInterfaceUtils.b(r3)
        L_0x0085:
            return r4
        L_0x0086:
            r0 = move-exception
            goto L_0x001e
        L_0x0088:
            r4 = move-exception
            goto L_0x009d
        L_0x008a:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ Exception -> 0x0088 }
            r4.<init>(r8)     // Catch:{ Exception -> 0x0088 }
            throw r4     // Catch:{ Exception -> 0x0088 }
        L_0x0090:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ Exception -> 0x0088 }
            r4.<init>(r8)     // Catch:{ Exception -> 0x0088 }
            throw r4     // Catch:{ Exception -> 0x0088 }
        L_0x0096:
            r0 = move-exception
            r3 = r1
            goto L_0x00ab
        L_0x0099:
            r3 = move-exception
            r4 = r3
            r3 = r1
            r1 = r2
        L_0x009d:
            java.lang.String r5 = "Encountered exception while getting thumbnail"
            android.util.Log.d(r0, r5, r4)     // Catch:{ all -> 0x0086 }
            androidx.exifinterface.media.ExifInterfaceUtils.c(r1)
            if (r3 == 0) goto L_0x00aa
            androidx.exifinterface.media.ExifInterfaceUtils.b(r3)
        L_0x00aa:
            return r2
        L_0x00ab:
            androidx.exifinterface.media.ExifInterfaceUtils.c(r2)
            if (r3 == 0) goto L_0x00b3
            androidx.exifinterface.media.ExifInterfaceUtils.b(r3)
        L_0x00b3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.G():byte[]");
    }

    @Nullable
    public long[] H() {
        if (this.t) {
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        } else if (!this.f7814i) {
            return null;
        } else {
            if (this.f7815j && !this.f7816k) {
                return null;
            }
            return new long[]{(long) (this.f7817l + this.p), (long) this.f7818m};
        }
    }

    public boolean M(@NonNull String str) {
        return q(str) != null;
    }

    public boolean N() {
        return this.f7814i;
    }

    public boolean Q() {
        int l8 = l(C, 1);
        return l8 == 2 || l8 == 7 || l8 == 4 || l8 == 5;
    }

    public boolean c0() {
        if (!this.f7814i) {
            return false;
        }
        int i8 = this.o;
        return i8 == 6 || i8 == 7;
    }

    public void f() {
        int i8 = 1;
        switch (l(C, 1)) {
            case 1:
                i8 = 2;
                break;
            case 2:
                break;
            case 3:
                i8 = 4;
                break;
            case 4:
                i8 = 3;
                break;
            case 5:
                i8 = 6;
                break;
            case 6:
                i8 = 5;
                break;
            case 7:
                i8 = 8;
                break;
            case 8:
                i8 = 7;
                break;
            default:
                i8 = 0;
                break;
        }
        v0(C, Integer.toString(i8));
    }

    public void g() {
        int i8 = 1;
        switch (l(C, 1)) {
            case 1:
                i8 = 4;
                break;
            case 2:
                i8 = 3;
                break;
            case 3:
                i8 = 2;
                break;
            case 4:
                break;
            case 5:
                i8 = 8;
                break;
            case 6:
                i8 = 7;
                break;
            case 7:
                i8 = 6;
                break;
            case 8:
                i8 = 5;
                break;
            default:
                i8 = 0;
                break;
        }
        v0(C, Integer.toString(i8));
    }

    public double h(double d8) {
        double k8 = k(D1, -1.0d);
        int i8 = -1;
        int l8 = l(C1, -1);
        if (k8 < 0.0d || l8 < 0) {
            return d8;
        }
        if (l8 != 1) {
            i8 = 1;
        }
        return k8 * ((double) i8);
    }

    @Nullable
    public String i(@NonNull String str) {
        String str2;
        if (str != null) {
            ExifAttribute q8 = q(str);
            if (q8 != null) {
                if (!h7.contains(str)) {
                    return q8.q(this.f7813h);
                }
                if (str.equals(E1)) {
                    int i8 = q8.f7821a;
                    if (i8 == 5 || i8 == 10) {
                        Rational[] rationalArr = (Rational[]) q8.r(this.f7813h);
                        if (rationalArr == null || rationalArr.length != 3) {
                            str2 = "Invalid GPS Timestamp array. array=" + Arrays.toString(rationalArr);
                        } else {
                            Rational rational = rationalArr[0];
                            Integer valueOf = Integer.valueOf((int) (((float) rational.f7829a) / ((float) rational.f7830b)));
                            Rational rational2 = rationalArr[1];
                            Integer valueOf2 = Integer.valueOf((int) (((float) rational2.f7829a) / ((float) rational2.f7830b)));
                            Rational rational3 = rationalArr[2];
                            return String.format("%02d:%02d:%02d", new Object[]{valueOf, valueOf2, Integer.valueOf((int) (((float) rational3.f7829a) / ((float) rational3.f7830b)))});
                        }
                    } else {
                        str2 = "GPS Timestamp format is not rational. format=" + q8.f7821a;
                    }
                    Log.w(v, str2);
                    return null;
                }
                try {
                    return Double.toString(q8.o(this.f7813h));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    @Nullable
    public byte[] j(@NonNull String str) {
        if (str != null) {
            ExifAttribute q8 = q(str);
            if (q8 != null) {
                return q8.f7824d;
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public double k(@NonNull String str, double d8) {
        if (str != null) {
            ExifAttribute q8 = q(str);
            if (q8 == null) {
                return d8;
            }
            try {
                return q8.o(this.f7813h);
            } catch (NumberFormatException unused) {
                return d8;
            }
        } else {
            throw new NullPointerException("tag shouldn't be null");
        }
    }

    public int l(@NonNull String str, int i8) {
        if (str != null) {
            ExifAttribute q8 = q(str);
            if (q8 == null) {
                return i8;
            }
            try {
                return q8.p(this.f7813h);
            } catch (NumberFormatException unused) {
                return i8;
            }
        } else {
            throw new NullPointerException("tag shouldn't be null");
        }
    }

    @Nullable
    public long[] m(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        } else if (!this.t) {
            ExifAttribute q8 = q(str);
            if (q8 == null) {
                return null;
            }
            return new long[]{q8.f7823c, (long) q8.f7824d.length};
        } else {
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long n() {
        return f0(i(U), i(r0), i(o0));
    }

    public void n0() {
        v0(C, Integer.toString(1));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long o() {
        return f0(i(n0), i(t0), i(q0));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long p() {
        return f0(i(m0), i(s0), i(p0));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004c, code lost:
        if (r0 < 0) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0025, code lost:
        if (r0 < 0) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void p0(int r7) {
        /*
            r6 = this;
            int r0 = r7 % 90
            if (r0 != 0) goto L_0x0057
            r0 = 1
            java.lang.String r1 = "Orientation"
            int r0 = r6.l(r1, r0)
            java.util.List<java.lang.Integer> r2 = M2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            boolean r3 = r2.contains(r3)
            r4 = 0
            r5 = 4
            if (r3 == 0) goto L_0x0034
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r0 = r2.indexOf(r0)
            int r7 = r7 / 90
            int r0 = r0 + r7
            int r0 = r0 % r5
            if (r0 >= 0) goto L_0x0028
        L_0x0027:
            r4 = 4
        L_0x0028:
            int r0 = r0 + r4
            java.lang.Object r7 = r2.get(r0)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r4 = r7.intValue()
            goto L_0x004f
        L_0x0034:
            java.util.List<java.lang.Integer> r2 = N2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            boolean r3 = r2.contains(r3)
            if (r3 == 0) goto L_0x004f
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r0 = r2.indexOf(r0)
            int r7 = r7 / 90
            int r0 = r0 + r7
            int r0 = r0 % r5
            if (r0 >= 0) goto L_0x0028
            goto L_0x0027
        L_0x004f:
            java.lang.String r7 = java.lang.Integer.toString(r4)
            r6.v0(r1, r7)
            return
        L_0x0057:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "degree should be a multiple of 90"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.p0(int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r6v8, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0152, code lost:
        r2.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0084, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0085, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0088, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0089, code lost:
        r8 = null;
        r9 = null;
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00de, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00df, code lost:
        r9 = null;
        r1 = r6;
        r6 = r8;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00f1, code lost:
        androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.c(r13.f7807b, 0, android.system.OsConstants.SEEK_SET);
        r1 = new java.io.FileOutputStream(r13.f7807b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0106, code lost:
        r1 = new java.io.FileOutputStream(r13.f7806a);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0084 A[Catch:{ Exception -> 0x0088, all -> 0x0084 }, ExcHandler: all (th java.lang.Throwable), Splitter:B:31:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f1 A[Catch:{ Exception -> 0x0104, all -> 0x0101 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0106 A[Catch:{ Exception -> 0x0104, all -> 0x0101 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q0() throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r13.f7809d
            boolean r0 = Z(r0)
            if (r0 == 0) goto L_0x0172
            java.io.FileDescriptor r0 = r13.f7807b
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = r13.f7806a
            if (r0 == 0) goto L_0x0011
            goto L_0x0019
        L_0x0011:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface does not support saving attributes for the current input."
            r0.<init>(r1)
            throw r0
        L_0x0019:
            boolean r0 = r13.f7814i
            if (r0 == 0) goto L_0x002e
            boolean r0 = r13.f7815j
            if (r0 == 0) goto L_0x002e
            boolean r0 = r13.f7816k
            if (r0 == 0) goto L_0x0026
            goto L_0x002e
        L_0x0026:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface does not support saving attributes when the image file has non-consecutive thumbnail strips"
            r0.<init>(r1)
            throw r0
        L_0x002e:
            r0 = 1
            r13.t = r0
            byte[] r1 = r13.E()
            r13.f7819n = r1
            r1 = 0
            java.lang.String r2 = "temp"
            java.lang.String r3 = "tmp"
            java.io.File r2 = java.io.File.createTempFile(r2, r3)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            java.lang.String r3 = r13.f7806a     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            r4 = 0
            if (r3 == 0) goto L_0x0056
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            java.lang.String r6 = r13.f7806a     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            goto L_0x0064
        L_0x004e:
            r0 = move-exception
            r6 = r1
            goto L_0x016b
        L_0x0052:
            r0 = move-exception
            r6 = r1
            goto L_0x0162
        L_0x0056:
            java.io.FileDescriptor r3 = r13.f7807b     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            int r6 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.c(r3, r4, r6)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            java.io.FileDescriptor r6 = r13.f7807b     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
        L_0x0064:
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            r6.<init>(r2)     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            androidx.exifinterface.media.ExifInterfaceUtils.e(r3, r6)     // Catch:{ Exception -> 0x0159, all -> 0x0156 }
            androidx.exifinterface.media.ExifInterfaceUtils.c(r3)
            androidx.exifinterface.media.ExifInterfaceUtils.c(r6)
            r3 = 0
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00e4, all -> 0x0084 }
            r6.<init>(r2)     // Catch:{ Exception -> 0x00e4, all -> 0x0084 }
            java.lang.String r7 = r13.f7806a     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            if (r7 == 0) goto L_0x0090
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            java.lang.String r8 = r13.f7806a     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            goto L_0x009e
        L_0x0084:
            r0 = move-exception
            r9 = r1
            goto L_0x014a
        L_0x0088:
            r7 = move-exception
            r8 = r1
            r9 = r8
            r1 = r6
        L_0x008c:
            r6 = r7
            r7 = r9
            goto L_0x00e8
        L_0x0090:
            java.io.FileDescriptor r7 = r13.f7807b     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            int r8 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.c(r7, r4, r8)     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            java.io.FileDescriptor r8 = r13.f7807b     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
        L_0x009e:
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00de, all -> 0x0084 }
            r8.<init>(r6)     // Catch:{ Exception -> 0x00de, all -> 0x0084 }
            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00d8, all -> 0x00d5 }
            r9.<init>(r7)     // Catch:{ Exception -> 0x00d8, all -> 0x00d5 }
            int r10 = r13.f7809d     // Catch:{ Exception -> 0x00b5 }
            r11 = 4
            if (r10 != r11) goto L_0x00ba
            r13.r0(r8, r9)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x00c9
        L_0x00b1:
            r0 = move-exception
        L_0x00b2:
            r1 = r8
            goto L_0x014a
        L_0x00b5:
            r1 = move-exception
            r12 = r6
            r6 = r1
            r1 = r12
            goto L_0x00e8
        L_0x00ba:
            r11 = 13
            if (r10 != r11) goto L_0x00c2
            r13.s0(r8, r9)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x00c9
        L_0x00c2:
            r11 = 14
            if (r10 != r11) goto L_0x00c9
            r13.t0(r8, r9)     // Catch:{ Exception -> 0x00b5 }
        L_0x00c9:
            androidx.exifinterface.media.ExifInterfaceUtils.c(r8)
            androidx.exifinterface.media.ExifInterfaceUtils.c(r9)
            r2.delete()
            r13.f7819n = r1
            return
        L_0x00d5:
            r0 = move-exception
            r9 = r1
            goto L_0x00b2
        L_0x00d8:
            r9 = move-exception
            r12 = r9
            r9 = r1
            r1 = r6
            r6 = r12
            goto L_0x00e8
        L_0x00de:
            r8 = move-exception
            r9 = r1
            r1 = r6
            r6 = r8
            r8 = r9
            goto L_0x00e8
        L_0x00e4:
            r7 = move-exception
            r8 = r1
            r9 = r8
            goto L_0x008c
        L_0x00e8:
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0121, all -> 0x011f }
            r10.<init>(r2)     // Catch:{ Exception -> 0x0121, all -> 0x011f }
            java.lang.String r1 = r13.f7806a     // Catch:{ Exception -> 0x0104, all -> 0x0101 }
            if (r1 != 0) goto L_0x0106
            java.io.FileDescriptor r1 = r13.f7807b     // Catch:{ Exception -> 0x0104, all -> 0x0101 }
            int r11 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0104, all -> 0x0101 }
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.c(r1, r4, r11)     // Catch:{ Exception -> 0x0104, all -> 0x0101 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0104, all -> 0x0101 }
            java.io.FileDescriptor r4 = r13.f7807b     // Catch:{ Exception -> 0x0104, all -> 0x0101 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0104, all -> 0x0101 }
        L_0x00ff:
            r7 = r1
            goto L_0x010e
        L_0x0101:
            r0 = move-exception
            r1 = r10
            goto L_0x0143
        L_0x0104:
            r1 = move-exception
            goto L_0x0124
        L_0x0106:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0104, all -> 0x0101 }
            java.lang.String r4 = r13.f7806a     // Catch:{ Exception -> 0x0104, all -> 0x0101 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0104, all -> 0x0101 }
            goto L_0x00ff
        L_0x010e:
            androidx.exifinterface.media.ExifInterfaceUtils.e(r10, r7)     // Catch:{ Exception -> 0x0104, all -> 0x0101 }
            androidx.exifinterface.media.ExifInterfaceUtils.c(r10)     // Catch:{ all -> 0x00b1 }
            androidx.exifinterface.media.ExifInterfaceUtils.c(r7)     // Catch:{ all -> 0x00b1 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00b1 }
            java.lang.String r1 = "Failed to save new file"
            r0.<init>(r1, r6)     // Catch:{ all -> 0x00b1 }
            throw r0     // Catch:{ all -> 0x00b1 }
        L_0x011f:
            r0 = move-exception
            goto L_0x0143
        L_0x0121:
            r3 = move-exception
            r10 = r1
            r1 = r3
        L_0x0124:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x013f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x013f }
            r4.<init>()     // Catch:{ all -> 0x013f }
            java.lang.String r5 = "Failed to save new file. Original file is stored in "
            r4.append(r5)     // Catch:{ all -> 0x013f }
            java.lang.String r5 = r2.getAbsolutePath()     // Catch:{ all -> 0x013f }
            r4.append(r5)     // Catch:{ all -> 0x013f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x013f }
            r3.<init>(r4, r1)     // Catch:{ all -> 0x013f }
            throw r3     // Catch:{ all -> 0x013f }
        L_0x013f:
            r1 = move-exception
            r0 = r1
            r1 = r10
            r3 = 1
        L_0x0143:
            androidx.exifinterface.media.ExifInterfaceUtils.c(r1)     // Catch:{ all -> 0x00b1 }
            androidx.exifinterface.media.ExifInterfaceUtils.c(r7)     // Catch:{ all -> 0x00b1 }
            throw r0     // Catch:{ all -> 0x00b1 }
        L_0x014a:
            androidx.exifinterface.media.ExifInterfaceUtils.c(r1)
            androidx.exifinterface.media.ExifInterfaceUtils.c(r9)
            if (r3 != 0) goto L_0x0155
            r2.delete()
        L_0x0155:
            throw r0
        L_0x0156:
            r0 = move-exception
        L_0x0157:
            r1 = r3
            goto L_0x016b
        L_0x0159:
            r0 = move-exception
        L_0x015a:
            r1 = r3
            goto L_0x0162
        L_0x015c:
            r0 = move-exception
            r6 = r1
            goto L_0x0157
        L_0x015f:
            r0 = move-exception
            r6 = r1
            goto L_0x015a
        L_0x0162:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x016a }
            java.lang.String r3 = "Failed to copy original file to temp file"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x016a }
            throw r2     // Catch:{ all -> 0x016a }
        L_0x016a:
            r0 = move-exception
        L_0x016b:
            androidx.exifinterface.media.ExifInterfaceUtils.c(r1)
            androidx.exifinterface.media.ExifInterfaceUtils.c(r6)
            throw r0
        L_0x0172:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface only supports saving attributes for JPEG, PNG, and WebP formats."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.q0():void");
    }

    @SuppressLint({"AutoBoxing"})
    @Nullable
    public Long r() {
        String i8 = i(a2);
        String i9 = i(E1);
        if (!(i8 == null || i9 == null)) {
            Pattern pattern = U7;
            if (pattern.matcher(i8).matches() || pattern.matcher(i9).matches()) {
                String str = i8 + ' ' + i9;
                ParsePosition parsePosition = new ParsePosition(0);
                try {
                    Date parse = m6.parse(str, parsePosition);
                    if (parse == null && (parse = n6.parse(str, parsePosition)) == null) {
                        return null;
                    }
                    return Long.valueOf(parse.getTime());
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return null;
    }

    @Deprecated
    public boolean u(float[] fArr) {
        double[] v8 = v();
        if (v8 == null) {
            return false;
        }
        fArr[0] = (float) v8[0];
        fArr[1] = (float) v8[1];
        return true;
    }

    public void u0(double d8) {
        String str = d8 >= 0.0d ? "0" : IcyHeaders.a3;
        v0(D1, new Rational(Math.abs(d8)).toString());
        v0(C1, str);
    }

    @Nullable
    public double[] v() {
        String i8 = i(z1);
        String i9 = i(y1);
        String i10 = i(B1);
        String i11 = i(A1);
        if (i8 == null || i9 == null || i10 == null || i11 == null) {
            return null;
        }
        try {
            return new double[]{c(i8, i9), c(i10, i11)};
        } catch (IllegalArgumentException unused) {
            Log.w(v, "Latitude/longitude values are not parsable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", new Object[]{i8, i9, i10, i11}));
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02c6, code lost:
        r3.put(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0269, code lost:
        r3.put(r1, r4);
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02ca  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02ed  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x026e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void v0(@androidx.annotation.NonNull java.lang.String r18, @androidx.annotation.Nullable java.lang.String r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            if (r1 == 0) goto L_0x032c
            java.lang.String r3 = "DateTime"
            boolean r3 = r3.equals(r1)
            java.lang.String r4 = " : "
            java.lang.String r5 = "Invalid value for "
            java.lang.String r6 = "ExifInterface"
            if (r3 != 0) goto L_0x0026
            java.lang.String r3 = "DateTimeOriginal"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0026
            java.lang.String r3 = "DateTimeDigitized"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x006d
        L_0x0026:
            if (r2 == 0) goto L_0x006d
            java.util.regex.Pattern r3 = W7
            java.util.regex.Matcher r3 = r3.matcher(r2)
            boolean r3 = r3.find()
            java.util.regex.Pattern r7 = X7
            java.util.regex.Matcher r7 = r7.matcher(r2)
            boolean r7 = r7.find()
            int r8 = r19.length()
            r9 = 19
            if (r8 != r9) goto L_0x0054
            if (r3 != 0) goto L_0x0049
            if (r7 != 0) goto L_0x0049
            goto L_0x0054
        L_0x0049:
            if (r7 == 0) goto L_0x006d
            java.lang.String r3 = "-"
            java.lang.String r7 = ":"
            java.lang.String r2 = r2.replaceAll(r3, r7)
            goto L_0x006d
        L_0x0054:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x0059:
            r3.append(r5)
            r3.append(r1)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            android.util.Log.w(r6, r1)
            return
        L_0x006d:
            java.lang.String r3 = "ISOSpeedRatings"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0080
            boolean r1 = w
            if (r1 == 0) goto L_0x007e
            java.lang.String r1 = "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY."
            android.util.Log.d(r6, r1)
        L_0x007e:
            java.lang.String r1 = "PhotographicSensitivity"
        L_0x0080:
            r3 = 2
            r7 = 1
            if (r2 == 0) goto L_0x00f4
            java.util.HashSet<java.lang.String> r8 = h7
            boolean r8 = r8.contains(r1)
            if (r8 == 0) goto L_0x00f4
            java.lang.String r8 = "GPSTimeStamp"
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x00df
            java.util.regex.Pattern r8 = V7
            java.util.regex.Matcher r8 = r8.matcher(r2)
            boolean r9 = r8.find()
            if (r9 != 0) goto L_0x00a6
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x0059
        L_0x00a6:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r8.group(r7)
            int r4 = java.lang.Integer.parseInt(r4)
            r2.append(r4)
            java.lang.String r4 = "/1,"
            r2.append(r4)
            java.lang.String r5 = r8.group(r3)
            int r5 = java.lang.Integer.parseInt(r5)
            r2.append(r5)
            r2.append(r4)
            r4 = 3
            java.lang.String r4 = r8.group(r4)
            int r4 = java.lang.Integer.parseInt(r4)
            r2.append(r4)
            java.lang.String r4 = "/1"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            goto L_0x00f4
        L_0x00df:
            double r8 = java.lang.Double.parseDouble(r2)     // Catch:{ NumberFormatException -> 0x00ed }
            androidx.exifinterface.media.ExifInterface$Rational r10 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ NumberFormatException -> 0x00ed }
            r10.<init>(r8)     // Catch:{ NumberFormatException -> 0x00ed }
            java.lang.String r2 = r10.toString()     // Catch:{ NumberFormatException -> 0x00ed }
            goto L_0x00f4
        L_0x00ed:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x0059
        L_0x00f4:
            r4 = 0
            r5 = 0
        L_0x00f6:
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r8 = d7
            int r8 = r8.length
            if (r5 >= r8) goto L_0x032b
            r8 = 4
            if (r5 != r8) goto L_0x0105
            boolean r8 = r0.f7814i
            if (r8 != 0) goto L_0x0105
        L_0x0102:
            r15 = 1
            goto L_0x0324
        L_0x0105:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifTag>[] r8 = g7
            r8 = r8[r5]
            java.lang.Object r8 = r8.get(r1)
            androidx.exifinterface.media.ExifInterface$ExifTag r8 = (androidx.exifinterface.media.ExifInterface.ExifTag) r8
            if (r8 == 0) goto L_0x0102
            if (r2 != 0) goto L_0x011b
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r8 = r0.f7811f
            r8 = r8[r5]
            r8.remove(r1)
            goto L_0x0102
        L_0x011b:
            android.util.Pair r9 = J(r2)
            int r10 = r8.f7827c
            java.lang.Object r11 = r9.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r12 = -1
            if (r10 == r11) goto L_0x01eb
            int r10 = r8.f7827c
            java.lang.Object r11 = r9.second
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r10 != r11) goto L_0x013a
            goto L_0x01eb
        L_0x013a:
            int r10 = r8.f7828d
            if (r10 == r12) goto L_0x0158
            java.lang.Object r11 = r9.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r10 == r11) goto L_0x0154
            int r10 = r8.f7828d
            java.lang.Object r11 = r9.second
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r10 != r11) goto L_0x0158
        L_0x0154:
            int r8 = r8.f7828d
            goto L_0x01ed
        L_0x0158:
            int r10 = r8.f7827c
            if (r10 == r7) goto L_0x01e9
            r11 = 7
            if (r10 == r11) goto L_0x01e9
            if (r10 != r3) goto L_0x0163
            goto L_0x01e9
        L_0x0163:
            boolean r10 = w
            if (r10 == 0) goto L_0x0102
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Given tag ("
            r10.append(r11)
            r10.append(r1)
            java.lang.String r11 = ") value didn't match with one of expected formats: "
            r10.append(r11)
            java.lang.String[] r11 = G6
            int r13 = r8.f7827c
            r13 = r11[r13]
            r10.append(r13)
            int r13 = r8.f7828d
            java.lang.String r14 = ", "
            java.lang.String r15 = ""
            if (r13 != r12) goto L_0x018c
            r8 = r15
            goto L_0x019f
        L_0x018c:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r14)
            int r8 = r8.f7828d
            r8 = r11[r8]
            r13.append(r8)
            java.lang.String r8 = r13.toString()
        L_0x019f:
            r10.append(r8)
            java.lang.String r8 = " (guess: "
            r10.append(r8)
            java.lang.Object r8 = r9.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            r8 = r11[r8]
            r10.append(r8)
            java.lang.Object r8 = r9.second
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r8 != r12) goto L_0x01bf
            goto L_0x01d8
        L_0x01bf:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r14)
            java.lang.Object r9 = r9.second
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            r9 = r11[r9]
            r8.append(r9)
            java.lang.String r15 = r8.toString()
        L_0x01d8:
            r10.append(r15)
            java.lang.String r8 = ")"
            r10.append(r8)
            java.lang.String r8 = r10.toString()
        L_0x01e4:
            android.util.Log.d(r6, r8)
            goto L_0x0102
        L_0x01e9:
            r8 = r10
            goto L_0x01ed
        L_0x01eb:
            int r8 = r8.f7827c
        L_0x01ed:
            java.lang.String r9 = "/"
            java.lang.String r10 = ","
            switch(r8) {
                case 1: goto L_0x031a;
                case 2: goto L_0x0310;
                case 3: goto L_0x02ed;
                case 4: goto L_0x02ca;
                case 5: goto L_0x028f;
                case 6: goto L_0x01f4;
                case 7: goto L_0x0310;
                case 8: goto L_0x01f4;
                case 9: goto L_0x026e;
                case 10: goto L_0x022f;
                case 11: goto L_0x01f4;
                case 12: goto L_0x020a;
                default: goto L_0x01f4;
            }
        L_0x01f4:
            boolean r9 = w
            if (r9 == 0) goto L_0x0102
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Data format isn't one of expected formats: "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            goto L_0x01e4
        L_0x020a:
            java.lang.String[] r8 = r2.split(r10, r12)
            int r9 = r8.length
            double[] r9 = new double[r9]
            r10 = 0
        L_0x0212:
            int r11 = r8.length
            if (r10 >= r11) goto L_0x0220
            r11 = r8[r10]
            double r11 = java.lang.Double.parseDouble(r11)
            r9[r10] = r11
            int r10 = r10 + 1
            goto L_0x0212
        L_0x0220:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r8 = r0.f7811f
            r8 = r8[r5]
            java.nio.ByteOrder r10 = r0.f7813h
            androidx.exifinterface.media.ExifInterface$ExifAttribute r9 = androidx.exifinterface.media.ExifInterface.ExifAttribute.c(r9, r10)
            r8.put(r1, r9)
            goto L_0x0102
        L_0x022f:
            java.lang.String[] r8 = r2.split(r10, r12)
            int r10 = r8.length
            androidx.exifinterface.media.ExifInterface$Rational[] r10 = new androidx.exifinterface.media.ExifInterface.Rational[r10]
            r11 = 0
        L_0x0237:
            int r13 = r8.length
            if (r11 >= r13) goto L_0x025f
            r13 = r8[r11]
            java.lang.String[] r13 = r13.split(r9, r12)
            androidx.exifinterface.media.ExifInterface$Rational r14 = new androidx.exifinterface.media.ExifInterface$Rational
            r15 = r13[r4]
            double r3 = java.lang.Double.parseDouble(r15)
            long r3 = (long) r3
            r13 = r13[r7]
            r16 = r8
            double r7 = java.lang.Double.parseDouble(r13)
            long r7 = (long) r7
            r14.<init>(r3, r7)
            r10[r11] = r14
            int r11 = r11 + 1
            r8 = r16
            r3 = 2
            r4 = 0
            r7 = 1
            goto L_0x0237
        L_0x025f:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.f7811f
            r3 = r3[r5]
            java.nio.ByteOrder r4 = r0.f7813h
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.g(r10, r4)
        L_0x0269:
            r3.put(r1, r4)
            goto L_0x0102
        L_0x026e:
            java.lang.String[] r3 = r2.split(r10, r12)
            int r4 = r3.length
            int[] r4 = new int[r4]
            r7 = 0
        L_0x0276:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x0284
            r8 = r3[r7]
            int r8 = java.lang.Integer.parseInt(r8)
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x0276
        L_0x0284:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.f7811f
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.f7813h
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.e(r4, r7)
            goto L_0x0269
        L_0x028f:
            java.lang.String[] r3 = r2.split(r10, r12)
            int r4 = r3.length
            androidx.exifinterface.media.ExifInterface$Rational[] r4 = new androidx.exifinterface.media.ExifInterface.Rational[r4]
            r7 = 0
        L_0x0297:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x02bb
            r8 = r3[r7]
            java.lang.String[] r8 = r8.split(r9, r12)
            androidx.exifinterface.media.ExifInterface$Rational r10 = new androidx.exifinterface.media.ExifInterface$Rational
            r11 = 0
            r13 = r8[r11]
            double r13 = java.lang.Double.parseDouble(r13)
            long r13 = (long) r13
            r15 = 1
            r8 = r8[r15]
            double r11 = java.lang.Double.parseDouble(r8)
            long r11 = (long) r11
            r10.<init>(r13, r11)
            r4[r7] = r10
            int r7 = r7 + 1
            r12 = -1
            goto L_0x0297
        L_0x02bb:
            r15 = 1
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.f7811f
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.f7813h
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.l(r4, r7)
        L_0x02c6:
            r3.put(r1, r4)
            goto L_0x0324
        L_0x02ca:
            r3 = -1
            r15 = 1
            java.lang.String[] r3 = r2.split(r10, r3)
            int r4 = r3.length
            long[] r4 = new long[r4]
            r7 = 0
        L_0x02d4:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x02e2
            r8 = r3[r7]
            long r8 = java.lang.Long.parseLong(r8)
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x02d4
        L_0x02e2:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.f7811f
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.f7813h
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.j(r4, r7)
            goto L_0x02c6
        L_0x02ed:
            r3 = -1
            r15 = 1
            java.lang.String[] r3 = r2.split(r10, r3)
            int r4 = r3.length
            int[] r4 = new int[r4]
            r7 = 0
        L_0x02f7:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x0305
            r8 = r3[r7]
            int r8 = java.lang.Integer.parseInt(r8)
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x02f7
        L_0x0305:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.f7811f
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.f7813h
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.n(r4, r7)
            goto L_0x02c6
        L_0x0310:
            r15 = 1
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.f7811f
            r3 = r3[r5]
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.h(r2)
            goto L_0x02c6
        L_0x031a:
            r15 = 1
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.f7811f
            r3 = r3[r5]
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.a(r2)
            goto L_0x02c6
        L_0x0324:
            int r5 = r5 + 1
            r3 = 2
            r4 = 0
            r7 = 1
            goto L_0x00f6
        L_0x032b:
            return
        L_0x032c:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "tag shouldn't be null"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.v0(java.lang.String, java.lang.String):void");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void w0(@NonNull Long l8) {
        if (l8 == null) {
            throw new NullPointerException("Timestamp should not be null.");
        } else if (l8.longValue() >= 0) {
            String l9 = Long.toString(l8.longValue() % 1000);
            for (int length = l9.length(); length < 3; length++) {
                l9 = "0" + l9;
            }
            v0(U, m6.format(new Date(l8.longValue())));
            v0(r0, l9);
        } else {
            throw new IllegalArgumentException("Timestamp should a positive value.");
        }
    }

    public void x0(Location location) {
        if (location != null) {
            v0(Y1, location.getProvider());
            y0(location.getLatitude(), location.getLongitude());
            u0(location.getAltitude());
            v0(J1, "K");
            v0(K1, new Rational((double) ((location.getSpeed() * ((float) TimeUnit.HOURS.toSeconds(1))) / 1000.0f)).toString());
            String[] split = m6.format(new Date(location.getTime())).split("\\s+", -1);
            v0(a2, split[0]);
            v0(E1, split[1]);
        }
    }

    public void y0(double d8, double d9) {
        if (d8 < -90.0d || d8 > 90.0d || Double.isNaN(d8)) {
            throw new IllegalArgumentException("Latitude value " + d8 + " is not valid.");
        } else if (d9 < -180.0d || d9 > 180.0d || Double.isNaN(d9)) {
            throw new IllegalArgumentException("Longitude value " + d9 + " is not valid.");
        } else {
            v0(y1, d8 >= 0.0d ? "N" : R4);
            v0(z1, b(Math.abs(d8)));
            v0(A1, d9 >= 0.0d ? S4 : T4);
            v0(B1, b(Math.abs(d9)));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExifInterface(@androidx.annotation.NonNull java.io.FileDescriptor r5) throws java.io.IOException {
        /*
            r4 = this;
            r4.<init>()
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r0 = d7
            int r1 = r0.length
            java.util.HashMap[] r1 = new java.util.HashMap[r1]
            r4.f7811f = r1
            java.util.HashSet r1 = new java.util.HashSet
            int r0 = r0.length
            r1.<init>(r0)
            r4.f7812g = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r4.f7813h = r0
            if (r5 == 0) goto L_0x0057
            r0 = 0
            r4.f7808c = r0
            r4.f7806a = r0
            boolean r1 = X(r5)
            if (r1 == 0) goto L_0x0034
            r4.f7807b = r5
            java.io.FileDescriptor r5 = androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.b(r5)     // Catch:{ Exception -> 0x002b }
            r1 = 1
            goto L_0x0037
        L_0x002b:
            r5 = move-exception
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Failed to duplicate file descriptor"
            r0.<init>(r1, r5)
            throw r0
        L_0x0034:
            r4.f7807b = r0
            r1 = 0
        L_0x0037:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x004a }
            r2.<init>(r5)     // Catch:{ all -> 0x004a }
            r4.e0(r2)     // Catch:{ all -> 0x0048 }
            androidx.exifinterface.media.ExifInterfaceUtils.c(r2)
            if (r1 == 0) goto L_0x0047
            androidx.exifinterface.media.ExifInterfaceUtils.b(r5)
        L_0x0047:
            return
        L_0x0048:
            r0 = move-exception
            goto L_0x004e
        L_0x004a:
            r2 = move-exception
            r3 = r2
            r2 = r0
            r0 = r3
        L_0x004e:
            androidx.exifinterface.media.ExifInterfaceUtils.c(r2)
            if (r1 == 0) goto L_0x0056
            androidx.exifinterface.media.ExifInterfaceUtils.b(r5)
        L_0x0056:
            throw r0
        L_0x0057:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "fileDescriptor cannot be null"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.<init>(java.io.FileDescriptor):void");
    }

    public ExifInterface(@NonNull InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    public ExifInterface(@NonNull InputStream inputStream, int i8) throws IOException {
        ExifTag[][] exifTagArr = d7;
        this.f7811f = new HashMap[exifTagArr.length];
        this.f7812g = new HashSet(exifTagArr.length);
        this.f7813h = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.f7806a = null;
            if (i8 == 1) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, k7.length);
                if (!P(bufferedInputStream)) {
                    Log.w(v, "Given data does not follow the structure of an Exif-only data.");
                    return;
                }
                this.f7810e = true;
                this.f7808c = null;
                this.f7807b = null;
                inputStream = bufferedInputStream;
            } else {
                if (inputStream instanceof AssetManager.AssetInputStream) {
                    this.f7808c = (AssetManager.AssetInputStream) inputStream;
                } else {
                    if (inputStream instanceof FileInputStream) {
                        FileInputStream fileInputStream = (FileInputStream) inputStream;
                        if (X(fileInputStream.getFD())) {
                            this.f7808c = null;
                            this.f7807b = fileInputStream.getFD();
                        }
                    }
                    this.f7808c = null;
                }
                this.f7807b = null;
            }
            e0(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }

    public ExifInterface(@NonNull String str) throws IOException {
        ExifTag[][] exifTagArr = d7;
        this.f7811f = new HashMap[exifTagArr.length];
        this.f7812g = new HashSet(exifTagArr.length);
        this.f7813h = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            O(str);
            return;
        }
        throw new NullPointerException("filename cannot be null");
    }
}
