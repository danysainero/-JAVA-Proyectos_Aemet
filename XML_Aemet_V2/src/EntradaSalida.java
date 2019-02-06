
import java.util.ArrayList;

public class EntradaSalida 
{
	
	public static void mostrarClima(Clima c) 
	{
	String provincia=c.getProvincia();
	String municipio=c.getMunicipio();
	ArrayList<Dia> lista_dias=c.getLista_dias();
	System.out.println("Provincia:  "+provincia+ "\nMunicipio: "+municipio);	
		
		for(int i=0;i<lista_dias.size();i++) 
		{
			Dia d=(Dia)lista_dias.get(i);
			String fecha_bonita=d.getFecha();
			String[] campos = fecha_bonita.split("-");
			String fecha_buena=campos[2]+"/"+campos[1]+"/"+campos[0];
			System.out.println("fecha: "+ fecha_buena+" Tª max: "+ d.getT_maxima()+ " Tª min " + d.getT_minima());      
		}		
	}	
}
    

