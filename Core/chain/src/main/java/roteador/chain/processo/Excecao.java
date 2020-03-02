package roteador.chain.processo;

import org.apache.log4j.Logger;

import roteador.core.constants.Transaction;
import roteador.core.constants.SystemMessage;
import roteador.core.exception.command.CommandException;
import roteador.core.exception.service.ServiceException;
import roteador.core.exception.service.TransactionExecutionException;

/**
 * 
 * @author Mauricio Santos
 *
 */
public class Excecao {

    private static final Logger LOG = Logger.getLogger(Excecao.class);

    private static final String TIPO_COMMAND = "COMMAND";

    private static final String TIPO_EXECUCAO_TRANSACAO = "EXECUCAO_TRANSACAO";

    private static final String TIPO_SERVICE = "SERVICE";

    @SuppressWarnings("unused")
	private static final String TIPO_PRODUCT_QUANTITY = "PRODUCT_QUANTITY";

    private final String tipo;

    private final String construcao;
    
    public Excecao(final String _tipo, final String _construcao) {
        this.tipo = _tipo;
        this.construcao = _construcao;
    }

    /**
     * 
     * @throws Exception
     */
    public void lancar() throws Exception {
        LOG.info("Ocorreu uma excecao do tipo " + this.tipo + " mapeada no processo.");
        if (tipo.equals(TIPO_COMMAND)) {
            throw new CommandException(SystemMessage.valueOf(construcao));
        } else if (tipo.equals(TIPO_EXECUCAO_TRANSACAO)) {
            throw new TransactionExecutionException(Transaction.valueOf(construcao));
        } else if (tipo.equals(TIPO_SERVICE)) {
            throw new ServiceException(SystemMessage.valueOf(construcao));
        } else {
            throw new IllegalStateException("Excecao n�o consta no resultado da sequencia");
        }
    }

}
