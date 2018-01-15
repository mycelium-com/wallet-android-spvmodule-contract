package com.mycelium.spvmodule.providers.data;

import android.database.MatrixCursor;

import com.mycelium.spvmodule.providers.TransactionContract;

/**
 * The custom cursor that defines data returned by {@link TransactionContract.CurrentReceiveAddress#TABLE_NAME}
 */
public class CurrentReceiveAddressCursor extends MatrixCursor {
    private static String[] columnNames = {
            TransactionContract.CurrentReceiveAddress._ID,
            TransactionContract.CurrentReceiveAddress.ADDRESS,
            TransactionContract.CurrentReceiveAddress.ADDRESS_QR
    };

    public CurrentReceiveAddressCursor() {
        super(columnNames, 1);
    }
}
