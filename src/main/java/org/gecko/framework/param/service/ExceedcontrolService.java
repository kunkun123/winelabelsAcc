package org.gecko.framework.param.service;

import org.gecko.framework.base.BaseGeckoService;
import org.gecko.framework.param.entity.Exceedcontrol;
import org.springframework.stereotype.Service;

/**
 * 
 * ExceedcontrolService
 * EXCEEDCONTROL服务接口
 * @author Gecko Generator
 * @email admin@aisino.com
 * @date 2018-03-26 18:09:25 
 *
 */
@Service("ExceedcontrolService")
public class ExceedcontrolService extends BaseGeckoService<Exceedcontrol> {

    public int updateField(String field, String value, String pk) {
        return updateField("Exceedcontrol", field, value, pk);
    }
}
