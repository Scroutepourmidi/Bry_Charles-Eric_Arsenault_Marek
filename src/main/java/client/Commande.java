package client;

import java.io.Serializable;

public class Commande implements Serializable {
    private String arg;
    private String session;

    public Commande(String arg, String session){
        this.session=session;
        this.arg=arg;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public void setArg(String arg){
        this.arg = arg;
    }

    public String getSession(){
        return this.session;
    }

    public String getArg(){
        return this.arg;
    }


    @Override
    public String toString(){
        return this.arg+" "+this.session;
    }


}
