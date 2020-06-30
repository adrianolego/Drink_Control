package com.challange.drinkcontrol.resource;

import com.challange.drinkcontrol.domain.Session;
import com.challange.drinkcontrol.dto.SessionDTO;
import com.challange.drinkcontrol.service.SessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Api(value = "API REST Session")
@RestController
@RequestMapping("/session")
public class SessionResource {

    @Autowired
    private SessionService sessionService;

    @ApiOperation(value = "Find Session")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Session> find(@PathVariable Integer id) {
        Session session = sessionService.find(id);
        return ResponseEntity.ok().body(session);
    }

    @ApiOperation(value = "Find Sessions")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<SessionDTO>> findAllSessionPaginated(
            @RequestParam(value = "initialPage", defaultValue = "0") Integer page,
            @RequestParam(value = "linesAmount", defaultValue = "10") Integer linesPerPage,
            @RequestParam(value = "orderField", defaultValue = "id") String orderBy,
            @RequestParam(value = "ascOrDesc", defaultValue = "asc") String direction) {
        Page<Session> listSessions = sessionService.findPage(page, linesPerPage, orderBy, direction);
        Page<SessionDTO> listDto = listSessions.map(dto -> new SessionDTO(dto));
        return ResponseEntity.ok().body(listDto);
    }

    @ApiOperation(value = "Insert session")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody SessionDTO sessionDTO) {
        Session session = sessionService.fromDTO(sessionDTO);
        session = sessionService.insert(session);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(session.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @ApiOperation(value = "Update session")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody SessionDTO sessionDTO, @PathVariable Integer id) {
        sessionDTO.setId(id);
        Session session = sessionService.fromDTO(sessionDTO);
        sessionService.update(session);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Delete session")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        sessionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
