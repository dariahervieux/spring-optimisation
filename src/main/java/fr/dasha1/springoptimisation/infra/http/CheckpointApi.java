package fr.dasha1.springoptimisation.infra.http;

import org.crac.CheckpointException;
import org.crac.Core;
import org.crac.RestoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/checkpoint")
public class CheckpointApi {
    private final Logger logger = LoggerFactory.getLogger(CheckpointApi.class);

    @PostMapping
    public void makeCheckpoint() {
        logger.info("Triggering JVM checkpoint/restore");
        try {
            Core.checkpointRestore();
        }
        catch (UnsupportedOperationException ex) {
            throw new ApplicationContextException("CRaC checkpoint not supported on current JVM", ex);
        }
        catch (CheckpointException ex) {
            throw new ApplicationContextException("Failed to take CRaC checkpoint on demand", ex);
        }
        catch (RestoreException ex) {
            throw new ApplicationContextException("Failed to restore CRaC checkpoint on demand", ex);
        }
    }

}
