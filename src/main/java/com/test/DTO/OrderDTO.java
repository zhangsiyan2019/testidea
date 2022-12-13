package com.test.DTO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zsy
 * @since 2022-11-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO implements Serializable {

    private Integer orderId;

    private String orderNo;

    private Integer customerId;
    private String customerName;


}
