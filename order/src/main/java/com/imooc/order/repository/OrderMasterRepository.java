package com.imooc.order.repository;

import com.imooc.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName OrderMasterRepository
 * @Description TOOD
 * @Author 99795
 * @DaTe 2019/5/3 14:53
 * @Version 1.0
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
