package com.escalab.service.impl;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escalab.dto.ConsultaListaExamenDTO;
import com.escalab.dto.ConsultaResumenDTO;
import com.escalab.dto.FiltroConsultaDTO;
import com.escalab.model.Consulta;
import com.escalab.repo.IConsultaExamenRepo;
import com.escalab.repo.IConsultaRepo;
import com.escalab.service.IConsultaService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ConsultaServiceImpl implements IConsultaService{

	@Autowired	
	private IConsultaRepo repo;
	
	@Autowired
	private IConsultaExamenRepo ceRepo;
	
	@Override
	public Consulta registrar(Consulta obj) {
		obj.getDetalleConsulta().forEach(det -> {
			det.setConsulta(obj);
		});
		return repo.save(obj);
	}
	
	@Transactional
	@Override
	public Consulta registrarTransaccional(ConsultaListaExamenDTO dto) {
		dto.getConsulta().getDetalleConsulta().forEach(det -> {
			det.setConsulta(dto.getConsulta());
		});
		repo.save(dto.getConsulta());
		
		dto.getLstExamen().forEach(ex -> ceRepo.registrar(dto.getConsulta().getIdConsulta(), ex.getIdExamen()));
		
		return dto.getConsulta();
		
	}

	@Override
	public Consulta modificar(Consulta obj) {		
		return repo.save(obj);
	}

	@Override
	public List<Consulta> listar() {
		return repo.findAll();
	}

	@Override
	public Consulta leerPorId(Integer id) {
		Optional<Consulta> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Consulta();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}

	@Override
	public List<Consulta> buscar(FiltroConsultaDTO filtro) {		
		return repo.buscar(filtro.getDni(), filtro.getNombreCompleto());
	}


	@Override
	public List<Consulta> buscarFecha(FiltroConsultaDTO filtro) {
		LocalDateTime fechaSgte = filtro.getFechaConsulta().plusDays(1);
		return repo.buscarFecha(filtro.getFechaConsulta(), fechaSgte);
	}

	@Override
	public List<ConsultaResumenDTO> listarResumen() {
		List<ConsultaResumenDTO> consultas = new ArrayList<>();
		
		repo.listarResumen().forEach(x -> {
			ConsultaResumenDTO cr = new ConsultaResumenDTO();
			cr.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			cr.setFecha(String.valueOf(x[1]));
			consultas.add(cr);
		});
		return consultas;
	}

	@Override
	public byte[] generarReporte() {
		byte[] data = null;
		
		try {
			File file = new ClassPathResource("/reports/consultas.jasper").getFile();
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(this.listarResumen()));
			data = JasperExportManager.exportReportToPdf(print);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;	
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


