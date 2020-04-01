# BitcoinDiamond 地址生成说明

详细的生成demo见 [BCDAddressDemo](../src/main/java/org/bitcoindiamond/demo/BCDAddress.java)。

## Key

BitcoinDiamond 公私钥与 Bitcoin 生成方式一致，同样采用的是 Secp256k1 曲线。

私钥是一个数字，通常是随机选出的。基于私钥，我们就可以使用椭圆曲线乘法这个单向密码函数产生一个公钥。基于公钥，我们就可以使用一个单向密码哈希函数生成 BitcoinDiamond 地址。

使用基于 [bitcoinj](https://github.com/bitcoinj/bitcoinj) 修改过的 [bitcoindiamondj](https://github.com/Starry9/bitcoindiamondj) Java库可以方便的生成私钥和公钥，示例如下：

```java
// 生成随机的ECKey对象
ECKey key = new ECKey();

// 获取私钥
String privateKeyWIF = key.getPrivKey();

// 获取公钥
String publicKeyHex = key.getPublicKey();
```

## Address

Bitcoindiamond 的地址 Base58 的前缀格式和 Bitcoin 相比并没有改变，所以生成方式和 Bitcoin 一致，传统地址格式和 Bitcoin 也是一样的。

有效的地址格式示例如下：

> 1CoDCvX8CJJ3Cd86aMSVGb9J4tNpVXcKCg                        
>
> 3GrPSQqn8BNDxx5mza4xqcegWZ8JGsrnNP                     
>
> bcd1qteh87fmdk5j8egkfery7utqxe5r8wt3qgjqtwh

（注：Segwit 相关的 hrp 有修改）

```java
// 获取P2PKH地址的方式
Address addressP2PKH = Address.fromKey(params, key, Script.ScriptType.P2PKH);
Address addressLegacy = LegacyAddress.fromKey(params, key);
```

地址合法性校验通过 Address 类进行导入地址，导入成功则有效，失败则无效。

```java
Address.fromString(params, address);
```

 地址无需激活，生成即可使用。