package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.Set;

final class EmptyRequestManagerTreeNode implements RequestManagerTreeNode {
    EmptyRequestManagerTreeNode() {
    }

    @NonNull
    public Set<RequestManager> a() {
        return Collections.emptySet();
    }
}
