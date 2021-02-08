package portlet1.dto;

import java.util.Objects;

public class CreateShipmentRequest {
    String product;
    String accountNumber;
    String customerReference;
    String shipmentDate;
    String weight;
    String recipientEmail;
    String shipperName;
    String shipperStreetName;
    String shipperStrteetNumber;
    String shipperZip;
    String shipperCity;
    String shipperCountry;
    String receiverStreetName;
    String receiverStrteetNumber;
    String receiverZip;
    String receiverCity;
    String receiverCountry;

    public CreateShipmentRequest() {
    }

    public CreateShipmentRequest(String product, String accountNumber, String customerReference, String shipmentDate, String weight, String recipientEmail, String shipperName, String shipperStreetName, String shipperStrteetNumber, String shipperZip, String shipperCity, String shipperCountry, String receiverStreetName, String receiverStrteetNumber, String receiverZip, String receiverCity, String receiverCountry) {
        this.product = product;
        this.accountNumber = accountNumber;
        this.customerReference = customerReference;
        this.shipmentDate = shipmentDate;
        this.weight = weight;
        this.recipientEmail = recipientEmail;
        this.shipperName = shipperName;
        this.shipperStreetName = shipperStreetName;
        this.shipperStrteetNumber = shipperStrteetNumber;
        this.shipperZip = shipperZip;
        this.shipperCity = shipperCity;
        this.shipperCountry = shipperCountry;
        this.receiverStreetName = receiverStreetName;
        this.receiverStrteetNumber = receiverStrteetNumber;
        this.receiverZip = receiverZip;
        this.receiverCity = receiverCity;
        this.receiverCountry = receiverCountry;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerReference() {
        return this.customerReference;
    }

    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }

