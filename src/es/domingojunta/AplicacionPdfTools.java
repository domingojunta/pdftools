package es.domingojunta;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import com.itextpdf.kernel.log.SystemOutCounter;

import es.domingojunta.entities.ExpedienteEntity;
import es.domingojunta.frames.HomeFrame;
import es.domingojunta.tools.Configuracion;

public class AplicacionPdfTools {
public static void main(String[] args) {
				
		Configuracion configuracion = new Configuracion();
		HomeFrame homeFrame;

		ExpedienteEntity expedienteEntity = configuracion.cargarConfiguracion();
		
//		String os = System.getProperty("os.name");
//		String dir =System.getProperty("user.dir");
//		System.out.println("El S.O. es: "+ os + " y el directorio de trabajo es: "+dir);
		homeFrame = new HomeFrame(expedienteEntity);
		//homeFrame.setExpedienteEntity(expedienteEntity);
		homeFrame.setVisible(true);

	}

}
