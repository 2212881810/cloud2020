package qinfeng.zheng.hystrix.payment.service;

public interface IPaymentService {
    String ok(Integer id);

    String timeout(Integer id);

    String paymentCircuirtBreak(Integer id);

}
