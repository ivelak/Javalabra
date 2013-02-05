package maalimanvahvimmat.model;

import java.util.List;

/**
 * Yläluokka kaikille liikkeille
 * @author rantapel
 */

public abstract class Liike {

    private List<Integer> toistot;
    private List<Integer> painot;

    public abstract String getNimi();
}
