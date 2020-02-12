package roteador.core.exception.command;

import roteador.core.constants.SystemMessage;


public class CommandException extends Exception {


    private static final long serialVersionUID = -1174968063721194602L;
    private SystemMessage mensagem = null;
    private String mensagemFinal;


    public CommandException(String message) {
        super(message);
    }


    public CommandException() {
        super();
    }


    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }


    public CommandException(Throwable cause) {
        super(cause);
    }


    public CommandException(SystemMessage mensagem){
    	this(mensagem.getChave());
    	this.mensagem = mensagem;
    }

    public CommandException(SystemMessage mensagem, Throwable cause){
          super(mensagem.getChave(), cause);
          this.mensagem = mensagem;
      }


    public CommandException(SystemMessage mensagem, String[] args) {
    	this.mensagem = mensagem;
        this.mensagemFinal = mensagem.getChave();
        int index = -1;
        for(int i=1; i<args.length+1; i++) {
            index = this.mensagemFinal.indexOf(":"+i);
            if(index > -1) {
                this.mensagemFinal = this.mensagemFinal.replace(":"+i, args[i-1]);
            }
        }
    }

    public CommandException(SystemMessage mensagem, String[] args, Throwable cause) {
          super(mensagem.getChave(), cause); //coloca value sem parametros
          this.mensagem = mensagem;
          this.mensagemFinal = mensagem.getChave();
          int index = -1;
          for(int i=1; i<args.length+1; i++) {
              index = this.mensagemFinal.indexOf(":"+i);
              if(index > -1) {
                  this.mensagemFinal = this.mensagemFinal.replace(":"+i, args[i-1]);
              }
          }
      }

    public SystemMessage getMensagem(){
        return mensagem;
    }
    
    @Override
    public String getMessage() {
        if(this.mensagemFinal == null) {
            return super.getMessage();
        } else {
            return this.mensagemFinal;
        }
    }
}
