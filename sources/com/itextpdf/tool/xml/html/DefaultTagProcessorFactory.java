package com.itextpdf.tool.xml.html;

import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.NoTagProcessorException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultTagProcessorFactory implements TagProcessorFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, FactoryObject> f27586a = new ConcurrentHashMap();

    protected final class FactoryObject {

        /* renamed from: a  reason: collision with root package name */
        private final String f27587a;

        /* renamed from: b  reason: collision with root package name */
        private TagProcessor f27588b;

        public FactoryObject(String str) {
            this.f27587a = str;
        }

        public String a() {
            return this.f27587a;
        }

        public TagProcessor b() {
            if (this.f27588b == null) {
                this.f27588b = DefaultTagProcessorFactory.this.g(this.f27587a);
            }
            return this.f27588b;
        }

        public FactoryObject(DefaultTagProcessorFactory defaultTagProcessorFactory, String str, TagProcessor tagProcessor) {
            this(str);
            this.f27588b = tagProcessor;
        }
    }

    public void a(String str) {
        this.f27586a.remove(str);
    }

    public void b(TagProcessor tagProcessor, String... strArr) {
        for (String d2 : strArr) {
            d(d2, tagProcessor);
        }
    }

    public TagProcessor c(String str, String str2) {
        FactoryObject factoryObject = this.f27586a.get(str.toLowerCase());
        if (factoryObject != null) {
            return factoryObject.b();
        }
        throw new NoTagProcessorException(str);
    }

    public void d(String str, TagProcessor tagProcessor) {
        this.f27586a.put(str, new FactoryObject(this, tagProcessor.getClass().getName(), tagProcessor));
    }

    public void e(String str, String str2) {
        this.f27586a.put(str, new FactoryObject(str2));
    }

    public void f(String str, String... strArr) {
        for (String e2 : strArr) {
            e(e2, str);
        }
    }

    /* access modifiers changed from: protected */
    public TagProcessor g(String str) throws NoTagProcessorException {
        try {
            return (TagProcessor) Class.forName(str).newInstance();
        } catch (LinkageError unused) {
            throw new NoTagProcessorException(String.format(LocaleMessages.a().b(LocaleMessages.f27576g), new Object[]{str}));
        } catch (ClassNotFoundException e2) {
            throw new NoTagProcessorException(String.format(LocaleMessages.a().b(LocaleMessages.f27576g), new Object[]{str}), e2);
        } catch (InstantiationException e3) {
            throw new NoTagProcessorException(String.format(LocaleMessages.a().b(LocaleMessages.f27576g), new Object[]{str}), e3);
        } catch (IllegalAccessException e4) {
            throw new NoTagProcessorException(String.format(LocaleMessages.a().b(LocaleMessages.f27576g), new Object[]{str}), e4);
        }
    }

    /* access modifiers changed from: protected */
    public TagProcessor h(String str, ClassLoader classLoader) throws NoTagProcessorException {
        try {
            return (TagProcessor) classLoader.loadClass(str).newInstance();
        } catch (LinkageError unused) {
            throw new NoTagProcessorException(String.format(LocaleMessages.a().b(LocaleMessages.f27576g), new Object[]{str}));
        } catch (ClassNotFoundException e2) {
            throw new NoTagProcessorException(String.format(LocaleMessages.a().b(LocaleMessages.f27576g), new Object[]{str}), e2);
        } catch (InstantiationException e3) {
            throw new NoTagProcessorException(String.format(LocaleMessages.a().b(LocaleMessages.f27576g), new Object[]{str}), e3);
        } catch (IllegalAccessException e4) {
            throw new NoTagProcessorException(String.format(LocaleMessages.a().b(LocaleMessages.f27576g), new Object[]{str}), e4);
        }
    }
}
