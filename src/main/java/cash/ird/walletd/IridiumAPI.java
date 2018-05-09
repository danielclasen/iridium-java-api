package cash.ird.walletd;

import cash.ird.walletd.model.body.*;
import cash.ird.walletd.rpc.exception.IridiumWalletdException;

import java.util.List;

public interface IridiumAPI {

    boolean reset(String viewSecretKey) throws IridiumWalletdException;

    boolean save() throws IridiumWalletdException;

    String getViewKey() throws IridiumWalletdException;

    SpendKeyPair getSpendKeys(String address) throws IridiumWalletdException;

    Status getStatus(String address) throws IridiumWalletdException;

    List<String> getAddresses() throws IridiumWalletdException;

    String createAddress(String secretSpendKey, String publicSpendKey) throws IridiumWalletdException;

    boolean deleteAddress(String address) throws IridiumWalletdException;

    Balance getBalance(String address) throws IridiumWalletdException;

    List<String> getBlockHashes(long firstBlockIndex, long blockCount) throws IridiumWalletdException;

    List<TxHashBag> getTransactionHashes(String blockHash, long blockCount, List<String> addresses, String paymentId) throws IridiumWalletdException;

    List<TxHashBag> getTransactionHashes(long firstBlockIndex, long blockCount, List<String> addresses, String paymentId) throws IridiumWalletdException;

    List<TxItemBag> getTransactions(String blockHash, long blockCount, List<String> addresses, String paymentId) throws IridiumWalletdException;

    List<TxItemBag> getTransactions(long firstBlockIndex, long blockCount, List<String> addresses, String paymentId) throws IridiumWalletdException;

    List<String> getUnconfirmedTransactionHashes(List<String> addresses) throws IridiumWalletdException;

    Transaction getTransaction(String transactionHash) throws IridiumWalletdException;

    String sendTransaction(List<Transfer> transfers, long fee, int anonymity, String changeAddress, List<String> addresses, String extra, Long unlockTime, String paymentId) throws IridiumWalletdException;

    String createDelayedTransaction(List<Transfer> transfers, long fee, int anonymity, String changeAddress, List<String> addresses, String extra, Long unlockTime, String paymentId) throws IridiumWalletdException;

    List<String> getDelayedTransactionHashes() throws IridiumWalletdException;

    boolean deleteDelayedTransaction(String transactionHash) throws IridiumWalletdException;

    boolean sendDelayedTransaction(String transactionHash) throws IridiumWalletdException;

    String sendFusionTransaction(long threshold, int anonymity, String destinationAddress, List<String> addresses) throws IridiumWalletdException;

    EstimatedFusion estimateFusion(long threshold, List<String> addresses) throws IridiumWalletdException;


}