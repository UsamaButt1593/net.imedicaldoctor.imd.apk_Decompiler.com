package at.grabner.circleprogress;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.Typeface;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.text.DecimalFormat;

public class CircleProgressView extends View {
    private int A3 = 40;
    private int A4;
    private int B3 = TIFFConstants.e0;
    private OnProgressChangedListener B4;
    private float C3 = 1.0f;
    private float C4;
    private float D3 = 1.0f;
    private DecimalFormat D4;
    private int E3 = 0;
    private Typeface E4;
    private BarStartEndLine F3 = BarStartEndLine.NONE;
    private Typeface F4;
    private int G3 = -1442840576;
    private float H3 = 10.0f;
    private int I3 = 10;
    private int J3 = 10;
    private float K3 = 1.0f;
    private float L3 = 1.0f;
    private int M3 = -1442840576;
    private int N3 = -1442840576;
    private int O3 = -16738680;
    private int P3 = 0;
    private int Q3 = -1434201911;
    private int R3 = ViewCompat.y;
    private int S3 = ViewCompat.y;
    private boolean T3 = false;
    private int[] U3 = {-16738680};
    private Paint.Cap V3;
    private Paint.Cap W3;
    protected int X2 = 0;
    private Paint X3;
    protected int Y2 = 0;
    private Paint Y3;
    protected RectF Z2 = new RectF();
    private Paint Z3;
    protected RectF a3 = new RectF();
    private Paint a4;
    protected PointF b3;
    private Paint b4;
    protected RectF c3 = new RectF();
    private Paint c4;
    protected RectF d3 = new RectF();
    private Paint d4;
    protected RectF e3 = new RectF();
    private Paint e4;
    protected RectF f3 = new RectF();
    private Paint f4;
    protected RectF g3 = new RectF();
    private Paint g4;
    Direction h3 = Direction.CW;
    private String h4;
    float i3 = 0.0f;
    private int i4;
    float j3 = 0.0f;
    private String j4;
    float k3 = 0.0f;
    private UnitPosition k4;
    float l3 = 100.0f;
    private TextMode l4;
    float m3 = 0.0f;
    private boolean m4;
    float n3 = -1.0f;
    private boolean n4;
    float o3 = 0.0f;
    private Bitmap o4;
    float p3 = 42.0f;
    private Paint p4;
    float q3 = 0.0f;
    private float q4;
    float r3 = 2.8f;
    private boolean r4;
    private final int s = -16738680;
    boolean s3 = false;
    private boolean s4;
    double t3 = 900.0d;
    private boolean t4;
    int u3 = 10;
    private int u4;
    boolean v3;
    private float v4;
    AnimationHandler w3 = new AnimationHandler(this);
    private float w4;
    AnimationState x3 = AnimationState.IDLE;
    private float x4;
    AnimationStateChangedListener y3;
    private boolean y4;
    private int z3 = 40;
    private boolean z4;

