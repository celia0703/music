package cn.com.scitc.lover.controller;

import cn.com.scitc.lover.dao.UserDao;
import cn.com.scitc.lover.model.Users;
import cn.com.scitc.lover.myconfig.AlipayConfig;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class PayController {
        private @Autowired
        UserDao userDao;
        @RequestMapping("/toPay")
        @ResponseBody
        public String toPay() throws Exception{
            //            产生随机数
            Random  r = new Random();
            List<Integer> list = new ArrayList<Integer>();
            int i;
            while(list.size() < 8){
                i = r.nextInt(10);
                if(!list.contains(i)){
                    list.add(i);
                }
            }
            //获得初始化的AlipayClient
            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
            //设置请求参数
            AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
            alipayRequest.setReturnUrl(AlipayConfig.return_url);
            alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
            try {
                alipayRequest.setBizContent("{\"out_trade_no\":\""+ list +"\","
                        + "\"total_amount\":\""+ 98 +"\","
                        + "\"subject\":\""+ "测试支付" +"\","
                        + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

                //请求
                String result;
                result = alipayClient.pageExecute(alipayRequest).getBody();
                System.out.println("*********************\n返回结果为："+result);
                return result;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
        }
        @RequestMapping("/alipay/notify")
        public String toNotify(HttpSession session){
            String username=(String)session.getAttribute("loginUser");
            Users us = userDao.findByUsername(username);
            us.setStatus("会员");
            session.setAttribute("stutas",us.getStatus());
            userDao.save(us);
            return "/user/mine";
        }
    }
