package com.mycelium.spvmodule.providers;

import android.content.ContentResolver;
import android.net.Uri;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The contract between the [TransactionContentProvider] and clients. Contains definitions
 * for the supported URIs and columns.
 */
public class TransactionContract {
    public static class TransactionSummary {
        public static final String TABLE_NAME = "txn"; // "transaction" is an SQL reserved word.
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/vnd.com.mycelium.transaction";

        public static final String _ID = "_id";
        public static final String VALUE = "value";
        public static final String SYMBOL = "symbol";
        public static final String IS_INCOMING = "isIncoming";
        public static final String TIME = "time";
        public static final String SINCE = "since";
        public static final String HEIGHT = "height";
        public static final String CONFIRMATIONS = "confirmations";
        public static final String IS_QUEUED_OUTGOING = "isQueuedOutgoing";
        public static final String CONFIRMATION_RISK_PROFILE_LENGTH = "confirmationRiskProfileLength";
        public static final String CONFIRMATION_RISK_PROFILE_RBF_RISK = "confirmationRiskProfileRbfRisk";
        public static final String CONFIRMATION_RISK_PROFILE_DOUBLE_SPEND = "confirmationRiskProfileDoubleSpend";
        public static final String DESTINATION_ADDRESS = "destinationAddress";
        public static final String TO_ADDRESSES = "toAddresses";
        public static final String ACCOUNT_INDEX = "accountIndex";
        public static final String SINGLE_ADDRESS_ACCOUNT_GUID = "singleAddressAccountGUID";

        public static final String SELECTION_ACCOUNT_INDEX = ACCOUNT_INDEX + " = ?";
        public static final String SELECTION_ACCOUNT_INDEX_SINCE = SELECTION_ACCOUNT_INDEX +
                " AND " + SINCE + " = ?";

        public static final String SELECTION_SINGLE_ADDRESS_ACCOUNT_GUID = SINGLE_ADDRESS_ACCOUNT_GUID + " = ?";
        public static final String SELECTION_SINGLE_ADDRESS_ACCOUNT_GUID_SINCE = SINGLE_ADDRESS_ACCOUNT_GUID + " = ?" +
                " AND " + SINCE + " = ?";

        public static final String SELECTION_ID = SELECTION_ACCOUNT_INDEX + " AND " + _ID
            + " = ?";

        public static Uri CONTENT_URI(String packageName) {
            return Uri.withAppendedPath(AUTHORITY_URI(packageName), TABLE_NAME);
        }
    }

    public static class TransactionDetails {
        public static final String TABLE_NAME = "txndtls"; // "transaction" is an SQL reserved word.
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/vnd.com.mycelium.transaction";

        public static final String _ID = "_id";
        public static final String TIME = "time";
        public static final String HEIGHT = "height";
        public static final String ACCOUNT_INDEX = "accountIndex";

        public static final String SELECTION_ACCOUNT_INDEX = ACCOUNT_INDEX + " = ?";
        @NotNull
        public static final String RAW_SIZE = "rawSize";
        @NotNull
        public static final String INPUTS = "inputs";
        @NotNull
        public static final String OUTPUTS = "outputs";

        public static Uri CONTENT_URI(String packageName) {
            return Uri.withAppendedPath(AUTHORITY_URI(packageName), TABLE_NAME);
        }
    }

    public static class AccountBalance {
        public static final String TABLE_NAME = "acntblc"; // "transaction" is an SQL reserved word.
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/vnd.com.mycelium.transaction";

        public static final String _ID = "_id";
        public static final String CONFIRMED = "confirmed";
        public static final String SENDING = "sending";
        public static final String RECEIVING = "receiving";
        public static final String SYMBOL = "symbol";
        public static final String ACCOUNT_INDEX = "accountIndex";
        public static final String SINGLE_ADDRESS_ACCOUNT_GUID = "singleAddressAccountGUID";

        public static final String SELECTION_ACCOUNT_INDEX = ACCOUNT_INDEX + " = ?";

        public static final String SELECTION_SINGLE_ADDRESS_ACCOUNT_GUID = SINGLE_ADDRESS_ACCOUNT_GUID + " = ?";

        public static Uri CONTENT_URI(String packageName) {
            return Uri.withAppendedPath(AUTHORITY_URI(packageName), TABLE_NAME);
        }
    }

    public static class CurrentReceiveAddress {
        public static final String TABLE_NAME = "receiveaddress";
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/vnd.com.mycelium.address";

        public static final String _ID = "_id";
        public static final String ADDRESS = "address";
        public static final String ADDRESS_QR = "addressQr";
        public static final String ACCOUNT_INDEX = "accountIndex";
        public static final String SINGLE_ADDRESS_ACCOUNT_GUID = "singleAddressAccountGUID";

        public static final String SELECTION_ACCOUNT_INDEX = ACCOUNT_INDEX + " = ?";

