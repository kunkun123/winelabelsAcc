package org.gecko.framework.system.entity;

import org.gecko.framework.system.entity.base.AbstractRole;

public class Role extends AbstractRole {
	
	private static final long serialVersionUID = 1L;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}