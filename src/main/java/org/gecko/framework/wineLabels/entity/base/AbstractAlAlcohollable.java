package org.gecko.framework.wineLabels.entity.base;

import org.gecko.framework.base.BaseEntity;
import org.gecko.framework.ent.entity.enums.ProductType;
import org.gecko.framework.wineLabels.entity.enums.WineLablesStatus;
import org.gecko.framework.wineLabels.entity.enums.WineLablesType;
import org.gecko.annotations.GeckoField;
import org.gecko.annotations.GeckoField.FieldType;

/**
 * 
 * AbstractAlAlcohollable
 * 酒标信息表
 * @author Gecko Generator
 * @email admin@aisino.com
 * @date 2018-01-08 11:26:10 
 *
 */
public abstract class AbstractAlAlcohollable extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@GeckoField(primarykey=true,fieldType = GeckoField.FieldType.STRING, length = 10, nullable = false, description = "", searchable = true)
    private String id;

    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 200, nullable = true, description = "", searchable = true)
    private String temp4;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 200, nullable = true, description = "", searchable = true)
    private String temp3;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 200, nullable = true, description = "", searchable = true)
    private String temp2;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 200, nullable = true, description = "", searchable = true)
    private String temp1;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 10, nullable = true, description = "创建人", searchable = true)
    private String creator;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 10, nullable = true, description = "申请单id", searchable = true)
    private String applicanid;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 30, nullable = true, description = "申请人", searchable = true)
    private String applicant;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 10, nullable = true, description = "关联箱标", searchable = true)
    private String boxlable;
    
    @GeckoField(fieldType = GeckoField.FieldType.ENUM, length = 2, nullable = true, description = "商品类型", searchable = true)
    private ProductType altype;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 30, nullable = true, description = "商品id", searchable = true)
    private String productid;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 30, nullable = true, description = "销售单号", searchable = true)
    private String sales;
    
    @GeckoField(fieldType = GeckoField.FieldType.ENUM, length = 2, nullable = true, description = "状态", searchable = true)
    private WineLablesStatus status;
    
    @GeckoField(fieldType = GeckoField.FieldType.DATE, length = 7, nullable = true, description = "", searchable = true)
    private java.sql.Date lastupdatetime;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 30, nullable = true, description = "发放单位", searchable = true)
    private String grant;
    
    @GeckoField(fieldType = GeckoField.FieldType.ENUM, length = 30, nullable = true, description = "酒标类型", searchable = true)
    private WineLablesType type;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 30, nullable = true, description = "酒标验证码", searchable = true)
    private String verfycode;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 30, nullable = true, description = "酒标编号", searchable = true)
    private String serial;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 10, nullable = true, description = "当前持有人", searchable = true)
    private String owner;
    
    public void setTemp4(String temp4){
        this.temp4 = temp4;
    }

    public String getTemp4(){
        return this.temp4;
    }
    
    public void setTemp3(String temp3){
        this.temp3 = temp3;
    }

    public String getTemp3(){
        return this.temp3;
    }
    
    public void setTemp2(String temp2){
        this.temp2 = temp2;
    }

    public String getTemp2(){
        return this.temp2;
    }
    
    public void setTemp1(String temp1){
        this.temp1 = temp1;
    }

    public String getTemp1(){
        return this.temp1;
    }
    
    public void setCreator(String creator){
        this.creator = creator;
    }

    public String getCreator(){
        return this.creator;
    }
    
    public void setApplicanid(String applicanid){
        this.applicanid = applicanid;
    }

    public String getApplicanid(){
        return this.applicanid;
    }
    
    public void setApplicant(String applicant){
        this.applicant = applicant;
    }

    public String getApplicant(){
        return this.applicant;
    }
    
    public void setBoxlable(String boxlable){
        this.boxlable = boxlable;
    }

    public String getBoxlable(){
        return this.boxlable;
    }
    
    public void setAltype(ProductType productType){
        this.altype = productType;
    }

    public ProductType getAltype(){
        return this.altype;
    }
    
    public void setProductid(String productid){
        this.productid = productid;
    }

    public String getProductid(){
        return this.productid;
    }
    
    public void setSales(String sales){
        this.sales = sales;
    }

    public String getSales(){
        return this.sales;
    }
    
    public void setStatus(WineLablesStatus status){
        this.status = status;
    }

    public WineLablesStatus getStatus(){
        return this.status;
    }
    
    public void setLastupdatetime(java.sql.Date lastupdatetime){
        this.lastupdatetime = lastupdatetime;
    }

    public java.sql.Date getLastupdatetime(){
        return this.lastupdatetime;
    }
    
    public void setGrant(String grant){
        this.grant = grant;
    }

    public String getGrant(){
        return this.grant;
    }
    
    public void setType(WineLablesType type){
        this.type = type;
    }

    public WineLablesType getType(){
        return this.type;
    }
    
    public void setVerfycode(String verfycode){
        this.verfycode = verfycode;
    }

    public String getVerfycode(){
        return this.verfycode;
    }
    
    public void setSerial(String serial){
        this.serial = serial;
    }

    public String getSerial(){
        return this.serial;
    }
    
    public void setOwner(String owner){
        this.owner = owner;
    }

    public String getOwner(){
        return this.owner;
    }
    
    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "AbstractAlAlcohollable{" +
                "id='" + id + '\'' +
                ", temp4=" + temp4 +
                ", temp3=" + temp3 +
                ", temp2=" + temp2 +
                ", temp1=" + temp1 +
                ", creator=" + creator +
                ", applicanid=" + applicanid +
                ", applicant=" + applicant +
                ", boxlable=" + boxlable +
                ", altype=" + altype +
                ", productid=" + productid +
                ", sales=" + sales +
                ", status=" + status +
                ", lastupdatetime=" + lastupdatetime +
                ", grant=" + grant +
                ", type=" + type +
                ", verfycode=" + verfycode +
                ", serial=" + serial +
                ", owner=" + owner +
                '}';
    }
}
