package com.babbyunplugged.example;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang3.text.StrSubstitutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

@Controller
public class TestController {

	@GetMapping(value="/rptform")
	public String create(Model model) {

	    model.addAttribute("rpt", new Rpt());
	    return "form-rpt.html";
	}
	
	@PostMapping(value="/saverpt")
	public String save(@Valid Rpt rpt, BindingResult result) {

		//System.out.println("Name:"+rpt.getName());
	//	System.out.println("Content:"+rpt.getContent());
		try {
			generatePDFFromHTML(applyData(rpt.getContent()));	//apply data will replace variables.
		} catch (IOException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return "index";
	}
	
	/*
	 * Populate here all the variables from db,csv or any other source.
	 * variable format will be ${name}
	 */
	private String applyData(String template) {
		
		Map<String,String> valuesMap = new HashMap<>();
		 valuesMap.put("name", "Prashant Gupta");
		 valuesMap.put("Email", "prashant.gupta.ext@orange.com");
		 StrSubstitutor sub = new StrSubstitutor(valuesMap);
		 String resolvedString = sub.replace(template);
		return resolvedString;
		
	}
	
	private void generatePDFFromHTML(String filename) throws FileNotFoundException, IOException, DocumentException {
	    Document document = new Document(PageSize.A4, 20, 20, 50, 25);
	    PdfWriter writer = PdfWriter.getInstance(document,
	      new FileOutputStream("html.pdf"));
	    HeaderFooterPageEvent event = new HeaderFooterPageEvent();
	    writer.setPageEvent(event);
	    document.open();
	    
	    /*XMLWorkerHelper.getInstance().parseXHtml(writer, document,
	      new FileInputStream(filename));*/
	    InputStream is = new ByteArrayInputStream(filename.getBytes());
	    XMLWorkerHelper.getInstance().parseXHtml(writer,document,is);
	    document.close();
	}
	
}
