package com.qf.service.impl;

import com.qf.dao.UserAddressDao;
import com.qf.dao.impl.UserAddressDaoImpl;
import com.qf.entity.UserAddress;
import com.qf.service.UserAddressService;

import java.util.List;

public class UserAddressServiceImpl implements UserAddressService {

    UserAddressDao userAddressDao = new UserAddressDaoImpl();

    /**
     * 添加地址
     *
     * @param userAddress
     * @return
     */
    @Override
    public int addAddress(UserAddress userAddress) {
        return userAddressDao.addAddress(userAddress);
    }

    /**
     * 更新地址
     *
     * @param userAddress
     * @return
     */
    @Override
    public int updateAddress(UserAddress userAddress) {
        return userAddressDao.updateAddress(userAddress);
    }

    /**
     * 删除地址
     *
     * @param id
     * @return
     */
    @Override
    public int deleteAddress(int id) {
        return userAddressDao.deleteAddress(id);
    }

    /**
     * 查找uid用户的地址列表
     *
     * @param uid
     * @return
     */
    @Override
    public List<UserAddress> selectAddressByUid(int uid) {
        return userAddressDao.selectAddressByUid(uid);
    }

    /**
     * 使用id查找地址
     *
     * @param id
     * @return
     */
    @Override
    public UserAddress selectAddress(int id) {
        return userAddressDao.selectAddress(id);
    }
}
