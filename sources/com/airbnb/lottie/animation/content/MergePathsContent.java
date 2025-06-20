package com.airbnb.lottie.animation.content;

import android.annotation.TargetApi;
import android.graphics.Path;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
public class MergePathsContent implements PathContent, GreedyContent {

    /* renamed from: a  reason: collision with root package name */
    private final Path f16982a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f16983b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f16984c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final String f16985d;

    /* renamed from: e  reason: collision with root package name */
    private final List<PathContent> f16986e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final MergePaths f16987f;

    /* renamed from: com.airbnb.lottie.animation.content.MergePathsContent$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16988a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode[] r0 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16988a = r0
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.MERGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f16988a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.ADD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f16988a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.SUBTRACT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f16988a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.INTERSECT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f16988a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.MergePathsContent.AnonymousClass1.<clinit>():void");
        }
    }

    public MergePathsContent(MergePaths mergePaths) {
        this.f16985d = mergePaths.c();
        this.f16987f = mergePaths;
    }

    private void a() {
        for (int i2 = 0; i2 < this.f16986e.size(); i2++) {
            this.f16984c.addPath(this.f16986e.get(i2).getPath());
        }
    }

    @TargetApi(19)
    private void c(Path.Op op) {
        this.f16983b.reset();
        this.f16982a.reset();
        for (int size = this.f16986e.size() - 1; size >= 1; size--) {
            PathContent pathContent = this.f16986e.get(size);
            if (pathContent instanceof ContentGroup) {
                ContentGroup contentGroup = (ContentGroup) pathContent;
                List<PathContent> i2 = contentGroup.i();
                for (int size2 = i2.size() - 1; size2 >= 0; size2--) {
                    Path path = i2.get(size2).getPath();
                    path.transform(contentGroup.j());
                    this.f16983b.addPath(path);
                }
            } else {
                this.f16983b.addPath(pathContent.getPath());
            }
        }
        PathContent pathContent2 = this.f16986e.get(0);
        if (pathContent2 instanceof ContentGroup) {
            ContentGroup contentGroup2 = (ContentGroup) pathContent2;
            List<PathContent> i3 = contentGroup2.i();
            for (int i4 = 0; i4 < i3.size(); i4++) {
                Path path2 = i3.get(i4).getPath();
                path2.transform(contentGroup2.j());
                this.f16982a.addPath(path2);
            }
        } else {
            this.f16982a.set(pathContent2.getPath());
        }
        this.f16984c.op(this.f16982a, this.f16983b, op);
    }

    public void b(List<Content> list, List<Content> list2) {
        for (int i2 = 0; i2 < this.f16986e.size(); i2++) {
            this.f16986e.get(i2).b(list, list2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(java.util.ListIterator<com.airbnb.lottie.animation.content.Content> r3) {
        /*
            r2 = this;
        L_0x0000:
            boolean r0 = r3.hasPrevious()
            if (r0 == 0) goto L_0x000d
            java.lang.Object r0 = r3.previous()
            if (r0 == r2) goto L_0x000d
            goto L_0x0000
        L_0x000d:
            boolean r0 = r3.hasPrevious()
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r3.previous()
            com.airbnb.lottie.animation.content.Content r0 = (com.airbnb.lottie.animation.content.Content) r0
            boolean r1 = r0 instanceof com.airbnb.lottie.animation.content.PathContent
            if (r1 == 0) goto L_0x000d
            java.util.List<com.airbnb.lottie.animation.content.PathContent> r1 = r2.f16986e
            com.airbnb.lottie.animation.content.PathContent r0 = (com.airbnb.lottie.animation.content.PathContent) r0
            r1.add(r0)
            r3.remove()
            goto L_0x000d
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.MergePathsContent.e(java.util.ListIterator):void");
    }

    public String getName() {
        return this.f16985d;
    }

    public Path getPath() {
        Path.Op op;
        this.f16984c.reset();
        if (this.f16987f.d()) {
            return this.f16984c;
        }
        int i2 = AnonymousClass1.f16988a[this.f16987f.b().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                op = Path.Op.UNION;
            } else if (i2 == 3) {
                op = Path.Op.REVERSE_DIFFERENCE;
            } else if (i2 == 4) {
                op = Path.Op.INTERSECT;
            } else if (i2 == 5) {
                op = Path.Op.XOR;
            }
            c(op);
        } else {
            a();
        }
        return this.f16984c;
    }
}
