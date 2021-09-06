package es.domingojunta.tools;

import java.util.Comparator;

import es.domingojunta.entities.*;

public class ComparatorOrdenarFicherosEntityPorId implements Comparator<FicheroEntity>{

	@Override
	public int compare(FicheroEntity o1, FicheroEntity o2) {
		
		return o1.getId() - o2.getId();
	}

}
