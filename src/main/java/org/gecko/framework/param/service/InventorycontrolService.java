package org.gecko.framework.param.service;

import org.gecko.framework.base.BaseGeckoService;
import org.gecko.framework.param.entity.Inventorycontrol;
import org.springframework.stereotype.Service;

/**
 * 
 * InventorycontrolService
 * INVENTORYCONTROL服务接口
 * @author Gecko Generator
 * @email admin@aisino.com
 * @date 2018-03-26 11:59:55 
 *
 */
@Service("InventorycontrolService")
public class InventorycontrolService extends BaseGeckoService<Inventorycontrol> {

    public int updateField(String field, String value, String pk) {
        return updateField("Inventorycontrol", field, value, pk);
    }
}