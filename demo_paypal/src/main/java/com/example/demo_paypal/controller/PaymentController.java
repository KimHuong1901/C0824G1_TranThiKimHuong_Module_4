package com.example.demo_paypal.controller;

import com.example.demo_paypal.service.IPayService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class PaymentController {
    private static final String EXCHANGE_RATE_API = "https://open.er-api.com/v6/latest/USD";
    @Autowired
    private IPayService payService;

    @GetMapping("/")
    public String showPaymentForm() {
        return "payment-form";
    }

    private static final String SUCCESS_URL = "http://localhost:8080/success";
    private static final String CANCEL_URL = "http://localhost:8080/cancel";

    @PostMapping("/pay")
    public String processPayment(
            @RequestParam("amount") Double amount) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(EXCHANGE_RATE_API, String.class);
            JSONObject jsonResponse = new JSONObject(response);
            if (jsonResponse.has("rates")) {
                JSONObject rates = jsonResponse.getJSONObject("rates");
                if (rates.has("VND")) {
                    double exchangeRate = rates.getDouble("VND");
                    double convertedAmount = amount / exchangeRate;

                    Payment payment = payService.createPaymentWithPayPal(
                            convertedAmount,
                            "USD",
                            "paypal",
                            "sale",
                            "Mô tả",
                            CANCEL_URL,
                            SUCCESS_URL);

                    for (Links link : payment.getLinks()) {
                        if (link.getRel().equals("approval_url")) {
                            return "redirect:" + link.getHref();
                        }
                    }
                } else {
                    throw new RuntimeException("Tỷ giá VND không tồn tại trong phản hồi API.");
                }
            } else {
                throw new RuntimeException("Phản hồi từ API không chứa trường 'rates'.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Đã xảy ra lỗi khi xử lý API: " + e.getMessage());
        }
        return "redirect:/";
    }
    @GetMapping("/success")
    public String success(@RequestParam("paymentId") String paymentId,
                          @RequestParam("PayerID") String payerId, Model model) {
        try {
            Payment payment = payService.executePayment(paymentId, payerId);
            model.addAttribute("payment", payment);
            return "payment-success";
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/cancel")
    public String cancel() {
        return "payment-cancel";
    }
}
