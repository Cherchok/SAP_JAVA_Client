
package client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for myHash complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="myHash">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="realMap" type="{http://ws/}mapElementsArray" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "myHash", propOrder = {
    "realMap"
})
public class MyHash {

    protected MapElementsArray realMap;

    /**
     * Gets the value of the realMap property.
     * 
     * @return
     *     possible object is
     *     {@link MapElementsArray }
     *     
     */
    public MapElementsArray getRealMap() {
        return realMap;
    }

    /**
     * Sets the value of the realMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapElementsArray }
     *     
     */
    public void setRealMap(MapElementsArray value) {
        this.realMap = value;
    }

}
