package controllers;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import dto.Response;
import org.kxml2.io.KXmlSerializer;
import org.kxml2.kdom.Document;
import org.kxml2.wap.WbxmlParser;
import org.xmlpull.v1.XmlPullParserException;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.ProxyAuthenticator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ben-brahim.a on 19/08/14.
 */
public class Api extends Controller {

    public static Result trip(){

        Authenticator.setDefault(new ProxyAuthenticator("ben-brahim.a", "eLdorado1"));
		System.getProperties().put("http.proxyHost", "proxy.stef-tfe.fr");
		System.getProperties().put("http.proxyPort", "9090");

        URL localhost;
        Response response=new Response();

        try {

            //TODO
            // need map parameter
            // need some refactoring
            Config conf = ConfigFactory.load();
            String mtrackURL = conf.getString("mtrack.url") ;
            localhost = new URL(mtrackURL);

            HttpURLConnection httpConn = (HttpURLConnection)localhost.openConnection();
            httpConn.setRequestMethod("GET");
            Logger.debug(httpConn.getResponseMessage());
            InputStream is;
            if (httpConn.getResponseCode() >= 400) {
                is = httpConn.getErrorStream();
            } else {
                is = httpConn.getInputStream();
            }

            //TODO
            // Need some refactoring
            WbxmlParser parser = new WbxmlParser();
            parser.setTagTable(0, tagTable);
            parser.setAttrStartTable( 0, attrStartTable );
            parser.setAttrValueTable( 0, attrValueTable );
            parser.setInput(is, "UTF-8");
            Document dom = new Document();
            dom.parse(parser);

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            KXmlSerializer ser = new KXmlSerializer();
            ser.setOutput(out, null);
            dom.write(ser);
            ser.flush();
            out.close();

            byte[] b = out.toByteArray();
            Logger.debug(new String(b));

            // Unmarshaling XML Request

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b);
            Logger.debug("Available 01 "+byteArrayInputStream.available());
            JAXBContext jc = JAXBContext.newInstance(Response.class);
            Unmarshaller u = jc.createUnmarshaller();
            if(byteArrayInputStream.available()>39)
            response = (Response) u.unmarshal(byteArrayInputStream);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }catch (JAXBException e) {
            e.printStackTrace();
        }

        return  ok(Json.toJson(response)) ;
    }

    static final String tagTable[] = { "FIN_RUTA", "INCIDENCIA", "PARADA",
            "ORDEN_TRANSPORTE", "POSICION", "EXPEDIDOR", "BULTOS", "CODIGO",
            "BULTOS_INC", "RESPUESTA", "OK", "ERROR", "RUTA", "VIAJE",
            "INCIDENCIA_MLI", "ACTUALIZACION", "RECOGIDA", "TIPO", "UNIDAD",
            "CARGADO", "ACCESO", "CONTROL", "POSICION_REPRISE", "MOTIVO",
            "GLOBAL", "RESPUESTA", "DIF_HORA", "AGENCIAS", "UNIDADRECOGIDA",
            "UNIDADANOMALIARECOGIDA", "INCIDENCIARECOGIDA", "GMT", "MOTIVO",
            "INCIDENCIAREPRISE", "BORDEREAU", "POSICION_REPRISE", "AGENCIA" };

    static final String attrStartTable[] = { "cod", "nombre", "metodo",
            "numero_posicion", "cid" };
    static final String attrValueTable[] = {};

}
