package com.mycelium.spvmodule;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

/**
 * The contract between the [SpvService] and clients. Contains definitions
 * for the supported Actions.
 */
public interface IntentContract {
    String ACCOUNT_INDEXES_EXTRA = "ACCOUNT_INDEXES";
    String ACCOUNT_INDEX_EXTRA = "ACCOUNT_INDEX";
    String CREATIONTIMESECONDS = "CREATIONTIMESECONDS";
    String UNRELATED_ACCOUNT_GUID = "UNRELATED_ACCOUNT_GUID";
    String UNRELATED_ACCOUNT_TYPE = "UNRELATED_ACCOUNT_TYPE";
    String SATOSHIS_RECEIVED = "satoshisReceived";
    String SATOSHIS_SENT = "satoshisSent";
    String ACCOUNTS_INDEX = "accountsIndex";
    String OPERATION_ID = "operationId";
    String TRANSACTION_HASH = "transactionHash";
    String IS_SUCCESS = "is_success";
    String MESSAGE = "message";
    String TRANSACTIONS = "TRANSACTIONS";
    String CONNECTED_OUTPUTS = "CONNECTED_OUTPUTS";
    String UTXOS = "UTXOS";
    String TRANSACTION_BYTES = "TRANSACTION_BYTES";
    String ADDRESSES = "ADDRESSES";
    String UNSIGNED_TRANSACTION = "UNSIGNED_TRANSACTION";

    // hierarchically deterministic (bip32/44/47)
    int UNRELATED_ACCOUNT_TYPE_HD = 1;
    // single address
    int UNRELATED_ACCOUNT_TYPE_SA = 2;

    class BroadcastTransaction {
        public static final String ACTION = "com.mycelium.wallet.broadcastTransaction";
        public static final String TX_EXTRA = ACTION + "_tx";

        public static Intent createIntent(byte[] transaction) {
            return new Intent(ACTION)
                    .putExtra(TX_EXTRA, transaction);
        }
    }

    class ReceiveTransactions {
        public static final String ACTION = "com.mycelium.wallet.receiveTransactions";

        public static Intent createIntent(int accountId) {
            return new Intent(ACTION)
                    .putExtra(IntentContract.ACCOUNT_INDEX_EXTRA, accountId);
        }
    }

    class ReceiveTransactionsUnrelated {
        public static final String ACTION = "com.mycelium.wallet.receiveTransactionsSingleAddress";

        public static Intent createIntent(String guid, int accountType) {
            return new Intent(ACTION)
                    .putExtra(IntentContract.UNRELATED_ACCOUNT_GUID, guid)
                    .putExtra(IntentContract.UNRELATED_ACCOUNT_TYPE, accountType);
        }
    }

    class RequestAccountLevelKeysToSPV {
        public static final String ACTION = "com.mycelium.wallet.requestAccountLevelKeysToSPV";
        public static final String ACCOUNT_KEYS = ACTION + "_accountKeys";
        public static final String CREATION_TIME_SECONDS_EXTRA = ACTION + "_creationTimeSeconds";

        public static Intent createIntent(List<Integer> accountIds, List<String> watchingKeysB58, long creationTimeSeconds) {
            return new Intent(ACTION)
                    .putIntegerArrayListExtra(IntentContract.ACCOUNT_INDEXES_EXTRA, new ArrayList<>(accountIds))
                    .putStringArrayListExtra(ACCOUNT_KEYS, new ArrayList<>(watchingKeysB58))
                    .putExtra(CREATION_TIME_SECONDS_EXTRA, creationTimeSeconds);
        }
    }

    class SendUnrelatedPublicKeyToSPV {
        public static final String ACTION = "com.mycelium.wallet.sendSingleAddressPublicKeyToSPV";
        public static final String UNRELATED_ACCOUNT_GUID = ACTION + "_singleAddressGuid";
        public static final String PUBLIC_KEY_B58 = ACTION + "_data";

        public static Intent createIntent(String guid, String pubKeyB58, int accountType) {
            return new Intent(ACTION)
                    .putExtra(UNRELATED_ACCOUNT_GUID, guid)
                    .putExtra(PUBLIC_KEY_B58, pubKeyB58)
                    .putExtra(UNRELATED_ACCOUNT_TYPE, accountType);
        }
    }

    class SendUnrelatedWatchedAddressToSPV {
        public static final String ACTION = "com.mycelium.wallet.requestSingleAddressPublicKeyToSPV";
        public static final String UNRELATED_ACCOUNT_GUID = ACTION + "_singleAddressGuid";
        public static final String ADDRESS = ACTION + "_address";

        public static Intent createIntent(String guid, String address) {
            return new Intent(ACTION)
                    .putExtra(UNRELATED_ACCOUNT_GUID, guid)
                    .putExtra(ADDRESS, address);
        }
    }

    class CreateUnsignedTransaction {
        public static final String ACTION = "com.mycelium.wallet.createUnsignedTransaction";
        public static final String TX_EXTRA = ACTION + "_tx";

        public static Intent createIntent(int accountIndex, byte[] transaction) {
            return new Intent(ACTION)
                    .putExtra(ACCOUNT_INDEX_EXTRA, accountIndex)
                    .putExtra(TX_EXTRA, transaction);
        }
    }

