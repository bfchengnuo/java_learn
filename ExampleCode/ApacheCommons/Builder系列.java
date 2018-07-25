//ToStringBuilder  
@Override 
public String toString() {  
    return new ToStringBuilder(this).append(this.getId())  
            .append(this.getUsername()).toString();  
}  
 
@Override 
public String toString() {  
    return ToStringBuilder.reflectionToString(this);  
}  
// 以上输出格式为  Test@1270b73[<null>,<null>]  
 
 
 
// HashCodeBuilder  
@Override 
public int hashCode() {  
    return HashCodeBuilder.reflectionHashCode(this);  
}  
 
@Override 
public int hashCode() {  
    return new HashCodeBuilder(this).append(this.getId())  
            .append(this.getUsername()).hashCode();  
}  
 
 
 
// EqulasBuilder  
@Override 
public boolean equals(Object obj) {  
    if (this == obj) {  
        return true;  
    }  
    if (obj.getClass() == Test.class) {  
        Test test = (Test) obj;  
        return new EqualsBuilder().append(this.getId(), test.getId())  
                .append(this.getUsername(), test.getUsername()).isEquals();  
    }  
    return false;  
}  
@Override 
public boolean equals(Object obj) {  
    return EqualsBuilder.reflectionEquals(this, obj);  
}  
 
 
// CompareToBuilder  
@Override 
public int compareTo(Test o) {  
    return CompareToBuilder.reflectionCompare(this, o);  
}  
 
@Override 
public int compareTo(Test o) {  
    return new CompareToBuilder().append(this.getId(), o.getId())  
            .append(this.getUsername(), o.getUsername()).toComparison();  
}