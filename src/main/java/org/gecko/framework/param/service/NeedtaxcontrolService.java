package org.gecko.framework.param.service;

import org.gecko.framework.base.BaseGeckoService;
import org.gecko.framework.param.entity.Needtaxcontrol;
import org.springframework.stereotype.Service;

/**
 * 
 * NeedtaxcontrolService
 * NEEDTAXCONTROL服务接口
 * @author Gecko Generator
 * @email admin@aisino.com
 * @date 2018-03-26 15:41:26 
 *
 */
@Service("NeedtaxcontrolService")
public class NeedtaxcontrolService extends BaseGeckoService<Needtaxcontrol> {

    public int updateField(String field, String value, String pk) {
        return updateField("Needtaxcontrol", field, value, pk);
    }
}