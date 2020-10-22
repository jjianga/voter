package org.jjianga.voter.service;

import org.jjianga.voter.entity.DeviceInfo;

import java.util.List;

public interface DeviceInfoService {

    List<DeviceInfo> getDeviceInfoS(Integer pageNum, Integer pageSize);

    DeviceInfo getDefaultDeviceInfo();

    int editDefaultDeviceInfo(DeviceInfo deviceInfo);
}