    public String getShipmentDate() {
        return this.shipmentDate;
    }

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getRecipientEmail() {
        return this.recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getShipperName() {
        return this.shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getShipperStreetName() {
        return this.shipperStreetName;
    }

    public void setShipperStreetName(String shipperStreetName) {
        this.shipperStreetName = shipperStreetName;
    }

    public String getShipperStrteetNumber() {
        return this.shipperStrteetNumber;
    }

    public void setShipperStrteetNumber(String shipperStrteetNumber) {
        this.shipperStrteetNumber = shipperStrteetNumber;
    }

    public String getShipperZip() {
        return this.shipperZip;
    }

    public void setShipperZip(String shipperZip) {
        this.shipperZip = shipperZip;
    }

    public String getShipperCity() {
        return this.shipperCity;
    }

    public void setShipperCity(String shipperCity) {
        this.shipperCity = shipperCity;
    }

    public String getShipperCountry() {
        return this.shipperCountry;
    }

    public void setShipperCountry(String shipperCountry) {
        this.shipperCountry = shipperCountry;
    }

    public String getReceiverStreetName() {
        return this.receiverStreetName;
    }

    public void setReceiverStreetName(String receiverStreetName) {
        this.receiverStreetName = receiverStreetName;
    }

    public String getReceiverStrteetNumber() {
        return this.receiverStrteetNumber;
    }

    public void setReceiverStrteetNumber(String receiverStrteetNumber) {
        this.receiverStrteetNumber = receiverStrteetNumber;
    }

    public String getReceiverZip() {
        return this.receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
    }

    public String getReceiverCity() {
        return this.receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverCountry() {
        return this.receiverCountry;
    }

    public void setReceiverCountry(String receiverCountry) {
        this.receiverCountry = receiverCountry;
    }

    public CreateShipmentRequest product(String product) {
        setProduct(product);
        return this;
    }

    public CreateShipmentRequest accountNumber(String accountNumber) {
        setAccountNumber(accountNumber);
        return this;
    }

    public CreateShipmentRequest customerReference(String customerReference) {
        setCustomerReference(customerReference);
        return this;
    }

    public CreateShipmentRequest shipmentDate(String shipmentDate) {
        setShipmentDate(shipmentDate);
        return this;
    }

    public CreateShipmentRequest weight(String weight) {
        setWeight(weight);
        return this;
    }

    public CreateShipmentRequest recipientEmail(String recipientEmail) {
        setRecipientEmail(recipientEmail);
        return this;
    }

    public CreateShipmentRequest shipperName(String shipperName) {
        setShipperName(shipperName);
        return this;
    }

    public CreateShipmentRequest shipperStreetName(String shipperStreetName) {
        setShipperStreetName(shipperStreetName);
        return this;
    }

    public CreateShipmentRequest shipperStrteetNumber(String shipperStrteetNumber) {
        setShipperStrteetNumber(shipperStrteetNumber);
        return this;
    }

    public CreateShipmentRequest shipperZip(String shipperZip) {
        setShipperZip(shipperZip);
        return this;
    }

    public CreateShipmentRequest shipperCity(String shipperCity) {
        setShipperCity(shipperCity);
        return this;
    }

    public CreateShipmentRequest shipperCountry(String shipperCountry) {
        setShipperCountry(shipperCountry);
        return this;
    }

    public CreateShipmentRequest receiverStreetName(String receiverStreetName) {
        setReceiverStreetName(receiverStreetName);
        return this;
    }

    public CreateShipmentRequest receiverStrteetNumber(String receiverStrteetNumber) {
        setReceiverStrteetNumber(receiverStrteetNumber);
        return this;
    }

    public CreateShipmentRequest receiverZip(String receiverZip) {
        setReceiverZip(receiverZip);
        return this;
    }

    public CreateShipmentRequest receiverCity(String receiverCity) {
        setReceiverCity(receiverCity);
        return this;
    }

    public CreateShipmentRequest receiverCountry(String receiverCountry) {
        setReceiverCountry(receiverCountry);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateShipmentRequest)) {
            return false;
        }
        CreateShipmentRequest createShipmentRequest = (CreateShipmentRequest) o;
        return Objects.equals(product, createShipmentRequest.product) && Objects.equals(accountNumber, createShipmentRequest.accountNumber) && Objects.equals(customerReference, createShipmentRequest.customerReference) && Objects.equals(shipmentDate, createShipmentRequest.shipmentDate) && Objects.equals(weight, createShipmentRequest.weight) && Objects.equals(recipientEmail, createShipmentRequest.recipientEmail) && Objects.equals(shipperName, createShipmentRequest.shipperName) && Objects.equals(shipperStreetName, createShipmentRequest.shipperStreetName) && Objects.equals(shipperStrteetNumber, createShipmentRequest.shipperStrteetNumber) && Objects.equals(shipperZip, createShipmentRequest.shipperZip) && Objects.equals(shipperCity, createShipmentRequest.shipperCity) && Objects.equals(shipperCountry, createShipmentRequest.shipperCountry) && Objects.equals(receiverStreetName, createShipmentRequest.receiverStreetName) && Objects.equals(receiverStrteetNumber, createShipmentRequest.receiverStrteetNumber) && Objects.equals(receiverZip, createShipmentRequest.receiverZip) && Objects.equals(receiverCity, createShipmentRequest.receiverCity) && Objects.equals(receiverCountry, createShipmentRequest.receiverCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, accountNumber, customerReference, shipmentDate, weight, recipientEmail, shipperName, shipperStreetName, shipperStrteetNumber, shipperZip, shipperCity, shipperCountry, receiverStreetName, receiverStrteetNumber, receiverZip, receiverCity, receiverCountry);
    }

    @Override
    public String toString() {
        return "{" +
            " product='" + getProduct() + "'" +
            ", accountNumber='" + getAccountNumber() + "'" +
            ", customerReference='" + getCustomerReference() + "'" +
            ", shipmentDate='" + getShipmentDate() + "'" +
            ", weight='" + getWeight() + "'" +
            ", recipientEmail='" + getRecipientEmail() + "'" +
            ", shipperName='" + getShipperName() + "'" +
            ", shipperStreetName='" + getShipperStreetName() + "'" +
            ", shipperStrteetNumber='" + getShipperStrteetNumber() + "'" +
            ", shipperZip='" + getShipperZip() + "'" +
            ", shipperCity='" + getShipperCity() + "'" +
            ", shipperCountry='" + getShipperCountry() + "'" +
            ", receiverStreetName='" + getReceiverStreetName() + "'" +
            ", receiverStrteetNumber='" + getReceiverStrteetNumber() + "'" +
            ", receiverZip='" + getReceiverZip() + "'" +
            ", receiverCity='" + getReceiverCity() + "'" +
            ", receiverCountry='" + getReceiverCountry() + "'" +
            "}";
    }

    
    
}
