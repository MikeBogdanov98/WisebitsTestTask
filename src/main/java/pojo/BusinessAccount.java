package pojo;

import org.apache.commons.lang3.RandomStringUtils;

public class BusinessAccount {
    private final String producerName;
    private final String contactFirstname;
    private final String contactLastname;
    private final String directorFirstname;
    private final String directorLastname;
    private final String companyName;
    private final String registrationNumber;
    private final String vatNumber;
    private final String addressCountryCode;
    private final String addressCity;
    private final String addressRegion;
    private final String addressPostCode;
    private final String addressStreet;
    private final String custodianOfRecordsAddress;

    public BusinessAccount(String producerName,
                           String contactFirstname,
                           String contactLastname,
                           String directorFirstname,
                           String directorLastname,
                           String companyName,
                           String registrationNumber,
                           String vatNumber,
                           String addressCountryCode,
                           String addressCity,
                           String addressRegion,
                           String addressPostCode,
                           String addressStreet,
                           String custodianOfRecordsAddress) {
        this.producerName = producerName;
        this.contactFirstname = contactFirstname;
        this.contactLastname = contactLastname;
        this.directorFirstname = directorFirstname;
        this.directorLastname = directorLastname;
        this.companyName = companyName;
        this.registrationNumber = registrationNumber;
        this.vatNumber = vatNumber;
        this.addressCountryCode = addressCountryCode;
        this.addressCity = addressCity;
        this.addressRegion = addressRegion;
        this.addressPostCode = addressPostCode;
        this.addressStreet = addressStreet;
        this.custodianOfRecordsAddress = custodianOfRecordsAddress;
    }

    public BusinessAccount(){
        this.producerName = RandomStringUtils.randomAlphabetic(10);
        this.contactFirstname = RandomStringUtils.randomAlphabetic(10);
        this.contactLastname = RandomStringUtils.randomAlphabetic(10);
        this.directorFirstname = RandomStringUtils.randomAlphabetic(10);
        this.directorLastname = RandomStringUtils.randomAlphabetic(10);
        this.companyName = RandomStringUtils.randomAlphabetic(10);
        this.registrationNumber = RandomStringUtils.randomAlphabetic(10);
        this.vatNumber = RandomStringUtils.randomAlphabetic(10);
        this.addressCountryCode = RandomStringUtils.randomAlphabetic(1);
        this.addressCity = RandomStringUtils.randomAlphabetic(10);
        this.addressRegion = RandomStringUtils.randomAlphabetic(10);
        this.addressPostCode = RandomStringUtils.randomAlphabetic(10);
        this.addressStreet = RandomStringUtils.randomAlphanumeric(30);
        this.custodianOfRecordsAddress = RandomStringUtils.randomAlphanumeric(30);
    }

    public String getProducerName() {
        return producerName;
    }

    public String getContactFirstname() {
        return contactFirstname;
    }

    public String getContactLastname() {
        return contactLastname;
    }

    public String getDirectorFirstname() {
        return directorFirstname;
    }

    public String getDirectorLastname() {
        return directorLastname;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public String getAddressCountryCode() {
        return addressCountryCode;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public String getAddressRegion() {
        return addressRegion;
    }

    public String getAddressPostCode() {
        return addressPostCode;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public String getCustodianOfRecordsAddress() {
        return custodianOfRecordsAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusinessAccount that = (BusinessAccount) o;

        if (!producerName.equals(that.producerName)) return false;
        if (!contactFirstname.equals(that.contactFirstname)) return false;
        if (!contactLastname.equals(that.contactLastname)) return false;
        if (!directorFirstname.equals(that.directorFirstname)) return false;
        if (!directorLastname.equals(that.directorLastname)) return false;
        if (!companyName.equals(that.companyName)) return false;
        if (!registrationNumber.equals(that.registrationNumber)) return false;
        if (vatNumber != null ? !vatNumber.equals(that.vatNumber) : that.vatNumber != null) return false;
        if (addressCountryCode != null ? !addressCountryCode.equals(that.addressCountryCode) : that.addressCountryCode != null)
            return false;
        if (!addressCity.equals(that.addressCity)) return false;
        if (!addressRegion.equals(that.addressRegion)) return false;
        if (!addressPostCode.equals(that.addressPostCode)) return false;
        if (!addressStreet.equals(that.addressStreet)) return false;
        return custodianOfRecordsAddress.equals(that.custodianOfRecordsAddress);
    }

    @Override
    public int hashCode() {
        int result = producerName.hashCode();
        result = 31 * result + contactFirstname.hashCode();
        result = 31 * result + contactLastname.hashCode();
        result = 31 * result + directorFirstname.hashCode();
        result = 31 * result + directorLastname.hashCode();
        result = 31 * result + companyName.hashCode();
        result = 31 * result + registrationNumber.hashCode();
        result = 31 * result + (vatNumber != null ? vatNumber.hashCode() : 0);
        result = 31 * result + (addressCountryCode != null ? addressCountryCode.hashCode() : 0);
        result = 31 * result + addressCity.hashCode();
        result = 31 * result + addressRegion.hashCode();
        result = 31 * result + addressPostCode.hashCode();
        result = 31 * result + addressStreet.hashCode();
        result = 31 * result + custodianOfRecordsAddress.hashCode();
        return result;
    }
}
