package org.gecko.framework.param.entity.base;

import org.gecko.framework.base.BaseEntity;
import org.gecko.annotations.GeckoField;
import org.gecko.annotations.GeckoField.FieldType;

/**
 * 
 * AbstractFinishtaxcontrol
 * FINISHTAXCONTROL
 * @author Gecko Generator
 * @email admin@aisino.com
 * @date 2018-03-26 10:53:42 
 *
 */
public abstract class AbstractFinishtaxcontrol extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@GeckoField(primarykey=true,fieldType = GeckoField.FieldType.STRING, length = 64, nullable = false, description = "", searchable = true)
    private String id;

    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String credit_;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String ent;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String finish;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String year;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String month;
    @GeckoField(primarykey=true,fieldType = GeckoField.FieldType.STRING, length = 64, nullable = false, description = "", searchable = true)
    private String temp1;

    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String temp2;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String temp3;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String temp4;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String temp5;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String temp6;
    @GeckoField(primarykey=true,fieldType = GeckoField.FieldType.STRING, length = 64, nullable = false, description = "", searchable = true)
    private String temp7;

    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String temp8;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String temp9;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String temp10;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String temp11;
    
    @GeckoField(fieldType = GeckoField.FieldType.STRING, length = 64, nullable = true, description = "", searchable = true)
    private String temp12;
    
    public String getTemp1() {
		return temp1;
	}

	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}

	public String getTemp2() {
		return temp2;
	}

	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}

	public String getTemp3() {
		return temp3;
	}

	public void setTemp3(String temp3) {
		this.temp3 = temp3;
	}

	public String getTemp4() {
		return temp4;
	}

	public void setTemp4(String temp4) {
		this.temp4 = temp4;
	}

	public String getTemp5() {
		return temp5;
	}

	public void setTemp5(String temp5) {
		this.temp5 = temp5;
	}

	public String getTemp6() {
		return temp6;
	}

	public void setTemp6(String temp6) {
		this.temp6 = temp6;
	}

	public String getTemp7() {
		return temp7;
	}

	public void setTemp7(String temp7) {
		this.temp7 = temp7;
	}

	public String getTemp8() {
		return temp8;
	}

	public void setTemp8(String temp8) {
		this.temp8 = temp8;
	}

	public String getTemp9() {
		return temp9;
	}

	public void setTemp9(String temp9) {
		this.temp9 = temp9;
	}

	public String getTemp10() {
		return temp10;
	}

	public void setTemp10(String temp10) {
		this.temp10 = temp10;
	}

	public String getTemp11() {
		return temp11;
	}

	public void setTemp11(String temp11) {
		this.temp11 = temp11;
	}

	public String getTemp12() {
		return temp12;
	}

	public void setTemp12(String temp12) {
		this.temp12 = temp12;
	}

	public void setCredit(String credit){
        this.credit_ = credit;
    }

    public String getCredit(){
        return this.credit_;
    }
    
    public void setEnt(String ent){
        this.ent = ent;
    }

    public String getEnt(){
        return this.ent;
    }
    
    public void setFinish(String finish){
        this.finish = finish;
    }

    public String getFinish(){
        return this.finish;
    }
    
    public void setYear(String year){
        this.year = year;
    }

    public String getYear(){
        return this.year;
    }
    
    public void setMonth(String month){
        this.month = month;
    }

    public String getMonth(){
        return this.month;
    }
    
    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "AbstractFinishtaxcontrol{" +
                "id='" + id + '\'' +
                ", credit=" + credit_ +
                ", ent=" + ent +
                ", finish=" + finish +
                ", year=" + year +
                ", month=" + month +
                '}';
    }
}
