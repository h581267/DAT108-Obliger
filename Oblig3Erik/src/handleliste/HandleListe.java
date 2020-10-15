package handleliste;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class HandleListe {
	
    private List<String> items = new ArrayList<>();
    
    public HandleListe() {
    	this.items = new ArrayList<>();
    }
    
    public synchronized void addItem(String item) {
    	String s = item.replace(" ", "&nbsp;");
        items.add(s);
    }
    
    public List<String> getItems() {
        return items;
    }
    
    public synchronized void slettItem(String navn) {
    	items = items.stream().filter(s -> !s.equals(navn)).collect(Collectors.toList());
    }

	public void setItems(List<String> items) {
		this.items = items;
	}
	
	public synchronized boolean finnes(String navn) {		
		return (items.contains(navn)) ;	
	}
}
