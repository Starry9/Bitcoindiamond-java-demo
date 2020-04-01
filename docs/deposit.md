# 钱包充值处理

用户钱包可以分配一个或者多个独立随机私钥对应生成的地址，也可是使用HD的方式从助记词生成的主私钥（主公钥）来按照一定的推导序列来生成对应的用户地址，用户充值时，需要对用户地址相关的交易进行订阅，订阅的方式可以是分析所有新区块/新交易来检查是否有用户地址相关的数据。

钱包服务需要接收到当前Bitcoindiamond网络产生的所有新区块和新交易，对新交易或者区块中的交易进行分析交易输出，解析出交易输出脚本对应的地址是否和钱包中的地址匹配，对匹配的地址记录本交易输出中的数值进行充值，当充值交易的确认数超过6-10个确认之后，可以认为钱包中此地址充值成功。

接收区块链网络中的所有新区块和新交易可以考虑两种方式：一种是使用 P2P 的方式与Bitcoindiamond 节点互联，新的交易和区块都会通过P2P的消息进行传递；还有一种是通过 ZeroMQ（ØMQ、zmq）的方式，编写zmq客户端订阅Bitcoindiamond节点的推送数据。

推荐使用zmq的方式，本文档以zmq的方式解释说明新区块与新交易的解析。

## ØMQ订阅交易和区块

在节点配置文件 bitcoin.conf 中开启zmq推送服务

```shell
# 启用 ZMQ 
zmqpubhashblock=tcp://127.0.0.1:58333
zmqpubhashtx=tcp://127.0.0.1:58333
zmqpubrawblock=tcp://127.0.0.1:58333
zmqpubrawtx=tcp://127.0.0.1:58333
```

编写zmq客户端，在上述配置端口进行订阅 topic： “hashblock”、“hashtx”、“rawblock”、“rawtx”。

## ØMQ消息

有新交易或新区块时，zmq客户端会收到相应推送，接收到的二进制消息分为3部分

> **sequence + topic + body**

- sequence 整形序号

- topic 即上面订阅的  “hashblock”、“hashtx”、“rawblock”、“rawtx”

- body 即相应数据
  - hashblock 对应区块 Hash
  - hashtx 对应交易 Hash
  - rawblock 对应原始区块数据
  - rawtx 对应原始交易数据

## 解析区块

### RPC解析

接收到hashblock数据之后，可以通过 Bitcoindiamond 节点的 RPC 命令 getblock 获取完整区块解析数据。

