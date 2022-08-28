package mandacaru.service.util;

import java.io.ByteArrayOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import mandacaru.model.Imovel;

public class PdfGenerator {

	public byte[] criarPdf(Imovel imovel) {
			
			 Document document = new Document();
			 ByteArrayOutputStream out = new ByteArrayOutputStream();    
	         
	         try {
	        	 PdfWriter.getInstance(document, out);
	        	 
	        	 document.open();
	        	 
	        	 document.add(new Paragraph("Titulo:"+ imovel.getTitulo()));
		         document.add(new Paragraph("Endereço:"+ imovel.getEndereco()));
		         document.add(new Paragraph("Metros Quadrados do terreno:"+ imovel.getMetros_quadrados_de_terreno()));
		         document.add(new Paragraph("Qunatidade de Quartos:"+ imovel.getQuantidade_de_quartos()));
		         document.add(new Paragraph("Quantidade de Banheiros:"+ imovel.getQuantidade_de_banheiros()));
		         document.add(new Paragraph("Quantidade de Vagas na Garagem:"+ imovel.getQuantidade_de_vagas_de_garagem()));
		         document.add(new Paragraph("Preço:"+ imovel.getPreco()));
	         }
	         catch(Exception e){}
	         
	         document.close();
	        
			return out.toByteArray();
	     	}

		 }
	 
	

