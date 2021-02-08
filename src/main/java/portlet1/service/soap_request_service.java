package portlet1.service;
import java.io.*;
import io.restassured.*;
import io.restassured.response.*;
import portlet1.constants.urls;
import portlet1.dto.CreateShipmentRequest;
import portlet1.dto.CreateShipmentResponse;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import static io.restassured.RestAssured.*;
public class soap_request_service {
    private static soap_request_service instance;

    public static soap_request_service getInstance() {
        if (soap_request_service.instance == null) {
            soap_request_service.instance = new soap_request_service();
        }
        return soap_request_service.instance;
    }

    private InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }
    public String readRequestFile() {
     
            try {
                 BufferedInputStream bis = new BufferedInputStream(getFileFromResourceAsStream(urls.create_shipment_soap_request_path));
                try {
                    String fileContents = new String(bis.readAllBytes());
                    bis.close();
                    String s = fileContents;
                    bis.close();
                    return s;
                }
                catch (Throwable t) {
                    try {
                        bis.close();
                    }
                    catch (Throwable t2) {
                        t.addSuppressed(t2);
                    }
                    throw t;
                }
            }catch(Exception e){

                return "faild to read file";
            }
            
            
      
    }

    private String request_with_form_value(CreateShipmentRequest requestModel) {
        return readRequestFile()
        		.replaceFirst("PRODUCT", requestModel.getProduct())
        		.replaceFirst("ACCOUNT_NUMBER", requestModel.getAccountNumber())
        		.replaceFirst("CUSTOMER_REFERENCE", requestModel.getCustomerReference())
        		.replaceFirst("SHIPMENT_DATE", requestModel.getShipmentDate().replaceAll("/", "-"))
        		.replaceFirst("PRODUCT_WEIGHT", requestModel.getWeight())
        		.replaceFirst("RECIEPENT_EMAIL_ADDRESS", requestModel.getRecipientEmail())
        		.replaceFirst("SHIPER_NAME", requestModel.getShipperName())
        		.replaceFirst("SHIPER_STREET_NAME", requestModel.getShipperStreetName())
        		.replaceFirst("SHIPER_STREET_NUMBER", requestModel.getShipperStrteetNumber())
        		.replaceFirst("SHIPER_ZIP", requestModel.getShipperZip())
        		.replaceFirst("SHIPER_CITY", requestModel.getShipperCity())
        		.replaceFirst("SHIPER_COUNTRY_CODE", requestModel.getShipperCountry())
        		.replaceFirst("RECEIVER_NAME", requestModel.getReceiverName())
        		.replaceFirst("RECEIVER_STREET_NAME", requestModel.getReceiverStreetName())
        		.replaceFirst("RECEIVER_STREET_NUMBER", requestModel.getReceiverStrteetNumber())
        		.replaceFirst("RECEIVER_ZIP", requestModel.getReceiverZip())
        		.replaceFirst("RECEIVER_CITY", requestModel.getReceiverCity())
        		.replaceFirst("RECEIVER_COUNTRY_CODE", requestModel.getReceiverCountry());
    }

    public InputStream send_soap_request(CreateShipmentRequest requestModel) {
        RestAssured.baseURI = urls.dhl_sandbox_request;
        Response response =
        		given()
        		.header("content-type", "text/xml;charset=UTF-8")
        		.and()
        		.header("Authorization","Basic dGVzc2Fmb2xkOlNoYW0xMjM0IQ==")
        		.and()
        		.body(request_with_form_value(requestModel))
        		.when()
        		.post("/soap")
        		.then()
        		.and()
        		.log()
        		.all()
        		.extract()
        		.response();
        return response.asInputStream();
    }

    public CreateShipmentResponse convertResponseToObject(InputStream xml) {
    CreateShipmentResponse createShipmentOrderModel = new CreateShipmentResponse();
        Document doc = null;
        try {
             DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
             DocumentBuilder db = dbf.newDocumentBuilder();
             doc = db.parse(xml);
             doc.getDocumentElement().normalize();
             createShipmentOrderModel.setStatusText(doc.getElementsByTagName("statusText").item(0).getTextContent());
             NodeList nodeList = doc.getElementsByTagName("CreationState");
            Node node = nodeList.item(0);
            Element eElement = (Element)node;
            createShipmentOrderModel.setStatusMessage(eElement.getElementsByTagName("statusMessage").item(0).getTextContent());
            createShipmentOrderModel.setShipment_number(doc.getElementsByTagName("shipmentNumber").item(0).getTextContent());
            createShipmentOrderModel.setLabelUrl(eElement.getElementsByTagName("labelUrl").item(0).getTextContent());
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            return createShipmentOrderModel;
        }
        catch (NullPointerException | ParserConfigurationException | SAXException | IOException e) {
            createShipmentOrderModel.setShipment_number("shipment_number");
           return createShipmentOrderModel;

        }
    }
}