> getblock 9fe5c677efcb138f41554f8e576781ab57263490a076d1bfa22c5bb20650dcea 2
> ￼
> {
>   "hash": "9fe5c677efcb138f41554f8e576781ab57263490a076d1bfa22c5bb20650dcea",
>   "powhash": "000000000000045f368c30e7bd21d690b89ce4aca59586c8046da42a7b356ffd",
>   "confirmations": 7,
>   "strippedsize": 379,
>   "size": 524,
>   "weight": 1661,
>   "height": 612341,
>   "version": 1610612736,
>   "versionHex": "60000000",
>   "merkleroot": "00fba80c193495571f36fc71347e11a54f48602fcf34250bfae4bbc6a2bb2bbd",
>   "tx": [
>     {
>       "txid": "779ad0c9d1a0e6991e6ed80eea47b638844d7774d725b9a70b049002e978dd96",
>       "hash": "04559b653a6887e9f7c603b1bcbc007c8c03b384390dd3b0d576a70cd7567c3d",
>       "version": 1,
>       "size": 196,
>       "vsize": 169,
>       "weight": 676,
>       "locktime": 0,
>       "vin": [
>         {
>           "coinbase": "03f5570904539a815e08908fbd5243000000097575706f6f6c2e636e",
>           "sequence": 0
>         }
>       ],
>       "vout": [
>         {
>           "value": 0.0000000,
>           "n": 0,
>           "scriptPubKey": {
>             "asm": "OP_RETURN aa21a9ed1778d0c100d7b665cf564965d49674fad3076108f21cb028fa8455ae859d72fa",
>             "hex": "6a24aa21a9ed1778d0c100d7b665cf564965d49674fad3076108f21cb028fa8455ae859d72fa",
>             "type": "nulldata"
>           }
>         },
>         {
>           "value": 125.0010000,
>           "n": 1,
>           "scriptPubKey": {
>             "asm": "OP_DUP OP_HASH160 02540af6c20108e78105b871b0e8c0d8dc82addc OP_EQUALVERIFY OP_CHECKSIG",
>             "hex": "76a91402540af6c20108e78105b871b0e8c0d8dc82addc88ac",
>             "reqSigs": 1,
>             "type": "pubkeyhash",
>             "addresses": [
>               "1DK2nLeaxCx1LgJLBzXNX3M5Vnc3ZocSW"
>             ]
>           }
>         }
>       ],
>       "hex": "010000000001010000000000000000000000000000000000000000000000000000000000000000ffffffff1c03f5570904539a815e08908fbd5243000000097575706f6f6c2e636e00000000020000000000000000266a24aa21a9ed1778d0c100d7b665cf564965d49674fad3076108f21cb028fa8455ae859d72fa90a3814a000000001976a91402540af6c20108e78105b871b0e8c0d8dc82addc88ac0120000000000000000000000000000000000000000000000000000000000000000000000000"
>     },
>     {
>       "txid": "d7afa9ef2391ff4f194e9dafda71a808b6f7e16b643560389eaa15537ad2b34d",
>       "hash": "5f15f148492ca4fcb2bfc68ee5b05b3e8a4b6a8a7990c8e7f93412bd0ae8101f",
>       "version": 12,
>       "size": 247,
>       "vsize": 166,
>       "weight": 661,
>       "locktime": 0,
>       "vin": [
>         {
>           "txid": "00af254b8ad00993f9a78447be668be3208a2f460b6e15716caa5e7ffc7d6941",
>           "vout": 0,
>           "scriptSig": {
>             "asm": "001471664f1be1957f5a57fd0ed6b9a002ae4e913ea0",
>             "hex": "16001471664f1be1957f5a57fd0ed6b9a002ae4e913ea0"
>           },
>           "txinwitness": [
>             "3044022003ff244a3f38682da0bf9d526dc3aa56fc3ab6dfa4471fe2c6c626b5494e818402206938b0310161907bf1c275fb561afb6e2a4b1523dfdf03a3e72a15aa91fc354101",
>             "03f4e9193c6783b18af381ddd34dc173a8adf2ea314c443aea2e2df2ce67895de4"
>           ],
>           "sequence": 4294967295
>         }
>       ],
>       "vout": [
>         {
>           "value": 5.6990000,
>           "n": 0,
>           "scriptPubKey": {
>             "asm": "OP_HASH160 a4ba523a5f1624af596188b44e177f3a8519b8c2 OP_EQUAL",
>             "hex": "a914a4ba523a5f1624af596188b44e177f3a8519b8c287",
>             "reqSigs": 1,
>             "type": "scripthash",
>             "addresses": [
>               "3Gi1wpyxv7y4NqnkDDfKcXAjyTfTiDt1LZ"
>             ]
>           }
>         }
>       ],
>       "hex": "0c0000002ba634ace4b9f9ca00cd3d977f4c2c72976687398623e18c38abbe4a1617abb800010141697dfc7f5eaa6c71156e0b462f8a20e38b66be4784a7f99309d08a4b25af00000000001716001471664f1be1957f5a57fd0ed6b9a002ae4e913ea0ffffffff01309965030000000017a914a4ba523a5f1624af596188b44e177f3a8519b8c28702473044022003ff244a3f38682da0bf9d526dc3aa56fc3ab6dfa4471fe2c6c626b5494e818402206938b0310161907bf1c275fb561afb6e2a4b1523dfdf03a3e72a15aa91fc3541012103f4e9193c6783b18af381ddd34dc173a8adf2ea314c443aea2e2df2ce67895de400000000"
>     }
>   ],
>   "time": 1585551955,
>   "mediantime": 1585549259,
>   "nonce": 3348295427,
>   "bits": "1a053387",
>   "difficulty": 3225545.295903729,
>   "chainwork": "000000000000000000000000000000000000000000b80c991653e4b5c9b0053f",
>   "nTx": 2,
>   "previousblockhash": "b8ab17164abeab388ce1238639876697722c4c7f973dcd00caf9b9e4ac34a62b",
>   "nextblockhash": "3d65bd955bca5cce334afee24086f91d41a1ab164e709ebd419d5c1c71eb63f1"
> }

