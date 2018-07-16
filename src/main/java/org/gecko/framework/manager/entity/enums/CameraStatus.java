package org.gecko.framework.manager.entity.enums;

import org.gecko.core.enums.IGeckoEnum;

/**
 * 
 * 
 * 酒标状态枚举
 * @author niupanfeng
 * @date 2017年4月26日 上午10:02:05
 *
 */
public enum CameraStatus implements IGeckoEnum {

	NORMAL(0, "正常"),UNABLE(1, "不可用");

	private int key;
	private String value;

	private CameraStatus(int key, String value) {
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
