package com.mycelium.spvmodule.providers.data;

import android.database.MatrixCursor;

import com.mycelium.spvmodule.providers.TransactionContract;

/**
 * The custom cursor that defines data returned by {@link TransactionContract.ValidateAddress#TABLE_NAME}
 */
public class ValidateAddressCursor extends MatrixCursor {

    private static String[] columnNames = {
            TransactionContract.ValidateAddress.ADDRESS,
            TransactionContract.ValidateAddress.IS_VALID
    };

    public ValidateAddressCursor() {
        super(columnNames, 1);
    }
}
