package net.imedicaldoctor.imd;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.SequenceInputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Data.UnzipCompleted;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.progress.ProgressMonitor;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

public class Decompress {

    /* renamed from: a  reason: collision with root package name */
    private final String f29606a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29607b;

    /* renamed from: c  reason: collision with root package name */
    Context f29608c;

    /* renamed from: d  reason: collision with root package name */
    CompressHelper f29609d;

    public Decompress(String str, String str2, Context context) {
        this.f29606a = str;
        this.f29607b = str2;
        this.f29608c = context;
        this.f29609d = new CompressHelper(context);
        b("");
    }

    private void b(String str) {
        File file = new File(this.f29607b + str);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
    }

    public static byte[] c(String str, String str2) {
        ZipInputStream zipInputStream;
        ZipEntry nextEntry;
        try {
            BufferedSource e2 = Okio.e(Okio.t(new File(str)));
            try {
                zipInputStream = new ZipInputStream(e2.z());
                do {
                    nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        zipInputStream.close();
                        e2.close();
                        return null;
                    }
                } while (!nextEntry.getName().equals(str2));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        zipInputStream.close();
                        e2.close();
                        return byteArray;
                    }
                }
            } catch (Throwable th) {
                if (e2 != null) {
                    e2.close();
                }
                throw th;
            }
            throw th;
        } catch (Exception e3) {
            FirebaseCrashlytics.d().g(e3);
            iMDLogger.f("Error in unzip", e3.getLocalizedMessage());
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    public static byte[] d(String str, String str2, Bundle bundle) {
        Date date = new Date();
        try {
            Vector vector = new Vector(10);
            for (int i2 = 1; i2 < 11; i2++) {
                vector.add(new FileInputStream(str + "." + i2));
            }
            SequenceInputStream sequenceInputStream = new SequenceInputStream(vector.elements());
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(sequenceInputStream));
            String str3 = "";
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    } else if (!nextEntry.isDirectory()) {
                        nextEntry.getName().toLowerCase().endsWith(str2);
                    } else if (str3.length() == 0) {
                        str3 = nextEntry.getName();
                    }
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                    return null;
                }
            }
            zipInputStream.close();
            sequenceInputStream.close();
            Iterator it2 = vector.iterator();
            while (it2.hasNext()) {
                try {
                    ((FileInputStream) it2.next()).close();
                } catch (Exception unused) {
                }
            }
            long seconds = TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - date.getTime());
            iMDLogger.f("Found file", "In " + seconds + " Seconds");
        } catch (Exception e3) {
            FirebaseCrashlytics.d().g(e3);
            iMDLogger.f("Error in unzip", e3.getLocalizedMessage() + " in " + "");
            e3.printStackTrace();
        }
        return null;
    }

    public static Observable<byte[]> e(final String str, final String str2) {
        return Observable.w1(new ObservableOnSubscribe<byte[]>() {
            public void a(@NonNull ObservableEmitter<byte[]> observableEmitter) throws Throwable {
                ZipEntry nextEntry;
                try {
                    ZipInputStream zipInputStream = new ZipInputStream(Okio.e(Okio.t(new File(str))).z());
                    do {
                        nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            observableEmitter.onError(new FileNotFoundException("Resource not found: " + str2));
                            return;
                        }
                    } while (!nextEntry.getName().equals(str2));
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    BufferedSink d2 = Okio.d(Okio.p(byteArrayOutputStream));
                    BufferedSource e2 = Okio.e(Okio.u(zipInputStream));
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = e2.read(bArr);
                        if (read != -1) {
                            d2.write(bArr, 0, read);
                        } else {
                            d2.flush();
                            observableEmitter.onNext(byteArrayOutputStream.toByteArray());
                            observableEmitter.onComplete();
                            return;
                        }
                    }
                } catch (Exception e3) {
                    observableEmitter.onError(e3);
                    iMDLogger.f("Error in unzip", e3.getLocalizedMessage());
                }
            }
        });
    }

    public static void f(String str, String str2, UnzipCompleted unzipCompleted) {
        ZipInputStream zipInputStream;
        try {
            zipInputStream = new ZipInputStream(new FileInputStream(str));
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    unzipCompleted.a("Can't find file " + str2 + " in " + str);
                    break;
                } else if (nextEntry.getName().equals(str2)) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    unzipCompleted.b(byteArrayOutputStream.toByteArray());
                }
            }
            zipInputStream.close();
            return;
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("Error in unzip", e2.getLocalizedMessage());
            unzipCompleted.a(e2.getLocalizedMessage());
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void a(File file) {
        try {
            file.setReadable(true, false);
        } catch (Exception unused) {
            Log.e("Error", "Error");
        }
    }

    public String g(ObservableEmitter<Bundle> observableEmitter, String str) {
        try {
            ZipFile zipFile = new ZipFile(this.f29606a);
            if (zipFile.D()) {
                zipFile.R("imedicaldoctor".toCharArray());
            }
            Bundle bundle = new Bundle();
            bundle.putString("progress", "");
            bundle.putString("labelText", str);
            zipFile.S(true);
            ProgressMonitor A = zipFile.A();
            zipFile.o(this.f29607b);
            String str2 = "";
            while (A.i() == ProgressMonitor.State.BUSY) {
                PrintStream printStream = System.out;
                printStream.println("Percent Done: " + A.g());
                printStream.println("File: " + A.f());
                String format = String.format(TimeModel.b3, new Object[]{Integer.valueOf(A.g())});
                if (!format.equals(str2)) {
                    iMDLogger.f("Decompress", "Percent : " + format);
                    bundle.remove("progress");
                    bundle.putString("progress", format);
                    observableEmitter.onNext(bundle);
                    str2 = format;
                }
            }
            if (A.h() == ProgressMonitor.Result.SUCCESS) {
                return "0";
            }
            A.e().printStackTrace();
            return "0";
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("Error in unzip", e2.getLocalizedMessage() + " in " + "");
            e2.printStackTrace();
            return e2.getLocalizedMessage() + " in " + "";
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v24, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v25, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v18, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v35, resolved type: net.lingala.zip4j.io.inputstream.ZipInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v20, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v22, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v21, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v35, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v36, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v23, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v37, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v32, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v39, resolved type: net.lingala.zip4j.io.inputstream.ZipInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v47, resolved type: net.lingala.zip4j.io.inputstream.ZipInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v41, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v42, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v43, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v40, resolved type: net.lingala.zip4j.io.inputstream.ZipInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v49, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v51, resolved type: net.lingala.zip4j.io.inputstream.ZipInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v53, resolved type: net.lingala.zip4j.io.inputstream.ZipInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v55, resolved type: net.lingala.zip4j.io.inputstream.ZipInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v57, resolved type: net.lingala.zip4j.io.inputstream.ZipInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v59, resolved type: net.lingala.zip4j.io.inputstream.ZipInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v41, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v42, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v45, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v43, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v45, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v47, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v49, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v46, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v51, resolved type: java.util.Date} */
    /* JADX WARNING: type inference failed for: r2v27 */
    /* JADX WARNING: type inference failed for: r8v15 */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: type inference failed for: r7v32 */
    /* JADX WARNING: type inference failed for: r2v38 */
    /* JADX WARNING: type inference failed for: r8v33 */
    /* JADX WARNING: type inference failed for: r8v34 */
    /* JADX WARNING: type inference failed for: r7v50 */
    /* JADX WARNING: type inference failed for: r7v52 */
    /* JADX WARNING: type inference failed for: r7v54 */
    /* JADX WARNING: type inference failed for: r7v56 */
    /* JADX WARNING: type inference failed for: r8v35 */
    /* JADX WARNING: type inference failed for: r8v37 */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0156, code lost:
        if (r7 == false) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0158, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x015d, code lost:
        if (r3 >= r8.size()) goto L_0x0179;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x015f, code lost:
        r14 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r36.f29609d.j(((android.os.Bundle) r8.get(r3)).getString(r14));
        r3 = r3 + 1;
        r27 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0179, code lost:
        r1 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x017c, code lost:
        r1 = r36;
        r14 = r27;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0185, code lost:
        if (r3 >= r24.size()) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0187, code lost:
        r2 = r24;
        r1.f29609d.j(((android.os.Bundle) r2.get(r3)).getString(r14));
        r3 = r3 + 1;
        r24 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x019d, code lost:
        r12.close();
        net.imedicaldoctor.imd.iMDLogger.f("Zip Completed", "In " + java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(new java.util.Date().getTime() - r18.getTime()) + " Seconds");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01d1, code lost:
        return "0";
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String h(io.reactivex.rxjava3.core.ObservableEmitter<android.os.Bundle> r37, java.lang.String r38, android.app.Activity r39) {
        /*
            r36 = this;
            r1 = r36
            r2 = r37
            java.lang.String r5 = "/"
            java.lang.String r6 = "progress"
            java.lang.String r7 = ""
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ Exception -> 0x0480 }
            r8.<init>()     // Catch:{ Exception -> 0x0480 }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x0480 }
            r9.<init>()     // Catch:{ Exception -> 0x0480 }
            java.util.Vector r0 = new java.util.Vector     // Catch:{ Exception -> 0x0480 }
            r10 = 10
            r0.<init>(r10)     // Catch:{ Exception -> 0x0480 }
            r10 = 0
            r12 = 1
        L_0x001e:
            r13 = 11
            java.lang.String r14 = "offset"
            java.lang.String r15 = "filePath"
            if (r12 >= r13) goto L_0x0066
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0063 }
            r13.<init>()     // Catch:{ Exception -> 0x0063 }
            java.lang.String r3 = r1.f29606a     // Catch:{ Exception -> 0x0063 }
            r13.append(r3)     // Catch:{ Exception -> 0x0063 }
            java.lang.String r3 = "."
            r13.append(r3)     // Catch:{ Exception -> 0x0063 }
            r13.append(r12)     // Catch:{ Exception -> 0x0063 }
            java.lang.String r3 = r13.toString()     // Catch:{ Exception -> 0x0063 }
            android.os.Bundle r13 = new android.os.Bundle     // Catch:{ Exception -> 0x0063 }
            r13.<init>()     // Catch:{ Exception -> 0x0063 }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0063 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0063 }
            long r17 = r4.length()     // Catch:{ Exception -> 0x0063 }
            long r10 = r10 + r17
            r13.putString(r15, r3)     // Catch:{ Exception -> 0x0063 }
            r13.putLong(r14, r10)     // Catch:{ Exception -> 0x0063 }
            r8.add(r13)     // Catch:{ Exception -> 0x0063 }
            r9.add(r13)     // Catch:{ Exception -> 0x0063 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0063 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0063 }
            r0.add(r4)     // Catch:{ Exception -> 0x0063 }
            r3 = 1
            int r12 = r12 + r3
            goto L_0x001e
        L_0x0063:
            r0 = move-exception
            goto L_0x0483
        L_0x0066:
            java.util.Enumeration r0 = r0.elements()     // Catch:{ Exception -> 0x0480 }
            java.io.SequenceInputStream r3 = new java.io.SequenceInputStream     // Catch:{ Exception -> 0x0480 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0480 }
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0480 }
            r4 = 131072(0x20000, float:1.83671E-40)
            r0.<init>(r3, r4)     // Catch:{ Exception -> 0x0480 }
            com.google.common.io.CountingInputStream r3 = new com.google.common.io.CountingInputStream     // Catch:{ Exception -> 0x0480 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0480 }
            java.lang.String r0 = r1.f29606a     // Catch:{ Exception -> 0x0480 }
            java.lang.String r12 = ".zipp"
            boolean r0 = r0.contains(r12)     // Catch:{ Exception -> 0x0480 }
            if (r0 == 0) goto L_0x0092
            net.lingala.zip4j.io.inputstream.ZipInputStream r0 = new net.lingala.zip4j.io.inputstream.ZipInputStream     // Catch:{ Exception -> 0x0063 }
            java.lang.String r12 = "imedicaldoctor"
            char[] r12 = r12.toCharArray()     // Catch:{ Exception -> 0x0063 }
            r0.<init>((java.io.InputStream) r3, (char[]) r12)     // Catch:{ Exception -> 0x0063 }
        L_0x0090:
            r12 = r0
            goto L_0x0098
        L_0x0092:
            net.lingala.zip4j.io.inputstream.ZipInputStream r0 = new net.lingala.zip4j.io.inputstream.ZipInputStream     // Catch:{ Exception -> 0x0480 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0480 }
            goto L_0x0090
        L_0x0098:
            java.util.Date r0 = new java.util.Date     // Catch:{ Exception -> 0x0480 }
            r0.<init>()     // Catch:{ Exception -> 0x0480 }
            java.util.Date r13 = new java.util.Date     // Catch:{ Exception -> 0x0480 }
            r13.<init>()     // Catch:{ Exception -> 0x0480 }
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ Exception -> 0x0480 }
            r4.<init>()     // Catch:{ Exception -> 0x0480 }
            r4.putString(r6, r7)     // Catch:{ Exception -> 0x0480 }
            r18 = r0
            java.lang.String r0 = "labelText"
            r19 = r7
            r7 = r38
            r4.putString(r0, r7)     // Catch:{ Exception -> 0x0177 }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0177 }
            java.lang.String r7 = r1.f29607b     // Catch:{ Exception -> 0x0177 }
            r0.<init>(r7)     // Catch:{ Exception -> 0x0177 }
            android.content.Context r0 = r1.f29608c     // Catch:{ Exception -> 0x0177 }
            java.lang.String r7 = "default_preferences"
            r20 = r5
            r5 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r7, r5)     // Catch:{ Exception -> 0x0177 }
            java.lang.String r7 = "lessspace"
            boolean r7 = r0.getBoolean(r7, r5)     // Catch:{ Exception -> 0x0177 }
            java.lang.Object r0 = r8.get(r5)     // Catch:{ Exception -> 0x0177 }
            android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ Exception -> 0x0177 }
            long r21 = r0.getLong(r14)     // Catch:{ Exception -> 0x0177 }
            r0 = r18
        L_0x00d9:
            java.util.Date r5 = new java.util.Date     // Catch:{ Exception -> 0x0177 }
            r5.<init>()     // Catch:{ Exception -> 0x0177 }
            long r23 = r5.getTime()     // Catch:{ Exception -> 0x0177 }
            long r25 = r0.getTime()     // Catch:{ Exception -> 0x0177 }
            r18 = r13
            r5 = r14
            long r13 = r23 - r25
            r38 = r0
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0177 }
            long r13 = r0.toSeconds(r13)     // Catch:{ Exception -> 0x0177 }
            r23 = r5
            r5 = 1
            long r0 = (long) r5
            java.lang.String r5 = "Percent : "
            r24 = r9
            java.lang.String r9 = "%.2f"
            r25 = 4636737291354636288(0x4059000000000000, double:100.0)
            r27 = r15
            java.lang.String r15 = "Decompress"
            int r28 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r28 <= 0) goto L_0x014c
            long r13 = r3.b()     // Catch:{ Exception -> 0x013e }
            double r13 = (double) r13     // Catch:{ Exception -> 0x013e }
            r29 = r0
            double r0 = (double) r10     // Catch:{ Exception -> 0x013e }
            double r13 = r13 / r0
            double r13 = r13 * r25
            java.lang.Double r0 = java.lang.Double.valueOf(r13)     // Catch:{ Exception -> 0x013e }
            r1 = 1
            java.lang.Object[] r13 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x013e }
            r1 = 0
            r13[r1] = r0     // Catch:{ Exception -> 0x013e }
            java.lang.String r0 = java.lang.String.format(r9, r13)     // Catch:{ Exception -> 0x013e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013e }
            r1.<init>()     // Catch:{ Exception -> 0x013e }
            r1.append(r5)     // Catch:{ Exception -> 0x013e }
            r1.append(r0)     // Catch:{ Exception -> 0x013e }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x013e }
            net.imedicaldoctor.imd.iMDLogger.f(r15, r1)     // Catch:{ Exception -> 0x013e }
            r4.remove(r6)     // Catch:{ Exception -> 0x013e }
            r4.putString(r6, r0)     // Catch:{ Exception -> 0x013e }
            if (r2 == 0) goto L_0x0145
            r2.onNext(r4)     // Catch:{ Exception -> 0x013e }
            goto L_0x0145
        L_0x013e:
            r0 = move-exception
            r1 = r36
        L_0x0141:
            r7 = r19
            goto L_0x0483
        L_0x0145:
            java.util.Date r0 = new java.util.Date     // Catch:{ Exception -> 0x013e }
            r0.<init>()     // Catch:{ Exception -> 0x013e }
            r1 = r0
            goto L_0x0150
        L_0x014c:
            r29 = r0
            r1 = r38
        L_0x0150:
            net.lingala.zip4j.model.LocalFileHeader r13 = r12.h()     // Catch:{ Exception -> 0x0437 }
            if (r13 != 0) goto L_0x01d2
            if (r7 == 0) goto L_0x017c
            r3 = 0
        L_0x0159:
            int r0 = r8.size()     // Catch:{ Exception -> 0x013e }
            if (r3 >= r0) goto L_0x0179
            java.lang.Object r0 = r8.get(r3)     // Catch:{ Exception -> 0x013e }
            android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ Exception -> 0x013e }
            r14 = r27
            java.lang.String r0 = r0.getString(r14)     // Catch:{ Exception -> 0x013e }
            r1 = r36
            net.imedicaldoctor.imd.Data.CompressHelper r2 = r1.f29609d     // Catch:{ Exception -> 0x0177 }
            r2.j(r0)     // Catch:{ Exception -> 0x0177 }
            r2 = 1
            int r3 = r3 + r2
            r27 = r14
            goto L_0x0159
        L_0x0177:
            r0 = move-exception
            goto L_0x0141
        L_0x0179:
            r1 = r36
            goto L_0x019d
        L_0x017c:
            r1 = r36
            r14 = r27
            r3 = 0
        L_0x0181:
            int r0 = r24.size()     // Catch:{ Exception -> 0x0177 }
            if (r3 >= r0) goto L_0x019d
            r2 = r24
            java.lang.Object r0 = r2.get(r3)     // Catch:{ Exception -> 0x0177 }
            android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ Exception -> 0x0177 }
            java.lang.String r0 = r0.getString(r14)     // Catch:{ Exception -> 0x0177 }
            net.imedicaldoctor.imd.Data.CompressHelper r4 = r1.f29609d     // Catch:{ Exception -> 0x0177 }
            r4.j(r0)     // Catch:{ Exception -> 0x0177 }
            r4 = 1
            int r3 = r3 + r4
            r24 = r2
            goto L_0x0181
        L_0x019d:
            r12.close()     // Catch:{ Exception -> 0x0177 }
            java.util.Date r0 = new java.util.Date     // Catch:{ Exception -> 0x0177 }
            r0.<init>()     // Catch:{ Exception -> 0x0177 }
            long r2 = r0.getTime()     // Catch:{ Exception -> 0x0177 }
            long r4 = r18.getTime()     // Catch:{ Exception -> 0x0177 }
            long r2 = r2 - r4
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0177 }
            long r2 = r0.toSeconds(r2)     // Catch:{ Exception -> 0x0177 }
            java.lang.String r0 = "Zip Completed"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0177 }
            r4.<init>()     // Catch:{ Exception -> 0x0177 }
            java.lang.String r5 = "In "
            r4.append(r5)     // Catch:{ Exception -> 0x0177 }
            r4.append(r2)     // Catch:{ Exception -> 0x0177 }
            java.lang.String r2 = " Seconds"
            r4.append(r2)     // Catch:{ Exception -> 0x0177 }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x0177 }
            net.imedicaldoctor.imd.iMDLogger.f(r0, r2)     // Catch:{ Exception -> 0x0177 }
            java.lang.String r0 = "0"
            return r0
        L_0x01d2:
            r38 = r1
            r14 = r27
            r27 = r29
            r1 = r36
            long r29 = r3.b()     // Catch:{ Exception -> 0x0177 }
            int r0 = (r29 > r21 ? 1 : (r29 == r21 ? 0 : -1))
            if (r0 <= 0) goto L_0x0205
            r2 = 0
            java.lang.Object r0 = r8.get(r2)     // Catch:{ Exception -> 0x0177 }
            android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ Exception -> 0x0177 }
            java.lang.String r0 = r0.getString(r14)     // Catch:{ Exception -> 0x0177 }
            if (r7 == 0) goto L_0x01f4
            net.imedicaldoctor.imd.Data.CompressHelper r2 = r1.f29609d     // Catch:{ Exception -> 0x0177 }
            r2.j(r0)     // Catch:{ Exception -> 0x0177 }
        L_0x01f4:
            r2 = 0
            r8.remove(r2)     // Catch:{ Exception -> 0x0177 }
            java.lang.Object r0 = r8.get(r2)     // Catch:{ Exception -> 0x0177 }
            android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ Exception -> 0x0177 }
            r2 = r23
            long r21 = r0.getLong(r2)     // Catch:{ Exception -> 0x0177 }
            goto L_0x0207
        L_0x0205:
            r2 = r23
        L_0x0207:
            boolean r0 = r13.t()     // Catch:{ Exception -> 0x0177 }
            if (r0 == 0) goto L_0x0222
            java.lang.String r0 = r13.k()     // Catch:{ Exception -> 0x0177 }
            r1.b(r0)     // Catch:{ Exception -> 0x0177 }
            r0 = r38
            r13 = r2
            r2 = r12
            r17 = r20
            r20 = r7
            r12 = r8
            r8 = r14
            r7 = r37
            goto L_0x0422
        L_0x0222:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0177 }
            r0.<init>()     // Catch:{ Exception -> 0x0177 }
            r23 = r2
            java.lang.String r2 = r1.f29607b     // Catch:{ Exception -> 0x0177 }
            r0.append(r2)     // Catch:{ Exception -> 0x0177 }
            r2 = r20
            r0.append(r2)     // Catch:{ Exception -> 0x0177 }
            r20 = r7
            java.lang.String r7 = r13.k()     // Catch:{ Exception -> 0x0177 }
            r0.append(r7)     // Catch:{ Exception -> 0x0177 }
            java.lang.String r7 = r0.toString()     // Catch:{ Exception -> 0x0177 }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0434 }
            r0.<init>(r7)     // Catch:{ Exception -> 0x0434 }
            boolean r0 = r0.exists()     // Catch:{ Exception -> 0x0434 }
            if (r0 == 0) goto L_0x0285
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0063 }
            r0.<init>()     // Catch:{ Exception -> 0x0063 }
            r29 = r14
            java.lang.String r14 = r13.k()     // Catch:{ Exception -> 0x0063 }
            r0.append(r14)     // Catch:{ Exception -> 0x0063 }
            java.lang.String r14 = " Exists"
            r0.append(r14)     // Catch:{ Exception -> 0x0063 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0063 }
            net.imedicaldoctor.imd.iMDLogger.f(r15, r0)     // Catch:{ Exception -> 0x0063 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0063 }
            r0.<init>()     // Catch:{ Exception -> 0x0063 }
            java.lang.String r14 = r13.k()     // Catch:{ Exception -> 0x0063 }
            r0.append(r14)     // Catch:{ Exception -> 0x0063 }
            java.lang.String r14 = " Different Size. Deleteing old file"
            r0.append(r14)     // Catch:{ Exception -> 0x0063 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0063 }
            net.imedicaldoctor.imd.iMDLogger.f(r15, r0)     // Catch:{ Exception -> 0x0063 }
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r1.f29609d     // Catch:{ Exception -> 0x0063 }
            r0.j(r7)     // Catch:{ Exception -> 0x0063 }
        L_0x0282:
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0288
        L_0x0285:
            r29 = r14
            goto L_0x0282
        L_0x0288:
            byte[] r0 = new byte[r14]     // Catch:{ Exception -> 0x0434 }
            java.io.FileOutputStream r14 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x03f4 }
            r19 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03e4 }
            r7.<init>()     // Catch:{ Exception -> 0x03e4 }
            r30 = r8
            java.lang.String r8 = r1.f29607b     // Catch:{ Exception -> 0x03d1 }
            r7.append(r8)     // Catch:{ Exception -> 0x03d1 }
            r7.append(r2)     // Catch:{ Exception -> 0x03d1 }
            java.lang.String r8 = r13.k()     // Catch:{ Exception -> 0x03d1 }
            r7.append(r8)     // Catch:{ Exception -> 0x03d1 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x03d1 }
            r14.<init>(r7)     // Catch:{ Exception -> 0x03d1 }
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x03d1 }
            r8 = 131072(0x20000, float:1.83671E-40)
            r7.<init>(r14, r8)     // Catch:{ Exception -> 0x03d1 }
            r14 = r38
            r17 = r2
            r31 = r13
            r2 = 0
        L_0x02b9:
            int r13 = r12.read(r0, r2, r8)     // Catch:{ Exception -> 0x03cb }
            r8 = -1
            if (r13 == r8) goto L_0x03a9
            r7.write(r0, r2, r13)     // Catch:{ Exception -> 0x03a4 }
            java.util.Date r2 = new java.util.Date     // Catch:{ Exception -> 0x03a4 }
            r2.<init>()     // Catch:{ Exception -> 0x03a4 }
            long r32 = r2.getTime()     // Catch:{ Exception -> 0x03a4 }
            long r34 = r14.getTime()     // Catch:{ Exception -> 0x03a4 }
            r2 = r12
            long r12 = r32 - r34
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x03a0 }
            long r12 = r8.toSeconds(r12)     // Catch:{ Exception -> 0x03a0 }
            int r8 = (r12 > r27 ? 1 : (r12 == r27 ? 0 : -1))
            if (r8 <= 0) goto L_0x0331
            long r12 = r3.b()     // Catch:{ Exception -> 0x032c }
            double r12 = (double) r12     // Catch:{ Exception -> 0x032c }
            r32 = r7
            double r7 = (double) r10     // Catch:{ Exception -> 0x032c }
            double r12 = r12 / r7
            double r12 = r12 * r25
            java.lang.Double r7 = java.lang.Double.valueOf(r12)     // Catch:{ Exception -> 0x032c }
            r8 = 1
            java.lang.Object[] r12 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0328 }
            r13 = 0
            r12[r13] = r7     // Catch:{ Exception -> 0x0328 }
            java.lang.String r7 = java.lang.String.format(r9, r12)     // Catch:{ Exception -> 0x0328 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0328 }
            r12.<init>()     // Catch:{ Exception -> 0x0328 }
            r12.append(r5)     // Catch:{ Exception -> 0x0328 }
            r12.append(r7)     // Catch:{ Exception -> 0x0328 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0328 }
            net.imedicaldoctor.imd.iMDLogger.f(r15, r12)     // Catch:{ Exception -> 0x0328 }
            r4.remove(r6)     // Catch:{ Exception -> 0x0328 }
            r4.putString(r6, r7)     // Catch:{ Exception -> 0x0328 }
            r7 = r37
            if (r7 == 0) goto L_0x0321
            r7.onNext(r4)     // Catch:{ Exception -> 0x0316 }
            goto L_0x0321
        L_0x0316:
            r0 = move-exception
        L_0x0317:
            r5 = r19
            r13 = r23
            r8 = r29
            r12 = r30
            goto L_0x0400
        L_0x0321:
            java.util.Date r12 = new java.util.Date     // Catch:{ Exception -> 0x0316 }
            r12.<init>()     // Catch:{ Exception -> 0x0316 }
            r14 = r12
            goto L_0x0336
        L_0x0328:
            r0 = move-exception
            r7 = r37
            goto L_0x0317
        L_0x032c:
            r0 = move-exception
            r7 = r37
            r8 = 1
            goto L_0x0317
        L_0x0331:
            r32 = r7
            r8 = 1
            r7 = r37
        L_0x0336:
            long r12 = r3.b()     // Catch:{ Exception -> 0x0398 }
            int r16 = (r12 > r21 ? 1 : (r12 == r21 ? 0 : -1))
            if (r16 <= 0) goto L_0x0392
            r12 = r30
            r13 = 0
            java.lang.Object r16 = r12.get(r13)     // Catch:{ Exception -> 0x038c }
            r13 = r16
            android.os.Bundle r13 = (android.os.Bundle) r13     // Catch:{ Exception -> 0x038c }
            r8 = r29
            java.lang.String r13 = r13.getString(r8)     // Catch:{ Exception -> 0x0388 }
            if (r20 == 0) goto L_0x0361
            r29 = r0
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r1.f29609d     // Catch:{ Exception -> 0x035a }
            r0.j(r13)     // Catch:{ Exception -> 0x035a }
        L_0x0358:
            r13 = 0
            goto L_0x0364
        L_0x035a:
            r0 = move-exception
            r5 = r19
            r13 = r23
            goto L_0x0400
        L_0x0361:
            r29 = r0
            goto L_0x0358
        L_0x0364:
            r12.remove(r13)     // Catch:{ Exception -> 0x0388 }
            java.lang.Object r0 = r12.get(r13)     // Catch:{ Exception -> 0x0388 }
            android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ Exception -> 0x0388 }
            r13 = r23
            long r21 = r0.getLong(r13)     // Catch:{ Exception -> 0x0383 }
            r30 = r12
            r23 = r13
            r0 = r29
            r7 = r32
            r12 = r2
            r29 = r8
        L_0x037e:
            r2 = 0
            r8 = 131072(0x20000, float:1.83671E-40)
            goto L_0x02b9
        L_0x0383:
            r0 = move-exception
        L_0x0384:
            r5 = r19
            goto L_0x0400
        L_0x0388:
            r0 = move-exception
            r13 = r23
            goto L_0x0384
        L_0x038c:
            r0 = move-exception
            r13 = r23
            r8 = r29
            goto L_0x0384
        L_0x0392:
            r8 = r29
            r12 = r2
            r7 = r32
            goto L_0x037e
        L_0x0398:
            r0 = move-exception
        L_0x0399:
            r13 = r23
            r8 = r29
            r12 = r30
            goto L_0x0384
        L_0x03a0:
            r0 = move-exception
            r7 = r37
            goto L_0x0399
        L_0x03a4:
            r0 = move-exception
            r7 = r37
            r2 = r12
            goto L_0x0399
        L_0x03a9:
            r32 = r7
            r2 = r12
            r13 = r23
            r8 = r29
            r12 = r30
            r7 = r37
            r32.flush()     // Catch:{ Exception -> 0x0383 }
            r32.close()     // Catch:{ Exception -> 0x0383 }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0383 }
            r5 = r19
            r0.<init>(r5)     // Catch:{ Exception -> 0x03c9 }
            r1.a(r0)     // Catch:{ Exception -> 0x03c9 }
        L_0x03c4:
            r19 = r5
            r0 = r14
            goto L_0x0422
        L_0x03c9:
            r0 = move-exception
            goto L_0x0400
        L_0x03cb:
            r0 = move-exception
            r7 = r37
            r2 = r12
            goto L_0x0317
        L_0x03d1:
            r0 = move-exception
            r7 = r37
            r17 = r2
            r2 = r12
            r31 = r13
            r5 = r19
            r13 = r23
            r8 = r29
            r12 = r30
        L_0x03e1:
            r14 = r38
            goto L_0x0400
        L_0x03e4:
            r0 = move-exception
            r7 = r37
            r17 = r2
            r2 = r12
            r31 = r13
            r5 = r19
            r13 = r23
        L_0x03f0:
            r12 = r8
            r8 = r29
            goto L_0x03e1
        L_0x03f4:
            r0 = move-exception
            r17 = r2
            r5 = r7
            r2 = r12
            r31 = r13
            r13 = r23
            r7 = r37
            goto L_0x03f0
        L_0x0400:
            com.google.firebase.crashlytics.FirebaseCrashlytics r9 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x0431 }
            r9.g(r0)     // Catch:{ Exception -> 0x0431 }
            java.lang.String r0 = "Decompress Error"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0431 }
            r9.<init>()     // Catch:{ Exception -> 0x0431 }
            java.lang.String r15 = "Can't write . "
            r9.append(r15)     // Catch:{ Exception -> 0x0431 }
            java.lang.String r15 = r31.k()     // Catch:{ Exception -> 0x0431 }
            r9.append(r15)     // Catch:{ Exception -> 0x0431 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0431 }
            net.imedicaldoctor.imd.iMDLogger.f(r0, r9)     // Catch:{ Exception -> 0x0431 }
            goto L_0x03c4
        L_0x0422:
            r15 = r8
            r8 = r12
            r14 = r13
            r13 = r18
            r9 = r24
            r12 = r2
            r2 = r7
            r7 = r20
            r20 = r17
            goto L_0x00d9
        L_0x0431:
            r0 = move-exception
            r7 = r5
            goto L_0x0483
        L_0x0434:
            r0 = move-exception
            r5 = r7
            goto L_0x0483
        L_0x0437:
            r0 = move-exception
            r38 = r1
            r17 = r20
            r13 = r23
            r1 = r36
            r20 = r7
            r7 = r2
            r2 = r12
            r12 = r8
            r8 = r27
            r5 = r0
            com.google.firebase.crashlytics.FirebaseCrashlytics r0 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x0177 }
            r0.g(r5)     // Catch:{ Exception -> 0x0177 }
            java.lang.String r0 = "Error"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0177 }
            r9.<init>()     // Catch:{ Exception -> 0x0177 }
            java.lang.String r14 = "Error in getNextEntry : "
            r9.append(r14)     // Catch:{ Exception -> 0x0177 }
            java.lang.String r14 = r5.getLocalizedMessage()     // Catch:{ Exception -> 0x0177 }
            r9.append(r14)     // Catch:{ Exception -> 0x0177 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0177 }
            net.imedicaldoctor.imd.iMDLogger.f(r0, r9)     // Catch:{ Exception -> 0x0177 }
            r5.printStackTrace()     // Catch:{ Exception -> 0x0177 }
            java.lang.String r0 = r5.getLocalizedMessage()     // Catch:{ Exception -> 0x0177 }
            java.lang.String r9 = "CRC mismatch"
            boolean r0 = r0.equals(r9)     // Catch:{ Exception -> 0x0177 }
            if (r0 == 0) goto L_0x047b
            r0 = r38
            goto L_0x0422
        L_0x047b:
            java.lang.String r0 = r5.getLocalizedMessage()     // Catch:{ Exception -> 0x0177 }
            return r0
        L_0x0480:
            r0 = move-exception
            r19 = r7
        L_0x0483:
            com.google.firebase.crashlytics.FirebaseCrashlytics r2 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
            r2.g(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r0.getLocalizedMessage()
            r2.append(r3)
            java.lang.String r3 = " in "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "Error in unzip"
            net.imedicaldoctor.imd.iMDLogger.f(r4, r2)
            r0.printStackTrace()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r0 = r0.getLocalizedMessage()
            r2.append(r0)
            r2.append(r3)
            r2.append(r7)
            java.lang.String r0 = r2.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Decompress.h(io.reactivex.rxjava3.core.ObservableEmitter, java.lang.String, android.app.Activity):java.lang.String");
    }

    public boolean i() {
        BufferedSink d2;
        try {
            ZipInputStream zipInputStream = new ZipInputStream(Okio.e(Okio.t(new File(this.f29606a))).z());
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    iMDLogger.j("Decompress", "Unzipping " + nextEntry.getName());
                    if (nextEntry.isDirectory()) {
                        b(nextEntry.getName());
                    } else {
                        File file = new File(this.f29607b, nextEntry.getName());
                        file.getParentFile().mkdirs();
                        d2 = Okio.d(Okio.n(file));
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            d2.write(bArr, 0, read);
                        }
                        if (d2 != null) {
                            d2.close();
                        }
                        zipInputStream.closeEntry();
                    }
                } else {
                    zipInputStream.close();
                    return true;
                }
            }
        } catch (Exception e2) {
            iMDLogger.f("Decompress", "unzip failed: " + e2);
            return false;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public boolean j() {
        try {
            FileInputStream fileInputStream = new FileInputStream(this.f29606a);
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
            long length = new File(this.f29606a).length();
            long j2 = 0;
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    j2 += nextEntry.getCompressedSize();
                    long j3 = j2 / length;
                    if (nextEntry.isDirectory()) {
                        b(nextEntry.getName());
                    } else {
                        String str = this.f29607b + "/" + nextEntry.getName();
                        if (new File(str).exists()) {
                            this.f29609d.j(str);
                        }
                        byte[] bArr = new byte[262144];
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.f29607b + "/" + nextEntry.getName()), 262144);
                        while (true) {
                            int read = zipInputStream.read(bArr, 0, 262144);
                            if (read == -1) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        a(new File(str));
                    }
                } else {
                    zipInputStream.close();
                    fileInputStream.close();
                    return true;
                }
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("Error in unzip", e2.getLocalizedMessage());
            return false;
        }
    }

    public Observable<String> k() {
        return Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                if (Decompress.this.j()) {
                    observableEmitter.onComplete();
                } else {
                    observableEmitter.onError((Throwable) null);
                }
            }
        });
    }

    public String l(ObservableEmitter<Bundle> observableEmitter, String str) {
        String str2;
        long j2;
        Date date;
        String str3 = "/";
        String str4 = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(this.f29606a);
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
            long length = new File(this.f29606a).length();
            Date date2 = new Date();
            Bundle bundle = new Bundle();
            bundle.putString("progress", str4);
            bundle.putString("labelText", str);
            File file = new File(this.f29607b);
            long j3 = 0;
            String str5 = str4;
            Date date3 = date2;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        try {
                            zipInputStream.close();
                            fileInputStream.close();
                            return "0";
                        } catch (Exception e2) {
                            e = e2;
                            str4 = str5;
                        }
                    } else {
                        try {
                            j3 += nextEntry.getCompressedSize();
                            if (nextEntry.isDirectory()) {
                                b(nextEntry.getName());
                            } else {
                                String str6 = str3;
                                Date date4 = date3;
                                if (TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - date3.getTime()) > 1) {
                                    str2 = str5;
                                    j2 = j3;
                                    try {
                                        String format = String.format("%.2f", new Object[]{Double.valueOf((((double) j3) / ((double) length)) * 100.0d)});
                                        iMDLogger.f("Decompress", "Percent : " + format);
                                        bundle.remove("progress");
                                        bundle.putString("progress", format);
                                        observableEmitter.onNext(bundle);
                                        date = new Date();
                                    } catch (Exception e3) {
                                        e = e3;
                                        str4 = str2;
                                        FirebaseCrashlytics.d().g(e);
                                        iMDLogger.f("Error in unzip", e.getLocalizedMessage() + " in " + str4);
                                        e.printStackTrace();
                                        return e.getLocalizedMessage() + " in " + str4;
                                    }
                                } else {
                                    ObservableEmitter<Bundle> observableEmitter2 = observableEmitter;
                                    String str7 = str5;
                                    j2 = j3;
                                    date = date4;
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append(this.f29607b);
                                String str8 = str6;
                                sb.append(str8);
                                sb.append(nextEntry.getName());
                                str5 = sb.toString();
                                if (new File(str5).exists()) {
                                    iMDLogger.f("Decompress", nextEntry.getName() + " Exists.");
                                    this.f29609d.j(str5);
                                    iMDLogger.f("Decompress", nextEntry.getName() + " Deleted.");
                                }
                                if (nextEntry.getSize() > file.getUsableSpace()) {
                                    iMDLogger.f("Decompress", "Not Enough space");
                                    return ExifInterface.Y4;
                                }
                                byte[] bArr = new byte[262144];
                                int i2 = 262144;
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.f29607b + str8 + nextEntry.getName()), 262144);
                                while (true) {
                                    int read = zipInputStream.read(bArr, 0, i2);
                                    if (read == -1) {
                                        break;
                                    }
                                    bufferedOutputStream.write(bArr, 0, read);
                                    i2 = 262144;
                                }
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                a(new File(str5));
                                date3 = date;
                                str3 = str8;
                                j3 = j2;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            str2 = str5;
                            str4 = str2;
                            FirebaseCrashlytics.d().g(e);
                            iMDLogger.f("Error in unzip", e.getLocalizedMessage() + " in " + str4);
                            e.printStackTrace();
                            return e.getLocalizedMessage() + " in " + str4;
                        }
                    }
                } catch (Exception e5) {
                    String str9 = str3;
                    Date date5 = date3;
                    str2 = str5;
                    Exception exc = e5;
                    FirebaseCrashlytics.d().g(exc);
                    iMDLogger.f("Error", "Error in getNextEntry : " + exc.getLocalizedMessage());
                    exc.printStackTrace();
                    if (!exc.getLocalizedMessage().equals("CRC mismatch")) {
                        return exc.getLocalizedMessage();
                    }
                    date3 = date5;
                    str3 = str9;
                    str5 = str2;
                }
            }
        } catch (Exception e6) {
            e = e6;
            FirebaseCrashlytics.d().g(e);
            iMDLogger.f("Error in unzip", e.getLocalizedMessage() + " in " + str4);
            e.printStackTrace();
            return e.getLocalizedMessage() + " in " + str4;
        }
    }

    public String m(ObservableEmitter<Bundle> observableEmitter, String str) {
        String str2;
        long j2;
        Date date;
        String str3 = "/";
        String str4 = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(this.f29606a);
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
            long length = new File(this.f29606a).length();
            Date date2 = new Date();
            Bundle bundle = new Bundle();
            bundle.putString("progress", str4);
            bundle.putString("labelText", str);
            File file = new File(this.f29607b);
            long j3 = 0;
            String str5 = str4;
            Date date3 = date2;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        try {
                            zipInputStream.close();
                            fileInputStream.close();
                            return "0";
                        } catch (Exception e2) {
                            e = e2;
                            str4 = str5;
                        }
                    } else {
                        try {
                            j3 += nextEntry.getCompressedSize();
                            if (nextEntry.isDirectory()) {
                                b(nextEntry.getName());
                            } else {
                                String str6 = str3;
                                Date date4 = date3;
                                if (TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - date3.getTime()) > 1) {
                                    str2 = str5;
                                    j2 = j3;
                                    try {
                                        String format = String.format("%.2f", new Object[]{Double.valueOf((((double) j3) / ((double) length)) * 100.0d)});
                                        iMDLogger.f("Decompress", "Percent : " + format);
                                        bundle.remove("progress");
                                        bundle.putString("progress", format);
                                        observableEmitter.onNext(bundle);
                                        date = new Date();
                                    } catch (Exception e3) {
                                        e = e3;
                                        str4 = str2;
                                        FirebaseCrashlytics.d().g(e);
                                        iMDLogger.f("Error in unzip", e.getLocalizedMessage() + " in " + str4);
                                        e.printStackTrace();
                                        return e.getLocalizedMessage() + " in " + str4;
                                    }
                                } else {
                                    ObservableEmitter<Bundle> observableEmitter2 = observableEmitter;
                                    String str7 = str5;
                                    j2 = j3;
                                    date = date4;
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append(this.f29607b);
                                String str8 = str6;
                                sb.append(str8);
                                sb.append(nextEntry.getName());
                                str5 = sb.toString();
                                if (new File(str5).exists()) {
                                    this.f29609d.j(str5);
                                }
                                if (nextEntry.getSize() > file.getUsableSpace()) {
                                    iMDLogger.f("Decompress", "Not Enough space");
                                    return ExifInterface.Y4;
                                }
                                byte[] bArr = new byte[262144];
                                int i2 = 262144;
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.f29607b + str8 + nextEntry.getName()), 262144);
                                while (true) {
                                    int read = zipInputStream.read(bArr, 0, i2);
                                    if (read == -1) {
                                        break;
                                    }
                                    bufferedOutputStream.write(bArr, 0, read);
                                    i2 = 262144;
                                }
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                a(new File(str5));
                                date3 = date;
                                str3 = str8;
                                j3 = j2;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            str2 = str5;
                            str4 = str2;
                            FirebaseCrashlytics.d().g(e);
                            iMDLogger.f("Error in unzip", e.getLocalizedMessage() + " in " + str4);
                            e.printStackTrace();
                            return e.getLocalizedMessage() + " in " + str4;
                        }
                    }
                } catch (Exception e5) {
                    String str9 = str3;
                    Date date5 = date3;
                    str2 = str5;
                    Exception exc = e5;
                    FirebaseCrashlytics.d().g(exc);
                    iMDLogger.f("Error", "Error in getNextEntry : " + exc.getLocalizedMessage());
                    exc.printStackTrace();
                    if (!exc.getLocalizedMessage().equals("CRC mismatch")) {
                        return exc.getLocalizedMessage();
                    }
                    date3 = date5;
                    str3 = str9;
                    str5 = str2;
                }
            }
        } catch (Exception e6) {
            e = e6;
            FirebaseCrashlytics.d().g(e);
            iMDLogger.f("Error in unzip", e.getLocalizedMessage() + " in " + str4);
            e.printStackTrace();
            return e.getLocalizedMessage() + " in " + str4;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v23, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v27, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v29, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v40, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v31, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v32, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v43, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v34, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r9v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00c7, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00c8, code lost:
        if (r7 == false) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ce, code lost:
        if (r0 >= r8.size()) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d0, code lost:
        r1.f29609d.j(((android.os.Bundle) r8.get(r0)).getString(r15));
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00e2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e3, code lost:
        r7 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00eb, code lost:
        if (r0 >= r9.size()) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ed, code lost:
        r1.f29609d.j(((android.os.Bundle) r9.get(r0)).getString(r15));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00fc, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r0 = r10.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0107, code lost:
        if (r0.hasNext() == false) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0109, code lost:
        ((java.io.FileInputStream) r0.next()).close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0113, code lost:
        r5.close();
        r13.close();
        r4.close();
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        net.imedicaldoctor.imd.iMDLogger.f("Zip Completed", "In " + java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(new java.util.Date().getTime() - r18.getTime()) + " Seconds");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0150, code lost:
        return "0";
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x011f */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String n(io.reactivex.rxjava3.core.ObservableEmitter<android.os.Bundle> r33, java.lang.String r34, android.app.Activity r35) {
        /*
            r32 = this;
            r1 = r32
            r2 = r33
            java.lang.String r5 = "/"
            java.lang.String r6 = "progress"
            java.lang.String r7 = ""
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ Exception -> 0x036c }
            r8.<init>()     // Catch:{ Exception -> 0x036c }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x036c }
            r9.<init>()     // Catch:{ Exception -> 0x036c }
            java.util.Vector r10 = new java.util.Vector     // Catch:{ Exception -> 0x036c }
            r0 = 10
            r10.<init>(r0)     // Catch:{ Exception -> 0x036c }
            r11 = 0
            r0 = 1
        L_0x001e:
            r13 = 11
            java.lang.String r14 = "offset"
            java.lang.String r15 = "filePath"
            if (r0 >= r13) goto L_0x0066
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0063 }
            r13.<init>()     // Catch:{ Exception -> 0x0063 }
            java.lang.String r3 = r1.f29606a     // Catch:{ Exception -> 0x0063 }
            r13.append(r3)     // Catch:{ Exception -> 0x0063 }
            java.lang.String r3 = "."
            r13.append(r3)     // Catch:{ Exception -> 0x0063 }
            r13.append(r0)     // Catch:{ Exception -> 0x0063 }
            java.lang.String r3 = r13.toString()     // Catch:{ Exception -> 0x0063 }
            android.os.Bundle r13 = new android.os.Bundle     // Catch:{ Exception -> 0x0063 }
            r13.<init>()     // Catch:{ Exception -> 0x0063 }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0063 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0063 }
            long r16 = r4.length()     // Catch:{ Exception -> 0x0063 }
            long r11 = r11 + r16
            r13.putString(r15, r3)     // Catch:{ Exception -> 0x0063 }
            r13.putLong(r14, r11)     // Catch:{ Exception -> 0x0063 }
            r8.add(r13)     // Catch:{ Exception -> 0x0063 }
            r9.add(r13)     // Catch:{ Exception -> 0x0063 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0063 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0063 }
            r10.add(r4)     // Catch:{ Exception -> 0x0063 }
            r3 = 1
            int r0 = r0 + r3
            goto L_0x001e
        L_0x0063:
            r0 = move-exception
            goto L_0x036f
        L_0x0066:
            java.util.Enumeration r0 = r10.elements()     // Catch:{ Exception -> 0x036c }
            java.io.SequenceInputStream r3 = new java.io.SequenceInputStream     // Catch:{ Exception -> 0x036c }
            r3.<init>(r0)     // Catch:{ Exception -> 0x036c }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x036c }
            r13 = 131072(0x20000, float:1.83671E-40)
            r4.<init>(r3, r13)     // Catch:{ Exception -> 0x036c }
            com.google.common.io.CountingInputStream r13 = new com.google.common.io.CountingInputStream     // Catch:{ Exception -> 0x036c }
            r13.<init>(r4)     // Catch:{ Exception -> 0x036c }
            r17 = r5
            java.util.zip.ZipInputStream r5 = new java.util.zip.ZipInputStream     // Catch:{ Exception -> 0x036c }
            r5.<init>(r13)     // Catch:{ Exception -> 0x036c }
            java.util.Date r0 = new java.util.Date     // Catch:{ Exception -> 0x036c }
            r0.<init>()     // Catch:{ Exception -> 0x036c }
            java.util.Date r18 = new java.util.Date     // Catch:{ Exception -> 0x036c }
            r18.<init>()     // Catch:{ Exception -> 0x036c }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ Exception -> 0x036c }
            r2.<init>()     // Catch:{ Exception -> 0x036c }
            r2.putString(r6, r7)     // Catch:{ Exception -> 0x036c }
            r19 = r0
            java.lang.String r0 = "labelText"
            r20 = r7
            r7 = r34
            r2.putString(r0, r7)     // Catch:{ Exception -> 0x00e2 }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r7 = r1.f29607b     // Catch:{ Exception -> 0x00e2 }
            r0.<init>(r7)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r0 = "default_preferences"
            r7 = r35
            r21 = r2
            r2 = 0
            android.content.SharedPreferences r0 = r7.getSharedPreferences(r0, r2)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r7 = "lessspace"
            boolean r7 = r0.getBoolean(r7, r2)     // Catch:{ Exception -> 0x00e2 }
            java.lang.Object r0 = r8.get(r2)     // Catch:{ Exception -> 0x00e2 }
            android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ Exception -> 0x00e2 }
            long r22 = r0.getLong(r14)     // Catch:{ Exception -> 0x00e2 }
        L_0x00c1:
            java.util.zip.ZipEntry r2 = r5.getNextEntry()     // Catch:{ Exception -> 0x0328 }
            if (r2 != 0) goto L_0x0151
            r0 = 0
            if (r7 == 0) goto L_0x00e7
        L_0x00ca:
            int r2 = r8.size()     // Catch:{ Exception -> 0x00e2 }
            if (r0 >= r2) goto L_0x00ff
            java.lang.Object r2 = r8.get(r0)     // Catch:{ Exception -> 0x00e2 }
            android.os.Bundle r2 = (android.os.Bundle) r2     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r2 = r2.getString(r15)     // Catch:{ Exception -> 0x00e2 }
            net.imedicaldoctor.imd.Data.CompressHelper r6 = r1.f29609d     // Catch:{ Exception -> 0x00e2 }
            r6.j(r2)     // Catch:{ Exception -> 0x00e2 }
            r2 = 1
            int r0 = r0 + r2
            goto L_0x00ca
        L_0x00e2:
            r0 = move-exception
            r7 = r20
            goto L_0x036f
        L_0x00e7:
            int r2 = r9.size()     // Catch:{ Exception -> 0x00e2 }
            if (r0 >= r2) goto L_0x00ff
            java.lang.Object r2 = r9.get(r0)     // Catch:{ Exception -> 0x00e2 }
            android.os.Bundle r2 = (android.os.Bundle) r2     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r2 = r2.getString(r15)     // Catch:{ Exception -> 0x00e2 }
            net.imedicaldoctor.imd.Data.CompressHelper r6 = r1.f29609d     // Catch:{ Exception -> 0x00e2 }
            r6.j(r2)     // Catch:{ Exception -> 0x00e2 }
            r2 = 1
            int r0 = r0 + r2
            goto L_0x00e7
        L_0x00ff:
            java.util.Iterator r0 = r10.iterator()     // Catch:{ Exception -> 0x011f }
        L_0x0103:
            boolean r2 = r0.hasNext()     // Catch:{ Exception -> 0x011f }
            if (r2 == 0) goto L_0x0113
            java.lang.Object r2 = r0.next()     // Catch:{ Exception -> 0x011f }
            java.io.FileInputStream r2 = (java.io.FileInputStream) r2     // Catch:{ Exception -> 0x011f }
            r2.close()     // Catch:{ Exception -> 0x011f }
            goto L_0x0103
        L_0x0113:
            r5.close()     // Catch:{ Exception -> 0x011f }
            r13.close()     // Catch:{ Exception -> 0x011f }
            r4.close()     // Catch:{ Exception -> 0x011f }
            r3.close()     // Catch:{ Exception -> 0x011f }
        L_0x011f:
            java.util.Date r0 = new java.util.Date     // Catch:{ Exception -> 0x00e2 }
            r0.<init>()     // Catch:{ Exception -> 0x00e2 }
            long r2 = r0.getTime()     // Catch:{ Exception -> 0x00e2 }
            long r4 = r18.getTime()     // Catch:{ Exception -> 0x00e2 }
            long r2 = r2 - r4
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x00e2 }
            long r2 = r0.toSeconds(r2)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r0 = "Zip Completed"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e2 }
            r4.<init>()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r5 = "In "
            r4.append(r5)     // Catch:{ Exception -> 0x00e2 }
            r4.append(r2)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r2 = " Seconds"
            r4.append(r2)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x00e2 }
            net.imedicaldoctor.imd.iMDLogger.f(r0, r2)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r0 = "0"
            return r0
        L_0x0151:
            long r24 = r13.b()     // Catch:{ Exception -> 0x00e2 }
            int r0 = (r24 > r22 ? 1 : (r24 == r22 ? 0 : -1))
            if (r0 <= 0) goto L_0x017c
            r24 = r3
            r3 = 0
            java.lang.Object r0 = r8.get(r3)     // Catch:{ Exception -> 0x00e2 }
            android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r0 = r0.getString(r15)     // Catch:{ Exception -> 0x00e2 }
            if (r7 == 0) goto L_0x016d
            net.imedicaldoctor.imd.Data.CompressHelper r3 = r1.f29609d     // Catch:{ Exception -> 0x00e2 }
            r3.j(r0)     // Catch:{ Exception -> 0x00e2 }
        L_0x016d:
            r3 = 0
            r8.remove(r3)     // Catch:{ Exception -> 0x00e2 }
            java.lang.Object r0 = r8.get(r3)     // Catch:{ Exception -> 0x00e2 }
            android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ Exception -> 0x00e2 }
            long r22 = r0.getLong(r14)     // Catch:{ Exception -> 0x00e2 }
            goto L_0x017e
        L_0x017c:
            r24 = r3
        L_0x017e:
            boolean r0 = r2.isDirectory()     // Catch:{ Exception -> 0x00e2 }
            if (r0 == 0) goto L_0x0197
            java.lang.String r0 = r2.getName()     // Catch:{ Exception -> 0x00e2 }
            r1.b(r0)     // Catch:{ Exception -> 0x00e2 }
            r29 = r4
            r25 = r9
            r9 = r14
            r3 = r15
            r15 = r17
            r17 = r6
            goto L_0x031a
        L_0x0197:
            java.util.Date r0 = new java.util.Date     // Catch:{ Exception -> 0x00e2 }
            r0.<init>()     // Catch:{ Exception -> 0x00e2 }
            long r25 = r0.getTime()     // Catch:{ Exception -> 0x00e2 }
            long r27 = r19.getTime()     // Catch:{ Exception -> 0x00e2 }
            r29 = r4
            long r3 = r25 - r27
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x00e2 }
            long r3 = r0.toSeconds(r3)     // Catch:{ Exception -> 0x00e2 }
            r25 = r9
            r26 = r14
            r27 = r15
            r9 = 1
            long r14 = (long) r9
            java.lang.String r0 = "Decompress"
            int r9 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x0200
            long r3 = r13.b()     // Catch:{ Exception -> 0x00e2 }
            double r3 = (double) r3     // Catch:{ Exception -> 0x00e2 }
            double r14 = (double) r11     // Catch:{ Exception -> 0x00e2 }
            double r3 = r3 / r14
            r14 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r3 = r3 * r14
            java.lang.String r9 = "%.2f"
            java.lang.Double r3 = java.lang.Double.valueOf(r3)     // Catch:{ Exception -> 0x00e2 }
            r4 = 1
            java.lang.Object[] r14 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00e2 }
            r15 = 0
            r14[r15] = r3     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r3 = java.lang.String.format(r9, r14)     // Catch:{ Exception -> 0x00e2 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e2 }
            r9.<init>()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r14 = "Percent : "
            r9.append(r14)     // Catch:{ Exception -> 0x00e2 }
            r9.append(r3)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00e2 }
            net.imedicaldoctor.imd.iMDLogger.f(r0, r9)     // Catch:{ Exception -> 0x00e2 }
            r9 = r21
            r9.remove(r6)     // Catch:{ Exception -> 0x00e2 }
            r9.putString(r6, r3)     // Catch:{ Exception -> 0x00e2 }
            r3 = r33
            if (r3 == 0) goto L_0x01fa
            r3.onNext(r9)     // Catch:{ Exception -> 0x00e2 }
        L_0x01fa:
            java.util.Date r19 = new java.util.Date     // Catch:{ Exception -> 0x00e2 }
            r19.<init>()     // Catch:{ Exception -> 0x00e2 }
            goto L_0x0205
        L_0x0200:
            r3 = r33
            r9 = r21
            r4 = 1
        L_0x0205:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e2 }
            r14.<init>()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r15 = r1.f29607b     // Catch:{ Exception -> 0x00e2 }
            r14.append(r15)     // Catch:{ Exception -> 0x00e2 }
            r15 = r17
            r14.append(r15)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r4 = r2.getName()     // Catch:{ Exception -> 0x00e2 }
            r14.append(r4)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r4 = r14.toString()     // Catch:{ Exception -> 0x00e2 }
            java.io.File r14 = new java.io.File     // Catch:{ Exception -> 0x0262 }
            r14.<init>(r4)     // Catch:{ Exception -> 0x0262 }
            boolean r14 = r14.exists()     // Catch:{ Exception -> 0x0262 }
            if (r14 == 0) goto L_0x025f
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0262 }
            r14.<init>()     // Catch:{ Exception -> 0x0262 }
            java.lang.String r3 = r2.getName()     // Catch:{ Exception -> 0x0262 }
            r14.append(r3)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r3 = " Exists"
            r14.append(r3)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r3 = r14.toString()     // Catch:{ Exception -> 0x0262 }
            net.imedicaldoctor.imd.iMDLogger.f(r0, r3)     // Catch:{ Exception -> 0x0262 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0262 }
            r3.<init>()     // Catch:{ Exception -> 0x0262 }
            java.lang.String r14 = r2.getName()     // Catch:{ Exception -> 0x0262 }
            r3.append(r14)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r14 = " Different Size. Deleteing old file"
            r3.append(r14)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0262 }
            net.imedicaldoctor.imd.iMDLogger.f(r0, r3)     // Catch:{ Exception -> 0x0262 }
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r1.f29609d     // Catch:{ Exception -> 0x0262 }
            r0.j(r4)     // Catch:{ Exception -> 0x0262 }
        L_0x025f:
            r3 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0266
        L_0x0262:
            r0 = move-exception
            r7 = r4
            goto L_0x036f
        L_0x0266:
            byte[] r0 = new byte[r3]     // Catch:{ Exception -> 0x0262 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x02f4 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f4 }
            r14.<init>()     // Catch:{ Exception -> 0x02f4 }
            r17 = r6
            java.lang.String r6 = r1.f29607b     // Catch:{ Exception -> 0x02f0 }
            r14.append(r6)     // Catch:{ Exception -> 0x02f0 }
            r14.append(r15)     // Catch:{ Exception -> 0x02f0 }
            java.lang.String r6 = r2.getName()     // Catch:{ Exception -> 0x02f0 }
            r14.append(r6)     // Catch:{ Exception -> 0x02f0 }
            java.lang.String r6 = r14.toString()     // Catch:{ Exception -> 0x02f0 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x02f0 }
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x02f0 }
            r14 = 131072(0x20000, float:1.83671E-40)
            r6.<init>(r3, r14)     // Catch:{ Exception -> 0x02f0 }
            r21 = r9
            r3 = 0
        L_0x0291:
            int r9 = r5.read(r0, r3, r14)     // Catch:{ Exception -> 0x02d5 }
            r14 = -1
            if (r9 == r14) goto L_0x02db
            r6.write(r0, r3, r9)     // Catch:{ Exception -> 0x02d5 }
            long r30 = r13.b()     // Catch:{ Exception -> 0x02d5 }
            int r9 = (r30 > r22 ? 1 : (r30 == r22 ? 0 : -1))
            if (r9 <= 0) goto L_0x02cf
            java.lang.Object r9 = r8.get(r3)     // Catch:{ Exception -> 0x02d5 }
            android.os.Bundle r9 = (android.os.Bundle) r9     // Catch:{ Exception -> 0x02d5 }
            r3 = r27
            java.lang.String r9 = r9.getString(r3)     // Catch:{ Exception -> 0x02b8 }
            if (r7 == 0) goto L_0x02b6
            net.imedicaldoctor.imd.Data.CompressHelper r14 = r1.f29609d     // Catch:{ Exception -> 0x02b8 }
            r14.j(r9)     // Catch:{ Exception -> 0x02b8 }
        L_0x02b6:
            r9 = 0
            goto L_0x02bc
        L_0x02b8:
            r0 = move-exception
            r9 = r26
            goto L_0x02f8
        L_0x02bc:
            r8.remove(r9)     // Catch:{ Exception -> 0x02b8 }
            java.lang.Object r14 = r8.get(r9)     // Catch:{ Exception -> 0x02b8 }
            android.os.Bundle r14 = (android.os.Bundle) r14     // Catch:{ Exception -> 0x02b8 }
            r9 = r26
            long r22 = r14.getLong(r9)     // Catch:{ Exception -> 0x02d3 }
            r27 = r3
            r26 = r9
        L_0x02cf:
            r3 = 0
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0291
        L_0x02d3:
            r0 = move-exception
            goto L_0x02f8
        L_0x02d5:
            r0 = move-exception
        L_0x02d6:
            r9 = r26
            r3 = r27
            goto L_0x02f8
        L_0x02db:
            r9 = r26
            r3 = r27
            r6.flush()     // Catch:{ Exception -> 0x02d3 }
            r6.close()     // Catch:{ Exception -> 0x02d3 }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x02d3 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x02d3 }
            r1.a(r0)     // Catch:{ Exception -> 0x02d3 }
        L_0x02ed:
            r20 = r4
            goto L_0x031a
        L_0x02f0:
            r0 = move-exception
        L_0x02f1:
            r21 = r9
            goto L_0x02d6
        L_0x02f4:
            r0 = move-exception
            r17 = r6
            goto L_0x02f1
        L_0x02f8:
            com.google.firebase.crashlytics.FirebaseCrashlytics r6 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x0262 }
            r6.g(r0)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r0 = "Decompress Error"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0262 }
            r6.<init>()     // Catch:{ Exception -> 0x0262 }
            java.lang.String r14 = "Can't write . "
            r6.append(r14)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x0262 }
            r6.append(r2)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x0262 }
            net.imedicaldoctor.imd.iMDLogger.f(r0, r2)     // Catch:{ Exception -> 0x0262 }
            goto L_0x02ed
        L_0x031a:
            r14 = r9
            r6 = r17
            r9 = r25
            r4 = r29
            r17 = r15
            r15 = r3
            r3 = r24
            goto L_0x00c1
        L_0x0328:
            r0 = move-exception
            r24 = r3
            r29 = r4
            r25 = r9
            r9 = r14
            r3 = r15
            r15 = r17
            r17 = r6
            r2 = r0
            com.google.firebase.crashlytics.FirebaseCrashlytics r0 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x00e2 }
            r0.g(r2)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r0 = "Error"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e2 }
            r4.<init>()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r6 = "Error in getNextEntry : "
            r4.append(r6)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r6 = r2.getLocalizedMessage()     // Catch:{ Exception -> 0x00e2 }
            r4.append(r6)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00e2 }
            net.imedicaldoctor.imd.iMDLogger.f(r0, r4)     // Catch:{ Exception -> 0x00e2 }
            r2.printStackTrace()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r0 = r2.getLocalizedMessage()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r4 = "CRC mismatch"
            boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x00e2 }
            if (r0 == 0) goto L_0x0367
            goto L_0x031a
        L_0x0367:
            java.lang.String r0 = r2.getLocalizedMessage()     // Catch:{ Exception -> 0x00e2 }
            return r0
        L_0x036c:
            r0 = move-exception
            r20 = r7
        L_0x036f:
            com.google.firebase.crashlytics.FirebaseCrashlytics r2 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
            r2.g(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r0.getLocalizedMessage()
            r2.append(r3)
            java.lang.String r3 = " in "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "Error in unzip"
            net.imedicaldoctor.imd.iMDLogger.f(r4, r2)
            r0.printStackTrace()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r0 = r0.getLocalizedMessage()
            r2.append(r0)
            r2.append(r3)
            r2.append(r7)
            java.lang.String r0 = r2.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Decompress.n(io.reactivex.rxjava3.core.ObservableEmitter, java.lang.String, android.app.Activity):java.lang.String");
    }
}
