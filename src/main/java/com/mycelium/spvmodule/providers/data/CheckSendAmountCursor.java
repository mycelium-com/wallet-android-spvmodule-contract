package com.mycelium.spvmodule.providers.data;

import android.database.MatrixCursor;

import com.mycelium.spvmodule.providers.TransactionContract;

/**
 * The custom cursor that defines data returned by {@link TransactionContract.CheckSendAmount#TABLE_NAME}
 */
public class CheckSendAmountCursor extends MatrixCursor {

    private static String[] columnNames = {
            TransactionContract.CheckSendAmount.TX_FEE,
            TransactionContract.CheckSendAmount.TX_FEE_FACTOR,
            TransactionContract.CheckSendAmount.AMOUNT_TO_SEND,
            TransactionContract.CheckSendAmount.RESULT
    };

    public CheckSendAmountCursor() {
        super(columnNames, 1);
    }
}