    class SendSignedTransactionToSPV {
        public static final String ACTION = "com.mycelium.wallet.sendSignedTransactionToSPV";
        public static final String TX_EXTRA = ACTION + "_tx";

        public static Intent createIntent(String operationId, int accountIndex, byte[] transaction) {
            return new Intent(ACTION)
                    .putExtra(ACCOUNT_INDEX_EXTRA, accountIndex)
                    .putExtra(OPERATION_ID, operationId)
                    .putExtra(TX_EXTRA, transaction);
        }
    }

    class SendSignedTransactionUnrelatedToSPV {
        public static final String ACTION = "com.mycelium.wallet.sendSignedTransactionSingleAddressToSPV";
        public static final String TX_EXTRA = ACTION + "_tx";
        public static final String UNRELATED_ACCOUNT_GUID = ACTION + "_singleAddressGuid";

        public static Intent createIntent(String operationId, String guid, byte[] transaction) {
            return new Intent(ACTION)
                    .putExtra(UNRELATED_ACCOUNT_GUID, guid)
                    .putExtra(OPERATION_ID, operationId)
                    .putExtra(TX_EXTRA, transaction);
        }
    }

    class SendFunds {
        public static final String ACTION = "com.mycelium.wallet.sendFunds";
        public static final String OPERATION_ID = ACTION + "_opId";
        public static final String ADDRESS_EXTRA = ACTION + "_address";
        public static final String AMOUNT_EXTRA = ACTION + "_amount";
        public static final String FEE_EXTRA = ACTION + "_fee";
        public static final String FEE_FACTOR_EXTRA = ACTION + "_fee_factor";

        public static Intent createIntent(String operationId, int accountId, String address, long amount, TransactionFee txFee, float txFeeFactor) {
            return new Intent(ACTION)
                    .putExtra(IntentContract.ACCOUNT_INDEX_EXTRA, accountId)
                    .putExtra(OPERATION_ID, operationId)
                    .putExtra(ADDRESS_EXTRA, address)
                    .putExtra(AMOUNT_EXTRA, amount)
                    .putExtra(FEE_EXTRA, txFee.name())
                    .putExtra(FEE_FACTOR_EXTRA, txFeeFactor);
        }
    }

    class SendFundsUnrelated {
        public static final String ACTION = "com.mycelium.wallet.sendFundsSingleAddress";
        public static final String OPERATION_ID = ACTION + "_opId";
        public static final String ADDRESS_EXTRA = ACTION + "_address";
        public static final String AMOUNT_EXTRA = ACTION + "_amount";
        public static final String FEE_EXTRA = ACTION + "_fee";
        public static final String FEE_FACTOR_EXTRA = ACTION + "_fee_factor";
        public static final String ACCOUNT_TYPE = ACTION + "_account_type";

        public static Intent createIntent(String operationId, String guid, String address, long amount, TransactionFee fee, float txFeeFactor, int accountType) {
            return new Intent(ACTION)
                    .putExtra(OPERATION_ID, operationId)
                    .putExtra(IntentContract.UNRELATED_ACCOUNT_GUID, guid)
                    .putExtra(ADDRESS_EXTRA, address)
                    .putExtra(AMOUNT_EXTRA, amount)
                    .putExtra(FEE_EXTRA, fee.name())
                    .putExtra(FEE_FACTOR_EXTRA, txFeeFactor)
                    .putExtra(ACCOUNT_TYPE, accountType);
        }
    }

    /**
     * Query the intents queue
     */
    class WaitingIntents {
        public static final String ACTION = "com.mycelium.wallet.waitingIntents";
        public static final String RESULT_ACTION = "com.mycelium.wallet.waitingIntentsResult";
        public static final String WAITING_ACTIONS = ACTION + "_actions";

        public static Intent createResultIntent(int accountId, String[] waitingActions) {
            return new Intent(RESULT_ACTION)
                    .putExtra(IntentContract.ACCOUNT_INDEX_EXTRA, accountId)
                    .putExtra(WAITING_ACTIONS, waitingActions);
        }

        public static Intent createIntent(int accountId) {
            return new Intent(ACTION)
                    .putExtra(IntentContract.ACCOUNT_INDEX_EXTRA, accountId);
        }
    }

    class RemoveHdWalletAccount {
        public static final String ACTION = "com.mycelium.wallet.removeHdWalletAccount";

        public static Intent createIntent(int accountId) {
            return new Intent(ACTION)
                    .putExtra(IntentContract.ACCOUNT_INDEX_EXTRA, accountId);
        }
    }

    class RemoveUnrelatedAccount {
        public static final String ACTION = "com.mycelium.wallet.removeSingleAddressWalletAccount";

        public static Intent createIntent(String guid) {
            return new Intent(ACTION)
                    .putExtra(IntentContract.UNRELATED_ACCOUNT_GUID, guid);
        }

    }

    /**
     * This intent should be called when app is first started to ensure that no old data related to
     * old app installations remains in modules.
     */
    class ForceCacheClean {
        public static final String ACTION = "com.mycelium.wallet.forceCacheClean";

        public static Intent createIntent() {
            return new Intent(ACTION);
        }
    }
}
