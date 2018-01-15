package com.mycelium.spvmodule.providers.data;

import android.database.MatrixCursor;

import com.mycelium.spvmodule.providers.TransactionContract;

/**
 * The custom cursor that defines data returned by {@link TransactionContract.CalculateMaxSpendable#TABLE_NAME}
 */
public class CalculateMaxSpendableCursor extends MatrixCursor {
    private static String[] columnNames = {
            TransactionContract.CalculateMaxSpendable.TX_FEE,
            TransactionContract.CalculateMaxSpendable.TX_FEE_FACTOR,
            TransactionContract.CalculateMaxSpendable.MAX_SPENDABLE
    };

    public CalculateMaxSpendableCursor() {
        super(columnNames, 1);
    }
}
