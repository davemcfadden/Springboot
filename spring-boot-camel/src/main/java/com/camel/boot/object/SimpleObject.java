package com.camel.boot.object;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
/**
 * 
 * @author Dave McFadden
 *
 */
@CsvRecord(separator = ",")
public class SimpleObject  extends BindyCsvDataFormat  {

	@DataField(pos = 1)
	private String element1;
	@DataField(pos = 2)
	private String element2;
	@DataField(pos = 3)
	private String element3;
	@DataField(pos = 4)
	private String element4;
	@DataField(pos = 5)
	private String element5;
	
	
	public String getElement1() {
		return element1;
	}
	public void setElement1(String element1) {
		this.element1 = element1;
	}
	public String getElement2() {
		return element2;
	}
	public void setElement2(String element2) {
		this.element2 = element2;
	}
	public String getElement3() {
		return element3;
	}
	public void setElement3(String element3) {
		this.element3 = element3;
	}
	public String getElement4() {
		return element4;
	}
	public void setElement4(String element4) {
		this.element4 = element4;
	}
	public String getElement5() {
		return element5;
	}
	public void setElement5(String element5) {
		this.element5 = element5;
	}
	@Override
	public String toString() {
		return "SimpleObject is [element1=" + element1 + ", element2=" + element2
				+ ", element3=" + element3 + ", element4=" + element4
				+ ", element5=" + element5 + "]";
	}
	
}
