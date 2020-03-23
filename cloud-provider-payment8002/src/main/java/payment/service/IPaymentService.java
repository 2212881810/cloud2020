package payment.service;

import qinfeng.zheng.common.entry.Payment;

import java.util.Optional;

public interface IPaymentService {
    Optional findById(Integer id);

    Payment create(Payment payment);
}
