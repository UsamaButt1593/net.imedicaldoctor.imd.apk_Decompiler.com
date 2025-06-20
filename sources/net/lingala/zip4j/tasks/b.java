package net.lingala.zip4j.tasks;

import java.util.Comparator;
import net.lingala.zip4j.model.FileHeader;

public final /* synthetic */ class b implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return AbstractModifyFileTask.p((FileHeader) obj, (FileHeader) obj2);
    }
}
