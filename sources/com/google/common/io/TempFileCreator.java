package com.google.common.io;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.StandardSystemProperty;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryFlag;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.FileAttribute;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import org.threeten.bp.chrono.HijrahDate;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
abstract class TempFileCreator {

    /* renamed from: a  reason: collision with root package name */
    static final TempFileCreator f22799a = c();

    private static final class JavaIoCreator extends TempFileCreator {

        /* renamed from: b  reason: collision with root package name */
        private static final int f22800b = 10000;

        private JavaIoCreator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public File a() {
            File file = new File(StandardSystemProperty.JAVA_IO_TMPDIR.c());
            String str = System.currentTimeMillis() + "-";
            for (int i2 = 0; i2 < 10000; i2++) {
                File file2 = new File(file, str + i2);
                if (file2.mkdir()) {
                    return file2;
                }
            }
            throw new IllegalStateException("Failed to create directory within 10000 attempts (tried " + str + "0 to " + str + HijrahDate.f3 + ASCIIPropertyListParser.f18650h);
        }

        /* access modifiers changed from: package-private */
        public File b(String str) throws IOException {
            return File.createTempFile(str, (String) null, (File) null);
        }
    }

    @IgnoreJRERequirement
    private static final class JavaNioCreator extends TempFileCreator {

        /* renamed from: b  reason: collision with root package name */
        private static final PermissionSupplier f22801b;

        /* renamed from: c  reason: collision with root package name */
        private static final PermissionSupplier f22802c;

        @IgnoreJRERequirement
        private interface PermissionSupplier {
            FileAttribute<?> get() throws IOException;
        }

        static {
            PermissionSupplier permissionSupplier;
            Set a2 = FileSystems.getDefault().supportedFileAttributeViews();
            if (a2.contains("posix")) {
                f22801b = new u();
                f22802c = new v();
                return;
            }
            if (a2.contains("acl")) {
                permissionSupplier = q();
            } else {
                new w
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0032: CONSTRUCTOR  (r0v3 ? I:com.google.common.io.w) =  call: com.google.common.io.w.<init>():void type: CONSTRUCTOR in method: com.google.common.io.TempFileCreator.JavaNioCreator.<clinit>():void, dex: classes2.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v3 ?
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	... 53 more
                    */
                /*
                    java.nio.file.FileSystem r0 = java.nio.file.FileSystems.getDefault()
                    java.util.Set r0 = r0.supportedFileAttributeViews()
                    java.lang.String r1 = "posix"
                    boolean r1 = r0.contains(r1)
                    if (r1 == 0) goto L_0x001f
                    com.google.common.io.u r0 = new com.google.common.io.u
                    r0.<init>()
                    f22801b = r0
                    com.google.common.io.v r0 = new com.google.common.io.v
                    r0.<init>()
                    f22802c = r0
                    goto L_0x0036
                L_0x001f:
                    java.lang.String r1 = "acl"
                    boolean r0 = r0.contains(r1)
                    if (r0 == 0) goto L_0x0030
                    com.google.common.io.TempFileCreator$JavaNioCreator$PermissionSupplier r0 = q()
                L_0x002b:
                    f22802c = r0
                    f22801b = r0
                    goto L_0x0036
                L_0x0030:
                    com.google.common.io.w r0 = new com.google.common.io.w
                    r0.<init>()
                    goto L_0x002b
                L_0x0036:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.TempFileCreator.JavaNioCreator.<clinit>():void");
            }

            private JavaNioCreator() {
                super();
            }

            private static String k() {
                String c2 = StandardSystemProperty.USER_NAME.c();
                Objects.requireNonNull(c2);
                try {
                    Class<?> cls = Class.forName("java.lang.ProcessHandle");
                    Class<?> cls2 = Class.forName("java.lang.ProcessHandle$Info");
                    Class<?> cls3 = Class.forName("java.util.Optional");
                    Method method = cls.getMethod("current", (Class[]) null);
                    Method method2 = cls.getMethod("info", (Class[]) null);
                    Method method3 = cls2.getMethod("user", (Class[]) null);
                    Object invoke = cls3.getMethod("orElse", new Class[]{Object.class}).invoke(method3.invoke(method2.invoke(method.invoke((Object) null, (Object[]) null), (Object[]) null), (Object[]) null), new Object[]{c2});
                    Objects.requireNonNull(invoke);
                    return (String) invoke;
                } catch (ClassNotFoundException unused) {
                    return c2;
                } catch (InvocationTargetException e2) {
                    Throwables.w(e2.getCause());
                    return c2;
                } catch (IllegalAccessException | NoSuchMethodException unused2) {
                    return c2;
                }
            }

            /* access modifiers changed from: private */
            public static /* synthetic */ FileAttribute n() throws IOException {
                throw new IOException("unrecognized FileSystem type " + FileSystems.getDefault());
            }

            /* access modifiers changed from: private */
            public static /* synthetic */ FileAttribute o(FileAttribute fileAttribute) throws IOException {
                return fileAttribute;
            }

            /* access modifiers changed from: private */
            public static /* synthetic */ FileAttribute p(IOException iOException) throws IOException {
                throw new IOException("Could not find user", iOException);
            }

            /* access modifiers changed from: private */
            public static PermissionSupplier q() {
                try {
                    final ImmutableList K = ImmutableList.K(AclEntry.newBuilder().setType(AclEntryType.ALLOW).setPrincipal(FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName(k())).setPermissions(EnumSet.allOf(i.a())).setFlags(new AclEntryFlag[]{AclEntryFlag.DIRECTORY_INHERIT, AclEntryFlag.FILE_INHERIT}).build());
                    return new x(new FileAttribute<ImmutableList<AclEntry>>() {
                        /* renamed from: a */
                        public ImmutableList<AclEntry> value() {
                            return ImmutableList.this;
                        }

                        public String name() {
                            return "acl:acl";
                        }
                    });
                } catch (IOException e2) {
                    return new y(e2);
                }
            }

            /* access modifiers changed from: package-private */
            public File a() {
                try {
                    return Files.createTempDirectory(Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.c(), new String[0]), (String) null, new FileAttribute[]{f22802c.get()}).toFile();
                } catch (IOException e2) {
                    throw new IllegalStateException("Failed to create directory", e2);
                }
            }

            /* access modifiers changed from: package-private */
            public File b(String str) throws IOException {
                return Files.createTempFile(Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.c(), new String[0]), str, (String) null, new FileAttribute[]{f22801b.get()}).toFile();
            }
        }

