package com.imooc.order.repository;

import com.imooc.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName OrderDetailRepository
 * @Description TOOD
 * @Author 99795
 * @DaTe 2019/5/3 14:55
 * @Version 1.0
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
}
