package com.primeton.cloud.service;

import com.primeton.cloud.dao.Oauth2ClientMapper;
import com.primeton.cloud.model.Oauth2Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private Oauth2ClientMapper oauth2ClientMapper;

    @Override
    public Oauth2Client createClient(Oauth2Client client) {

       return null;

    }

    @Override
    public Oauth2Client updateClient(Oauth2Client client) {
        return null;
    }

    @Override
    public void deleteClient(Long clientId) {

    }

    @Override
    public Oauth2Client findOne(Long clientId) {
        return null;
    }

    @Override
    public List<Oauth2Client> findAll() {
        return null;
    }

  @Override
    public Oauth2Client findByClientId(String clientId) {
    //    return oauth2ClientMapper.findByClientId(clientId);
      return null;
    }

    @Override
    public Oauth2Client findByClientSecret(String clientSecret) {
        return null;
    }
}

