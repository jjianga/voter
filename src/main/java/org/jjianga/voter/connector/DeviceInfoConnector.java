package org.jjianga.voter.connector;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jjianga.voter.entity.DeviceInfo;
import org.jjianga.voter.service.DeviceInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "设备信息")
@RestController
@RequestMapping("DeviceInfoConnector")
public class DeviceInfoConnector {
    final
    DeviceInfoService deviceInfoService;

    public DeviceInfoConnector(DeviceInfoService deviceInfoService) {
        this.deviceInfoService = deviceInfoService;
    }

    @PostMapping(value = "getDefaultDeviceInfoS")
    @ApiOperation(value="获取配置信息", notes="获取配置信息")
    public DeviceInfo getDefaultDeviceInfoS(){
        return deviceInfoService.getDefaultDeviceInfo();
    }

    @PostMapping(value = "editDefaultDeviceInfo")
    @ApiOperation(value="修改配置信息", notes="修改配置信息")
    public int editDefaultDeviceInfo(DeviceInfo deviceInfo){
        return deviceInfoService.editDefaultDeviceInfo(deviceInfo);
    }
}
