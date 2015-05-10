package com.sample.mol;

import com.sample.mol.model.KickOutReason;

/**
 * Created by fgallois on 6/27/14.
 */
public abstract class AbstractResult {
    private Checkable checkable;

    public KickOutReason performCheck() {
        return checkable.check(this);
    }

    public Checkable getCheckable() {
        return checkable;
    }

    public void setCheckable(final Checkable checkable) {
        this.checkable = checkable;
    }
}
