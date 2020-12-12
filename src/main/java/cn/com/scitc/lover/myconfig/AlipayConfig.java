package cn.com.scitc.lover.myconfig;

public class AlipayConfig {

        // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
        public static String app_id = "2016101200666780";
        // 商户私钥，您的PKCS8格式RSA2私钥
        public static String merchant_private_key ="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC8jL01FZfNZ+ay4f95HcDwGSrDgE1U58cMVWtHDhWn4ekzkX7KHTjF8wkBPv/TJmezGZqQbyiZemEU3vNsCuW+qQ2CzkgyxHdMd73Zlm3IZ4oVbnswQ8MNTaxh3VSjhbeJA8iboREUAJlRzWi4kRGYPqBbnzfvmYJYGC4AaJD8gkQTDMsTP9babajuVAVsBdgNSOZbk+tq4meU0T8hPGmhXo2di+FWl6eCl0k4GaRtBjRDr1hmfpF81OyKcvUxWgw6Bta6RbTfXyRk7oJerIXbh5jh2RrPCEdgZk+efTAy/ocnowEFXI8jDF0sb32v5qDHQyOWRrGTBi6AUVLlY1gZAgMBAAECggEAKMpBvJQ5TQSnUhe2Txtyu/6V08mT8URbOX3ZQXv4j2M+MhvN1CfSOnDDh/N7IND0KjjlyU1i+SESk5NQEhWhckfcVmoOEH2UWYSmG8aBZZOQueY23FAsiFo/asSZJO8ur4OUCKclrLAceyf2+cbYiZky0990GG+bVTeV7ByzEQ02YUoA4XJZI6P3tQMJkSBNIcQ5YYbtt3BCXEnOktmlFnIBKPEVg8NpvWIAarvur4n+UPPjDAV+kAoVeTjSGKpThu3HG6MYihH1cG8qT26oDAevTvpHPh152B8kuPboKavYNdOnrZyx4BCngmI267SIk4Go5+BPY/DUsDZB/5egSQKBgQDcwdI1RASV9lBra2URBCcl0wbUl4gchOoTX3EEvVaXj+LkqgSV1pu4vyCc3hAiGVVjHhRNn81Mc76NGLynUWb3DT4xaFwzo200NBVUPi1vANulqg47TO7O/5IF4CiS3cSW6e100QOuvu0orNuEgHATFuSKy9beWQpX++1vTcFUYwKBgQDapqCirOcQrm5utv5vuetd8LV/6atm7Ka4A1I8sIYpBmm4IzE7KXE7/kuPDSXU4587n/yLlx9wDbv02m60sh2MGyxsYadFjjxpH68hzUa6NroLuemZxK11iFq4B0i2meAqWgYNB73kUElkVBFU6XzCfACgDsaCAWRMqGCG29HUUwKBgBzYClJBX+QEOf+/GYZ+p2rOxt6yKeuoBjmfx9GZt524BCpieJTnZJNgDa/RaAQ8kSaRQI/f6GAr42LmL4ghH7X5+f1UqG9q1BL1FzBZq3AMiaZ8sL1Y0P8k73xrDIIcDdq2F/uib7u+YJhm9Yu7iGlGHXhxJ9MHiU1zslNPsooHAoGAbqKLe2SzklxAoqLTgaL4dlMa83s/8FdkUI3VqcHEULPfAH5GJeJlWm7kuqBzeRIn+xqLxfIUxTUd2to/1AygKMmDI+ARrH85EBQpIJhm5khUwSQ0EEtVXbg99wowf7zCkYt1rlgxfHoneK2VC3sNVrc59cMkLJoZrzQvi21k8eMCgYAoY5KJe8XszjrzpMs5UArsGXerihstVa/JT9Lrgq2saDSFREDuZloZuRqv7hxvVPVFAYgKqT9RwvPZUxJJ9VvLiqadBke7MVsdyCD6tDJRMQrc2XfAx662pmXk0edXQA33sEB50R5lrLqIRBYinEahNia8bMm2P4CAR7zsz0XrOQ==";
        // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
        public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnM2YkFMXM6Z1LxKeKxTATMxmzx0K7lVQqoJigKdQAFZ56UCMK5b55DeD8JvrD3BMHYXbu+mYrGBQkf4PmZm4fdiJL1fu8SXZtTlirTilCsGb0XPU6bXdNOTSzpR9+OtHAlNjoeowNNBaercyIHEWzjTnChY9C/B/h66eKDWGKAfZCn44nTY4qi5UWnxznWkStU9PJruLam9b7B6dZ/qdM0GAHrZ+jkN/sYqpWYRAUwdJpXR34/+1y4gQ1Z1GRgiQURhXp+pu5gcD4wGUysCw+BKosEHuRG05x6EF5kbuyIqbNqIn71zh7MyOcsquwHJes+WbU3ihlMaF6YmohmxrjQIDAQAB";
        // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
        public static String notify_url = "http://localhost/alipay.trade.page.pay-JAVA-UTF-8/notify_url";
        // 页面跳转同步通知页面路径
//    public static String return_url = "http://localhost/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
        public static String return_url = "http://182.149.197.162:8080/user/mine";
        // 签名方式，注意这里，如果步骤设置的是RSA则用RSA
        public static String sign_type = "RSA2";
        // 字符编码格式
        public static String charset = "utf-8";
        // 支付宝网关https://openapi.alipaydev.com/gateway.do
        public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
        // 支付宝网关日志路径
//    public static String log_path = "C:\\";
    }

