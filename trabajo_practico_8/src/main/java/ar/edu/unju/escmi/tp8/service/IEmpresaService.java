package ar.edu.unju.escmi.tp8.service;

import java.util.List;
import ar.edu.unju.escmi.tp8.model.Empresa;
public interface IEmpresaService {
	Empresa guardarEmpresa(Empresa empresa);
	List<Empresa> obtenerEmpresas();
	Empresa buscarEmpresaId(int id);
	Empresa modificarEmpresa(Empresa empresa);
	boolean eliminarEmpresa(int id);
}
