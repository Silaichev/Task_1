package project.ListForProd;

import project.entities.Chandelier;
import project.entities.Lighting;

import java.util.Iterator;

public interface CustomIterator<C extends Lighting> extends Iterator<Chandelier> {
    public void filter(ChandelierList.TypeOfFilter type, int min, int max);

    @Override
    boolean hasNext();

    @Override
    Chandelier next();
}
