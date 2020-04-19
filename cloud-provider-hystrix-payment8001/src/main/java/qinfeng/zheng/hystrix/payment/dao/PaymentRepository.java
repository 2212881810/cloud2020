package qinfeng.zheng.hystrix.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qinfeng.zheng.hystrix.payment.entry.PaymentDO;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentDO,Integer> {
}
