package io.munkush.app.service;

import io.munkush.app.dto.RegisterRequestDto;
import io.munkush.app.mapper.RequestToRepresentationMapper;
import io.munkush.app.mapper.RequestToUserMapper;
import io.munkush.app.model.User;
import io.munkush.app.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final Keycloak keycloak;
    private RealmResource keycloakTemplate;


    private final RequestToRepresentationMapper requestToRepresentationMapper;
    private final RequestToUserMapper requestToUserMapper;


    @PostConstruct
    public void init(){
        keycloakTemplate = keycloak.realm("NotificationApplication");
    }


    public void save(RegisterRequestDto requestDto){
        // Сохранение в Keycloak
        saveToKeyCloak(requestDto);
        // Сохранение в Postgres
        saveToPostgres(requestDto);
    }
    private void saveToKeyCloak(RegisterRequestDto requestDto){
        var userRepresentation = requestToRepresentationMapper.map(requestDto);
        keycloakTemplate.users().create(userRepresentation);
    }

    private void saveToPostgres(RegisterRequestDto requestDto){
        var user = requestToUserMapper.map(requestDto);

        setId(user, requestDto);

        userRepository.save(user);
    }

    private void setId(User user, RegisterRequestDto requestDto){
        var userRepresentation = keycloakTemplate.users()
                .searchByUsername(requestDto.getUsername(),true).get(0);

        var id = userRepresentation.getId();

        user.setId(id);
    }
}
