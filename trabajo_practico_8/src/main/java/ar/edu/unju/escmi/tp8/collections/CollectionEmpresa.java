package ar.edu.unju.escmi.tp8.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp8.model.Empresa;

public abstract class CollectionEmpresa {

    public static List<Empresa> empresas = new ArrayList<Empresa>();

    public static void precargarEmpresas() {
        if (empresas.isEmpty()) {
            empresas.add(new Empresa(1, "Ledesma", 250, "3884567890", "Libertador General San Martín"));
            empresas.add(new Empresa(2, "Arcor", 180, "3884123456", "San Salvador de Jujuy"));
            empresas.add(new Empresa(3, "Empresa Norte", 75, "3884987654", "Palpalá"));
        }
    }

}
