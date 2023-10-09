package top.liukanshan.rain;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;

public class Main {

    public static void main(String[] args) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
                "2021011390",
                "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDEGN2WB/e0Hs0CF4Muas2XStkDxlA1rugQVi/7uvU19MucUlYZJQM3G2i3JF/cHJJupLoclwKBgAcnyXqQ1ByG7b7n7UZZ/LfkGPfKK9V3D+o16PFMbYhGfNT5sCIwXCNvCrE97XnRmKENPE94iIqwRqL3aLXPofMTusQF0DBuiUh6jVCGjIxNLMaeuF620UvJrY+ASp4B/FO92ipq8/JZXV5jK13o2Vvhht872HOUpp8HlpTpWgz3AoGALjPoncJhEhl0TfeQA30ZkhUSJOoCjpOWAVtUfGmm3fx2NoFzomIhiw3/6SnRBDkayEJ6CxVeccr1WYThbHFgkAySx/WYcDlnsCRFCbfKFXCxuJDerqOKx73/Cpoa7VFUifqJcMGX+9ZbMypvXYO0WAnFERhYzhiIoqEcolvOJCuyKp7Zk4=",
                "json",
                "GBK",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnOS8EKod6+ZLpVDFaiuLTBV/DcJqASEZQCcxJW0coTtP9K58CfuXSy68F28X05/vEhBFqG3omy/XUn+BQPswFFKQPoCWHbPmnUui2E9v65fpSmMZzuXTswIDAQAB",
                "RSA2");
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setNotifyUrl("");
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", "20210817010101003");
        bizContent.put("total_amount", 0.01);
        bizContent.put("subject", "测试商品");

        request.setBizContent(bizContent.toString());
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }
}
