package project.ListForProd;

import project.entities.Chandelier;

import java.util.*;
import java.util.List;

public class ChandelierList implements List<Chandelier> {
    private Chandelier[] mass;
    private int count;

    public enum TypeOfFilter{
        PRICE,
        POWER,
        NUM_LUMPS
    }

    {
        mass = new Chandelier[10];
        count = 0;
    }

    public ChandelierList() {
    }

    public ChandelierList(Chandelier[] mass) {
        this.mass = mass;
    }


    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (indexOf(o) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public CustomIterator<Chandelier> iterator() {

        Chandelier[] temp = new Chandelier[count];
        System.arraycopy(mass, 0, temp, 0, count);

        CustomIterator<Chandelier> it = new CustomIterator<Chandelier>() {

            Chandelier[] itMass = temp;
            private int current = 0;

            @Override
            public boolean hasNext() {
                if (current != itMass.length) {
                    return true;
                }
                return false;
            }

            @Override
            public Chandelier next() {
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException("End of list.");
                }
                current++;
                return itMass[current - 1];
            }
            @Override
            public void filter(TypeOfFilter type,int min, int max){
                switch(type){
                    case PRICE:
                        itMass = Arrays.stream(temp)
                                .filter(c->c.getPrice()>=min && c.getPrice()<=max)
                                .toArray(Chandelier[]::new);
                        break;
                    case POWER:
                        itMass = Arrays.stream(temp)
                                .filter(c->c.getPower()>=min && c.getPower()<=max)
                                .toArray(Chandelier[]::new);
                        break;
                    case NUM_LUMPS:
                        itMass = Arrays.stream(temp)
                                .filter(c->c.getNumLampHolders()>=min && c.getNumLampHolders()<=max)
                                .toArray(Chandelier[]::new);
                        break;
                }
            }
        };

        return it;
    }



    @Override
    public Object[] toArray() {
        Object[] objects = new Object[count];
        System.arraycopy(mass, 0, objects, 0, count);
        return objects;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(mass, count, a.getClass());
    }

    @Override
    public boolean add(Chandelier chandelier) {
        if (count + 1 != mass.length) {
            mass[count] = chandelier;
            count++;
            return true;
        } else if (count + 1 == mass.length) {
            Chandelier[] temp = new Chandelier[mass.length + 10];
            System.arraycopy(mass, 0, temp, 0, mass.length);
            mass = temp;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (indexOf(o) >= 0) {
            System.arraycopy(mass, indexOf(o) + 1, mass, indexOf(o), mass.length - (indexOf(o) + 1));
            count--;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Chandelier[] temp = c.toArray(new Chandelier[c.size()]);
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i].toString());
            if (contains(temp[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Chandelier> c) {
       /* Chandelier[] temp = c.toArray(new Chandelier[c.size()]);
        for(int i=0;i<temp.length;i++){
            if(!add(temp[i])){
                return false;
            }
        }*/
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Chandelier> c) {
        Chandelier[] array = c.toArray(new Chandelier[c.size()]);
        for (int i = 0; i < array.length; i++) {
            add(index, array[i]);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Chandelier[] array = c.toArray(new Chandelier[c.size()]);
        for (int i = 0; i < array.length; i++) {
            if (!remove(array[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        mass = new Chandelier[10];
        count = 0;
    }

    @Override
    public Chandelier get(int index) {
        if (index <= count) {
            return mass[index];
        }
        return mass[index];
    }

    @Override
    public Chandelier set(int index, Chandelier element) {
        if (index <= count) {
            mass[index] = element;
        }
        return null;
    }

    @Override
    public void add(int index, Chandelier element) {
        if (count <= mass.length - 1) {
            System.arraycopy(mass, index, mass, index + 1, count + 1 - index);
            mass[index] = element;
        }
    }

    @Override
    public Chandelier remove(int index) {

        Chandelier temp = get(index);
        if (index == 0) {
            clear();
            count = 0;
        } else if (index == count - 1) {
            mass[index] = null;
            count--;
        } else if (index > 0 && index < count - 1) {
            System.arraycopy(mass, index + 1, mass, index, count - index);
            count--;
        }
        return temp;
    }

    @Override
    public int indexOf(Object o) {

        if (o == null) {
            for (int i = 0; i < count; i++) {
                if (mass[i] == o) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i <= count; i++) {
                if (o.equals(mass[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int temp = -1;
        for (int i = 0; i <= count; i++) {
            if (o.equals(mass[i])) {
                temp = i;
            }
        }
        return temp;
    }

    @Override
    public ListIterator<Chandelier> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Chandelier> listIterator(int index) {
        return null;
    }

    @Override
    public List<Chandelier> subList(int fromIndex, int toIndex) {
        return null;
    }
}