### 反序列化

接收到rawblock数据之后，可以对数据进行区块反序列化

区块原始数据

> 000000602ba634ace4b9f9ca00cd3d977f4c2c72976687398623e18c38abbe4a1617abb8bd2bbba2c6bbe4fa0b2534cf2f60484fa5117e3471fc361f579534190ca8fb00539a815e8733051a03ef92c702010000000001010000000000000000000000000000000000000000000000000000000000000000ffffffff1c03f5570904539a815e08908fbd5243000000097575706f6f6c2e636e00000000020000000000000000266a24aa21a9ed1778d0c100d7b665cf564965d49674fad3076108f21cb028fa8455ae859d72fa90a3814a000000001976a91402540af6c20108e78105b871b0e8c0d8dc82addc88ac01200000000000000000000000000000000000000000000000000000000000000000000000000c0000002ba634ace4b9f9ca00cd3d977f4c2c72976687398623e18c38abbe4a1617abb800010141697dfc7f5eaa6c71156e0b462f8a20e38b66be4784a7f99309d08a4b25af00000000001716001471664f1be1957f5a57fd0ed6b9a002ae4e913ea0ffffffff01309965030000000017a914a4ba523a5f1624af596188b44e177f3a8519b8c28702473044022003ff244a3f38682da0bf9d526dc3aa56fc3ab6dfa4471fe2c6c626b5494e818402206938b0310161907bf1c275fb561afb6e2a4b1523dfdf03a3e72a15aa91fc3541012103f4e9193c6783b18af381ddd34dc173a8adf2ea314c443aea2e2df2ce67895de400000000

其中前80个字节为区块头

> 000000602ba634ace4b9f9ca00cd3d977f4c2c72976687398623e18c38abbe4a1617abb8bd2bbba2c6bbe4fa0b2534cf2f60484fa5117e3471fc361f579534190ca8fb00539a815e8733051a03ef92c7

81 字节开始为 varint

> 02 

后面即两个交易

> 010000000001010000000000000000000000000000000000000000000000000000000000000000ffffffff1c03f5570904539a815e08908fbd5243000000097575706f6f6c2e636e00000000020000000000000000266a24aa21a9ed1778d0c100d7b665cf564965d49674fad3076108f21cb028fa8455ae859d72fa90a3814a000000001976a91402540af6c20108e78105b871b0e8c0d8dc82addc88ac0120000000000000000000000000000000000000000000000000000000000000000000000000

> 0c0000002ba634ace4b9f9ca00cd3d977f4c2c72976687398623e18c38abbe4a1617abb800010141697dfc7f5eaa6c71156e0b462f8a20e38b66be4784a7f99309d08a4b25af00000000001716001471664f1be1957f5a57fd0ed6b9a002ae4e913ea0ffffffff01309965030000000017a914a4ba523a5f1624af596188b44e177f3a8519b8c28702473044022003ff244a3f38682da0bf9d526dc3aa56fc3ab6dfa4471fe2c6c626b5494e818402206938b0310161907bf1c275fb561afb6e2a4b1523dfdf03a3e72a15aa91fc3541012103f4e9193c6783b18af381ddd34dc173a8adf2ea314c443aea2e2df2ce67895de400000000

可使用 [BCDTransactionDemo](../src/main/java/org/bitcoindiamond/demo/BCDTransaction.java) 中的交易反序列化进行解析

```java
// 反序列化
byte[] newRawTransaction = Utils.HEX.decode(hexRawTransaction);
Transaction newTx = new Transaction(params, newRawTransaction);
```

