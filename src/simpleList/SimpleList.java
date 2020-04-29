package simpleList;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SimpleList<E> {
    private List<E> backingStore;

    public SimpleList() {
        this.backingStore = new ArrayList<E>();
    }

    public E add(E e) {
        if(backingStore.add(e)) return e;
        else return null;
    }

    public int size() {
        return backingStore.size();
    }
    public void clear() {
        backingStore.clear();
    }
}

class SimpleListTest {
    public void testAdd(){
        Logger log = Logger.getLogger(SimpleList.class.getName());
        SimpleList<BigDecimal> sl = new SimpleList<>();
        sl.add(BigDecimal.ONE);
        log.info("SimpleList size is: "+sl.size());
        sl.add(BigDecimal.ZERO);
        log.info("SimpleList size is: "+sl.size());
        sl.clear();
        log.info("SimpleList size is: "+sl.size());

    }
}