package com.primeton.cloud.service;

import com.primeton.cloud.model.Oauth2Client;

import java.util.List;

public interface ClientService {


    public Oauth2Client createClient(Oauth2Client client);
    public Oauth2Client updateClient(Oauth2Client client);
    public void deleteClient(Long clientId);

    Oauth2Client findOne(Long clientId);

    List<Oauth2Client> findAll();

    Oauth2Client findByClientId(String clientId);
    Oauth2Client findByClientSecret(String clientSecret);
}
