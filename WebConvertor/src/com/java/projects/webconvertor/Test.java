package com.java.projects.webconvertor;

import java.io.StringReader;

import org.w3c.css.sac.InputSource;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSRuleList;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleRule;
import org.w3c.dom.css.CSSStyleSheet;

import com.steadystate.css.parser.CSSOMParser;

public class Test {
	public static void main(String[] args) throws Exception {
//		InputStream inStream = new FileInputStream("input.css");
//		try {
//		    InputSource source = new InputSource(new InputStreamReader(inStream, "UTF-8"));
//		    CSSOMParser parser = new CSSOMParser();
//		    CSSStyleDeclaration decl = parser.parseStyleDeclaration(source);
//		} finally {
//		    inStream.close();
//		}
//		for (int i = 0; i < decl.getLength(); i++) {
//		    final String propName = decl.item(i);
//
//		    System.out.println("'" + propName + "' has value: '" + 
//
//		decl.getPropertyValue(propName) + "'");
//		}
		InputSource source = new InputSource(new StringReader("h1 { background: #ffcc44, #ffcc45; background: #ffcc45 } h1 { background: #ffcc45; } "));
		CSSOMParser parser = new CSSOMParser();
		CSSStyleSheet sheet = parser.parseStyleSheet(source, null, null);
		CSSRuleList rules = sheet.getCssRules();
		for (int i = 0; i < rules.getLength(); i++) {
		    final CSSRule rule = rules.item(i);
		    if (rule instanceof CSSStyleRule) 
            {
                CSSStyleRule styleRule=(CSSStyleRule)rule;
                System.out.println("selector:" + i + ": " + styleRule.getSelectorText());
                CSSStyleDeclaration styleDeclaration = styleRule.getStyle();


                for (int j = 0; j < styleDeclaration.getLength(); j++) 
                {
                     String property = styleDeclaration.item(j);
                     System.out.println("property: " + property);
                     System.out.println("value: " + styleDeclaration.getPropertyCSSValue(property).getCssText());
                     System.out.println("priority: " + styleDeclaration.getPropertyPriority(property));   
                }



             }// end of StyleRule instance test
           } 
		    //System.out.println(rule.getCssText();
		}
		
	}

			

