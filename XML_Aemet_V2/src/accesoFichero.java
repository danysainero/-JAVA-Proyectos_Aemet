import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class accesoFichero 
{

	public static Clima parsearXML() 
	{
		Clima c=null;
		SAXBuilder builder = new SAXBuilder();
		try 
		{
			Document documento=builder.build(new File("C:\\XML_Aemet\\aemet_xml.xml"));
			Element elemento_raiz=documento.getRootElement();
			Element elemento_municipio=elemento_raiz.getChild("nombre");
			Element elemento_provincia=elemento_raiz.getChild("provincia");
			String municipio=elemento_municipio.getValue();
			String provincia=elemento_provincia.getValue();
			Element elemento_prediccion=elemento_raiz.getChild("prediccion");
			List<Element> lista_elementos_dia=elemento_prediccion.getChildren("dia");
			
			/*for(int i=0;i<lista_elementos_dia.size();i++) 
			* {			 
			*Element element=lista_elementos_dia.get(i); 
			* }*/
			ArrayList<Dia> lista_dias=new ArrayList<>();
			for (Element element : lista_elementos_dia) {
				Attribute atributo_fecha=element.getAttribute("fecha");
				String fecha_rara=atributo_fecha.getValue();
				Element elemento_temperatura=element.getChild("temperatura");
				String t_minima=elemento_temperatura.getChild("minima").getValue();
				String t_maxima=elemento_temperatura.getChild("maxima").getValue();
				Dia d=new Dia(fecha_rara,Integer.parseInt(t_minima), Integer.parseInt(t_maxima));
				lista_dias.add(d);
			}
			c=new Clima(municipio, provincia, lista_dias);
			
		}
		catch (JDOMException | IOException e) 
		{
			e.printStackTrace();
		}
					
		return c;
	}

}	
	

