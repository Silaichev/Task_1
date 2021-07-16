package project.ListForProd;

import org.junit.Assert;
import org.junit.Test;
import project.entities.Chandelier;
import project.entities.Lighting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class ChandelierListTest {
    ChandelierList list = new ChandelierList();

    @Test
    public void size() {
        list.add(new Chandelier("Viennese",1000, 220, Lighting.TypeLight.Bulb_roll,12));
        list.add(new Chandelier("French",1200, 220, Lighting.TypeLight.Led,12));
        list.add(new Chandelier("Russian ",1400, 220, Lighting.TypeLight.Bulb_roll,12));
        int expected = 3;
        int actual = list.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void contains() {
        Chandelier c1 = new Chandelier("Viennese",1000, 220, Lighting.TypeLight.Bulb_roll,12);
        Chandelier c2 = new Chandelier("French",1200, 220, Lighting.TypeLight.Led,12);
        Chandelier c3 = new Chandelier("Russian ",1400, 220, Lighting.TypeLight.Bulb_roll,12);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        assertTrue(list.contains(c2));
    }

    @Test
    public void iterator() {
        Chandelier c1 = new Chandelier("Viennese",1000, 220, Lighting.TypeLight.Bulb_roll,12);
        Chandelier c2 = new Chandelier("French",1200, 220, Lighting.TypeLight.Led,12);
        Chandelier c3 = new Chandelier("Russian ",1400, 220, Lighting.TypeLight.Bulb_roll,12);
        list.add(c1);
        list.add(c2);
        list.add(c3);

        Iterator it = list.iterator();

        int numOfChan = 0;
        while(it.hasNext()){
            numOfChan++;
            it.next();
        }
        Assert.assertEquals(list.size(),numOfChan);
    }

    @Test
    public void add() {
        Chandelier c1 = new Chandelier("Viennese",1000, 220, Lighting.TypeLight.Bulb_roll,12);
        Chandelier c2 = new Chandelier("French",1200, 220, Lighting.TypeLight.Led,12);
        list.add(c1);
        list.add(c2);
        assertEquals(c2,list.get(1));

    }
    @Test
    public void addWithIndex() {
        Chandelier c1 = new Chandelier("Viennese",1000, 220, Lighting.TypeLight.Bulb_roll,12);
        Chandelier c2 = new Chandelier("French",1200, 220, Lighting.TypeLight.Led,12);
        Chandelier c3 = new Chandelier("Russian ",1400, 220, Lighting.TypeLight.Bulb_roll,12);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        Chandelier c4 = new Chandelier("Пражская", 220, 220, Lighting.TypeLight.Bulb_roll, 20);
        list.add(1,c4);
        assertEquals(c4, list.get(1));
    }

    @Test
    public void remove() {
        Chandelier c1 = new Chandelier("Viennese",1000, 220, Lighting.TypeLight.Bulb_roll,12);
        Chandelier c2 = new Chandelier("French",1200, 220, Lighting.TypeLight.Led,12);
        Chandelier c3 = new Chandelier("Russian ",1400, 220, Lighting.TypeLight.Bulb_roll,12);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.remove(1);
        assertFalse(list.contains(c2));
    }

    @Test
    public void removeObject() {
        Chandelier c1 = new Chandelier("Viennese",1000, 220, Lighting.TypeLight.Bulb_roll,12);
        Chandelier c2 = new Chandelier("French",1200, 220, Lighting.TypeLight.Led,12);
        Chandelier c3 = new Chandelier("Russian ",1400, 220, Lighting.TypeLight.Bulb_roll,12);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.remove(c2);
        assertFalse(list.contains(c2));
    }


    @Test
    public void addAll() {
        Chandelier c1 = new Chandelier("Viennese",1000, 220, Lighting.TypeLight.Bulb_roll,12);
        Chandelier c2 = new Chandelier("French",1200, 220, Lighting.TypeLight.Led,12);
        Chandelier c3 = new Chandelier("Russian ",1400, 220, Lighting.TypeLight.Bulb_roll,12);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        List<Chandelier> temp = new ArrayList<>();
        temp.add(c1);
        temp.add(c2);
        temp.add(c3);
        assertTrue(list.addAll(temp));
    }

    @Test
    public void removeAll() {
        Chandelier c1 = new Chandelier("Viennese",1000, 220, Lighting.TypeLight.Bulb_roll,12);
        Chandelier c2 = new Chandelier("French",1200, 220, Lighting.TypeLight.Led,12);
        Chandelier c3 = new Chandelier("Russian ",1400, 220, Lighting.TypeLight.Bulb_roll,12);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        List<Chandelier> temp = new ArrayList<>();
        temp.add(c1);
        temp.add(c2);
        temp.add(c3);
        assertTrue(list.removeAll(temp));

    }

    @Test
    public void clear() {
        Chandelier c1 = new Chandelier("Viennese",1000, 220, Lighting.TypeLight.Bulb_roll,12);
        Chandelier c2 = new Chandelier("French",1200, 220, Lighting.TypeLight.Led,12);
        Chandelier c3 = new Chandelier("Russian ",1400, 220, Lighting.TypeLight.Bulb_roll,12);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.clear();
        assertEquals(0,list.size());
    }

    @Test
    public void get() {
        Chandelier c1 = new Chandelier("Viennese",1000, 220, Lighting.TypeLight.Bulb_roll,12);
        Chandelier c2 = new Chandelier("French",1200, 220, Lighting.TypeLight.Led,12);
        Chandelier c3 = new Chandelier("Russian ",1400, 220, Lighting.TypeLight.Bulb_roll,12);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        assertEquals(c2,list.get(1));
    }


}