package com.terminal_tpv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.terminal_tpv.model.Producto;
import com.terminal_tpv.repository.ProductoRepository;

@Controller
public class AdminController {

	@Autowired
	private ProductoRepository prodRepo;

	@Value("${app.upload.dir}")
	private String uploadDir;

	@RequestMapping("/guardarProducto")
	public String guardarMascota(@ModelAttribute Producto objeto_entidad, @RequestParam("imagen") MultipartFile file) {

		if (!file.isEmpty()) {
			try {

				String fileName = StringUtils.cleanPath(file.getOriginalFilename());

				Path uploadPath = Paths.get(uploadDir);
				if (!Files.exists(uploadPath)) {
					Files.createDirectories(uploadPath);
				}

				try (InputStream inputStream = file.getInputStream()) {
					Files.copy(inputStream, uploadPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
				}

				objeto_entidad.setFoto(fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		prodRepo.save(objeto_entidad);
		return "redirect:/productos";
	}

	@RequestMapping("/modificarProducto/{id}")
	public String formularioModificarProducto(@PathVariable Integer id, Model model) {
		Producto prod = prodRepo.findById(id).orElse(null);

		model.addAttribute("producto", prod);

		return "modificar_prod";
	}

	@PostMapping("/modificarProducto")
	public String modificarProducto(@ModelAttribute Producto producto, @RequestParam("imagen") MultipartFile file) {

		if (!file.isEmpty() && !(file == null)) {
			try {

				String fileName = StringUtils.cleanPath(file.getOriginalFilename());

				Path uploadPath = Paths.get(uploadDir);
				if (!Files.exists(uploadPath)) {
					Files.createDirectories(uploadPath);
				}

				try (InputStream inputStream = file.getInputStream()) {
					Files.copy(inputStream, uploadPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
				}

				producto.setFoto(fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			String nombre_foto = prodRepo.obtenerNombreFoto(producto.getId());

			System.out.println("NOMBRE DE LA IMAGEN AAAAAAAAA: " + nombre_foto);

			producto.setFoto(nombre_foto);
		}

		prodRepo.save(producto);
		return "redirect:/productos";
	}

	@RequestMapping("/borrarProducto/{id}")
	public String borrarMascota(@PathVariable Integer id) {
		prodRepo.deleteById(id);
		return "redirect:/productos";
	}

}
