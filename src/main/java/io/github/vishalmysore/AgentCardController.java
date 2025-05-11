package io.github.vishalmysore;

import io.github.vishalmysore.a2a.domain.AgentCard;
import io.github.vishalmysore.a2a.server.RealTimeAgentCardController;
import lombok.extern.java.Log;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Log
@RestController
@RequestMapping(RealTimeAgentCardController.WELL_KNOWN_PATH)
public class AgentCardController extends RealTimeAgentCardController {


    @GetMapping(value = RealTimeAgentCardController.AGENT_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AgentCard> getAgentCardForMyApp() {
        AgentCard card = getCachedAgentCard();
        card.getCapabilities().setStreaming(true);
        log.info(card.getUrl());
        return ResponseEntity.ok(card);

    }

}
