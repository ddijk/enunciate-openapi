package dk.jyskebank.tools.enunciate.modules.openapi.simple;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="dataXml")
@XmlType(propOrder = { "first", "content", "password", "receivers", "success", "message", "greeting", "last"})
@XmlAccessorType(XmlAccessType.FIELD)
public class DataXmlDTO {
	/** Last string. Should be last in serialization order. */
	private String last;
	/** First string. Should be first in serialization order. */
	private String first;
	
	@CustomAnnotation(custom = "foo")
	@XmlElement(name="password")
	private String password;

    @CustomAnnotation(custom = "bar", listValues = {"a", "b", "c"})
	@XmlElement(name="content")
	private byte[] content;

	@XmlElementWrapper(name="receivers")
	@XmlElement(name = "receiver")
	private List<String> receivers = new ArrayList<>();

	@XmlElement(name="success", nillable=false)
	private boolean success = true;
	    
	@XmlElement(name="message", nillable=true)
	private String message;

	@XmlElement(name="greeting")
	private DataXmlEnum greeting;
	
	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}
}