        public static final String SELECTION_SINGLE_ADDRESS_ACCOUNT_GUID = SINGLE_ADDRESS_ACCOUNT_GUID + " = ?";

        public static Uri CONTENT_URI(String packageName) {
            return Uri.withAppendedPath(AUTHORITY_URI(packageName), TABLE_NAME);
        }
    }

    public static class ValidateQrCode {
        public static final String TABLE_NAME = "validateqrcode";
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/vnd.com.mycelium.qrcode";

        public static final String QR_CODE = "qrCode";
        public static final String IS_VALID = "isValid";
        public static final String ACCOUNT_INDEX = "accountIndex";

        public static final String SELECTION_ACCOUNT_INDEX = ACCOUNT_INDEX + " = ?";
        public static final String SELECTION_QR_CODE = QR_CODE + " = ?";

        public static final String SELECTION_COMPLETE = SELECTION_ACCOUNT_INDEX + " AND " + SELECTION_QR_CODE;

        public static Uri CONTENT_URI(String packageName) {
            return Uri.withAppendedPath(AUTHORITY_URI(packageName), TABLE_NAME);
        }
    }

    public static class CalculateMaxSpendable {
        public static final String TABLE_NAME = "calculatemaxspendable";
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/vnd.com.mycelium.calculate";

        public static final String TX_FEE = "txFee";
        public static final String TX_FEE_FACTOR = "txFeeFactor";
        public static final String MAX_SPENDABLE = "maxSpendable";
        public static final String SYMBOL = "symbol";
        public static final String ACCOUNT_INDEX = "accountIndex";

        public static final String SELECTION_ACCOUNT_INDEX = ACCOUNT_INDEX + " = ?";
        public static final String SELECTION_TX_FEE = TX_FEE + " = ? AND " + TX_FEE_FACTOR + " = ?";

        public static final String SELECTION_COMPLETE = SELECTION_ACCOUNT_INDEX + " AND " + SELECTION_TX_FEE;

        public static Uri CONTENT_URI(String packageName) {
            return Uri.withAppendedPath(AUTHORITY_URI(packageName), TABLE_NAME);
        }
    }

    public static class CheckSendAmount {
        public static final String TABLE_NAME = "checksendamount";
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/vnd.com.mycelium.calculate";

        public static final String TX_FEE = "txFee";
        public static final String TX_FEE_FACTOR = "txFeeFactor";
        public static final String AMOUNT_TO_SEND = "amountToSend";
        public static final String RESULT = "result";
        public static final String ACCOUNT_INDEX = "accountIndex";

        public static final String SELECTION_ACCOUNT_INDEX = ACCOUNT_INDEX + " = ?";
        public static final String SELECTION_TX_FEE = TX_FEE + " = ? AND " + TX_FEE_FACTOR + " = ?";
        public static final String SELECTION_AMOUNT_TO_SEND = AMOUNT_TO_SEND + " = ?";

        public static final String SELECTION_COMPLETE = SELECTION_ACCOUNT_INDEX + " AND " + SELECTION_TX_FEE + " AND " + SELECTION_AMOUNT_TO_SEND;

        public static Uri CONTENT_URI(String packageName) {
            return Uri.withAppendedPath(AUTHORITY_URI(packageName), TABLE_NAME);
        }

        public enum Result {
            RESULT_OK,
            RESULT_INVALID,
            RESULT_NOT_ENOUGH_FUNDS
        }
    }

    public static class ValidateAddress {
        public static final String TABLE_NAME = "validateaddress";
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/vnd.com.mycelium.address";

        public static final String ADDRESS = "address";
        public static final String IS_VALID = "isValid";

        public static final String SELECTION_ADDRESS = ADDRESS + " = ?";

        public static final String SELECTION_COMPLETE = SELECTION_ADDRESS;

        public static Uri CONTENT_URI(String packageName) {
            return Uri.withAppendedPath(AUTHORITY_URI(packageName), TABLE_NAME);
        }
    }

    public static class GetSyncProgress {
        public static final String TABLE_NAME = "getsyncprogress";

        public static final String PERCENT = "percent";

        public static Uri CONTENT_URI(String packageName) {
            return Uri.withAppendedPath(AUTHORITY_URI(packageName), TABLE_NAME);
        }
    }


    public static class GetPrivateKeysCount {
        public static final String TABLE_NAME = "getprivatekeyscount";

        public static final String KEYS_COUNT = "keysCount";

        public static Uri CONTENT_URI(String packageName) {
            return Uri.withAppendedPath(AUTHORITY_URI(packageName), TABLE_NAME);
        }
    }

    public static String AUTHORITY(String packageName) {
        return packageName + ".providers.TransactionContentProvider";
    }

    /**
     * A content:// style uri to the authority for the contacts provider
     */
    private static Uri AUTHORITY_URI(String packageName) {
        return Uri.parse("content://" + AUTHORITY(packageName));
    }
}