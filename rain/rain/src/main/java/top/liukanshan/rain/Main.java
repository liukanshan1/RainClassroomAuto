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
                "2021004121611390",
                "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDEGN2WB/e0Hs0CF4Muas2XStkDxlA1rugQVi/7uvU19MucUlYZJQM3G2i3J6wQryGsNbuqU5malcIrIeIeIapppA4IlIGYxNK/ibz/cUw9IC/umgVeYEkAYOvrZzXelwBpi3OilYRnXLuiT7We3mxgc+tSYJSZAYjoi14J+HU0pCH0meV+t4Zudu+XfJseUSB9wY6vIZJsh/J7hU1wBdR4yX79oXeRCqGwG/HhtAwT9e0ZEjS7d7+RLfzsV9xTDj20LmcudWmMAeqRGGitXNgWPkN6UQzhnlZ9OraQAwqngv0PZvT/0SIHPGVz35pa+HgN6Bn4pgTp6zdSew1xAezpAgMBAAECggEATwmyrlkRxuCvQsuVTS0xJmy9oZ7aD3krAgKrHmxRj2jWdHBfUY0wiZKbl07/NE5SZSXXOSSvAbag51+l0v1AwYmlOmIZBik2xIrQyaix0OVbTHF5/nsSkXt/O4eDF++G9AOIHRzknACthBNaoekGh63RSIey/SS4OPqLcbtaClf0mfD3Es86yD1k58sSGnbDQ2XQ49CbuKoSfzAGaEuot+K6D20HDqwQ+FLKiflsuTkGe3DpElt4C7qT0I7tm2I+fJXApPtTY/QM8ZJdJh1lYAEmmPePJimEDYuOSbR39bbw4NpF5sNUIGlBG6bfVF5gmjly3XXft7m7j4hSj5cF7QKBgQDrxOBBKm6bGSIWGHpO7oE1AQLyHhG3Al2bEgnv9Y2KXRHSPzWnxRgKtLjcbX58uitUSUgJ4/F8DQqV0mVSSdj20gfysFtqBRyTOHnld/cZk8RAzc15RFhfHJ40fmgI1Gk/ed/bl0dX0aD7TpvgG7TttXJDBTyMLRLhAiNUjXHyfwKBgQDU7IThpjklQTDdIOyq0ZfUDUDSw8+xxJHB6y/4MJdZucL0x2x002iqEgTYaOFYFXCfzezWo846h79GZC+/tsYi7gKfnMtx+vxSFl2IsvHvprU4Lec2oxxeVEcltOO+q7IueOXOfjTEitv0aiHdoNmacmnerQGMYF/cHJJupLoclwKBgAcnyXqQ1ByG7b7n7UZZ/LfkGPfKK9V3D+o16PFMbYhGfNT5sCIwXCNvCrE97XnRmKENPE94iIqwRqL3aLXPofMTusQF0DBuiUh6jVCGjIxNLMaeuF620UvJrY+ASp4B/FO92ipq8/JZXV5jK13o2Vvhht872HOUpp8HlpTpWgz3AoGALjPoncJhEhl0TfeQA30ZkhUSJOoCjpOWAVtUfGmm3fx2NoFzomIhiw3/6SnRBDkayEJ6CxVeccr1EYQ57ELv+bJl9Vajuub4i6N4xmn2H8ev+THUw0FfrYRiL+dxp/U/49+uFkHCl4d+NSo2kQ4PSflbycsG0/wxsOSuTb4G+J8CgYEA2eaEzWac7lRKUkj4mw4f28Lbw2AhE7djjLngMA8dGpI0/CkXFM5RJBEr4rrVWaeqSIClUWYThbHFgkAySx/WYcDlnsCRFCbfKFXCxuJDerqOKx73/Cpoa7VFUifqJcMGX+9ZbMypvXYO0WAnFERhYzhiIoqEcolvOJCuyKp7Zk4=",
                "json",
                "GBK",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnOS8EKod6+ZLpVDFaiuLTBV/DcJqASEZQCcxJW0coTtP9K5pZ3Kf3+IZTmhKVYLXls9pwg49nxH1N/lHL+i+WxyGnFK8wG2pRJh9E3JFP9sB1r3iY5LqVNXqfDkWQHahH9HTkLGt0HLPQNjCZ9a2oGSHe2K+WuD7HlfolJ4u4cUsd7ShWduB4cY5cKSq2zIrn49Qq+rGHglGzPIvWtSi/N/nQ9+yWGeCExpCN+hF0EvP4FqRe/tNUTg7SM5Ly2DEXZeqBM2SF8CAdWR8CfuXSy68F28X05/vEhBFqG3omy/XUn+BQPswFFKQPoCWHbPmnUui2E9v65fpSmMZzuXTswIDAQAB",
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
