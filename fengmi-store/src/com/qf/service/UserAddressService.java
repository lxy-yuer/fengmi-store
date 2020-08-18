package com.qf.service;

import com.qf.entity.UserAddress;

import java.util.List;

public interface UserAddressService {
    /**
     * 添加地址
     *
     * @param userAddress
     * @return
     */
    int addAddress(UserAddress userAddress);

    /**
     * 更新地址
     *
     * @param userAddress
     * @return
     */
    int updateAddress(UserAddress userAddress);

    /**
     * 删除地址
     *
     * @param id
     * @return
     */
    int deleteAddress(int id);

    /**
     * 查找uid用户的地址列表
     *
     * @param uid
     * @return
     */
    List<UserAddress> selectAddressByUid(int uid);

    /**
     * 使用id查找地址
     *
     * @param id
     * @return
     */
    UserAddress selectAddress(int id);
}
