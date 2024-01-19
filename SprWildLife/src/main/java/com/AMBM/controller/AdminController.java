package com.AMBM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AMBM.model.Especie;
import com.AMBM.model.Mascota;
import com.AMBM.model.Provincia;
import com.AMBM.repository.EspecieRepository;
import com.AMBM.repository.MascotaRepository;
import com.AMBM.repository.ProvinciaRepository;
import com.AMBM.service.CsvExportService;

@Controller
public class AdminController {

	@Autowired
	private MascotaRepository mascotaRepo;

	@Autowired
	private EspecieRepository especieRepo;

	@Autowired
	private ProvinciaRepository provinciaRepo;

	@RequestMapping("/administracion")
	public String cargarPrincipal(Model model) {

		List<Mascota> listaMascotas = mascotaRepo.findAll();
		List<Especie> listaEspecies = especieRepo.findAll();
		List<Provincia> listaProvincias = provinciaRepo.findAll();

		model.addAttribute("atr_lista_mascotas", listaMascotas);
		model.addAttribute("atr_lista_especies", listaEspecies);
		model.addAttribute("atr_lista_provincias", listaProvincias);
		model.addAttribute("objeto_entidad", new Mascota());

		return "administracion";
	}

	@RequestMapping("/guardarMascota")
	public String guardarMascota(@ModelAttribute Mascota objeto_entidad) {
		mascotaRepo.save(objeto_entidad);
		return "redirect:/administracion";
	}

	@RequestMapping("/borrarMascota/{id}")
	public String borrarMascota(@PathVariable Integer id) {
		mascotaRepo.deleteById(id);
		return "redirect:/administracion";
	}

	@GetMapping("/modificarMascota/{id}")
	public String mostrarFormularioModificar(@PathVariable Integer id, Model model) {
		Mascota mascota = mascotaRepo.findById(id).orElse(null);
		model.addAttribute("mascota", mascota);

		List<Especie> listaEspecies = especieRepo.findAll();
		List<Provincia> listaProvincias = provinciaRepo.findAll();
		model.addAttribute("atr_lista_especies", listaEspecies);
		model.addAttribute("atr_lista_provincias", listaProvincias);
		return "modificar";
	}

	@PostMapping("/modificarMascota")
	public String modificarMascota(@ModelAttribute Mascota mascota) {
		mascotaRepo.save(mascota);
		return "redirect:/administracion";
	}

	@Autowired
	private CsvExportService csvExportService;

	@GetMapping("/guardarCSV")
	public String guardarCSV() {
		csvExportService.exportDataToCsv();
		return "redirect:/administracion";
	}
	
	@GetMapping("/restaurarCSV")
    public String restaurarCSV() {
        csvExportService.importMascotasFromCsv(); 
        return "redirect:/administracion";
    }

}
