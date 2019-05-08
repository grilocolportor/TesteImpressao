import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Funciounou!!!");
		
		 // Compile jrxml file.
	       try {
			JasperReport jasperReport = JasperCompileManager.compileReport("report/Teste_impressao.jrxml");
			
			// Parameters for report
		       Map<String, Object> parameters = new HashMap<String, Object>();
		       
		       JRDataSource dataSource = new JREmptyDataSource();
		       
		       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
		               parameters, dataSource);
		       
		       // Make sure the output directory exists.
		       File outDir = new File("jasperoutput");
		       outDir.mkdirs();
		 
		       // Export to PDF.
		       JasperExportManager.exportReportToPdfFile(jasperPrint,
		               "jasperoutput/teste_impressao.pdf");
		       
		       
		       if ((new File("jasperoutput/teste_impressao.pdf")).exists()) {

					Process p = Runtime
					   .getRuntime()
					   .exec("rundll32 url.dll,FileProtocolHandler c:\\Java-Interview.pdf");
					p.waitFor();
						
				} else {

					System.out.println("File is not exists");

				}

		        
		       System.out.println("Done!");
		} catch (JRException | IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
