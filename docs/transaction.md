# Bitcoindiamod 交易

交易相关的详细 Demo 见 [BCDTransactionDemo](../src/main/java/org/bitcoindiamond/demo/BCDTransaction.java)

## 与Bitcoin交易区别

- 普通交易 version 版本号为 **12**， Coinbase 交易版本号是 **1**。
- 交易结构中在 version 后有 **32** 字节的当前区块Hash数据，即交易构建时最新的区块Hash，Coinbase交易无此数据，其他交易都需要携带此数据，目前数据不做检查，只需要 **非0** 即可。
- 交易中的数额小数位数最多只有 **7** 位，即 1 satoshi = 0.0000001 BCD。

## 构建交易

构建方式与Bitcoin基本相同，主要交易结构如下：

> Version (版本号) + BlockHash (区块Hash) + Inputs (交易输入) + Outputs (交易输出) + LockTime (锁定时间)

创建交易主要代码如下：

```java
// 创建空交易
Transaction tx = new Transaction(params);

// 增加输入
Script script = ScriptBuilder.createOutputScript(sourceAddress);
tx.addInput(Sha256Hash.wrap(utxo_txid), utxo_index, script);

// 增加输出
tx.addOutput(Coin.valueOf(toAmount), toAddress);
```

创建的空交易设置Version为12， BlockHash有默认值，推荐自行设置BlockHash为当前区块Hash，设置方法为:

```java
tx.setPresentBlockHash(Sha256Hash.wrap(blockHash));
```

## 离线签名

以 P2PKH 为例

```java
// 获取输入中 UTXO 的 scriptPubKey
Script scriptPubKey = tx.getInput(0).getScriptSig();
// 计算需要签名的 Hash 数据
Sha256Hash hash = tx.hashForSignature(0, scriptPubKey, Transaction.SigHash.ALL, true);
// 对 Hash 数据签名
ECKey.ECDSASignature ecdsaSignature = key.sign(hash);
// 创建签名数据
TransactionSignature txSignature = new TransactionSignature(ecdsaSignature, Transaction.SigHash.ALL, true);
// 交易输入中添加签名数据
tx.getInput(0).setScriptSig(ScriptBuilder.createInputScript(txSignature, key));
```

## 序列化、反序列化

```java
// 序列化
byte[] rawTransaction = tx.bitcoinSerialize();
String hexRawTransaction = Utils.HEX.encode(rawTransaction);

// 反序列化
byte[] newRawTransaction = Utils.HEX.decode(hexRawTransaction);
Transaction newTx = new Transaction(params, newRawTransaction);
```

## 广播交易

通过节点的 JSON RPC 接口广播交易 (使用 [bitcoin-rpc-client](https://github.com/Polve/bitcoin-rpc-client))

```java
// 开启节点 JSON RPC 服务，配置中增加 server=1
String user = "bcd";  // 节点配置增加 rpcuser=bcd
String password = "123456";  // 节点配置增加 rpcpassword=123456
String host = "127.0.0.1";  // 节点 IP
String port = "7116";  // 节点端口

try {
    URL url = new URL("http://" + user + ':' + password + "@" + host + ":" + port + "/");

    // 创建 RPC 客户端
    BitcoinJSONRPCClient bitcoinClient = new BitcoinJSONRPCClient(url);

    // 通过 sendrawtransaction 接口广播交易
    String broadcastResult = bitcoinClient.sendRawTransaction(transactionRawHex);
    System.out.println("Broadcast transaction result: " + broadcastResult);
} catch (Exception e) {
    e.printStackTrace();
}
```