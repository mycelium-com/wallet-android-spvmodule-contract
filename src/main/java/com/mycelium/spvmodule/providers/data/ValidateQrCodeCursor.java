package com.mycelium.spvmodule.providers.data;

import android.database.MatrixCursor;

import com.mycelium.spvmodule.providers.TransactionContract;

/**
 * The custom cursor that defines data returned by {@link TransactionContract.ValidateQrCode#TABLE_NAME}
 */
public class ValidateQrCodeCursor extends MatrixCursor {

    private static String[] columnNames = {
            TransactionContract.ValidateQrCode.QR_CODE,
            TransactionContract.ValidateQrCode.IS_VALID
    };

    public ValidateQrCodeCursor() {
        super(columnNames, 1);
    }
}
