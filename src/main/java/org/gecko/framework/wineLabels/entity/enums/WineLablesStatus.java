package org.gecko.framework.wineLabels.entity.enums;

import org.gecko.core.enums.IGeckoEnum;

/**
 * 
 * 
 * 酒标状态枚举
 * @author niupanfeng
 * @date 2017年4月26日 上午10:02:05
 *
 */
public enum WineLablesStatus implements IGeckoEnum {

	UNCIRCULATION(1, "未流转"), CIRCULATIONING(2, "流转中"),  WRITTENOFF (3, "已核销"),  UNUSERD(4, "未使用"),  NEEDWRITTENOFF (5, "待核销");

	private int key;
	private String value;

	private WineLablesStatus(int key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public int getKey() {
		return key;
	}

	@Override
	public String getValue() {
		return value;
	}
}
