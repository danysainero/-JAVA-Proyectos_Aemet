import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ClasePrincipal 
{

	public static void main(String[] args) 
	{
		SAXBuilder builder = new SAXBuilder();
		try 
		{
			Document documento=builder.build(new File("C:\\XML_Aemet\\aemet_xml.xml"));
			Element elemento_raiz=documento.getRootElement();
			Element elemento_nombre=elemento_raiz.getChild("nombre");
			Element elemento_provincia=elemento_raiz.getChild("provincia");
			Element elemento_prediccion=elemento_raiz.getChild("prediccion");
			
			//Element elemento_temperatura=elemento_día.getChild("temperatura");
			//Element elemento_temperatura_max=elemento_temperatura.getChild("maxima");
			//Element elemento_temperatura_min=elemento_temperatura.getChild("minima");
			List<Element> lista_dias=elemento_prediccion.getChildren("dia");
			
			
			
				System.out.println("Nombre: "+elemento_nombre.getValue()+" Provincia: "+elemento_provincia.getValue());
				
				for (Element element : lista_dias)
				{
					Attribute atributo_fecha=element.getAttribute("fecha");	
					Element elemento_temperatura=element.getChild("temperatura");
					Element elemento_temperatura_max=elemento_temperatura.getChild("maxima");
					Element elemento_temperatura_min=elemento_temperatura.getChild("minima");
					System.out.println("dia: "+atributo_fecha.getValue());
					System.out.println("Tª min: "+elemento_temperatura_min.getValue()+ " Tª max: "+elemento_temperatura_max.getValue());
				}
				
			
		} 
		catch (JDOMException | IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	

}
