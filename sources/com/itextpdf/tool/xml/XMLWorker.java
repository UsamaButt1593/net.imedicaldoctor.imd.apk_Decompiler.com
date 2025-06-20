package com.itextpdf.tool.xml;

import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.parser.XMLParserListener;
import com.itextpdf.tool.xml.pipeline.ctx.WorkerContextImpl;
import java.util.Map;

public class XMLWorker implements XMLParserListener {

    /* renamed from: c  reason: collision with root package name */
    private static ThreadLocal<WorkerContextImpl> f27447c = new ThreadLocal<WorkerContextImpl>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public WorkerContextImpl initialValue() {
            return new WorkerContextImpl();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    protected final Pipeline<?> f27448a;

    /* renamed from: b  reason: collision with root package name */
    protected final boolean f27449b;

    public XMLWorker(Pipeline<?> pipeline, boolean z) {
        this.f27449b = z;
        this.f27448a = pipeline;
    }

    protected static void g() {
        f27447c.remove();
    }

    protected static WorkerContext j() {
        return f27447c.get();
    }

    public void a(String str) {
        if (str.startsWith("<![CDATA[") && str.endsWith("]]>")) {
            if (!k()) {
                str = str.substring(9, str.length() - 3);
            } else {
                return;
            }
        }
        WorkerContext j2 = j();
        if (j2.b() != null && str.length() > 0) {
            Pipeline<?> pipeline = this.f27448a;
            ProcessObject processObject = new ProcessObject();
            do {
                try {
                    pipeline = pipeline.e(j2, j2.b(), str, processObject);
                } catch (PipelineException e2) {
                    throw new RuntimeWorkerException((Throwable) e2);
                }
            } while (pipeline != null);
        }
    }

    public void b(String str) {
    }

    public void c(String str, String str2) {
        if (this.f27449b) {
            str = str.toLowerCase();
        }
        WorkerContext j2 = j();
        if (j2.b() == null || str.equals(j2.b().o())) {
            Pipeline<?> pipeline = this.f27448a;
            ProcessObject processObject = new ProcessObject();
            do {
                try {
                    pipeline = pipeline.d(j2, j2.b(), processObject);
                } catch (PipelineException e2) {
                    throw new RuntimeWorkerException((Throwable) e2);
                } catch (Throwable th) {
                    if (j2.b() != null) {
                        j2.c(j2.b().r());
                    }
                    throw th;
                }
            } while (pipeline != null);
            if (j2.b() != null) {
                j2.c(j2.b().r());
                return;
            }
            return;
        }
        throw new RuntimeWorkerException(String.format(LocaleMessages.a().b(LocaleMessages.f27572c), new Object[]{str, j2.b().o()}));
    }

    public void close() {
        g();
    }

    public void d(String str) {
    }

    public void e() {
        Pipeline<?> pipeline = this.f27448a;
        do {
            try {
                pipeline = pipeline.c(j());
            } catch (PipelineException e2) {
                throw new RuntimeWorkerException((Throwable) e2);
            }
        } while (pipeline != null);
    }

    public void f(String str, Map<String, String> map, String str2) {
        Tag h2 = h(str, map, str2);
        WorkerContext j2 = j();
        if (j2.b() != null) {
            j2.b().b(h2);
        }
        j2.c(h2);
        Pipeline<?> pipeline = this.f27448a;
        ProcessObject processObject = new ProcessObject();
        do {
            try {
                pipeline = pipeline.b(j2, h2, processObject);
            } catch (PipelineException e2) {
                throw new RuntimeWorkerException((Throwable) e2);
            }
        } while (pipeline != null);
    }

    /* access modifiers changed from: protected */
    public Tag h(String str, Map<String, String> map, String str2) {
        if (this.f27449b) {
            str = str.toLowerCase();
        }
        return new Tag(str, map, str2);
    }

    /* access modifiers changed from: protected */
    public Tag i() {
        return j().b();
    }

    /* access modifiers changed from: protected */
    public boolean k() {
        return true;
    }
}
