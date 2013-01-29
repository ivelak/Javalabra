package maalimanvahvimmat.model.liikkeet;

import maalimanvahvimmat.model.Liike;

public class Kyykky extends Liike {

    
    
    @Override
    public String getNimi() {
        return this.getClass().getSimpleName();
    }
    
    
}
