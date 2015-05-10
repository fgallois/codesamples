package com.sample.mol.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.sample.mol.Calculator;
import com.sample.mol.MolProvider;
import com.sample.mol.model.MaxOrderLimitType;

/**
 * Created by fgallois on 6/25/14.
 */
public class MolProviderImpl implements MolProvider {

    @Autowired
    private Map<String, Calculator> calculators;

    @Override
    public Calculator getMolCalculator(final MaxOrderLimitType type) {
        Calculator result;
        if (type == null) {
            // Use Standard MOL calculator in case the client is not initialized with a MOL type.
            result = calculators.get(MaxOrderLimitType.STANDARD.name());
        } else {
            result = calculators.get(type.name());
        }
        return result;
    }

    public void setCalculators(final Map<String, Calculator> calculators) {
        this.calculators = calculators;
    }
}
