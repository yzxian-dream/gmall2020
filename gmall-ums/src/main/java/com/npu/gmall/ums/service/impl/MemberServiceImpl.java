package com.npu.gmall.ums.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.npu.gmall.ums.entity.Member;
import com.npu.gmall.ums.entity.MemberReceiveAddress;
import com.npu.gmall.ums.mapper.MemberMapper;
import com.npu.gmall.ums.mapper.MemberReceiveAddressMapper;
import com.npu.gmall.ums.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author gy
 * @since 2020-01-03
 */
@Service
@Component
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    MemberReceiveAddressMapper addressMapper;

    @Override
    public Member login(String username, String password) {

        String digest = DigestUtils.md5DigestAsHex(password.getBytes());

        Member member = memberMapper.selectOne(new QueryWrapper<Member>().eq("username", username).eq("password", digest));
        return member;
    }

    @Override
    public List<MemberReceiveAddress> getMemberAddress(Long id) {
        return addressMapper.selectList(new QueryWrapper<MemberReceiveAddress>().eq("member_id",id));
    }

    @Override
    public MemberReceiveAddress getMemberAddressByAddressId(Long addressId) {
        return addressMapper.selectById(addressId);
    }
}
