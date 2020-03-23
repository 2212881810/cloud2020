package payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import payment.entry.PaymentDO;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentDO,Integer> {
}
