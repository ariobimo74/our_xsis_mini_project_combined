package com.xsis.xsis.services.rio;

import com.xsis.xsis.model.rio.ClientEntityRio;
import com.xsis.xsis.repository.rio.ClientRepositoryRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceRio
{
    @Autowired
    private ClientRepositoryRio clientRepository;

    public Iterable<ClientEntityRio> getClientEntity()
    {
        List<ClientEntityRio> clientEntities = new ArrayList<>();
        for (ClientEntityRio clientEntity : clientRepository.findAll())
        {
            if (!clientEntity.getIsDelete())
            {
                clientEntities.add(clientEntity);
            }
        }
        return clientEntities;
    }

    public Optional<ClientEntityRio> findClientById(Long clientId)
    {
        return clientRepository.findById(clientId);
    }
}
