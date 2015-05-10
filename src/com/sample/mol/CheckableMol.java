package com.sample.mol;

import com.sample.mol.model.KickOutReason;
import com.sample.mol.model.KickOutReasonEnum;

/**
 * Created by fgallois on 6/27/14.
 */
public class CheckableMol implements Checkable {

    @Override
    public KickOutReason check(final AbstractResult abstractResult) {
        KickOutReason reason = null;
        MolResult molResult = (MolResult) abstractResult;
        if (molResult.getRemainingNumberOfPurchases() <= 0) {
            // Add kickout to process stage:
            final KickOutReason kickOutReason = new KickOutReason();

            kickOutReason.setCode(KickOutReasonEnum.RC701);
            kickOutReason.setDetail("Code samples", new Object[] { molResult.getNumberOfOpenOrders() });

            reason = kickOutReason;
        }
        return reason;
    }
}
