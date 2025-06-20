package com.trello.rxlifecycle4;

import javax.annotation.Nullable;

public class OutsideLifecycleException extends IllegalStateException {
    public OutsideLifecycleException(@Nullable String str) {
        super(str);
    }
}
