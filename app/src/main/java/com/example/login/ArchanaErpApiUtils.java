package com.example.login;

public class ArchanaErpApiUtils extends ApiUtils {

    @Override
    protected String getFileExtension() {

        return ServerEndPoint.serverFileExtension;
    }

    @Override
    protected String getServerApplicationFolder() {

        return ServerEndPoint.serverApplicationFolder;
    }

    @Override
    protected String getServerAddress() {

        return ServerEndPoint.serverAddress;
    }

    @Override
    protected String getAddressProtocol() {

        return ServerEndPoint.serverAddressProtocol;
    }

    String getLoginApiUrl() {

//        return getApiMethodEndpointUrl("login.php");
        return getApiMethodEndpointUrl("getLogin");
    }

    String getSignUpApiUrl() {

        return getApiMethodEndpointUrl("signup.php");
    }
}
