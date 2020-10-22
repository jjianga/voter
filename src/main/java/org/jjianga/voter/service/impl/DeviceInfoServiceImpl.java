package org.jjianga.voter.service.impl;

import com.github.pagehelper.PageHelper;
import org.jjianga.voter.entity.DeviceInfo;
import org.jjianga.voter.mapper.DeviceInfoMapper;
import org.jjianga.voter.service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {
    final
    DeviceInfoMapper deviceInfoMapper;

    public DeviceInfoServiceImpl(DeviceInfoMapper deviceInfoMapper) {
        this.deviceInfoMapper = deviceInfoMapper;
    }

    @Override
    public List<DeviceInfo> getDeviceInfoS(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return deviceInfoMapper.selectByExample(null);
    }

    @Override
    public DeviceInfo getDefaultDeviceInfo() {
        return deviceInfoMapper.selectByPrimaryKey(1);
    }

    @Override
    public int editDefaultDeviceInfo(DeviceInfo deviceInfo) {
        deviceInfo.setId(1);
        return deviceInfoMapper.updateByPrimaryKey(deviceInfo);
    }

}
