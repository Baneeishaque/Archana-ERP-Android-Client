package com.example.login;

public abstract class ApiUtils {

//    public String getApiMethodEndpointUrl(String apiMethodName) {
//
//        return getAddressProtocol() + "://" + getServerAddress() + "/" + getServerApplicationFolder() + "/" + apiMethodName;
//    }

    public String getApiMethodEndpointUrl(String apiMethodName) {

        return getAddressProtocol() + "://" + getServerAddress() + "/" + getServerApplicationFolder() + "/" + apiMethodName + getFileExtension();
    }

    protected abstract String getFileExtension();

    protected abstract String getServerApplicationFolder();

    protected abstract String getServerAddress();

    protected abstract String getAddressProtocol();
}
