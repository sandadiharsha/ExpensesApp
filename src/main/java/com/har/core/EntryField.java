/**
 * 
 */
package com.har.core;

import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author hsandadi
 *
 */
public class EntryField extends TagSupport{
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	private String value;
@Override
public int doStartTag() throws JspException {
	JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
    try{
    StringBuffer buffer=new StringBuffer();
    buffer.append("<input type=");
    buffer.append(type);
    if(name!=null)
    {
    	buffer.append(" name=");
    	buffer.append(name);
    }
    if(value!=null){
    	buffer.append(" value=");
    	buffer.append(value);
    }
    buffer.append(">");
     out.write(buffer.toString());  
    }catch(Exception e){System.out.println(e);}  
    return SKIP_BODY;//will not evaluate the body content of the tag}
}
}