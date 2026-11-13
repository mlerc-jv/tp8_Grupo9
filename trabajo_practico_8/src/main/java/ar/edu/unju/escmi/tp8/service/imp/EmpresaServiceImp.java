package ar.edu.unju.escmi.tp8.service.imp;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import ar.edu.unju.escmi.tp8.model.Empresa;
import ar.edu.unju.escmi.tp8.service.IEmpresaService;
import ar.edu.unju.escmi.tp8.collections.CollectionEmpresa;

@Service
public class EmpresaServiceImp implements IEmpresaService {
	@Override
	public Empresa guardarEmpresa(Empresa empresa) {
		CollectionEmpresa.empresas.add(empresa);
		System.out.println("Empresa guardada: " +empresa);
		return empresa;
	}
	@Override
	public List<Empresa> obtenerEmpresas(){
		return CollectionEmpresa.empresas;
	}
	@Override
	public Empresa buscarEmpresaId(int id) {
		for (Empresa empresa:CollectionEmpresa.empresas) {
			if (empresa.getId()==id) {
				return empresa;
			}
		}
		return null;
	}
	@Override
	public Empresa modificarEmpresa(Empresa empresa) {
		for(Empresa emp: CollectionEmpresa.empresas) {
			if(emp.getId()==empresa.getId()) {
				emp.setNombre(empresa.getNombre());
				emp.setCantidadEmpleados(empresa.getCantidadEmpleados());
				emp.setTelefono(empresa.getTelefono());
				emp.setDireccion(empresa.getDireccion());
				System.out.println("Se modifico la empresa: "+emp);
					return emp;
			}
		}
		return null;
	}
	@Override
	public boolean eliminarEmpresa(int id) {
		Optional<Empresa> empresa = CollectionEmpresa.empresas.stream()
		    .filter(e-> e.getId()==id)
		    .findFirst();
		if(empresa.isPresent()) {
			CollectionEmpresa.empresas.remove(empresa.get());
			System.out.println("se elimino la empresa con ID: " +id);
			return true;
		}
		return false;
	}
}
