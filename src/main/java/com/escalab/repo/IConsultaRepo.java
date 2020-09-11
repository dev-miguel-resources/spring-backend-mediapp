package com.escalab.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.escalab.model.Consulta;

//@Repository
public interface IConsultaRepo extends JpaRepository<Consulta, Integer>{
		
	@Query("from Consulta c where c.paciente.dni =:dni or LOWER(c.paciente.nombres) like %:nombreCompleto% or LOWER(c.paciente.apellidos) like %:nombreCompleto%")
	List<Consulta> buscar(@Param("dni")String dni,@Param("nombreCompleto") String nombreCompleto);

	// >= <
	@Query("from Consulta c where c.fecha between :fechaConsulta and :fechaSgte")
	List<Consulta> buscarFecha(@Param("fechaConsulta") LocalDateTime fechaConsulta, @Param("fechaSgte") LocalDateTime fechaSgte);
	
	@Query(value = "select * from fn_listarResumen()", nativeQuery = true)
	List<Object[]> listarResumen();

	//cantidad		fecha
	//[4		,	11/09/2020]
	//[1		, 	18/09/2020]
}
