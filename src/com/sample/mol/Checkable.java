package com.sample.mol;

import com.sample.mol.model.KickOutReason;

/**
 * Created by fgallois on 6/27/14.
 */
public interface Checkable {

    KickOutReason check(AbstractResult abstractResult);

}
