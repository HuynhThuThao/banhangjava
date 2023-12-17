package Model;

public class producttype {
    private String TypeID;
    private String TypeName;

    public producttype() {
    
    }

    public String getTypeID() {
        return TypeID;
    }

    public void setTypeID(String typeID) {
        TypeID = typeID;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }

    @Override
    public String toString() {
        return "producttype [TypeID=" + TypeID + ", TypeName=" + TypeName + "]";
    }
}
