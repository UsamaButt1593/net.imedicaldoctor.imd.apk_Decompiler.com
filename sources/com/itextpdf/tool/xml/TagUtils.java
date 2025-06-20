package com.itextpdf.tool.xml;

import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.NoSiblingException;
import java.util.List;

public class TagUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final TagUtils f27446a = new TagUtils();

    public static TagUtils a() {
        return f27446a;
    }

    public Tag b(Tag tag, int i2) throws NoSiblingException {
        try {
            List<Tag> k2 = tag.r().k();
            return k2.get(k2.indexOf(tag) + i2);
        } catch (IndexOutOfBoundsException e2) {
            throw new NoSiblingException(String.format(LocaleMessages.a().b(LocaleMessages.f27577h), new Object[]{tag.o(), Integer.valueOf(i2)}), e2);
        }
    }
}
