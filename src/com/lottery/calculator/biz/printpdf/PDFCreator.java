package com.lottery.calculator.biz.printpdf;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFCreator {
	public static void main(String args[]) throws Exception {

		Document document = new Document();
		PdfPTable table = new PdfPTable(new float[] { 2, 1, 2 });
		table.setWidthPercentage(100); // Width 100%
		table.setSpacingBefore(10f); // Space before table
		table.setSpacingAfter(10f);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell("Name");
		table.addCell("Age");
		table.addCell("Location");
		table.setHeaderRows(1);
		PdfPCell[] cells = table.getRow(0).getCells();
		for (int j = 0; j < cells.length; j++) {
			cells[j].setBackgroundColor(BaseColor.GRAY);
		}
		for (int i = 1; i < 500; i++) {
			table.addCell("Name:" + i);
			table.addCell("Age:" + i);
			table.addCell("Location:" + i);
		}
		PdfWriter.getInstance(document, new FileOutputStream("D:\\Sunil's workspace\\sample3.pdf"));
		document.open();
		document.add(new Paragraph("Report"));
		document.addAuthor("SA");
		document.addCreationDate();
		document.addCreator("Report Generator");
		document.addTitle("Report Generator");
		document.addSubject("An example to show how attributes can be added to pdf files.");
		document.add(table);
		document.close();
		System.out.println("Done");
	}
}
