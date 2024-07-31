package io.munkush.app.mapper;


import io.munkush.app.dto.RegisterRequestDto;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RequestToRepresentationMapper implements Mapper<RegisterRequestDto, UserRepresentation> {


    @Override
    public UserRepresentation map(RegisterRequestDto addSource) {
        UserRepresentation userRepresentation = new UserRepresentation();

        userRepresentation.setUsername(addSource.getUsername());
        userRepresentation.setEmail(addSource.getEmail());
        userRepresentation.setFirstName(addSource.getFirstname());
        userRepresentation.setLastName(addSource.getLastname());
        userRepresentation.setEnabled(true);
        userRepresentation.setEmailVerified(true);

        var credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setTemporary(false);
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
        credentialRepresentation.setValue(addSource.getPassword());
        userRepresentation.setCredentials(List.of(credentialRepresentation));



        return userRepresentation;
    }
}
