package qinfeng.zheng.payment.service.impl;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qinfeng.zheng.common.entry.Payment;
import qinfeng.zheng.payment.dao.PaymentRepository;
import qinfeng.zheng.payment.entry.PaymentDO;
import qinfeng.zheng.payment.service.IPaymentService;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment create(Payment payment) {
        PaymentDO paymentDO = new PaymentDO();
        BeanUtil.copyProperties(payment, paymentDO);
        paymentRepository.save(paymentDO);
        BeanUtil.copyProperties(paymentDO, payment);
        return payment;
    }

    @Override
    public Optional findById(Integer id) {
        Optional<PaymentDO> result = paymentRepository.findById(id);
        return Optional.ofNullable(result);
    }

}
