/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseautomationsystem;

/**
 *
 * @author Osman Süzer
 */
public class Document implements DocumentInterface
{
    String DocumentName;
    String DocumentType;
    
    Document(String documentName, String documentType)
    {
        setDocumentName(documentName);
        setDocumentType(documentType);
    }
    

    @Override
    public void setDocumentName(String newDocumentName)
    {
        DocumentName = newDocumentName;
    }

    @Override
    public String getDocumentName()
    {
        return DocumentName;
    }
    

    @Override
    public void setDocumentType(String newDocumentType)
    {
        DocumentType = newDocumentType;
    }


    @Override
    public String getDocumentType()
    {
        return DocumentType;
    }
    

    @Override
    public boolean equals(Document otherDocument)
    {
        return(this.getDocumentName() == otherDocument.getDocumentName() &&
                this.getDocumentType() == otherDocument.getDocumentType());
    }
    
    @Override
    public String toString()
    {
        return String.format("Document Type : %s - Document Name : %s", 
                                   getDocumentType(), getDocumentName());
    }
}