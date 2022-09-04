package modelo.entidades;

import java.util.Comparator;

public class ComparatorMensaje implements Comparator<Mensaje>{

	@Override
	public int compare(Mensaje m1, Mensaje m2) {
		int resultadoComparacion;
        if (m1.getIdMensaje() > m2.getIdMensaje()) {
            resultadoComparacion = 1;
        } else {
            if (m1.getIdMensaje() == m2.getIdMensaje()) {
                resultadoComparacion = 0;
            } else {
                resultadoComparacion = -1;
            }
        }
        return resultadoComparacion;
	}
}
