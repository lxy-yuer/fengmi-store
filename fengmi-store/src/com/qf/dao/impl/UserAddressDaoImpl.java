package com.qf.dao.impl;

import com.qf.dao.UserAddressDao;
import com.qf.entity.UserAddress;
import com.qf.util.DBUtils;

import java.util.List;

public class UserAddressDaoImpl implements UserAddressDao {

    DBUtils<UserAddress> dbUtils = new DBUtils<>();

    /**
     * 添加地址
     *
     * @param userAddress
     * @return
     */
    @Override
    public int addAddress(UserAddress userAddress) {
        return dbUtils.updateData("insert into t_useraddress(uid, address_detail) values(?,?)", userAddress.getUid(), userAddress.getAddress_detail());
    }

    /**
     * 更新地址
     *
     * @param userAddress
     * @return
     */
    @Override
    public int updateAddress(UserAddress userAddress) {
        return 0;
    }

    /**
     * 删除地址
     *
     * @param id
     * @return
     */
    @Override
    public int deleteAddress(int id) {
        return 0;
    }

    /**
     * 查找uid用户的地址列表
     *
     * @param uid
     * @return
     */
    @Override
    public List<UserAddress> selectAddressByUid(int uid) {
        return null;
    }

    /**
     * 使用id查找地址
     *
     * @param id
     * @return
     */
    @Override
    public UserAddress selectAddress(int id) {
        return null;
    }
}