    /* renamed from: at.grabner.circleprogress.CircleProgressView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16619a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f16620b;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0063 */
        static {
            /*
                at.grabner.circleprogress.TextMode[] r0 = at.grabner.circleprogress.TextMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16620b = r0
                r1 = 1
                at.grabner.circleprogress.TextMode r2 = at.grabner.circleprogress.TextMode.TEXT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f16620b     // Catch:{ NoSuchFieldError -> 0x001d }
                at.grabner.circleprogress.TextMode r3 = at.grabner.circleprogress.TextMode.PERCENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f16620b     // Catch:{ NoSuchFieldError -> 0x0028 }
                at.grabner.circleprogress.TextMode r4 = at.grabner.circleprogress.TextMode.VALUE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                at.grabner.circleprogress.UnitPosition[] r3 = at.grabner.circleprogress.UnitPosition.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f16619a = r3
                at.grabner.circleprogress.UnitPosition r4 = at.grabner.circleprogress.UnitPosition.TOP     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f16619a     // Catch:{ NoSuchFieldError -> 0x0043 }
                at.grabner.circleprogress.UnitPosition r3 = at.grabner.circleprogress.UnitPosition.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f16619a     // Catch:{ NoSuchFieldError -> 0x004d }
                at.grabner.circleprogress.UnitPosition r1 = at.grabner.circleprogress.UnitPosition.LEFT_TOP     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = f16619a     // Catch:{ NoSuchFieldError -> 0x0058 }
                at.grabner.circleprogress.UnitPosition r1 = at.grabner.circleprogress.UnitPosition.RIGHT_TOP     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f16619a     // Catch:{ NoSuchFieldError -> 0x0063 }
                at.grabner.circleprogress.UnitPosition r1 = at.grabner.circleprogress.UnitPosition.LEFT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r0 = f16619a     // Catch:{ NoSuchFieldError -> 0x006e }
                at.grabner.circleprogress.UnitPosition r1 = at.grabner.circleprogress.UnitPosition.RIGHT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: at.grabner.circleprogress.CircleProgressView.AnonymousClass1.<clinit>():void");
        }
    }

    public interface OnProgressChangedListener {
        void a(float f2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x02e7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x03ee  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0406 A[SYNTHETIC, Splitter:B:62:0x0406] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0422 A[SYNTHETIC, Splitter:B:67:0x0422] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x043e A[SYNTHETIC, Splitter:B:72:0x043e] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x045f  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0481  */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CircleProgressView(android.content.Context r10, android.util.AttributeSet r11) {
        /*
            r9 = this;
            r9.<init>(r10, r11)
            r0 = -16738680(0xffffffffff009688, float:-1.7092279E38)
            r9.s = r0
            r1 = 0
            r9.X2 = r1
            r9.Y2 = r1
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r9.Z2 = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r9.a3 = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r9.c3 = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r9.d3 = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r9.e3 = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r9.f3 = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r9.g3 = r2
            at.grabner.circleprogress.Direction r2 = at.grabner.circleprogress.Direction.CW
            r9.h3 = r2
            r2 = 0
            r9.i3 = r2
            r9.j3 = r2
            r9.k3 = r2
            r3 = 1120403456(0x42c80000, float:100.0)
            r9.l3 = r3
            r9.m3 = r2
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            r9.n3 = r3
            r9.o3 = r2
            r3 = 1109917696(0x42280000, float:42.0)
            r9.p3 = r3
            r9.q3 = r2
            r3 = 1077097267(0x40333333, float:2.8)
            r9.r3 = r3
            r9.s3 = r1
            r3 = 4651127699538968576(0x408c200000000000, double:900.0)
            r9.t3 = r3
            r3 = 10
            r9.u3 = r3
            at.grabner.circleprogress.AnimationHandler r4 = new at.grabner.circleprogress.AnimationHandler
            r4.<init>(r9)
            r9.w3 = r4
            at.grabner.circleprogress.AnimationState r4 = at.grabner.circleprogress.AnimationState.IDLE
            r9.x3 = r4
            r4 = 40
            r9.z3 = r4
            r9.A3 = r4
            r4 = 270(0x10e, float:3.78E-43)
            r9.B3 = r4
            r4 = 1065353216(0x3f800000, float:1.0)
            r9.C3 = r4
            r9.D3 = r4
            r9.E3 = r1
            at.grabner.circleprogress.BarStartEndLine r5 = at.grabner.circleprogress.BarStartEndLine.NONE
            r9.F3 = r5
            r5 = -1442840576(0xffffffffaa000000, float:-1.1368684E-13)
            r9.G3 = r5
            r6 = 1092616192(0x41200000, float:10.0)
            r9.H3 = r6
            r9.I3 = r3
            r9.J3 = r3
            r9.K3 = r4
            r9.L3 = r4
            r9.M3 = r5
            r9.N3 = r5
            r9.O3 = r0
            r9.P3 = r1
            r3 = -1434201911(0xffffffffaa83d0c9, float:-2.3415148E-13)
            r9.Q3 = r3
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r9.R3 = r3
            r9.S3 = r3
            r9.T3 = r1
            int[] r3 = new int[]{r0}
            r9.U3 = r3
            android.graphics.Paint$Cap r3 = android.graphics.Paint.Cap.BUTT
            r9.V3 = r3
            r9.W3 = r3
            android.graphics.Paint r3 = new android.graphics.Paint
            r3.<init>()
            r9.X3 = r3
            android.graphics.Paint r3 = new android.graphics.Paint
            r3.<init>()
            r9.Z3 = r3
            android.graphics.Paint r3 = new android.graphics.Paint
            r3.<init>()
            r9.a4 = r3
            android.graphics.Paint r3 = new android.graphics.Paint
            r3.<init>()
            r9.b4 = r3
            android.graphics.Paint r3 = new android.graphics.Paint
            r3.<init>()
            r9.c4 = r3
            android.graphics.Paint r3 = new android.graphics.Paint
            r3.<init>()
            r9.d4 = r3
            android.graphics.Paint r3 = new android.graphics.Paint
            r3.<init>()
            r9.e4 = r3
            android.graphics.Paint r3 = new android.graphics.Paint
            r3.<init>()
            r9.f4 = r3
            android.graphics.Paint r3 = new android.graphics.Paint
            r3.<init>()
            r9.g4 = r3
            java.lang.String r3 = ""
            r9.h4 = r3
            r9.j4 = r3
            at.grabner.circleprogress.UnitPosition r3 = at.grabner.circleprogress.UnitPosition.RIGHT_TOP
            r9.k4 = r3
            at.grabner.circleprogress.TextMode r3 = at.grabner.circleprogress.TextMode.PERCENT
            r9.l4 = r3
            r9.n4 = r1
            r9.q4 = r4
            r9.r4 = r1
            r9.s4 = r1
            r9.t4 = r1
            r3 = 18
            r9.u4 = r3
            r5 = 1063675494(0x3f666666, float:0.9)
            r9.v4 = r5
            r6 = 360(0x168, float:5.04E-43)
            int r6 = r6 / r3
            float r3 = (float) r6
            r9.w4 = r3
            float r3 = r3 * r5
            r9.x4 = r3
            r9.y4 = r1
            r9.z4 = r1
            java.text.DecimalFormat r3 = new java.text.DecimalFormat
            java.lang.String r6 = "0"
            r3.<init>(r6)
            r9.D4 = r3
            int[] r3 = at.grabner.circleprogress.R.styleable.f16649a
            android.content.res.TypedArray r10 = r10.obtainStyledAttributes(r11, r3)
            int r11 = at.grabner.circleprogress.R.styleable.f16661m
            int r3 = r9.z3
            float r3 = (float) r3
            float r11 = r10.getDimension(r11, r3)
            int r11 = (int) r11
            r9.setBarWidth(r11)
            int r11 = at.grabner.circleprogress.R.styleable.A
            int r3 = r9.A3
            float r3 = (float) r3
            float r11 = r10.getDimension(r11, r3)
            int r11 = (int) r11
            r9.setRimWidth(r11)
            int r11 = at.grabner.circleprogress.R.styleable.J
            float r3 = r9.r3
            float r11 = r10.getFloat(r11, r3)
            int r11 = (int) r11
            float r11 = (float) r11
            r9.setSpinSpeed(r11)
            int r11 = at.grabner.circleprogress.R.styleable.G
            boolean r3 = r9.s3
            boolean r11 = r10.getBoolean(r11, r3)
            r9.setSpin(r11)
            at.grabner.circleprogress.Direction[] r11 = at.grabner.circleprogress.Direction.values()
            int r3 = at.grabner.circleprogress.R.styleable.q
            int r3 = r10.getInt(r3, r1)
            r11 = r11[r3]
            r9.setDirection(r11)
            int r11 = at.grabner.circleprogress.R.styleable.Y
            float r3 = r9.i3
            float r11 = r10.getFloat(r11, r3)
            r9.setValue(r11)
            r9.i3 = r11
            int r11 = at.grabner.circleprogress.R.styleable.f16652d
            boolean r3 = r10.hasValue(r11)
            if (r3 == 0) goto L_0x01c1
            int r3 = at.grabner.circleprogress.R.styleable.f16653e
            boolean r6 = r10.hasValue(r3)
            if (r6 == 0) goto L_0x01c1
            int r6 = at.grabner.circleprogress.R.styleable.f16654f
            boolean r7 = r10.hasValue(r6)
            if (r7 == 0) goto L_0x01c1
            int r7 = at.grabner.circleprogress.R.styleable.f16655g
            boolean r8 = r10.hasValue(r7)
            if (r8 == 0) goto L_0x01c1
            int r11 = r10.getColor(r11, r0)
            int r3 = r10.getColor(r3, r0)
            int r6 = r10.getColor(r6, r0)
            int r0 = r10.getColor(r7, r0)
            int[] r11 = new int[]{r11, r3, r6, r0}
            r9.U3 = r11
            goto L_0x0215
        L_0x01c1:
            boolean r3 = r10.hasValue(r11)
            if (r3 == 0) goto L_0x01ea
            int r3 = at.grabner.circleprogress.R.styleable.f16653e
            boolean r6 = r10.hasValue(r3)
            if (r6 == 0) goto L_0x01ea
            int r6 = at.grabner.circleprogress.R.styleable.f16654f
            boolean r7 = r10.hasValue(r6)
            if (r7 == 0) goto L_0x01ea
            int r11 = r10.getColor(r11, r0)
            int r3 = r10.getColor(r3, r0)
            int r0 = r10.getColor(r6, r0)
            int[] r11 = new int[]{r11, r3, r0}
            r9.U3 = r11
            goto L_0x0215
        L_0x01ea:
            boolean r3 = r10.hasValue(r11)
            if (r3 == 0) goto L_0x0207
            int r3 = at.grabner.circleprogress.R.styleable.f16653e
            boolean r6 = r10.hasValue(r3)
            if (r6 == 0) goto L_0x0207
            int r11 = r10.getColor(r11, r0)
            int r0 = r10.getColor(r3, r0)
            int[] r11 = new int[]{r11, r0}
            r9.U3 = r11
            goto L_0x0215
        L_0x0207:
            int r3 = r10.getColor(r11, r0)
            int r11 = r10.getColor(r11, r0)
            int[] r11 = new int[]{r3, r11}
            r9.U3 = r11
        L_0x0215:
            int r11 = at.grabner.circleprogress.R.styleable.f16660l
            boolean r0 = r10.hasValue(r11)
            if (r0 == 0) goto L_0x022c
            at.grabner.circleprogress.StrokeCap[] r0 = at.grabner.circleprogress.StrokeCap.values()
            int r11 = r10.getInt(r11, r1)
            r11 = r0[r11]
            android.graphics.Paint$Cap r11 = r11.s
            r9.setBarStrokeCap(r11)
        L_0x022c:
            int r11 = at.grabner.circleprogress.R.styleable.f16659k
            boolean r0 = r10.hasValue(r11)
            r3 = 3
            if (r0 == 0) goto L_0x025f
            int r0 = at.grabner.circleprogress.R.styleable.f16656h
            boolean r6 = r10.hasValue(r0)
            if (r6 == 0) goto L_0x025f
            float r11 = r10.getDimension(r11, r2)
            int r11 = (int) r11
            at.grabner.circleprogress.BarStartEndLine[] r2 = at.grabner.circleprogress.BarStartEndLine.values()
            int r0 = r10.getInt(r0, r3)
            r0 = r2[r0]
            int r2 = at.grabner.circleprogress.R.styleable.f16657i
            int r6 = r9.G3
            int r2 = r10.getColor(r2, r6)
            int r6 = at.grabner.circleprogress.R.styleable.f16658j
            float r7 = r9.H3
            float r6 = r10.getFloat(r6, r7)
            r9.p(r11, r0, r2, r6)
        L_0x025f:
            int r11 = at.grabner.circleprogress.R.styleable.I
            int r0 = r9.O3
            int r11 = r10.getColor(r11, r0)
            r9.setSpinBarColor(r11)
            int r11 = at.grabner.circleprogress.R.styleable.H
            float r0 = r9.p3
            float r11 = r10.getFloat(r11, r0)
            r9.setSpinningBarLength(r11)
            int r11 = at.grabner.circleprogress.R.styleable.P
            boolean r0 = r10.hasValue(r11)
            if (r0 == 0) goto L_0x0288
            int r0 = r9.J3
            float r0 = (float) r0
            float r11 = r10.getDimension(r11, r0)
            int r11 = (int) r11
            r9.setTextSize(r11)
        L_0x0288:
            int r11 = at.grabner.circleprogress.R.styleable.V
            boolean r0 = r10.hasValue(r11)
            if (r0 == 0) goto L_0x029b
            int r0 = r9.I3
            float r0 = (float) r0
            float r11 = r10.getDimension(r11, r0)
            int r11 = (int) r11
            r9.setUnitSize(r11)
        L_0x029b:
            int r11 = at.grabner.circleprogress.R.styleable.M
            boolean r0 = r10.hasValue(r11)
            if (r0 == 0) goto L_0x02ac
            int r0 = r9.R3
            int r11 = r10.getColor(r11, r0)
            r9.setTextColor(r11)
        L_0x02ac:
            int r11 = at.grabner.circleprogress.R.styleable.S
            boolean r0 = r10.hasValue(r11)
            if (r0 == 0) goto L_0x02bd
            int r0 = r9.S3
            int r11 = r10.getColor(r11, r0)
            r9.setUnitColor(r11)
        L_0x02bd:
            int r11 = at.grabner.circleprogress.R.styleable.f16650b
            boolean r0 = r10.hasValue(r11)
            if (r0 == 0) goto L_0x02ce
            boolean r0 = r9.T3
            boolean r11 = r10.getBoolean(r11, r0)
            r9.setTextColorAuto(r11)
        L_0x02ce:
            int r11 = at.grabner.circleprogress.R.styleable.f16651c
            boolean r0 = r10.hasValue(r11)
            if (r0 == 0) goto L_0x02df
            boolean r0 = r9.m4
            boolean r11 = r10.getBoolean(r11, r0)
            r9.setAutoTextSize(r11)
        L_0x02df:
            int r11 = at.grabner.circleprogress.R.styleable.N
            boolean r0 = r10.hasValue(r11)
            if (r0 == 0) goto L_0x02f4
            at.grabner.circleprogress.TextMode[] r0 = at.grabner.circleprogress.TextMode.values()
            int r11 = r10.getInt(r11, r1)
            r11 = r0[r11]
            r9.setTextMode(r11)
        L_0x02f4:
            int r11 = at.grabner.circleprogress.R.styleable.T
            boolean r0 = r10.hasValue(r11)
            if (r0 == 0) goto L_0x0309
            at.grabner.circleprogress.UnitPosition[] r0 = at.grabner.circleprogress.UnitPosition.values()
            int r11 = r10.getInt(r11, r3)
            r11 = r0[r11]
            r9.setUnitPosition(r11)
        L_0x0309:
            int r11 = at.grabner.circleprogress.R.styleable.L
            boolean r0 = r10.hasValue(r11)
            if (r0 == 0) goto L_0x0318
            java.lang.String r11 = r10.getString(r11)
            r9.setText(r11)
        L_0x0318:
            int r11 = at.grabner.circleprogress.R.styleable.W
            float r11 = r10.getFloat(r11, r4)
            r9.setUnitToTextScale(r11)
            int r11 = at.grabner.circleprogress.R.styleable.z
            int r0 = r9.Q3
            int r11 = r10.getColor(r11, r0)
            r9.setRimColor(r11)
            int r11 = at.grabner.circleprogress.R.styleable.r
            int r0 = r9.P3
            int r11 = r10.getColor(r11, r0)
            r9.setFillCircleColor(r11)
            int r11 = at.grabner.circleprogress.R.styleable.x
            int r0 = r9.M3
            int r11 = r10.getColor(r11, r0)
            r9.setOuterContourColor(r11)
            int r11 = at.grabner.circleprogress.R.styleable.y
            float r0 = r9.C3
            float r11 = r10.getDimension(r11, r0)
            r9.setOuterContourSize(r11)
            int r11 = at.grabner.circleprogress.R.styleable.s
            int r0 = r9.N3
            int r11 = r10.getColor(r11, r0)
            r9.setInnerContourColor(r11)
            int r11 = at.grabner.circleprogress.R.styleable.t
            float r0 = r9.D3
            float r11 = r10.getDimension(r11, r0)
            r9.setInnerContourSize(r11)
            int r11 = at.grabner.circleprogress.R.styleable.u
            float r0 = r9.l3
            float r11 = r10.getFloat(r11, r0)
            r9.setMaxValue(r11)
            int r11 = at.grabner.circleprogress.R.styleable.w
            float r0 = r9.m3
            float r11 = r10.getFloat(r11, r0)
            r9.setMinValueAllowed(r11)
            int r11 = at.grabner.circleprogress.R.styleable.v
            float r0 = r9.n3
            float r11 = r10.getFloat(r11, r0)
            r9.setMaxValueAllowed(r11)
            int r11 = at.grabner.circleprogress.R.styleable.B
            boolean r0 = r9.y4
            boolean r11 = r10.getBoolean(r11, r0)
            r9.setRoundToBlock(r11)
            int r11 = at.grabner.circleprogress.R.styleable.C
            boolean r0 = r9.z4
            boolean r11 = r10.getBoolean(r11, r0)
            r9.setRoundToWholeNumber(r11)
            int r11 = at.grabner.circleprogress.R.styleable.R
            java.lang.String r11 = r10.getString(r11)
            r9.setUnit(r11)
            int r11 = at.grabner.circleprogress.R.styleable.F
            boolean r0 = r9.n4
            boolean r11 = r10.getBoolean(r11, r0)
            r9.setUnitVisible(r11)
            int r11 = at.grabner.circleprogress.R.styleable.O
            float r0 = r9.K3
            float r11 = r10.getFloat(r11, r0)
            r9.setTextScale(r11)
            int r11 = at.grabner.circleprogress.R.styleable.U
            float r0 = r9.L3
            float r11 = r10.getFloat(r11, r0)
            r9.setUnitScale(r11)
            int r11 = at.grabner.circleprogress.R.styleable.D
            boolean r0 = r9.r4
            boolean r11 = r10.getBoolean(r11, r0)
            r9.setSeekModeEnabled(r11)
            int r11 = at.grabner.circleprogress.R.styleable.K
            int r0 = r9.B3
            int r11 = r10.getInt(r11, r0)
            r9.setStartAngle(r11)
            int r11 = at.grabner.circleprogress.R.styleable.E
            boolean r0 = r9.s4
            boolean r11 = r10.getBoolean(r11, r0)
            r9.setShowTextWhileSpinning(r11)
            int r11 = at.grabner.circleprogress.R.styleable.f16662n
            boolean r0 = r10.hasValue(r11)
            r2 = 1
            if (r0 == 0) goto L_0x03fe
            int r11 = r10.getInt(r11, r2)
            r9.setBlockCount(r11)
            int r11 = at.grabner.circleprogress.R.styleable.o
            float r11 = r10.getFloat(r11, r5)
            r9.setBlockScale(r11)
        L_0x03fe:
            int r11 = at.grabner.circleprogress.R.styleable.Q
            boolean r0 = r10.hasValue(r11)
            if (r0 == 0) goto L_0x041a
            android.content.Context r0 = r9.getContext()     // Catch:{ Exception -> 0x0419 }
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch:{ Exception -> 0x0419 }
            java.lang.String r11 = r10.getString(r11)     // Catch:{ Exception -> 0x0419 }
            android.graphics.Typeface r11 = android.graphics.Typeface.createFromAsset(r0, r11)     // Catch:{ Exception -> 0x0419 }
            r9.E4 = r11     // Catch:{ Exception -> 0x0419 }
            goto L_0x041a
        L_0x0419:
        L_0x041a:
            int r11 = at.grabner.circleprogress.R.styleable.X
            boolean r0 = r10.hasValue(r11)
            if (r0 == 0) goto L_0x0436
            android.content.Context r0 = r9.getContext()     // Catch:{ Exception -> 0x0435 }
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch:{ Exception -> 0x0435 }
            java.lang.String r11 = r10.getString(r11)     // Catch:{ Exception -> 0x0435 }
            android.graphics.Typeface r11 = android.graphics.Typeface.createFromAsset(r0, r11)     // Catch:{ Exception -> 0x0435 }
            r9.F4 = r11     // Catch:{ Exception -> 0x0435 }
            goto L_0x0436
        L_0x0435:
        L_0x0436:
            int r11 = at.grabner.circleprogress.R.styleable.p
            boolean r0 = r10.hasValue(r11)
            if (r0 == 0) goto L_0x0456
            java.lang.String r11 = r10.getString(r11)     // Catch:{ Exception -> 0x044c }
            if (r11 == 0) goto L_0x0456
            java.text.DecimalFormat r0 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x044c }
            r0.<init>(r11)     // Catch:{ Exception -> 0x044c }
            r9.D4 = r0     // Catch:{ Exception -> 0x044c }
            goto L_0x0456
        L_0x044c:
            r11 = move-exception
            java.lang.String r0 = "CircleView"
            java.lang.String r11 = r11.getMessage()
            android.util.Log.w(r0, r11)
        L_0x0456:
            r10.recycle()
            boolean r10 = r9.isInEditMode()
            if (r10 != 0) goto L_0x0464
            r10 = 2
            r11 = 0
            r9.setLayerType(r10, r11)
        L_0x0464:
            android.graphics.Paint r10 = new android.graphics.Paint
            r10.<init>(r2)
            r9.p4 = r10
            r10.setFilterBitmap(r1)
            android.graphics.Paint r10 = r9.p4
            android.graphics.PorterDuffXfermode r11 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.DST_IN
            r11.<init>(r0)
            r10.setXfermode(r11)
            r9.t()
            boolean r10 = r9.s3
            if (r10 == 0) goto L_0x0484
            r9.u()
        L_0x0484:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: at.grabner.circleprogress.CircleProgressView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public static double a(PointF pointF, PointF pointF2) {
        double degrees = Math.toDegrees(Math.atan2((double) (pointF2.y - pointF.y), (double) (pointF2.x - pointF.x)));
        return degrees < 0.0d ? degrees + 360.0d : degrees;
    }

    private static RectF b(String str, Paint paint, RectF rectF) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        float width = (float) (rect.left + rect.width());
        float height = ((float) rect.bottom) + (((float) rect.height()) * 0.93f);
        RectF rectF2 = new RectF();
        rectF2.left = rectF.left + ((rectF.width() - width) / 2.0f);
        float height2 = rectF.top + ((rectF.height() - height) / 2.0f);
        rectF2.top = height2;
        rectF2.right = rectF2.left + width;
        rectF2.bottom = height2 + height;
        return rectF2;
    }

    private int d(double d2) {
        int[] iArr = this.U3;
        int i2 = 0;
        if (iArr.length <= 1) {
            return iArr.length == 1 ? iArr[0] : ViewCompat.y;
        }
        double maxValue = ((double) (1.0f / getMaxValue())) * d2;
        int floor = (int) Math.floor(((double) (this.U3.length - 1)) * maxValue);
        int i5 = floor + 1;
        if (floor < 0) {
            i5 = 1;
        } else {
            int[] iArr2 = this.U3;
            if (i5 >= iArr2.length) {
                floor = iArr2.length - 2;
                i5 = iArr2.length - 1;
            }
            i2 = floor;
        }
        int[] iArr3 = this.U3;
        return ColorUtils.a(iArr3[i2], iArr3[i5], (float) (1.0d - ((((double) (iArr3.length - 1)) * maxValue) % 1.0d)));
    }

    private static float e(String str, Paint paint, RectF rectF) {
        Matrix matrix = new Matrix();
        Rect rect = new Rect();
        String replace = str.replace('1', '0');
        paint.getTextBounds(replace, 0, replace.length(), rect);
        matrix.setRectToRect(new RectF(rect), rectF, Matrix.ScaleToFit.CENTER);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return paint.getTextSize() * fArr[0];
    }

    private void f(Canvas canvas, RectF rectF, float f2, float f5, Paint paint) {
        float f6 = 0.0f;
        while (f6 < f5) {
            Canvas canvas2 = canvas;
            RectF rectF2 = rectF;
            canvas2.drawArc(rectF2, f2 + f6, Math.min(this.x4, f5 - f6), false, paint);
            f6 += this.w4;
        }
    }

    private void g(Canvas canvas) {
        float f2;
        float f5;
        if (this.o3 < 0.0f) {
            this.o3 = 1.0f;
        }
        if (this.h3 == Direction.CW) {
            f2 = ((float) this.B3) + this.q3;
            f5 = this.o3;
        } else {
            f2 = (float) this.B3;
            f5 = this.q3;
        }
        float f6 = f2 - f5;
        canvas.drawArc(this.Z2, f6, this.o3, false, this.Z3);
    }

    private RectF h(RectF rectF) {
        float f2;
        float f5;
        float width = (rectF.width() - ((float) ((((double) (((rectF.width() - ((float) Math.max(this.z3, this.A3))) - this.C3) - this.D3)) / 2.0d) * Math.sqrt(2.0d)))) / 2.0f;
        if (n()) {
            switch (AnonymousClass1.f16619a[this.k4.ordinal()]) {
                case 1:
                case 2:
                    f5 = 1.1f;
                    f2 = 0.88f;
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    f5 = 0.77f;
                    f2 = 1.33f;
                    break;
            }
        }
        f5 = 1.0f;
        f2 = 1.0f;
        float f6 = f5 * width;
        float f7 = width * f2;
        return new RectF(rectF.left + f6, rectF.top + f7, rectF.right - f6, rectF.bottom - f7);
    }

    private float i(PointF pointF) {
        long round = Math.round(a(this.b3, pointF));
        return o(this.h3 == Direction.CW ? (float) (round - ((long) this.B3)) : (float) (((long) this.B3) - round));
    }

    private static float o(float f2) {
        return ((f2 % 360.0f) + 360.0f) % 360.0f;
    }

    private void s() {
        int[] iArr = this.U3;
        if (iArr.length > 1) {
            this.X3.setShader(new SweepGradient(this.Z2.centerX(), this.Z2.centerY(), this.U3, (float[]) null));
            Matrix matrix = new Matrix();
            this.X3.getShader().getLocalMatrix(matrix);
            matrix.postTranslate(-this.Z2.centerX(), -this.Z2.centerY());
            matrix.postRotate((float) this.B3);
            matrix.postTranslate(this.Z2.centerX(), this.Z2.centerY());
            this.X3.getShader().setLocalMatrix(matrix);
            this.X3.setColor(this.U3[0]);
        } else {
            if (iArr.length == 1) {
                this.X3.setColor(iArr[0]);
            } else {
                this.X3.setColor(-16738680);
            }
            this.X3.setShader((Shader) null);
        }
        this.X3.setAntiAlias(true);
        this.X3.setStrokeCap(this.V3);
        this.X3.setStyle(Paint.Style.STROKE);
        this.X3.setStrokeWidth((float) this.z3);
        if (this.V3 != Paint.Cap.BUTT) {
            Paint paint = new Paint(this.X3);
            this.Y3 = paint;
            paint.setShader((Shader) null);
            this.Y3.setColor(this.U3[0]);
        }
    }

    private void setSpin(boolean z) {
        this.s3 = z;
    }

    private void setTextSizeAndTextBoundsWithFixedTextSize(String str) {
        this.d4.setTextSize((float) this.J3);
        this.d3 = b(str, this.d4, this.Z2);
    }

    private void w(float f2) {
        OnProgressChangedListener onProgressChangedListener = this.B4;
        if (onProgressChangedListener != null && f2 != this.C4) {
            onProgressChangedListener.a(f2);
            this.C4 = f2;
        }
    }

    private void x() {
        this.i4 = -1;
        this.c3 = h(this.Z2);
        invalidate();
    }

    public int c() {
        return this.R3;
    }

    public int[] getBarColors() {
        return this.U3;
    }

    public BarStartEndLine getBarStartEndLine() {
        return this.F3;
    }

    public Paint.Cap getBarStrokeCap() {
        return this.V3;
    }

    public int getBarWidth() {
        return this.z3;
    }

    public int getBlockCount() {
        return this.u4;
    }

    public float getBlockScale() {
        return this.v4;
    }

    public float getCurrentValue() {
        return this.i3;
    }

    public DecimalFormat getDecimalFormat() {
        return this.D4;
    }

    public int getDelayMillis() {
        return this.u3;
    }

    public int getFillColor() {
        return this.b4.getColor();
    }

    public int getInnerContourColor() {
        return this.N3;
    }

    public float getInnerContourSize() {
        return this.D3;
    }

    public float getMaxValue() {
        return this.l3;
    }

    public float getMaxValueAllowed() {
        return this.n3;
    }

    public float getMinValueAllowed() {
        return this.m3;
    }

    public int getOuterContourColor() {
        return this.M3;
    }

    public float getOuterContourSize() {
        return this.C3;
    }

    public float getRelativeUniteSize() {
        return this.q4;
    }

    public int getRimColor() {
        return this.Q3;
    }

    public Shader getRimShader() {
        return this.c4.getShader();
    }

    public int getRimWidth() {
        return this.A3;
    }

    public boolean getRoundToBlock() {
        return this.y4;
    }

    public boolean getRoundToWholeNumber() {
        return this.z4;
    }

    public float getSpinSpeed() {
        return this.r3;
    }

    public Paint.Cap getSpinnerStrokeCap() {
        return this.W3;
    }

    public int getStartAngle() {
        return this.B3;
    }

    public float getTextScale() {
        return this.K3;
    }

    public int getTextSize() {
        return this.J3;
    }

    public String getUnit() {
        return this.j4;
    }

    public float getUnitScale() {
        return this.L3;
    }

    public int getUnitSize() {
        return this.I3;
    }

    public boolean j() {
        return this.m4;
    }

    public boolean k() {
        return this.r4;
    }

    public boolean l() {
        return this.t4;
    }

    public boolean m() {
        return this.s4;
    }

    public boolean n() {
        return this.n4;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x03a0, code lost:
        if (r0 != 6) goto L_0x03af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008e, code lost:
        if (r6.s4 != false) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010b, code lost:
        if (r6.s4 != false) goto L_0x010d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x03a0  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x03ce  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x03d5  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x03e4  */
    /* JADX WARNING: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x027b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r18) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            super.onDraw(r18)
            r0 = 1135869952(0x43b40000, float:360.0)
            float r1 = r6.l3
            float r0 = r0 / r1
            float r1 = r6.i3
            float r8 = r0 * r1
            int r0 = r6.P3
            if (r0 == 0) goto L_0x0022
            android.graphics.RectF r1 = r6.a3
            r4 = 0
            android.graphics.Paint r5 = r6.b4
            r2 = 1135869952(0x43b40000, float:360.0)
            r3 = 1135869952(0x43b40000, float:360.0)
            r0 = r18
            r0.drawArc(r1, r2, r3, r4, r5)
        L_0x0022:
            int r0 = r6.A3
            if (r0 <= 0) goto L_0x0049
            boolean r0 = r6.t4
            if (r0 != 0) goto L_0x0039
            android.graphics.RectF r1 = r6.Z2
            r4 = 0
            android.graphics.Paint r5 = r6.c4
            r2 = 1135869952(0x43b40000, float:360.0)
            r3 = 1135869952(0x43b40000, float:360.0)
            r0 = r18
            r0.drawArc(r1, r2, r3, r4, r5)
            goto L_0x0049
        L_0x0039:
            android.graphics.RectF r2 = r6.Z2
            int r0 = r6.B3
            float r3 = (float) r0
            r4 = 1135869952(0x43b40000, float:360.0)
            android.graphics.Paint r5 = r6.c4
            r0 = r17
            r1 = r18
            r0.f(r1, r2, r3, r4, r5)
        L_0x0049:
            float r0 = r6.C3
            r9 = 0
            int r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x005e
            android.graphics.RectF r1 = r6.f3
            r4 = 0
            android.graphics.Paint r5 = r6.f4
            r2 = 1135869952(0x43b40000, float:360.0)
            r3 = 1135869952(0x43b40000, float:360.0)
            r0 = r18
            r0.drawArc(r1, r2, r3, r4, r5)
        L_0x005e:
            float r0 = r6.D3
            int r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x0072
            android.graphics.RectF r1 = r6.g3
            r4 = 0
            android.graphics.Paint r5 = r6.g4
            r2 = 1135869952(0x43b40000, float:360.0)
            r3 = 1135869952(0x43b40000, float:360.0)
            r0 = r18
            r0.drawArc(r1, r2, r3, r4, r5)
        L_0x0072:
            at.grabner.circleprogress.AnimationState r0 = r6.x3
            at.grabner.circleprogress.AnimationState r1 = at.grabner.circleprogress.AnimationState.SPINNING
            r10 = 1073741824(0x40000000, float:2.0)
            r11 = 1
            if (r0 == r1) goto L_0x0106
            at.grabner.circleprogress.AnimationState r1 = at.grabner.circleprogress.AnimationState.END_SPINNING
            if (r0 != r1) goto L_0x0081
            goto L_0x0106
        L_0x0081:
            at.grabner.circleprogress.AnimationState r1 = at.grabner.circleprogress.AnimationState.END_SPINNING_START_ANIMATING
            if (r0 != r1) goto L_0x0092
            r17.g(r18)
            boolean r0 = r6.v3
            if (r0 != 0) goto L_0x0092
            boolean r0 = r6.s4
            if (r0 == 0) goto L_0x03ca
            goto L_0x010d
        L_0x0092:
            at.grabner.circleprogress.Direction r0 = r6.h3
            at.grabner.circleprogress.Direction r1 = at.grabner.circleprogress.Direction.CW
            if (r0 != r1) goto L_0x009d
            int r0 = r6.B3
            float r0 = (float) r0
        L_0x009b:
            r12 = r0
            goto L_0x00a2
        L_0x009d:
            int r0 = r6.B3
            float r0 = (float) r0
            float r0 = r0 - r8
            goto L_0x009b
        L_0x00a2:
            boolean r0 = r6.t4
            if (r0 != 0) goto L_0x00f8
            android.graphics.Paint$Cap r0 = r6.V3
            android.graphics.Paint$Cap r1 = android.graphics.Paint.Cap.BUTT
            if (r0 == r1) goto L_0x00ee
            int r0 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x00ee
            int[] r0 = r6.U3
            int r0 = r0.length
            if (r0 <= r11) goto L_0x00ee
            r0 = 1127481344(0x43340000, float:180.0)
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            android.graphics.RectF r1 = r6.Z2
            if (r0 <= 0) goto L_0x00dd
            float r13 = r8 / r10
            r4 = 0
            android.graphics.Paint r5 = r6.X3
            r0 = r18
            r2 = r12
            r3 = r13
            r0.drawArc(r1, r2, r3, r4, r5)
            android.graphics.RectF r1 = r6.Z2
            android.graphics.Paint r5 = r6.Y3
            r3 = 1065353216(0x3f800000, float:1.0)
            r0.drawArc(r1, r2, r3, r4, r5)
            android.graphics.RectF r1 = r6.Z2
            float r2 = r12 + r13
            android.graphics.Paint r5 = r6.X3
            r3 = r13
        L_0x00d9:
            r0.drawArc(r1, r2, r3, r4, r5)
            goto L_0x010d
        L_0x00dd:
            r4 = 0
            android.graphics.Paint r5 = r6.X3
            r0 = r18
            r2 = r12
            r3 = r8
            r0.drawArc(r1, r2, r3, r4, r5)
            android.graphics.RectF r1 = r6.Z2
            android.graphics.Paint r5 = r6.Y3
            r3 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00d9
        L_0x00ee:
            android.graphics.RectF r1 = r6.Z2
            r4 = 0
            android.graphics.Paint r5 = r6.X3
            r0 = r18
            r2 = r12
            r3 = r8
            goto L_0x00d9
        L_0x00f8:
            android.graphics.RectF r2 = r6.Z2
            android.graphics.Paint r5 = r6.X3
            r0 = r17
            r1 = r18
            r3 = r12
            r4 = r8
            r0.f(r1, r2, r3, r4, r5)
            goto L_0x010d
        L_0x0106:
            r17.g(r18)
            boolean r0 = r6.s4
            if (r0 == 0) goto L_0x03ca
        L_0x010d:
            int[] r0 = at.grabner.circleprogress.CircleProgressView.AnonymousClass1.f16619a
            at.grabner.circleprogress.UnitPosition r1 = r6.k4
            int r1 = r1.ordinal()
            r1 = r0[r1]
            r2 = 2
            if (r1 == r11) goto L_0x0129
            if (r1 == r2) goto L_0x0129
            float r1 = r6.q4
            r3 = 1057803469(0x3f0ccccd, float:0.55)
            float r3 = r3 * r1
            r4 = 1050253722(0x3e99999a, float:0.3)
        L_0x0126:
            float r1 = r1 * r4
            goto L_0x0133
        L_0x0129:
            float r1 = r6.q4
            r3 = 1048576000(0x3e800000, float:0.25)
            float r3 = r3 * r1
            r4 = 1053609165(0x3ecccccd, float:0.4)
            goto L_0x0126
        L_0x0133:
            android.graphics.RectF r4 = r6.c3
            float r4 = r4.width()
            r5 = 1028443341(0x3d4ccccd, float:0.05)
            float r4 = r4 * r5
            float r4 = r4 / r10
            android.graphics.RectF r5 = r6.c3
            float r5 = r5.width()
            float r5 = r5 * r1
            android.graphics.RectF r1 = r6.c3
            float r1 = r1.height()
            r12 = 1020054733(0x3ccccccd, float:0.025)
            float r1 = r1 * r12
            float r1 = r1 / r10
            android.graphics.RectF r12 = r6.c3
            float r12 = r12.height()
            float r12 = r12 * r3
            boolean r3 = r6.T3
            if (r3 == 0) goto L_0x016b
            android.graphics.Paint r3 = r6.d4
            float r13 = r6.i3
            double r13 = (double) r13
            int r13 = r6.d(r13)
            r3.setColor(r13)
        L_0x016b:
            int[] r3 = at.grabner.circleprogress.CircleProgressView.AnonymousClass1.f16620b
            at.grabner.circleprogress.TextMode r13 = r6.l4
            int r13 = r13.ordinal()
            r3 = r3[r13]
            r13 = 3
            if (r3 == r2) goto L_0x018c
            if (r3 == r13) goto L_0x0182
            java.lang.String r3 = r6.h4
            if (r3 == 0) goto L_0x017f
            goto L_0x0198
        L_0x017f:
            java.lang.String r3 = ""
            goto L_0x0198
        L_0x0182:
            java.text.DecimalFormat r3 = r6.D4
            float r14 = r6.i3
        L_0x0186:
            double r14 = (double) r14
            java.lang.String r3 = r3.format(r14)
            goto L_0x0198
        L_0x018c:
            java.text.DecimalFormat r3 = r6.D4
            r14 = 1120403456(0x42c80000, float:100.0)
            float r15 = r6.l3
            float r14 = r14 / r15
            float r15 = r6.i3
            float r14 = r14 * r15
            goto L_0x0186
        L_0x0198:
            int r14 = r6.i4
            int r15 = r3.length()
            if (r14 == r15) goto L_0x025d
            int r14 = r3.length()
            r6.i4 = r14
            if (r14 != r11) goto L_0x01d7
            android.graphics.RectF r14 = r6.Z2
            android.graphics.RectF r14 = r6.h(r14)
            r6.c3 = r14
            android.graphics.RectF r14 = new android.graphics.RectF
            android.graphics.RectF r15 = r6.c3
            float r9 = r15.left
            float r15 = r15.width()
            r16 = 1036831949(0x3dcccccd, float:0.1)
            float r15 = r15 * r16
            float r9 = r9 + r15
            android.graphics.RectF r15 = r6.c3
            float r10 = r15.top
            float r13 = r15.right
            float r15 = r15.width()
            float r15 = r15 * r16
            float r13 = r13 - r15
            android.graphics.RectF r15 = r6.c3
            float r15 = r15.bottom
            r14.<init>(r9, r10, r13, r15)
            r6.c3 = r14
            goto L_0x01df
        L_0x01d7:
            android.graphics.RectF r9 = r6.Z2
            android.graphics.RectF r9 = r6.h(r9)
            r6.c3 = r9
        L_0x01df:
            boolean r9 = r6.m4
            if (r9 == 0) goto L_0x0258
            android.graphics.RectF r9 = r6.c3
            boolean r10 = r6.n4
            if (r10 == 0) goto L_0x0242
            at.grabner.circleprogress.UnitPosition r9 = r6.k4
            int r9 = r9.ordinal()
            r9 = r0[r9]
            if (r9 == r11) goto L_0x0231
            if (r9 == r2) goto L_0x021f
            r10 = 3
            if (r9 == r10) goto L_0x020d
            r10 = 5
            if (r9 == r10) goto L_0x020d
            android.graphics.RectF r9 = new android.graphics.RectF
            android.graphics.RectF r10 = r6.c3
            float r13 = r10.left
            float r14 = r10.top
            float r15 = r10.right
            float r15 = r15 - r5
            float r15 = r15 - r4
            float r10 = r10.bottom
            r9.<init>(r13, r14, r15, r10)
            goto L_0x0242
        L_0x020d:
            android.graphics.RectF r9 = new android.graphics.RectF
            android.graphics.RectF r10 = r6.c3
            float r13 = r10.left
            float r13 = r13 + r5
            float r13 = r13 + r4
            float r14 = r10.top
            float r15 = r10.right
            float r10 = r10.bottom
            r9.<init>(r13, r14, r15, r10)
            goto L_0x0242
        L_0x021f:
            android.graphics.RectF r9 = new android.graphics.RectF
            android.graphics.RectF r10 = r6.c3
            float r13 = r10.left
            float r14 = r10.top
            float r15 = r10.right
            float r10 = r10.bottom
            float r10 = r10 - r12
            float r10 = r10 - r1
            r9.<init>(r13, r14, r15, r10)
            goto L_0x0242
        L_0x0231:
            android.graphics.RectF r9 = new android.graphics.RectF
            android.graphics.RectF r10 = r6.c3
            float r13 = r10.left
            float r14 = r10.top
            float r14 = r14 + r12
            float r14 = r14 + r1
            float r15 = r10.right
            float r10 = r10.bottom
            r9.<init>(r13, r14, r15, r10)
        L_0x0242:
            android.graphics.Paint r10 = r6.d4
            float r13 = e(r3, r10, r9)
            float r14 = r6.K3
            float r13 = r13 * r14
            r10.setTextSize(r13)
            android.graphics.Paint r10 = r6.d4
            android.graphics.RectF r9 = b(r3, r10, r9)
            r6.d3 = r9
            goto L_0x025b
        L_0x0258:
            r6.setTextSizeAndTextBoundsWithFixedTextSize(r3)
        L_0x025b:
            r9 = 1
            goto L_0x025e
        L_0x025d:
            r9 = 0
        L_0x025e:
            android.graphics.RectF r10 = r6.d3
            float r10 = r10.left
            android.graphics.Paint r13 = r6.d4
            float r13 = r13.getTextSize()
            r14 = 1017370378(0x3ca3d70a, float:0.02)
            float r13 = r13 * r14
            float r10 = r10 - r13
            android.graphics.RectF r13 = r6.d3
            float r13 = r13.bottom
            android.graphics.Paint r15 = r6.d4
            r7.drawText(r3, r10, r13, r15)
            boolean r3 = r6.n4
            if (r3 == 0) goto L_0x03ca
            boolean r3 = r6.T3
            if (r3 == 0) goto L_0x028b
            android.graphics.Paint r3 = r6.e4
            float r10 = r6.i3
            double r14 = (double) r10
            int r10 = r6.d(r14)
            r3.setColor(r10)
        L_0x028b:
            if (r9 == 0) goto L_0x03af
            boolean r3 = r6.m4
            r9 = 6
            r10 = 4
            if (r3 == 0) goto L_0x032a
            at.grabner.circleprogress.UnitPosition r3 = r6.k4
            int r3 = r3.ordinal()
            r3 = r0[r3]
            if (r3 == r11) goto L_0x02d9
            if (r3 == r2) goto L_0x02c6
            r2 = 3
            if (r3 == r2) goto L_0x02b7
            r1 = 5
            if (r3 == r1) goto L_0x02b7
            android.graphics.RectF r1 = new android.graphics.RectF
            android.graphics.RectF r2 = r6.c3
            float r3 = r2.right
            float r5 = r3 - r5
            float r5 = r5 + r4
            float r2 = r2.top
            float r12 = r12 + r2
            r1.<init>(r5, r2, r3, r12)
        L_0x02b4:
            r6.e3 = r1
            goto L_0x02e9
        L_0x02b7:
            android.graphics.RectF r1 = new android.graphics.RectF
            android.graphics.RectF r2 = r6.c3
            float r3 = r2.left
            float r2 = r2.top
            float r5 = r5 + r3
            float r5 = r5 - r4
            float r12 = r12 + r2
            r1.<init>(r3, r2, r5, r12)
            goto L_0x02b4
        L_0x02c6:
            android.graphics.RectF r2 = new android.graphics.RectF
            android.graphics.RectF r3 = r6.c3
            float r4 = r3.left
            float r5 = r3.bottom
            float r11 = r5 - r12
            float r11 = r11 + r1
            float r1 = r3.right
            r2.<init>(r4, r11, r1, r5)
        L_0x02d6:
            r6.e3 = r2
            goto L_0x02e9
        L_0x02d9:
            android.graphics.RectF r2 = new android.graphics.RectF
            android.graphics.RectF r3 = r6.c3
            float r4 = r3.left
            float r5 = r3.top
            float r3 = r3.right
            float r12 = r12 + r5
            float r12 = r12 - r1
            r2.<init>(r4, r5, r3, r12)
            goto L_0x02d6
        L_0x02e9:
            android.graphics.Paint r1 = r6.e4
            java.lang.String r2 = r6.j4
            android.graphics.RectF r3 = r6.e3
            float r2 = e(r2, r1, r3)
            float r3 = r6.L3
            float r2 = r2 * r3
            r1.setTextSize(r2)
            java.lang.String r1 = r6.j4
            android.graphics.Paint r2 = r6.e4
            android.graphics.RectF r3 = r6.e3
            android.graphics.RectF r1 = b(r1, r2, r3)
            r6.e3 = r1
            at.grabner.circleprogress.UnitPosition r1 = r6.k4
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 3
            if (r0 == r1) goto L_0x031b
            if (r0 == r10) goto L_0x031b
            r1 = 5
            if (r0 == r1) goto L_0x03a3
            if (r0 == r9) goto L_0x03a3
            r2 = 0
            goto L_0x03af
        L_0x031b:
            r2 = 0
            android.graphics.RectF r0 = r6.d3
            float r0 = r0.top
            android.graphics.RectF r1 = r6.e3
            float r3 = r1.top
            float r0 = r0 - r3
        L_0x0325:
            r1.offset(r2, r0)
            goto L_0x03af
        L_0x032a:
            r3 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 * r3
            float r1 = r1 * r3
            android.graphics.Paint r3 = r6.e4
            int r5 = r6.I3
            float r5 = (float) r5
            r3.setTextSize(r5)
            java.lang.String r3 = r6.j4
            android.graphics.Paint r5 = r6.e4
            android.graphics.RectF r12 = r6.c3
            android.graphics.RectF r3 = b(r3, r5, r12)
            r6.e3 = r3
            at.grabner.circleprogress.UnitPosition r3 = r6.k4
            int r3 = r3.ordinal()
            r3 = r0[r3]
            if (r3 == r11) goto L_0x0381
            if (r3 == r2) goto L_0x0374
            r2 = 3
            if (r3 == r2) goto L_0x0363
            r1 = 5
            if (r3 == r1) goto L_0x0363
            android.graphics.RectF r1 = r6.e3
            android.graphics.RectF r2 = r6.d3
            float r2 = r2.right
            float r2 = r2 + r4
            float r3 = r1.top
        L_0x035f:
            r1.offsetTo(r2, r3)
            goto L_0x0390
        L_0x0363:
            android.graphics.RectF r1 = r6.e3
            android.graphics.RectF r2 = r6.d3
            float r2 = r2.left
            float r2 = r2 - r4
            float r3 = r1.width()
            float r2 = r2 - r3
            android.graphics.RectF r3 = r6.e3
            float r3 = r3.top
            goto L_0x035f
        L_0x0374:
            android.graphics.RectF r2 = r6.e3
            float r3 = r2.left
            android.graphics.RectF r4 = r6.d3
            float r4 = r4.bottom
            float r4 = r4 + r1
        L_0x037d:
            r2.offsetTo(r3, r4)
            goto L_0x0390
        L_0x0381:
            android.graphics.RectF r2 = r6.e3
            float r3 = r2.left
            android.graphics.RectF r4 = r6.d3
            float r4 = r4.top
            float r4 = r4 - r1
            float r1 = r2.height()
            float r4 = r4 - r1
            goto L_0x037d
        L_0x0390:
            at.grabner.circleprogress.UnitPosition r1 = r6.k4
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 3
            if (r0 == r1) goto L_0x031b
            if (r0 == r10) goto L_0x031b
            r1 = 5
            if (r0 == r1) goto L_0x03a3
            if (r0 == r9) goto L_0x03a3
            goto L_0x03af
        L_0x03a3:
            android.graphics.RectF r0 = r6.d3
            float r0 = r0.bottom
            android.graphics.RectF r1 = r6.e3
            float r2 = r1.bottom
            float r0 = r0 - r2
            r2 = 0
            goto L_0x0325
        L_0x03af:
            java.lang.String r0 = r6.j4
            android.graphics.RectF r1 = r6.e3
            float r1 = r1.left
            android.graphics.Paint r2 = r6.e4
            float r2 = r2.getTextSize()
            r3 = 1017370378(0x3ca3d70a, float:0.02)
            float r2 = r2 * r3
            float r1 = r1 - r2
            android.graphics.RectF r2 = r6.e3
            float r2 = r2.bottom
            android.graphics.Paint r3 = r6.e4
            r7.drawText(r0, r1, r2, r3)
        L_0x03ca:
            android.graphics.Bitmap r0 = r6.o4
            if (r0 == 0) goto L_0x03d5
            android.graphics.Paint r1 = r6.p4
            r2 = 0
            r7.drawBitmap(r0, r2, r2, r1)
            goto L_0x03d6
        L_0x03d5:
            r2 = 0
        L_0x03d6:
            int r0 = r6.E3
            if (r0 <= 0) goto L_0x0425
            at.grabner.circleprogress.BarStartEndLine r0 = r6.F3
            at.grabner.circleprogress.BarStartEndLine r1 = at.grabner.circleprogress.BarStartEndLine.NONE
            if (r0 == r1) goto L_0x0425
            int r1 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x0425
            at.grabner.circleprogress.Direction r1 = r6.h3
            at.grabner.circleprogress.Direction r2 = at.grabner.circleprogress.Direction.CW
            if (r1 != r2) goto L_0x03ee
            int r1 = r6.B3
            float r1 = (float) r1
            goto L_0x03f2
        L_0x03ee:
            int r1 = r6.B3
            float r1 = (float) r1
            float r1 = r1 - r8
        L_0x03f2:
            float r3 = r6.H3
            r2 = 1073741824(0x40000000, float:2.0)
            float r2 = r3 / r2
            float r9 = r1 - r2
            at.grabner.circleprogress.BarStartEndLine r1 = at.grabner.circleprogress.BarStartEndLine.START
            if (r0 == r1) goto L_0x0402
            at.grabner.circleprogress.BarStartEndLine r1 = at.grabner.circleprogress.BarStartEndLine.BOTH
            if (r0 != r1) goto L_0x040d
        L_0x0402:
            android.graphics.RectF r1 = r6.Z2
            r4 = 0
            android.graphics.Paint r5 = r6.a4
            r0 = r18
            r2 = r9
            r0.drawArc(r1, r2, r3, r4, r5)
        L_0x040d:
            at.grabner.circleprogress.BarStartEndLine r0 = r6.F3
            at.grabner.circleprogress.BarStartEndLine r1 = at.grabner.circleprogress.BarStartEndLine.END
            if (r0 == r1) goto L_0x0417
            at.grabner.circleprogress.BarStartEndLine r1 = at.grabner.circleprogress.BarStartEndLine.BOTH
            if (r0 != r1) goto L_0x0425
        L_0x0417:
            android.graphics.RectF r1 = r6.Z2
            float r2 = r9 + r8
            float r3 = r6.H3
            r4 = 0
            android.graphics.Paint r5 = r6.a4
            r0 = r18
            r0.drawArc(r1, r2, r3, r4, r5)
        L_0x0425:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: at.grabner.circleprogress.CircleProgressView.onDraw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i5) {
        super.onMeasure(i2, i5);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        if (paddingLeft > paddingTop) {
            paddingLeft = paddingTop;
        }
        setMeasuredDimension(getPaddingLeft() + paddingLeft + getPaddingRight(), paddingLeft + getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i5, int i6, int i7) {
        super.onSizeChanged(i2, i5, i6, i7);
        this.Y2 = i2;
        this.X2 = i5;
        int min = Math.min(i2, i5);
        int i8 = this.Y2 - min;
        int i9 = (this.X2 - min) / 2;
        float paddingTop = (float) (getPaddingTop() + i9);
        float paddingBottom = (float) (getPaddingBottom() + i9);
        int i10 = i8 / 2;
        float paddingLeft = (float) (getPaddingLeft() + i10);
        float paddingRight = (float) (getPaddingRight() + i10);
        int width = getWidth();
        int height = getHeight();
        int i11 = this.z3;
        int i12 = this.A3;
        float f2 = this.C3;
        float f5 = ((float) i11) / 2.0f > (((float) i12) / 2.0f) + f2 ? ((float) i11) / 2.0f : (((float) i12) / 2.0f) + f2;
        float f6 = ((float) width) - paddingRight;
        float f7 = ((float) height) - paddingBottom;
        this.Z2 = new RectF(paddingLeft + f5, paddingTop + f5, f6 - f5, f7 - f5);
        int i13 = this.z3;
        this.a3 = new RectF(paddingLeft + ((float) i13), paddingTop + ((float) i13), f6 - ((float) i13), f7 - ((float) i13));
        this.c3 = h(this.Z2);
        RectF rectF = this.Z2;
        float f8 = rectF.left;
        int i14 = this.A3;
        float f9 = this.D3;
        this.g3 = new RectF(f8 + (((float) i14) / 2.0f) + (f9 / 2.0f), rectF.top + (((float) i14) / 2.0f) + (f9 / 2.0f), (rectF.right - (((float) i14) / 2.0f)) - (f9 / 2.0f), (rectF.bottom - (((float) i14) / 2.0f)) - (f9 / 2.0f));
        RectF rectF2 = this.Z2;
        float f10 = rectF2.left;
        int i15 = this.A3;
        float f11 = this.C3;
        this.f3 = new RectF((f10 - (((float) i15) / 2.0f)) - (f11 / 2.0f), (rectF2.top - (((float) i15) / 2.0f)) - (f11 / 2.0f), rectF2.right + (((float) i15) / 2.0f) + (f11 / 2.0f), rectF2.bottom + (((float) i15) / 2.0f) + (f11 / 2.0f));
        this.b3 = new PointF(this.Z2.centerX(), this.Z2.centerY());
        s();
        Bitmap bitmap = this.o4;
        if (bitmap != null) {
            this.o4 = Bitmap.createScaledBitmap(bitmap, getWidth(), getHeight(), false);
        }
        invalidate();
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!this.r4) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 1) {
            this.A4 = 0;
            r((this.l3 / 360.0f) * i(new PointF(motionEvent.getX(), motionEvent.getY())), 800);
            return true;
        } else if (actionMasked == 2) {
            int i2 = this.A4 + 1;
            this.A4 = i2;
            if (i2 <= 5) {
                return false;
            }
            setValue((this.l3 / 360.0f) * i(new PointF(motionEvent.getX(), motionEvent.getY())));
            return true;
        } else if (actionMasked != 3) {
            return super.onTouchEvent(motionEvent);
        } else {
            this.A4 = 0;
            return false;
        }
    }

    public void p(int i2, BarStartEndLine barStartEndLine, @ColorInt int i5, float f2) {
        this.E3 = i2;
        this.F3 = barStartEndLine;
        this.G3 = i5;
        this.H3 = f2;
    }

    public void q(float f2, float f5, long j2) {
        if (this.t4 && this.y4) {
            float f6 = this.l3 / ((float) this.u4);
            f5 = ((float) Math.round(f5 / f6)) * f6;
        } else if (this.z4) {
            f5 = (float) Math.round(f5);
        }
        float max = Math.max(this.m3, f5);
        float f7 = this.n3;
        if (f7 >= 0.0f) {
            max = Math.min(f7, max);
        }
        this.t3 = (double) j2;
        Message message = new Message();
        message.what = AnimationMsg.Z - 1;
        message.obj = new float[]{f2, max};
        this.w3.sendMessage(message);
        w(max);
    }

    public void r(float f2, long j2) {
        q(this.i3, f2, j2);
    }

    public void setAutoTextSize(boolean z) {
        this.m4 = z;
    }

    public void setBarColor(@ColorInt int... iArr) {
        this.U3 = iArr;
        s();
    }

    public void setBarStrokeCap(Paint.Cap cap) {
        this.V3 = cap;
        this.X3.setStrokeCap(cap);
        if (this.V3 != Paint.Cap.BUTT) {
            Paint paint = new Paint(this.X3);
            this.Y3 = paint;
            paint.setShader((Shader) null);
            this.Y3.setColor(this.U3[0]);
        }
    }

    public void setBarWidth(@IntRange(from = 0) int i2) {
        this.z3 = i2;
        float f2 = (float) i2;
        this.X3.setStrokeWidth(f2);
        this.Z3.setStrokeWidth(f2);
    }

    public void setBlockCount(int i2) {
        if (i2 > 1) {
            this.t4 = true;
            this.u4 = i2;
            float f2 = 360.0f / ((float) i2);
            this.w4 = f2;
            this.x4 = f2 * this.v4;
            return;
        }
        this.t4 = false;
    }

    public void setBlockScale(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.v4 = f2;
            this.x4 = this.w4 * f2;
        }
    }

    @TargetApi(11)
    public void setClippingBitmap(Bitmap bitmap) {
        if (getWidth() > 0 && getHeight() > 0) {
            bitmap = Bitmap.createScaledBitmap(bitmap, getWidth(), getHeight(), false);
        }
        this.o4 = bitmap;
        setLayerType(this.o4 == null ? 2 : 1, (Paint) null);
    }

    public void setDecimalFormat(DecimalFormat decimalFormat) {
        if (decimalFormat != null) {
            this.D4 = decimalFormat;
            return;
        }
        throw new IllegalArgumentException("decimalFormat must not be null!");
    }

    public void setDelayMillis(int i2) {
        this.u3 = i2;
    }

    public void setDirection(Direction direction) {
        this.h3 = direction;
    }

    public void setFillCircleColor(@ColorInt int i2) {
        this.P3 = i2;
        this.b4.setColor(i2);
    }

    public void setInnerContourColor(@ColorInt int i2) {
        this.N3 = i2;
        this.g4.setColor(i2);
    }

    public void setInnerContourSize(@FloatRange(from = 0.0d) float f2) {
        this.D3 = f2;
        this.g4.setStrokeWidth(f2);
    }

    public void setLengthChangeInterpolator(TimeInterpolator timeInterpolator) {
        this.w3.e(timeInterpolator);
    }

    public void setMaxValue(@FloatRange(from = 0.0d) float f2) {
        this.l3 = f2;
    }

    public void setMaxValueAllowed(@FloatRange(from = 0.0d) float f2) {
        this.n3 = f2;
    }

    public void setMinValueAllowed(@FloatRange(from = 0.0d) float f2) {
        this.m3 = f2;
    }

    public void setOnAnimationStateChangedListener(AnimationStateChangedListener animationStateChangedListener) {
        this.y3 = animationStateChangedListener;
    }

    public void setOnProgressChangedListener(OnProgressChangedListener onProgressChangedListener) {
        this.B4 = onProgressChangedListener;
    }

    public void setOuterContourColor(@ColorInt int i2) {
        this.M3 = i2;
        this.f4.setColor(i2);
    }

    public void setOuterContourSize(@FloatRange(from = 0.0d) float f2) {
        this.C3 = f2;
        this.f4.setStrokeWidth(f2);
    }

    public void setRimColor(@ColorInt int i2) {
        this.Q3 = i2;
        this.c4.setColor(i2);
    }

    public void setRimShader(Shader shader) {
        this.c4.setShader(shader);
    }

    public void setRimWidth(@IntRange(from = 0) int i2) {
        this.A3 = i2;
        this.c4.setStrokeWidth((float) i2);
    }

    public void setRoundToBlock(boolean z) {
        this.y4 = z;
    }

    public void setRoundToWholeNumber(boolean z) {
        this.z4 = z;
    }

    public void setSeekModeEnabled(boolean z) {
        this.r4 = z;
    }

    public void setShowBlock(boolean z) {
        this.t4 = z;
    }

    public void setShowTextWhileSpinning(boolean z) {
        this.s4 = z;
    }

    public void setSpinBarColor(@ColorInt int i2) {
        this.O3 = i2;
        this.Z3.setColor(i2);
    }

    public void setSpinSpeed(float f2) {
        this.r3 = f2;
    }

    public void setSpinnerStrokeCap(Paint.Cap cap) {
        this.W3 = cap;
        this.Z3.setStrokeCap(cap);
    }

    public void setSpinningBarLength(@FloatRange(from = 0.0d) float f2) {
        this.p3 = f2;
        this.o3 = f2;
    }

    public void setStartAngle(@IntRange(from = 0, to = 360) int i2) {
        this.B3 = (int) o((float) i2);
    }

    public void setText(String str) {
        if (str == null) {
            str = "";
        }
        this.h4 = str;
        invalidate();
    }

    public void setTextColor(@ColorInt int i2) {
        this.R3 = i2;
        this.d4.setColor(i2);
    }

    public void setTextColorAuto(boolean z) {
        this.T3 = z;
    }

    public void setTextMode(TextMode textMode) {
        this.l4 = textMode;
    }

    public void setTextScale(@FloatRange(from = 0.0d) float f2) {
        this.K3 = f2;
    }

    public void setTextSize(@IntRange(from = 0) int i2) {
        this.d4.setTextSize((float) i2);
        this.J3 = i2;
        this.m4 = false;
    }

    public void setTextTypeface(Typeface typeface) {
        this.d4.setTypeface(typeface);
    }

    public void setUnit(String str) {
        if (str == null) {
            str = "";
        }
        this.j4 = str;
        invalidate();
    }

    public void setUnitColor(@ColorInt int i2) {
        this.S3 = i2;
        this.e4.setColor(i2);
        this.T3 = false;
    }

    public void setUnitPosition(UnitPosition unitPosition) {
        this.k4 = unitPosition;
        x();
    }

    public void setUnitScale(@FloatRange(from = 0.0d) float f2) {
        this.L3 = f2;
    }

    public void setUnitSize(@IntRange(from = 0) int i2) {
        this.I3 = i2;
        this.e4.setTextSize((float) i2);
    }

    public void setUnitTextTypeface(Typeface typeface) {
        this.e4.setTypeface(typeface);
    }

    public void setUnitToTextScale(@FloatRange(from = 0.0d) float f2) {
        this.q4 = f2;
        x();
    }

    public void setUnitVisible(boolean z) {
        if (z != this.n4) {
            this.n4 = z;
            x();
        }
    }

    public void setValue(float f2) {
        if (this.t4 && this.y4) {
            float f5 = this.l3 / ((float) this.u4);
            f2 = ((float) Math.round(f2 / f5)) * f5;
        } else if (this.z4) {
            f2 = (float) Math.round(f2);
        }
        float max = Math.max(this.m3, f2);
        float f6 = this.n3;
        if (f6 >= 0.0f) {
            max = Math.min(f6, max);
        }
        Message message = new Message();
        message.what = AnimationMsg.Y - 1;
        message.obj = new float[]{max, max};
        this.w3.sendMessage(message);
        w(max);
    }

    public void setValueAnimated(float f2) {
        r(f2, 1200);
    }

    public void setValueInterpolator(TimeInterpolator timeInterpolator) {
        this.w3.g(timeInterpolator);
    }

    public void t() {
        s();
        this.Z3.setAntiAlias(true);
        this.Z3.setStrokeCap(this.W3);
        Paint paint = this.Z3;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.Z3.setStrokeWidth((float) this.z3);
        this.Z3.setColor(this.O3);
        this.f4.setColor(this.M3);
        this.f4.setAntiAlias(true);
        this.f4.setStyle(style);
        this.f4.setStrokeWidth(this.C3);
        this.g4.setColor(this.N3);
        this.g4.setAntiAlias(true);
        this.g4.setStyle(style);
        this.g4.setStrokeWidth(this.D3);
        Paint paint2 = this.e4;
        Paint.Style style2 = Paint.Style.FILL;
        paint2.setStyle(style2);
        this.e4.setAntiAlias(true);
        Typeface typeface = this.F4;
        if (typeface != null) {
            this.e4.setTypeface(typeface);
        }
        this.d4.setSubpixelText(true);
        this.d4.setLinearText(true);
        Paint paint3 = this.d4;
        Typeface typeface2 = Typeface.MONOSPACE;
        paint3.setTypeface(typeface2);
        this.d4.setColor(this.R3);
        this.d4.setStyle(style2);
        this.d4.setAntiAlias(true);
        this.d4.setTextSize((float) this.J3);
        Typeface typeface3 = this.E4;
        if (typeface3 != null) {
            this.d4.setTypeface(typeface3);
        } else {
            this.d4.setTypeface(typeface2);
        }
        this.b4.setColor(this.P3);
        this.b4.setAntiAlias(true);
        this.b4.setStyle(style2);
        this.c4.setColor(this.Q3);
        this.c4.setAntiAlias(true);
        this.c4.setStyle(style);
        this.c4.setStrokeWidth((float) this.A3);
        this.a4.setColor(this.G3);
        this.a4.setAntiAlias(true);
        this.a4.setStyle(style);
        this.a4.setStrokeWidth((float) this.E3);
    }

    public void u() {
        setSpin(true);
        this.w3.sendEmptyMessage(AnimationMsg.s - 1);
    }

    public void v() {
        setSpin(false);
        this.w3.sendEmptyMessage(AnimationMsg.X - 1);
    }
}