        private static final class ThrowingCreator extends TempFileCreator {

            /* renamed from: b  reason: collision with root package name */
            private static final String f22804b = "Guava cannot securely create temporary files or directories under SDK versions before Jelly Bean. You can create one yourself, either in the insecure default directory or in a more secure directory, such as context.getCacheDir(). For more information, see the Javadoc for Files.createTempDir().";

            private ThrowingCreator() {
                super();
            }

            /* access modifiers changed from: package-private */
            public File a() {
                throw new IllegalStateException(f22804b);
            }

            /* access modifiers changed from: package-private */
            public File b(String str) throws IOException {
                throw new IOException(f22804b);
            }
        }

        private TempFileCreator() {
        }

        private static TempFileCreator c() {
            try {
                Class.forName("java.nio.file.Path");
                return new JavaNioCreator();
            } catch (ClassNotFoundException unused) {
                try {
                    return ((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get((Object) null)).intValue() < ((Integer) Class.forName("android.os.Build$VERSION_CODES").getField("JELLY_BEAN").get((Object) null)).intValue() ? new ThrowingCreator() : new JavaIoCreator();
                } catch (NoSuchFieldException unused2) {
                    return new ThrowingCreator();
                } catch (ClassNotFoundException unused3) {
                    return new ThrowingCreator();
                } catch (IllegalAccessException unused4) {
                    return new ThrowingCreator();
                }
            }
        }

        @IgnoreJRERequirement
        @VisibleForTesting
        static void d() throws IOException {
            JavaNioCreator.q().get();
        }

        /* access modifiers changed from: package-private */
        public abstract File a();

        /* access modifiers changed from: package-private */
        public abstract File b(String str) throws IOException;
    }
