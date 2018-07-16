package org.gecko.framework.param.service;

import org.gecko.framework.base.BaseGeckoService;
import org.gecko.framework.param.entity.Finishtaxcontrol;
import org.springframework.stereotype.Service;

/**
 * 
 * FinishtaxcontrolService
 * FINISHTAXCONTROL服务接口
 * @author Gecko Generator
 * @email admin@aisino.com
 * @date 2018-03-26 18:05:17 
 *
 */
@Service("FinishtaxcontrolService")
public class FinishtaxcontrolService extends BaseGeckoService<Finishtaxcontrol> {

    public int updateField(String field, String value, String pk) {
        return updateField("Finishtaxcontrol", field, value, pk);
    }
}
