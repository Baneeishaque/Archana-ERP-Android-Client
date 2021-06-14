package com.example.login;

public abstract class ApiUtils {

    public String getApiMethodEndpointUrl(String apiMethodName) {

        return getAddressProtocol() + "://" + getServerAddress() + "/" + getServerApplicationFolder() + "/" + apiMethodName;
    }

    protected abstract String getServerApplicationFolder();

    protected abstract String getServerAddress();

    protected abstract String getAddressProtocol();
}
