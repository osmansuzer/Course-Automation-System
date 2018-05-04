/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseautomationsystem;

import java.util.ArrayList;

/**
 *
 * @author Osman Süzer
 */
public interface DocumentInterface 
{
    
    /**
     * Sets Document Name.
     * @param newDocumentName String to set Document Name.
     */
    public void setDocumentName(String newDocumentName);

    /**
     * Gets Document Name.
     * @return It returns Document Name as String.
     */
    public String getDocumentName();

    /**
     * Sets Document Type.
     * @param newDocumentType String to set Document Type.
     */
    public void setDocumentType(String newDocumentType);

    /**
     * Gets Document Type.
     * @return It returns Document Type as String.
     */
    public String getDocumentType();
    
    /**
     * Controls equality of Document with another Document. 
     * @param otherDocument Document which equality controlled.
     * @return It returns "true" if Documents are equal.
     */
    public boolean equals(Document otherDocument);
    
    /**
     * Converts Document to String.
     * @return Document as String.
     */
    public String toString();
}
