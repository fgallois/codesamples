package com.sample.mol;

import com.sample.mol.model.MaxOrderLimitType;

/**
 * Created by fgallois on 6/25/14.
 */
public interface MolProvider {
    Calculator getMolCalculator(MaxOrderLimitType type);
}
