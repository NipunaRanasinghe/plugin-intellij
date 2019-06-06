package io.ballerina.plugins.idea.extensions.server;

import org.eclipse.lsp4j.jsonrpc.services.JsonRequest;
import org.eclipse.lsp4j.jsonrpc.services.JsonSegment;

import java.util.concurrent.CompletableFuture;

/**
 * An extension interface for Language server to add features related to ballerina files.
 */
@JsonSegment("ballerinaDocument")
public interface BallerinaDocumentService {

    @JsonRequest
    CompletableFuture<BallerinaASTResponse> ast(BallerinaASTRequest request);

    @JsonRequest
    CompletableFuture<BallerinaASTDidChangeResponse> astDidChange(BallerinaASTDidChange notification);
}
