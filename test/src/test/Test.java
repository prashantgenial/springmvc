package test;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.text.StrSubstitutor;


public class Test {

	public static void main(String[] args) {
		
		String content = "<html><head><title>${title}</title></head><body><p>${name}</p></body></html>";
		/*String name = "Prashant Gupta";
		String title = "Customer Operations Guide";*/
		Map<String,String> valuesMap = new HashMap<>();
		 valuesMap.put("name", "Prashant Gupta");
		 valuesMap.put("title", "Customer Operations Guide");
		 StrSubstitutor sub = new StrSubstitutor(valuesMap);
		 String resolvedString = sub.replace(content);
		 System.out.println(resolvedString);
	}

}


/**
 * public class StrSubstitutor {
    private Map<String, String> map;
    private static final Pattern p = Pattern.compile("\\$\\{(.+?)\\}");

    public StrSubstitutor(Map<String, String> map) {
        this.map = map;
    }

    public String replace(String str) {
        Matcher m = p.matcher(str);
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            String var = m.group(1);
            String replacement = map.get(var);
            m.appendReplacement(sb, replacement);
        }
        m.appendTail(sb);
        return sb.toString();
    }
}*/
///https://www.baeldung.com/java-apache-commons-text
//https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/text/StrSubstitutor.html