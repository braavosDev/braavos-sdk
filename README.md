# braavos-sdk
提供API接入SDK，暂只提供java版本SDK，后续将会不断完善


## sdk-java



### 工具类(UnifiedRsaUtils)

支持读取pkcs8格式的私钥&公钥,签名算法为SHA256withRSA

#### 机构密钥对生成方式
```
/**
 *
 * 生成密钥对: ssh-keygen -m PEM -t rsa -b 4096 -f id_rsa
 * 进行PKCS#8编码：openssl pkcs8 -topk8 -inform PEM -in id_rsa -outform pem -nocrypt -out private_key.pem
 * 根据私钥生成公钥：openssl rsa -in private_key.pem -pubout -out public_key.pem
 *
 * 得到私钥文件  private_key.pem
 * 得到公钥文件  public_key.pem
 *
 */
```

#### 签名&验签

- 客户端请求，需要采用机构私钥进行签名
```
public static String signWithPriKey(String plainText, String privateKeyStr)

```
- 客户端响应，需要采用平台公钥进行验签
```
public static boolean verifyWithPubKey(String plainText, String signature, String publicKeyStr) 
```

### 客户端Client(UnifiedOpenApiClient)
#### 使用说明
- 初始化需要设置`appId`（平台发放）、`openApiHost`（平台host）、`privateKey`（机构自己的私钥）
- 调用 `remoteCall`方法，传入json参数和请求接口path，内部会自动进行签名&header设置，并调用平台接口

#### 使用示例
```
    public static void main(String[] args) throws JsonProcessingException {

        UnifiedOpenApiClient openApiClient = new UnifiedOpenApiClient(APP_ID, OPEN_API_HOST, PRIVATE_KEY);

        SimpleUser user = new SimpleUser();
        user.name = "john";
        user.sex = "boy";
        user.birth_time = System.currentTimeMillis();

        // 将Object 序列化为json
        String jsonData = new ObjectMapper().writeValueAsString(user);

        // 请求具体的接口，并获取返回的json  response
        String responseData = openApiClient.remoteCall(jsonData, "/api/sample/hello");

        System.out.println("response is : " + responseData);

    }
```
> 详见 com.yqg.braavos.sdk.ExampleApp
> UnifiedOpenApiClient默认使用OkHttpClient组件，可根据项目情况参照代码使用其他组件

### 服务器校验 
#### 使用说明
- 初始化需要设置`platformPublicKey`(平台的公钥),并注册为 Filter
- UnifiedSignCheckFilter 会自动校验平台签名是否合法

#### 备注
若不打算使用filter进行校验，也可以仿照逻辑手动获取 RequestBody，从header中获取签名信息，手动进行签名校验

