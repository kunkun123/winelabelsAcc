package org.gecko.framework.param.entity.base;

import org.gecko.framework.base.BaseEntity;
import org.gecko.annotations.GeckoField;
import org.gecko.annotations.GeckoField.FieldType;

/**
 * 
 * AbstractInventorycontrol
 * INVENTORYCONTROL
 * @author Gecko Generator
 * @email admin@aisino.com
 * @date 2018-03-26 10:54:45 
 *
 */
public abstract class AbstractInventorycontrol extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@GeckoField(primarykey=true,fieldType = GeckoField.FieldType.STRING, length = 64, nullable = false, description = "", searchable = true)
    private String id;

    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String credit_;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String circulating;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String uncirculation;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String ent;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String unused;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String finish;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String total;
    
    public void setCredit(String credit){
        this.credit_ = credit;
    }

    public String getCredit(){
        return this.credit_;
    }
    
    public void setCirculating(String circulating){
        this.circulating = circulating;
    }

    public String getCirculating(){
        return this.circulating;
    }
    
    public void setUncirculation(String uncirculation){
        this.uncirculation = uncirculation;
    }

    public String getUncirculation(){
        return this.uncirculation;
    }
    
    public void setEnt(String ent){
        this.ent = ent;
    }

    public String getEnt(){
        return this.ent;
    }
    
    public void setUnused(String unused){
        this.unused = unused;
    }

    public String getUnused(){
        return this.unused;
    }
    
    public void setFinish(String finish){
        this.finish = finish;
    }

    public String getFinish(){
        return this.finish;
    }
    
    public void setTotal(String total){
        this.total = total;
    }

    public String getTotal(){
        return this.total;
    }
    
    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "AbstractInventorycontrol{" +
                "id='" + id + '\'' +
                ", credit=" + credit_ +
                ", circulating=" + circulating +
                ", uncirculation=" + uncirculation +
                ", ent=" + ent +
                ", unused=" + unused +
                ", finish=" + finish +
                ", total=" + total +
                '}';
    }
}