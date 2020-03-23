package br.com.service.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.com.service.rest.modelo.Banda;
import br.com.service.rest.modelo.Musica;

public class ConsomeBanda {
	public static int HTTP_COD_SUCESSO = 200;
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			if(conn.getResponseCode() != HTTP_COD_SUCESSO) {
				throw new RuntimeException("HTTP error code: " + conn.getResponseCode());
			}
			
			BufferedReader br  = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			JAXBContext jaxbContent = JAXBContext.newInstance(Banda.class);
			Unmarshaller unmarshaller = jaxbContent.createUnmarshaller();
			Banda banda = (Banda) unmarshaller.unmarshal(br);
			
			System.out.println("---------- DADOS DA BANDA -----------");
			System.out.println("Nome da banda: " + banda.getNome());
			System.out.println("Nome da banda: " + banda.getAlbum().getNome());
			System.out.println("Nome da banda: " + banda.getAlbum().getAno());
			
			
			int count = 0;
			
			for(Musica musica : banda.getAlbum().getMusicas()) {
				System.out.println("Música: " + count + musica.getNome());
				count++;
			}
			
			conn.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
