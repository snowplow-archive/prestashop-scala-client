package co.orderly.prestasac.representations.shared;
 
import org.eclipse.persistence.oxm.XMLNameTransformer;
 
public class LowerCaseWithUnderscoresNameGenerator implements XMLNameTransformer {
 
    public String transformRootElementName(String name) {
        return name;
    }
 
    public String transformTypeName(String name) {
        return name;
    }
 
    public String transformElementName(String name) {
        StringBuilder strBldr = new StringBuilder();
        for(char character : name.toCharArray()) {
            if(Character.isUpperCase(character)) {
                strBldr.append('_');
                strBldr.append(Character.toLowerCase(character));
            } else {
                strBldr.append(character);
            }
         }
        return strBldr.toString();
    }
 
    public String transformAttributeName(String name) {
        return name;
    }
}
