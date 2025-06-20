package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import java.util.ArrayList;

public class Chain {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f4160a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f4161b = false;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: androidx.constraintlayout.core.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v1, resolved type: androidx.constraintlayout.core.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: androidx.constraintlayout.core.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v3, resolved type: androidx.constraintlayout.core.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v4, resolved type: androidx.constraintlayout.core.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v39, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX WARNING: type inference failed for: r5v10, types: [androidx.constraintlayout.core.SolverVariable] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r7 == 2) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004b, code lost:
        if (r7 == 2) goto L_0x0033;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x025c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02b8 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x032e  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0343  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0353 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x039c  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x03b1  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x03b4  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0495  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x04d3 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x04df  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x04eb  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x04ee  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x04f4  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x04f7  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x04fb  */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x050b  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x050f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x039e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:327:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r37, androidx.constraintlayout.core.LinearSystem r38, int r39, int r40, androidx.constraintlayout.core.widgets.ChainHead r41) {
        /*
            r0 = r37
            r9 = r38
            r10 = r39
            r1 = r41
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r1.f4162a
            androidx.constraintlayout.core.widgets.ConstraintWidget r12 = r1.f4164c
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = r1.f4163b
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = r1.f4165d
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r1.f4166e
            float r3 = r1.f4172k
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.b0
            r4 = r4[r10]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r15 = 1
            if (r4 != r5) goto L_0x001f
            r4 = 1
            goto L_0x0020
        L_0x001f:
            r4 = 0
        L_0x0020:
            r5 = 2
            if (r10 != 0) goto L_0x003d
            int r7 = r2.J0
            if (r7 != 0) goto L_0x0029
            r8 = 1
            goto L_0x002a
        L_0x0029:
            r8 = 0
        L_0x002a:
            if (r7 != r15) goto L_0x002f
            r16 = 1
            goto L_0x0031
        L_0x002f:
            r16 = 0
        L_0x0031:
            if (r7 != r5) goto L_0x0035
        L_0x0033:
            r5 = 1
            goto L_0x0036
        L_0x0035:
            r5 = 0
        L_0x0036:
            r17 = r16
            r7 = 0
            r16 = r8
            r8 = r11
            goto L_0x004e
        L_0x003d:
            int r7 = r2.K0
            if (r7 != 0) goto L_0x0043
            r8 = 1
            goto L_0x0044
        L_0x0043:
            r8 = 0
        L_0x0044:
            if (r7 != r15) goto L_0x0049
            r16 = 1
            goto L_0x004b
        L_0x0049:
            r16 = 0
        L_0x004b:
            if (r7 != r5) goto L_0x0035
            goto L_0x0033
        L_0x004e:
            r21 = 0
            if (r7 != 0) goto L_0x012b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r8.Y
            r6 = r6[r40]
            if (r5 == 0) goto L_0x005b
            r19 = 1
            goto L_0x005d
        L_0x005b:
            r19 = 4
        L_0x005d:
            int r23 = r6.g()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r15 = r8.b0
            r15 = r15[r10]
            r25 = r3
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r15 != r3) goto L_0x0075
            int[] r15 = r8.y
            r15 = r15[r10]
            if (r15 != 0) goto L_0x0075
            r26 = r7
            r15 = 1
            goto L_0x0078
        L_0x0075:
            r26 = r7
            r15 = 0
        L_0x0078:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r6.f4183f
            if (r7 == 0) goto L_0x0084
            if (r8 == r11) goto L_0x0084
            int r7 = r7.g()
            int r23 = r23 + r7
        L_0x0084:
            r7 = r23
            if (r5 == 0) goto L_0x0091
            if (r8 == r11) goto L_0x0091
            if (r8 == r13) goto L_0x0091
            r23 = r2
            r19 = 8
            goto L_0x0093
        L_0x0091:
            r23 = r2
        L_0x0093:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r6.f4183f
            r27 = r11
            if (r2 == 0) goto L_0x00ca
            if (r8 != r13) goto L_0x00a4
            androidx.constraintlayout.core.SolverVariable r11 = r6.f4186i
            androidx.constraintlayout.core.SolverVariable r2 = r2.f4186i
            r1 = 6
            r9.i(r11, r2, r7, r1)
            goto L_0x00ad
        L_0x00a4:
            androidx.constraintlayout.core.SolverVariable r1 = r6.f4186i
            androidx.constraintlayout.core.SolverVariable r2 = r2.f4186i
            r11 = 8
            r9.i(r1, r2, r7, r11)
        L_0x00ad:
            if (r15 == 0) goto L_0x00b3
            if (r5 != 0) goto L_0x00b3
            r19 = 5
        L_0x00b3:
            if (r8 != r13) goto L_0x00bf
            if (r5 == 0) goto L_0x00bf
            boolean r1 = r8.A0(r10)
            if (r1 == 0) goto L_0x00bf
            r1 = 5
            goto L_0x00c1
        L_0x00bf:
            r1 = r19
        L_0x00c1:
            androidx.constraintlayout.core.SolverVariable r2 = r6.f4186i
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.f4183f
            androidx.constraintlayout.core.SolverVariable r6 = r6.f4186i
            r9.e(r2, r6, r7, r1)
        L_0x00ca:
            if (r4 == 0) goto L_0x00fe
            int r1 = r8.l0()
            r2 = 8
            if (r1 == r2) goto L_0x00ec
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r8.b0
            r1 = r1[r10]
            if (r1 != r3) goto L_0x00ec
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r8.Y
            int r2 = r40 + 1
            r2 = r1[r2]
            androidx.constraintlayout.core.SolverVariable r2 = r2.f4186i
            r1 = r1[r40]
            androidx.constraintlayout.core.SolverVariable r1 = r1.f4186i
            r3 = 0
            r6 = 5
            r9.i(r2, r1, r3, r6)
            goto L_0x00ed
        L_0x00ec:
            r3 = 0
        L_0x00ed:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r8.Y
            r1 = r1[r40]
            androidx.constraintlayout.core.SolverVariable r1 = r1.f4186i
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r0.Y
            r2 = r2[r40]
            androidx.constraintlayout.core.SolverVariable r2 = r2.f4186i
            r6 = 8
            r9.i(r1, r2, r3, r6)
        L_0x00fe:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r8.Y
            int r2 = r40 + 1
            r1 = r1[r2]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f4183f
            if (r1 == 0) goto L_0x0119
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.f4181d
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r1.Y
            r2 = r2[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f4183f
            if (r2 == 0) goto L_0x0119
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r2.f4181d
            if (r2 == r8) goto L_0x0117
            goto L_0x0119
        L_0x0117:
            r21 = r1
        L_0x0119:
            if (r21 == 0) goto L_0x0120
            r8 = r21
            r7 = r26
            goto L_0x0121
        L_0x0120:
            r7 = 1
        L_0x0121:
            r1 = r41
            r2 = r23
            r3 = r25
            r11 = r27
            goto L_0x004e
        L_0x012b:
            r23 = r2
            r25 = r3
            r27 = r11
            if (r14 == 0) goto L_0x018f
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r12.Y
            int r2 = r40 + 1
            r1 = r1[r2]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f4183f
            if (r1 == 0) goto L_0x018f
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r14.Y
            r1 = r1[r2]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r14.b0
            r3 = r3[r10]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r6) goto L_0x0165
            int[] r3 = r14.y
            r3 = r3[r10]
            if (r3 != 0) goto L_0x0165
            if (r5 != 0) goto L_0x0165
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.f4183f
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r3.f4181d
            if (r6 != r0) goto L_0x0165
            androidx.constraintlayout.core.SolverVariable r6 = r1.f4186i
            androidx.constraintlayout.core.SolverVariable r3 = r3.f4186i
            int r7 = r1.g()
            int r7 = -r7
            r8 = 5
            r9.e(r6, r3, r7, r8)
            goto L_0x017b
        L_0x0165:
            r8 = 5
            if (r5 == 0) goto L_0x017b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.f4183f
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r3.f4181d
            if (r6 != r0) goto L_0x017b
            androidx.constraintlayout.core.SolverVariable r6 = r1.f4186i
            androidx.constraintlayout.core.SolverVariable r3 = r3.f4186i
            int r7 = r1.g()
            int r7 = -r7
            r11 = 4
            r9.e(r6, r3, r7, r11)
        L_0x017b:
            androidx.constraintlayout.core.SolverVariable r3 = r1.f4186i
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r12.Y
            r2 = r6[r2]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f4183f
            androidx.constraintlayout.core.SolverVariable r2 = r2.f4186i
            int r1 = r1.g()
            int r1 = -r1
            r6 = 6
            r9.k(r3, r2, r1, r6)
            goto L_0x0190
        L_0x018f:
            r8 = 5
        L_0x0190:
            if (r4 == 0) goto L_0x01a9
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r0.Y
            int r1 = r40 + 1
            r0 = r0[r1]
            androidx.constraintlayout.core.SolverVariable r0 = r0.f4186i
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r12.Y
            r1 = r2[r1]
            androidx.constraintlayout.core.SolverVariable r2 = r1.f4186i
            int r1 = r1.g()
            r3 = 8
            r9.i(r0, r2, r1, r3)
        L_0x01a9:
            r0 = r41
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r1 = r0.f4169h
            if (r1 == 0) goto L_0x025a
            int r2 = r1.size()
            r3 = 1
            if (r2 <= r3) goto L_0x025a
            boolean r3 = r0.r
            if (r3 == 0) goto L_0x01c2
            boolean r3 = r0.t
            if (r3 != 0) goto L_0x01c2
            int r3 = r0.f4171j
            float r3 = (float) r3
            goto L_0x01c4
        L_0x01c2:
            r3 = r25
        L_0x01c4:
            r4 = 0
            r7 = r21
            r6 = 0
            r29 = 0
        L_0x01ca:
            if (r6 >= r2) goto L_0x025a
            java.lang.Object r11 = r1.get(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r11
            float[] r15 = r11.N0
            r15 = r15[r10]
            int r20 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r20 >= 0) goto L_0x01f6
            boolean r15 = r0.t
            if (r15 == 0) goto L_0x01f1
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r11 = r11.Y
            int r15 = r40 + 1
            r15 = r11[r15]
            androidx.constraintlayout.core.SolverVariable r15 = r15.f4186i
            r11 = r11[r40]
            androidx.constraintlayout.core.SolverVariable r11 = r11.f4186i
            r4 = 4
            r8 = 0
            r9.e(r15, r11, r8, r4)
            r4 = 0
            goto L_0x020e
        L_0x01f1:
            r4 = 4
            r15 = 1065353216(0x3f800000, float:1.0)
        L_0x01f4:
            r8 = 0
            goto L_0x01f8
        L_0x01f6:
            r4 = 4
            goto L_0x01f4
        L_0x01f8:
            int r19 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r19 != 0) goto L_0x0213
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r11 = r11.Y
            int r15 = r40 + 1
            r15 = r11[r15]
            androidx.constraintlayout.core.SolverVariable r15 = r15.f4186i
            r11 = r11[r40]
            androidx.constraintlayout.core.SolverVariable r11 = r11.f4186i
            r4 = 0
            r8 = 8
            r9.e(r15, r11, r4, r8)
        L_0x020e:
            r25 = r1
            r18 = r2
            goto L_0x0250
        L_0x0213:
            r4 = 0
            if (r7 == 0) goto L_0x0249
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r7.Y
            r8 = r7[r40]
            androidx.constraintlayout.core.SolverVariable r8 = r8.f4186i
            int r18 = r40 + 1
            r7 = r7[r18]
            androidx.constraintlayout.core.SolverVariable r7 = r7.f4186i
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r11.Y
            r25 = r1
            r1 = r4[r40]
            androidx.constraintlayout.core.SolverVariable r1 = r1.f4186i
            r4 = r4[r18]
            androidx.constraintlayout.core.SolverVariable r4 = r4.f4186i
            r18 = r2
            androidx.constraintlayout.core.ArrayRow r2 = r38.v()
            r28 = r2
            r30 = r3
            r31 = r15
            r32 = r8
            r33 = r7
            r34 = r1
            r35 = r4
            r28.p(r29, r30, r31, r32, r33, r34, r35)
            r9.d(r2)
            goto L_0x024d
        L_0x0249:
            r25 = r1
            r18 = r2
        L_0x024d:
            r7 = r11
            r29 = r15
        L_0x0250:
            int r6 = r6 + 1
            r2 = r18
            r1 = r25
            r4 = 0
            r8 = 5
            goto L_0x01ca
        L_0x025a:
            if (r13 == 0) goto L_0x0263
            if (r13 == r14) goto L_0x0260
            if (r5 == 0) goto L_0x0263
        L_0x0260:
            r11 = r27
            goto L_0x0266
        L_0x0263:
            r11 = r27
            goto L_0x02b6
        L_0x0266:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r11.Y
            r0 = r0[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r12.Y
            int r2 = r40 + 1
            r1 = r1[r2]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f4183f
            if (r0 == 0) goto L_0x0278
            androidx.constraintlayout.core.SolverVariable r0 = r0.f4186i
            r3 = r0
            goto L_0x027a
        L_0x0278:
            r3 = r21
        L_0x027a:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r1.f4183f
            if (r0 == 0) goto L_0x0282
            androidx.constraintlayout.core.SolverVariable r0 = r0.f4186i
            r5 = r0
            goto L_0x0284
        L_0x0282:
            r5 = r21
        L_0x0284:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.Y
            r0 = r0[r40]
            if (r14 == 0) goto L_0x028e
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r14.Y
            r1 = r1[r2]
        L_0x028e:
            if (r3 == 0) goto L_0x04d1
            if (r5 == 0) goto L_0x04d1
            r2 = r23
            if (r10 != 0) goto L_0x029a
            float r2 = r2.q0
        L_0x0298:
            r4 = r2
            goto L_0x029d
        L_0x029a:
            float r2 = r2.r0
            goto L_0x0298
        L_0x029d:
            int r6 = r0.g()
            int r7 = r1.g()
            androidx.constraintlayout.core.SolverVariable r2 = r0.f4186i
            androidx.constraintlayout.core.SolverVariable r8 = r1.f4186i
            r10 = 7
            r0 = r38
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.c(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04d1
        L_0x02b6:
            if (r16 == 0) goto L_0x03a3
            if (r13 == 0) goto L_0x03a3
            int r1 = r0.f4171j
            if (r1 <= 0) goto L_0x02c5
            int r0 = r0.f4170i
            if (r0 != r1) goto L_0x02c5
            r24 = 1
            goto L_0x02c7
        L_0x02c5:
            r24 = 0
        L_0x02c7:
            r8 = r13
            r15 = r8
        L_0x02c9:
            if (r15 == 0) goto L_0x04d1
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r15.P0
            r0 = r0[r10]
            r7 = r0
        L_0x02d0:
            if (r7 == 0) goto L_0x02df
            int r0 = r7.l0()
            r6 = 8
            if (r0 != r6) goto L_0x02e1
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r7.P0
            r7 = r0[r10]
            goto L_0x02d0
        L_0x02df:
            r6 = 8
        L_0x02e1:
            if (r7 != 0) goto L_0x02ee
            if (r15 != r14) goto L_0x02e6
            goto L_0x02ee
        L_0x02e6:
            r22 = r7
        L_0x02e8:
            r18 = r8
            r20 = 5
            goto L_0x0393
        L_0x02ee:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r15.Y
            r0 = r0[r40]
            androidx.constraintlayout.core.SolverVariable r1 = r0.f4186i
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.f4183f
            if (r2 == 0) goto L_0x02fb
            androidx.constraintlayout.core.SolverVariable r2 = r2.f4186i
            goto L_0x02fd
        L_0x02fb:
            r2 = r21
        L_0x02fd:
            if (r8 == r15) goto L_0x0308
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r8.Y
            int r3 = r40 + 1
            r2 = r2[r3]
        L_0x0305:
            androidx.constraintlayout.core.SolverVariable r2 = r2.f4186i
            goto L_0x0315
        L_0x0308:
            if (r15 != r13) goto L_0x0315
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r11.Y
            r2 = r2[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f4183f
            if (r2 == 0) goto L_0x0313
            goto L_0x0305
        L_0x0313:
            r2 = r21
        L_0x0315:
            int r0 = r0.g()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r15.Y
            int r4 = r40 + 1
            r3 = r3[r4]
            int r3 = r3.g()
            if (r7 == 0) goto L_0x032e
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r7.Y
            r5 = r5[r40]
        L_0x0329:
            androidx.constraintlayout.core.SolverVariable r6 = r5.f4186i
            r37 = r7
            goto L_0x033b
        L_0x032e:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r12.Y
            r5 = r5[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f4183f
            if (r5 == 0) goto L_0x0337
            goto L_0x0329
        L_0x0337:
            r37 = r7
            r6 = r21
        L_0x033b:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r15.Y
            r7 = r7[r4]
            androidx.constraintlayout.core.SolverVariable r7 = r7.f4186i
            if (r5 == 0) goto L_0x0348
            int r5 = r5.g()
            int r3 = r3 + r5
        L_0x0348:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r8.Y
            r5 = r5[r4]
            int r5 = r5.g()
            int r0 = r0 + r5
            if (r1 == 0) goto L_0x038f
            if (r2 == 0) goto L_0x038f
            if (r6 == 0) goto L_0x038f
            if (r7 == 0) goto L_0x038f
            if (r15 != r13) goto L_0x0363
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.Y
            r0 = r0[r40]
            int r0 = r0.g()
        L_0x0363:
            r5 = r0
            if (r15 != r14) goto L_0x0371
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r14.Y
            r0 = r0[r4]
            int r0 = r0.g()
            r18 = r0
            goto L_0x0373
        L_0x0371:
            r18 = r3
        L_0x0373:
            if (r24 == 0) goto L_0x0378
            r19 = 8
            goto L_0x037a
        L_0x0378:
            r19 = 5
        L_0x037a:
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r38
            r3 = r5
            r5 = r6
            r20 = 5
            r6 = r7
            r22 = r37
            r7 = r18
            r18 = r8
            r8 = r19
            r0.c(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0393
        L_0x038f:
            r22 = r37
            goto L_0x02e8
        L_0x0393:
            int r0 = r15.l0()
            r8 = 8
            if (r0 == r8) goto L_0x039c
            goto L_0x039e
        L_0x039c:
            r15 = r18
        L_0x039e:
            r8 = r15
            r15 = r22
            goto L_0x02c9
        L_0x03a3:
            r8 = 8
            if (r17 == 0) goto L_0x04d1
            if (r13 == 0) goto L_0x04d1
            int r1 = r0.f4171j
            if (r1 <= 0) goto L_0x03b4
            int r0 = r0.f4170i
            if (r0 != r1) goto L_0x03b4
            r24 = 1
            goto L_0x03b6
        L_0x03b4:
            r24 = 0
        L_0x03b6:
            r7 = r13
            r15 = r7
        L_0x03b8:
            if (r15 == 0) goto L_0x047c
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r15.P0
            r0 = r0[r10]
        L_0x03be:
            if (r0 == 0) goto L_0x03cb
            int r1 = r0.l0()
            if (r1 != r8) goto L_0x03cb
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r0.P0
            r0 = r0[r10]
            goto L_0x03be
        L_0x03cb:
            if (r15 == r13) goto L_0x0465
            if (r15 == r14) goto L_0x0465
            if (r0 == 0) goto L_0x0465
            if (r0 != r14) goto L_0x03d6
            r6 = r21
            goto L_0x03d7
        L_0x03d6:
            r6 = r0
        L_0x03d7:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r15.Y
            r0 = r0[r40]
            androidx.constraintlayout.core.SolverVariable r1 = r0.f4186i
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.f4183f
            if (r2 == 0) goto L_0x03e3
            androidx.constraintlayout.core.SolverVariable r2 = r2.f4186i
        L_0x03e3:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r7.Y
            int r3 = r40 + 1
            r2 = r2[r3]
            androidx.constraintlayout.core.SolverVariable r2 = r2.f4186i
            int r0 = r0.g()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r15.Y
            r4 = r4[r3]
            int r4 = r4.g()
            if (r6 == 0) goto L_0x0410
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r6.Y
            r5 = r5[r40]
            androidx.constraintlayout.core.SolverVariable r8 = r5.f4186i
            r37 = r6
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r5.f4183f
            if (r6 == 0) goto L_0x0408
            androidx.constraintlayout.core.SolverVariable r6 = r6.f4186i
            goto L_0x040a
        L_0x0408:
            r6 = r21
        L_0x040a:
            r36 = r8
            r8 = r6
            r6 = r36
            goto L_0x0423
        L_0x0410:
            r37 = r6
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r14.Y
            r5 = r5[r40]
            if (r5 == 0) goto L_0x041b
            androidx.constraintlayout.core.SolverVariable r6 = r5.f4186i
            goto L_0x041d
        L_0x041b:
            r6 = r21
        L_0x041d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r8 = r15.Y
            r8 = r8[r3]
            androidx.constraintlayout.core.SolverVariable r8 = r8.f4186i
        L_0x0423:
            if (r5 == 0) goto L_0x042a
            int r5 = r5.g()
            int r4 = r4 + r5
        L_0x042a:
            r18 = r4
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r7.Y
            r3 = r4[r3]
            int r3 = r3.g()
            int r3 = r3 + r0
            if (r24 == 0) goto L_0x043a
            r20 = 8
            goto L_0x043c
        L_0x043a:
            r20 = 4
        L_0x043c:
            if (r1 == 0) goto L_0x045a
            if (r2 == 0) goto L_0x045a
            if (r6 == 0) goto L_0x045a
            if (r8 == 0) goto L_0x045a
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r38
            r19 = 4
            r5 = r6
            r22 = r37
            r6 = r8
            r23 = r7
            r7 = r18
            r10 = 8
            r8 = r20
            r0.c(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0462
        L_0x045a:
            r22 = r37
            r23 = r7
            r10 = 8
            r19 = 4
        L_0x0462:
            r0 = r22
            goto L_0x046b
        L_0x0465:
            r23 = r7
            r10 = 8
            r19 = 4
        L_0x046b:
            int r1 = r15.l0()
            if (r1 == r10) goto L_0x0473
            r7 = r15
            goto L_0x0475
        L_0x0473:
            r7 = r23
        L_0x0475:
            r10 = r39
            r15 = r0
            r8 = 8
            goto L_0x03b8
        L_0x047c:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.Y
            r0 = r0[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r11.Y
            r1 = r1[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f4183f
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r14.Y
            int r3 = r40 + 1
            r10 = r2[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r12.Y
            r2 = r2[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r2.f4183f
            r15 = 5
            if (r1 == 0) goto L_0x04c1
            if (r13 == r14) goto L_0x04a3
            androidx.constraintlayout.core.SolverVariable r2 = r0.f4186i
            androidx.constraintlayout.core.SolverVariable r1 = r1.f4186i
            int r0 = r0.g()
            r9.e(r2, r1, r0, r15)
            goto L_0x04c1
        L_0x04a3:
            if (r11 == 0) goto L_0x04c1
            androidx.constraintlayout.core.SolverVariable r2 = r0.f4186i
            androidx.constraintlayout.core.SolverVariable r3 = r1.f4186i
            int r4 = r0.g()
            androidx.constraintlayout.core.SolverVariable r5 = r10.f4186i
            androidx.constraintlayout.core.SolverVariable r6 = r11.f4186i
            int r7 = r10.g()
            r8 = 1056964608(0x3f000000, float:0.5)
            r0 = r38
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r8
            r8 = r15
            r0.c(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x04c1:
            if (r11 == 0) goto L_0x04d1
            if (r13 == r14) goto L_0x04d1
            androidx.constraintlayout.core.SolverVariable r0 = r10.f4186i
            androidx.constraintlayout.core.SolverVariable r1 = r11.f4186i
            int r2 = r10.g()
            int r2 = -r2
            r9.e(r0, r1, r2, r15)
        L_0x04d1:
            if (r16 != 0) goto L_0x04d5
            if (r17 == 0) goto L_0x052e
        L_0x04d5:
            if (r13 == 0) goto L_0x052e
            if (r13 == r14) goto L_0x052e
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.Y
            r1 = r0[r40]
            if (r14 != 0) goto L_0x04e0
            r14 = r13
        L_0x04e0:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r14.Y
            r3 = 1
            int r3 = r40 + 1
            r2 = r2[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r1.f4183f
            if (r4 == 0) goto L_0x04ee
            androidx.constraintlayout.core.SolverVariable r4 = r4.f4186i
            goto L_0x04f0
        L_0x04ee:
            r4 = r21
        L_0x04f0:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.f4183f
            if (r5 == 0) goto L_0x04f7
            androidx.constraintlayout.core.SolverVariable r5 = r5.f4186i
            goto L_0x04f9
        L_0x04f7:
            r5 = r21
        L_0x04f9:
            if (r12 == r14) goto L_0x0509
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r12.Y
            r5 = r5[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f4183f
            if (r5 == 0) goto L_0x0507
            androidx.constraintlayout.core.SolverVariable r5 = r5.f4186i
            r21 = r5
        L_0x0507:
            r5 = r21
        L_0x0509:
            if (r13 != r14) goto L_0x050d
            r2 = r0[r3]
        L_0x050d:
            if (r4 == 0) goto L_0x052e
            if (r5 == 0) goto L_0x052e
            int r6 = r1.g()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r14.Y
            r0 = r0[r3]
            int r7 = r0.g()
            androidx.constraintlayout.core.SolverVariable r1 = r1.f4186i
            androidx.constraintlayout.core.SolverVariable r8 = r2.f4186i
            r10 = 5
            r11 = 1056964608(0x3f000000, float:0.5)
            r0 = r38
            r2 = r4
            r3 = r6
            r4 = r11
            r6 = r8
            r8 = r10
            r0.c(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x052e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Chain.a(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.LinearSystem, int, int, androidx.constraintlayout.core.widgets.ChainHead):void");
    }

    public static void b(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i2) {
        int i3;
        ChainHead[] chainHeadArr;
        int i4;
        if (i2 == 0) {
            i4 = constraintWidgetContainer.M1;
            chainHeadArr = constraintWidgetContainer.P1;
            i3 = 0;
        } else {
            i4 = constraintWidgetContainer.N1;
            chainHeadArr = constraintWidgetContainer.O1;
            i3 = 2;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
            chainHead.a();
            if (arrayList == null || arrayList.contains(chainHead.f4162a)) {
                a(constraintWidgetContainer, linearSystem, i2, i3, chainHead);
            }
        }
    }
}
